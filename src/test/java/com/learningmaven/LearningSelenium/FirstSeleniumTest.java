package com.learningmaven.LearningSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		// basic setup to begin with selenium
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome Driver\\chromedriver.exe");

		// opens up the browser
		driver = new ChromeDriver();

		// load url on the browser that was open
		driver.get("https://www.quora.com/");

		// maximize the screen
		driver.manage().window().maximize();
	}

	@Test
	public void test1() {

		String titleOfThePage = driver.getTitle();
		System.out.println("The Title of the page is: " + titleOfThePage);
		Assert.assertEquals(titleOfThePage, "Quora - A place to share knowledge and better understand the world",
				"Title doesnt match");
	}

	@AfterMethod
	public void tearDown() {

		// close the browser
		driver.close();
	}
}
