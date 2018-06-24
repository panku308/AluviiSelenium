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


public class HRManagementPage extends BasePage{

	WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), 20);

	@FindBy(xpath = "//h1[contains(text(),'HR Management Dashboard')]")
	private WebElement pageTitle;

	@FindBy(xpath = "//*[@id='tabstrip']/ul/li//a[text()='Manage Employees']")
	private WebElement manageEmployeesTab;

	@FindBy(xpath = "//*[@id='tabstrip-1']//*[text()='Select Option']")
	private WebElement selectOption;

	@FindBy(xpath = "//*[@id='ddEmployeeTask_listbox']/li")
	private List<WebElement> selectOptionOptions;

	@FindBy(id = "FirstName")
	private WebElement FirstName;

	@FindBy(id = "LastName")
	private WebElement LastName;

	@FindBy(id = "EmployeeEmail")
	private WebElement EmployeeEmail;

	@FindBy(xpath = "//*[@id='employeeEdit']/div[1]/div[12]/div/input")
	private WebElement submitButton;

	@FindBy(xpath = "//*[@id='popupWindow_wnd_title' and text()='Add Employee']")
	private WebElement addEmployeePagePopup;

	@FindBy(xpath = "//*[@id='popupWindow_wnd_title' and text()='Edit Employee']")
	private WebElement editEmployeePagePopup;

	@FindBy(css = "iframe[title='Add Employee']")
	private WebElement addEmployeeFrame;

	@FindBy(css = "iframe[title='Add Login Activity']")
	private WebElement addLoginActivityFrame;

	@FindBy(xpath = "//*[@id='HREmployeesActivityGrid']//a[text()='Last Accessed']")
	private WebElement lastAccessed;

	@FindBy(xpath = "//*[@id='HREmployeesActivityGrid']//a[4]")
	private WebElement lastPage;
	
	@FindBy(xpath = "//*[@id='HREmployeesActivityGrid']//a[text()='Email']/preceding-sibling::a")
	private WebElement emailColumnMenu;
	
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

	@FindBy(xpath = "//*[@id='HREmployeesActivityGrid']//tbody//td[3]")
	private List<WebElement> registeredEmail;

	@FindBy(xpath = "//a[text()='Set Password']")
	private WebElement setPasswordMenu;
	
	@FindBy(xpath = "//a[text()='Login Activities']")
	private WebElement loginActivitiesMenu;
	
	@FindBy(xpath = "//*[@value='Add Login Activity']")
	private WebElement addLoginActivity;
	
	@FindBy(xpath = "//span[text()='Select Activity']")
	private WebElement selectAcitivity;
	
	@FindBy(xpath = "//*[text()='Select Activity']/..//li")
	private List<WebElement> selectAcitivityList;

	@FindBy(id = "btnSaveActivity")
	private WebElement addActivity;

	@FindBy(id = "NewPassword")
	private WebElement NewPassword;

	@FindBy(id = "ConfirmPassword")
	private WebElement ConfirmPassword;

	@FindBy(id = "password-button")
	private WebElement UpdatePasswordButton;

	@FindBy(xpath = "//a[@aria-label='Close']")
	private WebElement popupCloseButton;

	@FindBy(id = "username")
	private WebElement userMenu;

	@FindBy(xpath = "//*[@id='user-menu-dropdown']//a[contains(text(),'Logout')]")
	private WebElement logoutButton;

	public HRManagementPage clickManageEmployeesTab() {

		manageEmployeesTab.click();
		return this;
	}

	public HRManagementPage selectOptions(String option) {

		selectOption.click();				

		wait.until(ExpectedConditions.visibilityOf(selectOptionOptions.get(1)));

		Actions action = new Actions(DriverManager.getDriver());		
		for(int i=0;i<selectOptionOptions.size();i++)
		{
			if(selectOptionOptions.get(i).getText().equals(option))
				action.moveToElement(selectOptionOptions.get(i)).click().build().perform();
		}

		DriverManager.getDriver().switchTo().frame(0);
		return this;
	}

	public boolean checkAddEmployeePopup() {

		try {			
			wait.until(ExpectedConditions.visibilityOf(addEmployeePagePopup));	
			DriverManager.getDriver().switchTo().frame(addEmployeeFrame);			

			return true;

		}catch(Exception e)	{

			return false;
		}


	}



	public HRManagementPage typeFirstName(String input) {

		wait.until(ExpectedConditions.visibilityOf(FirstName));
		FirstName.sendKeys(input);
		return this;
	}

	public HRManagementPage typeLastName(String input) {

		LastName.sendKeys(input);
		return this;
	}

	public HRManagementPage typeEmployeeEmail(String input) {

		EmployeeEmail.sendKeys(input);
		return this;
	}

	public HRManagementPage clickSave() {

		((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].click();", submitButton);


		DriverManager.getDriver().switchTo().defaultContent();		
		try{Thread.sleep(2000);}catch(Exception e){}
		return this;
	}

	public HRManagementPage moveToLastPage() {

		wait.until(ExpectedConditions.elementToBeClickable(lastPage));
		//((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].click();", lastPage);

		Actions action = new Actions(DriverManager.getDriver());	
		action.moveToElement(lastPage).click().build().perform();
		try{Thread.sleep(2000);}catch(Exception e){}
		return this;
	}
	
	public HRManagementPage filterRegisteredEmployeeByEmail(String email) {

		emailColumnMenu.click();
		try{Thread.sleep(1000);}catch(Exception e){}
		filter.click();
		try{Thread.sleep(2000);}catch(Exception e){}
		filterDefault.click();
		try{Thread.sleep(2000);}catch(Exception e){}
		selectFilterEqualTo.click();
		try{Thread.sleep(1000);}catch(Exception e){}
		filterInput.sendKeys(email);
		try{Thread.sleep(1000);}catch(Exception e){}
		filterButton.click();	
		try{Thread.sleep(2000);}catch(Exception e){}
		return this;
	}

	public HRManagementPage sortByLastAccessed() {

		wait.until(ExpectedConditions.elementToBeClickable(lastAccessed));
		((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", lastAccessed);
		((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].click();", lastAccessed);
		try{Thread.sleep(4000);}catch(Exception e){}
		((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", lastAccessed);
		((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].click();", lastAccessed);
		try{Thread.sleep(2000);}catch(Exception e){}
		return this;
	}


	public String isRegisteredEmail() {

		wait.until(ExpectedConditions.visibilityOf(registeredEmail.get(registeredEmail.size()-1)));

		return registeredEmail.get(registeredEmail.size()-1).getText();
	}

	public HRManagementPage doubleClickRegisteredAccount() {

		Actions action = new Actions(DriverManager.getDriver());
		Action doubleClick=action.doubleClick(registeredEmail.get(registeredEmail.size()-1)).build();
		doubleClick.perform();

		try{Thread.sleep(2000);}catch(Exception e){}
		DriverManager.getDriver().switchTo().frame(0);

		return this;
	}

	public boolean checkEditEmployeePopup() {

		try {

			wait.until(ExpectedConditions.visibilityOf(editEmployeePagePopup));	
			System.out.println("wait over");

			DriverManager.getDriver().switchTo().frame(0);
			try{Thread.sleep(2000);}catch(Exception e){}
			return true;

		}catch(Exception e)	{
			System.out.println(e.getMessage());
			return false;
		}


	}

	public HRManagementPage clickLoginActivitiesMenu() {

		((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].click();", loginActivitiesMenu);
		return this;
	}
	
	public HRManagementPage clickAddLoginAcitivity() {

		((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].click();", addLoginActivity);

		try{Thread.sleep(2000);}catch(Exception e){}
		DriverManager.getDriver().switchTo().frame(0);
		return this;
	}
	
	public HRManagementPage selectLoginAcitivity(String activity) {

		Actions action=new Actions(DriverManager.getDriver());
		wait.until(ExpectedConditions.visibilityOf(selectAcitivity));
		action.moveToElement(selectAcitivity).click().build().perform();
		
		try{Thread.sleep(2000);}catch(Exception e){}
		
		for(int i=0;i<selectAcitivityList.size();i++)
		{
			if(selectAcitivityList.get(i).getText().equals(activity))
			{
				action.moveToElement(selectAcitivityList.get(i)).click().build().perform();
			}
		}
		return this;
	}
	
	public HRManagementPage addAcitivity() {

		((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].click();", addActivity);

		try{Thread.sleep(2000);}catch(Exception e){}
		DriverManager.getDriver().switchTo().defaultContent();	
		DriverManager.getDriver().switchTo().frame(0);
		return this;
	}

	public HRManagementPage clickSetPasswordMenu() {

		((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].click();", setPasswordMenu);
		return this;
	}

	public HRManagementPage setNewPassword(String input) {

		((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", NewPassword);
		NewPassword.sendKeys(input);
		return this;
	}

	public HRManagementPage setConfirmPassword(String input) {

		((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", ConfirmPassword);
		ConfirmPassword.sendKeys(input);
		return this;
	}

	public HRManagementPage clickUpdatePassword() {

		((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", UpdatePasswordButton);
		((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].click();", UpdatePasswordButton);

		DriverManager.getDriver().switchTo().defaultContent();		
		try{Thread.sleep(2000);}catch(Exception e){}

		return this;
	}

	public HRManagementPage clickClosePopupButton() {

		((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].click();", popupCloseButton);
		return this;
	}

	public LoginPage logout() {

		try{Thread.sleep(2000);}catch(Exception e){}
		Actions action=new Actions(DriverManager.getDriver());
		action.moveToElement(userMenu).clickAndHold();
		try{Thread.sleep(2000);}catch(Exception e){}
		action.moveToElement(logoutButton).click().build().perform();
		return (LoginPage) openPage(LoginPage.class);
	}

	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(pageTitle);
	}

}
