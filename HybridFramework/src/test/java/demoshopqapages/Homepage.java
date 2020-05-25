package demoshopqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import utlity.Helper;

public class Homepage {
WebDriver driver;
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By search = By.cssSelector("a.noo-search");
	By searchenter= By.cssSelector("input[type='search']");
	

	public void search(String data) 
	{
		   Helper.waitForWebElementAndClick(driver, search, "Click on Search");
		   Helper.waitForWebElementAndType(driver, searchenter, data, "Enter the Search data");
		   Helper.waitForWebElementAndClick(driver, searchenter, "Click on Search before enter");
		   WebElement ele = driver.findElement(searchenter);
		   ele.sendKeys(Keys.ENTER);
		   Reporter.log("LOG:INFO- Search end", true);
	//	   Reporter.log("Search end");
	//	   System.out.println("search end");
		   
	}
	
	
	
}
