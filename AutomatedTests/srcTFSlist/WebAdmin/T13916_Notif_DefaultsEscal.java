
package WebAdmin;

import java.util.List;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T13916_Notif_DefaultsEscal
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13916_Notif_DefaultsEscal-t0
	
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
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbEscalation")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        //Test Case 13917:WebAdmin - NotificationTab - Escalation - Distribution List default value none.
	        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxDdlEscalationDistributionList")));
			WebElement option = select.getFirstSelectedOption();
			value = option.getText();
			if(!value.contains("None")) 
	        	result += -10; //Default value none
	        //Test Case 13916:WebAdmin - NotificationTab - Escalation - Box default value is blank
			try{
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxTxtEscalationBox")).getAttribute("value");
			}catch(Exception ex){}//if blank then value field inaccessible 
	        if(value.length() != 0) 
	        	result += -10; //Default value blank
	        //Test Case 13918:WebAdmin - NotificationTab - Escalation - Carbon Copy checked by default
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxChkEscalationCarbonCopy")).isSelected()) 
	        	result += -10; //Default selected
	        //Test Case 13920:WebAdmin - NotificationTab - Escalation - Ignore Distribution Messages unchecked by default
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxChkIgnoreDistributionMessages")).isSelected()) 
	        	result += -10; //Default unselected
	        //Test Case 13922:WebAdmin - NotificationTab - Escalation - Number of Messages default+
	        
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxTxtNumberOfMessages")).getAttribute("value");
	        if(!value.contains("1")) 
	        	result += -10; //Default value 1
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
	
	