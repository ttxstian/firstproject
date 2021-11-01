package com.aspire.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClassTest1 {
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
	public void eleMoveToElementTest() throws InterruptedException {
		//打开百度
		driver.get("https://www.baidu.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		WebElement eleMoveToElement = driver.findElement(By.id("s-usersetting-top"));
		//使用Actions类之前需要先实例化
		Actions action = new Actions(driver);
		//moveToElement方法，表示将鼠标移动到某个元素上
		action.moveToElement(eleMoveToElement).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='搜索设置']")).click();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void ClosedBrower() {
		//关闭所有窗口退出
		driver.quit();
	}
	
}
