package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import pages.CashControlPage;
import pages.DashboardPage;
import pages.HRManagementPage;
import pages.LoginPage;
import baseSetup.TestSetUp;

public class CreateTill extends TestSetUp {



	@Test
	public void createTillTest() {

		LoginPage login= new LoginPage().open();

		DashboardPage dashboard = login.typeUsername("TestEmail464@aluvii.com")
				.typePassword("Admin@123")
				.clickLogin();

		CashControlPage ccPage = dashboard.clickCashControl();

		DashboardPage dashboard2=ccPage.clickOpenTillsTab()
		.selectOptions("Create Till")
		.selectLocation("Fritz's Adventure")
		.selectDepartment("Retail")
		.selectSite("Gift Shop")
		.selectEmployeeAssigned("TestFirstName29853 TestLastName8342")
		.selectInititalValue("200")
		.clickSaveAndCreateTill()
		.clickDashboard();
		
		Assert.assertEquals(dashboard2.getCurrentTillStatus(), "Active");
		
		CashControlPage ccPage2 = dashboard2.clickCashControl();
		
		ccPage2.filterAssignedToByEmployeeName("TestFirstName29853 TestLastName8342")
		.selectFilteredRow()
		.selectOptions("Close Till")
		.clickCloseTillButton()
		.clickConfirmCloseTillButton();
		
		DashboardPage dashboard3 = ccPage2.clickDashboard();
		
		Assert.assertEquals(dashboard3.getCurrentTillStatus(), "No Till");

	}

}
