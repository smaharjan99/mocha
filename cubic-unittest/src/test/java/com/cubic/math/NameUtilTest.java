package com.cubic.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.cubic.Accounting;
import com.cubic.Billing;

public class NameUtilTest {

	private NameUtil nameUtil = new NameUtil();

	@Test
	public void testGetFullName() {
		String result = nameUtil.getFullName("Adam", "Gilchrist");
		// assertNull(result);
		assertEquals("Adam,Gilchrist", result);
		// assertThat(result, allOf(containsString("Adam"),
		// containsString("Gilchrist")));

		// fail("Not yet implemented");
	}

	@Category({ Accounting.class, Billing.class })
	@Test
	public void testGetLastName() {
		String result = nameUtil.getFullName(null, "Gilchrist");
		// assertNull(result);
		assertEquals("Gilchrist", result);
		// fail("Not yet implemented");
	}

	@Category({ Accounting.class })
	@Test
	public void testGetFirstName() {
		String result = nameUtil.getFullName("Adam", null);
		// assertNull(result);
		assertEquals("Adam", result);
		// fail("Not yet implemented");
	}

	@Category({ Billing.class })
	@Test
	public void testGetNoName() {
		String result = nameUtil.getFullName(null, null);
		// assertNotNull(result);
		assertEquals("", result);
		// fail("Not yet implemented");
	}

}
