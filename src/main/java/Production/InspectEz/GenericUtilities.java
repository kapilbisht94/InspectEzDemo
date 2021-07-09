package Production.InspectEz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GenericUtilities extends Base{

AndroidDriver<AndroidElement> driver;
	
	public GenericUtilities(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}
	public void waitFunc(AndroidDriver<AndroidElement> driver, int time) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver,time);
	    wait.until(ExpectedConditions.alertIsPresent());
		 Alert alert1 = driver.switchTo().alert();		
	        // Capturing alert message.    
	     String alertMessage1= driver.switchTo().alert().getText();				
	        // Displaying alert message		
	     System.out.println(alertMessage1);	
	     Thread.sleep(5000);	        		
	        // Accepting alert		
	     alert1.accept();
	}
	
	public void ExcelData(String sheetName) throws FileNotFoundException
	{
		FileInputStream fis= new FileInputStream("C:\\Users\\kapilb\\Desktop\\APPIUM STUFFS\\InspectEzApp\\AutomationInspectEzTestCases.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		int sheets = workbook.getNumberOfSheets(); 
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase(sheetName))
			{
			XSSFSheet sheet =workbook.getSheetAt(i);
			Iterator<Row> rows=sheet.iterator();
			Row firstrow= rows.next();
			Iterator<Cell> cell=firstrow.cellIterator();
			int k=0;
			int column=0;
			while(cell.hasNext())
			{
				Cell value= cell.next();
				if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
				{
					column=k;
				}
				k++;
			}
			
			while(rows.hasNext())
			{
				Row r=rows.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase"))
				{
					Iterator<Cell> c= r.cellIterator();
					while(c.hasNext())
					{
						System.out.println(c.next().getStringCellValue());
					}
				}
			}
			}
			
		}
		
	}
}
