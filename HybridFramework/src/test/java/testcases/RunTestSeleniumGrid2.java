package testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RunTestSeleniumGrid2 {

	@Test
	public void executeTest() throws MalformedURLException
	{
		
		DesiredCapabilities caps=new DesiredCapabilities();
	
		caps.setCapability("os_version", "13");
		caps.setCapability("device", "iPhone 11");
		caps.setCapability("real_mobile", "true");
		//caps.setCapability("browserstack.local", "true");
		caps.setCapability("browserstack.debug", "true");
		caps.setCapability("browserstack.networkLogs", "true");
	    
	    WebDriver driver=new RemoteWebDriver(new URL("http://mukeshotwani3:s4GTbs4fFzQxJxzpzp2f@hub-cloud.browserstack.com/wd/hub"), caps);
		
	    driver.get("http://www.google.com/ncr");
	    WebElement element = driver.findElement(By.name("q"));

	    element.sendKeys("BrowserStack");
	    element.submit();

	    System.out.println(driver.getTitle());
	    driver.quit();
	}

}
