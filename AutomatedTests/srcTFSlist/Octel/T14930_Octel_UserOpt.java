
package Octel;
import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class T14930_Octel_UserOpt 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//Octel_T14930_UserOpt-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String box = "865069";
		
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
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
	    	String[] folderList = {"DList", "TestSuite", "TUI", "OctelTS", "2", "Octel_T14930_UserOpt"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
			//
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 82000);
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
		//
		System.exit(result);
	}
}

