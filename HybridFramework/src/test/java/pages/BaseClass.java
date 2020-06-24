/**
 * 
 */
package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import utlity.Helper;

/**
 * @author Sashank Pawar
 * Logs
 * Reports
 * Attaching screenshot on failure
 * Browser session
 *
 */
public class BaseClass {
	
	public static ExtentReports report;
	public ExtentTest  logger;
	public WebDriver driver;
	String reportPath;
	
	
	@BeforeSuite
	public void setupReport()
	{
		System.out.println("LOG:INFO : Setting up Report");
		
		reportPath=System.getProperty("user.dir")+"\\Reports\\Report"+Helper.getCurrentDateTime()+".html";
	//	reportPath=System.getProperty("user.dir")+"\\Reports\\Report.html";
		
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(reportPath);
		
		htmlReporter.config().setReportName("Automation Report");
		
		report=new ExtentReports();
		
		report.attachReporter(htmlReporter);
		
		System.out.println("LOG:INFO : Report is set");

	}
	
//	@Parameters({"browser","appurl"})
	@Parameters({"browser"})
	@BeforeClass
	public void startBrowserSession(String browser)
	{
		System.out.println("LOG:INFO : Setting up browser session");
	//	driver=new BrowserFactory().startBrowser(DataProviderFactory.getConfig().getBrowser(),DataProviderFactory.getConfig().stagingURL());
		driver=new BrowserFactory().startBrowser(browser,DataProviderFactory.getConfig().stagingURL());

		//System.out.println("Driver value "+driver);
	}
	
	@AfterClass
	public void clearBrowserSession()
	{
		System.out.println("Driver value before closing the session "+driver);
		driver.quit();
		System.out.println("LOG:INFO : Closing browser session");
	}
	
	@AfterMethod
	public void addResultToReport(ITestResult result)
	{
	
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			System.out.println("LOG:INFO : Test Result is Success");
			logger.pass("Test Passed");
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("LOG:INFO : Test Result is Failure");

			try {
				logger.fail("Test Failed "+result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				
				System.out.println("Exception "+e.getMessage());
			}
		}
		else
		{
			System.out.println("LOG:INFO : Test Result is Skipped");

			try {
				logger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				System.out.println("Exception "+e.getMessage());

			}
		}
		
		report.flush();
		
		System.out.println("LOG:INFO : Adding Test Result to report");

			
	}

}
