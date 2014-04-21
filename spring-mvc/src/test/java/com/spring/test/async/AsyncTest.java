package com.spring.test.async;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-context.xml")
public class AsyncTest {
	@Autowired
	private AsyncJob asyncJob;

	@Test
	public void test() throws InterruptedException, ExecutionException {
		System.out.println("Before, in test: " + Thread.currentThread());
		Future<Integer> test = asyncJob.print();
		System.out.println("After, in test: " + Thread.currentThread());

		assertEquals(test.get(), new Integer(-2));
	}
}
