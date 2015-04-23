package com.spring.test.annotation;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginCheckController {
	@Autowired
	private LoginCheckBO loginCheckBO;

	@RequestMapping("login")
	@ResponseBody
	@Auth(check = true)
	public String check(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();

		String result = loginCheckBO.check(cookies);

		return result;
	}
}
