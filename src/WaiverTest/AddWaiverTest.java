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
		 
		  
		  CommonFunctions.Login(driver);
		  Thread.sleep(5000);
		  
		  Thread.sleep(2000);
		  WaiverManagementPageElements.OpenWaiverManagementPage(driver);
		  AddWaiverDialogBoxElements.AddWaiver(driver, WaiverName, 1);
	  }
	  
	  @Test (priority=2)
	  public void AddWaiver_ReqAllGuestOverMinAge()throws Exception
	  {
		  WaiverName = "waiver" + System.currentTimeMillis();
		  AddWaiverDialogBoxElements.AddWaiver(driver, WaiverName, 2);
	  }
	  @Test (priority=3)
	  public void AddWaiver_OnlyOneGuest()throws Exception
	  {
		  WaiverName = "waiver" + System.currentTimeMillis();
		  AddWaiverDialogBoxElements.AddWaiver(driver, WaiverName, 3);
	  }
	
	  @AfterClass
	  public void afterClass() {
		  driver.quit();
		  
	  }


}
