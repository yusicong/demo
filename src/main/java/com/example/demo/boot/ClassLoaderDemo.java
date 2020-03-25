package com.example.demo.boot;

/**
 * Create by idea
 *
 * @Author : yusicong
 * @Date : 2020/3/20 10:54
 * @FileName : classLoader
 * @Description: 类加载机制
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(ClassLoaderDemo.class.getClassLoader());
    }
}
