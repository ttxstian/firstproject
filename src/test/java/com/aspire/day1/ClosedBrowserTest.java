package com.aspire.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClosedBrowserTest {
	@Test
	public void closedChrome1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "I:\\����\\ѧϰ����\\Seliume+h5\\�������driver��\\chrome\\95.0.4638.17\\chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();
		Thread.sleep(5000);
		webDriver.close();
	}
	@Test
	public void closedChrome2() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "I:\\����\\ѧϰ����\\Seliume+h5\\�������driver��\\chrome\\95.0.4638.17\\chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();
		Thread.sleep(5000);
		webDriver.quit();
	}
}