package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utlity.Helper;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
		
	}
	
	By forgotLink=By.xpath("//a[text()='Forgot your password?']");
	By usernameId=By.id("txtUsername");
	By passwordId=By.id("txtPassword");
	By loginButton=By.xpath("//input[@value='LOGIN']");
	By facebookIcon=By.xpath("//img[contains(@alt,'Facebook')]");
	By youtubeIcon=By.xpath("//img[contains(@alt,'youtube')]");
	
	
	public void verifyAfterLogin()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}
	

	public void verifyBeforeLogin()
	{
		Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));
	}
	
	
	public void clickOnForgotYourPasswordLink()
	{
		driver.findElement(forgotLink).click();
	}
	
	public void loginToApplication(String uname,String pass)
	{
		/*driver.findElement(usernameId).sendKeys(uname);
		driver.findElement(passwordId).sendKeys(pass);
		driver.findElement(loginButton).click();*/
		
		Helper.waitForWebElementAndType(driver, usernameId, uname, "Enter username");
		Helper.waitForWebElementAndType(driver, passwordId, pass, "Enter password");
		Helper.waitForWebElementAndClick(driver, loginButton, "Click on Login button");
	}
	
	
	public void facebookLink()
	{
		Assert.assertTrue(driver.findElement(facebookIcon).isDisplayed());
	}
	
	public void youTubeLink()
	{
		Assert.assertTrue(driver.findElement(youtubeIcon).isDisplayed());
	}
	
	

}
