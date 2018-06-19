package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WaiverManagementPageElements {
private static WebElement element = null;
	
	
	public static WebElement GetWaiverTab(WebDriver driver)
	{
		element =driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div/ul/li[1]/a"));
		return element;
	}
	public static WebElement GetSignedWaiverTab(WebDriver driver)
	{
		element =driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div/ul/li[2]/a"));
		return element;
	}
	public static WebElement GetSelectOptionDropdown(WebDriver driver)
	{
		element =driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/div/div[1]/span/span/span[1]"));
		return element;
	}
	public static WebElement GetIDColumn(WebDriver driver)
	{
		element =driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/div/div[3]/div[1]/div/table/thead/tr/th[1]/a[2]"));
		return element;
	}
	public static WebElement GetWaiverNameOfFirstRow(WebDriver driver)
	{
		element =driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/div/div[3]/div[2]/table/tbody/tr[1]/td[2]"));
		return element;
	}
	public static WebElement SelectOptionFromSelectOptionDD(WebDriver driver, String OptName)
	{
		element =driver.findElement(By.xpath("//li[text() = '"+OptName+"']"));
		return element;
	}

}