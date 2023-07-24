package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pages.HomeProductPage;
import pages.LoginPage;
import utility.GenericUtilsPage;

public class LoginTest extends BaseTest {

	LoginPage loginPage;
	HomeProductPage homeProductPage;
	GenericUtilsPage genericUtilsPage;

	@Test
	public void loginTest() {
		// Getting data from Properties file
		genericUtilsPage = new GenericUtilsPage(driver);
		String username = genericUtilsPage.getProperty("username");
		String password = genericUtilsPage.getProperty("password");
		String expectedString = genericUtilsPage.getProperty("expectedString");

		// Login with valid credentials
		loginPage = new LoginPage(driver);
		loginPage.inputUsernamePassword(username, password);
		loginPage.dologin();
		if (username.equalsIgnoreCase("standard_user")) {
			homeProductPage = new HomeProductPage(driver);
			assertEquals(expectedString, homeProductPage.getLoginConformationMessage());
			System.out.println("Login Test Success!!");
		} else {
			System.out.println("Login Test Failed!!");
		}
		// Capture screenshot, On Home page
		genericUtilsPage.captureScreenshot();

	}

}
