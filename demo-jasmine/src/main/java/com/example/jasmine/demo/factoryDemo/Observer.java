package com.example.jasmine.demo.factoryDemo;

/**
 * @program: demo-jasmine
 * @description: 抽象观察者接口
 * @author: libingyao
 * @create: 2019-06-12 16:12
 **/
public interface Observer {
    void update(String message);    //接收到通知进行更新
}
