package GlobalFiles;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import ObjectRepository.LoginPageElements;

public class CommonFunctions {
	public static WebDriver driver = null;
	public static String domainName="https://sessionqa";
	public static String url=domainName+".aluvii.com/employee/";
	public static String UserName="ceo@aluvii.com";
	public static String Password="Admin@123";
	public static String chromeDriverPath="C:\\Users\\DELL\\Downloads\\Softwares\\chromedriver_win32\\chromedriver.exe";
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
	public static void SelectValueFromDropdown(WebElement element, String OptName)
	{
		element.click();
		Select ObjSelect = new Select(element);
		ObjSelect.selectByValue(OptName);
	}
	
	public static void SelectValueFromDropdownByVisibleText(WebElement element, String OptName)
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
