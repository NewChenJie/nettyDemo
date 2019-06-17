package com.cj.service.handler;

import com.cj.service.packet.CreateGroupResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author : chenjie
 * @date : 2019-06-15 14:37
 * @describe :
 */
public class CreateGroupResponseHandler extends SimpleChannelInboundHandler<CreateGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupResponsePacket packet) throws Exception {
        System.out.print("群创建成功，id 为[" + packet.getGroupId() + "], ");
        System.out.println("群里面有：" + packet.getUserNameList());
    }
}
