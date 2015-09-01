package com.spring.test.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpelSample {
	@Value("#{common['common.test']}")
	private String test;

	@Value("#{ T(java.lang.Math).random() * 100.0 }")
	private long random;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public long getRandom() {
		return random;
	}

	public void setRandom(long random) {
		this.random = random;
	}
}
