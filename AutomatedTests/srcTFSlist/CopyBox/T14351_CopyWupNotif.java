
package CopyBox;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T14351_CopyWupNotif 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14351_CopyWupNotif-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			wd = WebDriverLogin.implicitlyWaitSetter(wd);
			//Enable boxes being used
	    	WebDriverLogin.enableBoxRange(wd, "900006", "900008");
			WebDriverLogin.resetBoxAll(wd, "900006", "900008");
			WebDriverLogin.searchBoxRange(wd, "900006", "900008");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications")).click();
	        WebDriverLogin.waitT(wd, 3500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationThree")).click();
	        WebDriverLogin.waitT(wd, 3500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbWakeUp")).click();
	        WebDriverLogin.waitT(wd, 3500);
	        //
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtDialingString")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtDialingString")).sendKeys("900006");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtOwnerProgNumber")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtOwnerProgNumber")).sendKeys("6");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtNumberOfAttempts")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtNumberOfAttempts")).sendKeys("12");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlNumberOfOwnerProgDigits")).sendKeys("5");
	        WebDriverLogin.waitT(wd, 500);
	        
	        //
	        WebDriverLogin.waitT(wd, 250);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlStartTimeHour")).sendKeys("5");
	        WebDriverLogin.waitT(wd, 250);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlEndTimeHour")).sendKeys("5");
	        WebDriverLogin.waitT(wd, 250);
	        
	        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlStartTimeHour")));
			WebElement option = select.getFirstSelectedOption();
			String value = option.getText();
	        while(!value.contains("5"))
	        {
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtDigitsDialedAfterConection")).click();
	        	WebDriverLogin.waitT(wd, 250);
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlStartTimeHour")).sendKeys("5");
	        	select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlNumberOfOwnerProgDigits")));
	    		option = select.getFirstSelectedOption();
	    		value = option.getText();
	        }
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlStartTimeHour")).sendKeys("5");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlDelayHour")).sendKeys("1");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlRetryHour")).sendKeys("1");
	        //
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxChkSunday")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxChkSunday")).click();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxChkSaturday")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxChkSaturday")).click();
	        //
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxBtnWakeUpSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.tagName("html")).getText().toLowerCase().contains("changes accepted"))
	    		result += -2000;
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        //
	        
	        //
	        //WebDriverLogin.waitT(wd, 1000);
	        WebDriverLogin.searchBoxRange(wd, "900006", "900008", 2500);
	        //WebDriverLogin.waitT(wd, 1000);
	        if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected()) 
	        {
	        	wd.findElement(By.id("uxChkboxsrtpr")).click();
	        	if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).isSelected()) 
	        		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Copy")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).sendKeys("900006");
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.linkText("Notifications")).click();
	        result += copyOneBox(wd);
	        if(!wd.findElement(By.id("uxChkResetNotifAll")).isSelected())
	            wd.findElement(By.id("uxChkResetNotifAll")).click();
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Copy Successful"))
	        {
	        	WebDriverLogin.waitT(wd, 15000);
		        if(!wd.findElement(By.tagName("html")).getText().contains("Copy Successful"))
		    		result += -2000;
	        }
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        //
	        
	        //
	        result += checkBoxes(wd, "900007");
	        result += checkBoxes(wd, "900008");
	        
	        wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += -109;
			ex.printStackTrace();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
	        
        System.exit(result);
	}
	
	public static int checkBoxes(ChromeDriver wd, String box) throws InterruptedException
	{
		int result = 0;
		
		WebDriverLogin.searchBoxRange(wd, box, box);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
        WebDriverLogin.waitT(wd, 1500);
        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications")).click();
        WebDriverLogin.waitT(wd, 2000);
        
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationThree")).click();
        WebDriverLogin.waitT(wd, 2500);
        String value = "";
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtDialingString")).getAttribute("value");
        if(!value.contains("900006"))
        	result += -10;
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtOwnerProgNumber")).getAttribute("value");
        if(!value.contains("6"))
        	result += -10;
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtNumberOfAttempts")).getAttribute("value");
        if(!value.contains("12"))
        	result += -10;
        
        
        
        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlNumberOfOwnerProgDigits")));
		WebElement option = select.getFirstSelectedOption();
		value = option.getText();
		if(!value.contains("5"))
        	result += -10;
		
		select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlStartTimeHour")));
		option = select.getFirstSelectedOption();
		value = option.getText();
		if(!value.contains("5"))
        	result += -10;
		
		select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlEndTimeHour")));
		option = select.getFirstSelectedOption();
		value = option.getText();
		if(!value.contains("5"))
        	result += -10;
		
		select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlDelayHour")));
		option = select.getFirstSelectedOption();
		value = option.getText();
		if(!value.contains("10"))
        	result += -10;
		
		select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlRetryHour")));
		option = select.getFirstSelectedOption();
		value = option.getText();
		if(!value.contains("10"))
        	result += -10;
		
		
		
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxChkSunday")).isSelected())
        	result += -10;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxChkSaturday")).isSelected())
        	result += -10;
        
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
        WebDriverLogin.waitT(wd, 1500);
		
		return result;
	}
	
	public static int copyOneBox(ChromeDriver wd) throws Exception
    {
		WebDriverLogin.waitT(wd, 1000);
    	int result = 0;
    	
        if(!wd.findElement(By.id("uxChkResetNotifAll")).isSelected()) {
            wd.findElement(By.id("uxChkResetNotifAll")).click();
        }
        
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetNotifPlans")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetNotifPlans")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetNotifCtrl")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetNotifCtrl")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetWakeupCtrl")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetWakeupCtrl")).click();
        else
        	result += -2;
        
        
        
        WebDriverLogin.waitT(wd, 1000);
        if(wd.findElement(By.id("uxChkResetNotifAll")).isSelected()) 
        {
            wd.findElement(By.id("uxChkResetNotifAll")).click();
            WebDriverLogin.waitT(wd, 250);
            wd.findElement(By.id("uxChkResetNotifAll")).click();
        }
        
        WebDriverLogin.waitT(wd, 1000);
        return result;
    }
}
