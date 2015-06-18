package com.spring.test.etc;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.quartz.CronExpression;

public class StringTest {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * cron parsing 및 validation 테스트
	 */
	@Test
	public void test() {
		String cronStr = "0/2 * * * * ?";
		CronExpression jobCronExp;
		try {
			jobCronExp = new CronExpression(cronStr);
		} catch (ParseException e) {
			throw new IllegalArgumentException("cannot parse cron expression:" + cronStr, e);
		}

		System.out.println(jobCronExp.isSatisfiedBy(new Date()));
	}

	@Test
	public void testConrExpression() throws ParseException {
		String expression = "0 0 1 1 * ?";
		CronExpression cronExpression = new CronExpression(expression);

		Date date = new Date();

		for (int i = 0; i < 7; i++) {
			Date nextValidDate = cronExpression.getNextValidTimeAfter(date);
			System.out.println(nextValidDate);
			date = nextValidDate;
		}
	}
}
