package GlobalFiles;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import ObjectRepository.LoginPageElements;

public class CommonFunctions {
	//--------------------------------------------Global Variables------------------------------------------------------
	public static String domainName="https://sessionqa";
	public static String url=domainName+".aluvii.com/employee/";
	public static String UserName="ceo@aluvii.com";
	public static String Password="Admin@123";
	public static String chromeDriverPath="C:\\chromedriver_win32\\chromedriver.exe";
	
	
	public static int CreateProduct_unitPrice=5;
	//-------------------------------------------------------------------------------------------------------------------
	public static WebDriver driver = null;
	private static WebElement element=null;
	
	public static WebDriver SetupEnvironment(String url, String Browser)
	{
		if (Browser.toLowerCase().equals("chrome"))			
		{
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	public static void SelectOptionFromDropdownByValue(WebElement element, String OptName)
	{
		element.click();
		Select ObjSelect = new Select(element);
		ObjSelect.selectByValue(OptName);
	}
	public static void SelectOptionFromDropdownByIndex(WebElement element, int indexID)
	{
		element.click();
		Select ObjSelect = new Select(element);
		ObjSelect.selectByIndex(indexID);
	}
	
	public static void SelectOptionFromDropdownByVisibleText(WebElement element, String OptName)
	{
		element.click();
		Select ObjSelect = new Select(element);
		ObjSelect.selectByVisibleText(OptName);
	}
	
	public static void Login(WebDriver driver) throws InterruptedException
	{
	
		clearLoginFields();
		
		LoginPageElements.GetUsernameField(driver).sendKeys(UserName);
		LoginPageElements.GetPasswordField(driver).sendKeys(Password);
		LoginPageElements.GetLoginButton(driver).click();
		Thread.sleep(5000);
		
	}
	
	public static void clearLoginFields()
	{
		LoginPageElements.GetUsernameField(driver).clear();
		LoginPageElements.GetPasswordField(driver).clear();
	}
	
}
