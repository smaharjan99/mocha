package com.cubic.math;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.cubic.Accounting;
import com.cubic.Billing;

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

	SimpleCalc calc = new SimpleCalc();

	@Category({ Accounting.class })
	@Test
	public void testAdd() {

		int result = calc.add(10, 5);
		assertEquals(15, result);
		// fail("Not yet implemented");
	}

	@Test
	public void testAddNegative() {

		int result = calc.add(-10, -5);
		assertEquals(-15, result);
		// fail("Not yet implemented");
	}

	@Category({ Billing.class })
	@Test
	public void testSub() {

		int result = calc.sub(10, 5);
		assertEquals(5, result);
		// fail("Not yet implemented");
	}

	@Test(expected = ArithmeticException.class)
	public void testDiv() {
		int result = calc.div(10, 5);
		assertEquals(2, result);
		// fail("Not yet implemented");
	}

	@Test
	public void testMult() {

		int result = calc.mult(10, 5);
		assertEquals(50, result);
		// fail("Not yet implemented");
	}

	@Test(timeout = 1500)
	public void testMulTimeOut() {
		timeout(1000);
		int result = calc.mult(10, 5);
		assertEquals(50, result);
		// fail("Not yet implemented");
	}

	private void timeout(int value) {
		try {
			Thread.sleep(value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
