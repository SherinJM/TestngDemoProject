package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.NewUserSignUpPage;

public class NewTestCases extends BaseClass {
	@Test(priority = 0)
	public void signUpTest() throws Exception {
		lp = new LoginPage(driver);
		Thread.sleep(5000);
		lp.clickSignUp();
		sp = new NewUserSignUpPage(driver);
		sp.enterUserName();
		Thread.sleep(1000);
		sp.enterEmail();
		Thread.sleep(1000);
		sp.enterPassword();
		Thread.sleep(1000);
		sp.selectInterests();
		Thread.sleep(1000);
		sp.selectGender();
		Thread.sleep(1000);
		sp.selectState();
		Thread.sleep(1000);
		sp.selectHobbies();
		Thread.sleep(1000);		
		sp.clickSignUp();
	}
}
