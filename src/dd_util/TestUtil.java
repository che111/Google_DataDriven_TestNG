package dd_util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import dd_Core.testCore;

public class TestUtil extends testCore{

	
	
	public static boolean isExecutable(String tcid){
		
		for(int rowNum=2; rowNum<=excel.getRowCount("TestSuit"); rowNum++){
			if(excel.getCellData("TestSuit","TCID", rowNum).equals(tcid)){
				if(excel.getCellData("TestSuit","Runmode", rowNum).equalsIgnoreCase("Y")){
					return true;
				}
				else{
					return false;
				}
					
			}
		}
		return false;
	}

	
	public static Object[][] getData(String sheetName){
		// return test data;
		// read test data from xls
		
		int rows=excel.getRowCount(sheetName)-1;
		if(rows <=0){
			Object[][] testData =new Object[1][0];
			return testData;
			
		}
	    rows = excel.getRowCount(sheetName);  // 3
		int cols = excel.getColumnCount(sheetName);
		//System.out.println("total rows -- "+ rows);
		//System.out.println("total cols -- "+cols);
		Object data[][] = new Object[rows-1][cols];
		
		for( int rowNum = 2 ; rowNum <= rows ; rowNum++){
			
			for(int colNum=0 ; colNum< cols; colNum++){
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		
		return data;
		
		
	}


public static void captureScreenshot(){
	
	String mailscreenshotpath;
	
	  Calendar cal = new GregorianCalendar();
	  int month = cal.get(Calendar.MONTH);
	  int year = cal.get(Calendar.YEAR);
	  int sec =cal.get(Calendar.SECOND);
	  int min =cal.get(Calendar.MINUTE);
	  int date = cal.get(Calendar.DATE);
	  int day =cal.get(Calendar.HOUR_OF_DAY);
	  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    try {
	    	mailscreenshotpath = System.getProperty("user.dir")+"\\screenshot\\"+"_"+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+".jpeg";
			FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
		} catch (IOException e) 
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
    
   
    	      
         }
	   }
}

