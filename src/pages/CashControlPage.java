package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import util.DriverManager;


public class CashControlPage extends BasePage{

	WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), 20);

	@FindBy(xpath = "//h1[contains(text(),'Cash Control')]")
	private WebElement pageTitle;
	
	@FindBy(id = "myLink_1014")
	private WebElement dashboardMenuButton;

	@FindBy(xpath = "//*[@id='tabstrip']/ul/li//a[text()='Open Tills']")
	private WebElement openTillsTab;
	
	@FindBy(xpath = "//*[@id='tabstrip-1']//*[text()='Select Option']")
	private WebElement selectOption;

	@FindBy(xpath = "//*[@id='ddOpenTill_listbox']/li")
	private List<WebElement> selectOptionOptions;
	
	@FindBy(xpath = "//*[text()='Select Location']")
	private WebElement selectLocation;

	@FindBy(xpath = "//*[text()='Select Location']/..//li")
	private List<WebElement> selectLocationOption;
	
	@FindBy(xpath = "//*[text()='Select Department']")
	private WebElement selectDepartment;

	@FindBy(xpath = "//*[text()='Select Department']/..//li")
	private List<WebElement> selectDepartmentOption;
	
	@FindBy(xpath = "//*[text()='Select Site']")
	private WebElement selectSite;

	@FindBy(xpath = "//*[text()='Select Site']/..//li")
	private List<WebElement> selectSiteOption;
	
	@FindBy(xpath = "//*[@id='employeeDisplay']//input")
	private WebElement employeeAssigned;
	
	@FindBy(xpath = "//*[@id='EmployeeIdNameList_listbox']/li")
	private List<WebElement> employeeAssignedList;
	
	@FindBy(xpath = "html/body/div[1]/div/div[1]/div[1]/div[1]/div[3]/span/span/span/span[1]/span")
	private WebElement initialValue;
	
	@FindBy(id = "btnSaveCreateTill")
	private WebElement saveCreateTill;
	
	@FindBy(xpath = "//*[@id='tillgrid']//a[text()='Assigned To']/preceding-sibling::a")
	private WebElement AssignedToColumnMenu;
	
	@FindBy(xpath = "//span[text()='Filter']")
	private WebElement filter;
	
	@FindBy(xpath = "//select[@title='Operator']/..")
	private WebElement filterDefault;
	
	@FindBy(xpath = "//li[text()='Is equal to']")
	private WebElement selectFilterEqualTo;
	
	@FindBy(xpath = "//select[@title='Operator']/../following-sibling::input")
	private WebElement filterInput;
	
	@FindBy(xpath = "//button[text()='Filter']")
	private WebElement filterButton;
	
	@FindBy(xpath = "//*[@id='tillgrid']//tbody//td[3]")
	private List<WebElement> assignedToName;
	
	@FindBy(id = "btnCloseTill")
	private WebElement closeTillButton;
	
	@FindBy(id = "yes")
	private WebElement confirmCloseTill;
	
	public CashControlPage clickOpenTillsTab() {

		openTillsTab.click();
		return this;
	}
	
	
	public CashControlPage selectOptions(String option) {

		selectOption.click();				

		wait.until(ExpectedConditions.visibilityOf(selectOptionOptions.get(1)));

		Actions action = new Actions(DriverManager.getDriver());		
		for(int i=0;i<selectOptionOptions.size();i++)
		{
			if(selectOptionOptions.get(i).getText().equals(option))
				action.moveToElement(selectOptionOptions.get(i)).click().build().perform();
		}

		DriverManager.getDriver().switchTo().frame(0);
		
		try{Thread.sleep(2000);}catch(Exception e){}
		return this;
	}
	
	public CashControlPage selectLocation(String option) {

		selectLocation.click();				

		wait.until(ExpectedConditions.visibilityOf(selectLocationOption.get(1)));

		Actions action = new Actions(DriverManager.getDriver());		
		for(int i=0;i<selectLocationOption.size();i++)
		{
			if(selectLocationOption.get(i).getText().equals(option))
				action.moveToElement(selectLocationOption.get(i)).click().build().perform();
		}
		
		try{Thread.sleep(2000);}catch(Exception e){}
		return this;
	}
	
	public CashControlPage selectDepartment(String option) {

		selectDepartment.click();				

		wait.until(ExpectedConditions.visibilityOf(selectDepartmentOption.get(1)));

		Actions action = new Actions(DriverManager.getDriver());		
		for(int i=0;i<selectDepartmentOption.size();i++)
		{
			if(selectDepartmentOption.get(i).getText().equals(option))
				action.moveToElement(selectDepartmentOption.get(i)).click().build().perform();
		}
		
		try{Thread.sleep(2000);}catch(Exception e){}
		return this;
	}
	
	public CashControlPage selectSite(String option) {

		selectSite.click();				

		wait.until(ExpectedConditions.visibilityOf(selectSiteOption.get(0)));

		Actions action = new Actions(DriverManager.getDriver());		
		for(int i=0;i<selectSiteOption.size();i++)
		{
			if(selectSiteOption.get(i).getText().equals(option))
				action.moveToElement(selectSiteOption.get(i)).click().build().perform();
		}		
		try{Thread.sleep(2000);}catch(Exception e){}
		return this;
	}
	
	public CashControlPage selectEmployeeAssigned(String employee) {

		employeeAssigned.click();				

		wait.until(ExpectedConditions.visibilityOf(employeeAssignedList.get(1)));

		Actions action = new Actions(DriverManager.getDriver());		
		for(int i=0;i<employeeAssignedList.size();i++)
		{
			if(employeeAssignedList.get(i).getText().equals(employee))
				action.moveToElement(employeeAssignedList.get(i)).click().build().perform();
		}		
		try{Thread.sleep(2000);}catch(Exception e){}
		return this;
	}
	
	public CashControlPage selectInititalValue(String value) {

		int count=Integer.parseInt(value);
		
		while(count>1)
		{
			initialValue.click();
			count--;
		}

		return this;
	}
	public CashControlPage clickSaveAndCreateTill() {
	

		saveCreateTill.click();
		try{Thread.sleep(2000);}catch(Exception e){}

		return this;
	}
	
	public DashboardPage clickDashboard() {

		dashboardMenuButton.click();

		return (DashboardPage) openPage(DashboardPage.class);
	}
	
	public CashControlPage selectFilteredRow() {

		assignedToName.get(assignedToName.size()-1).click();
		return this;
	}
	
	public CashControlPage clickCloseTillButton() {

		closeTillButton.click();
		try{Thread.sleep(2000);}catch(Exception e){}
		return this;
	}
	
	public CashControlPage clickConfirmCloseTillButton() {

		confirmCloseTill.click();
		try{Thread.sleep(2000);}catch(Exception e){}
		DriverManager.getDriver().switchTo().defaultContent();
		return this;
	}
	
	public CashControlPage filterAssignedToByEmployeeName(String empName) {

		AssignedToColumnMenu.click();
		try{Thread.sleep(1000);}catch(Exception e){}
		filter.click();
		try{Thread.sleep(2000);}catch(Exception e){}
		filterDefault.click();
		try{Thread.sleep(2000);}catch(Exception e){}
		selectFilterEqualTo.click();
		try{Thread.sleep(1000);}catch(Exception e){}
		filterInput.sendKeys(empName);
		try{Thread.sleep(1000);}catch(Exception e){}
		filterButton.click();	
		try{Thread.sleep(2000);}catch(Exception e){}
		return this;
	}
	
	
	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(pageTitle);
	}

}
