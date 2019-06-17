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
 * @date : 2019-06-15 14:32
 * @describe :
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateGroupResponsePacket extends Packet {
    private Boolean success;
    private List<String> userNameList;
    private String groupId;

    @Override
    public Byte getCommand() {
        return Command.GROUP_RESPONSE.getId();
    }
}
