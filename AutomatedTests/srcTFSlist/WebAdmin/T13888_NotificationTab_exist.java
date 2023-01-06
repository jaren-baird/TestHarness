
package WebAdmin;

import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T13888_NotificationTab_exist
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13888_NotificationTab_exist-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String value = "";
		//
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			if(checkNotifTab(wd, "900000", "Voicemail") != 0)
				result += fail();
			if(checkNotifTab(wd, "900001", "Audiotext") != -1)
				result += fail();
			if(checkNotifTab(wd, "900002", "UCD") != -1)
				result += fail();
			if(checkNotifTab(wd, "900003", "Fax Only") != 0)
				result += fail();
			if(checkNotifTab(wd, "900004", "Teacher Box") != 0)
				result += fail();
			
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
	
	public static int checkNotifTab(ChromeDriver wd, String boxNum, String boxType) throws InterruptedException
	{
		wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); //expecting exceptions, reduced timeout is efficient
		
		String value = "";
		int result = 0;
		
		WebDriverLogin.searchBoxRange(wd, boxNum, boxNum, 1500);
		value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbType")).getText();
		if(!value.contains(boxType))
			result += -10;
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
        WebDriverLogin.waitT(wd, 2500);
        try
        {
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_tab")).click();
        }
        catch (Exception ex)
        {
        	result += -1;
        }
        /*value = wd.findElement(By.tagName("html")).getText();
        if(!value.contains("Notifications"))
        	result += -1;*/
        
        //
        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
        WebDriverLogin.waitT(wd, 2500);

		
		return result;
	}
	
	public static int fail()
	{
		return -10;
	}
}
	
	