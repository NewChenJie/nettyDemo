package com.cj.service.config;

import com.alibaba.fastjson.JSON;

/**
 * @author : chenjie
 * @date : 2019-06-13 16:59
 * @describe :
 */
public class JSONSerializer implements Serializer {
    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {

        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {

        return JSON.parseObject(bytes, clazz);
    }
}
