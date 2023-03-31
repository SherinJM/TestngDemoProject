package browsermanagement;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static WebDriver driver;

	public static WebDriver startBrowser(String browserName, String url) {

		if (browserName.contains("Chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);
		} else if (browserName.contains("FireFox")) {
			driver = new FirefoxDriver();
		} else if (browserName.contains("Edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Sorry, browser is not supported");
		}
		System.out.println(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(url);

		return driver;

	}

}
