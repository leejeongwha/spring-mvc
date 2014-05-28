package com.spring.test.exec;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

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

	/**
	 * ping 테스트
	 * 
	 * @throws Exception
	 */
	@Test
	public void pingTest() throws Exception {
		String host = "10.67.21.33";
		String message = "SUCESS";

		boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");

		ProcessBuilder processBuilder = new ProcessBuilder("ping", isWindows ? "-n" : "-c", "1", host);
		Process proc = processBuilder.start();

		int returnVal = proc.waitFor();

		if (returnVal == 1) {
			message = "FAIL";
		}

		System.out.println("status : " + message);
	}

	/**
	 * 텔넷 테스트
	 */
	@Test
	public void telnetTest() {
		try {
			String ip = "10.67.21.33";
			int port = 80;

			Socket s1 = new Socket(ip, port);
			InputStream is = s1.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			if (dis != null) {
				System.out.println("Connected with ip " + ip + " and port " + port);
			} else {
				System.out.println("Connection invalid");
			}

			dis.close();
			s1.close();
		} catch (Exception e) {
			System.out.println("Not Connected,Please enter proper input");
		}
	}

	/**
	 * url 테스트
	 * 
	 * @throws IOException
	 */
	@Test
	public void urlTest() throws IOException {
		String strUrl = "http://www.naver.com";

		try {
			URL url = new URL(strUrl);
			HttpURLConnection urlConn = (HttpURLConnection)url.openConnection();
			urlConn.connect();

			assertEquals(HttpURLConnection.HTTP_OK, urlConn.getResponseCode());
		} catch (IOException e) {
			System.err.println("Error creating HTTP connection");
			e.printStackTrace();

			throw e;
		}
	}

	/**
	 * 호스트 및 IP 출력
	 * 
	 * @throws UnknownHostException
	 */
	@Test
	public void printHostNameIp() throws UnknownHostException {
		System.out.println(InetAddress.getLocalHost().getHostName());
		System.out.println(InetAddress.getLocalHost().getHostAddress());
	}

}
