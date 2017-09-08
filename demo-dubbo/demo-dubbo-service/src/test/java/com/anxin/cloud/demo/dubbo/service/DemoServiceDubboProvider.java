package com.anxin.cloud.demo.dubbo.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动Dubbo服务用的Main，仅用作调试用
 * 
 * @author zhu wei rong
 * @date 2016年11月3日
 *
 */
public class DemoServiceDubboProvider {
	
	private static final Log log = LogFactory.getLog(DemoServiceDubboProvider.class);

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
			context.start();
		} catch (Exception e) {
			log.error("== DubboProvider context start error:",e);
		}
		synchronized (DemoServiceDubboProvider.class) {
			while (true) {
				try {
					DemoServiceDubboProvider.class.wait();
				} catch (InterruptedException e) {
					log.error("== synchronized error:",e);
				}
			}
		}
	}
    
}