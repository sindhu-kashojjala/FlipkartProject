package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.FlipkartTestBase;

public class SearchPage extends FlipkartTestBase{
	
	@FindBy(xpath="//div[contains(text(),'Redmi 9 Prime (Sunrise Flare, 64 GB)')]")
	WebElement Product;
	
	@FindBy(xpath="//a[@title='Mobiles']")
	WebElement Category;
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String CheckCategory() {
		return Category.getText();
	}
	
	public ProductPage ClickProduct() {
		Product.click();	
		return new ProductPage();
		
	}

}
