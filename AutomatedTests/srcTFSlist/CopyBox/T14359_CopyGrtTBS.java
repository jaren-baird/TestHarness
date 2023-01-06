
package CopyBox;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T14359_CopyGrtTBS 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14359_CopyGrtTBS-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			
			//Enable boxes being used
	    	WebDriverLogin.enableBoxRange(wd, "900000", "900006");
			WebDriverLogin.resetBoxAll(wd, "900000", "900000");
			WebDriverLogin.resetBoxAll(wd, "899992", "899992");
			WebDriverLogin.resetBoxAll(wd, "900006", "900006");
			WebDriverLogin.searchBoxRange(wd, "900006", "900006");
			
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxTxtGreetingLength")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxTxtGreetingLength")).sendKeys("120");
	        
	        WebDriverLogin.waitT(wd, 250);
	        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreetingMaxNumGreetings", "9");
	        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudDefGreeting", "2");
	        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudBusyGreeting", "3");
	        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudNoAnsGreeting", "4");
	        WebDriverLogin.waitT(wd, 250);
	        
	        
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkEnableTimeblockScheduling")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkEnableTimeblockScheduling")).click();
	    	WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsSubmit")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        //
	        //Mon
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_0,0", "8", true, "1");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_0,1", "12", false, "2");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_0,2", "1", false, "3");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_0,3", "5", false, "4");
	        //Tue
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_1,0", "8", true, "1");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_1,1", "12", false, "2");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_1,2", "1", false, "3");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_1,3", "5", false, "4");
	        //Wed
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_2,0", "8", true, "1");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_2,1", "12", false, "2");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_2,2", "1", false, "3");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_2,3", "5", false, "4");
	        //Thur
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_3,0", "8", true, "1");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_3,1", "12", false, "2");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_3,2", "1", false, "3");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_3,3", "5", false, "4");
	        //Fri
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_4,0", "8", true, "1");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_4,1", "12", false, "2");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_4,2", "1", false, "3");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_4,3", "5", false, "4");
	        //Sat
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_5,0", "8", true, "1");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_5,1", "12", false, "2");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_5,2", "1", false, "3");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_5,3", "5", false, "4");
	        //Sun
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_6,0", "8", true, "1");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_6,1", "12", false, "2");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_6,2", "1", false, "3");
	        createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_6,3", "5", false, "4");
	        //
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
	        	result += -10;
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsClose")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += resultException();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
        //
		try
		{
			wd = WebDriverLogin.getWebAdmin();
	        copyOneBox(wd, "900006", "900000");
	        copyOneBox(wd, "900006", "899992");
	        //
	        
	        //
	        result += checkBoxes(wd, "900000", "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings", true);
	        result += checkBoxes(wd, "899992", "ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings", false);
	        //
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += resultException();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		
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
	
	public static int checkBoxes(ChromeDriver wd, String box, String boxtype, boolean vm) throws InterruptedException
	{
		int result = 0;
		
		WebDriverLogin.searchBoxRange(wd, box, box);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
        WebDriverLogin.waitT(wd, 2000);
        wd.findElement(By.linkText("Greetings")).click();
        WebDriverLogin.waitT(wd, 2000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Time Blocks Scheduling")) 
		{
			WebDriverLogin.waitT(wd, 12500);
			if(!wd.findElement(By.tagName("html")).getText().contains("Time Blocks Scheduling")) 
				WebDriverLogin.waitT(wd, 35000);
		}
        
        if(vm == true)
        {
	        //Mon
	        result += checkTimeBlockVM(wd, boxtype+"_0,0", "8", true, "1");
	        result += checkTimeBlockVM(wd, boxtype+"_0,1", "12", false, "2");
	        result += checkTimeBlockVM(wd, boxtype+"_0,2", "1", false, "3");
	        result += checkTimeBlockVM(wd, boxtype+"_0,3", "5", false, "4");
	        //Tue
	        result += checkTimeBlockVM(wd, boxtype+"_1,0", "8", true, "1");
	        result += checkTimeBlockVM(wd, boxtype+"_1,1", "12", false, "2");
	        result += checkTimeBlockVM(wd, boxtype+"_1,2", "1", false, "3");
	        result += checkTimeBlockVM(wd, boxtype+"_1,3", "5", false, "4");
	        //Wed
	        result += checkTimeBlockVM(wd, boxtype+"_2,0", "8", true, "1");
	        result += checkTimeBlockVM(wd, boxtype+"_2,1", "12", false, "2");
	        result += checkTimeBlockVM(wd, boxtype+"_2,2", "1", false, "3");
	        result += checkTimeBlockVM(wd, boxtype+"_2,3", "5", false, "4");
	        //Thur
	        result += checkTimeBlockVM(wd, boxtype+"_3,0", "8", true, "1");
	        result += checkTimeBlockVM(wd, boxtype+"_3,1", "12", false, "2");
	        result += checkTimeBlockVM(wd, boxtype+"_3,2", "1", false, "3");
	        result += checkTimeBlockVM(wd, boxtype+"_3,3", "5", false, "4");
	        //Fri
	        result += checkTimeBlockVM(wd, boxtype+"_4,0", "8", true, "1");
	        result += checkTimeBlockVM(wd, boxtype+"_4,1", "12", false, "2");
	        result += checkTimeBlockVM(wd, boxtype+"_4,2", "1", false, "3");
	        result += checkTimeBlockVM(wd, boxtype+"_4,3", "5", false, "4");
	        //Sat
	        result += checkTimeBlockVM(wd, boxtype+"_5,0", "8", true, "1");
	        result += checkTimeBlockVM(wd, boxtype+"_5,1", "12", false, "2");
	        result += checkTimeBlockVM(wd, boxtype+"_5,2", "1", false, "3");
	        result += checkTimeBlockVM(wd, boxtype+"_5,3", "5", false, "4");
	        //Sun
	        result += checkTimeBlockVM(wd, boxtype+"_6,0", "8", true, "1");
	        result += checkTimeBlockVM(wd, boxtype+"_6,1", "12", false, "2");
	        result += checkTimeBlockVM(wd, boxtype+"_6,2", "1", false, "3");
	        result += checkTimeBlockVM(wd, boxtype+"_6,3", "5", false, "4");
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsClose")).click();
	        
        }
        else
        {
        	//Mon
            result += checkTimeBlockAT(wd, boxtype+"_0,0", "8", true, "1");
            result += checkTimeBlockAT(wd, boxtype+"_0,1", "12", false, "2");
            result += checkTimeBlockAT(wd, boxtype+"_0,2", "1", false, "3");
            result += checkTimeBlockAT(wd, boxtype+"_0,3", "5", false, "4");
            //Tue
            result += checkTimeBlockAT(wd, boxtype+"_1,0", "8", true, "1");
            result += checkTimeBlockAT(wd, boxtype+"_1,1", "12", false, "2");
            result += checkTimeBlockAT(wd, boxtype+"_1,2", "1", false, "3");
            result += checkTimeBlockAT(wd, boxtype+"_1,3", "5", false, "4");
            //Wed
            result += checkTimeBlockAT(wd, boxtype+"_2,0", "8", true, "1");
            result += checkTimeBlockAT(wd, boxtype+"_2,1", "12", false, "2");
            result += checkTimeBlockAT(wd, boxtype+"_2,2", "1", false, "3");
            result += checkTimeBlockAT(wd, boxtype+"_2,3", "5", false, "4");
            //Thur
            result += checkTimeBlockAT(wd, boxtype+"_3,0", "8", true, "1");
            result += checkTimeBlockAT(wd, boxtype+"_3,1", "12", false, "2");
            result += checkTimeBlockAT(wd, boxtype+"_3,2", "1", false, "3");
            result += checkTimeBlockAT(wd, boxtype+"_3,3", "5", false, "4");
            //Fri
            result += checkTimeBlockAT(wd, boxtype+"_4,0", "8", true, "1");
            result += checkTimeBlockAT(wd, boxtype+"_4,1", "12", false, "2");
            result += checkTimeBlockAT(wd, boxtype+"_4,2", "1", false, "3");
            result += checkTimeBlockAT(wd, boxtype+"_4,3", "5", false, "4");
            //Sat
            result += checkTimeBlockAT(wd, boxtype+"_5,0", "8", true, "1");
            result += checkTimeBlockAT(wd, boxtype+"_5,1", "12", false, "2");
            result += checkTimeBlockAT(wd, boxtype+"_5,2", "1", false, "3");
            result += checkTimeBlockAT(wd, boxtype+"_5,3", "5", false, "4");
            //Sun
            result += checkTimeBlockAT(wd, boxtype+"_6,0", "8", true, "1");
            result += checkTimeBlockAT(wd, boxtype+"_6,1", "12", false, "2");
            result += checkTimeBlockAT(wd, boxtype+"_6,2", "1", false, "3");
            result += checkTimeBlockAT(wd, boxtype+"_6,3", "5", false, "4");
            //
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxBtnGreetingsClose")).click();
        }
        
        WebDriverLogin.waitT(wd, 2500);
		
		return result;
	}
	
	public static int checkTimeBlockVM(ChromeDriver wd, String day, String time, boolean am, String grt) throws InterruptedException
	{
		int result = 0;
		
		try
        {
			//if(!wd.findElement(By.tagName("html")).getText().contains("Time Blocks Scheduling"))
	    	//	WebDriverLogin.waitT(wd, 12000);
			wd.findElement(By.id(day)).click();
	        WebDriverLogin.waitT(wd, 500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Time Blocks Scheduling"))
	    		WebDriverLogin.waitT(wd, 35000);
			//
	        String value = "";
	        //
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_grtSTBHour")).getAttribute("value");
	        if(!value.contains(time))
	        	result += -10;
	        												
	        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_STB_GrtDDL_DefGreet")));
			WebElement option = select.getFirstSelectedOption();
			value = option.getText();
			if(!value.contains(grt))
	        	result += -10;
			select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_STB_GrtDDL_BsyGreet")));
			option = select.getFirstSelectedOption();
			value = option.getText();
			if(!value.contains(grt))
	        	result += -10;
			select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_STB_GrtDDL_NAGreet")));
			option = select.getFirstSelectedOption();
			value = option.getText();
			if(!value.contains(grt))
	        	result += -10;
	        
	        WebDriverLogin.waitT(wd, 1000);
	        try
	        {
	        	if(am == true)
	        	{
	            	value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_grtSTBAMPM_0")).getAttribute("checked");
	            	if(!value.contains("true"))
	            		result += -15;
	        	}
	        	else
	        	{
	        		value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_grtSTBAMPM_1")).getAttribute("checked");
	        		if(!value.contains("true"))
	            		result += -15;
	        	}
	        }
	        catch(Exception ex)
	        {result += resultException();}
		}
	    catch(Exception ex)
	    {result += resultException();}
        
		return result;
	}
	
	public static int checkTimeBlockAT(ChromeDriver wd, String day, String time, boolean am, String grt) throws InterruptedException
	{
		int result = 0;
		
		try
        {
			//if(!wd.findElement(By.tagName("html")).getText().contains("Time Blocks Scheduling"))
	    	//	WebDriverLogin.waitT(wd, 12000);
			wd.findElement(By.id(day)).click();
	        WebDriverLogin.waitT(wd, 500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Time Blocks Scheduling"))
	    		WebDriverLogin.waitT(wd, 35000);
			//
	        String value = "";
	        //
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_grtSTBHour")).getAttribute("value");
	        if(!value.contains(time))
	        	result += -10;
	        												
	        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_STB_GrtDDL_DefGreet")));
			WebElement option = select.getFirstSelectedOption();
			value = option.getText();
			if(!value.contains(grt))
	        	result += -10;
	        
	        WebDriverLogin.waitT(wd, 1000);
	        try
	        {
	        	if(am == true)
	        	{
	            	value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_grtSTBAMPM_0")).getAttribute("checked");
	            	if(!value.contains("true"))
	            		result += -15;
	        	}
	        	else
	        	{
	        		value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_grtSTBAMPM_1")).getAttribute("checked");
	        		if(!value.contains("true"))
	            		result += -15;
	        	}
	        }
	        catch(Exception ex)
	        {result += resultException();}
        }
	    catch(Exception ex)
	    {result += resultException();}
        
		return result;
	}
	
	public static int copyOneBox(ChromeDriver wd, String boxCopyFrom, String boxCopyTo) throws Exception
    {
		int result = 0;
		
		try
		{
			WebDriverLogin.waitT(wd, 500);
	    	WebDriverLogin.searchBoxRange(wd, boxCopyTo, boxCopyTo);
	    	if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Copy")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        if(!wd.findElementByTagName("html").getText().contains("Copy Boxes"))
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Copy")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.linkText("Greetings")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).clear();
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).sendKeys(boxCopyFrom);
	        WebDriverLogin.waitT(wd, 1000);
        	while(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtTimeBlock_uxChkResetTimeBlockSch")).isSelected())
        	{
        		WebDriverLogin.waitT(wd, 500);
        		wd.findElement(By.id("uxChkResetGrtAll")).click();
        		WebDriverLogin.waitT(wd, 1000);
        	}
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Copy Successful"))
	    		result += -2000;
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 4000);
		}
        catch(Exception ex)
        {
        	ex.printStackTrace();
			result += resultException();
        }
	        
        return result;
    }
	
	public static int resultException()
	{
		return -109;
	}
}
