package com.aspire.day3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SelGrid {
	@Test
	public void openChrome() throws MalformedURLException,InterruptedException {
		//实例化一个Grid任务分发对象 
		DesiredCapabilities chromeDc = DesiredCapabilities.chrome();
		//实例化一个driver
		//此处如果想通过hub去分发，URL里面传递hub的url地址；
		//如果想指派某个node节点来跑脚本，URL里面的值为具体某个node节点的url值。
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.56:8888/wd/hub"),chromeDc);
		driver.get("http://www.baidu.com");
		Thread.sleep(3000);
		driver.quit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

}
