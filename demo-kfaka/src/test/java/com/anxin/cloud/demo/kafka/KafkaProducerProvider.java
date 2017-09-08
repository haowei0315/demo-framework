package com.anxin.cloud.demo.kafka;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.kafka.listener.config.ContainerProperties;

import com.anxin.cloud.demo.kafka.task.ProducerTast;

public class KafkaProducerProvider {
	
	private static final Log log = LogFactory.getLog(KafkaProducerProvider.class);

	public static void main(String[] args) {
		try {
			//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:kafka-consumer.xml");
			String[] resource = new String[]{"classpath:applicationContext.xml", "classpath:spring-kafka-producer.xml"};
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(resource);
			context.start();
			ProducerTast bean = context.getBean(ProducerTast.class);
			System.err.println(bean);
			//ContainerProperties bean = context.getBean(ContainerProperties.class);
		//	System.err.println(bean);
		//	System.err.println(StringUtils.join(bean.getTopics()));
		} catch (Exception e) {
			log.error("== KafkaProducerProvider context start error:",e);
			e.printStackTrace();
		}
		synchronized (KafkaProducerProvider.class) {
			while (true) {
				try {
					KafkaProducerProvider.class.wait();
				} catch (InterruptedException e) {
					log.error("== synchronized error:",e);
				}
			}
		}
	}
    
}