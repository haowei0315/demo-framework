package com.anxin.cloud.demo.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		//"classpath:applicationContext.xml",
		//"classpath:applicationContext-redis.xml", 
		"classpath:kafka-producer.xml" })
public class KafkaTest {
	   
    @Autowired  
    private KafkaTemplate<Integer, String> kafkaTemplate;  
      
    /** 
     * 向kafka里写数据.<br/>   
     * @author miaohongbin 
     * Date:2016年6月24日下午6:22:58 
     */  
    @Test  
    public void testTemplateSend(){  
        kafkaTemplate.sendDefault("haha111");  
        System.err.println("OK................");
    }  
}
