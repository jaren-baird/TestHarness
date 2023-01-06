
import login.WebDriverLogin;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

public class Test_RCTP_on
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	
	public static void main(String[] args) throws Exception
	{
		int result = 0;
		try
		{
			String[] folderList = {"Owner Services", "RCTP", "VM_RCTP_on"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 32000);
	        String[] para = {"2", "false"};
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
			String[] folderList = {"Owner Services", "RCTP", "VM_RCTP_DTB_on"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 30000);
	        String[] para = {"2", "false"};
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
		//webadmin DTB
		try
    	{
    		wd = WebDriverLogin.getWebAdmin();
            WebDriverLogin.searchBoxRange(wd, "1000", "1000");
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
            WebDriverLogin.waitT(wd, 2000);
            wd.findElement(By.linkText("Call Options")).click();
            WebDriverLogin.waitT(wd, 1500);
            if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).isSelected()) {
                wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).click();
            }
            WebDriverLogin.waitT(wd, 500);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOSubmit")).click();
            WebDriverLogin.waitT(wd, 3000);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOClose")).click();
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
		
		/*
		String url = "";
		String ip = "";
		String testName = "VM_RCTP_on";
		
        for (int i = 0; i < 2; i++)
        {
	        wd.findElement(By.linkText("Test Cases")).click();
	        wd.findElement(By.cssSelector("a[title=\"Test Cases & Blocks\"]")).click();
	        if(!wd.findElement(By.tagName("html")).getText().contains("Cyara Testing")) {
	            System.out.println("");
	        }
	        if(!wd.findElement(By.tagName("html")).getText().contains("Owner Services")) {
	        	wd.findElement(By.linkText("Cyara Testing")).click();
	        }
	        if(!wd.findElement(By.tagName("html")).getText().contains("RCTP")) {
	        	wd.findElement(By.linkText("Owner Services")).click();
	        }
	        wd.findElement(By.linkText("RCTP")).click();
	        wd.findElement(By.linkText(testName)).click();
	        if(!wd.findElement(By.tagName("html")).getText().contains("Associated Steps")) {
	            System.out.println(" ");
	        }
	        if(!wd.findElement(By.tagName("html")).getText().contains("Insert Block")) {
	            System.out.println(" ");
	        }
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println(" ");
	        }
	        if(!(wd.findElements(By.cssSelector("span.brand")).size() != 0)) {
	            System.out.println(" ");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 18000);
	        
	        if(result != Exception && i == 0)
	        {
	     	   url = wd.getCurrentUrl();
	     	   RunJar(url, "2", "false");
	     	   if(result != 0)
	     	   {
	     		   result -= 10;
	     		   break;
	     	   }
	     	   testName = "VM_RCTP_DTB_on";
	        }
	        else if(result == 0 && i == 1)
	        {
	        	url = wd.getCurrentUrl();
	        	RunJar(url, "2", "false");
	        }
        }
        
        wd.quit();*/
        System.exit(result);
	}
}