package com.spring.test.spel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:root-context.xml")
public class SpelSampleTest {
	@Autowired
	private SpelSample spelSample;

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * value 어노테이션 테스트
	 */
	@Test
	public void test() {
		System.out.println(spelSample.getRandom());
		System.out.println(spelSample.getTest());
	}

}
