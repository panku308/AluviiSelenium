package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddWaiverDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement GetWaiverNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("WaiverName"));
		return element;
	}
	public static WebElement GetMemberShipDropDown(WebDriver driver)
	{
		element =driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/form/div[1]/div[5]/div[1]/div[2]/div[2]/span/span/span[1]"));
		return element;
	}
	public static WebElement GetWaiverLanguageTextArea(WebDriver driver)
	{
		element =driver.findElement(By.xpath("/html/body"));
		return element;
	}	
	public static WebElement GetReqAllGuestRadioButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//input[@id='WaiverSignConfig'][@value='0'] "));
		return element;
	}
	public static WebElement GetReqAllGuestOverMinAgeRadioButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//input[@id='WaiverSignConfig'][@value='1'] "));
		return element;
	}
	public static WebElement GetReqOneGuestRadioButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//input[@id='WaiverSignConfig'][@value='2'] "));
		return element;
	}
	public static WebElement GetMinAgeDropdownUpArrow(WebDriver driver)
	{
		element =driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/form/div[1]/div[13]/div[1]/div/div[2]/span/span/span/span[1]/span"));
		return element;
	}
	public static WebElement GetSubmitWaiverButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnSubmit"));
		return element;
	}
	public static WebElement GetCancelButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnCancel"));
		return element;
	}
	public static WebElement SelectOptionFromSelectOptionDD(WebDriver driver, String OptName)
	{
		element =driver.findElement(By.xpath("//li[text() = '"+OptName+"']"));
		return element;
	}
}
