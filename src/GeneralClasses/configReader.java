package GeneralClasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class configReader {
	
	 
		
		private Properties properties;
		private final String propertyFilePath= "./config.properties";
		
	 
		
		public configReader(){
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(propertyFilePath));
				properties = new Properties();
				try {
					properties.load(reader);
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
			}		
		}
		
		public String getDriverPath(){
			String driverPath = properties.getProperty("chromePath");
			if(driverPath!= null) return driverPath;
			else throw new RuntimeException("ChromeDriver Path not found");		
		}
		
		public String getApplicationUrl() {
			String url = properties.getProperty("applnURL");
			if(url != null) return url;
			else throw new RuntimeException("Application URL not found");
		}
		
		public String getExcelPath() {		
			String path = properties.getProperty("Excelpath");
			if(path != null) return path;
			else throw new RuntimeException("TestData Excel not found");		
		}
		
		public String getReportPath() {		
			String path = properties.getProperty("Reportpath");
			if(path != null) return path;
			else throw new RuntimeException("Extent Reports path not found");		
		}
		
		public String getScreenshotPath() {		
			String path = properties.getProperty("ScreenshotPath");
			if(path != null) return path;
			else throw new RuntimeException("Screenshots path not found");		
		}
		
		public String getlogPath() {		
			String path = properties.getProperty("LogsPath");
			if(path != null) return path;
			else throw new RuntimeException("Screenshots path not found");		
		}

		
		
		
		
	 
	}


