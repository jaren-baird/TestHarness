
import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Reset_Messages_CallOptions 
{
	private static int result = 0;
	private static int Exception = -109;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//Reset_Messages_CallOptions
	
	public static void main(String[] args) throws Exception
	{
		String box = "1007";
		try
    	{
			wd = WebDriverLogin.getWebAdmin();
			result += WebDriverLogin.resetMessages(wd, box, box);
			result += WebDriverLogin.resetCallOptions(wd, box, box);
			
			WebDriverLogin.searchBoxRange(wd, box, box, 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2500);
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxChkUser_OctelMenus")).isSelected())
			{
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxChkUser_OctelMenus")).click();
				WebDriverLogin.waitT(wd, 1000);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
				WebDriverLogin.waitT(wd, 3000);
			}
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
			WebDriverLogin.waitT(wd, 2500);
    		wd.quit();
    		wd = null;
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    		result += Exception;
    	}
    	finally
    	{
    		if(wd != null)
    			wd.quit();
    	}
        
        
		System.exit(result);
	}
}
