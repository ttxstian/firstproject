package com.aspire.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest {
	WebDriver driver;

	@BeforeMethod
	public void openChrome() {
		//设置chromedriver路径
		System.setProperty("webdriver.chrome.driver", "I:\\桌面\\学习资料\\Seliume+h5\\浏览器的driver包\\chrome\\92.0.4515.43\\chromedriver.exe");
		//打开chrome
		driver = new ChromeDriver();
	}
	
	@Test
	public void selectTest() throws InterruptedException {
		//打开百度
		driver.get("https://www.baidu.com/");
		//先定位到下拉框元素
		WebElement selectEle = driver.findElement(By.id("dddd"));
		//实例化一个select类
		Select select = new Select(selectEle);
		//通过索引号选择一个下拉选项，索引值 从0开始
		select.selectByIndex(2);
		//通过value值选择一个下拉选项
		select.selectByValue("按条");
		//通过文本值选择一个下拉选项,注意文本值后面有时候有一堆空格，要带上空格。
		select.selectByVisibleText("按条");
	}
	
	@AfterMethod
	public void ClosedBrower() {
		//关闭所有窗口退出
		driver.quit();
	}
}