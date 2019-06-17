package com.cj.service.packet;

import com.cj.service.config.Command;
import com.cj.service.config.Packet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : chenjie
 * @date : 2019-06-13 17:52
 * @describe :
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponsePacket extends Packet {
    private String reason;
    private Boolean success;
    private String userId;
    private String username;
    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE.getId();
    }
}
