package com.jms.demo.springbootactiveMq.test;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jms.demo.springbootactiveMq.Producer;



@RunWith(SpringRunner.class)
@SpringBootTest    //表明这是一个springboot的测试类
public class activeMqTest {
  
	@Autowired
	Producer  producer;
	@Test
	public void  testActivemq()  throws InterruptedException{
		ActiveMQQueue activeMQQueue = new ActiveMQQueue("mytest.queue");   //设置目的地destination
		for(int i=0;i<1000;i++) {    
		  producer.sendMessage(activeMQQueue, "xxh 是一个好人");   
		}
	}
}
