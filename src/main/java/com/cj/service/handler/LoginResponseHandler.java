package com.cj.service.handler;

import com.cj.service.oneNetty.LoginUtil;
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
 * @date : 2019-06-14 11:56
 * @describe :
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) {
//        // 创建登录对象
//        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
//        loginRequestPacket.setUserId(UUID.randomUUID().toString());
//        loginRequestPacket.setUsername("flash");
//        loginRequestPacket.setPassword("pwd");
//        // 写数据
//        ctx.channel().writeAndFlush(loginRequestPacket);
//    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) {
        String userId = loginResponsePacket.getUserId();
        String userName = loginResponsePacket.getUsername();
        if (loginResponsePacket.getSuccess()) {
            System.out.println(new Date() + ": 客户端登录成功");
            SessionUtil.bindSession(new Session(userId, userName), ctx.channel());
        } else {
            System.out.println(new Date() + ": 客户端登录失败，原因：" + loginResponsePacket.getReason());
        }
    }
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        System.out.println("客户端连接被关闭!");
    }

}
