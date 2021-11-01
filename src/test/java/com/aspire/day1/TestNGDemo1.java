
package com.aspire.day1;

import org.testng.annotations.*;

public class TestNGDemo1 {
	@BeforeTest
	public void beforeTest01(){
		System.out.println("����@BeforeTest01��һ��ע��");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("����@BeforeMethod��һ��ע��");
	}
	
	@Test
	public void testCase01(){
		System.out.println("����@Test01��һ��ע��,Case01");
	}
	
	@Test
	public void testCase02(){
		System.out.println("����@Test02��һ��ע��,Case02");
	}
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("����@AfterMethod��һ��ע��");
	}
	
	@AfterTest
	public void afterTest01(){
		System.out.println("����@afterTest01��һ��ע��");
	}
}