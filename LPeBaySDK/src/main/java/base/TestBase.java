package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.Util;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		prop=new Properties();
		try {
//			FileInputStream ip=new FileInputStream(System.getProperty("user.dir"+"\\src\\main\\java\\config\\config.properties"));
			FileInputStream ip=new FileInputStream("D:\\Brinder\\OBJ\\LPeBaySDK\\src\\main\\java\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialisation()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Brinder\\BrowserDrivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		if(browsername.equals("Firefox"))
		{
		System.setProperty("webdriver.geko.driver", "D:\\Brinder\\BrowserDrivers\\gekodriver.exe");
		driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	

}
