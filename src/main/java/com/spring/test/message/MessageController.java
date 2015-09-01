package com.spring.test.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.test.batch.BoardUserBatchController;

@Controller
public class MessageController {
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

	@Autowired
	private MessageSource messages;

	@RequestMapping("message")
	public String messageTest() {
		logger.debug(messages.getMessage("test", new Object[] {"메시지테스트"}, null));

		logger.debug(messages.getMessage("test1", new Object[] {"userDao"}, null));

		return "message/test";
	}
}
