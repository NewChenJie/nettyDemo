package com.cj.service.handler;

import com.cj.service.oneNetty.Session;
import com.cj.service.oneNetty.SessionUtil;
import com.cj.service.packet.LoginRequestPacket;
import com.cj.service.packet.LoginResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;
import java.util.UUID;

/**
 * @author : chenjie
 * @date : 2019-06-14 11:12
 * @describe :
 */
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket packet) {
        System.out.println("--------登录时打印--------");
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(packet.getVersion());
        loginResponsePacket.setUsername(packet.getUsername());

        if (valid(packet)) {
            loginResponsePacket.setSuccess(true);
            String userId = randomUserId();
            loginResponsePacket.setUserId(userId);
            System.out.println("[" + packet.getUsername() + "]登录成功");
            SessionUtil.bindSession(new Session(userId, packet.getUsername()), ctx.channel());
        } else {
            loginResponsePacket.setReason("账号密码校验失败");
            loginResponsePacket.setSuccess(false);
            System.out.println(new Date() + ": 登录失败!");
        }

        // 登录响应
        ctx.channel().writeAndFlush(loginResponsePacket);
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }

    private static String randomUserId() {
        return UUID.randomUUID().toString().split("-")[0];
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        SessionUtil.unBindSession(ctx.channel());
    }

}
