package com.anxin.cloud.demo.dubbo.consumer;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.FileCopyUtils;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath:applicationContext.xml",
		"classpath:applicationContext-dubbo-consumer.xml" })
public class DemoServiceDubboConsumerTest {
	   
    @Autowired  
    private PlanOrderService planOrderService;
      
    
    @Test  
    public void testQueryByRefCode() throws InterruptedException{  
    	planOrderService.queryByRefCode("A00000000");
    	 Thread.sleep(2 *1000);
        System.err.println("OK................");
    } 
    
    
    
    @Test  
    public void testUpload() throws IOException, InterruptedException{  
    	byte[] bytes = FileCopyUtils.copyToByteArray(new File("c://11.txt"));
    	planOrderService.upload(118L, bytes);
    	 Thread.sleep(20 *1000);
        System.err.println("OK................");
    } 
}
