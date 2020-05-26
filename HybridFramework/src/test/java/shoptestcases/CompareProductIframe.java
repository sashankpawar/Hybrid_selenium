package shoptestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import demoshopqapages.Homepage;
import demoshopqapages.ProductDetails;
import factory.DataProviderFactory;
import pages.BaseClass;

public class CompareProductIframe extends BaseClass 
{

	Homepage home;
	ProductDetails product;
	
	@Test
	public void compareproduct()
	{
		logger=report.createTest("Compare the Products Iframe");
		home=PageFactory.initElements(driver, Homepage.class);
		product=PageFactory.initElements(driver, ProductDetails.class);
		home.search(DataProviderFactory.getExcel().getCellData("Demoshop", 47, 5));
		product.Openproduct(DataProviderFactory.getExcel().getCellData("Demoshop", 47, 5));
		product.stock();
		
	}
	
}
