package com.aspire.day3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SelGridSimultaneous {
	@DataProvider (name = "data1")
	public Object[][] test1(){
		return new Object[][] {
			{"firefox","http://192.168.1.56:8888/"},
			{"firefox","http://192.168.1.57:8888/"}
		};
	}
	
	@Test(dataProvider = "data1")
	public void testGrid(String browser,String url) throws MalformedURLException,InterruptedException {
		//实例化一个Grid任务分发对象 
		DesiredCapabilities dc = null;
		if(browser.contentEquals("firefox")) {
			dc = DesiredCapabilities.firefox();
		}else if(browser.contentEquals("chrome")) {
			dc = DesiredCapabilities.chrome();
		}else {
			System.out.println("Error");
		}
		WebDriver driver = new RemoteWebDriver(new URL(url + "wd/hub"),dc);
		driver.get("http://www.baidu.com");
		Thread.sleep(3000);
		driver.quit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
