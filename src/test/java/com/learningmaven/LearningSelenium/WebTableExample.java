package com.learningmaven.LearningSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTableExample {

	WebDriver webDriver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		// setting up the chrome driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome Driver\\chromedriver.exe");

		// Creating Ref. variable and intialising with Chrome driver
		webDriver = new ChromeDriver();

		wait = new WebDriverWait(webDriver, 10);

		webDriver.get("https://chercher.tech/practice/table");

		// Maximise the browser
		webDriver.manage().window().maximize();

	}

	@Test
	public void webTableTest() {

		List<WebElement> noOfRows = webDriver.findElements(By.xpath("//table[@id='webtable']//tbody//tr"));
		List<WebElement> noOfColumns = webDriver.findElements(By.xpath("//table[@id='webtable']//tbody//tr//th"));
		System.out.println("The number of rows: " + noOfRows.size());
		System.out.println("The number of columns: " + noOfColumns.size());

		String xpathBefore = "//table[@id='webtable']//tbody//tr[";
		String xpathAfter = "]//td[";

		for (int i = 2; i < noOfRows.size(); i++) {
			for (int j = 1; j < noOfColumns.size(); j++) {
				WebElement element = webDriver.findElement(By.xpath(xpathBefore + i + xpathAfter + j + "]"));
				if (element.getText().equals("Google")) {
					System.out.println("Found the entry Google in the table");
				}

			}
		}

	}

	@AfterMethod
	public void tearDown() {
		webDriver.quit();
	}
}
