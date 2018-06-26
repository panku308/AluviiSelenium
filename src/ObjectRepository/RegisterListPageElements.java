package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterListPageElements {
private static WebElement element = null;
	
	
	public static WebElement GetRegisterLink(WebDriver driver, String RegisterName)
	{
		
		element =driver.findElement(By.xpath("//div[@id='listView']//h1[text()='"+RegisterName+"']"));
		return element;
	}

}
