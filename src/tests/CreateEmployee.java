package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import pages.DashboardPage;
import pages.HRManagementPage;
import pages.LoginPage;
import baseSetup.TestSetUp;

public class CreateEmployee extends TestSetUp {



	@Test
	public void createEmployeeTest() {

		LoginPage login= new LoginPage().open();

		DashboardPage dashboard=login.typeUsername("ceo@aluvii.com")
				.typePassword("Admin@123")
				.clickLogin();

		HRManagementPage hrPage=dashboard.clickHRManagement();

		hrPage.clickManageEmployeesTab()
		.selectOptions("Add Employee");

		String emailToBeRegistered="TestEmail"+CommonFunctions.generateRandomIndex()+"@aluvii.com";
		System.out.println(emailToBeRegistered);

		hrPage.typeFirstName("TestFirstName"+CommonFunctions.generateRandomIndex())
		.typeLastName("TestLastName"+CommonFunctions.generateRandomIndex())
		.typeEmployeeEmail(emailToBeRegistered)
		.clickSave();

		String isRegisteredEmail=hrPage.filterRegisteredEmployeeByEmail(emailToBeRegistered)
				.isRegisteredEmail();

		Assert.assertEquals(isRegisteredEmail,emailToBeRegistered);

		hrPage.doubleClickRegisteredAccount()
		.clickLoginActivitiesMenu()
		.clickAddLoginAcitivity()
		.selectLoginAcitivity("Administration (Activity)")
		.addAcitivity()
		.clickLoginActivitiesMenu()
		.clickAddLoginAcitivity()
		.selectLoginAcitivity("Arcade Management (Activity)")
		.addAcitivity()
		.clickLoginActivitiesMenu()
		.clickAddLoginAcitivity()
		.selectLoginAcitivity("Cash Control (Activity)")
		.addAcitivity();

		hrPage.clickSetPasswordMenu()
		.setNewPassword("Admin@123")
		.setConfirmPassword("Admin@123")
		.clickUpdatePassword()
		.clickClosePopupButton();

		LoginPage loginAgain=hrPage.logout();

		DashboardPage dashboard2=login.typeUsername(isRegisteredEmail)
				.typePassword("Admin@123")
				.clickLogin();

		Assert.assertTrue(dashboard2.checkSidebarMenus("Administration"));
		Assert.assertTrue(dashboard2.checkSidebarMenus("Arcade Management"));
		Assert.assertTrue(dashboard2.checkSidebarMenus("Cash Control"));
	}

}
