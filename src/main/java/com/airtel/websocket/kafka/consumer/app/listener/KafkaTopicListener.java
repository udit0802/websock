package com.airtel.websocket.kafka.consumer.app.listener;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.airtel.websocket.kafka.consumer.app.utils.UserLocationMap;
import com.airtel.websocket.kafka.consumer.app.vo.Location;
import com.airtel.websocket.kafka.consumer.app.vo.TrackingRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class KafkaTopicListener {

	private static final Logger logger = LoggerFactory.getLogger(KafkaTopicListener.class);

	@Value("${kafka.consumer.topic}")
	private String topic;
	
	@Autowired
	private ObjectMapper objectMapper;

	@PostConstruct
	public void init() {
		logger.debug("KafkaTopicListener created for Topic " + topic);
	}

	@KafkaListener(topics = "tracking_main", containerFactory = "kafkaListenerContainerFactory")
	public void consume(@Payload String object,@Headers MessageHeaders headers,
			ConsumerRecord<String, Object> data, Acknowledgment acknowledgment){
		try{
			TrackingRequest obj = objectMapper.convertValue(object, TrackingRequest.class);
			UserLocationMap.insertIfNotExist(obj.getUserId(), new Location(obj.getLatitude(),obj.getLongitude()));
		}catch(Exception e){
			e.printStackTrace();
			acknowledgment.acknowledge();
		}
		

	}

}