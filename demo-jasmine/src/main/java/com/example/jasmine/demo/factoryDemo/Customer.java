package com.example.jasmine.demo.factoryDemo;

/**
 * @program: demo-jasmine
 * @description: ${description}
 * @author: libingyao
 * @create: 2019-06-12 16:27
 **/
public class Customer implements Observer {
    private String name;
    private String message;
    public Customer(String name) {
        this.name = name;
    }
    @Override
    public void update(String message) {
        this.message = message;
        read();
    }
    private void read() {
        System.out.println(this.name + "客户收到新消息：" + this.message);
    }
}
