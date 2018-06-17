package GlobalFiles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ObjectRepository.AddProductDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;

public class Debug {
	public static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = CommonFunctions.SetupEnvironment(CommonFunctions.url, "chrome");
		Thread.sleep(5000);
		  CommonFunctions.Login(driver);
		  Thread.sleep(5000);
		  DashboardPageElements.GetRegisterManagementLink(driver).click();
		  Thread.sleep(5000);
		  RegisterManagementDashboardPageElements.GetProductsTab(driver).click();
		  Thread.sleep(5000);
		  RegisterManagementDashboardPageElements.GetSelectOptionDropdown(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Product").click();
		  Thread.sleep(3000);
		  List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		  System.out.println("iframe length = " + iframeElements.size());
		  driver.switchTo().frame(0);
		  

		  
		  AddProductDialogBoxElements.GetSalesTaxTab(driver).click();
		  Thread.sleep(3000);
		  AddProductDialogBoxElements.GetSalesTax_FirstRowOfTaxOptionNameColumn(driver).click();
		  AddProductDialogBoxElements.GetSalesTax_FirstRowOfTaxOptionNameColumn(driver).click();
		  Thread.sleep(5000);
		  try
		  {
			  driver.findElement(By.xpath("//*[@id='TaxOptionName_listbox']//li[1]")).click();  
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
		  
		  

	}

}
