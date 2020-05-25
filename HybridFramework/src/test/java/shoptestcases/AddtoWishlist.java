package shoptestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import demoshopqapages.DemoShopBrowse;
import demoshopqapages.DemoShopLogin;
import demoshopqapages.WishList;
import factory.DataProviderFactory;
import pages.BaseClass;

public class AddtoWishlist extends BaseClass {
	DemoShopLogin login;
	DemoShopBrowse browse;
	WishList wish;
	
	
	@Test
	public void wishlist()
	{
		logger=report.createTest("Add to Wishlist");
		login=PageFactory.initElements(driver, DemoShopLogin.class);
		browse=PageFactory.initElements(driver, DemoShopBrowse.class);
		wish=PageFactory.initElements(driver, WishList.class);
		login.verifyBeforeLogin();
		login.loginToApplication(DataProviderFactory.getExcel().getCellData("Admin", 4,0),DataProviderFactory.getExcel().getCellData("Admin", 4,1));
		login.verifyBeforeLogin();
		browse.browseproducts();
		browse.addtowishlist();
		wish.searchWishlist("BACK MAXI");
		
		
	}
	
	
}
