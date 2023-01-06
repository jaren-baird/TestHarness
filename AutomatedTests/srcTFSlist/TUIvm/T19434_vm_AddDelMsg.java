
package TUIvm;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T19434_vm_AddDelMsg
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T19434_vm_AddDelMsg-t0
	//Test Case 19434:TUI - Try deleting your new message
	//Test Case 19435:TUI - Try adding to your new message
	//Test Case 19436:TUI - Access message addressing options
	
	public static void main(String[] args) throws Exception
	{
	    int result = 0;
	    
	    try
    	{
	    	wd = WebDriverLogin.getWebAdmin();
    		WebDriverLogin.resetMessages(wd, "900005", "900006");
    		WebDriverLogin.resetCallOptions(wd, "900005", "900006");
    		WebDriverLogin.searchBoxRange(wd, "900006", "900006");
	  	   	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbStatus")).click();
	  	   	WebDriverLogin.waitT(wd, 1500);
	  	   	String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_New_Value")).getText();//getAttribute("value");
	  	   	if(value == null)
	  	   	{
	  	   		result = -9999;
	  	   	}
	  	   	else if(!value.contains("0"))  //no messages in mailbox
		  	{
	    		result += -10;
	    		System.out.println("reset failed");
	    	}
		  	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxStatusClose")).click();
		  	WebDriverLogin.waitT(wd, 2500);
		  	//
		  	WebDriverLogin.searchBoxRange(wd, "900005", "900005");
		  	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
    		WebDriverLogin.waitT(wd, 2000);
            wd.findElement(By.linkText("Messages")).click();
            WebDriverLogin.waitT(wd, 1000);
            if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsMsgEditing")).isSelected()) {
                wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsMsgEditing")).click();
            }
            WebDriverLogin.waitT(wd, 500);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Submit")).click();
            WebDriverLogin.waitT(wd, 1500);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Close")).click();
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
		
  	   	//
  	   	//
	    try
		{
	    	String[] folderList = {"DList", "TestSuite", "TUI", "TUIvm", "T19434_vm_AddToMsg"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
			if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
				System.out.println("");
			}
			//
			wd.findElement(By.id("executeButton")).click();
			WebDriverLogin.waitT(wd, 140000);
			String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
		   	//
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
	    	String[] folderList = {"DList", "TestSuite", "TUI", "TUIvm", "T19435_vm_ListenMsg"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
			if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
				System.out.println("");
			}
			//
			wd.findElement(By.id("executeButton")).click();
			WebDriverLogin.waitT(wd, 100000);
			String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
		   	//
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
	    	String[] folderList = {"DList", "TestSuite", "TUI", "TUIvm", "T19434_vm_DeleteMsg"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
			if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
				System.out.println("");
			}
			//
			wd.findElement(By.id("executeButton")).click();
			WebDriverLogin.waitT(wd, 80000);
			String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
		   	//
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
			WebDriverLogin.searchBoxRange(wd, "900005", "900005");
	  	   	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbStatus")).click();
	  	   	WebDriverLogin.waitT(wd, 1500);
	  	   	String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_New_Value")).getText();//getAttribute("value");
	  	   	if(value == null)
	  	   	{
	  	   		result = -9999;
	  	   	}
	  	   	else if(!value.contains("0"))
		  	{
	    		result += -10;
	    		System.out.println("delete failed");
	    	}
	  	   	value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_Deleted_Value")).getText();//getAttribute("value");
	  	   	if(value == null)
	  	   	{
	  	   		result = -9999;
	  	   	}
	  	   	else if(!value.contains("1"))
		  	{
	    		result += -10;
	    		System.out.println("delete failed");
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
		
		System.exit(result);
	}
}
