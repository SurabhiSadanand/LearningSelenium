package com.learningmaven.LearningSelenium;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EdgeSignupAndPurchase {

	WebDriver driver;
	String email;

	@BeforeMethod(enabled = true)
	public void setup() {
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\Edge Driver\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void signUpTest() {

		WebElement firstNameInputField = driver.findElement(By.cssSelector("#input-firstname"));
		firstNameInputField.sendKeys("Surabhi");

		WebElement lastNameInputField = driver.findElement(By.cssSelector("#input-lastname"));
		lastNameInputField.sendKeys("Sadanand");

		Random rnd = new Random();

		int ranNumber = rnd.nextInt(1500);
		email = "user" + ranNumber + "@gmail.com";

		WebElement emailInputField = driver.findElement(By.cssSelector("#input-email"));
		emailInputField.sendKeys(email);

		WebElement telephoneInputField = driver.findElement(By.cssSelector("#input-telephone"));
		telephoneInputField.sendKeys("8872198016");

		WebElement passwordInputField = driver
				.findElement(By.cssSelector("fieldset:nth-of-type(2)>div:nth-of-type(1) input"));
		passwordInputField.sendKeys("testPassword");

		WebElement confirmPasswordInputField = driver
				.findElement(By.cssSelector("fieldset:nth-of-type(2)>div:nth-of-type(2) input"));
		confirmPasswordInputField.sendKeys("testPassword");
		WebElement privacyPolicyLink = driver.findElement(By.cssSelector("div.buttons input:first-of-type"));
		privacyPolicyLink.click();

		WebElement continueBtn = driver.findElement(By.cssSelector("div.buttons input:nth-of-type(2)"));
		continueBtn.click();

		WebElement accountCreatedMessage = driver.findElement(By.cssSelector("#content h1"));
		sleep();
		String accountSuccessCreatedMessage = accountCreatedMessage.getText();
		Assert.assertEquals(accountSuccessCreatedMessage, "Your Account Has Been Created!",
				"Unable to register account,Try again!!");
	}

	@Test(priority = 2)
	public void loginAndPurchaseTest() {
		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		WebElement emailIdInputField = driver.findElement(By.cssSelector("div.well>form input"));
		emailIdInputField.sendKeys(email);

		WebElement passwrdInputField = driver.findElement(By.cssSelector("div.well>form div:nth-of-type(2) input"));
		passwrdInputField.sendKeys("testPassword");

		WebElement loginBTN = driver.findElement(By.cssSelector("input.btn"));
		loginBTN.submit();

		WebElement desktopProducts = driver.findElement(By.cssSelector("ul.nav.navbar-nav>li:nth-of-type(1) a"));
		desktopProducts.click();

		WebElement macDesktop = driver.findElement(By.cssSelector("ul.list-unstyled li:nth-of-type(2) a"));
		macDesktop.click();

		WebElement addToCartBtn = driver.findElement(By.cssSelector("div.button-group button:first-of-type"));
		addToCartBtn.click();

		WebElement cartBtn = driver
				.findElement(By.cssSelector("header div.container div.row div.col-sm-3 button.btn.btn-inverse"));
		cartBtn.click();

		WebElement checkoutBtn = driver.findElement(By.cssSelector("ul.list-inline>li:nth-of-type(5) span"));
		checkoutBtn.click();

		WebElement fnameInputField = driver.findElement(By.cssSelector("#input-payment-firstname"));
		fnameInputField.sendKeys("Surabhi");

		WebElement lnameInputField = driver.findElement(By.cssSelector("#input-payment-lastname"));
		lnameInputField.sendKeys("Sadanand");

		WebElement companyInputField = driver.findElement(By.cssSelector("#input-payment-company"));
		companyInputField.sendKeys("ABC Company");

		WebElement address1InputField = driver.findElement(By.cssSelector("#input-payment-address-1"));
		address1InputField.sendKeys("22 Pine Valley Drive");

		WebElement cityInputField = driver.findElement(By.cssSelector("#input-payment-city"));
		cityInputField.sendKeys("St. Thomas");

		WebElement postCodeInputField = driver.findElement(By.cssSelector("#input-payment-postcode"));
		postCodeInputField.sendKeys("A1B2C3");

		WebElement countryField = driver.findElement(By.cssSelector("#input-payment-country"));
		select(countryField).selectByVisibleText("Canada");

		WebElement zoneField = driver.findElement(By.cssSelector("#input-payment-zone"));
		select(zoneField).selectByVisibleText("Ontario");

		WebElement continueBtn1 = driver.findElement(By.cssSelector("div.buttons input"));
		continueBtn1.click();

		WebElement continueBtn2 = driver.findElement(By.cssSelector("input#button-shipping-address"));
		continueBtn2.click();

		WebElement continueBtn3 = driver.findElement(By.cssSelector("input#button-shipping-method"));
		continueBtn3.click();

		WebElement termsAgreeBtn = driver.findElement(By.cssSelector(
				"div.panel-group>div:nth-of-type(5)>div:nth-of-type(2)>div>div.buttons div.pull-right input:nth-of-type(1)"));
		termsAgreeBtn.click();

		WebElement continueBtn4 = driver.findElement(By.cssSelector("div.pull-right #button-payment-method"));
		continueBtn4.click();

		WebElement confirmOrderBtn = driver
				.findElement(By.cssSelector("div#collapse-checkout-confirm div.panel-body>div:nth-of-type(2) input"));
		confirmOrderBtn.click();

		sleep();
		WebElement orderPlacedSuccessMessage = driver.findElement(By.cssSelector("#content h1"));

		WebElement orderPlacedMessageElement = driver.findElement(By.cssSelector("div#content h1"));
		String messagePlacedText = orderPlacedMessageElement.getText();
		Assert.assertEquals(messagePlacedText, "Your order has been placed!", "Message not matching");

		driver.findElement(By.cssSelector("ul.list-inline li.dropdown span:nth-of-type(1)")).click();
		driver.findElement(By.cssSelector("ul.dropdown-menu.dropdown-menu-right>li:nth-of-type(5) a")).click();

		WebElement logOutMessageElement = driver.findElement(By.cssSelector("div#content h1"));
		String logOutMessage = logOutMessageElement.getText();
		System.out.println(logOutMessage);
		Assert.assertEquals(logOutMessage, "Account Logout", "Unable to succesfully logout!!");
	}

	public Select select(WebElement element) {

		Select sc = new Select(element);
		return sc;
	}

	@AfterMethod(enabled = true)
	public void tearDown() {
		driver.close();
	}

	public void sleep() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
