package com.cj.service.handler;

import com.cj.service.packet.LoginRequestPacket;
import com.cj.service.packet.LoginResponsePacket;
import com.cj.service.config.Packet;
import com.cj.service.config.PacketCodeC;
import com.cj.service.packet.MessageRequestPacket;
import com.cj.service.packet.MessageResponsePacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @author : chenjie
 * @date : 2019-06-13 17:36
 * @describe :
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    LoginResponsePacket loginResponsePacket = new LoginResponsePacket();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf requestByteBuf = (ByteBuf) msg;
        // 解码
        Packet packet = PacketCodeC.INSTANCE().decode(requestByteBuf);
        // 判断是否是登录请求数据包
        if (packet instanceof LoginRequestPacket) {
            LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;
            // 登录校验
            if (valid(loginRequestPacket)) {
                // 校验成功
                System.out.println("登录成功");
                loginResponsePacket.setSuccess(true);
            } else {
                // 校验失败
                System.out.println("登录失败");
                loginResponsePacket.setReason("账号密码校验失败");
                loginResponsePacket.setSuccess(false);
            }
            // 编码
            ctx.channel().writeAndFlush(loginResponsePacket);
        } else if (packet instanceof MessageRequestPacket) {
            // 处理消息
            MessageRequestPacket messageRequestPacket = ((MessageRequestPacket) packet);
            System.out.println(new Date() + ": 收到客户端消息: " + messageRequestPacket.getMessage());

            MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
            messageResponsePacket.setMessage("服务端回复【" + messageRequestPacket.getMessage() + "】");
            ctx.channel().writeAndFlush(messageResponsePacket);
        }
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
            return true;
    }
}
