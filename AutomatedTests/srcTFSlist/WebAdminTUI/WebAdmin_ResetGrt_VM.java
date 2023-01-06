package WebAdminTUI;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebAdmin_ResetGrt_VM
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//1WebAdmin_ResetGrt_VM-t0
	//Test Case 13831:Box Reset - Reset a box greeting
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			result += WebDriverLogin.resetBoxAll(wd, "900006", "900006");
		    wd.quit();
		    wd = null;
		    
		}
	    catch (Exception ex)
	    {
	    	
	    }
		finally
		{
			if(wd != null)
				wd.quit();
		}
		
		try
		{
			//setup 900006
	        String[] folderList = {"DList", "TestSuite", "ResetTS", "SetupTS", "VMbox initial setup 900006"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 205000);
	        String[] para = {"0","true"};
	        if(WebDriverLogin.RunErrorTable(wd, para) != 0)
	        	System.out.println("setup had an error in 'VMbox initial setup 900006'");
	  	   	wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += resultException();
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
			WebDriverLogin.searchBoxRange(wd, "900006", "900006", 3000); //WebDriverLogin.resetGreetingTab(wd, "900006", "900006");
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).isSelected()) {
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
			}
			if(!wd.findElement(By.tagName("html")).getText().contains("Reset")) {
			    System.out.println("");
			}
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
			if(!wd.findElement(By.tagName("html")).getText().contains("Reset Boxes")) {
			    System.out.println("");
			}
			WebDriverLogin.waitT(wd, 2000);
			wd.findElement(By.linkText("Greetings")).click();
			WebDriverLogin.waitT(wd, 2000);
			wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt")).click();
			WebDriverLogin.waitT(wd, 2000);
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetGrtGreeting")).isSelected()) {
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetGrtGreeting")).click();
			}
			if(!wd.findElement(By.tagName("html")).getText().contains("Submit")) {
			    System.out.println("");
			}
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
			WebDriverLogin.waitT(wd, 3500);
			if(!wd.findElementByTagName("html").getText().contains("Reset Successful."))
				WebDriverLogin.waitT(wd, 12000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
			WebDriverLogin.waitT(wd, 1500);
    	}
    	catch(Exception ex)
    	{
    		result += resultException();
    		ex.printStackTrace();
    	}
    	finally
    	{
    		if(wd != null)
    			wd.quit();
    	}
        
    	try
		{
			String[] folderList = {"DList", "TestSuite", "ResetTS", "T13831_ListenGrt"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 70000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
 	  	   	wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += resultException();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
        
        System.exit(result);
	}
	
	public static int resultFailure()
	{
		int result = -10;
		return result;
	}
	public static int resultException()
	{
		int result = -109;
		return result;
	}
}
	