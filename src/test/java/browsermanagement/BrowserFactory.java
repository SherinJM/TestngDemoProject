package browsermanagement;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ThreadGuard;

import configurationManagement.ConfigurationReader;

public class BrowserFactory {

	protected static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static WebDriver startBrowser(String browserName, String url) throws Exception, Exception {

		if (browserName.contains("Chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver.set(new ChromeDriver(option));
		} else if (browserName.contains("FireFox")) {
			driver.set(new FirefoxDriver());
		} else if (browserName.contains("Edge")) {
			driver.set(new EdgeDriver());
		} else {
			System.out.println("Sorry, browser is not supported");
		}

		getDriver().manage().window().maximize();

		getDriver().manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(ConfigurationReader.getProperty("pagetimeout"))));
		getDriver().get(url);
		getDriver().manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigurationReader.getProperty("implicittimeout"))));

		return getDriver();

	}
}
