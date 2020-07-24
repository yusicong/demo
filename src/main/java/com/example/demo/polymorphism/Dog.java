package com.example.demo.polymorphism;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/4/12
 * @time 13:45
 */
public class Dog extends Animal {
    @Override
    void eat() {
        System.out.println("吃狗粮");
    }

    void work() {
        System.out.println("看家护院");
    }
}
