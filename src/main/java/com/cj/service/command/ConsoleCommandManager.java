package com.cj.service.command;

import com.cj.service.command.ConsoleCommand;
import com.cj.service.command.SendToUserConsoleCommand;
import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author : chenjie
 * @date : 2019-06-14 15:40
 * @describe :
 */
public class ConsoleCommandManager implements ConsoleCommand {
    private Map<String, ConsoleCommand> consoleCommandMap;

    public ConsoleCommandManager() {
        consoleCommandMap = new HashMap<>();
        consoleCommandMap.put("sendToUser", new SendToUserConsoleCommand());
        consoleCommandMap.put("logout", new LogoutConsoleCommand());
        consoleCommandMap.put("createGroup", new CreateGroupConsoleCommand());
    }

    @Override
    public void exec(Scanner scanner, Channel channel) {
        //  获取第一个指令
        String command = scanner.next();

        ConsoleCommand consoleCommand = consoleCommandMap.get(command);

        if (consoleCommand != null) {
            consoleCommand.exec(scanner, channel);
        } else {
            System.err.println("无法识别[" + command + "]指令，请重新输入!");
        }
    }
}
