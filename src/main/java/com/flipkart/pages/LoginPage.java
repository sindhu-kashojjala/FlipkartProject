package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.FlipkartTestBase;

public class LoginPage extends FlipkartTestBase{
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement UserName;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement Password;
	
	@FindBy(xpath="(//span[contains(text(),'Login')])[2]")
	WebElement LoginBtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public HomePage Login(String uname, String pwd) {
		
		UserName.sendKeys(uname);
		Password.sendKeys(pwd);
		LoginBtn.click();
		return new HomePage();
		
	}

}
