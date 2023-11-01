package com.kr.vikash.rabbitmqapplication.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProductConsumer {

	@RabbitListener(queues = "${rabbitmq.queue}")
	public void consumeMessage(String message) throws InterruptedException {
		
		System.out.println("***Received message from RabbitMQ: " + message);
	}
}
