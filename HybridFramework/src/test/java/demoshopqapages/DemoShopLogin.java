package demoshopqapages;

import org.testng.Assert;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;

import utlity.Helper;
import factory.DataProviderFactory;

public class DemoShopLogin {
	
	WebDriver driver;
	public DemoShopLogin(WebDriver driver)
	{
		this.driver=driver;
	}	
	
	By usernameId=By.id("username");
	By passwordId=By.name("password");
	By loginButton=By.name("login");
	By unameAfterlogin=By.xpath("//strong[1]");
	By MyaccountLink=By.linkText("My Account");
	By dismiss=By.linkText("Dismiss");
	By Logout = By.linkText("Log out");
	
	public void verifyBeforeLogin() {
		
		Assert.assertTrue(driver.getTitle().contains("ToolsQA"));
		Helper.waitForWebElementAndClick(driver, dismiss, "Click on dismiss");
	}

	public void loginToApplication(String uname, String pass) {
		
	//	Helper.waitForWebElementAndClick(driver, dismiss, "Click on dismiss");
		Helper.waitForWebElementAndClick(driver, MyaccountLink, "Click on My Account link");
		Helper.waitForWebElementAndType(driver, usernameId, uname, "Enter username");
		
		Helper.waitForWebElementAndType(driver, passwordId, pass, "Enter password");
		
		Helper.waitForWebElementAndClick(driver, loginButton, "Click on Login button");
		Helper.waitForWebElementAndClickUsingJS(driver, Logout, "logout");
		
	}

	
	
	public void verifyAfterLogin() {	
		Assert.assertTrue(driver.getTitle().contains("My Account"));
		String Actualname=driver.findElement(unameAfterlogin).getText();
		Assert.assertEquals(Actualname, DataProviderFactory.getExcel().getCellData("Admin", 4,0), "Username is different");
	}

}
