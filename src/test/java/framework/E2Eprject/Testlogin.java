package framework.E2Eprject;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.Loginpage;
import resources.Base;

public class Testlogin extends Base{
	@BeforeTest
	public void openbrowser() throws IOException
	{
		driver=initializeDriver();
		//driver.get("https://www.amazon.com");		
	}
	
	@Test(dataProvider="getdata")
	public void basenavigation(String username,String password) throws IOException
	{		
		//driver.get("https://www.amazon.com");
		driver.get(prop.getProperty("url"));	
		 
	       
	       Loginpage login=new Loginpage(driver); 
	       login.getlogin().click();
	        login.getusername().sendKeys(username);
	        login.getpassword().sendKeys(password);  
	        login.getsubmit().click();
	}	
	@DataProvider
	public Object[][] getdata()
	{
		//array size from 0 but we have to give like below only while declaring array is size is 1
		Object[][] data=new Object[2][2];
		
		data[0][0]="9952180671";
		data[0][1]="vishnu";
		
		data[1][0]="priya@gmail.com";
		data[1][1]="vishnu";
		
		return data;
		//outut it open in two browser pass username and password
	}	
	
	@AfterTest
	public void closebrowser()
	{
		driver.close();
		driver=null;//to avoid increase of memory while running
	}

}
