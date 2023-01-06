
package WebAdmin;

import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T13905_Notif_DefaultsTele
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13905_Notif_DefaultsTele-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String value = "";
		//
		wd = WebDriverLogin.getWebAdmin();
		
		try
		{
			WebDriverLogin.resetNotifications(wd, "900006", "900006");
			WebDriverLogin.searchBoxRange(wd, "900006", "900006", 1500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElementByLinkText("Notifications").click();
	        WebDriverLogin.waitT(wd, 1500);
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationOne")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbTelephone")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        //Test Case 13905 WebAdmin - NotificationTab - Ignore Distribution Messages unchecked by default in telephone notification
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkTelePager_IgnoreDistMsgs")).isSelected()) 
	        	result += -10; //Default unselected
	        //Test Case 13907 WebAdmin - NotificationTab - Number of Messages default in telephone notification
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_NumOfMsgs")).getAttribute("value");
	        if(!value.contains("1")) 
	        	result += -10; //Default value 1
	        //Test Case 13914 WebAdmin - NotificationTab - Pre/Post Time unchecked for telephone
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkQueueStartEndTime")).isSelected()) 
	        	result += -10; //Default unselected
	        //
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        //
		}
	    catch (Exception ex)
	    {result+=-109;}
		
        wd.quit();
        System.exit(result);
	}
}
	
	