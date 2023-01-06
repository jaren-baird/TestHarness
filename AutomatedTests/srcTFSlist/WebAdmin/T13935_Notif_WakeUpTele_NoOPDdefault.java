
package WebAdmin;

import java.util.List;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T13935_Notif_WakeUpTele_NoOPDdefault
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13935_Notif_WakeUpTele_NoOPDdefault-t0
	
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
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationOne")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbWakeUp")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        //Number Of Owner Programmable Digits
	        //Test Case 13935:WebAdmin - NotificationTab - Wakeup - Programmable Digits default and valid values
	        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlNumberOfOwnerProgDigits")));
	        WebElement option = select.getFirstSelectedOption(); //drop down menus make it impossible to enter invalid values
			String value = option.getText();
	        if(!value.contains("1")) //default has changed from 0 to 1 for some reason?
	        	result += fail();
	        //
	        List<WebElement> option2 = select.getOptions();
	        value = "";
	        for(WebElement webElement : option2)
	        {
	        	value = value+" "+webElement.getText();
	        }
			if(!value.contains(" 0 1 2 3 4 5 6 7 8 9 10"))
	        	result += fail();
			option2.clear();
	        //
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbTelephone")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxDdlTelePager_OwnerProgDigits")));
	        option = select.getFirstSelectedOption();
			value = option.getText();
	        if(!value.contains("1"))
	        	result += fail();
	        //
	        option2 = select.getOptions();
	        value = "";
	        for(WebElement webElement : option2)
	        {
	        	value = value+" "+webElement.getText();
	        }
			if(!value.contains(" 0 1 2 3 4 5 6 7 8 9 10"))
	        	result += fail();
			option2.clear();
	        //
	        WebDriverLogin.waitT(wd, 2000);
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
	
	public static int fail()
	{
		return -10;
	}
}
	
	