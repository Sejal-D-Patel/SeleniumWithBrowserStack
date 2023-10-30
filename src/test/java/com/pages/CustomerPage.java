package com.pages;

import com.drivermanager.BrowserStackBaseTest;
import com.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPage extends BrowserStackBaseTest {
    @FindBy(id = "First Name")
    protected WebElement txtUserName;

    /**
     * Enter User name
     * @return
     */
    public CustomerPage enterUserName() {
        Utility.sendKey(txtUserName,getProperty("FirstName"));
        return this;
    }
}
