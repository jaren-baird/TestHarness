
package AudioText;
import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T14892_AT_DialExtension 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14892_AT_DialExtension-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String url = "";
		//
		try
  	   	{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetBoxAll(wd, "890990", "890990");
			WebDriverLogin.resetCallOptions(wd, "1007", "1007");
			WebDriverLogin.searchBoxRange(wd, "890990", "890990");
			
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.linkText("Call Options")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtCOAT_OperatorBox")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtCOAT_OperatorBox")).sendKeys("1007");
	        
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
	        	result += -10;
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOClose")).click();
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
        //
		try
		{
	        String[] folderList = {"DList", "TestSuite", "Other", "AudioText", "ATbox 890990 initial setup"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 135000);
	        String[] para = {"0","true"};
	        int temp = WebDriverLogin.RunErrorTable(wd, para);
	        if(temp != 0)
	        {
	        	result += temp;
	        	System.out.println("ATbox 890990 initial setup :: had an error");
	        }
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
  	   		wd = WebDriverLogin.getWebAdmin();
	  	   	WebDriverLogin.searchBoxRange(wd, "1007", "1007");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.linkText("Connectivity")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxChkGlobalFuntionalityGlobalExt")).isSelected())
	        {    
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxChkGlobalFuntionalityGlobalExt")).click();
		        WebDriverLogin.waitT(wd, 1000);
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxBtnConnectivitySubmit")).click();
		        WebDriverLogin.waitT(wd, 4000);
		        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
		        	result += -10;
	        }
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxBtnConnectivityClose")).click();
	        WebDriverLogin.waitT(wd, 3000);
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
  	   		wd = WebDriverLogin.getWebAdmin();
	  	   	WebDriverLogin.searchBoxRange(wd, "1000", "1000");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.linkText("Call Options")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).isSelected())
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).click();
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
	        	result += -10;
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOClose")).click();
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
        //
  	   	try
  	   	{
	        String[] folderList = {"DList", "TestSuite", "Other", "AudioText", "T14892_AT_DialExt"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 50000);
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
  	   	try
	   	{
	  	   	wd = WebDriverLogin.getWebAdmin();
	   		WebDriverLogin.searchBoxRange(wd, "1000", "1000");
	   		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	   		WebDriverLogin.waitT(wd, 2500);
	   		wd.findElement(By.linkText("Call Options")).click();
	   		WebDriverLogin.waitT(wd, 2000);
	   		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).isSelected())
	   			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).click();
	   		WebDriverLogin.waitT(wd, 1000);
	   		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOSubmit")).click();
	   		WebDriverLogin.waitT(wd, 4000);
	   		if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
	   			result += -10;
	   		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOClose")).click();
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
        //
        System.exit(result);
	}
}
