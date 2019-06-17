package com.cj.service.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

import java.nio.charset.Charset;
import java.time.LocalDateTime;

/**
 * @author : chenjie
 * @date : 2019-06-13 15:53
 * @describe :
 */
public class FirstServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(LocalDateTime.now() + ": 服务端读到数据 -> " + byteBuf.toString(Charset.forName("utf-8")));
    }
    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        byte[] bytes = "sun!".getBytes(Charset.forName("utf-8"));

        ByteBuf buffer = ctx.alloc().buffer();

        buffer.writeBytes(bytes);

        return buffer;
    }
}
