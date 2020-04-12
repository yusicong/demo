package com.example.demo.polymorphism;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/4/12
 * @time 13:46
 */
public class Test {
    public static void main(String[] args) {
        doWork(new Cat());
        doWork(new Dog());
        Animal animal = new Cat();
        animal.eat();
        Cat cat = (Cat) animal;
        cat.work();
    }

    private static void doWork(Animal animal) {
        animal.eat();
        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.work();
        } else if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.work();
        }
    }
}
