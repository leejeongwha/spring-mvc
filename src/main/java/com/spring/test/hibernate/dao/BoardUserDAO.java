package com.spring.test.hibernate.dao;

import java.util.List;

import com.spring.test.hibernate.model.BoardUser;

public interface BoardUserDAO {

	List<BoardUser> getBoardUserList(int page, int rownum) throws Exception;

	int getTotalBoardUserCount();

	BoardUser getBoardUserById(String id) throws Exception;

	boolean addBoardUser(BoardUser user) throws Exception;

	boolean removeBoardUser(BoardUser user) throws Exception;

	boolean removeBoardUserById(String id) throws Exception;

	boolean updateBoardUser(BoardUser user) throws Exception;

	int getUserCountById(String id) throws Exception;

	void cacheEvict();
}
