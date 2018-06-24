package RegisterManagementTest;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddCategoryDialogBoxElements;
import ObjectRepository.AddCategoryDialogboxInsideAddRegisterPageElements;
import ObjectRepository.AddRegisterDialogboxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;

public class CreateRegisterTest {
	  public static WebDriver driver=null;
	  public static String expectedResult="", actualResult="";
	  public static String RegisterName="Register_" + System.currentTimeMillis();
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.SetupEnvironment(CommonFunctions.url, "chrome");
		  Thread.sleep(5000);
	  }
	  @Test
	  public static void AddRegisterTest()throws Exception
	  {
		  CommonFunctions.Login(driver);
		  Thread.sleep(5000);
		  DashboardPageElements.GetRegisterManagementLink(driver).click();
		  Thread.sleep(5000);
		  RegisterManagementDashboardPageElements.GetRegistersTab(driver).click();
		  Thread.sleep(5000);
		  RegisterManagementDashboardPageElements.GetRegistersTab_subtab_Registers(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.GetRegistersTab_SubTab_Registers_SelectOptionDropdown(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Register").click();
		  Thread.sleep(3000);
		  List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		  System.out.println("iframe length = " + iframeElements.size());
		  driver.switchTo().frame(0);
		  AddRegisterDialogboxElements.GetRegisterNameField(driver).sendKeys(RegisterName);
		  
		  AddRegisterDialogboxElements.GetLocationDD(driver).click();
		  Thread.sleep(2000);
		  AddRegisterDialogboxElements.SelectFirstOptionFromLocationDD(driver);
		  
		  AddRegisterDialogboxElements.GetThermalReceiptDD(driver).click();
		  Thread.sleep(2000);
		  AddRegisterDialogboxElements.SelectFirstOptionFromThermalReceiptDD(driver);
		  
		  AddRegisterDialogboxElements.GetAdvancedReceiptDD(driver).click();
		  Thread.sleep(2000);
		  AddRegisterDialogboxElements.SelectFirstOptionFromAdvancedReceiptDD(driver);
		  
		  AddRegisterDialogboxElements.GetEmailReceiptDD(driver).click();
		  Thread.sleep(2000);
		  AddRegisterDialogboxElements.SelectFirstOptionFromEmailReceiptDD(driver);
		  
		  AddRegisterDialogboxElements.GetEmailConfigurationDD(driver).click();
		  Thread.sleep(2000);
		  AddRegisterDialogboxElements.SelectFirstOptionFromEmailConfigurationDD(driver);
		  
		  AddRegisterDialogboxElements.GetAddCategoryButton(driver).click();		  
		  Thread.sleep(2000);
		  List<WebElement> iframeElements1 = driver.findElements(By.tagName("iframe"));
		  System.out.println("iframe length = " + iframeElements1.size());
		  driver.switchTo().frame(0);
		  
		  AddCategoryDialogboxInsideAddRegisterPageElements.GetCategoryDD(driver).click();
		  Thread.sleep(2000);
		  AddCategoryDialogboxInsideAddRegisterPageElements.SelectValueFromCategoryDD(driver, "2.1rc1RegCat");
		  Thread.sleep(2000);
		  AddCategoryDialogboxInsideAddRegisterPageElements.GetAddCategoryButton(driver).click();
		  Thread.sleep(2000);
		  driver.switchTo().parentFrame();
		  		  
		  AddRegisterDialogboxElements.GetSaveChangesButton(driver).click();
		  Thread.sleep(5000);
		  driver.switchTo().defaultContent();
		  
		  
		  RegisterManagementDashboardPageElements.GetRegistersTab_SubTab_Registers_IDColumn(driver).click();
		  Thread.sleep(5000);
		  RegisterManagementDashboardPageElements.GetRegistersTab_SubTab_Registers_IDColumn(driver).click();
		  Thread.sleep(5000);
		  actualResult = RegisterManagementDashboardPageElements.GetRegistersTab_SubTab_Registers_FirstRowRegisterNameCloumn(driver).getText();
		  assertEquals(actualResult, RegisterName);
		  
	  }
	  
	  @AfterClass
	  public void afterClass() {
		//  driver.quit();
		  
	  }
}
