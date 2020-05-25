package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	

	public WebDriver startBrowser(String browserName,String url)
	{

		System.out.println("LOG:INFO : Starting Session on "+browserName + "Test will be executed on "+url);

		WebDriver driver = null;
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		//	System.setProperty("webdriver.gecko.driver","D:\\Hybrid framework  Mukesh otwni\\geckodriver-v0.26.0-win64 (1)\\geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
			driver=new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else if(browserName.equalsIgnoreCase("ChromeHeadless"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			ChromeOptions opt=new ChromeOptions();
			opt.setHeadless(true);
			driver=new ChromeDriver(opt);
		}
		else if(browserName.equalsIgnoreCase("FirefoxHeadless"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver=new FirefoxDriver(new FirefoxOptions().setHeadless(true));
		}
		else
		{
			System.out.println("Sorry We do not support this browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		System.out.println("LOG:INFO : Browser and Application is up and running");

		return driver;
	}
	
	
	
	
	
	
	
	
	

}
