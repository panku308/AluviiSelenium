package GlobalFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPageElements {
private static WebElement element = null;
	
	
	public static WebElement GetManageMemberShipLink(WebDriver driver)
	{
		element =driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[4]/a/span"));
		return element;
	}
	

}
