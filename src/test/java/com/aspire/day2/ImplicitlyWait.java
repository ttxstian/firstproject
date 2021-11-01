package com.aspire.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImplicitlyWait {
	WebDriver driver;

	@BeforeMethod
	public void openChrome() {
		//设置chromedriver路径
		System.setProperty("webdriver.chrome.driver", "I:\\桌面\\学习资料\\Seliume+h5\\浏览器的driver包\\chrome\\95.0.4638.17\\chromedriver.exe");
		//打开chrome
		driver = new ChromeDriver();
		/*
		 * 显示等待一般写在driver实例化后面
		 * 当遇到findElement或findElements方法时，它会在指定的时间内轮巡某个元素是否出现
		 * 若元素出现则继续往下执行，否则抛出NoSuchElementException的异常
		 */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void selectTest() throws InterruptedException {
		//打开百度
		driver.get("https://www.baidu.com/");
		driver.findElement(By.xpath("//*[@id='s-top-left']/a[1]")).click();
		//获取当前窗口的句柄值,此时获取到的句柄值其实是打开百度页面的句柄值，也就是第一个页面的句柄值
		String handle = driver.getWindowHandle();
		for(String handles:driver.getWindowHandles()) {
			if(handles.equals(handle))
				continue;
			//将控制权转交给第2个窗口
			driver.switchTo().window(handles);
		}
		//点击科技窗口
		driver.findElement(By.xpath("//*[text()='帮助']")).click();
		//将控制权转交给第1个窗口
		driver.switchTo().window(handle);
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void ClosedBrower() {
		//关闭所有窗口退出
		driver.quit();
	}
}