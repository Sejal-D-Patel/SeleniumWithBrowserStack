package com.tests;

import com.drivermanager.BrowserStackBaseTest;
import com.drivermanager.Constant;
import com.utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CustomerTest extends BrowserStackBaseTest {
	SoftAssert softAssert = new SoftAssert();
	public void getUrl() throws InterruptedException {
		driver.get(getProperty("URL"));
		Utility.waitForPageCompletelyLoaded(driver);
	}

	@Test(priority = 1)
	public void verifyLoginButton()  {
		try {
			getUrl();
			Assert.assertTrue(customerPage.btnLogin.isDisplayed());
		}catch (AssertionError | Exception E) {
			Assert.fail("User Could not Navigate To Home Page." + E.getMessage());
		}
	}
	@Test(priority = 2)
	public void verifyNavigationOfSignInPage()  {
		try{
			customerPage.clickOnLogin();
			customerPage.clickOnNewCustomerAccount();
			Assert.assertEquals(customerPage.txtSignIn.getText(),"Personal Information");
		}catch (AssertionError | Exception E) {
			Assert.fail("User Could not navigate the Sign in page." + E.getMessage());
		}
	}
	@Test(priority = 3)
	public void verifyFieldWithInvalidDetails ()  {
		try{
			customerPage.enterPassword(getProperty("PasswordShort"));
			softAssert.assertEquals(customerPage.txtPasswordShort.getText(), Constant.passwordShortValidation);

			customerPage.enterFirstName(getProperty("FirstNameShort"));
			softAssert.assertEquals(customerPage.txtFirstShort.getText(), Constant.firstNameShortValidation);

			customerPage.enterLastName(getProperty("LastNameShort"));
			softAssert.assertEquals(customerPage.txtLastShort.getText(), Constant.lastNameShortValidation);

			customerPage.enterEmailAddress(getProperty("InvalidEmail"));
			softAssert.assertEquals(customerPage.txtEmailShort.getText(), Constant.emailValidation);

			customerPage.enterPhoneNumber(getProperty("PhoneShort"));
			softAssert.assertEquals(customerPage.txtPhoneShort.getText(), Constant.phoneValidation);

			softAssert.assertAll();
		}catch (AssertionError | Exception E) {
			Assert.fail("User Could not verify the password validation." + E.getMessage());
		}
	}

	@Test(priority = 4)
	public void verifyFillingAllValidInformation() {
		try{
		customerPage.enterAllPersonalInformation();
		System.out.println("city name::"+customerPage.txtCityName.getAttribute("value"));
		Assert.assertEquals(customerPage.txtCityName.getAttribute("value"),getProperty("City"));
	}catch (AssertionError | Exception E) {
		Assert.fail("User Could not filling the information." + E.getMessage());
	}
	}
	@Test(priority = 5)
	public void verifyStateCountryInformation() {
		try{
			String actualState=customerPage.getStateName();
			String actualCountry=customerPage.getCountryName();
			Assert.assertEquals(actualState,getProperty("StateProvience"));
			Assert.assertEquals(actualCountry,getProperty("Country"));
			customerPage.clickOnNext();
		}catch (AssertionError | Exception E) {
			Assert.fail("User Could not verify the information." + E.getMessage());
		}
	}


}
