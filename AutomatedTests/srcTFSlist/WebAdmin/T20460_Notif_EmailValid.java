
package WebAdmin;

import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T20460_Notif_EmailValid
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T20460_Notif_EmailValid-t0
	//Test Case 20460:Validate all checkbox in the Email Notification can be selected and saved
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		
		
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetNotifications(wd, "900006", "900006");
			WebDriverLogin.searchBoxRange(wd, "900006", "900006", 1500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElementByLinkText("Notifications").click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationOne")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbEmail")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        //
			result += runInvalidDigits(wd);
			result += runValidDigits(wd);
			result += runCheckBox(wd, false);
			//
			WebDriverLogin.waitT(wd, 1000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxBtnEmailSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxLblEmailStatus")).getText().toLowerCase().contains("changes accepted"))
	    		result += -2000;
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxBtnNotifService_Submit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLblNotifServiceStatus")).getText().toLowerCase().contains("updated"))
	    		result += -2000;
	        //close
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        //
	        WebDriverLogin.searchBoxRange(wd, "900006", "900006", 1500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElementByLinkText("Notifications").click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationOne")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbEmail")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        result += runCheckBox(wd, true);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
	        WebDriverLogin.waitT(wd, 3000);
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
	
	public static int runCheckBox(ChromeDriver wd, boolean state)
	{
		int result = 0;
		//
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkNotifControlService", state);
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkWakeupControlService", state);
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled", state);
		//days
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxChkSunday", !state);
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxChkMonday", !state);
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxChkTuesday", !state);
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxChkWednesday", !state);
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxChkThursday", !state);
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxChkFriday", !state);
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxChkSaturday", !state);
		//check boxes
		result += checkBox(wd, "uxChkEmail_OmitForUrgent", !state);
		//
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxChkSendEmailSystemAccount", state);
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxChkIgnoreDistMessges", state);
		result += checkBox(wd, "uxChkAttachMessageEmail", state);
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxChkAddWebUrlEmail", state);
		result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxChkQueueStartEndTime", state);
		//
		WebDriverLogin.waitT(wd, 1000);
		//Time blocks 
		result += selectElementString(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxDdlNotificationOptions", "v", state, "Voice Message");
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxDdlStartTimeHour", "5", state);
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxDdlStartTimeMinute", "12", state);
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxDdlEndTimeHour", "6", state);
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxDdlEndTimeMinute", "13", state);
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxDdlDelayHour", "15", state);
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxDdlDelayMinute", "16", state);
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxDdlRetryHour", "15", state);
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxDdlRetryMinute", "16", state);
		
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxDdlStartTimeAmPm", "P", state);
		result += selectElement(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxDdlEndTimeAmPm", "P", state);
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
	
	public static int selectElementString(ChromeDriver wd, String eID, String numeric, boolean state, String selectedValue)
	{
		int result = 0;
		// 
		WebDriverLogin.waitT(wd, 200);
		Select select = new Select(wd.findElement(By.id(eID)));
        WebElement option = select.getFirstSelectedOption();
		String value = option.getText();
        if(!value.contains(selectedValue) && state == true)
        {
        	result += -10;
        	System.out.println(eID);
        }
        else if(!value.contains(selectedValue) && state == false)
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
	
	public static int checkField(ChromeDriver wd, String id, String errorId, String errorNotice, String[] validDigits, boolean state)
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
				if(checkData.contains(errorNotice) && state == true || !checkData.contains(errorNotice) && state == false)
					result += -10; //true for valid data, false for invalid data
			}
		}
		catch(Exception ex)
		{
			result += -10;
		}
		
		return result;
	}
	
	public static int runValidDigits(ChromeDriver wd)
	{
		int result = 0;
		
		try
		{
	        String id = "";
	        String errorId = "";
	        String errorNotice = "";
	        String[] validNumerics = {"1","10","50","99"};
	        String[] validEmail = {"TestEmail@callware.com"};
	        
        	//Email Address
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxTxtEmailAddress";
	        errorId = "RegularExpressionValidatorEA";
	        errorNotice = "Enter a Valid Email Address.";
	        result += checkField(wd, id, errorId, errorNotice, validEmail, true); //true for valid, false for invalid data
	        //Number Of Messages  validNumerics
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxTxtNumberOfMessages";
	        errorId = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_EMRangeValidator1";
	        errorNotice = "Values 1 - 99";
	        result += checkField(wd, id, errorId, errorNotice, validNumerics, true);
	        //Number Of Attempts  validNumerics
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxTxtNumberOfAttempts";
	        errorId = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_EMRangeValidator2";
	        errorNotice = "Values 1 - 99";
	        result += checkField(wd, id, errorId, errorNotice, validNumerics, true);
			//
		}
		catch(Exception ex)
		{
			result += -109;
		}
		
		return result;
	}
	
	public static int runInvalidDigits(ChromeDriver wd)
	{
		int result = 0;
		
		try
		{
	        String id = "";
	        String errorId = "";
	        String errorNotice = "";
	        String[] invalidDigits = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","!","$","%","^","&","(",")","A","B","C","D","*","#","@"};
	        String[] invalidString = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","!","$","%","^","&","(",")","A","B","C","D","*","#","@"};
	        String[] invalidNumerics = {"0","100","999","2345"};
	        String[] invalidZero = {"0"};
	        
        	//Email Address
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxTxtEmailAddress";
	        errorId = "RegularExpressionValidatorEA";
	        errorNotice = "Enter a Valid Email Address.";
	        result += checkField(wd, id, errorId, errorNotice, invalidDigits, false);
	        //Number Of Messages  invalidString
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxTxtNumberOfMessages";
	        errorId = "EmailRegularExpressionValidator3";
	        errorNotice = "Numeric Values Only.";
	        result += checkField(wd, id, errorId, errorNotice, invalidString, false);
	        //Number Of Messages  invalidNumerics
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxTxtNumberOfMessages";
	        errorId = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_EMRangeValidator1";
	        errorNotice = "Values 1 - 99";
	        result += checkField(wd, id, errorId, errorNotice, invalidNumerics, false);
	        //Number Of Attempts  invalidString
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxTxtNumberOfAttempts";
	        errorId = "EmailRegularExpressionValidator1";
	        errorNotice = "Numeric Values Only.";
	        result += checkField(wd, id, errorId, errorNotice, invalidString, false);
	        //Number Of Attempts  invalidNumerics
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxTxtNumberOfAttempts";
	        errorId = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_EMRangeValidator2";
	        errorNotice = "Values 1 - 99";
	        result += checkField(wd, id, errorId, errorNotice, invalidZero, false);
			
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxBtnNotifService_Submit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLblNotifServiceStatus")).getText().toLowerCase().contains("updated"))
	    		result += -1000;
			//
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxBtnEmailSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxLblEmailStatus")).getText().toLowerCase().contains("changes accepted"))
	    		result += -2000;
		}
		catch(Exception ex)
		{
			result += -109;
		}
		
		return result;
	}
}
	
	