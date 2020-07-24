package com.example.demo.polymorphism;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/4/12
 * @time 13:45
 */
public class Cat extends Animal {
    @Override
    void eat() {
        System.out.println("吃猫粮");
    }

    void work() {
        System.out.println("抓老鼠");
    }
}
