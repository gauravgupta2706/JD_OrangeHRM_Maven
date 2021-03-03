package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop_Example {
	ChromeDriver driver;

	@Test
	public void DragDrop() throws InterruptedException {
		// add 5 second wait
		Thread.sleep(3000);
		// Create object
		Actions act = new Actions(driver);
		// find element which we need to drag
		// WebElement drag=driver.findElementById("draggable");
		WebElement drag = driver.findElement(By.id("draggable"));
		// find element which we need to drop
		// WebElement drop=driver.findElementById("droppable");
		WebElement drop = driver.findElement(By.id("droppable"));
		// this will drag element to destination
		act.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(5000);
	}

	@BeforeTest
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Open Webpage
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		// Open Webpage and keep cookies and history
		// driver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html");
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
