package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.BIIPage;
import base.TestBase;

public class BIITest extends TestBase {
	
//	BIIPage objbiipage;
	
	public BIITest()
	{
		super();
	}
	@BeforeTest
	public void setup()
	{
		
	}
	@Test
	public void verifySubmitLoanApplication()
	{
		BIIPage objbiipage=new BIIPage();
		objbiipage.submitLoanApplication();
	}

}
