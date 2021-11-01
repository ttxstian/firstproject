package com.aspire.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo2 {
	@Test
	public void assertEqualTest() {
		String a = "asdf";
		String b = "234";
		Assert.assertEquals(a, b,"a������b");
	}
	
	@Test
	public void assertNotEqualTest() {
		int a = 123;
		int b = 234;
		Assert.assertNotEquals(a, b, "a����b");
	}
	
	@Test
	public void assertNotNullTest() {
		String a = null;
		Assert.assertNotNull(a, "aΪ��");
	}
	
	@Test
	public void assertNullTest() {
		String a = null;
		Assert.assertNull(a, "a��Ϊ��");
	}	
}