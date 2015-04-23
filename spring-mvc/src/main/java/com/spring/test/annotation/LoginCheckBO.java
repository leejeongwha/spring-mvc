package com.spring.test.annotation;

import javax.servlet.http.Cookie;

public interface LoginCheckBO {
	String check(Cookie[] cookies);
}
