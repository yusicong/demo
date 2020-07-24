package com.example.demo.Generic;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/3/27
 * @time 23:41
 */
public class GenericDefinitionDemo {
    static <String, T, Alibaba> String get(String string, Alibaba alibaba) {
        return string;
    }

    public static void main(String[] args) {
        Integer first = 222;
        Long second = 333L;
        Integer result = get(first, second);
        String o1 = "";
        String o2 = "";
        o1+="123";
        o2+="123";
        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());
    }
}
