package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryDialogBoxElements {
	private static WebElement element = null;
	public static WebElement GetCategoryName(WebDriver driver)
	{		
		element =driver.findElement(By.xpath("/html/body/div[19]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]/a"));
		return element;
	}

}
