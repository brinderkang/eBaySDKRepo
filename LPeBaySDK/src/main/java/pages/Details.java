package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Util;
import base.TestBase;

public class Details extends TestBase {
	
	 //WebElement to be used with PageFactory
		@FindBy(xpath="//img[@src='https://stglpapps.wpengine.com/wp-content/uploads/2020/08/ebay-10.33.47.png']")
		WebElement logo;
		@FindBy(xpath="//*[text()='Financing Amount']")
		WebElement lblfinanceamt;
		@FindBy(xpath="//input[@id='loanAmount']")
		WebElement txtloanamount;
		@FindBy(xpath="//*[text()='Business Entity Type']")
		WebElement lblbusinessentitytype;
		@FindBy (xpath="//select[@id='entityType']")
		WebElement ddbusinessentitytype;
		@FindBy(xpath=("//select[@id='loanPurpose']"))
		WebElement loanpDD;
		
		@FindBy(name="firstName")
		WebElement firstname;	
		@FindBy(id="lastName")
		WebElement lastname;
		@FindBy(id="dob")
		WebElement dob;
		@FindBy(id="phone")
		WebElement phonenumber;
		@FindBy(id="email")
		WebElement email;
		
		@FindBy(id="address")
		WebElement homeaddress;
		@FindBy(id="unit")
		WebElement homeaddress2;
		@FindBy(id="zipCode")
		WebElement zipcode;
		@FindBy(id="state")
		WebElement state;
		@FindBy(id="city")
		WebElement city;
		@FindBy(id="annualIncome")
		WebElement annualIncome;
		
		@FindBy(id="ss3")
		WebElement ssn3;
		@FindBy(id="ss1")
		WebElement ssn1;
		@FindBy(id="ss2")
		WebElement ssn2;
		
//		BUSINESS DETAILS
		@FindBy(xpath=("//input[@id='businessLegalName']"))
//		@FindBy(id="businessLegalName")
		WebElement businessLegalName;
		@FindBy(xpath=("//input[@id='taxId']"))
		WebElement taxId;
//		@FindBy(id="annualGrossSale")
		@FindBy(xpath=("//input[@id='annualGrossSale']"))
		WebElement annualGrossSale;
		
		@FindBy(xpath="//*[text()='Business Industry']")
		WebElement lblbusinessindustry;
		@FindBy(id="incomeYes")
		WebElement incomeYes;
		@FindBy(xpath="//*[text()='Retailer or distributor ']")
		WebElement lblretailer;
		@FindBy(id="NAICSSector")
		WebElement ddNAICSSector;
		@FindBy(name="NAICSSubSectorObject")
		WebElement ddNAICSSubSectorObject;
		
		@FindBy(id="ownershipPercentage")
		WebElement ownershipPercentage;
		@FindBy(id="isBusinessController")
		WebElement isBusinessController;
		
		@FindBy(xpath="//h3[text()='Business location & contact']")
		WebElement lblbusinesslocationcontact;
		@FindBy(id="checkboxAddress")
		WebElement chkbusinessaddress;
		@FindBy(id="businessAddress")
		WebElement businessAddress;
		@FindBy(id="businessAddress2")
		WebElement businessAddress2;
		@FindBy(id="businessZipCode")
		WebElement businessZipCode;
		@FindBy(id="businessState")
		WebElement businessState;
		@FindBy(id="businessCity")
		WebElement businessCity;
		@FindBy(id="businessPhoneNumber")
		WebElement businessPhoneNumber;
		@FindBy(xpath="//button[text()=' I Agree, check my options ']")
		WebElement checkmyoptions;
		
		@FindBy(xpath="//p[text()='This process may take a few seconds']")
		WebElement loading;
		
		
		
		
		OffersPage objofferspage;
		
		public Details()
		{
			PageFactory.initElements(driver, this);
			objofferspage=new OffersPage();
		}
		
		public String pageTitle()
		{
			return driver.getTitle();
		}
		public boolean validateLogo() throws InterruptedException
		{
			Thread.sleep(10000);
			return logo.isDisplayed();		
		}
		public String pageLabel()
		{
			return lblfinanceamt.getText();
		}
		public void addLoanAmount()
		{
			txtloanamount.sendKeys(prop.getProperty("loanamount"));
		}
		public boolean personalinfo() throws InterruptedException
		{
//			String str=lblfinanceamt.getText();
//			System.out.println(str);
			txtloanamount.sendKeys(prop.getProperty("loanamount"));
			ddbusinessentitytype.click();
			Util.selectdropdown(ddbusinessentitytype, "Partnership");
			loanpDD.click();
			Util.selectdropdown(loanpDD,"BUSINESS EXPANSION");
			firstname.sendKeys("John");
			lastname.sendKeys("Smith");
			dob.sendKeys("02/28/1975");
			phonenumber.sendKeys(prop.getProperty("phone"));
			email.sendKeys(prop.getProperty("email"));
			Thread.sleep(5000);
			homeaddress.sendKeys("222333 Peachtree Palace");
			homeaddress2.sendKeys("23");
			zipcode.sendKeys("30318");			
			annualIncome.sendKeys("65000");
			ssn3.sendKeys("3333");
			Thread.sleep(9000);
			ssn1.sendKeys("112");
			ssn2.sendKeys("22");
			return businessLegalName.isDisplayed();
			
		}
//		BUSINESS DETAILS
		public boolean submitLoanApplication()
		{
//			driver.findElement(By.id("businessLegalName")).sendKeys("New BLN");
			try {
				businessLegalName.sendKeys("New BLN");
				taxId.sendKeys("123456543");
				annualGrossSale.sendKeys("89000");
				if(lblbusinessindustry.isDisplayed())
				{
					incomeYes.click();
					if(lblretailer.isDisplayed())
					{
						ddNAICSSector.click();
						Util.selectdropdown(ddNAICSSector, "Books, Movies & Music");
						
						Util.scrollpage(ddNAICSSector);
						ddNAICSSubSectorObject.click();
						Util.selectddByVisibleText(ddNAICSSubSectorObject, "Musical Instruments");
					}
				}
				ownershipPercentage.sendKeys("100");
				isBusinessController.click();
				Util.selectdropdown(isBusinessController, "1");
				chkbusinessaddress.click();
				Util.waituntilElementClickable(checkmyoptions);
				Util.scrollpage(checkmyoptions);
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
//					e.printStackTrace();
				}
					Thread.sleep(6000);
					boolean ele = objofferspage.sendcodebtn.isDisplayed();
					if(ele)
					{
						System.out.println("OTP Verification screen displayed");
						String send_txt = objofferspage.sendcodebtn.getText();
						System.out.println(send_txt);
					}					
					boolean ele_cancel = objofferspage.canclebtn.isDisplayed();
					if(ele_cancel)
					{
						System.out.println("Cancel button visible on OTP screen");					
						String cancel_txt = objofferspage.canclebtn.getText();
						System.out.println(cancel_txt);
						objofferspage.canclebtn.click();
					}
					
					return ele;
						
//					if(ele)
//					{
//						return true;
//					}
//					else
//					{
//						boolean decline_txt=objofferspage.declinetxt.isDisplayed();
//						if(decline_txt){
//						System.out.println("Loan Declined");
//						return false;
//						}					
//					}
																
				}
			catch (Exception e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					boolean decline_txt=objofferspage.declinetxt.isDisplayed();
					if(decline_txt){
					System.out.println("Unfortunately, we’re unable to generate a loan offer for you at this time.");
					
					}
					return false;
				}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//			return false;
//		}						
			
				
			
	}
		
		

}
