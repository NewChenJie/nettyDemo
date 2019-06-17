package com.cj.service.packet;

import com.cj.service.config.Command;
import com.cj.service.config.Packet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : chenjie
 * @date : 2019-06-13 18:12
 * @describe :
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequestPacket extends Packet {

    private String toUserId;
    private String message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST.getId();
    }
}
