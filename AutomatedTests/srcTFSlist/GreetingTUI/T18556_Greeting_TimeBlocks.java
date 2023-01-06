
package GreetingTUI;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T18556_Greeting_TimeBlocks
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	private static String timeBlockID = "";
	//T18556_Greeting_TimeBlocks-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String url = "";
		
		//Setup 900006
		WebDriverLogin.setupBox900006grt();
		//
		try
		{
	        String[] folderList = {"DList", "TestSuite", "Greeting", "T18555_Greeting_RecordEach"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 230000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += exceptRes();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		//Begin TimeBlock tests
  	   	//SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_WEEK);
		int hourInt = 12;//c.get(Calendar.HOUR_OF_DAY);
		boolean am = true;//if(hourInt>=12)am=false; //if(hourInt>12)hourInt-=12;
		timeBlockID = getTimeBlockID(day);
		String hour = Integer.toString(hourInt);
		//
		//Greeting 1 default
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetTimeBlocks(wd, "900006", "900006");
	    	WebDriverLogin.searchBoxRange(wd, "900006", "900006");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkEnableTimeblockScheduling")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkEnableTimeblockScheduling")).click();
	    	WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsSubmit")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        createTimeBlock(wd, timeBlockID, hour, am, "1");
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += exceptRes();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
        //
		try
		{
	        String[] folderList = {"DList", "TestSuite", "Greeting", "T18556_GrtTBS_Listen1"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 60000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += exceptRes();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		//Greeting 2 busy
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetTimeBlocks(wd, "900006", "900006");
	    	WebDriverLogin.searchBoxRange(wd, "900006", "900006");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkEnableTimeblockScheduling")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkEnableTimeblockScheduling")).click();
	    	WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsSubmit")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        //
	        createTimeBlock(wd, timeBlockID, hour, am, "2");
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += exceptRes();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
        //
		try
		{
	        String[] folderList = {"DList", "TestSuite", "Greeting", "T18556_GrtTBS_Listen2"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 58000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += exceptRes();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
  	   	//Greeting 3 no answer
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetTimeBlocks(wd, "900006", "900006");
	    	WebDriverLogin.searchBoxRange(wd, "900006", "900006");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkEnableTimeblockScheduling")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkEnableTimeblockScheduling")).click();
	    	WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsSubmit")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        //
	        createTimeBlock(wd, timeBlockID, hour, am, "3");
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += exceptRes();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
        //
		try
		{
	        String[] folderList = {"DList", "TestSuite", "Greeting", "T18556_GrtTBS_Listen3"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 55000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += exceptRes();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
        //
  	   	System.exit(result);
	}
	
	public static int createTimeBlock(ChromeDriver wd, String day, String time, boolean am, String grt) throws InterruptedException
	{
		int result = 0;
		
		if(!wd.findElement(By.tagName("html")).getText().contains("Time Blocks Scheduling"))
    		WebDriverLogin.waitT(wd, 12000);
		wd.findElement(By.id(day)).click();
        WebDriverLogin.waitT(wd, 3500);
		//
        if(am == false)
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_grtSTBAMPM_1")).click();
		
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_grtSTBHour")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_grtSTBHour")).sendKeys(time);
        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_STB_GrtDDL_DefGreet", grt);
        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_STB_GrtDDL_BsyGreet", grt);
        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_STB_GrtDDL_NAGreet", grt);
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_STB_ApplyBtn")).click();
        WebDriverLogin.waitT(wd, 3500);
        //

		
		
		return result;
	}
	
	public static void forceChange(ChromeDriver wd, String field, String value)
	{
		Select select = new Select(wd.findElement(By.id(field)));
		WebElement option = select.getFirstSelectedOption();
		String valueX = option.getText();
		try
		{
			while(!valueX.contains(value))
			{
				wd.findElement(By.id(field)).sendKeys(value);
				WebDriverLogin.waitT(wd, 250);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxLblGreetingLength")).click();
				WebDriverLogin.waitT(wd, 250);
				select = new Select(wd.findElement(By.id(field)));
				option = select.getFirstSelectedOption();
				valueX = option.getText();
			}
		}
		catch (Exception ex){}
	}
	
	public static String getTimeBlockID(int day) throws InterruptedException
	{
		String timeblock = "";
		WebDriverLogin.waitT(wd, 2000);
		
		if(day == 2) //Monday
			timeblock = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_0,0";
		if(day == 3) //Tuesday
			timeblock = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_1,0";
		if(day == 4) //Wednesday
			timeblock = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_2,0";
		if(day == 5) //Thursday
			timeblock = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_3,0";
		if(day == 6) //Friday
			timeblock = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_4,0";
		if(day == 0) //Saturday
			timeblock = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_5,0";
		if(day == 1) //Sunday
			timeblock = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_6,0";
		
		
		return timeblock;
	}
	
	public static int exceptRes()
	{
		return -109;
	}
}
