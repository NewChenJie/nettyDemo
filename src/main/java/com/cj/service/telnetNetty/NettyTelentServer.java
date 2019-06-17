package com.cj.service.telnetNetty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : chenjie
 * @date : 2019-06-10 14:32
 * @describe :
 */
@Slf4j
public class NettyTelentServer {
    private static final int PORT = 8888;
    private ServerBootstrap serverBootstrap;

    private EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    private EventLoopGroup workerGroup = new NioEventLoopGroup();

    public void open() throws InterruptedException {

        serverBootstrap = new ServerBootstrap();
        // 指定socket的一些属性
        serverBootstrap.option(ChannelOption.SO_BACKLOG, 1024);
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new NettyTelnetInitializer());

        // 绑定对应的端口号,并启动开始监听端口上的连接
        Channel ch = serverBootstrap.bind(PORT).sync().channel();
        // 等待关闭,同步端口
        ch.closeFuture().sync();
    }
    public void close(){
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }

    public static void main(String[] args) {
        NettyTelentServer nettyTelnetServer = new NettyTelentServer();
        try {
            nettyTelnetServer.open();
        } catch (InterruptedException e) {
            nettyTelnetServer.close();
        }
    }
}
