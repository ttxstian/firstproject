package com.aspire.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramerTest {
	WebDriver driver;
	
	@BeforeMethod
	public void openChrome() {
		//设置chromedriver路径
		System.setProperty("webdriver.chrome.driver", "I:\\桌面\\学习资料\\Seliume+h5\\浏览器的driver包\\chrome\\95.0.4638.17\\chromedriver.exe");
		//打开chrome
		driver = new ChromeDriver();
	}
	@Test
	public void FrameTest() throws InterruptedException {
		//打开百度
		driver.get("https://www.baidu.com/");
		//共有3种方式转交控制权给iframe
		//通过id或name转交控制权
		driver.switchTo().frame("id");
		driver.switchTo().frame("kb");
		//通过元素定位的方式转交控制权,先定位到iframe这个元素
		WebElement iframeEle1 = driver.findElement(By.tagName("aaaaaa"));
		driver.switchTo().frame(iframeEle1);
		//多层嵌套的iframe转交控制权：
		WebElement iframeEle2 = driver.findElement(By.tagName("bbbbb"));
		driver.switchTo().frame(iframeEle2);
		//将控制权交给上一级frame
		driver.switchTo().parentFrame();
		//将控制权交给顶层frame
		driver.switchTo().defaultContent();
	}
}
