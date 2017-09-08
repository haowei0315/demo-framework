package com.anxin.cloud.demo.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

public class KafkaConsumer implements MessageListener<Integer, String> {

	@Override
	public void onMessage(ConsumerRecord<Integer, String> record) {
		System.out.println(record);
	}

}