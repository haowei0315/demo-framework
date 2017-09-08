package com.anxin.cloud.demo.kafka;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		//"classpath:applicationContext.xml",
		//"classpath:applicationContext-redis.xml", 
		"classpath:kafka-consumer.xml" })
public class KafkaConsumerTest {
	
	@Autowired
	private KafkaMessageListenerContainer messageListenerContainer;
    
      
    /** 
     * 向kafka里写数据.<br/>   
     * @author miaohongbin 
     * Date:2016年6月24日下午6:22:58 
     * @throws IOException 
     */  
    @Test  
    public void testTemplateSend() throws IOException{  
       System.in.read();
    }  
}
