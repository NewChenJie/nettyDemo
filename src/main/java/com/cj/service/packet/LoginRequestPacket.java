package com.cj.service.packet;

import com.cj.service.config.Command;
import com.cj.service.config.Packet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : chenjie
 * @date : 2019-06-13 16:53
 * @describe :
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestPacket extends Packet {

    private String userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST.getId();
    }
}
