package com.cj.service.handler;

import com.cj.service.config.Packet;
import com.cj.service.config.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author : chenjie
 * @date : 2019-06-14 10:53
 * @describe :
 */
public class PacketDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        out.add(PacketCodeC.INSTANCE().decode(in));
    }
}
