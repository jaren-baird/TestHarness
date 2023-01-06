
package WebAdmin;

import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T13953_GrtTab_TBSeditable 
{
	private static int result = 9;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13953_GrtTab_TBSeditable-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String value = "";
		//
		wd = WebDriverLogin.getWebAdmin();
		WebDriverLogin.resetGreetingTab(wd, "900006", "900006");
		WebDriverLogin.searchBoxRange(wd, "900006", "900006");
		
		try
		{
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxTxtGreetingLength")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxTxtGreetingLength")).sendKeys("120");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxTxtGreetingLength")).sendKeys(Keys.ENTER);
	        WebDriverLogin.waitT(wd, 250);
	        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreetingMaxNumGreetings", "9");
	        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudDefGreeting", "2");
	        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudBusyGreeting", "3");
	        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudNoAnsGreeting", "4");
	        WebDriverLogin.waitT(wd, 250);
	        //
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxLblGreeting_Status")).getText().contains("Updated"))
	        	result += -10;
	        //
	        try
	        {
	        	if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkEnableTimeblockScheduling")).isSelected())
		        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkEnableTimeblockScheduling")).click();
	        	wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	        	createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_0,0", "8", true, "2");
	        	result += -10; //supposed to throw an exception before reaching this
	        }
	        catch(Exception ex)
	        {
	        	//System.out.println("Cannot create a time block without the enabled box selected");
	        }
	        try
	        {
	        	if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkEnableTimeblockScheduling")).isSelected())
	        		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkEnableTimeblockScheduling")).click();
        		createTimeBlock(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_0,0", "8", true, "2");
        		WebDriverLogin.waitT(wd, 1500);
        		value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_0,0")).getAttribute("value");
        		if(!value.contains("8:00 AM"))
        			result += -10;
	        }
	        catch(Exception ex)
	        {result += -10;}
	        
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxLblGreeting_Status")).getText().contains("Updated"))
	        	result += -10;
		}
		catch (Exception ex)
		{result += -109;}
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsClose")).click();
        WebDriverLogin.waitT(wd, 2000);
        //
        
        //
        wd.quit();
        System.exit(result);
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
				wd.findElement(By.id(field)).sendKeys(Keys.ENTER);
				WebDriverLogin.waitT(wd, 250);
				select = new Select(wd.findElement(By.id(field)));
				option = select.getFirstSelectedOption();
				valueX = option.getText();
			}
		}
		catch (Exception ex){}
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
        WebDriverLogin.waitT(wd, 250);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_STB_ApplyBtn")).click();
        WebDriverLogin.waitT(wd, 2500);
        //
		return result;
	}
}
