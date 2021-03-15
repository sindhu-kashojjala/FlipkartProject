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
import com.flipkart.pages.SearchPage;

public class SearchPageTest extends FlipkartTestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	SearchPage searchPage;
	
	public SearchPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() throws IOException {
		LaunchBrowser();
		loginPage = new LoginPage();
		Map<String, String> map = FlipkartTestUtil.getFlipkartTestData();
		homePage = loginPage.Login(map.get("Email_Id"), map.get("Password"));
		searchPage = homePage.SearchProduct(map.get("ProductName"));
	}
	
	@Test
	public void SearchPageTitle() {		
		String ActualTitle = homePage.getTitle();
		System.out.println(ActualTitle);
		String ExpectedTitle = properties.getProperty("FlipkartTitle");
		Assert.assertEquals(ExpectedTitle, ActualTitle, "Search Page Title is displayed Incorrectly");
	}
	
	@Test
	public void CheckProductCategory() {
		String productcategory = searchPage.CheckCategory();
		System.out.println(productcategory);
		Assert.assertEquals(productcategory, properties.getProperty("ProductCategory"));
	}
	
	@Test
	public void LaunchProduct(){
		searchPage.ClickProduct();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}


}
