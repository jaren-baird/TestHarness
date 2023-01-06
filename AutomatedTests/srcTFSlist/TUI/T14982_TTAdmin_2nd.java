
package TUI;

import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;


public class T14982_TTAdmin_2nd
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14982_TTAdmin_2nd-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String url = "";
		
		try
		{
			//remove urgent delivery box 900005 The Viper
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetBoxAll(wd, "899990", "899990");
			WebDriverLogin.searchBoxRange(wd, "900005", "900005");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.linkText("Messages")).click();
			WebDriverLogin.waitT(wd, 2500);
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg")).isSelected())
			{
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg")).click();
			    WebDriverLogin.waitT(wd, 500);
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Submit")).click();
			    WebDriverLogin.waitT(wd, 4000);
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
			String[] folderList = {"DList", "TestSuite", "Teacher", "T18728_setup"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 180000);
	        String[] para = {"0","true"};
	        if(WebDriverLogin.RunErrorTable(wd, para) != 0) 
	        	System.out.println("Error in T18728_setup");
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
        //run 14982-84-88-90-91-92-93
		try
		{
	  		String[] folderList = {"DList", "TestSuite", "TUI", "2", "T14982_TTAdmin_2nd"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	  		if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	  			System.out.println("");
	  		}
	  		wd.findElement(By.id("executeButton")).click();
	  		WebDriverLogin.waitT(wd, 155000);
	  		String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
	  			
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
	