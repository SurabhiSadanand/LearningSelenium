package com.learningmaven.LearningSelenium;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignupAndPurchase {

	WebDriver driver;
	// instantiate the action class
	Actions ac;
	String email = "";

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		ac = new Actions(driver);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@Test
	public void signUp() {

		WebElement firstNameInputField = driver.findElement(By.cssSelector("#input-firstname"));
		firstNameInputField.sendKeys("Surabhi");

		WebElement lastNameInputField = driver.findElement(By.cssSelector("#input-lastname"));
		lastNameInputField.sendKeys("Sadanand");

		WebElement emailInputField = driver.findElement(By.cssSelector("#input-email"));
		email = randomEmailGenerator();
		emailInputField.sendKeys(email);

		WebElement telephoneInputField = driver.findElement(By.cssSelector("#input-telephone"));
		telephoneInputField.sendKeys("4372198016");

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
		sleep();

		WebElement accountCreatedMessage = driver.findElement(By.cssSelector("#content h1"));
		String accountSuccessCreatedMessage = accountCreatedMessage.getText();
		Assert.assertEquals(accountSuccessCreatedMessage, "Your Account Has Been Created!", "Message doesnot match");
		sleep();

		driver.findElement(By.cssSelector(" div.list-group a:nth-of-type(13)")).click();
		sleep();

		driver.findElement(By.cssSelector(" div.list-group a:nth-of-type(1)")).click();
		sleep();

		WebElement emailIdInputField = driver.findElement(By.cssSelector("#input-email"));
		emailIdInputField.sendKeys(email);

		WebElement passwrdInputField = driver.findElement(By.cssSelector("#input-password"));
		passwrdInputField.sendKeys("testPassword");

		WebElement loginBTN = driver.findElement(By.cssSelector("input.btn"));
		loginBTN.submit();
		sleep();

		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		sleep();

		WebElement desktopProducts = driver.findElement(By.cssSelector("ul.nav.navbar-nav>li:nth-of-type(1) a"));
		desktopProducts.click();
		sleep();

		WebElement macDesktop = driver.findElement(By.cssSelector("ul.list-unstyled li:nth-of-type(2) a"));
		macDesktop.click();
		sleep();

		WebElement addToCartBtn = driver.findElement(By.cssSelector("div.button-group button:first-of-type"));
		addToCartBtn.click();
		sleep();

		WebElement cartBtn = driver.findElement(By.cssSelector("#cart button"));
		cartBtn.click();
		sleep();

		WebElement checkoutBtn = driver.findElement(By.cssSelector("p.text-right a:nth-of-type(2) strong"));
		checkoutBtn.click();
		sleep();

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

		Select sc = new Select(driver.findElement(By.cssSelector("#input-payment-country")));
		sc.selectByVisibleText("Canada");

		Select s = new Select(driver.findElement(By.cssSelector("#input-payment-zone")));
		s.selectByVisibleText("Ontario");

		WebElement continueBtn1 = driver.findElement(By.cssSelector("div.buttons input"));
		continueBtn1.click();
		sleep();

		WebElement continueBtn2 = driver.findElement(By.cssSelector("input#button-shipping-address"));
		continueBtn2.click();
		sleep();

		WebElement continueBtn3 = driver.findElement(By.cssSelector("input#button-shipping-method"));
		continueBtn3.click();
		sleep();

		WebElement termsAgreeBtn = driver.findElement(By.cssSelector(
				"div.panel-group>div:nth-of-type(5)>div:nth-of-type(2)>div>div.buttons div.pull-right input:nth-of-type(1)"));
		termsAgreeBtn.click();
		sleep();

		WebElement continueBtn4 = driver.findElement(By.cssSelector("div.pull-right #button-payment-method"));
		continueBtn4.click();
		sleep();

		WebElement confirmOrderBtn = driver.findElement(By.cssSelector("#button-confirm"));
		confirmOrderBtn.click();
		sleep();

		WebElement orderPlacedSuccessMessage = driver.findElement(By.cssSelector("#content h1"));
		String orderPlacedmessage = orderPlacedSuccessMessage.getText();
		Assert.assertEquals(orderPlacedmessage, "Your order has been placed!", "Message does not match");
		sleep();

		WebElement continueBtn5 = driver.findElement(By.cssSelector("a.btn"));
		continueBtn5.click();
		sleep();

		WebElement myAccountBtn = driver.findElement(By.cssSelector("li.dropdown span"));
		myAccountBtn.click();
		sleep();

		WebElement LogoutBtn = driver.findElement(By.cssSelector("ul.dropdown-menu-right li:nth-of-type(5) a"));
		LogoutBtn.click();
		sleep();

		WebElement logOutElement = driver.findElement(By.cssSelector("div#content h1"));
		String logOutMessage = logOutElement.getText();
		Assert.assertEquals(logOutMessage, "Account Logout", "Message does not match");
		sleep();

	}

	public String randomEmailGenerator() {

		Random random = new Random();
		int randomNumber = random.nextInt(100);
		String email = "username" + randomNumber + "@gmail.com";
		return email;
	}

	@AfterMethod
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
