package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.FlipkartTestBase;

public class HomePage extends FlipkartTestBase{
	
	@FindBy(xpath="//div[contains(text(),'Sindhu')]")
	WebElement UserId;
	
	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	WebElement SearchBox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SearchBtn;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getUserId() {
		return UserId.getText();
	}
	
	public SearchPage SearchProduct(String product) {
		SearchBox.sendKeys(product);
		SearchBtn.click();
		return new SearchPage();
	}

}
