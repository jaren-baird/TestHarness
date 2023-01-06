
package CopyBox;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T14353_CopyEscalDList 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14353_CopyEscalDList-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			wd = WebDriverLogin.implicitlyWaitSetter(wd);
			//Enable boxes being used
			WebDriverLogin.resetBoxAll(wd, "900006", "900008");
			//
			WebDriverLogin.searchBoxRange(wd, "900006", "900008");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        result += createGDList(wd, "CREATEaGDL");
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications")).click();
	        WebDriverLogin.waitT(wd, 3500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationOne")).click();
	        //wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationFour")).click();
	        WebDriverLogin.waitT(wd, 3500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbEscalation")).click();
	        WebDriverLogin.waitT(wd, 3500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).click();
	        WebDriverLogin.waitT(wd, 1000);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxChkEscalationCarbonCopy")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxChkEscalationCarbonCopy")).click();
	        //
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxChkIgnoreDistributionMessages")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxChkIgnoreDistributionMessages")).click();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxChkPreservSenderInformation")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxChkPreservSenderInformation")).click();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxChkQueueStartEndTime")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxChkQueueStartEndTime")).click();
	        
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxTxtEscalationBox")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxTxtEscalationBox")).sendKeys("900006");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxTxtNumberOfMessages")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxTxtNumberOfMessages")).sendKeys("4");
	        WebDriverLogin.waitT(wd, 500);
	        //Select DList
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxDdlEscalationDistributionList")).sendKeys("90");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxTxtEscalationBox")).click();
	        
	        //
	        WebDriverLogin.waitT(wd, 250);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxDdlStartTimeHour")).sendKeys("5");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxDdlEndTimeHour")).sendKeys("5");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxDdlDelayHour")).sendKeys("1");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxDdlDelayMinute")).sendKeys("1");
	        //
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxChkSunday")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxChkSunday")).click();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxChkSaturday")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxChkSaturday")).click();
	        //
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxBtnEscalationSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.tagName("html")).getText().toLowerCase().contains("changes accepted"))
	    		result += -2000;
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        //
	        
	        //
	        //WebDriverLogin.waitT(wd, 1000);
	        WebDriverLogin.searchBoxRange(wd, "900006", "900008");
	        //WebDriverLogin.waitT(wd, 1000);
	        if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected()) 
	        {
	        	wd.findElement(By.id("uxChkboxsrtpr")).click();
	        	if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).isSelected()) 
	        		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Copy")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).sendKeys("900006");
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.linkText("Notifications")).click();
	        result += copyOneBox(wd);
	        if(!wd.findElement(By.id("uxChkResetNotifAll")).isSelected())
	            wd.findElement(By.id("uxChkResetNotifAll")).click();
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Copy Successful"))
	        {
	        	WebDriverLogin.waitT(wd, 12000);
		        if(!wd.findElement(By.tagName("html")).getText().contains("Copy Successful"))
		    		result += -2000;
	        }
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        //
	        result += checkBoxes(wd, "900007");
	        result += checkBoxes(wd, "900008");
	        //
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
        
        //wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationFour")).click();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationOne")).click();
        WebDriverLogin.waitT(wd, 2000);
        String value = "";
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxTxtNumberOfMessages")).getAttribute("value");
        if(!value.contains("4"))
        	result += fail();
        
        
        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxDdlStartTimeHour")));
		WebElement option = select.getFirstSelectedOption();
		value = option.getText();
		if(!value.contains("5"))
        	result += fail();
		
		select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxDdlEscalationDistributionList")));
		option = select.getFirstSelectedOption();
		value = option.getText();
		if(!value.contains("90-CREATEaGDL"))
        	result += fail();
		
		select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxDdlEndTimeHour")));
		option = select.getFirstSelectedOption();
		value = option.getText();
		if(!value.contains("5"))
        	result += fail();
		
		select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxDdlDelayHour")));
		option = select.getFirstSelectedOption();
		value = option.getText();
		if(!value.contains("10"))
        	result += fail();
		
		select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxDdlDelayMinute")));
		option = select.getFirstSelectedOption();
		value = option.getText();
		if(!value.contains("10"))
        	result += fail();
		
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).isSelected())
        	result += fail();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxChkEscalationCarbonCopy")).isSelected())
        	result += fail();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxChkIgnoreDistributionMessages")).isSelected())
        	result += fail();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxChkPreservSenderInformation")).isSelected())
        	result += fail();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxChkQueueStartEndTime")).isSelected())
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxChkSunday")).isSelected())
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxChkSaturday")).isSelected())
        	result += fail();
        
        
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
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetNotifCtrl")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetNotifCtrl")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetWakeupCtrl")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetWakeupCtrl")).click();
        else
        	result += fail();
        
        
        
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
	
	public static int createGDList(ChromeDriver wd, String gdlName)
	{
		int result = 0;
		
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
	    WebDriverLogin.waitT(wd, 2500);
	    //Create DList
	    if(!wd.findElement(By.tagName("html")).getText().contains(gdlName))
	    {
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(gdlName);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).click();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys("90");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("900005");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("900005");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Randy") && !wd.findElement(By.tagName("html")).getText().contains("Report Test"))
	        {
	        	result += -10;
	        }
	        else
	        {
	        	wd.findElement(By.id("uxChkDlistInternalSrch")).click();
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
	        	WebDriverLogin.waitT(wd, 2000);
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
	        	WebDriverLogin.waitT(wd, 1000);
	        	if(!wd.findElement(By.tagName("html")).getText().contains(gdlName))
	        	{
	        		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistClose")).click();
	        	}
	        	
	        	if(!wd.findElement(By.tagName("html")).getText().contains(gdlName))
		        	result += -10;
	        }	
	    }
	    
		
		return result;
	}
	
	public static int fail()
	{
		return -10;
	}
}
