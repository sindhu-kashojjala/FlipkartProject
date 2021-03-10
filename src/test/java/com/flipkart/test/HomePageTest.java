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

public class HomePageTest extends FlipkartTestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() throws IOException {
		LaunchBrowser();
		loginPage = new LoginPage();
		Map<String, String> map = FlipkartTestUtil.getFlipkartTestData();
		homePage = loginPage.Login(map.get("Email_Id"), map.get("Password"));
	}
	
	@Test
	public void HomePageTitle() {		
		String ActualTitle = homePage.getTitle();
		System.out.println(ActualTitle);
		String ExpectedTitle = properties.getProperty("FlipkartTitle");
		Assert.assertEquals(ExpectedTitle, ActualTitle, "Home Page Title is displayed Incorrectly");
	}
	
	@Test
	public void VerifyUserId() {
		String User_Id = homePage.getUserId();
		System.out.println(User_Id);
		Assert.assertEquals(User_Id, properties.getProperty("UserId"));
		
	}
	
	@Test
	public void SearchProduct() throws IOException {
		Map<String, String> map = FlipkartTestUtil.getFlipkartTestData();
		homePage.SearchProduct(map.get("ProductName"));
	}
	
	@AfterMethod
	public void TearDown() {
		//driver.quit();
	}
	
}
