package shoptestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataprovider.ExcelDataReader;
import demoshopqapages.DemoShopLogin;
import factory.DataProviderFactory;
import pages.BaseClass;
import factory.DataProviderTestng;


public class ShopLogin extends BaseClass{
	
	DemoShopLogin login;	
	
	
	
//	@Test(dataProvider="shopdata")
	@Test
	public void shoplogin(String username,String password )
{
	logger=report.createTest("Login to shop.demoqa");
	login=PageFactory.initElements(driver, DemoShopLogin.class);
	login.verifyBeforeLogin();
//	login.loginToApplication(username,password);
	login.loginToApplication(DataProviderFactory.getExcel().getCellData("Admin", 4,0),DataProviderFactory.getExcel().getCellData("Admin", 4,1));
	login.verifyAfterLogin();
}
	
	
	@DataProvider(name="shopdata")
	public Object[][] passdata()
	{
		
		ExcelDataReader reader = new ExcelDataReader("D:\\Hybrid framework  Mukesh otwni\\Data provider\\Data.xlsx");
		int rows = reader.rowCount(0);
		Object[][] data = new Object[rows][2];
		for(int i=0;i<rows;i++)
		{
			data[i][0]=reader.getCellData(0, i, 0);
			data[i][1]=reader.getCellData(0, i, 1);
		}
		return data;
		
	}
}
