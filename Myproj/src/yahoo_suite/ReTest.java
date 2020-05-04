package yahoo_suite;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Yahoo_Prg.Compose;
import Yahoo_Prg.Inbox;
import Yahoo_Prg.Login;
import Yahoo_Prg.MainClass;

public class ReTest extends MainClass
{
  
  @Test	
  @Parameters({"browser"})
  public void retesting(String str) throws Exception
  {
	  if(str.matches("firefox"))
	  {
		  driver=new FirefoxDriver();
	  }
	  if(str.matches("chrome"))
	  {
		  driver=new ChromeDriver();
	  }
	  FileInputStream fin = new FileInputStream("D:\\sel_dec18\\testcases.xlsx");  //get the excel file
	  XSSFWorkbook wb=new XSSFWorkbook(fin);   //get workbook in the file
	  XSSFSheet ws=wb.getSheet("retest"); //get sheet in the workbook

	  Row row;
	  String classname,methodname;
	  for(int r=1;r<=ws.getLastRowNum();r++)  //for all the rows in the sheet
	  {
			row=ws.getRow(r);
			if(row.getCell(5).getStringCellValue().matches("yes"))
			{
				classname=row.getCell(3).getStringCellValue();
				methodname=row.getCell(4).getStringCellValue();
				Class c=Class.forName(classname);   
				Method m=c.getMethod(methodname, null);		
				Object obj=c.newInstance();    
				m.invoke(obj, null);				
			}
	  }
	  fin.close();
	  
	  /*Login l=new Login();
	  l.validate_login();
	  l.signup();
	  l.valid_login();
	  
	  Inbox i=new Inbox();
	  i.deletemail();
	  
	  Compose c=new Compose();
	  c.close();*/
	  
	 
  }
}
