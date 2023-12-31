package com.utilities;

import com.drivermanager.BrowserStackBaseTest;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;

public class Utility extends BrowserStackBaseTest {
    private static final int explicitWaitDefault = 180;
    static XSSFWorkbook wb;
    static XSSFSheet sheet1;
    static File src;
    static String  excelPath = getProperty("ExcelFilePath");
    public static String getdata(int sheetNumber, int row, int col) {
        try {
            src = new File(excelPath);
            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
            sheet1 = wb.getSheetAt(0);
        } catch (Exception e) {

            System.out.println(e);
        }
        try {
            sheet1 = wb.getSheetAt(sheetNumber);
            String data = wb.getSheetAt(sheetNumber).getRow(row).getCell(col).getStringCellValue();
            return data;
        } catch (Exception e) {
            System.out.println(
                    "\n\n\n\n Error:  May excel sheet's cell data type is not supported, please change the cell datatype in excel! \n\n\n\n\n ");
        }
        return null;

    }

        /**
         * sleep
         * @param sec
         */
    public static void pause(int sec){
        try {
            Thread.sleep(1000*sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Send key
     *
     * @param element
     * @param value
     */
    public static void sendKey(WebElement element, String value) {
        element.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        element.sendKeys(value);
        pause(2);
    }

    /**
     * Wait for element visible
     *
     * @param webElement
     * @param driver
     * @return
     */
    public static boolean waitForVisibilityOfElement(WebElement webElement, WebDriver driver) {
        long timeOutSecond = 60;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutSecond);
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * Wait for element visible
     *
     * @param webElement
     * @param driver
     * @return
     */
    public static boolean waitForVisibilityOfElementLocated(WebElement webElement, WebDriver driver) {
        long timeOutSecond = 60;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutSecond);
            wait.until(ExpectedConditions.visibilityOfElementLocated((By) webElement));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * Wait for element click
     *
     * @param element
     * @param driver
     */
    public static void waitForElementTobeClickable(final WebElement element, WebDriver driver) {
        try {
            new WebDriverWait(driver, explicitWaitDefault)
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
        }
    }
    /**
     * Click on element
     * @param element
     */
    public static void clickOnElement(WebElement element,WebDriver driver) {
        waitForVisibilityOfElement(element,driver);
        waitForElementTobeClickable(element,driver);
        element.click();
    }
    /**
     * select value from dropdown/selectBox by value
     *
     * @param element
     * @param text
     */
    public static void selectFromDropDownByVisibleText(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
            System.out.println("Successfully select the following keys: " + text + ", to the following WebElement: " + "<" + element.toString() + ">");
        } catch (Exception e) {
            System.out.println("Unable to select the following keys: " + text + ", to the following WebElement: " + "<" + element.toString() + ">");
            Assert.fail("Unable to select the required index from the dropdown menu, Exception: " + e.getMessage());
        }
    }
    /**
     * get Selected value
     *
     * @param element
     *
     */
    public static String selectedValue(WebElement element) {
        Select select = new Select(element);
        String selectedState = select.getFirstSelectedOption().getText();
        return selectedState;
    }

    /**
     * waitForPageCompletelyLoaded
     */
    public static void waitForPageCompletelyLoaded(WebDriver driver) {
        pause(3);
        JavascriptExecutor j = (JavascriptExecutor) driver;
        if (j.executeScript("return document.readyState").toString().equals("complete")) {
            System.out.println("Page has loaded");
        }
    }
}
