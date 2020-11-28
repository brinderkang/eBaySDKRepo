package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.PIIPage;
import base.TestBase;

public class PIITest extends TestBase{
	
	PIIPage objpiipage;
	
	public PIITest()
	{
		super();
		
	}
	@BeforeTest
	public void setup()
	{
		objpiipage=new PIIPage();
	}
	
	@Test
	public void verifyPIIDetails() throws InterruptedException
	{
		
		objpiipage.personalinfo();
	}
	@AfterTest
	public void teardown()
	{
//		driver.quit();
	}
}
