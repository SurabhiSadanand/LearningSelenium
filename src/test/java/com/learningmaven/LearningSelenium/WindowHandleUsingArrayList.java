package com.learningmaven.LearningSelenium;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandleUsingArrayList {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome Driver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://demoqa.com/browser-windows");

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void windowHandleTest() {

		String parentWindowHandle = driver.getWindowHandle();

		System.out.println("Parent Handle:" + parentWindowHandle);

		// new tab child
		driver.findElement(By.cssSelector("#tabButton")).click();

		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());

		System.out.println(windowHandles);

		// window child
		driver.findElement(By.cssSelector("#windowButton")).click();

		ArrayList<String> windowHandles2 = new ArrayList<String>(driver.getWindowHandles());

		System.out.println(windowHandles2);

		for (String s : windowHandles) {

			windowHandles2.remove(s);
		}
		for (String s : windowHandles2) {

			System.out.println("2nd child window: " + s);

		}
	}

	@AfterMethod
	public void tearDown() {

		driver.close();
	}
}