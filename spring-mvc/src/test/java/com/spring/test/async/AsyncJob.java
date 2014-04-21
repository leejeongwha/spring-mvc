package com.spring.test.async;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class AsyncJob {
	@Async
	public Future<Integer> print() {
		System.out.println("In async: " + Thread.currentThread());

		return new AsyncResult<Integer>(-2);
	}
}
