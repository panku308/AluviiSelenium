package WaiverTest;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import GlobalFiles.CommonFunctions;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import ObjectRepository.SignWaiverPageElements;
import ObjectRepository.WaiverFinalPageElements;
import ObjectRepository.WaiverManagementPageElements;

public class WaiverSignTest {
	 public static WebDriver driver=null;	
	 String expectedResult="", actualResult="";
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.SetupEnvironment(CommonFunctions.url, "chrome");
		  Thread.sleep(5000);
	  }
	 @Test (priority=1)
	 public void SignWaiverTest()throws Exception
	  {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		  
		  CommonFunctions.Login(driver);
		  Thread.sleep(5000);
		  
		  Thread.sleep(2000);
		  js.executeScript("arguments[0].scrollIntoView();",DashboardPageElements.GetWaiverManagementLink(driver));
		  DashboardPageElements.clickOnManagementlink(driver);
		  DashboardPageElements.GetWaiverManagementLink(driver).click();
		  Thread.sleep(5000);
		  WaiverManagementPageElements.GetIDColumn(driver).click();
		  Thread.sleep(3000);
		  WaiverManagementPageElements.GetIDColumn(driver).click();
		  Thread.sleep(3000);
		  WaiverManagementPageElements.GetWaiverNameOfFirstRow(driver).click();
		  WaiverManagementPageElements.GetSelectOptionDropdown(driver).click();
		  Thread.sleep(3000);
		  String ParentWindo = driver.getWindowHandle();
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "View Waiver Form").click();
		  Thread.sleep(5000);
		  
		  ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(windowHandles.get(1));
		  
		  
		  SignWaiverPageElements.GetEmailIDField(driver).sendKeys("Email"+ System.currentTimeMillis() +"@gmail.com");
		  SignWaiverPageElements.GetPhoneNumberField(driver).sendKeys("1234567890");
		  SignWaiverPageElements.GetStreetAddressField(driver).sendKeys("Street1");
		  SignWaiverPageElements.GetCityField(driver).sendKeys("New York");
		  SignWaiverPageElements.GetStateField(driver).sendKeys("New York");
		  SignWaiverPageElements.GetZipCodeField(driver).sendKeys("12345");
		  
		  Actions builder = null;
		  Action drawAction = null;
		  
		  for (int i=1;i<=3;i++)
		  {
			  SignWaiverPageElements.GetFirstNameField(driver,i).sendKeys("fname" + System.currentTimeMillis());
			  SignWaiverPageElements.GetLastNameField(driver,i).sendKeys("lname"+ System.currentTimeMillis());		  
			  CommonFunctions.SelectOptionFromDropdownByValue(SignWaiverPageElements.GetYearDropdown(driver,i) , "1999");
			  CommonFunctions.SelectOptionFromDropdownByValue(SignWaiverPageElements.GetMonthDropdown(driver,i) , "11");
			  CommonFunctions.SelectOptionFromDropdownByValue(SignWaiverPageElements.GetDayDropdown(driver,i) , "20");
			  
			  builder = new Actions(driver);
			  drawAction = builder.moveToElement(SignWaiverPageElements.GetSignatureField(driver,i),100,15).clickAndHold().moveByOffset(120, 30).moveByOffset(80, 40).release().build();
			  drawAction.perform();
			  if(i<3)
			  {
				  SignWaiverPageElements.GetAddGuestButton(driver).click();  
			  }
			    
		  }
		  		  
		  SignWaiverPageElements.GetIMFinishedButton(driver).click();
		  Thread.sleep(5000);
		  
		  actualResult = WaiverFinalPageElements.GetSigningSuccessMsg(driver).getText();
		  CommonFunctions.printString("Actual Result " + actualResult);
		  assertEquals(actualResult.trim(), "Success!   Thank you for signing! Your waiver(s) have been submitted.");
		  
		  
		  actualResult = WaiverFinalPageElements.GetMsgSendSuccessMsg(driver).getText();
		  CommonFunctions.printString("Actual Result " + actualResult);
		  assertEquals(actualResult.trim(), "Successfully Sent!   A copy of your signed waiver(s) have been sent to your inbox.");
		  
		  driver.close();
		  driver.switchTo().window(windowHandles.get(0));
		  WaiverManagementPageElements.GetIDColumn(driver).click();
		  
		  
	  }
	 
	 @AfterClass
	 public void afterClass() {
		 // driver.quit();		  
	 }

}
