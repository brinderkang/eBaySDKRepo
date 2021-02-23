package testcases;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.BankInfoConfirmPage;
import base.TestBase;

public class BankInfoConfirmTest extends TestBase {
	
	BankInfoConfirmPage objbankinfoconfirm;
	public BankInfoConfirmTest()
	{
		super();
	}
	@BeforeTest
	public void setup()
	{
		objbankinfoconfirm=new BankInfoConfirmPage();
	}
	@Test(priority=1)
	public void verifyBankName()
	{
		boolean flag=objbankinfoconfirm.getBankInfo();
		Assert.assertEquals(true, flag);
	}
	@Test(priority=2)
	public void verify_selectBankAccount() throws InterruptedException
	{
		boolean flag=objbankinfoconfirm.selectBankAccount();
		Assert.assertEquals(true, flag);
	}

}
