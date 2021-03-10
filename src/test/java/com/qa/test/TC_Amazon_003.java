package com.qa.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Amazon_003 extends TestBase {

	// Visit Amazon Careers page

	//	3. Page to be scrolled down till the Careers link is visible
	//	4. Click the Careers link
	//	5. Check if the user is landed on the amazon careers page

	@Test
	public void amazonCareers() throws InterruptedException {
		WebElement careersLink = AmazonOR.getCareersLink();

		JavascriptExecutor Js = (JavascriptExecutor) driver;
		Js.executeScript("arguments[0].scrollIntoView", careersLink);

		String text = careersLink.getText();
		Reporter.log(text,true);
		Thread.sleep(5000);
		careersLink.click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("jobs")); 
	}


}
