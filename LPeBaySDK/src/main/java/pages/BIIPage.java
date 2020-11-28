package pages;

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
	
	
	public BIIPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void submitLoanApplication()
	{
//		driver.findElement(By.id("businessLegalName")).sendKeys("New BLN");
		businessLegalName.sendKeys("BLN limited");
		taxId.sendKeys("123456543");
		annualGrossSale.sendKeys("89000");
		ownershipPercentage.sendKeys("60");
		isBusinessController.click();
		Util.selectdropdown(isBusinessController, "1");
		checkboxAddress.click();
		Util.waituntilElementClickable(checkmyoptions);
		checkmyoptions.click();
		
	}

}
