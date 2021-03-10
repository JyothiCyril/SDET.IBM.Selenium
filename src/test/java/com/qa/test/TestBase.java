package com.qa.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.AmazonPages;

public class TestBase {
	//	1. Open the Browser
	//	2. Run the URL
	WebDriver driver;
	AmazonPages AmazonOR;
	FileInputStream FileLoc;
	Properties prop;

	@Parameters({"Browser"})
	@BeforeClass
	public void setUp(String Browser) throws IOException {

		if(Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium Software\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if(Browser.equalsIgnoreCase("Firefox")) {				
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium Software\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();		

		}else if(Browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "D:\\Selenium Software\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();

		}else if(Browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Selenium Software\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}


		AmazonOR = new AmazonPages(driver);
		
		FileLoc = new FileInputStream("D:\\Devlabs\\Batch 2\\BroadridgeBatch2\\SDET.IBM.Selenium\\src\\test\\java\\com\\qa\\testdata\\testData.properties");
		
		prop = new Properties();
		prop.load(FileLoc);
		
		driver.get(prop.getProperty("Url"));
	}



	//7. Close the browser
	@AfterClass
	public void tearDown() {
		driver.close();

	}


}
