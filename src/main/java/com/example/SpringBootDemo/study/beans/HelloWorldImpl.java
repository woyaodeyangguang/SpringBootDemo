package com.example.SpringBootDemo.study.beans;

public class HelloWorldImpl implements HelloWorld{

    private HelloWorld innerHelloWorld;

    private String name;

    @Override
    public void sayHello() {
        System.out.println("Hello World, " + name);
        innerHelloWorld.sayHello();
    }

    public HelloWorldImpl(HelloWorld innerHelloWorld) {
        this.innerHelloWorld = innerHelloWorld;
    }

    public void setName(String name) {
        this.name = name;
    }
}
