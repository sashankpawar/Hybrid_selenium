package testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RunTestSeleniumGrid {

	@Test
	public void executeTest() throws MalformedURLException
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("browser","Edge");
		cap.setCapability("browser_version","81.0 beta");
		cap.setCapability("os", "Windows");
	    cap.setCapability("os_version", "8");
	    cap.setCapability("browserstack.networkLogs","true");
	    
	    WebDriver driver=new RemoteWebDriver(new URL("http://mukeshotwani3:s4GTbs4fFzQxJxzpzp2f@hub-cloud.browserstack.com/wd/hub"), cap);
		
	    driver.get("http://www.google.com/ncr");
	    WebElement element = driver.findElement(By.name("q"));

	    element.sendKeys("BrowserStack");
	    element.submit();

	    System.out.println(driver.getTitle());
	    driver.quit();
	}

}
