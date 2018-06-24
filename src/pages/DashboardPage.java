package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class DashboardPage extends BasePage{
	

	@FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
	private WebElement pageTitle;
	
	@FindBy(id = "myLink_1004")
	private WebElement hrManagementMenuButton;
	
	@FindBy(id = "myLink_1007")
	private WebElement cashControlMenuButton;
	
	@FindBy(id = "current-till-status")
	private WebElement currentTillStatus;
	
	
	
	@FindBy(xpath = "//*[@id='sidebar']//li//span")
	private List<WebElement> sidebarMenus;
	
	
	public boolean checkSidebarMenus(String menu) {

		for(int i=0;i<sidebarMenus.size();i++)
		{
			if(sidebarMenus.get(i).getText().equals(menu))
				return true;
		}
		
		
		return false;
	}

	
	public HRManagementPage clickHRManagement() {

		hrManagementMenuButton.click();
		return (HRManagementPage) openPage(HRManagementPage.class);
	}
	
	public CashControlPage clickCashControl() {

		cashControlMenuButton.click();
		return (CashControlPage) openPage(CashControlPage.class);
	}
	
	public String getCurrentTillStatus() {
		
		return currentTillStatus.getText();
	}
	
	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(pageTitle);
	}
	

}
