
package Octel;
import login.WebDriverLogin;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class T14924_Octel_UrgentMsg 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//Octel_T14924_UrgentMsg-t0
	//T14925
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String box = "865069";
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetMessages(wd, box, box);
		    WebDriverLogin.searchBoxRange(wd, box, box, 1500);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxChkUser_OctelMenus")).isSelected())
	        {
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxChkUser_OctelMenus")).click();
		    	WebDriverLogin.waitT(wd, 500);
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
		        WebDriverLogin.waitT(wd, 2500);
	        }
	        wd.findElementByLinkText("Messages").click();
	        WebDriverLogin.waitT(wd, 2000);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg")).isSelected())
	        {
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg")).click();
		    	WebDriverLogin.waitT(wd, 500);
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Submit")).click();
		        WebDriverLogin.waitT(wd, 2500);
	        }
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Close")).click();
	        WebDriverLogin.waitT(wd, 2500);
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
		
		try
		{
	    	String[] folderList = {"DList", "TestSuite", "TUI", "OctelTS", "Octel_T14924_UrgentMsg"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
			//
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 165000);
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
		
		try
		{
			wd = WebDriverLogin.getWebAdmin();
		    WebDriverLogin.searchBoxRange(wd, box, box, 1500);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbStatus")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_NewUrgent_Value")).getText();
	        if(!value.contains("1"))
	        {
		    	result += -10;
	        }
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxStatusClose")).click();
	        WebDriverLogin.waitT(wd, 2500);
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
		//
		System.exit(result);
	}
}
