package com.flipkart.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.FlipkartTestBase;

public class ProductPage extends FlipkartTestBase{

	@FindBy(xpath="//button[@type='button']")
	WebElement BuyNowButton;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public PlaceOrderPage BuyProduct() {
		String parentwindowhandle = driver.getWindowHandle();
	    System.out.println("parent window name: "+parentwindowhandle);
	    Set<String> newwindowname = driver.getWindowHandles();
	      if(driver.getWindowHandles().size()>0) {
	    	  System.out.println("Searched Product is sucessfully launched in new tab");
	      }else{
	    	  System.out.println("Failed to search product");
	      }
	      Iterator<String> I1= newwindowname.iterator();
	      while(I1.hasNext())
	      {
	    	  String child_window=I1.next();
	    	  if(!parentwindowhandle.equals(child_window)){
	    		  driver.switchTo().window(child_window);
	    		  System.out.println(driver.switchTo().window(child_window).getTitle());
	    	  }
	      }

		BuyNowButton.click();	
		return new PlaceOrderPage();
		
	}	
}
