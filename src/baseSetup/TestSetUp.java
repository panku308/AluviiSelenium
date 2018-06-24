package baseSetup;


import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import util.PropertyFileManager;
import util.DriverFactory;
import util.DriverManager;



public class TestSetUp {

	protected static Properties configProperty;
	protected WebDriver driver = null;

	@BeforeSuite
	public void setUp() {
		
		PropertyFileManager.setConfigFilePath(
				System.getProperty("user.dir") + "\\src\\config.properties");

		DriverFactory.setChromeExeFilePath(System.getProperty("user.dir")
				+ "\\src\\chromedriver.exe");

	}

	@BeforeTest
	public void beforeTest() {

	}

	@BeforeClass
	public void beforeClass() {
		
		System.out.println("before class called");
		configProperty = PropertyFileManager.createConfigFileProperty();

		
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		System.out.println("before method called");		
		WebDriver driver = null;
		System.out.println("executing beforeMethod");
		
		if (driver == null) {
			driver = DriverFactory.createDriverInstance(configProperty.getProperty("browser"));
			DriverManager.getDriver().navigate().to(configProperty.getProperty("aluviiSite"));
			

		}

		
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
			
		DriverManager.getDriver().quit();

	}

	@AfterClass
	public void afterClass() {

	}

	@AfterTest
	public void afterTest() {

	}

	@AfterSuite
	public void tearDown() {
	
	}
	
	
}
