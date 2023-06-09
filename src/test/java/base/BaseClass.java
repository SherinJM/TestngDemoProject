package base;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import browsermanagement.BrowserFactory;
import configurationManagement.ConfigurationReader;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ManageCourses;
import pages.NewUserSignUpPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public DashboardPage db;
	public ManageCourses mc;
	public NewUserSignUpPage sp;

	@BeforeMethod
	public void browserSetUp() throws Exception {
		System.out.println("Log:Info-Setting up browser...");
		driver = BrowserFactory.startBrowser(ConfigurationReader.getProperty("browser"),
				ConfigurationReader.getProperty("url"));
		System.out.println("Log:Info-Browser is set up...");
	}

	@AfterMethod
	public void tearDown() {

		System.out.println("Log:Info-Quitting browser...");
		driver.quit();		
		System.out.println("Log:Info-Browser is quit...");
	}
}
