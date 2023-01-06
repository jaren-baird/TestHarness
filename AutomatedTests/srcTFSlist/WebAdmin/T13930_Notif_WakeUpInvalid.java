
package WebAdmin;

import java.util.List;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T13930_Notif_WakeUpInvalid
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13930_Notif_WakeUpInvalid-t0
	
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
	        String[] invalidDigits = {"e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","!","$","%","^","&","(",")"};
	        String[] invalidDTMF = {"e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","!","$","%","^","&","(",")","@"};
	        String[] invalidNumerics = {"0","00"};
        	//Dialing String
	        //Test Case 13930:WebAdmin - NotificationTab - Wakeup - Dialing String with invalid digits
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtDialingString";
	        errorId = "WakeRegularExpressionValidator1";
	        errorNotice = "Dial String Values Only.";
	        result += checkField(wd, id, errorId, errorNotice, invalidDigits);
	        //Digits Dialed After Connection
	        //Test Case 13932:WebAdmin - NotificationTab - Wakeup - Digits Dialed After Connection with invalid digits ::DTMF
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtDigitsDialedAfterConection";
	        errorId = "WakeRegularExpressionValidator2";
	        errorNotice = "Dtmf Values Only.";
	        result += checkField(wd, id, errorId, errorNotice, invalidDTMF);
	        //Owner Programmable Number
	        //Test Case 13934:WebAdmin - NotificationTab - Wakeup - Owner Programmable Number with invalid digits ::DTMF
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtOwnerProgNumber";
	        errorId = "WakeRegularExpressionValidator3";
	        errorNotice = "Dtmf Values Only.";
	        result += checkField(wd, id, errorId, errorNotice, invalidDTMF);
	        //Number of Attempts (1-99)
	        //Test Case 13938:WebAdmin - NotificationTab - Wakeup - Number of attempts with invalid digits ::values
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtNumberOfAttempts";
	        errorId = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_EMRangeValidator1";
	        errorNotice = "Values 1 - 99";
	        result += checkField(wd, id, errorId, errorNotice, invalidNumerics);
	        //Number Of Owner Programmable Digits
	        //Test Case 13936:WebAdmin - NotificationTab - Wakeup - Programmable Digits with invalid digits ::selection
	        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlNumberOfOwnerProgDigits")));
	        WebElement option = select.getFirstSelectedOption();
			String value = option.getText();
	        /*if(!value.contains("0"))
	        	result += -10; */		//this happens in a different test 
	        List<WebElement> option2 = select.getOptions();
	        for(WebElement webElement : option2)
	        {
	        	value = value+" "+webElement.getText();
	        }
			//value = option2.;
			if(!value.contains(" 0 1 2 3 4 5 6 7 8 9 10"))
	        	result += -10;
	        //Can only select 0 through 10
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxBtnWakeUpSubmit")).click();
	        WebDriverLogin.waitT(wd, 5000);
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxLblWakeUpStatus")).getText().toLowerCase().contains("changes accepted"))
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
				if(!checkData.contains(errorNotice))
					result += -10;
			}
		}
		catch(Exception ex)
		{result += -10;}
		
		return result;
	}
}
	
	