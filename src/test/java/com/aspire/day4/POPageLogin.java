package com.aspire.day4;

import org.openqa.selenium.By;

public class POPageLogin {
	//����Ԫ�صĶ�λ��ʽ
	public static By highLeverBtn = By.id("details-button");
	public static By linkBtn = By.id("proceed-link");
	public static By usernameText = By.name("username");
	public static By passwordText = By.name("password");
	public static By verificationCodeText = By.xpath("//*[@placeholder='��������֤��']");
	public static By loginBtn = By.xpath("//*[@class='el-button el-button--primary']");
}
