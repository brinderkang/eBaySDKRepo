package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class Util extends TestBase{
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public static void selectdropdown(WebElement element,String txtvalue)
	{
		Select objselect=new Select(element);
		objselect.selectByValue(txtvalue);
	}
	
	public static void waituntilElementClickable(WebElement element)
	{
		WebDriverWait wait;
		wait =new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
