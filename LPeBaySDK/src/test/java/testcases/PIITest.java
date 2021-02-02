package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoanPage;
import pages.PIIPage;
import base.TestBase;

public class PIITest extends TestBase{
	
	PIIPage objpiipage;
//	LoanPage objloanpage;
	
	public PIITest()
	{
		super();
		
	}
	@BeforeTest
	public void setup()
	{
//		initialisation();
//		objloanpage=new LoanPage();
		objpiipage=new PIIPage();
//		objloanpage.addLoanAmount();
//		objpiipage=objloanpage.clickSubmitIcon();
		
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
