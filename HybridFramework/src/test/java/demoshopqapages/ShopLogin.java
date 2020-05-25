package demoshopqapages;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import factory.DataProviderFactory;
import pages.BaseClass;
//import pages.LoginPage;

public class ShopLogin extends BaseClass{
	
	DemoShopLogin login;	
	
	
	
	@Test
	public void shoplogin()
{
	logger=report.createTest("Regression Test- Create User");
	login=PageFactory.initElements(driver, DemoShopLogin.class);
	login.verifyBeforeLogin();
	login.loginToApplication(DataProviderFactory.getExcel().getCellData("Admin", 4,0),DataProviderFactory.getExcel().getCellData("Admin", 4,1));
	login.verifyAfterLogin();
}
}
