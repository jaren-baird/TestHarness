
package WebAdmin;

import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class T13900_Notif_InvalidTele
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13900_Notif_InvalidTele-t0
	
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
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkNotifControlService")).isSelected()) 
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkNotifControlService")).click();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationOne")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).click();
	        //
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbTelephone")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        String id = "";
	        String errorId = "";
	        String errorNotice = "";
	        String[] invalidDigits = {"e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","!","$","%","^","&","(",")"};
	        String[] invalidNumerics = {"100","999","1000","9999","0"};
	        //Dialing String
	        //Test Case 13900:WebAdmin - NotificationTab - Enter invalid input for telephone notification
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_DialingString";
	        errorId = "TPRegExValMaxDispaly";
	        errorNotice = "Valid digits only (0-9ABCD*#@).";
	        result += checkField(wd, id, errorId, errorNotice, invalidDigits);
	        //Digits Dialed After Connection
	        //Test Case 13902:WebAdmin - NotificationTab - Enter invalid input for telephone digits dialed field
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_DigitsDialedAfterConnection";
	        errorId = "TPRegularExpressionValidator1";
	        errorNotice = "Valid digits only (0-9ABCD*#@).";
	        result += checkField(wd, id, errorId, errorNotice, invalidDigits);
	        //Owner Programmable Number
	        //Test Case 13904:WebAdmin - NotificationTab - Enter invalid input for telephone Owner Programmable field
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_OwnerProgrammableNumber";
	        errorId = "TPvalidatorOPN";
	        errorNotice = "Invalid Characters Entered.";
	        result += checkField(wd, id, errorId, errorNotice, invalidDigits);
	        //[//Test Case 13904:WebAdmin - NotificationTab - Enter invalid input for telephone Owner Programmable field
	        //Number of messages (numeric values only)
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_NumOfMsgs";
	        errorId = "TPRegularExpressionValidator2";
	        errorNotice = "Numeric Values Only.";
	        result += checkField(wd, id, errorId, errorNotice, invalidDigits);
	        //Number of messages (1-99)
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_NumOfMsgs";
	        errorId = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_TPRangeValidator2";
	        errorNotice = "Values 1 - 99";
	        result += checkField(wd, id, errorId, errorNotice, invalidNumerics);
	        //]
	        //Number of Attempts (numeric values only)
	        //[//Test Case 13910:WebAdmin - NotificationTab - Number of Attempts invalid for telephone
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_NumOfAttempts";
	        errorId = "TPRegularExpressionValidator3";
	        errorNotice = "Numeric Values Only.";
	        result += checkField(wd, id, errorId, errorNotice, invalidDigits);
	        //Number of Attempts (1-99)
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_NumOfAttempts";
	        errorId = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_TPRangeValidator1";
	        errorNotice = "Values 1 - 99";
	        String[] invalidZero = {"0"};
	        result += checkField(wd, id, errorId, errorNotice, invalidZero);
	        //]
	        
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxBtnTelephonePagerSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(wd.findElement(By.tagName("html")).getText().toLowerCase().contains("changes accepted"))
	    		result += -2000;
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        //
		}
	    catch (Exception ex)
	    {
	    	result+=-109;
    	}
		
        wd.quit();
        System.exit(result);
	}
	
	public static int checkField(ChromeDriver wd, String id, String errorId, String errorNotice, String[] invalidDigits)
	{
		int result = 0;
		String checkData = "";
		try
		{
			for(int i = 0; i < invalidDigits.length; i++)
			{
				wd.findElement(By.id(id)).clear();
				wd.findElement(By.id(id)).sendKeys(invalidDigits[i]);
				wd.findElement(By.id(id)).sendKeys(Keys.ENTER);
				WebDriverLogin.waitT(wd, 25);
				checkData = wd.findElement(By.id(errorId)).getText();
				if(!checkData.contains(errorNotice))
					result += -10;
			}
		}
		catch(Exception ex)
		{result += -10;}
		
		return result;
	}
}
	
	