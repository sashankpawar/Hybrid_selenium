package testcases;


import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

//import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.BaseClass;


//import pages.BaseClass;



public class NaukriUpload extends BaseClass{

	@Test
	public void Naukri() throws InterruptedException, IOException
	{
	logger=report.createTest("Naukri Resume Upload");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
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
	driver.switchTo().window(parenthandle);
	System.out.println(driver.getWindowHandle());
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.cssSelector("#wdgt-file-upload")).click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Runtime.getRuntime().exec("C:\\Users\\ADMIN\\photon-workspace\\HybridFramework\\Autoit\\upload.exe");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
	

