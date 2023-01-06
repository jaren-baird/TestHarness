
package Octel;
import login.WebDriverLogin;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class T14923_Octel_PlayMsgOptions 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//Octel_T14923_PlayMsgOptions-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String box = "865069";
		//default options
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.searchBoxRange(wd, box, box, 1500);
			WebDriverLogin.resetMessages(wd, box, box);
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
	    	String[] folderList = {"DList", "TestSuite", "TUI", "OctelTS", "Leave_3_messages"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
			//
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 190000);
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
	    	String[] folderList = {"DList", "TestSuite", "TUI", "OctelTS", "Octel_T14923_PlayMsgOptions"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
			//
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 265000);
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
		    WebDriverLogin.searchBoxRange(wd, box, box, 2500);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbStatus")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_New_Value")).getText().contains("1"))
	        	result += -10;
        	if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_Saved_Value")).getText().contains("1"))
        		result += -10;
    		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_Deleted_Value")).getText().contains("1"))
    			result += -10;
	        WebDriverLogin.waitT(wd, 1000);
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

