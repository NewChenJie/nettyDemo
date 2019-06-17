package com.cj.service.oneNetty;

import com.cj.service.handler.CreateGroupRequestHandler;
import com.cj.service.handler.LoginRequestHandler;
import com.cj.service.handler.PacketDecoder;
import com.cj.service.handler.PacketEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author : chenjie
 * @date : 2019-06-13 14:46
 * @describe :
 */
public class NettyServer {
    public static void main(String[] args) {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new PacketDecoder())
                                .addLast(new LoginRequestHandler())
                                .addLast(new CreateGroupRequestHandler())
//                        .addLast(new MessageRequestHandler())
                                .addLast(new PacketEncoder());
                    }
                });
        bootstrap.bind(7800);
    }


}
