package testcases;

import pages.BaseClass;
import pages.NaukriLoginPage;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class NaukriLoginTest extends BaseClass {
	
	NaukriLoginPage login;
	
	@Test
	public void createTest() {
	logger=report.createTest("Naukri Login");
	login=PageFactory.initElements(driver, NaukriLoginPage.class);
	login.verifyBeforeLogin();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	String parenthandle = driver.getWindowHandle();
	System.out.println(parenthandle);
	Set<String> handles = driver.getWindowHandles();
	for(String handle:handles)
	{
		if(!handle.equals(parenthandle))
		{
			System.out.println(handle);
			driver.switchTo().window(handle);
			driver.close();	
		}
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.switchTo().window(parenthandle);
	System.out.println(driver.getWindowHandle());	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	login.loginnaukri();
	login.verifyAfterLogin();
	}
}
