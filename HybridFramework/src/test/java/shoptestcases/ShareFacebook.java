package shoptestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import demoshopqapages.DemoShopBrowse;
import demoshopqapages.DemoShopLogin;
import demoshopqapages.ProductDetails;

import factory.DataProviderFactory;
import pages.BaseClass;

public class ShareFacebook extends BaseClass{

	DemoShopLogin login;
	DemoShopBrowse browse;
	ProductDetails product;
	
	@Test
	public void Facebook()
	{
		logger=report.createTest("Share Icon Facebook");
		login=PageFactory.initElements(driver, DemoShopLogin.class);
		browse=PageFactory.initElements(driver, DemoShopBrowse.class);
		product=PageFactory.initElements(driver, ProductDetails.class);
		login.verifyBeforeLogin();
		login.loginToApplication(DataProviderFactory.getExcel().getCellData("Admin", 4,0),DataProviderFactory.getExcel().getCellData("Admin", 4,1));
		login.verifyBeforeLogin();
		browse.browseproducts();	
		product.Openproduct(DataProviderFactory.getExcel().getCellData("Demoshop", 28, 5));
		product.Facebookshare();
	}
}
