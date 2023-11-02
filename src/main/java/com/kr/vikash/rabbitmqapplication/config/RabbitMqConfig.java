package com.kr.vikash.rabbitmqapplication.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

	@Value("${rabbitmq.exchange}")
	private String exchange;

	@Value("${rabbitmq.routingKey}")
	private String routingKey;

	@Value("${rabbitmq.queue}")
	private String queue;

	@Bean
	public Queue queue() {
		return new Queue(queue);
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchange);
	}

	@Bean
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(routingKey);
	}
	
//	 @Bean
//	    public Binding replyBinding() {
//	        return BindingBuilder.bind(queue()).to(exchange()).with(routingKey);
//	    }
}
