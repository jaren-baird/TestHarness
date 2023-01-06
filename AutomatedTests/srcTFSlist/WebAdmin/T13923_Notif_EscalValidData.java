
package WebAdmin;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class T13923_Notif_EscalValidData
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13923_Notif_EscalValidData-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetNotifications(wd, "900006", "900006");
			WebDriverLogin.searchBoxRange(wd, "900006", "900006", 3500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElementByLinkText("Notifications").click();
	        WebDriverLogin.waitT(wd, 2500);
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationOne")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbEscalation")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        String id = "";
	        String errorId = "";
	        String errorNotice = "";
	        String[] invalidDigits = {"A","B","C","D","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","!","$","%","^","&","(",")","@"};
	        String[] invalidNumberic = {"0"};
	        String[] validNumerics = {"1","10","50","99"};
        	//Number of Messages Valid
	        //Test Case 13923:WebAdmin - NotificationTab - Escalation - Values of Number of Messages
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxTxtNumberOfMessages";
	        errorId = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_ESRangeValidator1";
	        errorNotice = "Values 1 - 99";
	        result += checkField(wd, id, errorId, errorNotice, validNumerics, true);
	        //Number of Messages invalid non numerics
	        //Test Case 13923:WebAdmin - NotificationTab - Escalation - Values of Number of Messages
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxTxtNumberOfMessages";
	        errorId = "EscRegularExpressionValidator4";
	        errorNotice = "Numeric Values Only";
	        result += checkField(wd, id, errorId, errorNotice, invalidDigits, false);
	        //
	        //Number of Messages invalid numeric 0
	        //Test Case 13923:WebAdmin - NotificationTab - Escalation - Values of Number of Messages
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxTxtNumberOfMessages";
	        errorId = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_ESRangeValidator1";
	        errorNotice = "Values 1 - 99";
	        result += checkField(wd, id, errorId, errorNotice, invalidNumberic, false);
	        //
	        //Escalation Box Invalid
	        //Test Case 20462:Validate that only valid string can be use for "Escalation Box" fields. (Notification)
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxTxtEscalationBox";
	        errorId = "EscalationRegularExpressionValidator4";
	        errorNotice = "Values 1 - 99";
	        result += checkField(wd, id, errorId, errorNotice, validNumerics, true);
	        //
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxTxtEscalationBox";
	        errorId = "EscalationRegularExpressionValidator4";
	        errorNotice = "Numeric Values Only.";
	        result += checkField(wd, id, errorId, errorNotice, invalidDigits, false);
	        //
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxTxtEscalationBox";
	        errorId = "EscalationRegularExpressionValidator4";
	        errorNotice = "Numeric Values Only.";
	        result += checkField(wd, id, errorId, errorNotice, invalidNumberic, true); //0 works
	        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	        //
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxBtnEscalationSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(wd.findElement(By.tagName("html")).getText().toLowerCase().contains("changes accepted"))
	    		result += -2000; //should not submit with invalid data entered
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
	        WebDriverLogin.waitT(wd, 2500);
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
	
	public static int checkField(ChromeDriver wd, String id, String errorId, String errorNotice, String[] validDigits, boolean equiv)
	{
		int result = 0;
		String checkData = "";
		errorNotice = errorNotice.toLowerCase();
		try
		{
			for(int i = 0; i < validDigits.length; i++)
			{
				wd.findElement(By.id(id)).clear();
				wd.findElement(By.id(id)).sendKeys(validDigits[i]);
				wd.findElement(By.id(id)).sendKeys(Keys.ENTER);
				WebDriverLogin.waitT(wd, 100);
				checkData = wd.findElement(By.id(errorId)).getText().toLowerCase();
				if(checkData.contains(errorNotice) && equiv || !equiv && !checkData.contains(errorNotice))
					result += -10;
			}
		}
		catch(Exception ex)
		{
			result += -10;
		}
		
		return result;
	}
}
	
	