package com.spring.test.batch;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.test.hibernate.model.BoardUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:root-context.xml")
public class BoardUserBatchControllerTest {
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Resource
	Job importUserJob;

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	JobRepository jobRepository;

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Before
	public void setUp() throws Exception {
		jobLauncherTestUtils = new JobLauncherTestUtils();

		jobLauncherTestUtils.setJob(importUserJob);
		jobLauncherTestUtils.setJobLauncher(jobLauncher);
		jobLauncherTestUtils.setJobRepository(jobRepository);
	}

	@Test
	public void test() throws Exception {
		jobLauncherTestUtils.launchJob(jobLauncherTestUtils.getUniqueJobParameters());

		List<BoardUser> find = (List<BoardUser>)hibernateTemplate.find("FROM board_user WHERE id = 'admin19'");

		assertNotNull(find.get(0));

		System.out.println(find.get(0).getUserName());
	}
}
