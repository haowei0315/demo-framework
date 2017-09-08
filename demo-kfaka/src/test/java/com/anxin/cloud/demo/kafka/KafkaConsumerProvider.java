package com.anxin.cloud.demo.kafka;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.kafka.listener.config.ContainerProperties;

public class KafkaConsumerProvider {
	
	private static final Log log = LogFactory.getLog(KafkaConsumerProvider.class);

	public static void main(String[] args) {
		try {
			//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:kafka-consumer.xml");
			//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-kafka-consumer.xml");
			String[] resource = new String[]{"classpath:spring-kafka-consumer.xml"};
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(resource);
			context.start();
			//ContainerProperties bean = context.getBean(ContainerProperties.class);
		//	System.err.println(bean);
		//	System.err.println(StringUtils.join(bean.getTopics()));
		} catch (Exception e) {
			log.error("== KafkaConsumerProvider context start error:",e);
		}
		synchronized (KafkaConsumerProvider.class) {
			while (true) {
				try {
					KafkaConsumerProvider.class.wait();
				} catch (InterruptedException e) {
					log.error("== synchronized error:",e);
				}
			}
		}
	}
    
}