package shoptestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import demoshopqapages.DemoShopBrowse;
import demoshopqapages.DemoShopLogin;
import demoshopqapages.ProductDetails;
import demoshopqapages.WishList;
import factory.DataProviderFactory;
import pages.BaseClass;

public class SelectOptionWishlist extends BaseClass {
	DemoShopLogin login;
	DemoShopBrowse browse;
	WishList wish;
	ProductDetails product;
	
	@Test
	public void selectoption()
	{
		logger=report.createTest("Select Option Wishlist");
		login=PageFactory.initElements(driver, DemoShopLogin.class);
		browse=PageFactory.initElements(driver, DemoShopBrowse.class);
		wish=PageFactory.initElements(driver, WishList.class);
		product=PageFactory.initElements(driver, ProductDetails.class);
		login.verifyBeforeLogin();
		login.loginToApplication(DataProviderFactory.getExcel().getCellData("Admin", 4,0),DataProviderFactory.getExcel().getCellData("Admin", 4,1));
		login.verifyBeforeLogin();
		browse.browseproducts();
		browse.addtowishlist();
		wish.searchWishlist(DataProviderFactory.getExcel().getCellData("Demoshop", 24, 5));
		wish.selectoptionwish();
		product.VerifyProductDetailsPage();
		
	}
}
