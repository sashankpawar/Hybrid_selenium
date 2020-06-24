package utlity;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Helper {

	public static void waitForSuggestionAndSelect(WebDriver driver,By locator,String text,String stepInfo)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		List<WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		for(WebElement ele:elements)
		{
			if(ele.getText().contains(text))
			{
				ele.click();
				break;
			}
		}
	}
	
	
	public static void waitForWebElementAndSelectWithText(WebDriver driver,By locator,String visibleText,String stepInfo)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
		Reporter.log("LOG:INFO-"+stepInfo, true);
	}
	
	public static void waitForWebElementAndSelectWithValues(WebDriver driver,By locator,String value,String stepInfo)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		Select sel=new Select(element);
		sel.selectByValue(value);
		Reporter.log("LOG:INFO-"+stepInfo, true);
	}
	
	public static void waitForWebElementAndSelectIndex(WebDriver driver,By locator,int indexValue,String stepInfo)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		Select sel=new Select(element);
		sel.selectByIndex(indexValue);
		Reporter.log("LOG:INFO-"+stepInfo, true);
	}
	
	public static void verifyMessages(WebDriver driver, By locator,String text,String stepInfo)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(locator)).getText().equalsIgnoreCase(text));
		Reporter.log("LOG:INFO-"+stepInfo, true);

	}
	
	public static void verifyMessagesPartial(WebDriver driver, By locator,String text,String stepInfo)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(locator)).getText().contains(text));
		Reporter.log("LOG:INFO-"+stepInfo, true);
	}
	
	
	public static void waitForAlertAndAccept(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent()).accept();
	}
	
	
	public static void waitForAlertAndDismiss(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent()).dismiss();
	}
	
	public static void waitForAlertAndVerifyText(WebDriver driver,String expectedAlertMessage)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		Assert.assertEquals(wait.until(ExpectedConditions.alertIsPresent()).getText(),expectedAlertMessage);
	}
	
	public static void waitForAlertAndVerifyTextPartially(WebDriver driver,String expectedAlertMessage)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		Assert.assertTrue(wait.until(ExpectedConditions.alertIsPresent()).getText().contains(expectedAlertMessage));
	}
		
	public static void highLightElement(WebDriver driver, WebElement element)
	{
	JavascriptExecutor js=(JavascriptExecutor)driver; 
	 
	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	 
	try 
	{
	Thread.sleep(1000);
	} 
	catch (InterruptedException e) 
	{
	 
	System.out.println(e.getMessage());
	} 
	 
	js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
	 
	}
	
	
	public static WebElement waitForWebElementAndClick(WebDriver driver,By locator,String stepInfo)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		highLightElement(driver, element);
		element.click();
		Reporter.log("LOG:INFO-"+stepInfo, true);
		return element;
	}
	
	public static WebElement waitForWebElementAndClickUsingJS(WebDriver driver,By locator,String stepInfo)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		highLightElement(driver, element);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(locator));
		Reporter.log("LOG:INFO-JavaScript Click Operation"+stepInfo, true);
		return element;
	}
	
	public static WebElement waitForWebElementAndTypeUsingJS(WebDriver driver,By locator,String data,String stepInfo)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		highLightElement(driver, element);
		((JavascriptExecutor)driver).executeScript("arguments[0].value=arguments[1];", driver.findElement(locator),data);
		Reporter.log("LOG:INFO-"+stepInfo, true);
		return element;
	}
	
	
	public static WebElement waitForWebElementAndType(WebDriver driver,By locator,String data,String stepInfo)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		highLightElement(driver, element);
		element.sendKeys(data);
		Reporter.log("LOG:INFO-"+stepInfo, true);
		return element;
	}
	
	public static WebElement waitForWebElement(WebDriver driver,By locator,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		WebElement element=	wait.until(ExpectedConditions.elementToBeClickable(locator));
		highLightElement(driver, element);
		return element;
	}
	
	public static WebElement waitForWebElement(WebDriver driver,By locator)
	{
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		highLightElement(driver, element);
		return element;
	}
	

	
	public static WebElement waitForWebElement(WebDriver driver, String xpath,int time)
	{
		
		WebElement element=null;
		

		for(int i=0;i<time;i++)
		{
			try {
				element=driver.findElement(By.xpath(xpath));
				break;
				
			} catch (Exception e) 
			{
			
				try {
					Thread.sleep(1000);
					System.out.println("Waiting for WebElement to appear");
				} catch (InterruptedException e1) {
					
				}
				
			}
		}
		
		return element;
		
	}
	
	
	public static boolean isLinkBroken(String url)
	{
		boolean status=false;
		
		System.out.print("Sending Request to server for "+url);
		System.out.println(" Waiting for response code");
		
		HttpURLConnection httpurlconnection = null;
		try {
			httpurlconnection = (HttpURLConnection) new URL(url).openConnection();
			httpurlconnection.setConnectTimeout(20000);
			httpurlconnection.connect();
			System.out.println("Response code is "+httpurlconnection.getResponseCode());
			
			if(httpurlconnection.getResponseCode()==HttpURLConnection.HTTP_OK || httpurlconnection.getResponseCode()==201
			  || httpurlconnection.getResponseCode()==202
			  || httpurlconnection.getResponseCode()==204
			  || httpurlconnection.getResponseCode()==301
			  || httpurlconnection.getResponseCode()==302)
			{
				System.out.println(url+" - "+httpurlconnection.getResponseMessage());
			}
			else
			{
				
				status=true;
			}
		} catch (MalformedURLException e) {
			System.out.println("Exception trace is "+e.getMessage());
		} catch (IOException e) {
			System.out.println("Exception trace is "+e.getMessage());
		}
		
		
		return status;
	}
	
	
	
	public static String getCurrentDateTime()
	{	
		return new SimpleDateFormat("HH_mm_ss_dd_MM_yyy").format(new Date());
	}
	
	public static String captureScreenshot(WebDriver driver)
	{
		
		String path=System.getProperty("user.dir")+"\\Screenshots\\"+Helper.getCurrentDateTime()+".png";
		
		try 
		{
			FileHandler.copy(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(path));
		} 
		catch (IOException e) 
		{
			System.out.println("Exception trace is "+e.getMessage());
		}
		
		return path;
	}


	public static void Scrolldown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");	
		
	}


	public static void Scrollup(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-300)");	
		
	}
	
	
	
}
