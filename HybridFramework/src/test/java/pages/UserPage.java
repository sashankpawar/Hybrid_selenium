package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utlity.Helper;

public class UserPage {
	
	WebDriver driver;
	
	public UserPage(WebDriver driver)
	{
		this.driver=driver;
	}

	By adminTab=By.xpath("//b[text()='Admin']");
	By addButton=By.xpath("//input[@value='Add']");	
	By empName=By.xpath("//label[text()='Employee Name']//following::input[1]");
	By username=By.xpath("//label[text()='Username']//following::input[1]");
	By password=By.xpath("//label[text()='Password']//following::input[1]");
	By confirmPassword=By.xpath("//label[text()='Confirm Password']//following::input[1]");
	By saveButton=By.xpath("//input[@value='Save']");
	By successToolTipMessage=By.xpath("//*[contains(text(),'Successfully Saved')] ");
	
	
	public void addUser() {
		Helper.waitForWebElementAndClick(driver, adminTab, "Click on Admin tab");
		Helper.waitForWebElementAndClick(driver, addButton, "Click on add button");
		Helper.waitForWebElementAndType(driver, empName, "John Smith", "Type Emp Name");
		Helper.waitForWebElementAndType(driver, username, "King206", "Type user Name");
		Helper.waitForWebElementAndType(driver, password, "abcd1234", "Type password ");
		Helper.waitForWebElementAndType(driver, confirmPassword, "abcd1234", "Type confirmpassword");
		Helper.waitForWebElementAndClick(driver, saveButton, "Click on Save button");
		Helper.verifyMessagesPartial(driver, successToolTipMessage, "Saved","Verified success message after adding user");
	}
	
}
