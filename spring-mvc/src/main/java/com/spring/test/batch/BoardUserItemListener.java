package com.spring.test.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class BoardUserItemListener implements JobExecutionListener {

	@Override
	public void afterJob(JobExecution jobexecution) {
		System.out.println("##############board user batch afterJob");
	}

	@Override
	public void beforeJob(JobExecution jobexecution) {
		System.out.println("##############board user batch beforeJob");
	}
}
