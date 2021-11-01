package com.aspire.day4;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POLogin {
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
	
	public void login(String username,String password,String code){
		//�򿪰ٶ�
		driver.get("https://117.161.4.158/sbss/#/login?redirect=%2Fbusiness%2Fenterprise-info");
		driver.manage().window().maximize();
		driver.findElement(POPageLogin.highLeverBtn).click();
		driver.findElement(POPageLogin.linkBtn).click();
		driver.findElement(POPageLogin.usernameText).sendKeys(username);
		driver.findElement(POPageLogin.passwordText).sendKeys(password);
		driver.findElement(POPageLogin.verificationCodeText).sendKeys(code);
		driver.findElement(POPageLogin.loginBtn).click();

	}
	public void enterNumber() throws InterruptedException {
		driver.findElement(POPageEnterNumber.businessOperationBtn).click();
		driver.findElement(POPageEnterNumber.enterNumBtn).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementsByClassName('el-input__inner')[10].removeAttribute('readonly')");
		List<WebElement> inputEle = driver.findElements(POPageEnterNumber.inputEles);
		inputEle.get(inputEle.size()-1).sendKeys("I:\\����\\�����ص�����\\���벹¼���� ���������\\test.xls");
		Thread.sleep(6000);
	}
	
	@Test
	public void enterRightNumber() throws InterruptedException {
		login("workadmin","iSpicc2021","0000");
		enterNumber();		
	}
	
	@AfterMethod
	public void ClosedBrower() {
		//�ر����д����˳�
		driver.quit();
	}
}
