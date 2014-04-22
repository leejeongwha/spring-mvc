package com.spring.test.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.spring.test.hibernate.model.BoardUser;

@Controller
public class RestController {
	/**
	 * Spring이 알아서 해당 객체에 맞는 messageConverter를 반환
	 * 
	 * @return
	 */
	@RequestMapping("restJson")
	@ResponseBody
	public User restJson() {
		User user = new User();
		user.setName("tset json");
		user.setAge(20);

		return user;
	}

	@RequestMapping("restJsonFromString")
	public String restJsonFromString(Model model) {
		RestTemplate template = new RestTemplate();
		User forObject = template.getForObject(
				"http://localhost:8080/restJson", User.class);

		model.addAttribute("result", forObject);

		return "rest/result";
	}

	/**
	 * Spring이 알아서 해당 객체에 맞는 messageConverter를 반환
	 * 
	 * @return
	 */
	@RequestMapping("restXml")
	@ResponseBody
	public UserXml restXml() {
		UserXml userXml = new UserXml();
		userXml.setName("test xml");
		userXml.setAge(20);

		return userXml;
	}

	@RequestMapping("restXmlFromString")
	public String restXmlFromString(Model model) {
		RestTemplate template = new RestTemplate();
		User forObject = template.getForObject("http://localhost:8080/restXml",
				User.class);

		model.addAttribute("result", forObject);

		return "rest/result";
	}
}