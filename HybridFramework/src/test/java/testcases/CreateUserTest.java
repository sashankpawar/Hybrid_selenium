package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import factory.DataProviderFactory;
import pages.BaseClass;
import pages.LoginPage;
import pages.UserPage;

public class CreateUserTest extends BaseClass{

	LoginPage login;
	UserPage user;
	
	@Test
	public void createUser()
	{		
		//System.out.println("Thread id "+Thread.currentThread().getId());
		logger=report.createTest("Regression Test- Create User");
		login=PageFactory.initElements(driver, LoginPage.class);
		user=PageFactory.initElements(driver, UserPage.class);
		login.verifyBeforeLogin();
		login.loginToApplication(DataProviderFactory.getExcel().getCellData("Admin", 0,0),DataProviderFactory.getExcel().getCellData("Admin", 0,1));
		login.verifyAfterLogin();
		user.addUser();
	}
	
}
