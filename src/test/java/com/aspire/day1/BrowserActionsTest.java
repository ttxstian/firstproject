package com.aspire.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserActionsTest {
	WebDriver driver;
	
	@BeforeMethod
	public void openChrome() {
		//����chromedriver·��
		System.setProperty("webdriver.chrome.driver", "I:\\����\\ѧϰ����\\Seliume+h5\\�������driver��\\chrome\\95.0.4638.17\\chromedriver.exe");
		//��chrome
		driver = new ChromeDriver();
	}
	
	@Test
	public void closedChrome() throws InterruptedException {
		//�򿪰ٶ�
		driver.get("https://www.baidu.com");
		Thread.sleep(3000);
		//�������
		driver.manage().window().maximize();
		Thread.sleep(3000);		
		//ˢ��
		driver.navigate().refresh();
		Thread.sleep(3000);
		//����
		driver.navigate().back();
		Thread.sleep(3000);
		//ǰ��
		driver.navigate().forward();
		Thread.sleep(3000);
		//���ô��ڴ�С��ʵ����Dimension��
		Dimension dimension = new Dimension(300,300);
		driver.manage().window().setSize(dimension);
		Thread.sleep(3000);	
		String a = driver.getCurrentUrl();
		String b = "https://www.baidu.com/";
		System.out.println("��ȡ��URL�ǣ�"+a);
		System.out.println("Ԥ�ڵ�URL�ǣ�"+b);
		System.out.println("��ǰҳ��Title��"+driver.getTitle());
		Assert.assertEquals(a,b,"�򿪵���ַ����baidu");
	}
	
	@AfterMethod
	public void ClosedBrower() {
		//�ر����д����˳�
		driver.quit();
	}
}