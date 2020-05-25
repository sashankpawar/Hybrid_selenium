package demoshopqapages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cart {

	
WebDriver driver;
	
	public cart(WebDriver driver)
	{
		this.driver=driver;
	}
	
	ProductDetails prod;	
	
public void searchcart(String producttitle)
	{
	System.out.println("product title ::"+producttitle);
	List<WebElement> list = driver.findElements(By.xpath("//table[@class=\"shop_table shop_table_responsive cart\"]/tbody//td"));
		for(WebElement element:list)
		{		
			if(element.getText().contains(producttitle))
			{
			System.out.println("Product found in cart");
			break;
			}
		
		}
	}

}


