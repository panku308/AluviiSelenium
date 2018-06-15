package GlobalFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageMembershipsPageElements {
private static WebElement element = null;
	
	
	public static WebElement GetSearchTextField(WebDriver driver)
	{
		element =driver.findElement(By.id("searchbox"));
		return element;
	}
	public static WebElement GetSearchButtonField(WebDriver driver)
	{
		element =driver.findElement(By.id("buttonSearchbox"));
		return element;
	}
	public static WebElement GetAccountOptionDropdown(WebDriver driver)
	{
		element =driver.findElement(By.id("accountoptionsmenu"));
		return element;
	}
	public static WebElement GetCreateNewAccountLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Create New Account"));
		return element;
	}
	
	public static WebElement GetAccountsTableFirstRowEmailColum(WebDriver driver)
	{
		element =driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/table/tbody/tr/td[8]"));
		return element;
	}
}
