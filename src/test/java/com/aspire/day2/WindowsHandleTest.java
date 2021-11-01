package com.aspire.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsHandleTest {
	WebDriver driver;

	@BeforeMethod
	public void openChrome() {
		//����chromedriver·��
		System.setProperty("webdriver.chrome.driver", "I:\\����\\ѧϰ����\\Seliume+h5\\�������driver��\\chrome\\95.0.4638.17\\chromedriver.exe");
		//��chrome
		driver = new ChromeDriver();
	}
	
	@Test
	public void selectTest() throws InterruptedException {
		//�򿪰ٶ�
		driver.get("https://www.baidu.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='s-top-left']/a[1]")).click();
		Thread.sleep(3000);
		//��ȡ��ǰ���ڵľ��ֵ,��ʱ��ȡ���ľ��ֵ��ʵ�Ǵ򿪰ٶ�ҳ��ľ��ֵ��Ҳ���ǵ�һ��ҳ��ľ��ֵ
		String handle = driver.getWindowHandle();
		//System.out.println(handle2);
		for(String handles:driver.getWindowHandles()) {
			if(handles.equals(handle))
				continue;
			//������Ȩת������2������
			driver.switchTo().window(handles);
		}
		//����Ƽ�����
		driver.findElement(By.xpath("//*[text()='����']")).click();
		Thread.sleep(3000);
		//������Ȩת������1������
		driver.switchTo().window(handle);
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void ClosedBrower() {
		//�ر����д����˳�
		driver.quit();
	}
}
