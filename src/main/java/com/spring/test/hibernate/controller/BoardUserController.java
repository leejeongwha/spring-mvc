package com.spring.test.hibernate.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private BoardUserDAO boardUserDAO;

	@RequestMapping("/list")
	public String list(Model model, PagingTag pagingTag) throws Exception {
		List<BoardUser> boardUserList = boardUserDAO.getBoardUserList(pagingTag.getCurrentPage(), pagingTag.getRecordsPerPage());

		model.addAttribute("boardUserList", boardUserList);

		model.addAttribute("totalRecordCount", boardUserDAO.getTotalBoardUserCount());
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

		logger.info("user name = " + boardUserById.getUserName());

		model.addAttribute("boardUser", boardUserById);

		return "board/user";
	}

	@RequestMapping("/evict")
	public String evict() {
		boardUserDAO.cacheEvict();

		return "redirect:/board/list";
	}

	/**
	 * 엑셀 다운로드
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("excel")
	public String excel(Model model) throws Exception {
		final List<LinkedHashMap> excelStatistics = makeExcelData(boardUserDAO.getBoardUserList(1, 100));

		ArrayList<List<String>> dataElementList = new ArrayList<List<String>>();

		model.addAttribute("keySet", excelStatistics.get(0).keySet());

		for (LinkedHashMap map : excelStatistics) {
			List<String> dataElement = new ArrayList<String>();

			Set<Entry<String, String>> entrySet = map.entrySet();
			Iterator<Entry<String, String>> iterator = entrySet.iterator();
			while (iterator.hasNext()) {
				Map.Entry entry = (Map.Entry)iterator.next();
				dataElement.add(entry.getValue().toString());
			}
			dataElementList.add(dataElement);
		}

		model.addAttribute("dataElementList", dataElementList);

		return "board/excel";
	}

	/**
	 * LinkedHashMap을 사용하여야 순서대로 정렬됨
	 * 
	 * @param boardUserList
	 * @return
	 */
	private List<LinkedHashMap> makeExcelData(List<BoardUser> boardUserList) {
		List<LinkedHashMap> excelStatistics = new ArrayList<LinkedHashMap>();

		for (BoardUser obj : boardUserList) {
			try {
				// Field[] fields = obj.getClass().getFields(); //private field는
				// 나오지 않음
				Field[] fields = obj.getClass().getDeclaredFields();
				LinkedHashMap resultMap = new LinkedHashMap();
				for (int i = 0; i <= fields.length - 1; i++) {
					fields[i].setAccessible(true);
					resultMap.put(fields[i].getName(), fields[i].get(obj));
				}

				excelStatistics.add(resultMap);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		return excelStatistics;
	}
}
