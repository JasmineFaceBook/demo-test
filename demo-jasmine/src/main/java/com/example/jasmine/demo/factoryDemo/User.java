package com.example.jasmine.demo.factoryDemo;

/**
 * @program: demo-jasmine
 * @description: ${description}
 * @author: libingyao
 * @create: 2019-06-12 16:14
 **/
public class User  implements Observer{
    private String name;
    private String message;
    public User(String name) {
        this.name = name;
    }
    @Override
    public void update(String message) {
        this.message = message;
        read();
    }
    private void read() {
        System.out.println(this.name + "收到新消息：" + this.message);
    }
}
