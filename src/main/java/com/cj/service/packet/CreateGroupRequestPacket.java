package com.cj.service.packet;

import com.cj.service.config.Command;
import com.cj.service.config.Packet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : chenjie
 * @date : 2019-06-14 15:47
 * @describe :
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateGroupRequestPacket extends Packet {
    private List<String> userIdList;
    @Override
    public Byte getCommand() {
        return Command.GROUP_REQUEST.getId();
    }
}
