package Tests;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import GeneralClasses.XlsReader;
import GeneralClasses.configReader;
import GeneralClasses.log;
import GeneralClasses.testUtil;

public class Baseclass {
	
	public static WebDriver driver;
	public configReader con=new configReader();
		
	
	
	@BeforeClass
	public void beforeClass()
	{
		 DOMConfigurator.configure("log4j.xml");
		 PageFactory.initElements(driver, this);
		 log.info("Page Factory initialized");
	}
	
		
	@BeforeMethod
	public void setup(Method method)
	{
		log.startTestCase(method.getName());
		log.info("---Browser Session started---");
		System.setProperty("webdriver.chrome.driver",con.getDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(con.getApplicationUrl());
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
		log.info("---Application Launched---");
	
	}
	
	@AfterMethod
	public void aftermethod()
	{
		driver.close();
		log.info("---Browser Session Ended---");
		driver.quit();
				
	}
	
	
	public void checkRunMode(String testName) {
		 con= new configReader();
		 XlsReader xls = new XlsReader(con.getExcelPath());
		 // It will throw exception if RunMode will return false
		 if (!testUtil.isExecutable(xls, "TestCases", testName))
		 throw new SkipException("Test not found");
		 }
	

	
		
	}
