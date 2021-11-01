package com.aspire.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest {
	WebDriver driver;

	@BeforeMethod
	public void openChrome() {
		//����chromedriver·��
		System.setProperty("webdriver.chrome.driver", "I:\\����\\ѧϰ����\\Seliume+h5\\�������driver��\\chrome\\92.0.4515.43\\chromedriver.exe");
		//��chrome
		driver = new ChromeDriver();
	}
	
	@Test
	public void selectTest() throws InterruptedException {
		//�򿪰ٶ�
		driver.get("https://www.baidu.com/");
		//�ȶ�λ��������Ԫ��
		WebElement selectEle = driver.findElement(By.id("dddd"));
		//ʵ����һ��select��
		Select select = new Select(selectEle);
		//ͨ��������ѡ��һ������ѡ�����ֵ ��0��ʼ
		select.selectByIndex(2);
		//ͨ��valueֵѡ��һ������ѡ��
		select.selectByValue("����");
		//ͨ���ı�ֵѡ��һ������ѡ��,ע���ı�ֵ������ʱ����һ�ѿո�Ҫ���Ͽո�
		select.selectByVisibleText("����");
	}
	
	@AfterMethod
	public void ClosedBrower() {
		//�ر����д����˳�
		driver.quit();
	}
}