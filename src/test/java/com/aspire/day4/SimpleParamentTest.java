package com.aspire.day4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimpleParamentTest {
	@DataProvider(name = "logUser")
	public Object[][] data1(){
		return new Object[][] {
			{"user1","passwd1"},
			{"user2","passwd2"},
			{"user3","passwd3"}
		};
	}
	@Test(dataProvider = "logUser")
	public void loginTest(String user,String passwd) {
		System.out.println("user:"+user);
		System.out.println("passwd:"+passwd);
	}
}