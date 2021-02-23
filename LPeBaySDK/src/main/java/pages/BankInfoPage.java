package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class BankInfoPage extends TestBase {
	
	@FindBy(xpath = "//div[text()='Bank Information']")
	WebElement bankinfotxt;
	@FindBy(xpath = "//span[text()='Connect your bank account now']")
	WebElement connectyourbanktxt;
	@FindBy(xpath = "//p[contains(text(),'On the next screens,')]")
	WebElement txt1;
	@FindBy(xpath = "//p[contains(text(),'To link to and verify')]")
	WebElement txt2;
	@FindBy(xpath = "//button[text()='Skip this step']")
	WebElement skipplaidbtn;
	
//	PLAID
	@FindBy(id="a11y-title")
	WebElement usesplaidtxt;
	@FindBy(xpath = "//span[text()='Continue']")
	WebElement continuebtn;
	@FindBy(xpath = "//h1[text()='Select your bank']")
	WebElement selecturbanktxt;
	@FindBy(xpath = "//input[@class='InstitutionSearchInput__input InstitutionSearchInput__input--is-threads-treatment']")
	WebElement banksearchtextbox;
	@FindBy(xpath = "//p[text()='Bank of America']")
	WebElement banksearchresult;
	
	@FindBy(xpath = "//h1[text()='Enter your credentials']")
	WebElement entercredentialstxt;
	@FindBy(id = "username")
	WebElement bankusername;
	@FindBy(id = "password")
	WebElement bankpassword;
	@FindBy(xpath = "//span[text()='Submit']")
	WebElement submitbtn;
	
	@FindBy(xpath = "//h1[text()='Select account']")
	WebElement selectacctxt;
	@FindBy(id="vZpeMBG13BsnAJE6ZDZRI4eppy8z8JFWbZ5Wr")
	//div[text()='Plaid Saving']
	WebElement checkboxplaidsaving;
	@FindBy(xpath="//div[text()='Plaid Checking']")
	WebElement checkboxplaidchecking;
	@FindBy(xpath="//div[text()='Plaid Saving']")
	WebElement checkboxplaidsaving1;
	@FindBy(xpath = "//span[text()='Continue']")
	WebElement continueselectaccbtn;
	
	@FindBy(xpath = "//h1[text()='This application is requesting access to your...']")
	WebElement requestaccesstxt;
	@FindBy(xpath = "//span[text()='Allow']")
	WebElement allowbtn;
	
	public BankInfoPage()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean bankInfoElements()
	{
		bankinfotxt.isDisplayed();
		connectyourbanktxt.isDisplayed();
		txt1.isDisplayed();
		txt2.isDisplayed();
		return true;
	}
	public boolean bankConnectPlaid()
	{
		try {
			connectyourbanktxt.click();
			Thread.sleep(3000);
			driver.switchTo().frame("plaid-link-iframe-1");
			
			usesplaidtxt.isDisplayed();
			String pl=usesplaidtxt.getText();
			System.out.println(pl);
			continuebtn.click();
			selecturbanktxt.isDisplayed();
			banksearchtextbox.sendKeys(prop.getProperty("bankname"));
			banksearchresult.click();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("Unsuccessful bank connect in plaid");
//			String winHandleBefore = driver.getWindowHandle();
//			
//			// Perform the click operation that opens new window
//
//			// Switch to new window opened
//			for(String winHandle : driver.getWindowHandles()){
//				System.out.println(winHandle);
//			    driver.switchTo().window(winHandle);
//			}
			
			return false;
		}
	}
	public boolean plaidcredentials()
	{
		try {
			entercredentialstxt.isDisplayed();
			bankusername.sendKeys(prop.getProperty("bankusername"));
			bankpassword.sendKeys(prop.getProperty("bankpassword"));
			submitbtn.click();
			
			selectacctxt.isDisplayed();
			checkboxplaidsaving1.click();
			continueselectaccbtn.click();
			
			requestaccesstxt.isDisplayed();
			allowbtn.click();
			driver.switchTo().defaultContent();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			checkboxplaidsaving.click();
			System.out.println("Unsuccessful bank login in plaid");
			
			return false;
		}
	}
}
