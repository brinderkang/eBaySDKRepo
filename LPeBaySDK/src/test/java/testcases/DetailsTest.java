package testcases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Details;
import base.TestBase;






public class DetailsTest extends TestBase {
	Details objdetails;
	private Method method;
	public DetailsTest()
	{
		super();
	}
//	@BeforeSuite
//	public void startExtentReport()
//	{
//		startExtentReport();
//	}
//	@BeforeMethod
//	public void beforeMethod()
//	{
//		ExtentbeforeMethod(this.method);
//	}
	@BeforeTest
	public void setup()
	{
		initialisation();
		
		objdetails=new Details();
	}
	
	
	@Test(priority=1)
	public void verify_pagetitle()
	{
		String title=objdetails.pageTitle();
		Assert.assertEquals("LendingPoint", title);
	}
	@Test(priority=2)
	public void verify_pagelogo() throws InterruptedException
	{
		boolean flag=objdetails.validateLogo();
		Assert.assertEquals(true, flag);
	}
	@Test(priority=3)
	public void verifyPIIDetails() throws InterruptedException
	{
		
		boolean flag=objdetails.personalinfo();
		Assert.assertEquals(true, flag);
	}
	@Test(priority=4)
	public void verifySubmitLoanApplication()
	{
		 
		boolean biipage=objdetails.submitLoanApplication();
		Assert.assertEquals(true, biipage);
	}

}
