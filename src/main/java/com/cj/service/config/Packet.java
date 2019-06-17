package com.cj.service.config;

import lombok.Data;

/**
 * @author : chenjie
 * @date : 2019-06-13 16:50
 * @describe :
 */
@Data
public abstract class Packet {
    /**
     * 协议版本
     */
    private Byte version = 1;

    /** 指令 **/
    public abstract Byte getCommand();
 }
