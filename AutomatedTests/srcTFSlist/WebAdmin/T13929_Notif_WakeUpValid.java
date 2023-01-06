
package WebAdmin;

import java.util.List;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T13929_Notif_WakeUpValid
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13929_Notif_WakeUpValid-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
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
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbWakeUp")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        String id = "";
	        String errorId = "";
	        String errorNotice = "";
	        String[] validDigits = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","A","B","C","D","*","#","@"};
	        String[] validDTMF = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","A","B","C","D","*","#"};
	        String[] validNumerics = {"1","10","50","99"};
	        //Default Vaule 1
	        //Test Case 13937:WebAdmin - NotificationTab - Wakeup - Number of attempts default value
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtNumberOfAttempts")).getAttribute("value").contains("1"))
	        	result += -10;
        	//Dialing String
	        //Test Case 13929:WebAdmin - NotificationTab - Wakeup - Dialing String valid digits
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtDialingString";
	        errorId = "WakeRegularExpressionValidator1";
	        errorNotice = "Dial String Values Only.";
	        result += checkField(wd, id, errorId, errorNotice, validDigits);
	        //Digits Dialed After Connection
	        //Test Case 13931:WebAdmin - NotificationTab - Wakeup - Digits Dialed After Connection with valid digits
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtDigitsDialedAfterConection";
	        errorId = "WakeRegularExpressionValidator2";
	        errorNotice = "Dtmf Values Only.";
	        result += checkField(wd, id, errorId, errorNotice, validDTMF);
	        //Owner Programmable Number
	        //Test Case 13933:WebAdmin - NotificationTab - Wakeup - Owner Programmable Number with valid digits
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtOwnerProgNumber";
	        errorId = "WakeRegularExpressionValidator3";
	        errorNotice = "Dtmf Values Only.";
	        result += checkField(wd, id, errorId, errorNotice, validDTMF);
	        //Number of Attempts (1-99)
	        //Test Case 13937:WebAdmin - NotificationTab - Wakeup - Number of attempts valid values
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtNumberOfAttempts";
	        errorId = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_EMRangeValidator1";
	        errorNotice = "Values 1 - 99";
	        result += checkField(wd, id, errorId, errorNotice, validNumerics);
	        //Number Of Owner Programmable Digits
	        //Test Case 13935:WebAdmin - NotificationTab - Wakeup - Programmable Digits default and valid values
	        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlNumberOfOwnerProgDigits")));
	        WebElement option = select.getFirstSelectedOption();
			String value = option.getText();
	        /*if(!value.contains("1"))
	        	result += -10;*/ //Handled in a different test
	        List<WebElement> option2 = select.getOptions();
	        value = "";
	        for(WebElement webElement : option2)
	        {
	        	value = value+" "+webElement.getText();
	        }
			//value = option2.;
			if(!value.contains(" 0 1 2 3 4 5 6 7 8 9 10"))
	        	result += -10;
	        //Can only select 0 through 10
			WebDriverLogin.waitT(wd, 1500);
			result += runCheckBox(wd, false);
			WebDriverLogin.waitT(wd, 1500);
			
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxBtnNotifService_Submit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLblNotifServiceStatus")).getText().toLowerCase().contains("updated"))
	    		result += -1000;
			//
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxBtnWakeUpSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxLblWakeUpStatus")).getText().toLowerCase().contains("changes accepted"))
	    		result += -2000;
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        //
	        //Test Case 20461:Validate that only valid string can be used for "Wakeup Notification" fields.
	        WebDriverLogin.searchBoxRange(wd, "900006", "900006", 1500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElementByLinkText("Notifications").click();
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationOne")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbWakeUp")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtDialingString")).getAttribute("value").contains("@"))
	        	result += -10;
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtDigitsDialedAfterConection")).getAttribute("value").contains("#"))
	        	result += -10;
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtOwnerProgNumber")).getAttribute("value").contains("#"))
	        	result += -10;
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtNumberOfAttempts")).getAttribute("value").contains("99"))
	        	result += -10;
	        result += runCheckBox(wd, true);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
	        WebDriverLogin.waitT(wd, 2000);
		}
	    catch (Exception ex)
	    {
	    	result+=-109;
	    }
		
        wd.quit();
        System.exit(result);
	}
	
	public static int runCheckBox(ChromeDriver wd, boolean state)
	{
		int result = 0;
		//
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkNotifControlService", state);
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkWakeupControlService", state);
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled", state);
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxChkSunday", !state);
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxChkMonday", !state);
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxChkTuesday", !state);
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxChkWednesday", !state);
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxChkThursday", !state);
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxChkFriday", !state);
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxChkSaturday", !state);
		//Time blocks WebDriverLogin.waitT(wd, 1000);
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlNumberOfOwnerProgDigits", "5", state);
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlStartTimeHour", "5", state);
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlStartTimeMinute", "12", state);
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlDelayHour", "15", state);
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlDelayMinute", "16", state);
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlEndTimeHour", "6", state);
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlEndTimeMinute", "13", state);
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlRetryHour", "15", state);
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlRetryMinute", "16", state);
		
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlStartTimeAmPm", "P", state);
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlEndTimeAmPm", "P", state);
		//
		return result;
	}
	
	public static int selectElement(ChromeDriver wd, String eID, String numeric, boolean state)
	{
		int result = 0;
		// 
		WebDriverLogin.waitT(wd, 200);
		Select select = new Select(wd.findElement(By.id(eID)));
        WebElement option = select.getFirstSelectedOption();
		String value = option.getText();
        if(!value.contains(numeric) && state == true)
        {
        	result += -10;
        	System.out.println(eID);
        }
        else if(!value.contains(numeric) && state == false)
        	wd.findElement(By.id(eID)).sendKeys(numeric);
		WebDriverLogin.waitT(wd, 200);
		//
		return result;
	}
	
	public static int checkBox(ChromeDriver wd, String id, boolean state)
	{
		int result = 0;
		// 
		WebDriverLogin.waitT(wd, 200);
		if(!wd.findElement(By.id(id)).isSelected() && state == true || wd.findElement(By.id(id)).isSelected() && state == false)
			result += -10;
		else if(!wd.findElement(By.id(id)).isSelected() && state == false || wd.findElement(By.id(id)).isSelected() && state == true)
			wd.findElement(By.id(id)).click();
		WebDriverLogin.waitT(wd, 200);
		//
		return result;
	}
	
	public static int checkField(ChromeDriver wd, String id, String errorId, String errorNotice, String[] validDigits)
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
				WebDriverLogin.waitT(wd, 25);
				checkData = wd.findElement(By.id(errorId)).getText().toLowerCase();
				if(checkData.contains(errorNotice))
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
	
	