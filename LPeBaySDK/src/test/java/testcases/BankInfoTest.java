package testcases;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.BankInfoPage;
import base.TestBase;

public class BankInfoTest extends TestBase {

	BankInfoPage objbankinfo;
	
	public BankInfoTest(){
		super();
	}
	
	@BeforeTest
	public void setup()
	{
		objbankinfo = new BankInfoPage();
		
	}
	
	@Test(priority=1)
	public void verifybankInfoElements()
	{
		boolean bankpage_ele=objbankinfo.bankInfoElements();
		Assert.assertEquals(true, bankpage_ele);
	}
	@Test(priority=2)
	public void verifyPlaidBankConnect()
	{
		boolean bankconnection=objbankinfo.bankConnectPlaid();
		Assert.assertEquals(true, bankconnection);
	}
	@Test(priority=3)
	public void verifyPlaidBankLogin()
	{
		boolean banklogin=objbankinfo.plaidcredentials();
		Assert.assertEquals(true, banklogin);
		
	}
	
	
}
