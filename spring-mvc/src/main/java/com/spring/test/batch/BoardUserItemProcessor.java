package com.spring.test.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.spring.test.hibernate.model.BoardUser;

@Service
public class BoardUserItemProcessor implements
		ItemProcessor<BoardUser, BoardUser> {

	@Override
	public BoardUser process(BoardUser boardUser) throws Exception {
		final String userName = boardUser.getUserName().toUpperCase();

		System.out.println("Converting (" + boardUser.getUserName()
				+ ") into (" + userName + ")");

		boardUser.setUserName(userName);

		return boardUser;
	}
}
