package com.example.demo.Generic;

import lombok.Data;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/3/27
 * @time 23:52
 */
@Data
public class Demo<T> {

    private Boolean success;

    private T data;

    public Demo<T> success(T data) {
        Demo<T> objectDemo = new Demo<>();
        objectDemo.setSuccess(true);
        objectDemo.setData(data);
        return objectDemo;
    }

    public static <T> Demo<T> getSuccessDemo(T data) {
        Demo<T> objectDemo = new Demo<>();
        objectDemo.setSuccess(true);
        objectDemo.setData(data);
        return objectDemo;
    }
}
