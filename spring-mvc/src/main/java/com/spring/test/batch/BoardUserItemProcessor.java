package com.spring.test.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.spring.test.hello.HomeController;
import com.spring.test.hibernate.model.BoardUser;

@Service
public class BoardUserItemProcessor implements
		ItemProcessor<BoardUser, BoardUser> {
	private static final Logger logger = LoggerFactory
			.getLogger(BoardUserItemProcessor.class);

	@Override
	public BoardUser process(BoardUser boardUser) throws Exception {
		final String userName = boardUser.getUserName().toUpperCase();

		logger.info("Converting (" + boardUser.getUserName() + ") into ("
				+ userName + ")");

		boardUser.setUserName(userName);

		return boardUser;
	}
}
