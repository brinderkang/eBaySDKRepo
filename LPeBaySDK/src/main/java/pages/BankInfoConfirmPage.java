package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Util;
import base.TestBase;

public class BankInfoConfirmPage extends TestBase {
	
	@FindBy(xpath="//h1[text()=' Bank Information ']")
	WebElement hdrbankinfo;
	
	@FindBy(id="bankName")
	WebElement txtbankname;
	
	@FindBy(id="accountNumber")
	WebElement ddaccountnumber;
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement btncontinue;
	
	FirstPaymentPage objfirstpaymentpage;
	
	public BankInfoConfirmPage()
	{
		PageFactory.initElements(driver, this);
		objfirstpaymentpage=new FirstPaymentPage();
	}
	
	public boolean getBankInfo()
	{
		try {
			hdrbankinfo.getText();
			txtbankname.getText();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean selectBankAccount() throws InterruptedException
	{
		ddaccountnumber.click();
		Util.selectddByVisibleText(ddaccountnumber, " Plaid Saving - 1111 ");
		btncontinue.click();
		Thread.sleep(5000);
		return objfirstpaymentpage.hdrfirstpayment.isDisplayed();
	}

}
