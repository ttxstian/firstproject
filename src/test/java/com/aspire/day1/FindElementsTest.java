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
		//设置chromedriver路径
		System.setProperty("webdriver.chrome.driver", "I:\\桌面\\学习资料\\Seliume+h5\\浏览器的driver包\\chrome\\95.0.4638.17\\chromedriver.exe");
		//打开chrome
		driver = new ChromeDriver();
	}
	
	@Test
	public void findElementsTest() throws InterruptedException {
		//打开百度
		driver.get("https://www.baidu.com/");
		//通过id查找元素
		WebElement byIdKeys = driver.findElement(By.name("wd"));
		byIdKeys.sendKeys("你好");
		Thread.sleep(2000);
		//通过name查找元素
		WebElement byNameKeys = driver.findElement(By.id("su"));
		byNameKeys.click();
		Thread.sleep(3000);
		//通过classname查找元素
		WebElement byClassNameKeys = driver.findElement(By.className("s_ipt"));
		byClassNameKeys.sendKeys("Selenium");
		Thread.sleep(2000);
		//通过linkText查找元素,通过partialLinkText（部分文本）方式一样，此处略
		WebElement byLinkTextKeys = driver.findElement(By.linkText("更多"));
		byLinkTextKeys.click();
		Thread.sleep(2000);		
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		//通过tagName查找元素
		List<WebElement> byTagNameKeys = driver.findElements(By.tagName("input"));
		System.out.println(byTagNameKeys.size());
		//通过Xpath查找元素
		List<WebElement> byXpathKeys = driver.findElements(By.xpath("//*[@id='s-top-left']/a"));
		for(int i=0 ; i < byXpathKeys.size() ; i++) {
			System.out.println(byXpathKeys.get(i).getText());
		}
	}
	
	@AfterMethod
	public void ClosedBrower() {
		//关闭所有窗口退出
		driver.quit();
	}

}