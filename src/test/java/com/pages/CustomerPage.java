package com.pages;

import com.drivermanager.BrowserStackBaseTest;
import com.utilities.Utility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CustomerPage extends BrowserStackBaseTest {
    @FindBy(xpath = "//button[@title='Login']")
    public WebElement btnLogin;
    @FindBy(xpath = "//button[contains(.,'CREATE NEW CUSTOMER ACCOUNT')]")
    public WebElement btnNewAccount;
    @FindBy(xpath = "//div[@class='w-full text-left text-lg px-3 mb-[10px]']")
    public WebElement txtSignIn;
    @FindBy(xpath = "//input[@name='organizationName']")
    public WebElement txtOrganizationName;
    @FindBy(xpath = "//input[@name='jobTitle']")
    protected WebElement txtJobTitle;
    @FindBy(xpath = "//input[@name='departmentName']")
    protected WebElement txtDepartmentName;
    @FindBy(xpath = "//input[@name='password']")
    protected WebElement txtPassword;
    @FindBy(xpath = "//input[@name='password']//..//following-sibling::div[@class='text-red-500 text-s']")
    public WebElement txtPasswordShort;
    @FindBy(xpath = "//input[@name='firstname']//..//following-sibling::div[@class='text-red-500 text-s']")
    public WebElement txtFirstShort;
    @FindBy(xpath = "//input[@name='lastName']//..//following-sibling::div[@class='text-red-500 text-s']")
    public WebElement txtLastShort;
    @FindBy(xpath = "//input[@name='email']//..//following-sibling::div[@class='text-red-500 text-s']")
    public WebElement txtEmailShort;
    @FindBy(xpath = "//input[@name='phoneNumber']//..//following-sibling::div[@class='text-red-500 text-s']")
    public WebElement txtPhoneShort;
    @FindBy(xpath = "//input[@name='firstname']")
    protected WebElement txtFirstname;
    @FindBy(xpath = "//input[@name='lastName']")
    protected WebElement txtLastname;
    @FindBy(xpath = "//input[@name='email']")
    protected WebElement txtEmail;
    @FindBy(xpath = "//input[@name='companyAddress']")
    protected WebElement txtCompanyAddress;
    @FindBy(xpath = "//input[@name='zipCode']")
    protected WebElement txtZipcode;
    @FindBy(xpath = "//input[@name='cityName']")
    public WebElement txtCityName;
    @FindBy(xpath = "//select[@name='state']")
    protected WebElement txtStateName;
    @FindBy(xpath = "//select[@name='country']")
    protected WebElement txtCountryName;
    @FindBy(xpath = "//input[@name='phoneNumber']")
    protected WebElement txtPhoneNumber;
    @FindBy(xpath = "//button[contains(.,'Next >')]")
    protected WebElement btnNext;

    /**
     * click on Login button
     * @return
     */
    public CustomerPage clickOnLogin() {
       Utility.clickOnElement(btnLogin,driver);
        return this;
    }

    /**
     * click on new Account
     * @return
     */
    public CustomerPage clickOnNewCustomerAccount() {
       Utility.clickOnElement(btnNewAccount,driver);
        return this;
    }

    /**
     * Enter OrganizationName
     * @return
     */
    public CustomerPage enterOrganizationName() {
        Utility.waitForVisibilityOfElement(txtOrganizationName,driver);
        Utility.sendKey(txtOrganizationName,getProperty("OrganizationName"));
        return this;
    }

    /**
     * Enter JobTitle
     * @return
     */
    public CustomerPage enterJobTitle() {
        Utility.sendKey(txtJobTitle,getProperty("JobTitle"));
        return this;
    }

    /**
     * Enter DepartmentName
     * @return
     */
    public CustomerPage enterDepartmentName() {
        Utility.sendKey(txtDepartmentName,getProperty("DepartmentName"));
        return this;
    }

    /**
     * Enter password
     * @return
     */
    public CustomerPage enterPassword(String pass) {
        Utility.sendKey(txtPassword,pass);
        txtSignIn.click();
        return this;
    }

    /**
     * Enter Firstname
     * @return
     */
    public CustomerPage enterFirstName(String first) {
        Utility.sendKey(txtFirstname,first);
        txtSignIn.click();
        return this;
    }

    /**
     * Enter Lastname
     * @return
     */
    public CustomerPage enterLastName(String last) {
        Utility.sendKey(txtLastname,last);
        txtSignIn.click();
        return this;
    }
    /**
     * Enter EmailAddress
     * @return
     */
    public CustomerPage enterEmailAddress(String email) {
        Utility.sendKey(txtEmail,email);
        txtSignIn.click();
        return this;
    }
    /**
     * Enter Company Address
     * @return
     */
    public CustomerPage enterCompanyAddress() {
        Utility.sendKey(txtCompanyAddress,getProperty("CompanyAddress"));
        return this;
    }
    /**
     * Enter ZipCode
     * @return
     */
    public CustomerPage enterZipCode() {
        Utility.sendKey(txtZipcode,getProperty("ZipCode"));
        txtSignIn.click();
        return this;
    }
    /**
     * Enter Phone Number
     * @return
     */
    public CustomerPage enterPhoneNumber(String phone) {
        Utility.sendKey(txtPhoneNumber,phone);
        txtSignIn.click();
        return this;
    }

    /**
     * enter all personal information
     * @return
     */
    public CustomerPage enterAllPersonalInformation(){
        enterOrganizationName().enterJobTitle().enterDepartmentName().enterPassword(getProperty("Password"));
        enterFirstName(getProperty("FirstName")).enterLastName(getProperty("LastName")).enterEmailAddress(getProperty("EmailAddress")).enterCompanyAddress().enterZipCode().enterPhoneNumber(getProperty("Phone"));
        Utility.waitForVisibilityOfElement(txtCityName,driver);
        Utility.waitForVisibilityOfElementLocated(txtCityName,driver);
     return this;
    }

    /**
     * click on Next button
     * @return
     */
    public CustomerPage clickOnNext() {
        Utility.clickOnElement(btnNext,driver);
        return this;
    }

    /**
     * Get State name
     * @return
     */
    public String getStateName(){
       String selectedState=Utility.selectedValue(txtStateName);
        System.out.println("Selected State Name: " + selectedState);
        return selectedState;
    }
    /**
     * Get State name
     * @return
     */
    public String getCountryName(){
        String selectedCountry=Utility.selectedValue(txtCountryName);
        System.out.println("Selected State Name: " + selectedCountry);
        return selectedCountry;
    }



}
