
package WebAdmin;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T20779_Notif_EscalInvalidBoxType
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T20779_Notif_EscalInvalidBoxType-t0
	//Test Case 20779:Notification Escalation box types
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetNotifications(wd, "900006", "900006");
			disableBoxRange(wd, "900000", "900004");
			WebDriverLogin.searchBoxRange(wd, "900006", "900006", 1500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElementByLinkText("Notifications").click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationOne")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbEscalation")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        //Disabled Range
	        result += escalBoxType(wd, "900000", false);  //Voice Mail (00 VM)(01 AT)(02 UCD)(03 FO)(04 TB)
	        result += escalBoxType(wd, "900001", false);  //Audio Text
	        result += escalBoxType(wd, "900003", false);  //Fax Only
	        result += escalBoxType(wd, "900002", false);  //UCD
	        result += escalBoxType(wd, "900004", false);  //Teacher Box
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        WebDriverLogin.enableBoxRange(wd, "900000", "900004");
	        WebDriverLogin.searchBoxRange(wd, "900006", "900006", 1500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElementByLinkText("Notifications").click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationOne")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbEscalation")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        //Enabled Range
	        result += escalBoxType(wd, "900000", true);  //Voice Mail (00 VM)(01 AT)(02 UCD)(03 FO)(04 TB)
	        result += escalBoxType(wd, "900001", false); //Audio Text
	        result += escalBoxType(wd, "900003", true);  //Fax Only
	        result += escalBoxType(wd, "900002", false); //UCD
	        result += escalBoxType(wd, "900004", true);  //Teacher Box
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        
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
	
	public static int escalBoxType(ChromeDriver wd, String box, boolean state)
	{
		int result = 0;
		
		WebDriverLogin.waitT(wd, 500);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxTxtEscalationBox")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxTxtEscalationBox")).sendKeys(box);
        WebDriverLogin.waitT(wd, 500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxBtnEscalationSubmit")).click();
        WebDriverLogin.waitT(wd, 4000); 
        String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxLblEscalationStatus")).getText();
		if(!value.contains("Changes Accepted") && state == true || !value.contains("Invalid Box Number") && state == false)
		{
			WebDriverLogin.waitT(wd, 10000); 
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxLblEscalationStatus")).getText();
	        if(!value.contains("Changes Accepted") && state == true || !value.contains("Invalid Box Number") && state == false)
	        	result += -10;
		}
        
		return result;
	}
	
	public static int disableBoxRange(ChromeDriver wd, String startNum, String endNum)
	{
		int result = 0;
		String rangeExtend = "0";
		try
		{
			for(int i = Integer.parseInt(startNum); i <= Integer.parseInt(endNum); i+=100)
			{
				if(Integer.parseInt(endNum)-i >= 100)
					rangeExtend = Integer.toString(i+99);
				else if(Integer.parseInt(endNum)-i >= 1 && Integer.parseInt(endNum)-i < 100)
					rangeExtend = endNum;
				else
					rangeExtend = Integer.toString(i);
					
				WebDriverLogin.searchBoxRange(wd, Integer.toString(i), rangeExtend, 2000);
			    //disable section
			    wd.findElement(By.id("uxChkboxsrtpr")).click();
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLB_Box_State")).click();
		    	WebDriverLogin.waitT(wd, 1000);
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRbState_Disabled")).click();
		    	WebDriverLogin.waitT(wd, 250);
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxState_Multi_Submit")).click();
		    	WebDriverLogin.waitT(wd, 1000);
			}
		}
		catch(Exception ex)
		{
			result += -109;
		}
		return result;
	}
}
	
	