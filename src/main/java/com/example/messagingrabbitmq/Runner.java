package com.example.messagingrabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

	private final RabbitTemplate rabbitTemplate;

	private final Queue queue;

	public Runner(RabbitTemplate rabbitTemplate, Queue queue) {
		this.rabbitTemplate = rabbitTemplate;
		this.queue = queue;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sending message...");
		rabbitTemplate.convertAndSend(queue.getName(), "Message 1 ........ from RabbitMQ!");
		rabbitTemplate.convertAndSend(queue.getName(), "Message 2 .... from RabbitMQ!");
	}

}
