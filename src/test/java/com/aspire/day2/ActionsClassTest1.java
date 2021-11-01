package com.aspire.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClassTest1 {
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
	public void eleMoveToElementTest() throws InterruptedException {
		//�򿪰ٶ�
		driver.get("https://www.baidu.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		WebElement eleMoveToElement = driver.findElement(By.id("s-usersetting-top"));
		//ʹ��Actions��֮ǰ��Ҫ��ʵ����
		Actions action = new Actions(driver);
		//moveToElement��������ʾ������ƶ���ĳ��Ԫ����
		action.moveToElement(eleMoveToElement).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='��������']")).click();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void ClosedBrower() {
		//�ر����д����˳�
		driver.quit();
	}
	
}
