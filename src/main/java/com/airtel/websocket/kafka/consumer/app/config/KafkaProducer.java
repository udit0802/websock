package com.airtel.websocket.kafka.consumer.app.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.fasterxml.jackson.databind.JsonSerializer;

@EnableKafka
@Configuration
public class KafkaProducer {

	@Value("${kafka.consumer.brokers}")
	private String brokerList;

	@PostConstruct
	public void print(){
		System.out.println("producer initialized");
	}


	@Bean
	public Map<String, Object> producerConfigs() {
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return config;
	}

	public void send(String topic, String payload) {
		(new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(producerConfigs()))).send(topic, payload);
		System.out.println("Message: "+payload+" sent to topic: "+topic);
	}


}