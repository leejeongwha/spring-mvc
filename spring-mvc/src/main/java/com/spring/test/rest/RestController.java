package com.spring.test.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.spring.test.hibernate.model.BoardUser;

@Controller
public class RestController {
	@RequestMapping("rest")
	@ResponseBody
	public User rest() {
		User user = new User();
		user.setName("tset");
		user.setAge(20);
		
		return user;
	}
	
	@RequestMapping("restFromString")
	public void restFromString() {
		RestTemplate template = new RestTemplate();
		User forObject = template.getForObject("http://localhost:8080/rest", User.class);
		
		System.out.println(forObject.toString());
	}
}
