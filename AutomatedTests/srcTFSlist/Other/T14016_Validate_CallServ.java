
package Other;
import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T14016_Validate_CallServ
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14016_Validate_CallServ-t0
	//Test Case 14016:WebAdmin - Validate that all options in "Caller Services" can be selected and save after clicking "Submit" button.
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetMessages(wd, "900005", "900005");
			WebDriverLogin.searchBoxRange(wd, "900005", "900005");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_tab")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsRemovePrompt", false);
	        result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsMsgEditing", false);
	        result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg", false);
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Submit")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Close")).click();
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
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.searchBoxRange(wd, "900005", "900005");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_tab")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsRemovePrompt", true);
	        result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsMsgEditing", true);
	        result += checkBox(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg", true);
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Close")).click();
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
		
	    System.exit(result);
	}
	
	public static int checkBox(ChromeDriver wd, String idField, boolean state)
	{
		int result = 0;
		
		if(wd.findElement(By.id(idField)).isSelected() && state == false || state == true && !wd.findElement(By.id(idField)).isSelected())
        	result += -10;
        else if(state == false)
        	wd.findElement(By.id(idField)).click();
		
		return result;
	}
}
	
	