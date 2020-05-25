package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.BaseClass;

public class Iframes extends BaseClass {

	@Test
	public void iframe()
	{
		logger=report.createTest("Iframe test");
		driver.switchTo().frame("singleframe");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='col-xs-6 col-xs-offset-5']//input")).sendKeys("My Name is Sasha");
		driver.switchTo().defaultContent();
		
	}
	
}
