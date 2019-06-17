package com.cj.service.command;

import com.cj.service.packet.LoginRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author : chenjie
 * @date : 2019-06-15 14:24
 * @describe :
 */
public class LoginConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        System.out.print("输入用户名登录: ");
        String username = scanner.nextLine();
        loginRequestPacket.setUsername(username);
        // 密码使用默认的
        loginRequestPacket.setPassword("pwd");
        // 发送登录数据包
        channel.writeAndFlush(loginRequestPacket);
    }
}
