package com.spring.test.hibernate.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.test.hello.HomeController;
import com.spring.test.hibernate.dao.BoardUserDAO;
import com.spring.test.hibernate.model.BoardUser;
import com.spring.test.hibernate.model.PagingTag;

@Controller
@RequestMapping("/board")
public class BoardUserController {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private BoardUserDAO boardUserDAO;

	@RequestMapping("/list")
	public String list(Model model, PagingTag pagingTag) throws Exception {
		List<BoardUser> boardUserList = boardUserDAO.getBoardUserList(
				pagingTag.getCurrentPage(), pagingTag.getRecordsPerPage());

		model.addAttribute("boardUserList", boardUserList);

		model.addAttribute("totalRecordCount",
				boardUserDAO.getTotalBoardUserCount());
		model.addAttribute("recordsPerPage", pagingTag.getRecordsPerPage());

		return "board/list";
	}

	@RequestMapping("/add")
	public String add(Model model, BoardUser user) throws Exception {
		boardUserDAO.addBoardUser(user);

		return "redirect:/board/list";
	}

	@RequestMapping("/get/{id}")
	public String get(@PathVariable String id, Model model) throws Exception {
		BoardUser boardUserById = boardUserDAO.getBoardUserById(id);

		logger.info(boardUserById.getUserName());

		model.addAttribute("boardUser", boardUserById);

		return "board/user";
	}
}
