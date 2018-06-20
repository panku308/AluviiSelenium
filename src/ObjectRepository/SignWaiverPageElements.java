package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignWaiverPageElements {
private static WebElement element = null;
	
	
	public static WebElement GetEmailIDField(WebDriver driver)
	{
		element =driver.findElement(By.id("EmailAddress"));
		return element;
	}
	public static WebElement GetPhoneNumberField(WebDriver driver)
	{
		element =driver.findElement(By.id("PhoneNumber"));
		return element;
	}
	public static WebElement GetStreetAddressField(WebDriver driver)
	{
		element =driver.findElement(By.id("StreetAddress"));
		return element;
	}
	public static WebElement GetCityField(WebDriver driver)
	{
		element =driver.findElement(By.id("City"));
		return element;
	}
	public static WebElement GetStateField(WebDriver driver)
	{
		element =driver.findElement(By.id("State"));
		return element;
	}
	public static WebElement GetZipCodeField(WebDriver driver)
	{
		element =driver.findElement(By.id("ZipCode"));
		return element;
	}
	public static WebElement GetAddGuestButton(WebDriver driver)
	{
		element =driver.findElement(By.id("addGuest"));
		return element;
	}
	public static WebElement GetAddCancelButton(WebDriver driver)
	{
		element =driver.findElement(By.id("cancelWaiver"));
		return element;
	}
	public static WebElement GetIMFinishedButton(WebDriver driver)
	{
		
		element =driver.findElement(By.id("imFinished"));
		return element;
	}
	// Parent fields
	
	public static WebElement GetFirstNameField(WebDriver driver, int GuestNumber)
	{
		
		element =driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/form/div/div[3]/div["+GuestNumber+"]/div[2]/div/div[1]/div[1]/div/label/following::input"));
		return element;
	}
	public static WebElement GetLastNameField(WebDriver driver, int GuestNumber)
	{
		
		element =driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/form/div/div[3]/div["+GuestNumber+"]/div[2]/div/div[1]/div[2]/div/label/following::input"));
		return element;
	}
	public static WebElement GetYearDropdown(WebDriver driver, int GuestNumber)
	{
		element =driver.findElement(By.id("guestyear"+GuestNumber));
		return element;
	}
	public static WebElement GetMonthDropdown(WebDriver driver,int GuestNumber)
	{
		element =driver.findElement(By.id("guestmonth"+GuestNumber));
		return element;
	}
	public static WebElement GetDayDropdown(WebDriver driver, int GuestNumber)
	{
		element =driver.findElement(By.id("guestday"+GuestNumber));
		return element;
	}
	public static WebElement GetSignatureField(WebDriver driver, int GuestNumber)
	{
		element =driver.findElement(By.id("signature-canvas-"+GuestNumber));
		return element;
	}
	
}
