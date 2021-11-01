package com.aspire.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImplicitlyWait {
	WebDriver driver;

	@BeforeMethod
	public void openChrome() {
		//����chromedriver·��
		System.setProperty("webdriver.chrome.driver", "I:\\����\\ѧϰ����\\Seliume+h5\\�������driver��\\chrome\\95.0.4638.17\\chromedriver.exe");
		//��chrome
		driver = new ChromeDriver();
		/*
		 * ��ʾ�ȴ�һ��д��driverʵ��������
		 * ������findElement��findElements����ʱ��������ָ����ʱ������Ѳĳ��Ԫ���Ƿ����
		 * ��Ԫ�س������������ִ�У������׳�NoSuchElementException���쳣
		 */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void selectTest() throws InterruptedException {
		//�򿪰ٶ�
		driver.get("https://www.baidu.com/");
		driver.findElement(By.xpath("//*[@id='s-top-left']/a[1]")).click();
		//��ȡ��ǰ���ڵľ��ֵ,��ʱ��ȡ���ľ��ֵ��ʵ�Ǵ򿪰ٶ�ҳ��ľ��ֵ��Ҳ���ǵ�һ��ҳ��ľ��ֵ
		String handle = driver.getWindowHandle();
		for(String handles:driver.getWindowHandles()) {
			if(handles.equals(handle))
				continue;
			//������Ȩת������2������
			driver.switchTo().window(handles);
		}
		//����Ƽ�����
		driver.findElement(By.xpath("//*[text()='����']")).click();
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