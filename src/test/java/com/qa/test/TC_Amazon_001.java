package com.qa.test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_Amazon_001 extends TestBase {

	
	// Search an item

//	3. Select Category
//	4. Enter the item name
//	5. Click on magnifier button to submit
//	6. Check if the title of the page has search term
	
	@Test(dataProvider="getData") // receive the test data from the getData method
	public void searchItem(String Category, String Itemname) {		
		AmazonOR.setCategoryInput(Category); // 1st field
		AmazonOR.setSearchTextBoxInput(Itemname); //2nd field
		AmazonOR.setMaginifierBtnClick();		
		boolean status = driver.getTitle().contains(Itemname);
		
		Assert.assertTrue(status);; // if the assert fails, the next LOC will not be executed.
					
	}
	
	@DataProvider // Source the data to test case @Test
	public Object[][] getData(){
		
		Object[][] data = new Object[3][2];
		
		// Category
		data[0][0] = "Books";
		data[1][0] = "Electronics";
		data[2][0] = "Appliances";
				
		// Item Name
		data[0][1] = "Da vinci Code";
		data[1][1] = "Mobile phones";
		data[2][1] = "Fans";
				
		return data;
	}
	
	
	
	
}
