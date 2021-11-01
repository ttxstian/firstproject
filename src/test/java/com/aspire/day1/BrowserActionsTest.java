package com.aspire.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserActionsTest {
	WebDriver driver;
	
	@BeforeMethod
	public void openChrome() {
		//设置chromedriver路径
		System.setProperty("webdriver.chrome.driver", "I:\\桌面\\学习资料\\Seliume+h5\\浏览器的driver包\\chrome\\95.0.4638.17\\chromedriver.exe");
		//打开chrome
		driver = new ChromeDriver();
	}
	
	@Test
	public void closedChrome() throws InterruptedException {
		//打开百度
		driver.get("https://www.baidu.com");
		Thread.sleep(3000);
		//窗口最大化
		driver.manage().window().maximize();
		Thread.sleep(3000);		
		//刷新
		driver.navigate().refresh();
		Thread.sleep(3000);
		//后退
		driver.navigate().back();
		Thread.sleep(3000);
		//前进
		driver.navigate().forward();
		Thread.sleep(3000);
		//设置窗口大小，实例化Dimension类
		Dimension dimension = new Dimension(300,300);
		driver.manage().window().setSize(dimension);
		Thread.sleep(3000);	
		String a = driver.getCurrentUrl();
		String b = "https://www.baidu.com/";
		System.out.println("获取的URL是："+a);
		System.out.println("预期的URL是："+b);
		System.out.println("当前页面Title："+driver.getTitle());
		Assert.assertEquals(a,b,"打开的网址不是baidu");
	}
	
	@AfterMethod
	public void ClosedBrower() {
		//关闭所有窗口退出
		driver.quit();
	}
}