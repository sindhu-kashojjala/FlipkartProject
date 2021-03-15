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
import com.flipkart.pages.ProductPage;
import com.flipkart.pages.SearchPage;

public class ProductPageTest extends FlipkartTestBase{

	HomePage homePage;
	LoginPage loginPage;
	SearchPage searchPage;
	ProductPage productPage;
	
	public ProductPageTest() {
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
	}
	
	@Test
	public void ProductPageTitle() {		
		String ActualTitle = productPage.getTitle();
		System.out.println(ActualTitle);
		String ExpectedTitle = properties.getProperty("ProductPageTitle");
		Assert.assertEquals(ExpectedTitle, ActualTitle, "Product Page Title is displayed Incorrectly");
	}
	
	@Test
	public void PurchaseProduct() {
		productPage.BuyProduct();
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}


}
