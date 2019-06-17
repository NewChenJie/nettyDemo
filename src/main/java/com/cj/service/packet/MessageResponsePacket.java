package com.cj.service.packet;

import com.cj.service.config.Command;
import com.cj.service.config.Packet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : chenjie
 * @date : 2019-06-14 9:16
 * @describe :
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponsePacket extends Packet{
    private String message;
    private String fromUserId;
    private String fromUserName;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE.getId();
    }
}
