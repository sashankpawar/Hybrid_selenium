package shoptestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import demoshopqapages.DemoShopBrowse;
import demoshopqapages.DemoShopLogin;
import demoshopqapages.ProductDetails;
import factory.DataProviderFactory;
import pages.BaseClass;

public class ClearButton extends BaseClass{

	DemoShopLogin login;
	DemoShopBrowse browse;
	ProductDetails product;
	
	@Test
	public void ClearbuttonApply()
	{
		logger=report.createTest("Clear Button");
		login=PageFactory.initElements(driver, DemoShopLogin.class);
		browse=PageFactory.initElements(driver, DemoShopBrowse.class);
		product=PageFactory.initElements(driver, ProductDetails.class);
		login.verifyBeforeLogin();
		login.loginToApplication(DataProviderFactory.getExcel().getCellData("Admin", 4,0),DataProviderFactory.getExcel().getCellData("Admin", 4,1));
		login.verifyBeforeLogin();
		browse.browseproducts();	
		product.Openproduct(DataProviderFactory.getExcel().getCellData("Demoshop", 36, 5));
		product.cleardropdown();
	}
}
