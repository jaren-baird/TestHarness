
package WebAdmin;

import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class T13901_Notif_TestFieldsValid
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13901_Notif_TestFieldsValid-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		wd = WebDriverLogin.getWebAdmin();
		
		try
		{
			WebDriverLogin.resetNotifications(wd, "900006", "900006");
			WebDriverLogin.searchBoxRange(wd, "900006", "900006", 3500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElementByLinkText("Notifications").click();
	        WebDriverLogin.waitT(wd, 2500);
	        //
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkNotifControlService")).isSelected()) 
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkNotifControlService")).click();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationOne")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).click();
	        //
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbTelephone")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        String id = "";
	        String errorId = "";
	        String errorNotice = "";
	        String[] validDigits = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","A","B","C","D","*","#","@"};
	        String[] validNumerics = {"1","10","50","99"};
	        //Dialing String
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_DialingString";
	        errorId = "TPRegExValMaxDispaly";
	        errorNotice = "Valid digits only (0-9ABCD*#@).";
	        result += checkField(wd, id, errorId, errorNotice, validDigits);
	        //Digits Dialed After Connection
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_DigitsDialedAfterConnection";
	        errorId = "TPRegularExpressionValidator1";
	        errorNotice = "Valid digits only (0-9ABCD*#@).";
	        result += checkField(wd, id, errorId, errorNotice, validDigits);
	        //Owner Programmable Number
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_OwnerProgrammableNumber";
	        errorId = "TPvalidatorOPN";
	        errorNotice = "Invalid Characters Entered.";
	        result += checkField(wd, id, errorId, errorNotice, validNumerics);
	        //Number of messages (1-99)
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_NumOfMsgs";
	        errorId = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_TPRangeValidator2";
	        errorNotice = "Values 1 - 99";
	        result += checkField(wd, id, errorId, errorNotice, validNumerics);
	        //Number of Attempts (1-99)
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_NumOfAttempts";
	        errorId = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_TPRangeValidator1";
	        errorNotice = "Values 1 - 99";
	        result += checkField(wd, id, errorId, errorNotice, validNumerics);
	        //
	        //
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxBtnTelephonePagerSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxLblTelephonePagerStatus")).getText().toLowerCase().contains("changes accepted"))
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
	
	public static int checkField(ChromeDriver wd, String id, String errorId, String errorNotice, String[] validDigits)
	{
		int result = 0;
		String checkData = "";
		try
		{
			for(int i = 0; i < validDigits.length; i++)
			{
				wd.findElement(By.id(id)).clear();
				wd.findElement(By.id(id)).sendKeys(validDigits[i]);
				wd.findElement(By.id(id)).sendKeys(Keys.ENTER);
				WebDriverLogin.waitT(wd, 25);
				checkData = wd.findElement(By.id(errorId)).getText();
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
	
	