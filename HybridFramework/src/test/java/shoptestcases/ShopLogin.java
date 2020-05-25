package shoptestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import demoshopqapages.DemoShopLogin;
import factory.DataProviderFactory;
import pages.BaseClass;


public class ShopLogin extends BaseClass{
	
	DemoShopLogin login;	
	
	
	
	@Test
	public void shoplogin()
{
	logger=report.createTest("Login to shop.demoqa");
	login=PageFactory.initElements(driver, DemoShopLogin.class);
	login.verifyBeforeLogin();
	login.loginToApplication(DataProviderFactory.getExcel().getCellData("Admin", 4,0),DataProviderFactory.getExcel().getCellData("Admin", 4,1));
	login.verifyAfterLogin();
}
}
