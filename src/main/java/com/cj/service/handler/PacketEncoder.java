package com.cj.service.handler;

import com.cj.service.config.Packet;
import com.cj.service.config.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author : chenjie
 * @date : 2019-06-14 11:13
 * @describe :
 */
public class PacketEncoder extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out){
        PacketCodeC.INSTANCE().encode(out, packet);
    }
}
