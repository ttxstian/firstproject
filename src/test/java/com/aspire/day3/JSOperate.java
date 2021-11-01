package com.aspire.day3;

import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSOperate {
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
	public void eleDragTest() throws InterruptedException, AWTException {
		//打开百度
		driver.get("https://117.161.4.158/sbss/#/login?redirect=%2Fbusiness%2Fenterprise-info");
		driver.manage().window().maximize();
		driver.findElement(By.id("details-button")).click();;
		driver.findElement(By.id("proceed-link")).click();;
		driver.findElement(By.name("username")).sendKeys("workadmin");
		driver.findElement(By.name("password")).sendKeys("iSpicc2021");
		driver.findElement(By.xpath("//*[@placeholder='请输入验证码']")).sendKeys("0000");
		driver.findElement(By.xpath("//*[@class='el-button el-button--primary']")).click();;
		driver.findElement(By.xpath("//*[text()='业务操作']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'号码量补录')]")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementsByClassName('el-input__inner')[10].removeAttribute('readonly')");
		List<WebElement> inputEle = driver.findElements(By.className("el-input__inner"));
		inputEle.get(inputEle.size()-1).sendKeys("I:\\桌面\\近期重点需求\\号码补录功能 造测试数据\\test.xls");
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void ClosedBrower() {
		//关闭所有窗口退出
		driver.quit();
	}
}
