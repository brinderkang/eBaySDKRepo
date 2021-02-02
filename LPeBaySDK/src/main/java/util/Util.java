package util;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Iterator;
//
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	public static void waituntilElementPresent(WebElement element)
	{
		WebDriverWait wait;
		wait =new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
//	public void ReadExcelData(String sheetname)
//	{
//		File src=new File("Path");
//		FileInputStream fis;
//		XSSFSheet sh = null;
//		try {
//			fis= new FileInputStream(src);
//			XSSFWorkbook wb=new XSSFWorkbook(fis);
//			sh=wb.getSheet("sheetname");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		Iterator<Row> rowitr=sh.iterator();
//		
//		
//		int rowcount=sh.getLastRowNum();
//		for(int i=0;i<rowcount;i++)
//		{
//			String run=sh.getRow(i).getCell(0).getStringCellValue();
//			if(run.equalsIgnoreCase("on"))
//			{
//				
//			}
//			
//		}
//	}
//
}
