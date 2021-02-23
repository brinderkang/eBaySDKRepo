package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class OffersPage extends TestBase {
	@FindBy(xpath="(//button[text()='Send Code'])[1]")
	WebElement sendcodebtn;
	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement canclebtn;
	
	@FindBy(xpath = "//p[text()=' Unfortunately, we’re unable to generate a loan offer for you at this time.']")
	WebElement declinetxt;
	
	@FindBy(xpath = "//div[text()='Select Offer']")
	WebElement offerpagetxt;
	
	@FindBy(id="term36")
	WebElement radio36;
	@FindBy(id="term24")
	WebElement radio24;
	@FindBy(id="term12")
	WebElement radio12;
	
	
	@FindBy(xpath = "//span[text()='Payment options']")
	WebElement paymentoptiontxt;
	
	@FindBy(xpath = "//button[text()='Select']")
	WebElement selectofferbtn;
	
	@FindBy(xpath = "//h1[text()=' Verify Identity ']")
	WebElement verifyidentitytxt;	
	@FindBy(xpath = "//span[text()='Identity verification failed']")
	WebElement identityverifailedtxt;
	@FindBy(xpath = "//a[text()=' Try Again ']")
	WebElement tryagainbtn;
	@FindBy(xpath="//button[text()=' Continue ']")
	WebElement btncontinueidentity;
	
	
	
	public OffersPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean offerPageElements()
	{
		offerpagetxt.isDisplayed();
//		radio36.isDisplayed();
//		radio24.isDisplayed();
//		radio12.isDisplayed();
//		paymentoptiontxt.isDisplayed();
		return true;
	}
	
	public boolean selectOffer() throws InterruptedException
	{
		selectofferbtn.click();
		BankInfoPage obj_bankinfo = new BankInfoPage();
//		boolean bnkinfotxt=obj_bankinfo.bankinfotxt.isDisplayed();
		try{
			Thread.sleep(10000);
			if(tryagainbtn.isDisplayed())
			{
				System.out.println("Identification failed");
				tryagainbtn.click();
			}
		}catch(Exception e){
			System.out.println("continue to Bank Info screen");
		}
		try {
			if(btncontinueidentity.isDisplayed())
			{
				btncontinueidentity.click();
				System.out.println("continue button clicked");
			}
		} catch (Exception e) {
			System.out.println("continue to Bank Info screen from Verify Identity");
			e.printStackTrace();
		}
		Thread.sleep(15000);
		return obj_bankinfo.bankinfotxt.isDisplayed();
	}

}
