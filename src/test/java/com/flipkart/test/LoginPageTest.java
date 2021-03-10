package com.flipkart.test;

import java.io.IOException;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.flipkart.Util.FlipkartTestUtil;
import com.flipkart.base.FlipkartTestBase;
import com.flipkart.pages.LoginPage;

public class LoginPageTest extends FlipkartTestBase{
	
	LoginPage	loginPage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		LaunchBrowser();
		loginPage = new LoginPage();
	}
	
	@Test
	public void CheckLoginPageTitle() {		
		String ActualTitle = loginPage.getTitle();
		System.out.println(ActualTitle);
		String ExpectedTitle = properties.getProperty("FlipkartTitle");
		Assert.assertEquals(ExpectedTitle, ActualTitle, "Login Page Title is displayed Incorrectly");
	}
	
	@Test
	public void Login() throws IOException {
		Map<String, String> map = FlipkartTestUtil.getFlipkartTestData();
		loginPage.Login(map.get("Email_Id"), map.get("Password"));
	}
	
	@AfterMethod
	public void TearDown() {
		//driver.quit();
	}
}
