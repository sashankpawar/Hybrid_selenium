package demoshopqapages;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

import utlity.Helper;

public class DemoShopBrowse {
	WebDriver driver;
	
	public DemoShopBrowse(WebDriver driver)
	{
		this.driver=driver;
		
	}

	By downloads=By.linkText("Downloads");
	By browse=By.xpath("//a[contains(text(),'Browse products')]");
//	By buysale=By.xpath("//span[contains(text(),'Sale')]//parent::div//child::h3//child::a");
	
	@FindBy(xpath="//span[contains(text(),'Sale')]//parent::div//child::h3//child::a")
	List<WebElement> buysale;
	
	By producttitle=By.xpath("//div[@class='noo-product-inner']//a");
	By wishlist=By.xpath("//a[@data-product-id='1162']");
	
	public void browseproducts() {
		
		Helper.waitForWebElementAndClick(driver, downloads, "Click on order");
		
		Helper.waitForWebElementAndClick(driver, browse, "Click on browse");
		
	}
	
	public void Buysaledress(String title)
	{
		for(WebElement element:buysale)
		{
			String products= element.getText();
			System.out.println("The products with sale are "+products);
			if(products.contains(title))
			{				
				element.click();	
				break;
			}
		}	
	}
	
	public void addtowishlist()
	{
		Helper.Scrolldown(driver);		
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement wishli = wait.until(ExpectedConditions.presenceOfElementLocated(wishlist));
			try {
			
				//	System.out.println("Heart icon displayed "+wishli.isDisplayed());
					Actions actions = new Actions(driver);
					actions.moveToElement(wishli).build().perform();
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					Helper.waitForWebElementAndClick(driver, wishlist, "click on wishlist heart Icon");
				}
				catch(NoSuchElementException e)
				{
					System.out.println("Can't find the Addtowishlist element , check whether product is already there is wishlist");
			
				}
		}
		
		catch(TimeoutException e)
		{
			System.out.println("Webdriver couldn’t locate the element, check whether product is already there is wishlist");
		}
		
		
	}
	

}
