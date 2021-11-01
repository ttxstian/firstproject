package com.aspire.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverWaitTest {
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
		/*��ʾ�ȴ�����Ҫ��ʵ����һ��WebDriverWait���࣬Ȼ���������������until����
		until�����ﴫһ����λԪ�صķ��������ҵ����������ִ�У���δ�ȵ����Ԫ�ػᱨTimeoutException�쳣
		*/
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='s-top-left']/a[1]")));
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='����']")));
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

