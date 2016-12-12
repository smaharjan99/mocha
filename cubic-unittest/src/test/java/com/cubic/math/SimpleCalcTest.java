package com.cubic.math;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleCalcTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After");

	}

	@Test
	public void testAdd() {
		SimpleCalc calc = new SimpleCalc();
		int result = calc.add(10, 5);
		assertEquals(15, result);
		// fail("Not yet implemented");
	}

	@Test
	public void testAddNegative() {
		SimpleCalc calc = new SimpleCalc();
		int result = calc.add(-10, -5);
		assertEquals(-15, result);
		// fail("Not yet implemented");
	}

	@Test
	public void testSub() {
		SimpleCalc calc = new SimpleCalc();
		int result = calc.sub(10, 5);
		assertEquals(5, result);
		// fail("Not yet implemented");
	}

	@Test
	public void testDiv() {
		SimpleCalc calc = new SimpleCalc();
		int result = calc.div(10, 5);
		assertEquals(2, result);
		// fail("Not yet implemented");
	}

	@Test
	public void testMult() {
		SimpleCalc calc = new SimpleCalc();
		int result = calc.mult(10, 5);
		assertEquals(50, result);
		// fail("Not yet implemented");
	}

}
