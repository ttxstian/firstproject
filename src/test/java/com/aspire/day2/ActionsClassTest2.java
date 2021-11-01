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
		//设置chromedriver路径
		System.setProperty("webdriver.chrome.driver", "I:\\桌面\\学习资料\\Seliume+h5\\浏览器的driver包\\chrome\\92.0.4515.43\\chromedriver.exe");
		//打开chrome
		driver = new ChromeDriver();
		/*
		 * 显示等待一般写在driver实例化后面
		 * 当遇到findElement或findElements方法时，它会在指定的时间内轮巡某个元素是否出现
		 * 若元素出现则继续往下执行，否则抛出NoSuchElementException的异常
		 */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void eleDragTest() throws InterruptedException {
		//打开百度
		driver.get("https://www.baidu.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		WebElement eleDrag1 = driver.findElement(By.id("s-usersetting-top"));
		WebElement eleDrag2 = driver.findElement(By.id("s-usersetting-top1"));
		//使用Actions类之前需要先实例化
		Actions action = new Actions(driver);
		//将元素拖拽到x500,y500的位置
		action.dragAndDropBy(eleDrag1, 500, 500).perform();
		Thread.sleep(3000);
		
		
		/*
		 * 把元素eleDrag1拖拽到元素eleDrag2上，动作依次为：
		 * clickAndHold(eleDrag1)：按住元素1
		 * moveToElement(eleDrag2)：拖动到元素2上
		 * release(eleDrag2)：释放元素2
		 */		
		action.clickAndHold(eleDrag1).moveToElement(eleDrag2).release(eleDrag2).perform();
		Thread.sleep(3000);
		//先找到标签名为select的元素
		WebElement select = driver.findElement(By.id("aaa"));
		//再获取列表的所有选项，放到一个集合中（List）
		List<WebElement> options = select.findElements(By.tagName("bbbb"));
		/*
		 * 按住键盘的shift键后，点击列表中的第1个和第3个选项，选中1、2、3这3个选项
		 * keyDown(Keys.SHIFT)：按住键盘的shift键
		 * click(options.get(0))：点击列表中的第1个选项
		 * click(options.get(2))：点击列表中的第3个选项
		 */
		action.keyDown(Keys.SHIFT).click(options.get(0)).click(options.get(2)).perform();		
	}
	
	@AfterMethod
	public void ClosedBrower() {
		//关闭所有窗口退出
		driver.quit();
	}
}