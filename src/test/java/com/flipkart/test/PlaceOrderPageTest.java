package com.flipkart.test;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.Util.FlipkartTestUtil;
import com.flipkart.base.FlipkartTestBase;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.LoginPage;
import com.flipkart.pages.PlaceOrderPage;
import com.flipkart.pages.ProductPage;
import com.flipkart.pages.SearchPage;

public class PlaceOrderPageTest extends FlipkartTestBase{
	

	HomePage homePage;
	LoginPage loginPage;
	SearchPage searchPage;
	ProductPage productPage;
	PlaceOrderPage placeOrderPage;
	
	public PlaceOrderPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() throws IOException {
		LaunchBrowser();
		loginPage = new LoginPage();
		Map<String, String> map = FlipkartTestUtil.getFlipkartTestData();
		homePage = loginPage.Login(map.get("Email_Id"), map.get("Password"));
		searchPage = homePage.SearchProduct(map.get("ProductName"));
		productPage = searchPage.ClickProduct();
		placeOrderPage = productPage.BuyProduct();
	}
	
	@Test
	public void PaymentPageTitle() {		
		String ActualTitle = placeOrderPage.getTitle();
		System.out.println(ActualTitle);
		String ExpectedTitle = properties.getProperty("PaymentPageTitle");
		Assert.assertEquals(ExpectedTitle, ActualTitle, "Payment Page Title is displayed Incorrectly");
	}
	
	@Test
	public void OrderProduct() throws IOException {
		Map<String, String> map = FlipkartTestUtil.getFlipkartTestData();
		String ErrorMessage = placeOrderPage.ProceedtoPay(map.get("AccountNumber"));
		Assert.assertEquals(ErrorMessage, properties.getProperty("Errmessage"), "Error Message is not displayed for incorrect Card Details");
		
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}


}
