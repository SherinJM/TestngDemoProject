package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class AdditionalTestCases extends BaseClass {

	@Test
	public void validateBrokenLinks() throws Exception {
		System.out.println(Thread.currentThread().getId());
		lp = new LoginPage(driver);
		System.out.println("Driver value :" + driver);
		lp.brokenLinks();
		
	}

	@Test
	public void validateCountOfButtons() throws Exception {
		System.out.println(Thread.currentThread().getId());
		lp = new LoginPage(driver);
		System.out.println("Driver value :" + driver);
		int no = lp.countOfButtons();
		System.out.println("size is "+no);
		Assert.assertEquals(12, no, "Size is not matching");
	}

	@Test
	public void validateSample() throws Exception {
		System.out.println(Thread.currentThread().getId());
		lp = new LoginPage(driver);
		String pas = "password";
		lp.enterPassword(pas);
		String password = "password";
		Assert.assertEquals(password, pas);
	}

}
