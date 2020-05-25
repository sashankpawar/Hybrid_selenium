package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import factory.DataProviderFactory;
import pages.BaseClass;
import pages.LoginPage;

public class SmokeTest extends BaseClass{

	LoginPage login;
	
	@Test
	public void validLogin()
	{		
		//System.out.println("Thread id "+Thread.currentThread().getId());
		logger=report.createTest("Smoke Test");
		login=PageFactory.initElements(driver, LoginPage.class);
		login.verifyBeforeLogin();
		login.loginToApplication(DataProviderFactory.getExcel().getCellData("Admin", 0,0),DataProviderFactory.getExcel().getCellData("Admin", 0,1));
		login.verifyAfterLogin();
	}
	
}
