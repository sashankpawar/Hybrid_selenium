package pages;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import utlity.Helper;


public class NaukriLoginPage {
	WebDriver driver;
	
	public NaukriLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}

	By Upload=By.cssSelector("#wdgt-file-upload");
//	By Username=By.xpath("//input[@placeholder='Enter your active Email ID / Username']");
	By Username=By.cssSelector("input[placeholder$='Username']");
//	By Password=By.xpath("//input[@placeholder='Enter your password']");
	By Password=By.cssSelector("input[placeholder$='password']");
//	By Loginbutton=By.xpath("//button[@class='btn-primary loginButton']");
	By Loginbutton=By.xpath("//form[@name='login-form']//div/button[@type='submit']");
	By Loginlink=By.xpath("//div[contains(text(),'Login')]");
	public void verifyAfterLogin()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("naukri"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Actualname=driver.findElement(By.xpath("//div[@title='Sashank Pawar']")).getText();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Assert.assertEquals(Actualname, "Sashank Pawar", "Name is different" );
	}
	

	public void verifyBeforeLogin()
	{
		Assert.assertTrue(driver.getTitle().contains("Jobs"));
	}
	
	public void loginnaukri()
	{
		Helper.waitForWebElementAndClick(driver, Loginlink, "click on login first");
		Helper.waitForWebElementAndType(driver, Username, "sashankpawar39@gmail.com", "Enter username");
		Helper.waitForWebElementAndType(driver, Password, "Oracle@4485", "Enter password");
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Helper.waitForWebElementAndClick(driver, Loginbutton, "click on login button");
	}
	
	public void uploadCV() throws IOException 
	{
		Helper.waitForWebElementAndClick(driver, Upload , "Click on upload CV button");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Runtime.getRuntime().exec("C:\\Users\\ADMIN\\photon-workspace\\HybridFramework\\Autoit\\upload.exe");
	}
	
	
	
}
