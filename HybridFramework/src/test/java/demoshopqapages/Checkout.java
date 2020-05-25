package demoshopqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utlity.Helper;

public class Checkout {
	
	
WebDriver driver;
	
	public Checkout(WebDriver driver)
	{
		this.driver=driver;
	}

By checkoutbutton=By.xpath("//a[contains(text(),'Proceed to checkout')]");
By firstname=By.id("billing_first_name");
By lastname=By.id("billing_last_name");

	
	public void proceedcheckout()
	{
		Helper.waitForWebElementAndClick(driver, checkoutbutton, "click on checkout button");
		//Helper.waitForWebElementAndType(driver, locator, data, stepInfo)
	}
}
