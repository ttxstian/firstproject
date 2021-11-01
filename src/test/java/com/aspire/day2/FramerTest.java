package com.aspire.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramerTest {
	WebDriver driver;
	
	@BeforeMethod
	public void openChrome() {
		//����chromedriver·��
		System.setProperty("webdriver.chrome.driver", "I:\\����\\ѧϰ����\\Seliume+h5\\�������driver��\\chrome\\95.0.4638.17\\chromedriver.exe");
		//��chrome
		driver = new ChromeDriver();
	}
	@Test
	public void FrameTest() throws InterruptedException {
		//�򿪰ٶ�
		driver.get("https://www.baidu.com/");
		//����3�ַ�ʽת������Ȩ��iframe
		//ͨ��id��nameת������Ȩ
		driver.switchTo().frame("id");
		driver.switchTo().frame("kb");
		//ͨ��Ԫ�ض�λ�ķ�ʽת������Ȩ,�ȶ�λ��iframe���Ԫ��
		WebElement iframeEle1 = driver.findElement(By.tagName("aaaaaa"));
		driver.switchTo().frame(iframeEle1);
		//���Ƕ�׵�iframeת������Ȩ��
		WebElement iframeEle2 = driver.findElement(By.tagName("bbbbb"));
		driver.switchTo().frame(iframeEle2);
		//������Ȩ������һ��frame
		driver.switchTo().parentFrame();
		//������Ȩ��������frame
		driver.switchTo().defaultContent();
	}
}
