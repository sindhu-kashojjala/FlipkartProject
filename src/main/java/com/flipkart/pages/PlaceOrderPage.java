package com.flipkart.pages;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.Util.FlipkartTestUtil;
import com.flipkart.base.FlipkartTestBase;

public class PlaceOrderPage extends FlipkartTestBase{
	
	@FindBy(xpath="//button[contains(text(),'CONTINUE')]")
	WebElement ContinueBtn;
	
	//@FindBy(xpath="//div[contains(text(),'Credit / Debit / ATM Card')]")
	@FindBy(xpath="//button[contains(text(),'CONTINUE')]")
	WebElement Paymentmode;
	
	@FindBy(xpath="//input[@name='cardNumber']")
	WebElement AccNum;
	
	@FindBy(xpath="//span[contains(text(),'Not a valid card number')]")
	WebElement Errmsg;
	
	public PlaceOrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String ProceedtoPay(String accnum) throws IOException {
		ContinueBtn.click();
		Paymentmode.click();
		Map<String, String> map = FlipkartTestUtil.getFlipkartTestData();
		AccNum.sendKeys(map.get("AccountNumber"));
		return Errmsg.getText();
	}

}
