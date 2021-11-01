package com.aspire.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProFilefirefox {
	WebDriver driver;

	@BeforeMethod
	public void openChrome() {
		//设置firefoxdriver路径
		System.setProperty("webdriver.firefox.driver", "C:\\firefoxdriver.exe");		
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		//设置火孤的默认下载文件夹：0表示桌面，1表示的的下载，2表示自定义文件夹
		firefoxProfile.setPreference("browser.download.folderList", "2");
		//设置自定义文件夹的位置		
		firefoxProfile.setPreference("browser.download.dir", "D:\\aaa");	
		//设置无需确认下载的文件格式
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream,application/vnd.ms-excel,test/zip,application/exe");
		//打开一个预先配置的火孤，按老师的代码 例子写的，但以下语句报错了
		//driver = new FirefoxDriver(firefoxProfile);
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
