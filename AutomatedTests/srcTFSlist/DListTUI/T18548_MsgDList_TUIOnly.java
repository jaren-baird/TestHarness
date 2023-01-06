
package DListTUI;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T18548_MsgDList_TUIOnly 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T18548_MsgDList_TUIOnly-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String box = "900005";
		for(int i = 0; i < 100; i++)
		{
		System.out.println(i);
		try
		{
			//
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetDListAll(wd, box, box);
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
		//
		try
		{
			String[] folderList = {"DList", "TestSuite", "DListSetup", "2", "T18517_DListSetup_TUI"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 100000);
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
		try
		{
			String[] folderList = {"DList", "TestSuite", "DListSetup", "2", "T18518_DList_LeaveMessage2"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 100000);
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
		try
		{
			wd = WebDriverLogin.getWebAdmin();
		   	WebDriverLogin.searchBoxRange(wd, box, box);
		   	String status = "ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbStatus";
	  	   	wd.findElement(By.id(status)).click();
	  	   	WebDriverLogin.waitT(wd, 1500);
	  	   	String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_New_Value")).getText();//getAttribute("value");
	  	   	if(value == null)
	  	   		result += -9999;
		  	if(value.contains("0"))
	    		result += -10;
		  	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxStatusClose")).click();
		  	WebDriverLogin.waitT(wd, 1500);
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
		if(result < -1000)
			result = 0;
		}
  	   	//
  	   	System.exit(result);
		
	}
}