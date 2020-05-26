package shoptestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import demoshopqapages.DemoShopBrowse;
import demoshopqapages.DemoShopLogin;
import demoshopqapages.ProductDetails;
import factory.DataProviderFactory;
import pages.BaseClass;

public class ClearButtonvisible extends BaseClass{

	DemoShopLogin login;
	DemoShopBrowse browse;
	ProductDetails product;
	
	@Test
	public void Clearbutton()
	{
		logger=report.createTest("Clear Button Visible");
		login=PageFactory.initElements(driver, DemoShopLogin.class);
		browse=PageFactory.initElements(driver, DemoShopBrowse.class);
		product=PageFactory.initElements(driver, ProductDetails.class);
		login.verifyBeforeLogin();
		login.loginToApplication(DataProviderFactory.getExcel().getCellData("Admin", 4,0),DataProviderFactory.getExcel().getCellData("Admin", 4,1));
		login.verifyBeforeLogin();
		browse.browseproducts();	
		product.Openproduct(DataProviderFactory.getExcel().getCellData("Demoshop", 32, 5));
		product.clearvisible();
	}
}
