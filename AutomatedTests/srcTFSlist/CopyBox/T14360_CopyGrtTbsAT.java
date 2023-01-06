
package CopyBox;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T14360_CopyGrtTbsAT 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14360_CopyGrtTbsAT-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String boxTypeAT = "ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings";
		//
		wd = WebDriverLogin.getWebAdmin();
		
    	//
		WebDriverLogin.resetBoxAll(wd, "890997", "890997");
		WebDriverLogin.resetBoxAll(wd, "900000", "900000");
		WebDriverLogin.resetBoxAll(wd, "899992", "899992");
		WebDriverLogin.searchBoxRange(wd, "890997", "890997");
		
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
        WebDriverLogin.waitT(wd, 1500);
        wd.findElement(By.linkText("Greetings")).click();
        WebDriverLogin.waitT(wd, 1000);
        
        WebDriverLogin.waitT(wd, 250);
        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxDdlGreetingMaxNumGreetings", "9");
        WebDriverLogin.waitT(wd, 250);
        
        
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxChkEnableTimeblockScheduling")).isSelected()) 
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxChkEnableTimeblockScheduling")).click();
    	WebDriverLogin.waitT(wd, 2000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxBtnGreetingsSubmit")).click();
        WebDriverLogin.waitT(wd, 2000);
        //
        //Mon
        createTimeBlock(wd, boxTypeAT+"_0,0", "8", true, "1");
        createTimeBlock(wd, boxTypeAT+"_0,1", "12", false, "2");
        createTimeBlock(wd, boxTypeAT+"_0,2", "1", false, "3");
        createTimeBlock(wd, boxTypeAT+"_0,3", "5", false, "4");
        //Tue
        createTimeBlock(wd, boxTypeAT+"_1,0", "8", true, "1");
        createTimeBlock(wd, boxTypeAT+"_1,1", "12", false, "2");
        createTimeBlock(wd, boxTypeAT+"_1,2", "1", false, "3");
        createTimeBlock(wd, boxTypeAT+"_1,3", "5", false, "4");
        //Wed
        createTimeBlock(wd, boxTypeAT+"_2,0", "8", true, "1");
        createTimeBlock(wd, boxTypeAT+"_2,1", "12", false, "2");
        createTimeBlock(wd, boxTypeAT+"_2,2", "1", false, "3");
        createTimeBlock(wd, boxTypeAT+"_2,3", "5", false, "4");
        //Thur
        createTimeBlock(wd, boxTypeAT+"_3,0", "8", true, "1");
        createTimeBlock(wd, boxTypeAT+"_3,1", "12", false, "2");
        createTimeBlock(wd, boxTypeAT+"_3,2", "1", false, "3");
        createTimeBlock(wd, boxTypeAT+"_3,3", "5", false, "4");
        //Fri
        createTimeBlock(wd, boxTypeAT+"_4,0", "8", true, "1");
        createTimeBlock(wd, boxTypeAT+"_4,1", "12", false, "2");
        createTimeBlock(wd, boxTypeAT+"_4,2", "1", false, "3");
        createTimeBlock(wd, boxTypeAT+"_4,3", "5", false, "4");
        //Sat
        createTimeBlock(wd, boxTypeAT+"_5,0", "8", true, "1");
        createTimeBlock(wd, boxTypeAT+"_5,1", "12", false, "2");
        createTimeBlock(wd, boxTypeAT+"_5,2", "1", false, "3");
        createTimeBlock(wd, boxTypeAT+"_5,3", "5", false, "4");
        //Sun
        createTimeBlock(wd, boxTypeAT+"_6,0", "8", true, "1");
        createTimeBlock(wd, boxTypeAT+"_6,1", "12", false, "2");
        createTimeBlock(wd, boxTypeAT+"_6,2", "1", false, "3");
        createTimeBlock(wd, boxTypeAT+"_6,3", "5", false, "4");
        //
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxBtnGreetingsSubmit")).click();
        WebDriverLogin.waitT(wd, 4000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
        	result += -10;
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxBtnGreetingsClose")).click();
        WebDriverLogin.waitT(wd, 2000);
        //
        //
        
        //
		wd.quit();
		wd = WebDriverLogin.getWebAdmin();
        copyOneBox(wd, "890997", "900000");
        copyOneBox(wd, "890997", "899992");
        //
        
        //
        result += checkBoxes(wd, "900000", "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings", true);
        result += checkBoxes(wd, "899992", "ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings", false);
        
        wd.quit();
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
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_grtSTBAMPM_1")).click();
		
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_grtSTBHour")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_grtSTBHour")).sendKeys(time);
        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_STB_GrtDDL_DefGreet", grt);
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_STB_ApplyBtn")).click();
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
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxLblGreetingLength")).click();
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
        {result += -10;}
        
		return result;
	}
	
	public static int checkTimeBlockAT(ChromeDriver wd, String day, String time, boolean am, String grt) throws InterruptedException
	{
		int result = 0;
		
		
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
        {result += -10;}
        
		return result;
	}
	
	public static int copyOneBox(ChromeDriver wd, String boxCopyFrom, String boxCopyTo) throws Exception
    {
		WebDriverLogin.waitT(wd, 500);
    	int result = 0;
    	WebDriverLogin.searchBoxRange(wd, boxCopyTo, boxCopyTo);
    	if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).isSelected()) 
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
        WebDriverLogin.waitT(wd, 500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Copy")).click();
        WebDriverLogin.waitT(wd, 2000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).sendKeys(boxCopyFrom);
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.linkText("Greetings")).click();
        if(!wd.findElement(By.id("uxChkResetGrtAll")).isSelected())
            wd.findElement(By.id("uxChkResetGrtAll")).click();
        WebDriverLogin.waitT(wd, 500);
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtTimeBlock_AA_uxChkResetTimeBlockSch_AA")).isSelected())
        {
        	wd.findElement(By.id("uxChkResetAll")).click();
        	result += -3100;
        }
        
        
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
        WebDriverLogin.waitT(wd, 4000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Copy Successful"))
    		result += -2000;
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
        WebDriverLogin.waitT(wd, 4000);
        return result;
    }
}
