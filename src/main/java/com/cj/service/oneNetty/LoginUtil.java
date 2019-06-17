package com.cj.service.oneNetty;

import com.cj.service.config.Attributes;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

/**
 * @author : chenjie
 * @date : 2019-06-14 9:21
 * @describe :
 */
public class LoginUtil {
    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);

        return loginAttr.get() != null;
    }
}
