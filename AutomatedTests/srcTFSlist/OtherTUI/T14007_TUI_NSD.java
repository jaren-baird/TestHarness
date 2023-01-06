
package OtherTUI;
import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class T14007_TUI_NSD
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14007_TUI_NSD-t0
	//Test Case 14007:WebAdmin - Messages - Change Saved Message Retention
	//Test Case 14009:WebAdmin - Messages - Change Deleted Message Retention
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String box = "899998";
		//
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.waitT(wd, 1000);
			WebDriverLogin.enableBoxRange(wd, box, "900005");
			WebDriverLogin.resetMessages(wd, "900005", "900005");
			WebDriverLogin.resetCallOptions(wd, "900005", "900005");
			//WebDriverLogin.clearMWI(wd, box);
			WebDriverLogin.searchBoxRange(wd, box, box);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_tab")).click();
		    WebDriverLogin.waitT(wd, 2000);
	        if(!wd.findElement(By.id("uxTxtMessageParamsNewMsgRetention")).getAttribute("value").contains("1") 
	        		|| !wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsSavedMsgRetention")).getAttribute("value").contains("1")
	        		|| !wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsDeletedMsgRetention")).getAttribute("value").contains("1"))
	        {
	        	wd.findElement(By.id("uxTxtMessageParamsNewMsgRetention")).clear();
			    wd.findElement(By.id("uxTxtMessageParamsNewMsgRetention")).sendKeys("1");
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsSavedMsgRetention")).clear();
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsSavedMsgRetention")).sendKeys("1");
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsDeletedMsgRetention")).clear();
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsDeletedMsgRetention")).sendKeys("1");
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Submit")).click();
			    WebDriverLogin.waitT(wd, 2500);
			    result += -15;
	        }
	        
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
		//leave 3 message
		try
		{
			String[] folderList = {"DList", "TestSuite", "Messaging", "LeaveAMessage", "T14007_LeaveMSG"};
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
	        	System.out.println("Error occured in T14007_LeaveMSG");
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
		//Prepare new, saved, deleted messages
		try
		{
			String[] folderList = {"DList", "TestSuite", "Messaging", "LeaveAMessage", "T14007_NSD_MSG"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 125000);
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
		//check new and deleted messages for less than 3, more implies 1 day retention probable failure
		try
    	{
			wd = WebDriverLogin.getWebAdmin();
    		WebDriverLogin.searchBoxRange(wd, "899998", "899998");
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbStatus")).click();
    		WebDriverLogin.waitT(wd, 2000);
            //
    		String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_New_Value")).getText();
    		int vNum = Integer.parseInt(value);
    		if(vNum > 6 || vNum < 1)
    			result += -10;
    		value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_Saved_Value")).getText();
    		vNum = Integer.parseInt(value);
    		if(vNum > 6 || vNum < 1)
    			result += -10;
    		value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_Deleted_Value")).getText();
    		vNum = Integer.parseInt(value);
    		if(vNum > 6 || vNum < 1)
    			result += -10;
            //
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxStatusClose")).click();
            WebDriverLogin.waitT(wd, 1000);
            
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
	
	