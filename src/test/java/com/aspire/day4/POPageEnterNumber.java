package com.aspire.day4;

import org.openqa.selenium.By;

public class POPageEnterNumber {
	//定义元素的定位方式
	public static By businessOperationBtn = By.xpath("//*[text()='业务操作']");
	public static By enterNumBtn = By.xpath("//span[contains(text(),'号码量补录')]");
	public static By inputEles = By.className("el-input__inner");
}
