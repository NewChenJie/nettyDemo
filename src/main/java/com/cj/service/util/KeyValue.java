package com.cj.service.util;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 键值对处理类
 *
 * @since 2017/5/27
 */
public class KeyValue extends HashMap<String, Object> {
    public static final String STATUS = "status";
    public static final String MSG = "msg";
    public static final String DATA = "data";
    public static final ThreadLocal<String> cacheResult = ThreadLocal.withInitial(() -> null);
    private static final long serialVersionUID = 1L;

    private static KeyValue EMPTY = new KeyValue();

    /**
     * 分页数据
     *
     * @return {@link KeyValue}
     */
    public static KeyValue page(String pageNum, String pageSize) {
        return new KeyValue().add("pageNum", pageNum).add("pageSize", pageSize);
    }

    /**
     * 空数据
     *
     * @return {@link KeyValue}
     */
    public static KeyValue empty() {
        return (KeyValue) EMPTY.clone();
    }

    /**
     * 正确返回
     *
     * @return {@link KeyValue}
     */
    public static KeyValue ok() {
        return rd(HttpStatus.OK.value());
    }

    /**
     * 正确返回
     *
     * @param msg
     *         返回消息
     * @return {@link KeyValue}
     */
    public static KeyValue ok(String msg) {
        return rd(HttpStatus.OK.value(), msg);
    }

    /**
     * 正确返回
     *
     * @param data
     *         数据
     * @return {@link KeyValue}
     */
    public static KeyValue ok(Object data) {
        return rd(HttpStatus.OK.value(), data);
    }

    /**
     * 正确返回
     *
     * @param msg
     *         返回消息
     * @param data
     *         数据
     * @return {@link KeyValue}
     */
    public static KeyValue ok(String msg, Object data) {
        return rd(HttpStatus.OK.value(), msg, data);
    }

    /**
     * 拒绝访问
     *
     * @param msg
     *         提示消息
     * @return {@link KeyValue}
     */
    public static KeyValue bad_request(String msg) {
        return rd(HttpStatus.BAD_REQUEST.value(), msg);
    }

    /**
     * 拒绝访问
     *
     * @param msg
     *         提示消息
     * @param data
     *         错误数据
     * @return {@link KeyValue}
     */
    public static KeyValue bad_request(String msg, Object data) {
        return rd(HttpStatus.BAD_REQUEST.value(), msg, data);
    }

    /**
     * 拒绝访问
     *
     * @param msg
     *         提示消息
     * @return {@link KeyValue}
     */
    public static KeyValue forbidden(String msg) {
        return rd(HttpStatus.FORBIDDEN.value(), msg);
    }

    /**
     * 拒绝访问
     *
     * @param msg
     *         提示消息
     * @param data
     *         错误数据
     * @return {@link KeyValue}
     */
    public static KeyValue forbidden(String msg, Object data) {
        return rd(HttpStatus.FORBIDDEN.value(), msg, data);
    }

    /**
     * 数据返回
     *
     * @param status
     *         状态
     * @return {@link KeyValue}
     */
    public static KeyValue rd(int status) {
        return new KeyValue(STATUS, status);
    }

    /**
     * 结果返回
     *
     * @param result
     *         判断结果
     * @param success
     *         成功提示
     * @param error
     *         失败提示
     * @return {@link KeyValue}
     */
    public static KeyValue result(boolean result, String success, String error) {
        return result ? ok(success) : forbidden(error);
    }

    /**
     * 数据返回
     *
     * @param msg
     *         返回消息
     * @return {@link KeyValue}
     */
    public static KeyValue rd(int status, String msg) {
        WebKit.getResponse().setStatus(status);
        return new KeyValue(STATUS, status).add(MSG, msg);
    }

    /**
     * 数据返回
     *
     * @param status
     *         状态
     * @param data
     *         数据
     * @return {@link KeyValue}
     */
    public static KeyValue rd(int status, Object data) {
        WebKit.getResponse().setStatus(status);
        return new KeyValue(STATUS, status).add(DATA, data);
    }

    /**
     * 数据返回
     *
     * @param msg
     *         返回消息
     * @param data
     *         数据
     * @return {@link KeyValue}
     */
    public static KeyValue rd(int status, String msg, Object data) {
        WebKit.getResponse().setStatus(status);
        return new KeyValue(STATUS, status).add(MSG, msg).add(DATA, data);
    }

    public KeyValue() {
    }

    public KeyValue(String key, Object value) {
        put(key, value);
    }

    public KeyValue add(String key, Object value) {
        put(key, value);
        return this;
    }

    public KeyValue addExtraData(Map<? extends String, ?> map) {
        getData().putAll(map);
        return this;
    }

    public KeyValue addExtraData(String key, Object value) {
        getData().put(key, value);
        return this;
    }

    public KeyValue del(String key) {
        remove(key);
        return this;
    }

    public <T> T getAttr(String key) {
        return (T) get(key);
    }



    public String getMsg() {
        return getAttr(MSG);
    }

    public KeyValue getData() {
        return Optional.ofNullable((KeyValue) getAttr(DATA)).orElseGet(() -> add(DATA, new KeyValue()).getAttr(DATA));
    }

    public <T extends Map> T toMap() {
        return (T) this;
    }

    public <T extends MultiValueMap> T toMultiValueMap() {
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        forEach((s, o) -> {
            LinkedList<Object> list = new LinkedList<>();
            list.add(o);
            map.put(s, list);
        });
        return (T) map;
    }

    public void write(HttpServletResponse response) throws IOException {
        // 设置编码 防止乱码
        response.setHeader("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        cacheResult.set(toJson());
        response.getOutputStream().write(cacheResult.get().getBytes(StandardCharsets.UTF_8));
    }

    public KeyValue cache() {
        cacheResult.set(toJson());
        return this;
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }

    @Override
    public String toString() {
        return toJson();
    }
}
