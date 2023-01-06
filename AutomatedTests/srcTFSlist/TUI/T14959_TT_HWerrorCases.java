
package TUI;

import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class T14959_TT_HWerrorCases
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14959_TT_HWerrorCases-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			result += WebDriverLogin.resetBoxAll(wd, "899990", "899990");
			WebDriverLogin.searchBoxRange(wd, "899990", "899990", 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2500);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLifetime")).sendKeys("0");
		    WebDriverLogin.waitT(wd, 1500);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
		    WebDriverLogin.waitT(wd, 4000);
			    
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
		//setup 899990 error cases misc.
		try
		{
			String[] folderList = {"DList", "TestSuite", "TUI", "T14959_TT_HWErrorCases"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run"))  {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 440000);
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
        
        System.exit(result);
	}
}
	