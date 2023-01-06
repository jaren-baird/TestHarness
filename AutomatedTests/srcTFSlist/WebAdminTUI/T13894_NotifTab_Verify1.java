
package WebAdminTUI;

import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T13894_NotifTab_Verify1
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13894_NotifTab_Verify1-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String box = "900005";
		//
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetNotifications(wd, box, box);
			result += WebDriverLogin.createVmNotificationTele(wd, box);
 			result += WebDriverLogin.createVmNotificationEmail(wd, box);
			result += WebDriverLogin.createVmNotificationWakeUp(wd, box);
			result += WebDriverLogin.createVmNotificationEscalation(wd, box);
			WebDriverLogin.searchBoxRange(wd, box, box, 1500);
			WebDriverLogin.waitT(wd, 1000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElementByLinkText("Notifications").click();
	        WebDriverLogin.waitT(wd, 1500);
	        //
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkNotifControlService")).isSelected()) 
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkNotifControlService")).click();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkWakeupControlService")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkWakeupControlService")).click();
	        //

	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxBtnNotifService_Submit")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        if(!wd.findElement(By.tagName("html")).getText().toLowerCase().contains("updated"))
	    		result += -10;
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += -109;
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		
		try
		{
			String[] folderList = {"DList", "TestSuite", "Other", "TSNotification", "T13894_ControlDisabled"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 62000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
	  	   	wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += -109;
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
        
        System.exit(result);
	}
}
	
	