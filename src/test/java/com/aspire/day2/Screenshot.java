package com.aspire.day2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Screenshot {
	WebDriver driver;
	
	@BeforeMethod
	public void openChrome() {
		//设置chromedriver路径
		System.setProperty("webdriver.chrome.driver", "I:\\桌面\\学习资料\\Seliume+h5\\浏览器的driver包\\chrome\\95.0.4638.17\\chromedriver.exe");
		//打开chrome
		driver = new ChromeDriver();
	}
	
	@Test
	public void findElementsTest() throws InterruptedException {
		driver.get("https://www.baidu.com");
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file,new File("D:\\test1.png"));
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	
	@AfterMethod
	public void ClosedBrower() {
		//关闭所有窗口退出
		driver.quit();
	}
}