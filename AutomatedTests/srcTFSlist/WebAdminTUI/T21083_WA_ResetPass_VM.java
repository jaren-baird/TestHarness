package WebAdminTUI;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T21083_WA_ResetPass_VM
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//T21083_WA_ResetPass_VM-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String box = "900000";
		
		try
		{
			wd = WebDriverLogin.getWebAdmin();
		    WebDriverLogin.resetBoxAll(wd, box, box);
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
		try
		{
			String[] folderList = {"Voice Rec", "Login", "setupBoxes", "VMbox initial setup 900000"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 210000);
	        String[] para = {"0","true"};
	        if(WebDriverLogin.RunErrorTable(wd, para) != 0)
	        	System.out.println("Error occured in VMbox initial setup 900000");
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
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.searchBoxRange(wd, box, box, 2500);
		    //reset passcode
			if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected())
			    wd.findElement(By.id("uxChkboxsrtpr")).click();
			WebDriverLogin.waitT(wd, 1500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElementByLinkText("Basic").click();
			WebDriverLogin.waitT(wd, 2500);
			if(!wd.findElement(By.id("uxChkResetPasscode")).isSelected())
			    wd.findElement(By.id("uxChkResetPasscode")).click();
			
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
			WebDriverLogin.waitT(wd, 4500);
			if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
			{
				WebDriverLogin.waitT(wd, 12500);
				if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
					result += -10;
			}
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
			WebDriverLogin.waitT(wd, 2000);
			
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
			String[] folderList = {"DList", "TestSuite", "TUI", "TUIother", "T21083_WA_ResetPass_VM"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 85000);
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
