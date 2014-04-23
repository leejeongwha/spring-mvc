package com.spring.test.etc;

import static org.junit.Assert.*;

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
}
