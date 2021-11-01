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

public class ActionsClassTest {
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
		WebElement eleContextClick = driver.findElement(By.id("su"));
		//使用Actions类之前需要先实例化
		Actions action = new Actions(driver);
		/*
		 * 1、contextClick方法，表示右击，以下2两写法均可
		 * action.contextClick(ele).build().perform();
		 * action.contextClick(ele).perform();
		 * 2、contextClick可以带参或不带参，带参则在元素上右击，不带参在鼠标所在的位置上右击
		 */
		action.contextClick(eleContextClick).perform();
		Thread.sleep(3000);
		
		WebElement eleDoubleClick = driver.findElement(By.xpath("//*[@id=\"lg\"]"));
		/*
		 * 1、doubleClick方法，表示双击，以下2两写法均可
		 * action.doubleClick(ele).build().perform();
		 * action.doubleClick(ele).perform();
		 * 2、doubleClick可以带参或不带参，带参则在元素上双击，不带参在鼠标所在的位置上双击
		 */
		action.doubleClick(eleDoubleClick).build().perform();
		Thread.sleep(3000);
		
	}
	
	@AfterMethod
	public void ClosedBrower() {
		//关闭所有窗口退出
		driver.quit();
	}
}
