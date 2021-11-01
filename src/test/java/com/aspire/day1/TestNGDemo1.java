
package com.aspire.day1;

import org.testng.annotations.*;

public class TestNGDemo1 {
	@BeforeTest
	public void beforeTest01(){
		System.out.println("这是@BeforeTest01的一个注解");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("这是@BeforeMethod的一个注解");
	}
	
	@Test
	public void testCase01(){
		System.out.println("这是@Test01的一个注解,Case01");
	}
	
	@Test
	public void testCase02(){
		System.out.println("这是@Test02的一个注解,Case02");
	}
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("这是@AfterMethod的一个注解");
	}
	
	@AfterTest
	public void afterTest01(){
		System.out.println("这是@afterTest01的一个注解");
	}
}