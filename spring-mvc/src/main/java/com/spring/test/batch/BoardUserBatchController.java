package com.spring.test.batch;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
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
	public String handle() throws Exception {
		Map<String, JobParameter> confMap = new HashMap<String, JobParameter>();
		confMap.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters jobParameters = new JobParameters(confMap);

		JobExecution run = jobLauncher.run(importUserJob, jobParameters);

		System.out.println(run.getStatus());

		return "redirect:/board/list";
	}
}
