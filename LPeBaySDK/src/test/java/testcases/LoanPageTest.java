package testcases;

import junit.framework.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoanPage;
import base.TestBase;

public class LoanPageTest extends TestBase {
	
	LoanPage objloanpage;
	
	public LoanPageTest()
	{
		super();
	}
	
	@BeforeTest
	public void setup()
	{
		initialisation();
		objloanpage=new LoanPage();
	}
	
	@Test(priority=1)
	public void verify_pagetitle()
	{
		String title=objloanpage.pageTitle();
		Assert.assertEquals("LendingPoint", title);
	}
	@Test(priority=2)
	public void verify_pagelogo() throws InterruptedException
	{
		boolean flag=objloanpage.validateLogo();
		Assert.assertEquals(true, flag);
	}
	@Test(priority=3)
	public void verify_txtloanamount()
	{
		objloanpage.addLoanAmount();
		objloanpage.clickSubmitIcon();
	}
	
	@AfterTest
	public void teardown()
	{
//		driver.quit();
	}

}
