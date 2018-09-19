package com.jms.demo.springbootactiveMq;


import org.springframework.jms.annotation.JmsListener;

import org.springframework.stereotype.Service;

@Service   //或者@Component 都可以
public class Consumer {
     
     
     @JmsListener(destination="mytest.queue")   //使用JMSListener 监听在Producer的消息
     public void received(String message) {
    	 //打印接收到的信息
    	 System.out.println("customer接收到的信息为： " +message);
     }
}
