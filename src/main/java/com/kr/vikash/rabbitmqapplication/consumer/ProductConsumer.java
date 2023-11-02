package com.kr.vikash.rabbitmqapplication.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProductConsumer {

	@RabbitListener(queues = "${rabbitmq.queue}")
	public void consumeMessage(Message message) throws InterruptedException {
		String replyMessage = new String(message.getBody());
        String correlationId = message.getMessageProperties().getCorrelationId();
        System.out.println("Received reply with Correlation ID " + correlationId + ": " + replyMessage);
		//System.out.println("***Received message from RabbitMQ: " + message);
	}
}
