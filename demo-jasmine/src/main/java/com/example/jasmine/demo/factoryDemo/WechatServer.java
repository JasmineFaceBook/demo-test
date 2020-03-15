package com.example.jasmine.demo.factoryDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo-jasmine
 * @description: ${description}
 * @author: libingyao
 * @create: 2019-06-12 16:09
 **/
public class WechatServer implements Observerable{
    private List<Observer> list;
    private String message;
    public WechatServer() {
        list = new ArrayList<>();
    }
    @Override
    public void addObserver(Observer observer) {
        this.list.add(observer);
    }
    @Override
    public void deleteObserver(Observer observer) {
        if (!this.list.isEmpty()){
            list.remove(observer);
        }
    }
    @Override
    public void notifyObserver() {
        for(Observer observer : list){
            observer.update(this.message);
        }
    }
    public void setInformation(String s){
        this.message = s;
        System.out.println("发布新消息：" + s);
        notifyObserver();
    }
}
