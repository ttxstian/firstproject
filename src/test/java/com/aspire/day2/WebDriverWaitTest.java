package com.aspire.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverWaitTest {
	WebDriver driver;

	@BeforeMethod
	public void openChrome() {
		//设置chromedriver路径
		System.setProperty("webdriver.chrome.driver", "I:\\桌面\\学习资料\\Seliume+h5\\浏览器的driver包\\chrome\\95.0.4638.17\\chromedriver.exe");
		//打开chrome
		driver = new ChromeDriver();
	}
	
	@Test
	public void selectTest() throws InterruptedException {
		//打开百度
		driver.get("https://www.baidu.com/");
		/*显示等待，需要先实例化一个WebDriverWait的类，然后调用这个类下面的until方法
		until方法里传一个定位元素的方法，若找到则继续往下执行，若未等到这个元素会报TimeoutException异常
		*/
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='s-top-left']/a[1]")));
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='帮助']")));
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

