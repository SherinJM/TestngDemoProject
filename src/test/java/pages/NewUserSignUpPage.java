package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.HelperClass;

public class NewUserSignUpPage {

	public WebDriver driver;

	public NewUserSignUpPage(WebDriver driver) {
		this.driver = driver;
	}

	By txt_userName = By.xpath("//input[@id='name']");
	By txt_email = By.xpath("//input[@id='email']");
	By txt_password = By.xpath("//input[@id='password']");
	By chkbx_interests = By.xpath("//div[@class='interests-div']//div//label");
	By radio_gender = By.xpath("//input[@value='Male']");
	By radio_gender_list = By.xpath("//input[@name='gender']");
	By drpdwn_state = By.xpath("//select[@id='state']");
	By drpdwn_hobbies = By.xpath("//select[@id='hobbies']");
	By btn_SignUp = By.xpath("//button[contains(text(),'Sign')]");

	public void enterUserName() {
		HelperClass.waitForElement(driver, txt_userName);
		driver.findElement(txt_userName).sendKeys("Mathew");
	}

	public void enterEmail() {
		HelperClass.waitForElement(driver, txt_email);
		driver.findElement(txt_email).sendKeys("mathew1@email.com");
	}

	public void enterPassword() {
		HelperClass.waitForElement(driver, txt_password);
		driver.findElement(txt_password).sendKeys("password");
	}

	public void selectInterests() {
		List<WebElement> interests = driver.findElements(chkbx_interests);
		for (WebElement element : interests) {
			if (element.getText().contains("Automation")) {
				element.click();
				break;
			}
		}
	}

	public void selectGender() {

		List<WebElement> gender = driver.findElements(radio_gender_list);

		for (WebElement element : gender) {
			String genderName = element.getAttribute("value");
			System.out.println("Gender is: " + genderName);
			if (genderName.contains("Male")) {
				element.click();
				break;
			}
		}
	}

	public void selectState() throws Exception {
		Select select = new Select(driver.findElement(drpdwn_state));
		List<WebElement> element = select.getOptions();
		for (WebElement ele : element) {
			if (ele.getText().contains("Kerala")) {
				ele.click();
				break;
			}
		}
	}

	public void selectHobbies() {
		Select select = new Select(driver.findElement(drpdwn_hobbies));
		List<WebElement> element = select.getOptions();
		for (WebElement ele : element) {
			if (ele.getText().contains("Reading")) {
				ele.click();
				break;
			}
		}
	}

	public void clickSignUp() {

		boolean bol = HelperClass.isClicked(driver, btn_SignUp);

		if (bol == true) {
			System.out.println("Clicked in the first attempt");
		} else {
			HelperClass.javaExecuter(driver, btn_SignUp);
			System.out.println("Clicked in the Second attempt");
		}

	}
}
