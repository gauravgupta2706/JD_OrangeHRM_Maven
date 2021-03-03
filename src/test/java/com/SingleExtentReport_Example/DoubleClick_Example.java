package com.SingleExtentReport_Example;
// Need to change the code 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClick_Example {
	ChromeDriver driver; 
  @Test
  public void Navigation() throws InterruptedException 
  {  
	  //add 5 second wait 
	  Thread.sleep(3000);
	  //Create object 
	  WebElement admin = driver.findElementById("menu_admin_viewAdminModule");
	  Actions action=new Actions(driver);
	  action.moveToElement(admin).build().perform();
	  WebElement usermanagement = driver.findElementByLinkText("User Management");
	  action.moveToElement(usermanagement).build().perform();
	  driver.findElementByLinkText("Users").click();
	  driver.navigate().back();
	  Thread.sleep(3000);
	  String Dashboardurl = driver.getCurrentUrl();
	  System.out.println(Dashboardurl);
	  driver.navigate().forward();
	  Thread.sleep(3000);
	  String Dashboardurlnew = driver.getCurrentUrl();
	  System.out.println(Dashboardurlnew);
  }
  @BeforeTest
  public void LaunchBrowser() 
  {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  //Open Webpage
	  driver.get("https://www.testandquiz.com/selenium/testing.html");
	  //Open Webpage and keep cookies and history 
	  //driver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html");
  }
  
  @AfterTest
  public void CloseBrowser() 
  {
	  driver.quit();
  }

}
