package com.kr.vikash.rabbitmqapplication.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProductProducer {
	
    @Autowired
    private RabbitTemplate rabbitTemplate;
	
	@Value("${rabbitmq.exchange}")
	private String exchange;

	@Value("${rabbitmq.routingKey}")
	private String routingKey;

	@Value("${rabbitmq.queue}")
	private String queue;

	public void produceMessage(String message) {
		rabbitTemplate.convertAndSend(exchange, routingKey, message);
	}
}
