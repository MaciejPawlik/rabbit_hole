package com.example.messagingrabbitmq;

import org.springframework.stereotype.Component;

@Component
public class Receiver {

	public void receiveMessage(String message) {
		System.out.println("Received <" + message + ">");
		doWork(message);
		System.out.println("Done");
	}

	private static void doWork(String task) {
		int counter = 1;
		for (char ch: task.toCharArray()) {
			if (ch == '.') {
				System.out.println(String.format("Proceeding dot no. %s", counter));
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				counter++;
			}
		}
	}
}
