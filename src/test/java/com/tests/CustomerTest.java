package com.tests;

import com.drivermanager.BrowserStackBaseTest;
import com.utilities.Utility;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomerTest extends BrowserStackBaseTest {
	public void doLogin() throws InterruptedException {
		driver.get(getProperty("URL"));
		Utility.waitForPageCompletelyLoaded(driver);
	}
	@DataProvider(name = "FullNameValidation")
	public static Object[][] lessThan5CharactersOfFullName() {

		return new Object[][] { { Utility.getdata(0, 7, 2) }, { Utility.getdata(0, 7, 3) }, { Utility.getdata(0, 7, 4) },
				{ Utility.getdata(0, 7, 5) } };
	}

	@Test(priority = 1, dataProvider = "lessThan5CharactersOfFullName")
	public void checkInventoryItemTest() throws InterruptedException {
		doLogin();
		System.out.println(driver.getTitle());
	}

	@Test(priority = 2)
	public void checkAddToCartButtonTest() throws InterruptedException {
		customerPage.enterUserName();
		System.out.println(driver.getTitle());
	}

}
