package shoptestcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import demoshopqapages.Homepage;
import demoshopqapages.ProductDetails;

import pages.BaseClass;


public class AddtoCartButton extends BaseClass {

	ProductDetails product;
	Homepage home;
	@Test
	public void Addtocartvisible()
	{
		
		logger=report.createTest("Add to Wishlist");
		product=PageFactory.initElements(driver, ProductDetails.class);
		home=PageFactory.initElements(driver, Homepage.class);
		//home.search();
	}
	
	
}
