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

public class ActionsClassTest {
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
		WebElement eleContextClick = driver.findElement(By.id("su"));
		//ʹ��Actions��֮ǰ��Ҫ��ʵ����
		Actions action = new Actions(driver);
		/*
		 * 1��contextClick��������ʾ�һ�������2��д������
		 * action.contextClick(ele).build().perform();
		 * action.contextClick(ele).perform();
		 * 2��contextClick���Դ��λ򲻴��Σ���������Ԫ�����һ�����������������ڵ�λ�����һ�
		 */
		action.contextClick(eleContextClick).perform();
		Thread.sleep(3000);
		
		WebElement eleDoubleClick = driver.findElement(By.xpath("//*[@id=\"lg\"]"));
		/*
		 * 1��doubleClick��������ʾ˫��������2��д������
		 * action.doubleClick(ele).build().perform();
		 * action.doubleClick(ele).perform();
		 * 2��doubleClick���Դ��λ򲻴��Σ���������Ԫ����˫������������������ڵ�λ����˫��
		 */
		action.doubleClick(eleDoubleClick).build().perform();
		Thread.sleep(3000);
		
	}
	
	@AfterMethod
	public void ClosedBrower() {
		//�ر����д����˳�
		driver.quit();
	}
}
