package com.airtel.websocket.kafka.consumer.app.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.airtel.websocket.kafka.consumer.app.config.KafkaProducer;
import com.airtel.websocket.kafka.consumer.app.entity.UserEntity;
import com.airtel.websocket.kafka.consumer.app.vo.TrackingRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ProduceData {

//	@Value("${topic.producer.topic}")
	private String topicName="tracking_main";
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	public String send() {
		TrackingRequest req = new TrackingRequest();
		req.setLatitude("123");
		req.setLongitude("456");
		req.setTravelId("Travel");
		req.setToken("fsf");
		req.setPk("pk");
		req.setDis(2.0f);
		req.setTimestamp(System.currentTimeMillis());
		UserEntity u = new UserEntity();
		u.setUserId(456L);
		req.setUserEntity(u);
		kafkaProducer.send(topicName, req.toString());
		return "success";
	}
}
