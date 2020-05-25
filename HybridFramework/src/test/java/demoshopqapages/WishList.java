package demoshopqapages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utlity.Helper;

public class WishList {
WebDriver driver;
	
	public WishList(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By Mywishlist = By.linkText("My Wishlist");
	By Removewish= By.xpath("//a[@href='/wishlist/?remove_from_wishlist=1162']");
	By selectoption= By.xpath("//a[@data-product_id='1162']");
	
	public void searchWishlist(String producttitle)
	{
		Helper.Scrollup(driver);
		System.out.println("product title ::"+producttitle);
	//	driver.findElement(By.linkText("http://shop.demoqa.com/wishlist/")).click();
	Helper.waitForWebElementAndClick(driver, Mywishlist, "click on Mywishlist link");
		
		List<WebElement> list = driver.findElements(By.xpath("//tbody[@class='wishlist-items-wrapper']//td"));
		for(WebElement element:list)
		{		
			if(element.getText().contains(producttitle))
			{
				System.out.println("Product found in Wishlist");
				break;
			}
			
		}
	}
	
	
	public void removefromwishlist()
	{
		Helper.waitForWebElementAndClick(driver, Removewish, "Click on Remove button in Wishlist");
	}
	
	public void verifyRemoveWishlist()
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String message= driver.findElement(By.xpath("//div[contains(@class,'woocommerce-message')]")).getText();
		System.out.println("The removed message  "+message);
		
	}
	
	public void selectoptionwish()
	{
		Helper.waitForWebElementAndClick(driver, selectoption, "Click on Select Option link");
	}

	
	
}
