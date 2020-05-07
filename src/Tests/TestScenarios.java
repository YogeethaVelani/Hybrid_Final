package Tests;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import GeneralClasses.XlsReader;
import GeneralClasses.configReader;
import GeneralClasses.log;
import GeneralClasses.testUtil;
//import General_Classes.captureScreenshot;
import Pages.Home;
import Pages.Login;

public class TestScenarios extends Baseclass {
	
	

	@Test(dataProvider="LoginTC001Data")
	public void Login_TC001(String usrname,String pwd) 
	{
		
		log.info("---Login_TC001 started---");
		SoftAssert a=new SoftAssert();
		Home homepage=new Home(driver);
		Login loginpage=homepage.linkclick();
		loginpage.performLogin(usrname,pwd);
		log.info("---Test complete---");
			
	}
	
	@Test(dataProvider="LoginTC002Data")
	public void Login_TC002(String usrname,String pwd) 
	{
		
		log.info("---Login_TC001 started---");
		SoftAssert a=new SoftAssert();
		Home homepage=new Home(driver);
		Login loginpage=homepage.linkclick();
		loginpage.performLogin(usrname,pwd);
		log.info("---Test complete---");
			
	}
	
				
	@DataProvider(name="LoginTC001Data")
	public Object[][] tc001data() throws Exception
	{
		checkRunMode("Login_TC001");
		configReader config=new configReader();
		XlsReader xls=new XlsReader(config.getExcelPath());
		Object[][] data=xls.testData(config.getExcelPath(),"Login_TC001");
		return data;
	}
	
	@DataProvider(name="LoginTC002Data")
	public Object[][] tc002data() throws Exception
	{
		checkRunMode("Login_TC002");
		configReader config=new configReader();
		XlsReader xls=new XlsReader(config.getExcelPath());
		Object[][] data=xls.testData(config.getExcelPath(),"Login_TC002");
		return data;
	}
	
	
	

}
