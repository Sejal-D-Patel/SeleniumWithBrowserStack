package com.drivermanager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.pages.CustomerPage;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserStackBaseTest {
	public WebDriver driver;
	public CustomerPage customerPage;
	public static String getProperty(String key) {
		FileReader reader= null;
		try {
			reader = new FileReader("src/test/resources/configuration/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties p=new Properties();
		try {
			p.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p.getProperty(key);
	}
	public static final String USERNAME = getProperty("USERNAME");
	public static final String AUTOMATE_KEY =getProperty("AUTOMATE_KEY");
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


	@Parameters({"browser", "browser_version", "os", "os_version"})
	@BeforeTest
	public void setUp(String browserName, String browser_version, String os, String os_version) {

		System.out.println("browser name is : " + browserName);
	//	String methodName = name.getName();
		
		DesiredCapabilities caps = new DesiredCapabilities();
        
		caps.setCapability("os", os);
		caps.setCapability("os_version", os_version);
		caps.setCapability("browser_version", browser_version);
		//caps.setCapability("name", methodName);

		if (browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			caps.setCapability("browser", "Chrome");
		} else if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			caps.setCapability("browser", "Firefox");
		}else if (browserName.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			caps.setCapability("browser", "Edge");
		}
		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		customerPage = PageFactory.initElements(driver, CustomerPage.class);
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
