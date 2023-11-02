package com.kr.vikash.rabbitmqapplication.producer;

import java.util.UUID;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
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

	public void produceMessage(String inputMessage) {
		
		String correlationId = UUID.randomUUID().toString();  // unique correlation ID, help to match the reply with the corresponding request
		
		System.out.println("**Generated correlationId in Sender end: "+correlationId);

		MessageProperties properties = new MessageProperties();
        properties.setCorrelationId(correlationId);
        Message message = new Message(inputMessage.getBytes(), properties);
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
//		rabbitTemplate.convertAndSend(exchange, routingKey, message);
	}
}
