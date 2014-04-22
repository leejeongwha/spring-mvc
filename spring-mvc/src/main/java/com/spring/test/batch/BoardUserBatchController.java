package com.spring.test.batch;

import javax.annotation.Resource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardUserBatchController {
	@Autowired
	JobLauncher jobLauncher;

	@Resource
	Job importUserJob;

	@RequestMapping("batch")
	public void handle() throws Exception {
		jobLauncher.run(importUserJob, new JobParameters());
	}
}
