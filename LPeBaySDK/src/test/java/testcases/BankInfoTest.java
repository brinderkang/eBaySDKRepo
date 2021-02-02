package testcases;

import junit.framework.Assert;

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
		objbankinfo=new BankInfoPage();
		
	}
	
	@Test
	public void verifybankInfoElements()
	{
		objbankinfo.bankInfoElements();
	}
	@Test
	public void verifyPlaidBankConnect()
	{
		boolean bankconnection=objbankinfo.bankConnectPlaid();
		Assert.assertEquals(true, bankconnection);
	}
	@Test
	public void verifyPlaidBankLogin()
	{
		boolean banklogin=objbankinfo.plaidcredentials();
		Assert.assertEquals(true, banklogin);
		
	}
	
	
}
