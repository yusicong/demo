package com.example.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Create by idea
 *
 * @Author : yusicong
 * @Date : 2020/3/23 14:10
 * @FileName : ConCurrentHashMapDemo
 * @Description: ConcurrentHashMap
 */
@Slf4j
public class ConCurrentHashMapDemo {

    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (int i = 0; i < 999999; i++) {
            integerArrayList.add(i);
        }

        long startTime = System.currentTimeMillis();
        long sum = integerArrayList.stream().parallel().map(
                integer -> {
                    long rs;
                    log.info("{}", rs = integer + integer);
                    return rs;
                }
        ).reduce(0L, Long::sum);
        System.out.println(sum);
        log.info("运算结束，耗时：{}毫秒", System.currentTimeMillis() - startTime);
//        System.out.println(10 << 1);
//        System.out.println(10 >> 1);
//        System.out.println(10 >>> 1);
//        System.out.println(-10 >>> 1);
//        System.out.println(1 << 30);
    }
}
