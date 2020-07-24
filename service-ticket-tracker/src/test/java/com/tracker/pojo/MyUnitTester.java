package com.tracker.pojo;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyUnitTester {

	@Test
	public void test() {
		User test = new User("richard", "caceres", 44, "firefighter", "123456");
		String result1 = test.getFirstName();
		String result2 = test.getLastName();
		int result3 = test.getBadgeNum();
		String result4 = test.getJobFunction();
		String result5 = test.getPassword();
		
		assertEquals(result1, "richard");
		assertEquals(result2, "caceres");
		assertEquals(result3, 44);
		assertEquals(result4, "firefighter");
		assertEquals(result5, "123456");
		
	}

}
