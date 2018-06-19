package WaiverTest;

import org.testng.annotations.Test;



import GlobalFiles.CommonFunctions;
import ObjectRepository.AddWaiverDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import ObjectRepository.WaiverManagementPageElements;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class AddWaiverTest {



	  public static WebDriver driver=null;
	  String expectedResult="", actualResult="";
	  String WaiverName="";
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.SetupEnvironment(CommonFunctions.url, "chrome");
		  Thread.sleep(5000);
	  }
	  @Test (priority=1)
	  public void AddWaiver_ReqAllGuestToSign()throws Exception
	  {
		  WaiverName = "waiver" + System.currentTimeMillis();
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  
		  CommonFunctions.Login(driver);
		  Thread.sleep(5000);
		  
		  Thread.sleep(2000);
		  js.executeScript("arguments[0].scrollIntoView();",DashboardPageElements.GetWaiverManagementLink(driver));
		  DashboardPageElements.GetWaiverManagementLink(driver).click();
		  Thread.sleep(5000);
		  
		  WaiverManagementPageElements.GetSelectOptionDropdown(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Waiver").click();
		  Thread.sleep(5000);
		  
		  List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		  
		  System.out.println("iframe length = " + iframeElements.size());
		  
		  driver.switchTo().frame(0);		
		  AddWaiverDialogBoxElements.GetWaiverNameField(driver).sendKeys(WaiverName);
		  AddWaiverDialogBoxElements.GetMemberShipDropDown(driver).click();
		  Thread.sleep(3000);		  
		  AddWaiverDialogBoxElements.SelectOptionFromSelectOptionDD(driver, "2018 Waiver").click();
		  // switching to child frame.
		  List<WebElement> iframeElements1 = driver.findElements(By.tagName("iframe"));
		  System.out.println("iframe length = " + iframeElements1.size());
		  driver.switchTo().frame(0);
		  driver.findElement(By.cssSelector("body")).sendKeys("test message");
		  //Switching back to main frame.
		  
		  driver.switchTo().parentFrame();
		  Thread.sleep(3000);	
		  
		  AddWaiverDialogBoxElements.GetReqAllGuestRadioButton(driver).click();
		  
		  for (int i=0;i<18;i++)
		  {
			  AddWaiverDialogBoxElements.GetMinAgeDropdownUpArrow(driver).click();
		  }
		  AddWaiverDialogBoxElements.GetSubmitWaiverButton(driver).click();
		  Thread.sleep(10000);
		 driver.switchTo().defaultContent();
		  System.out.println(driver.getWindowHandle());
		  
		 driver.navigate().refresh();
		 Thread.sleep(10000);
		  WaiverManagementPageElements.GetIDColumn(driver).click();
		  Thread.sleep(3000);
		  WaiverManagementPageElements.GetIDColumn(driver).click();
		  Thread.sleep(5000);
		  actualResult = WaiverManagementPageElements.GetWaiverNameOfFirstRow(driver).getText();
		  assertEquals(actualResult, WaiverName);
	  }
	  
	  @Test (priority=2)
	  public void AddWaiver_ReqAllGuestOverMinAge()throws Exception
	  {
		  WaiverName = "waiver" + System.currentTimeMillis();
		  WaiverManagementPageElements.GetSelectOptionDropdown(driver).click();
		  Thread.sleep(3000);		  
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Waiver").click();
		  Thread.sleep(5000);
		  
		  List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		  
		  System.out.println("iframe length = " + iframeElements.size());
		  
		  driver.switchTo().frame(0);		
		  AddWaiverDialogBoxElements.GetWaiverNameField(driver).sendKeys(WaiverName);
		  AddWaiverDialogBoxElements.GetMemberShipDropDown(driver).click();
		  Thread.sleep(3000);		  
		  AddWaiverDialogBoxElements.SelectOptionFromSelectOptionDD(driver, "2018 Waiver").click();
		  // switching to child frame.
		  List<WebElement> iframeElements1 = driver.findElements(By.tagName("iframe"));
		  System.out.println("iframe length = " + iframeElements1.size());
		  driver.switchTo().frame(0);
		  driver.findElement(By.cssSelector("body")).sendKeys("test message");
		  //Switching back to main frame.
		  
		  driver.switchTo().parentFrame();
		  Thread.sleep(3000);	
		  
		  AddWaiverDialogBoxElements.GetReqAllGuestOverMinAgeRadioButton(driver).click();
		  
		  for (int i=0;i<18;i++)
		  {
			  AddWaiverDialogBoxElements.GetMinAgeDropdownUpArrow(driver).click();
		  }
		  AddWaiverDialogBoxElements.GetSubmitWaiverButton(driver).click();
		  Thread.sleep(10000);
		 driver.switchTo().defaultContent();
		  System.out.println(driver.getWindowHandle());
		  
		 driver.navigate().refresh();
		 Thread.sleep(10000);
		  WaiverManagementPageElements.GetIDColumn(driver).click();
		  Thread.sleep(3000);
		  WaiverManagementPageElements.GetIDColumn(driver).click();
		  Thread.sleep(5000);
		  actualResult = WaiverManagementPageElements.GetWaiverNameOfFirstRow(driver).getText();
		  assertEquals(actualResult, WaiverName);
	  }
	  @Test (priority=3)
	  public void AddWaiver_OnlyOneGuest()throws Exception
	  {
		  WaiverName = "waiver" + System.currentTimeMillis();
		  WaiverManagementPageElements.GetSelectOptionDropdown(driver).click();
		  Thread.sleep(3000);		  
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Waiver").click();
		  Thread.sleep(5000);
		  
		  List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		  
		  System.out.println("iframe length = " + iframeElements.size());
		  
		  driver.switchTo().frame(0);		
		  AddWaiverDialogBoxElements.GetWaiverNameField(driver).sendKeys(WaiverName);
		  AddWaiverDialogBoxElements.GetMemberShipDropDown(driver).click();
		  Thread.sleep(3000);		  
		  AddWaiverDialogBoxElements.SelectOptionFromSelectOptionDD(driver, "2018 Waiver").click();
		  // switching to child frame.
		  List<WebElement> iframeElements1 = driver.findElements(By.tagName("iframe"));
		  System.out.println("iframe length = " + iframeElements1.size());
		  driver.switchTo().frame(0);
		  driver.findElement(By.cssSelector("body")).sendKeys("test message");
		  //Switching back to main frame.
		  
		  driver.switchTo().parentFrame();
		  Thread.sleep(3000);	
		  
		  AddWaiverDialogBoxElements.GetReqOneGuestRadioButton(driver).click();
		  
		  for (int i=0;i<18;i++)
		  {
			  AddWaiverDialogBoxElements.GetMinAgeDropdownUpArrow(driver).click();
		  }
		  AddWaiverDialogBoxElements.GetSubmitWaiverButton(driver).click();
		  Thread.sleep(10000);
		 driver.switchTo().defaultContent();
		  System.out.println(driver.getWindowHandle());
		  
		 driver.navigate().refresh();
		 Thread.sleep(10000);
		  WaiverManagementPageElements.GetIDColumn(driver).click();
		  Thread.sleep(3000);
		  WaiverManagementPageElements.GetIDColumn(driver).click();
		  Thread.sleep(5000);
		  actualResult = WaiverManagementPageElements.GetWaiverNameOfFirstRow(driver).getText();
		  assertEquals(actualResult, WaiverName);
	  }
	
	  @AfterClass
	  public void afterClass() {
	//	  driver.quit();
		  
	  }


}
