package com.spring.test.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.spring.test.hello.HomeController;

@Service
public class SchedulerTest {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Scheduled(cron = "0/5 * * * * ?")
	public void test1() {
		//logger.info("test1 : " + System.currentTimeMillis());
	}

	@Scheduled(fixedDelay = 1000)
	public void test2() {
		//logger.info("test2 : " + System.currentTimeMillis());
	}
}
