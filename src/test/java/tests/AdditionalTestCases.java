package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class AdditionalTestCases extends BaseClass {

	@Test(priority = 0)
	public void validateCountOfButtons() throws Exception {
		lp = new LoginPage(driver);
		int no = lp.countOfButtons();
		Assert.assertEquals(12, no, "Size is not matching");
	}

	@Test(priority = 1)
	public void validateBrokenLinks() throws Exception {
		lp = new LoginPage(driver);
		lp.brokenLinks();
	}

}
