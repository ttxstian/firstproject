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
		//ʵ����һ��Grid����ַ����� 
		DesiredCapabilities chromeDc = DesiredCapabilities.chrome();
		//ʵ����һ��driver
		//�˴������ͨ��hubȥ�ַ���URL���洫��hub��url��ַ��
		//�����ָ��ĳ��node�ڵ����ܽű���URL�����ֵΪ����ĳ��node�ڵ��urlֵ��
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.56:8888/wd/hub"),chromeDc);
		driver.get("http://www.baidu.com");
		Thread.sleep(3000);
		driver.quit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

}
