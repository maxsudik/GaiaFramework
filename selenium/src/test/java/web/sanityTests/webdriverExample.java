package test.java.web.sanityTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webdriverExample {
 
	public static void main(String[] args) throws InterruptedException {
		
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		
		// Launch the ToolsQA WebSite
		driver.get("http://toolsqa.wpengine.com/Automation-practice-form/");
 
		// Type Name in the FirstName text box      
		driver.findElement(By.name("firstname")).sendKeys("Lakshay"); 
 
		//Type LastName in the LastName text box
		driver.findElement(By.name("lastname")).sendKeys("Sharma");
 
		// Click on the Submit button
		driver.findElement(By.id("submit")).click();
  
		
		
        // Close the driver
        driver.quit();
    }
}