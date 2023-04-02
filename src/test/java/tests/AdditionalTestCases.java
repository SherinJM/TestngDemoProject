package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ManageCourses;
import pages.NewUserSignUpPage;

public class AdditionalTestCases extends BaseClass {
	
	public WebDriver driver=null;;
	public LoginPage lp;
	public DashboardPage db;
	public ManageCourses mc;
	public NewUserSignUpPage sp;

	@Test(groups = {"smoke"})
	public void validateBrokenLinks() throws Exception {
		System.out.println(Thread.currentThread().getId());
		lp = new LoginPage(driver);
		lp.brokenLinks();
	}

	@Test(groups = {"regression"})
	public void validateCountOfButtons() throws Exception {
		System.out.println(Thread.currentThread().getId());
		lp = new LoginPage(driver);
		int no = lp.countOfButtons();
		Assert.assertEquals(12, no, "Size is not matching");
	}

	@Test(groups = {"smoke"})
	public void validateSample() throws Exception {
		System.out.println(Thread.currentThread().getId());
		System.out.println("Sample");
		System.out.println(driver.getCurrentUrl());

	}

}
