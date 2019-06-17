package com.cj.service.config;

import com.cj.service.oneNetty.Session;
import io.netty.util.AttributeKey;

/**
 * @author : chenjie
 * @date : 2019-06-14 9:19
 * @describe :
 */
public interface Attributes {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
