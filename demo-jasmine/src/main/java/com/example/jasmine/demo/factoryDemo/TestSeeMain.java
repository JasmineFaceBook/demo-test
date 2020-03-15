package com.example.jasmine.demo.factoryDemo;

/**
 * @program: demo-jasmine
 * @description: 观察者模式
 * @author: libingyao
 * @create: 2019-06-12 16:15
 **/
public class TestSeeMain {

    public static void main(String[] args) {
        WechatServer weixin = new WechatServer();
        User u1 = new User("张三");
        User u2 = new User("李四");
        User u3 = new User("王五");
        weixin.addObserver(u1);
        weixin.addObserver(u2);
        weixin.addObserver(u3);
       // weixin.setInformation("发布第一条消息");   //发布新消息：发布第一条消息 张三收到新消息：发布第一条消息 李四收到新消息：发布第一条消息 王五收到新消息：发布第一条消息

        weixin.deleteObserver(u2);
       // System.out.println("李四退出订阅");   //李四退出订阅
       // weixin.setInformation("发布第二条消息");   //发布新消息：发布第二条消息 张三收到新消息：发布第二条消息 王五收到新消息：发布第二条消息
        WechatServer weixin1 = new WechatServer();
        Customer c1 = new Customer("张三");
        Customer c2 = new Customer("李四");
        Customer c3 = new Customer("王五");

        weixin1.addObserver(c1);
        weixin1.addObserver(c2);
        weixin1.addObserver(c3);
        weixin1.setInformation("发布第一条消息");   //发布新消息：发布第一条消息 张三收到新消息：发布第一条消息 李四收到新消息：发布第一条消息 王五收到新消息：发布第一条消息

        weixin1.deleteObserver(c2);
        System.out.println("李四退出订阅");   //李四退出订阅
        weixin1.setInformation("发布第二条消息");   //发布新消息：发布第二条消息 张三收到新消息：发布第二条消息 王五收到新消息：发布第二条消息


        /**
         * 总结：
         * 观察者模式存在的意义：
         * 由于User中的通知信息内容需要发生改变，但是其他引用User的地方通知信息内容不需要改变，
         * 那么就从新写一个User实现接口的实现类Customer，将Customer中的通知信息改成最新的通知内容，
         * 那么User就不需要做任何修改了
         *
         **/
    }
}
