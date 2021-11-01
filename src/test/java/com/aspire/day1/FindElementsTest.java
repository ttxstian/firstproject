package com.aspire.day1;



import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindElementsTest {
	WebDriver driver;
	
	@BeforeMethod
	public void openChrome() {
		//����chromedriver·��
		System.setProperty("webdriver.chrome.driver", "I:\\����\\ѧϰ����\\Seliume+h5\\�������driver��\\chrome\\95.0.4638.17\\chromedriver.exe");
		//��chrome
		driver = new ChromeDriver();
	}
	
	@Test
	public void findElementsTest() throws InterruptedException {
		//�򿪰ٶ�
		driver.get("https://www.baidu.com/");
		//ͨ��id����Ԫ��
		WebElement byIdKeys = driver.findElement(By.name("wd"));
		byIdKeys.sendKeys("���");
		Thread.sleep(2000);
		//ͨ��name����Ԫ��
		WebElement byNameKeys = driver.findElement(By.id("su"));
		byNameKeys.click();
		Thread.sleep(3000);
		//ͨ��classname����Ԫ��
		WebElement byClassNameKeys = driver.findElement(By.className("s_ipt"));
		byClassNameKeys.sendKeys("Selenium");
		Thread.sleep(2000);
		//ͨ��linkText����Ԫ��,ͨ��partialLinkText�������ı�����ʽһ�����˴���
		WebElement byLinkTextKeys = driver.findElement(By.linkText("����"));
		byLinkTextKeys.click();
		Thread.sleep(2000);		
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		//ͨ��tagName����Ԫ��
		List<WebElement> byTagNameKeys = driver.findElements(By.tagName("input"));
		System.out.println(byTagNameKeys.size());
		//ͨ��Xpath����Ԫ��
		List<WebElement> byXpathKeys = driver.findElements(By.xpath("//*[@id='s-top-left']/a"));
		for(int i=0 ; i < byXpathKeys.size() ; i++) {
			System.out.println(byXpathKeys.get(i).getText());
		}
	}
	
	@AfterMethod
	public void ClosedBrower() {
		//�ر����д����˳�
		driver.quit();
	}

}