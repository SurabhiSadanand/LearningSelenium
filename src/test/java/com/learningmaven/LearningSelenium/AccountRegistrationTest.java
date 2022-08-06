package com.learningmaven.LearningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountRegistrationTest {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome Driver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		driver.manage().window().maximize();

	}

	@Test
	public void sendKeysTest() {

		WebElement firstNameInputField = driver.findElement(By.cssSelector("#input-firstname"));
		firstNameInputField.sendKeys("Surabhi");

		WebElement lastNameInputField = driver.findElement(By.cssSelector("#input-lastname"));
		lastNameInputField.sendKeys("Sadanand");

		WebElement emailInputField = driver.findElement(By.cssSelector("#input-email"));
		emailInputField.sendKeys("surabhisadanand92@gmail.com");

		WebElement telephoneInputField = driver.findElement(By.cssSelector("#input-telephone"));
		telephoneInputField.sendKeys("4372198016");

		WebElement passwordInputField = driver
				.findElement(By.cssSelector("fieldset:nth-of-type(2)>div:nth-of-type(1) input"));
		passwordInputField.sendKeys("testPassword");

		WebElement confirmPasswordInputField = driver
				.findElement(By.cssSelector("fieldset:nth-of-type(2)>div:nth-of-type(2) input"));
		confirmPasswordInputField.sendKeys("testPassword");

		WebElement continueBtn = driver.findElement(By.cssSelector("div.buttons input:nth-of-type(2)"));
		continueBtn.click();

		WebElement alert = driver.findElement(By.cssSelector("div#account-register>div:first-of-type"));
		String alertText = alert.getText();
		Assert.assertEquals(alertText, "Warning: You must agree to the Privacy Policy!", "Not a match!!!!!!!!");

	}

	public void tearDown() {

		driver.close();
	}

}
