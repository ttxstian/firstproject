package com.aspire.day3;

import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSOperate {
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
	public void eleDragTest() throws InterruptedException, AWTException {
		//�򿪰ٶ�
		driver.get("https://117.161.4.158/sbss/#/login?redirect=%2Fbusiness%2Fenterprise-info");
		driver.manage().window().maximize();
		driver.findElement(By.id("details-button")).click();;
		driver.findElement(By.id("proceed-link")).click();;
		driver.findElement(By.name("username")).sendKeys("workadmin");
		driver.findElement(By.name("password")).sendKeys("iSpicc2021");
		driver.findElement(By.xpath("//*[@placeholder='��������֤��']")).sendKeys("0000");
		driver.findElement(By.xpath("//*[@class='el-button el-button--primary']")).click();;
		driver.findElement(By.xpath("//*[text()='ҵ�����']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'��������¼')]")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementsByClassName('el-input__inner')[10].removeAttribute('readonly')");
		List<WebElement> inputEle = driver.findElements(By.className("el-input__inner"));
		inputEle.get(inputEle.size()-1).sendKeys("I:\\����\\�����ص�����\\���벹¼���� ���������\\test.xls");
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void ClosedBrower() {
		//�ر����д����˳�
		driver.quit();
	}
}
