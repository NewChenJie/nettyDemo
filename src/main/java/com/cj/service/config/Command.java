package com.cj.service.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author : chenjie
 * @date : 2019-06-13 18:13
 * @describe :
 */
public enum Command {
    LOGIN_REQUEST((byte)1),
    LOGIN_RESPONSE((byte)2),
    MESSAGE_REQUEST((byte)3),
    MESSAGE_RESPONSE((byte)4),
    GROUP_REQUEST((byte)5),
    GROUP_RESPONSE((byte)6);


    private Byte id;

    Command(Byte id) {
        this.id = id;
    }

    public Byte getId() {
        return id;
    }

}
