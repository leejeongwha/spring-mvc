package com.spring.test.amqp;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class TutorialListener implements MessageListener {
	public void onMessage(Message message) {

		String messageBody = new String(message.getBody());

		System.out.println("Listener received message----->" + messageBody);

	}
}
