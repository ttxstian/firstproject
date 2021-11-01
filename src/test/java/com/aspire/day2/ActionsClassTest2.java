package com.aspire.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClassTest2 {
	WebDriver driver;

	@BeforeMethod
	public void openChrome() {
		//����chromedriver·��
		System.setProperty("webdriver.chrome.driver", "I:\\����\\ѧϰ����\\Seliume+h5\\�������driver��\\chrome\\92.0.4515.43\\chromedriver.exe");
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
	public void eleDragTest() throws InterruptedException {
		//�򿪰ٶ�
		driver.get("https://www.baidu.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		WebElement eleDrag1 = driver.findElement(By.id("s-usersetting-top"));
		WebElement eleDrag2 = driver.findElement(By.id("s-usersetting-top1"));
		//ʹ��Actions��֮ǰ��Ҫ��ʵ����
		Actions action = new Actions(driver);
		//��Ԫ����ק��x500,y500��λ��
		action.dragAndDropBy(eleDrag1, 500, 500).perform();
		Thread.sleep(3000);
		
		
		/*
		 * ��Ԫ��eleDrag1��ק��Ԫ��eleDrag2�ϣ���������Ϊ��
		 * clickAndHold(eleDrag1)����סԪ��1
		 * moveToElement(eleDrag2)���϶���Ԫ��2��
		 * release(eleDrag2)���ͷ�Ԫ��2
		 */		
		action.clickAndHold(eleDrag1).moveToElement(eleDrag2).release(eleDrag2).perform();
		Thread.sleep(3000);
		//���ҵ���ǩ��Ϊselect��Ԫ��
		WebElement select = driver.findElement(By.id("aaa"));
		//�ٻ�ȡ�б������ѡ��ŵ�һ�������У�List��
		List<WebElement> options = select.findElements(By.tagName("bbbb"));
		/*
		 * ��ס���̵�shift���󣬵���б��еĵ�1���͵�3��ѡ�ѡ��1��2��3��3��ѡ��
		 * keyDown(Keys.SHIFT)����ס���̵�shift��
		 * click(options.get(0))������б��еĵ�1��ѡ��
		 * click(options.get(2))������б��еĵ�3��ѡ��
		 */
		action.keyDown(Keys.SHIFT).click(options.get(0)).click(options.get(2)).perform();		
	}
	
	@AfterMethod
	public void ClosedBrower() {
		//�ر����д����˳�
		driver.quit();
	}
}