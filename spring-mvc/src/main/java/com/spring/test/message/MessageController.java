package com.spring.test.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageController {
	@Autowired
	private MessageSource messages;

	@RequestMapping("message")
	public String messageTest() {
		System.out.println(messages.getMessage("test",
				new Object[] { "메시지테스트" }, null));

		System.out.println(messages.getMessage("test1",
				new Object[] { "userDao" }, null));

		return "message/test";
	}
}
