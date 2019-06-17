package com.cj.service.handler;

import com.cj.service.oneNetty.Session;
import com.cj.service.oneNetty.SessionUtil;
import com.cj.service.packet.LoginRequestPacket;
import com.cj.service.packet.MessageRequestPacket;
import com.cj.service.packet.MessageResponsePacket;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * @author : chenjie
 * @date : 2019-06-14 11:21
 * @describe :
 */
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket messageRequestPacket) {
        System.out.println(new Date() + ": 收到客户端消息: " + messageRequestPacket.getMessage());
        // 1.拿到消息发送方的会话信息
        Session session = SessionUtil.getSession(ctx.channel());
        // 2.通过消息发送方的会话信息构造要发送的消息
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setFromUserId(session.getUserId());
        messageResponsePacket.setFromUserName(session.getUserName());
        messageResponsePacket.setMessage("服务端回复【" + messageRequestPacket.getMessage() + "】");
        // 3.拿到消息接收方的 channel
        Channel toUserChannel = SessionUtil.getChannel(messageRequestPacket.getToUserId());
        // 4.将消息发送给消息接收方
        if (toUserChannel != null && SessionUtil.hasLogin(toUserChannel)) {
            toUserChannel.writeAndFlush(messageResponsePacket);
        } else {
            System.err.println("[" + messageRequestPacket.getToUserId() + "] 不在线，发送失败!");
        }
    }
}
