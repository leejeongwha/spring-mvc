package com.spring.test.annotation;

import javax.servlet.http.Cookie;

import org.springframework.stereotype.Service;

@Service
public class LoginCheckBOImpl implements LoginCheckBO {

	@Override
	@Auth(check = false)
	public String check(Cookie[] cookies) {
		StringBuilder builder = new StringBuilder();

		for (Cookie cookie : cookies) {
			builder.append(cookie.getName() + ":" + cookie.getValue() + "<br>");
		}

		return builder.toString();
	}
}
