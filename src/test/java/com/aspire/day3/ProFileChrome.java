package com.aspire.day3;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProFileChrome {
	WebDriver driver;

	@BeforeMethod
	public void openChrome() {
		String downloadFilepath = "D:\\";
		
		HashMap<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("profile.default_contest_settings.popus", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		//设置chromedriver路径
		System.setProperty("webdriver.chrome.driver", "I:\\桌面\\学习资料\\Seliume+h5\\浏览器的driver包\\chrome\\92.0.4515.43\\chromedriver.exe");
		//打开chrome
		driver = new ChromeDriver(options);
	}
	
	@Test
	public void selectTest() throws InterruptedException {
		//打开百度
		driver.get("https://www.baidu.com/");

	}
	
	@AfterMethod
	public void ClosedBrower() {
		//关闭所有窗口退出
		driver.quit();
	}
}
