package shoptestcases;




import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import demoshopqapages.DemoShopBrowse;
import demoshopqapages.DemoShopLogin;
import demoshopqapages.ProductDetails;
import demoshopqapages.cart;
import factory.DataProviderFactory;
import pages.BaseClass;

//import factory.DataProviderFactory;
//import org.openqa.selenium.support.ui.*;

public class SaleProducts extends BaseClass{
	
	DemoShopBrowse browse;
	DemoShopLogin login;
	ProductDetails product;
	cart cartt;
	String prod;
	
	
	@Test
	public void SaleProd()
	{
		logger=report.createTest("Browse the products");
		
		browse=PageFactory.initElements(driver,DemoShopBrowse.class );
		login=PageFactory.initElements(driver, DemoShopLogin.class);
		product=PageFactory.initElements(driver, ProductDetails.class);
		cartt=PageFactory.initElements(driver, cart.class);
		
		login.verifyBeforeLogin();
		login.loginToApplication(DataProviderFactory.getExcel().getCellData("Admin", 4,0),DataProviderFactory.getExcel().getCellData("Admin", 4,1));
		login.verifyAfterLogin();
		browse.browseproducts();
		System.out.println("Sale PRod test");
		browse.Buysaledress(DataProviderFactory.getExcel().getCellData(1, 3, 4));			
		prod=product.addtocart(DataProviderFactory.getExcel().getCellData(1,6,4),DataProviderFactory.getExcel().getCellData(1,4,4), DataProviderFactory.getExcel().getCellData(1,5,4));
		cartt.searchcart(prod);
	}

}
