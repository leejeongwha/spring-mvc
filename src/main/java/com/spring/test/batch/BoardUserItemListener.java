package com.spring.test.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class BoardUserItemListener implements JobExecutionListener {
	private static final Logger logger = LoggerFactory.getLogger(BoardUserItemListener.class);

	@Override
	public void afterJob(JobExecution jobexecution) {
		logger.debug("##############board user batch afterJob");
	}

	@Override
	public void beforeJob(JobExecution jobexecution) {
		logger.debug("##############board user batch beforeJob");
	}
}
