package com.aspire.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProFilefirefox {
	WebDriver driver;

	@BeforeMethod
	public void openChrome() {
		//����firefoxdriver·��
		System.setProperty("webdriver.firefox.driver", "C:\\firefoxdriver.exe");		
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		//���û�µ�Ĭ�������ļ��У�0��ʾ���棬1��ʾ�ĵ����أ�2��ʾ�Զ����ļ���
		firefoxProfile.setPreference("browser.download.folderList", "2");
		//�����Զ����ļ��е�λ��		
		firefoxProfile.setPreference("browser.download.dir", "D:\\aaa");	
		//��������ȷ�����ص��ļ���ʽ
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream,application/vnd.ms-excel,test/zip,application/exe");
		//��һ��Ԥ�����õĻ�£�����ʦ�Ĵ��� ����д�ģ���������䱨����
		//driver = new FirefoxDriver(firefoxProfile);
	}
	
	@Test
	public void selectTest() throws InterruptedException {		
		//�򿪰ٶ�
		driver.get("https://www.baidu.com/");
	}
	
	@AfterMethod
	public void ClosedBrower() {
		//�ر����д����˳�
		driver.quit();
	}
}
