
package CopyBox;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T14357_CopyAGreetingsAT 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14357_CopyAGreetingsAT-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetBoxAll(wd, "890997", "890999");
			WebDriverLogin.searchBoxRange(wd, "890997", "890999", 2500);
			
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxTxtGreetingLength")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxTxtGreetingLength")).sendKeys("120");
	        
	        WebDriverLogin.waitT(wd, 250);
	        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxDdlGreetingMaxNumGreetings", "9");
	        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxDdlGreeting_AudDefGreeting", "2");
	        WebDriverLogin.waitT(wd, 250);
	        
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxChkGreetingGrtPassNameEdit")).isSelected()) 
	        {
	        	result += failure();
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxChkGreetingGrtPassNameEdit")).click();
	        }
	        
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxBtnGreetingsSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
	        	result += failure();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxBtnGreetingsClose")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        //
	        
	        //
	        //WebDriverLogin.waitT(wd, 1000);
	        WebDriverLogin.searchBoxRange(wd, "890997", "890999", 2500);
	        //WebDriverLogin.waitT(wd, 1000);
	        if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected()) 
	        {
	        	wd.findElement(By.id("uxChkboxsrtpr")).click();
	        	if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).isSelected()) 
	        		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Copy")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).sendKeys("890997");
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.linkText("Greetings")).click();
	        WebDriverLogin.waitT(wd, 1000);
	        result += copyOneBox(wd);
	        if(!wd.findElement(By.id("uxChkResetGrtAll")).isSelected())
	            wd.findElement(By.id("uxChkResetGrtAll")).click();
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Copy Successful"))
	        	WebDriverLogin.waitT(wd, 12000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        //
	        result += checkBoxes(wd, "890998");
	        result += checkBoxes(wd, "890999");
	        
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += -109;
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		//
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
				WebDriverLogin.waitT(wd, 1000);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxLblGreetingLength")).click();
				WebDriverLogin.waitT(wd, 1000);
				select = new Select(wd.findElement(By.id(field)));
				option = select.getFirstSelectedOption();
				valueX = option.getText();
			}
		}
		catch (Exception ex){}
	}
	
	public static int checkBoxes(ChromeDriver wd, String box) throws InterruptedException
	{
		int result = 0;
		
		WebDriverLogin.searchBoxRange(wd, box, box);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
        WebDriverLogin.waitT(wd, 2000);
        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings")).click();
        WebDriverLogin.waitT(wd, 1500);
        if(!wd.findElement(By.tagName("html")).getText().contains("Time Blocks Scheduling")) 
		{
			WebDriverLogin.waitT(wd, 12500);
			if(!wd.findElement(By.tagName("html")).getText().contains("Time Blocks Scheduling")) 
				WebDriverLogin.waitT(wd, 35000);
		}
        
        String value = "";
        //
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxTxtGreetingLength")).getAttribute("value");
        if(!value.contains("120"))
        	result += failure();
        
        
        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxDdlGreetingMaxNumGreetings")));
		WebElement option = select.getFirstSelectedOption();
		value = option.getText();
		if(!value.contains("9"))
        	result += failure();
		select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxDdlGreeting_AudDefGreeting")));
		option = select.getFirstSelectedOption();
		value = option.getText();
		if(!value.contains("2"))
        	result += failure();
        //
		
        //
		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxChkGreetingGrtPassNameEdit")).isSelected())
        	result += failure();
		if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxChkGreetingAllowNameAudioBoxes")).isSelected())
        	result += failure();
		if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxChkGreetingPromptCallerLanguage")).isSelected())
        	result += failure();
		if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxChkGreetingKeepLanguage")).isSelected())
        	result += failure();
        //
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxBtnGreetingsClose")).click();
        WebDriverLogin.waitT(wd, 2500);
		
		return result;
	}
	
	public static int copyOneBox(ChromeDriver wd) throws Exception
    {
		WebDriverLogin.waitT(wd, 1000);
    	int result = 0;
    	
        if(!wd.findElement(By.id("uxChkResetGrtAll")).isSelected()) {
            wd.findElement(By.id("uxChkResetGrtAll")).click();
        }
        
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtTimeBlock_AA_uxChkResetTimeBlockSch_AA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtTimeBlock_AA_uxChkResetTimeBlockSch_AA")).click();
        else
        {
        	result += failure();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtTimeBlock_AA_uxChkResetTimeBlockSch_AA")).click();
        }
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtTimeBlock_AA_uxChkResetDailySchedule_AA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtTimeBlock_AA_uxChkResetDailySchedule_AA")).click();
        else
        {
        	result += failure();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtTimeBlock_AA_uxChkResetDailySchedule_AA")).click();
        }
        wd.findElement(By.linkText("Audio Greetings")).click();
        //
        WebDriverLogin.waitT(wd, 1000);
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtAudioGrt_AA_uxChkResetGrtName_AA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtAudioGrt_AA_uxChkResetGrtName_AA")).click();
        else
        {
        	result += failure();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtAudioGrt_AA_uxChkResetGrtName_AA")).click();
        }
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtAudioGrt_AA_uxChkResetGrtGreeting_AA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtAudioGrt_AA_uxChkResetGrtGreeting_AA")).click();
        else
        {
        	result += failure();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtAudioGrt_AA_uxChkResetGrtGreeting_AA")).click();
        }
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtAudioGrt_AA_uxChkResetGrtLength_AA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtAudioGrt_AA_uxChkResetGrtLength_AA")).click();
        else
    	{
        	result += failure();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtAudioGrt_AA_uxChkResetGrtLength_AA")).click();
    	}
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtAudioGrt_AA_uxChkResetMaxGreetings_AA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtAudioGrt_AA_uxChkResetMaxGreetings_AA")).click();
        else
    	{
        	result += failure();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtAudioGrt_AA_uxChkResetMaxGreetings_AA")).click();
    	}
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtAudioGrt_AA_uxChkResetDefGrt_AA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtAudioGrt_AA_uxChkResetDefGrt_AA")).click();
        else
    	{
        	result += failure();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtAudioGrt_AA_uxChkResetDefGrt_AA")).click();
    	}
        wd.findElement(By.linkText("Services")).click();
        WebDriverLogin.waitT(wd, 500);
        //
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtServices_AA_uxChkResetMultiLangGrt_AA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtServices_AA_uxChkResetMultiLangGrt_AA")).click();
        else
    	{
        	result += failure();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtServices_AA_uxChkResetMultiLangGrt_AA")).click();
    	}
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtServices_AA_uxChkResetGrtPCodeName_AA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtServices_AA_uxChkResetGrtPCodeName_AA")).click();
        else
    	{
        	result += failure();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtServices_AA_uxChkResetGrtPCodeName_AA")).click();
    	}
        
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtServices_AA_uxChkResetGrtAllowNameAT_AA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtServices_AA_uxChkResetGrtAllowNameAT_AA")).click();
        else
    	{
        	result += failure();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtServices_AA_uxChkResetGrtAllowNameAT_AA")).click();
    	}
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtServices_AA_uxChkResetGrtKeepLang_AA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtServices_AA_uxChkResetGrtKeepLang_AA")).click();
        else
    	{
        	result += failure();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtServices_AA_uxChkResetGrtKeepLang_AA")).click();
    	}
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtServices_AA_uxChkResetGrtPrmtpForLang_AA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtServices_AA_uxChkResetGrtPrmtpForLang_AA")).click();
        else
    	{
        	result += failure();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_AA_uxTpGrtServices_AA_uxChkResetGrtPrmtpForLang_AA")).click();
    	}
        

        WebDriverLogin.waitT(wd, 1000);
        if(wd.findElement(By.id("uxChkResetGrtAll")).isSelected()) 
        {
            wd.findElement(By.id("uxChkResetGrtAll")).click();
            WebDriverLogin.waitT(wd, 250);
            wd.findElement(By.id("uxChkResetGrtAll")).click();
        }
        
        WebDriverLogin.waitT(wd, 1000);
        return result;
    }
	
	public static int failure()
	{
		return -10;
	}
}
