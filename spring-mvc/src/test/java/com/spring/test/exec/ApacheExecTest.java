package com.spring.test.exec;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.PumpStreamHandler;
import org.junit.Before;
import org.junit.Test;

public class ApacheExecTest {
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * 커맨드 실행(쉘 실행은 Runtime.getRuntime().exec 메서드 사용하면 된다고 함.)
	 * 
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void commandExecTest() throws UnsupportedEncodingException {
		DefaultExecutor executor = new DefaultExecutor();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		PumpStreamHandler streamHandler = new PumpStreamHandler(baos);
		executor.setStreamHandler(streamHandler);

		CommandLine commandLine = CommandLine.parse("ipconfig");
		ExecuteWatchdog watchdog = new ExecuteWatchdog(6000);
		executor.setWatchdog(watchdog);
		try {
			int exitCode = executor.execute(commandLine);
			System.out.println("exit " + exitCode);
		} catch (ExecuteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(new String(baos.toByteArray(), "EUC-KR"));
	}
}
