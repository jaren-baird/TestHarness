
package TUI;

import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;


public class T14951_TUI_Teacher_2longPC
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14951_TUI_Teacher_2longPC-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetBoxAll(wd, "899990", "899990");
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
		//
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.searchBoxRange(wd, "899990", "899990");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_ChgPasscode")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("uxTxtPasscode")).clear();
	        wd.findElement(By.id("uxTxtPasscode")).sendKeys("5489");
	        wd.findElement(By.id("uxTxtRetypePasscode")).clear();
	        wd.findElement(By.id("uxTxtRetypePasscode")).sendKeys("5489");
	        WebDriverLogin.waitT(wd, 500);
	        Alert alert;
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnSubmitChangedPasscode")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        try 
		    { 
		    	alert = wd.switchTo().alert();
		        alert.accept();
		    }catch (NoAlertPresentException ex){}
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLifetime")).sendKeys("0");
		    WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
	        {}
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
	        WebDriverLogin.waitT(wd, 1000);
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
	        String[] folderList = {"DList", "TestSuite", "TUI", "T14951_Teacher_2longPass"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
			//
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 155000);
	        String[] para = {"0","true"};
	        int returnedRes = WebDriverLogin.RunErrorTable(wd, para);
	        if(returnedRes != 0)
	        	result += returnedRes;
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
	        //T14955_Teacher_VerifySavePass-t0
	        String[] folderList = {"DList", "TestSuite", "TUI", "T14955_Teacher_VerifySavePass"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
			//
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 42000);
	        String[] para = {"0","true"};
	        int returnedRes = WebDriverLogin.RunErrorTable(wd, para);
	        if(returnedRes != 0)
	        	result += returnedRes;
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
	