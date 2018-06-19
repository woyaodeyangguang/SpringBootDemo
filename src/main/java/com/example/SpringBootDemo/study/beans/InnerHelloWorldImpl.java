package com.example.SpringBootDemo.study.beans;

public class InnerHelloWorldImpl implements HelloWorld {
    @Override
    public void sayHello() {
        System.out.println("Inner Hello World!");
    }

    public InnerHelloWorldImpl() {
        System.out.println("--------------Inner Hello World constructor!---------------");
    }
}