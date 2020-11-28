package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import util.Util;
import base.TestBase;

public class PIIPage extends TestBase {
	
	@FindBy(id="loanAmount")
	WebElement financingamount;
	@FindBy(xpath=("//select[@id='loanPurpose']"))
	WebElement loanpDD;
	
//	@FindBy(xpath=("//select[@id='loanPurpose']"))
//	WebElement loanpurposeDD;
	
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
	
	@FindBy(id="street")
	WebElement address1;
	@FindBy(id="unit")
	WebElement address2;
	@FindBy(id="zip")
	WebElement zipcode;
	@FindBy(id="state")
	WebElement stateDD;
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="annualIncome")
	WebElement annualincome;
	@FindBy(id="ss3")
	WebElement ssn3;
	@FindBy(id="ss1")
	WebElement ssn1;
	@FindBy(id="ss2")
	WebElement ssn2;
	@FindBy(xpath="//button[@name='button']")
	WebElement btncontinue;
	
	public PIIPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void personalinfo() throws InterruptedException
	{
		String str=financingamount.getText();
		System.out.println(str);
		loanpDD.click();
		Util.selectdropdown(loanpDD,"BUSINESS EXPANSION");
		firstname.sendKeys("John");
		lastname.sendKeys("Smith");
		dob.sendKeys("02/28/1975");
		phonenumber.sendKeys("3202163245");
		email.sendKeys(prop.getProperty("email"));
		address1.sendKeys("222333 Peachtree Palace");
		address2.sendKeys("23");
		zipcode.sendKeys("30318");
		Thread.sleep(10000);
		annualincome.sendKeys("65000");
		ssn3.sendKeys("3333");
		Thread.sleep(5000);
		ssn1.sendKeys("112");
		ssn2.sendKeys("22");
		btncontinue.click();
	}

}
