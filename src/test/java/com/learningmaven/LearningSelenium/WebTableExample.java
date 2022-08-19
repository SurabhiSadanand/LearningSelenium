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
		System.setProperty("webdriver.chrome.driver", "C:\\\\Drivers\\\\Chrome Driver\\\\chromedriver.exe");

		// Creating Ref. variable and intialising with Chrome driver
		webDriver = new ChromeDriver();

		wait = new WebDriverWait(webDriver, 10);

		// Get the URL of the page0
		webDriver.get("https://www.nyse.com/index");

		// Maximise the browser
		webDriver.manage().window().maximize();

	}

	@Test
	public void webTableTest() {

		List<WebElement> noOfRows = webDriver.findElements(By.xpath("//table//tbody//tr"));
		List<WebElement> noOfColumns = webDriver.findElements(By.xpath("//table//thead//tr//th"));
		System.out.println("The number of rows: " + noOfRows.size());
		System.out.println("The number of columns: " + noOfColumns.size());

		String xpathBefore = "//table//tbody//tr[";
		String xpathAfter = "]//td[";

		for (int i = 1; i < noOfRows.size(); i++) {
			for (int j = 1; j < noOfColumns.size(); j++) {
				WebElement element = webDriver.findElement(By.xpath("//table//tbody//tr[" + i + "]//td[" + j + "]"));
				if (element.getText().equals("NYSE U.S. 100 INDEX")) {
					System.out.println("Found the entry");
				}

			}
		}

	}

	@AfterMethod
	public void tearDown() {
		webDriver.quit();
	}
}
