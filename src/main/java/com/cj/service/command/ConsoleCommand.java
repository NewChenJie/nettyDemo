package com.cj.service.command;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author : chenjie
 * @date : 2019-06-14 15:39
 * @describe :
 */
public interface ConsoleCommand {
    void exec(Scanner scanner, Channel channel);
}
