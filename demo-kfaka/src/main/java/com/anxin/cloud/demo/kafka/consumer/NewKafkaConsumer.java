package com.anxin.cloud.demo.kafka.consumer;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewKafkaConsumer {

	private static final Logger logger = LoggerFactory.getLogger(NewKafkaConsumer.class);

	public void processMessage(Map<String, Map<Integer, Object>> msgs) {
		logger.info("================================processMessage===============");
		Set<Entry<String, Map<Integer, Object>>> entrySet = msgs.entrySet();
		for (Entry<String, Map<Integer, Object>> entry : entrySet) {
			logger.info("============Topic:" + entry.getKey());
			System.err.println("============Topic:" + entry.getKey());
			Map<Integer, Object> messages = entry.getValue();
			Set<Integer> keys = messages.keySet();
			for (Integer i : keys) {
				logger.info("======Partition:" + i);
				System.err.println("======Partition:" + i);
			}
			Collection<Object> values = messages.values();
			for (Iterator<Object> iterator = values.iterator(); iterator.hasNext();) {
				Object object = iterator.next();
				String message = "[" + object.toString() + "]";
				logger.info("=====message:" + message);
				System.err.println("=====message:" + message);
			}
		}

	}
}
