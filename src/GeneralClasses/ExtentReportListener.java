package GeneralClasses;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Tests.Baseclass;

public class ExtentReportListener implements IReporter{
	
	public ExtentReports extent;
	public ExtentTest test;
	public static SimpleDateFormat	sdf;

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
			 sdf=new SimpleDateFormat("dd-MM-YYYY-hh-mm-ss");
			configReader con=new configReader();
			try
			{
				extent=new ExtentReports(System.getProperty("user.dir")+"/ExtentReports/"+"Final_Report"+sdf.format(new Date())+".html",true);	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			for (ISuite suite : suites) {
		        Map<String, ISuiteResult> result = suite.getResults();

		        for (ISuiteResult r : result.values()) {
		             
		        	ITestContext context = r.getTestContext();

		            buildTestNodes(context.getPassedTests(), LogStatus.PASS);
		            buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
		            buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
		          
		        }
		    }

		    extent.flush();
		    extent.close();
		}

		public  void buildTestNodes(IResultMap tests, LogStatus status) {
		   

		    if (tests.size() > 0) {
		        for (ITestResult result : tests.getAllResults()) {
		            test = extent.startTest(result.getMethod().getMethodName());

		            test.getTest().setStartedTime(getTime(result.getStartMillis()));
		            test.getTest().setEndedTime(getTime(result.getEndMillis()));

		            for (String group : result.getMethod().getGroups())
		            {   
		            test.assignCategory(group);
		            }
		            
		           	            
		            //String message = "Test " +status.toString().toLowerCase() + "ed";
		            
		            if (result.getThrowable() != null)
		            {
		            	test.log(status, result.getThrowable());
		            	 		                    
		            
		            String file = System.getProperty("user.dir")+"/Screenshots/"+"FailureMethod"+result.getMethod().getMethodName()+".png";
					try {
						testUtil.captureScreenshot(Baseclass, file);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					test.log(status, test.addScreenCapture(file));
		            }
		            
					
				else 
				{
					test.log(status, "Test " + status.toString().toLowerCase()
							+ "ed");
				}
		            
		           	           
		            extent.endTest(test);
		            
		        }
		    }
		}
		
		            
		   

		private  Date getTime(long millis) {
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTimeInMillis(millis);
		    return calendar.getTime();        
		}
		 
		
		
		
	}
	
	


