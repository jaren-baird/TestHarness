package Octel;
import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class T14920_SetupOctel 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//Octel_T14920_SetupOctel-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			for(int i = 0; i < 5; i++)
			{
				try
				{
					WebDriverLogin.searchBoxRange(wd, Integer.toString(900000+i), Integer.toString(900000+i), 2500);
					wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
					WebDriverLogin.waitT(wd, 2500);
					if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxChkUser_OctelMenus")).isSelected() || wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxChkUser_OctelMenus")).isSelected())
			        {
				    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxChkUser_OctelMenus")).click();
				        WebDriverLogin.waitT(wd, 2500);
			        }
					if(i != 0 && i < 4)
						result += -10;
				}
				catch(Exception ex)
				{
					if(i == 0 || i == 4)
						result += -10;
				}
				wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
			}
	        
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
		
		String box = "865069";
		
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverLogin.enableBoxRange(wd, "1007", "1008");
			WebDriverLogin.resetBoxAll(wd, box, box);
		    WebDriverLogin.searchBoxRange(wd, box, box, 1500);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxChkUser_OctelMenus")).isSelected())
	        {
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxChkUser_OctelMenus")).click();
		        WebDriverLogin.waitT(wd, 500);
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
		        WebDriverLogin.waitT(wd, 2500);
	        }
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
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
	    
		try
		{
	    	String[] folderList = {"DList", "TestSuite", "TUI", "OctelTS", "A_VMbox initial setup 865069"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
			//
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 200000);
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
			wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverLogin.searchBoxRange(wd, "900000", "900005", 2500);
			if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected())
				wd.findElement(By.id("uxChkboxsrtpr")).click();
			WebDriverLogin.waitT(wd, 500);
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	        WebDriverLogin.waitT(wd, 3500);
	        if(!wd.findElement(By.id("uxChkResetOctel")).isSelected())
				wd.findElement(By.id("uxChkResetOctel")).click();
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        WebDriverLogin.waitT(wd, 3500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
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

