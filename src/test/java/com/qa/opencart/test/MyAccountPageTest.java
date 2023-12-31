package com.qa.opencart.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.opencart.Pages.HomePage;
import com.qa.opencart.Pages.LoginPage;
import com.qa.opencart.Pages.MyAccountPage;
import com.qa.opencart.Pages.SearchPage;
import com.qa.opencart.base.BaseClass;

public class MyAccountPageTest extends BaseClass {
	HomePage hp;
	LoginPage lp;
	MyAccountPage map;
	SearchPage sp;

	public MyAccountPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		log.info("Launched Browser");
		hp = new HomePage();
		hp.clickMyAccount();
		log.info("Clicked My Account Button");
		hp.clickLogin();
		log.info("Clicked Login Button");
		lp = new LoginPage();
		map = lp.Login(p.getProperty("Email"), p.getProperty("Password"));
		log.info("Entered Email and Password");
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void verifyPageTitleTest() {
		Assert.assertEquals(map.myAccountPageTitle(), "My Account");
	}

	@Test(priority = 2)
	public void verifySearchContent() throws InterruptedException, IOException {
		sp = map.searchContent(p.getProperty("SearchContent"));
		log.info("Clicked and entered Search Option");
	}

	@Test(priority = 3)
	public void verifyMyAccountPageLogoTest() {
		Assert.assertTrue(map.logo());
	}

	@AfterMethod
	public void tearDown() {
		driverQuit();
		log.info("Exit Browser");
	}
}
