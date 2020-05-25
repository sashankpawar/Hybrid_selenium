package demoshopqapages;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utlity.Helper;

public class ProductDetails {
	WebDriver driver;
	
	public ProductDetails(WebDriver driver)
	{
		this.driver=driver;
	}
	
By color=By.id("pa_color");	
By size=By.id("pa_size");	
By quantity=By.xpath("//i[@class='icon_plus']");	
By addtocartbutton=By.xpath("//button[@type=\"submit\" and @class=\"single_add_to_cart_button button alt\"]");
By producttitle=By.xpath("//h1[@class='product_title entry-title']");
By Viewcart=By.xpath("//a[contains(text(),'View cart')]");
By Facebooklink=By.xpath("//a[@title='Share on Facebook']");
By products=By.xpath("//div[@class=\"noo-product-inner\"]//h3/a");
By choosecolor=By.id("pa_color");
By clearbutton=By.xpath("//a[contains(text(),'Clear')]");
By compare=By.cssSelector("a[data-product_id=\"1162\"]");
By stock=By.cssSelector("tr.stock>td>span");

public 	String productitl;

public String addtocart(String qty,String value, String visibleText)
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	productitl = driver.findElement(producttitle).getText();
	System.out.println("Product title  "+productitl);
	Helper.waitForWebElementAndSelectWithValues(driver, color, value, "Choose color for the product");
	Helper.waitForWebElementAndSelectWithText(driver, size, visibleText, "Choose size");
	int qt=Integer.parseInt(qty);  
	for(int i=1;i<qt;i++)
	{
		Helper.waitForWebElementAndClick(driver, quantity, "Quantity select");
	}
	Helper.waitForWebElementAndClick(driver, addtocartbutton, "ADD TO CART button");
	Helper.waitForWebElementAndClick(driver, Viewcart, "VIEW CART button");
	return productitl;	
}
	

public void VerifyProductDetailsPage()
{
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
String actualtext = driver.findElement(By.xpath("//strong[contains(text(),'product number')]")).getText();	
Assert.assertEquals(actualtext, "product number", "Product details page not displayed");	
}


public void Facebookshare()
	{
		String title=driver.getTitle();
		System.out.println("Page title "+title);
		Helper.waitForWebElementAndClick(driver, Facebooklink, "Click on Share on Facebook icon");
//	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		String parenthandle= driver.getWindowHandle();
		Set<String> handles =driver.getWindowHandles();
		for(String handle:handles)
		{
		if(!handle.equals(parenthandle))
			{
				driver.switchTo().window(handle);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				String pagetitle=driver.getTitle();
				System.out.println("Page title "+pagetitle);
				Assert.assertTrue(driver.getTitle().contains("Facebook"), "This is not a facebook page");	
				
				break;
			}
		}
		driver.switchTo().window(parenthandle);
	
	}


	public void Openproduct(String producttitle)
	{
		System.out.println("Open product beginning");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> list = driver.findElements(products);
		for(WebElement element:list)
		{		
			if(element.getText().contains(producttitle))
			{
				element.click();
				System.out.println("Open the "+producttitle+" product");
				break;
			}
		
		}	
	}


	public void clearvisible() 
	{
		WebElement displayed = driver.findElement(clearbutton);	
		System.out.println("clear button displayed is  "+ displayed.isDisplayed());	
		Helper.waitForWebElementAndSelectWithText(driver, choosecolor, "Black", "Choose color dropdown - Black");		
		System.out.println("clear button displayed is  "+ displayed.isDisplayed());
	}


	public void cleardropdown() {
		WebElement displayed = driver.findElement(clearbutton);	
		System.out.println("clear button displayed is  "+ displayed.isDisplayed());	
		Helper.waitForWebElementAndSelectWithText(driver, choosecolor, "Black", "Choose color dropdown - Black");		
		System.out.println("clear button displayed is  "+ displayed.isDisplayed());
	//	Helper.waitForWebElementAndClick(driver, clearbutton, "click on the clear button");
		Helper.waitForWebElementAndClickUsingJS(driver, clearbutton, "click on the clear button using javascript");
		driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
		WebElement color=driver.findElement(choosecolor);
		System.out.println("choose option selected is  "+ color.isSelected());
		Assert.assertFalse(color.isSelected(), " choose color is still selected");
	}


	public void stock() 
	{
		Helper.waitForWebElementAndClick(driver, compare, "Click on Compare Icon");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element= driver.findElement(By.cssSelector("iframe.cboxIframe"));
		driver.switchTo().frame(element);
		System.out.println("After switching frame");
		String Instock=driver.findElement(stock).getText();
		System.out.println("Availability "+Instock);
		Assert.assertEquals(Instock, "In stock", "Item is not in stock");
		driver.switchTo().defaultContent();
		
	}
}
