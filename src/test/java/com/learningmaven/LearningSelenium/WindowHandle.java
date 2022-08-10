package com.learningmaven.LearningSelenium;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandle {

	WebDriver driver;
	// instantiate the action class
	Actions ac;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		ac = new Actions(driver);
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}

	@Test()
	public void WindowHandleIDs() {

		// identify parent tab
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent Window Handle ID: " + parentWindowHandle);

		driver.findElement(By.id("tabButton")).click();
		Set<String> handle = driver.getWindowHandles();

		for (String windowHandle : handle) {
			if (!windowHandle.equals(parentWindowHandle)) {

				driver.switchTo().window(windowHandle);
				System.out.println("Switching to Child Tab with ID: " + driver.getWindowHandle());
			}
		}
		// switch back to parent

		driver.switchTo().window(parentWindowHandle);
		System.out.println("Switching back to Parent Window with ID: " + driver.getWindowHandle());

		driver.findElement(By.id("tabButton")).click();
		Set<String> handler = driver.getWindowHandles();

		for (String windowHandle : handler) {
			if (!windowHandle.equals(parentWindowHandle)) {

				driver.switchTo().window(windowHandle);
				System.out.println("Switching to Child Tab with ID: " + driver.getWindowHandle());
			}
		}

		driver.switchTo().window(parentWindowHandle);
		System.out.println("Switching back to Parent Window with ID: " + driver.getWindowHandle());

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
