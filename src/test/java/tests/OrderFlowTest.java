package tests;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomeProductPage;
import pages.LoginPage;
import pages.OrderCompletePage;
import pages.OverViewPage;
import pages.YourCartPage;
import utility.GenericUtilsPage;

public class OrderFlowTest extends BaseTest {

	LoginPage loginPage;
	HomeProductPage homeProductPage;
	YourCartPage yourCartPage;
	CheckOutPage checkOutPage;
	OverViewPage overViewPage;
	OrderCompletePage orderCompletePage;

	GenericUtilsPage genericUtilsPage;

	@Test
	public void OrderFlowTestProduct() throws InterruptedException {
		String expectedOrderString = "Thank you for your order!";
		// Getting data from Properties file
		genericUtilsPage = new GenericUtilsPage(driver);
		String username = genericUtilsPage.getProperty("username");
		String password = genericUtilsPage.getProperty("password");
		String expectedString = genericUtilsPage.getProperty("expectedString");

		// login to home Page with valid credentials
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
		
		// 2) Checkout page-->Add to cart	
		homeProductPage.selectAnyOneItemAndAddtoCart();
		homeProductPage.clickOnCartButton();
	
		// 3)Your cart page
		yourCartPage = new YourCartPage(driver);
		yourCartPage.clickOnProceedToCheckOut();
	
		// 4)CheckOut Page
		checkOutPage = new CheckOutPage(driver);
		String firstname = genericUtilsPage.getProperty("sFirstName");
		String lastname = genericUtilsPage.getProperty("sLastName");
		String zipcode = genericUtilsPage.getProperty("sZipCode");
		checkOutPage.getFirstNameElement().sendKeys(firstname);
		checkOutPage.getLastNameElement().sendKeys(lastname);
		checkOutPage.getZipCodeElement().sendKeys(zipcode);
		checkOutPage.getContinueButtonElement().click();
	
		// 5)OverView Page
		overViewPage = new OverViewPage(driver);
		overViewPage.clickOnFinishButton();
	
		// 6)Verify Order Number
		orderCompletePage = new OrderCompletePage(driver);
		String actualOrderString = orderCompletePage.getOrderConformationMessage();
		Assert.assertEquals(actualOrderString, expectedOrderString);
	
		// take screenshot for Order Success
		genericUtilsPage.captureScreenshot();
		System.out.println("Order placed Successfully");

	}

}
