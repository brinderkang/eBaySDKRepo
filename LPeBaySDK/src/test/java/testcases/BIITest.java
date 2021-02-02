package testcases;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.BIIPage;
import base.TestBase;

public class BIITest extends TestBase {
	
	
	BIIPage objbiipage;
	public BIITest()
	{
		super();	
		
	}
	@BeforeTest
	public void setup()
	{
		objbiipage=new BIIPage();
	}
	@Test
	public void verifySubmitLoanApplication()
	{
		 
		boolean biipage=objbiipage.submitLoanApplication();
		Assert.assertEquals(true, biipage);
	}

}
