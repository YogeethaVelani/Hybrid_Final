package GeneralClasses;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class XlsReader {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	
	public XlsReader(String excelPath)
	{
		File src=new File(excelPath);
		try {
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
			sheet=wb.getSheetAt(0);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getData(String sheetname,int colnum,int rownum)
	{
		sheet=wb.getSheet(sheetname);
		String data=sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		return data;
	}
	
	public int getRowCount(String sheetname)
	{
		sheet=wb.getSheet(sheetname);
		int rowCount=sheet.getLastRowNum()+1;
		return rowCount;
	}
	
	public int getColCount(String sheetname)
	{
		sheet=wb.getSheet(sheetname);
		XSSFRow rows=sheet.getRow(0);
		int colCount=rows.getLastCellNum();
		return colCount;
	}
	
		
	public Object[][] testData(String xlspath,String sheetname) throws Exception
	{
		Object[][] excelData=null;
		XlsReader xlsfile=new XlsReader(xlspath);
		int rows=xlsfile.getRowCount(sheetname);
		int cols=xlsfile.getColCount(sheetname);
		excelData=new Object[rows-1][cols];
		
		for(int i=1;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				excelData[i-1][j]=xlsfile.getData(sheetname, j, i);
			}
		}
		
		return excelData;
		
	}
	
	}
