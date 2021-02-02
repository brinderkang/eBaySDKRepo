package pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Util;
import base.TestBase;

public class BIIPage extends TestBase {
	
	@FindBy(xpath=("//input[@id='businessLegalName']"))
//	@FindBy(id="businessLegalName")
	WebElement businessLegalName;
	
	@FindBy(xpath=("//input[@id='taxId']"))
	WebElement taxId;
	
//	@FindBy(id="annualGrossSale")
	@FindBy(xpath=("//input[@id='annualGrossSale']"))
	WebElement annualGrossSale;
	
	@FindBy(id="ownershipPercentage")
	WebElement ownershipPercentage;
	
	@FindBy(id="isBusinessController")
	WebElement isBusinessController;
	
	@FindBy(id="checkboxAddress")
	WebElement checkboxAddress;
	
	@FindBy(xpath="//button[@name='button']")
	WebElement checkmyoptions;
	
	@FindBy(xpath="//p[text()='This process may take a few seconds']")
	WebElement loading;
	
	
	static String businesslegalname;
	OffersPage objofferspage;
	public BIIPage()
	{
		PageFactory.initElements(driver, this);
		objofferspage=new OffersPage();
		businesslegalname=prop.getProperty("BusinessName");
	}
	public boolean submitLoanApplication()
	{
//		driver.findElement(By.id("businessLegalName")).sendKeys("New BLN");
		try {
			businessLegalName.sendKeys(businesslegalname);
			taxId.sendKeys("123456543");
			annualGrossSale.sendKeys("89000");
			ownershipPercentage.sendKeys("100");
			isBusinessController.click();
			Util.selectdropdown(isBusinessController, "1");
			checkboxAddress.click();
			Util.waituntilElementClickable(checkmyoptions);
			checkmyoptions.click();									
			try 
			{
				do
				{
					Thread.sleep(10000);
				}
				while(loading.isDisplayed());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Loading completed");
//				e.printStackTrace();
			}
				Thread.sleep(6000);
				boolean ele = objofferspage.sendcodebtn.isDisplayed();
				System.out.println(ele);
				boolean ele_cancel = objofferspage.canclebtn.isDisplayed();
				System.out.println(ele_cancel);
				String send_txt = objofferspage.sendcodebtn.getText();
				System.out.println(send_txt);
				String cancel_txt = objofferspage.canclebtn.getText();
				System.out.println(cancel_txt);
				objofferspage.canclebtn.click();
				return ele;
					
//				if(ele)
//				{
//					return true;
//				}
//				else
//				{
//					boolean decline_txt=objofferspage.declinetxt.isDisplayed();
//					if(decline_txt){
//					System.out.println("Loan Declined");
//					return false;
//					}					
//				}
															
			}
		catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				boolean decline_txt=objofferspage.declinetxt.isDisplayed();
				if(decline_txt){
				System.out.println("loan declined");
				
				}
				return false;
			}
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
////		e.printStackTrace();
//		return false;
//	}						
		
			
		
}

}
