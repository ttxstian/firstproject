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
		//设置chromedriver路径
		System.setProperty("webdriver.chrome.driver", "I:\\桌面\\学习资料\\Seliume+h5\\浏览器的driver包\\chrome\\95.0.4638.17\\chromedriver.exe");
		//打开chrome
		driver = new ChromeDriver();
		/*
		 * 显示等待一般写在driver实例化后面
		 * 当遇到findElement或findElements方法时，它会在指定的时间内轮巡某个元素是否出现
		 * 若元素出现则继续往下执行，否则抛出NoSuchElementException的异常
		 */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void login(String username,String password,String code){
		//打开百度
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
		inputEle.get(inputEle.size()-1).sendKeys("I:\\桌面\\近期重点需求\\号码补录功能 造测试数据\\test.xls");
		Thread.sleep(6000);
	}
	
	@Test
	public void enterRightNumber() throws InterruptedException {
		login("workadmin","iSpicc2021","0000");
		enterNumber();		
	}
	
	@AfterMethod
	public void ClosedBrower() {
		//关闭所有窗口退出
		driver.quit();
	}
}
