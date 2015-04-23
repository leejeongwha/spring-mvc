package com.spring.test.etc;

import java.text.NumberFormat;

import org.junit.Before;
import org.junit.Test;

public class NumberTest {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * 3자리수 마다 콤마
	 */
	@Test
	public void NumberTest() {
		NumberFormat clsNF = NumberFormat.getInstance();

		System.out.println(clsNF.format(30002342));
	}

	@Test
	public void 소수점_2자리까지() {
		Double dougle = 2.12356;

		String format = String.format(new String("%.2f"), dougle);

		System.out.println(format);
	}
}
