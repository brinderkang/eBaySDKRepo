package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class LoanPage extends TestBase {
		    //WebElement to be used with PageFactory
	@FindBy(xpath="//img[@src='https://stglpapps.wpengine.com/wp-content/uploads/2020/08/ebay-10.33.47.png']")
	WebElement logo;
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/app-loader[1]/app-main[1]/div[1]/div[1]/app-loader[1]/app-personal-info[1]/app-component-type-loader[1]/app-sdk[1]/app-loader[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-input-mask[1]/input[1]")
	WebElement txtloanamount;
	@FindBy(xpath="//*[text()='Financing Amount']")
	WebElement lblfinanceamt;
	@FindBy(xpath="//img[@src='assets/icons/ico-next-step-white.svg']")
	WebElement submiticon;
	//constructor to initialise web elements using page factory.
	public LoanPage()
	{
		PageFactory.initElements(driver, this);
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
	public void clickSubmitIcon()
	{
		submiticon.click();
//		WebElement ele=driver.findElement(By.xpath("//select[@id='loanPurpose']"));
//		ele.click();
//		Select obj=new Select(driver.findElement(By.xpath("//select[@id='loanPurpose']")));
//		obj.selectByValue("BUSINESS EXPANSION");
	}
	
}
