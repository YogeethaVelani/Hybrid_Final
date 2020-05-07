package GeneralClasses;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class testUtil {
	
	static configReader con;
	static WebDriver driver;
	public static SimpleDateFormat sdf;
	
	public static boolean isExecutable(XlsReader xlsfile, String sheet,
			 String testName) {
			 for (int rowNum =1;rowNum<=xlsfile.getRowCount(sheet); rowNum++) {
			 if (xlsfile.getData(sheet,0,rowNum).equals(testName)) {
			 if (xlsfile.getData(sheet,1,rowNum).equalsIgnoreCase("Y"))
			 return true;
			 else
			 return false;
			 }
			 }
			 return false;
			 }
	
	public static String captureScreenshot(WebDriver driver,String imageName) throws Exception
	{
		con=new configReader();
		
		if(imageName.equals(""))
		{
			imageName="Noname";
		}
		try
		{
			TakesScreenshot ss=(TakesScreenshot)driver;
			File source=ss.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source,new File(con.getScreenshotPath()+imageName+"_"+sdf.format(new Date())+".png"));
			
		}
		catch(Exception e)
		{
			System.out.println("Exception while capturing screenshot"+e.getMessage());
		
		}
		
		return imageName;
		
	}
}

