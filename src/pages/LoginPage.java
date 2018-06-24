package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class LoginPage extends BasePage{
	
	@FindBy(xpath = "//h2[text()='Employee Portal']")
	private WebElement loginPortalHeader;

	@FindBy(id = "UserName")
	private WebElement userName;

	@FindBy(id = "Password")
	private WebElement password;

	@FindBy(id = "btnSubmit")
	private WebElement loginButton;


	
	public LoginPage open()
	{
		return (LoginPage)openPage(LoginPage.class);
	}


	public LoginPage typeUsername(String input) {

		userName.sendKeys(input);
		return this;
	}

	public LoginPage typePassword(String input) {

		password.sendKeys(input);
		return this;
	}

	public DashboardPage clickLogin() {

		loginButton.click();
		return (DashboardPage) openPage(DashboardPage.class);
	}
	
	

	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(loginButton);
	}
	



	

}
