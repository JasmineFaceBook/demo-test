package com.example.jasmine.demo.factoryDemo;

import com.example.jasmine.demo.factoryDemo.Observer;
/**
 * @program: demo-jasmine
 * @description: 被观察者接口
 * @author: libingyao
 * @create: 2019-06-12 16:08
 **/
public interface Observerable {
    void addObserver(Observer observer);        //新增一个观察者
    void deleteObserver(Observer observer);     //移除一个观察者
    void notifyObserver();      //通知观察者
}