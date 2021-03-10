package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Amazon_002 extends TestBase {

	// new registration
	

//	3. Mouse over on the account and list
//	4. Click the start here.
//	6. Check if the user is landed on the Registration page
	@Test
	public void registrationPage() {	
		
		WebElement ele = AmazonOR.getAccountList();
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform(); // MHover on the ele		
		AmazonOR.setstartHereLinkClick();		
		boolean contains = driver.getTitle().contains("Registration");
		Assert.assertTrue(contains);
	}
	
	
}
