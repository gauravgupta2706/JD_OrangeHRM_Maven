package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_MouseOver {
  @Test
  public void Sign_On() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  ChromeDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  Thread.sleep(15000);
	  driver.findElementByName("txtUsername").sendKeys("Admin");
	  driver.findElementByName("txtPassword").sendKeys("admin123");
	  driver.findElement(By.id("btnLogin")).click();
	  driver.findElement(By.linkText("Dashboard")).isDisplayed();
	  WebElement admin = driver.findElementById("menu_admin_viewAdminModule");

      Actions action = new Actions(driver);
      
      action.moveToElement(admin).build().perform();
      WebElement usermanagement = driver.findElementByLinkText("User Management");
      action.moveToElement(usermanagement).build().perform();
      Thread.sleep(5000);
      driver.findElementByLinkText("Users").click();
  }
}
