
package AudioText;
import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class T14896_AT_ChangePass 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14896_AT_ChangePass-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String box = "890990";
		//setup box in case it isn't
		try
    	{
    		
    		wd = WebDriverLogin.getWebAdmin();
    		WebDriverLogin.resetBoxAll(wd, box, box);
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
        	String[] folderList = {"DList", "TestSuite", "Other", "AudioText", "ATbox 890990 initial setup"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 132000);
	        String[] para = {"0","true"};
	        if(WebDriverLogin.RunErrorTable(wd, para) != 0)
	        	System.out.println("ATbox 890990 initial setup :: had errors");
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
		//begin test
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.searchBoxRange(wd, box, box);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpUser_ctl01_uxDdlUser_MinPassLifetime")).sendKeys("0");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpUser_ctl01_uxDdlUser_MinPassLifetime")).sendKeys(Keys.ENTER);
	        WebDriverLogin.waitT(wd, 250);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpUser_ctl01_uxBtnUser_Submit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        
	        wd.findElement(By.linkText("Greetings")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxChkGreetingGrtPassNameEdit")).isSelected())
	        {
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxChkGreetingGrtPassNameEdit")).click();
		        WebDriverLogin.waitT(wd, 250);
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxBtnGreetingsSubmit")).click();
		        WebDriverLogin.waitT(wd, 4000);
		        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
		        	result += -10;   
			}
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxBtnGreetingsClose")).click();
	        WebDriverLogin.waitT(wd, 3000);
	        //
			Actions builder = new Actions(wd);
	        builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'System Parameters')]"))).perform();
	        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbSecuritySettings")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucSecuritySettings_uxTxtMSSMaxPassRetention")).getAttribute("value").contains("0"))
	        {
		        wd.findElement(By.id("ctl00_uxCphContent_ucSecuritySettings_uxTxtMSSMaxPassRetention")).clear();
		        wd.findElement(By.id("ctl00_uxCphContent_ucSecuritySettings_uxTxtMSSMaxPassRetention")).sendKeys("3");
		        wd.findElement(By.id("ctl00_uxCphContent_ucSecuritySettings_uxBtnSecSettings_Submit")).click();
		        WebDriverLogin.waitT(wd, 2000);
		        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
		        	result += -1;
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
        	String[] folderList = {"DList", "TestSuite", "Other", "AudioText", "T14896_ChangePass"};
    		wd = WebDriverLogin.getCyara(args);
    		result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
            WebDriverLogin.waitT(wd, 1000);
            if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
                System.out.println("");
            }
            wd.findElement(By.id("executeButton")).click();
            WebDriverLogin.waitT(wd, 90000);
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
        //
        try
		{
        	String[] folderList = {"DList", "TestSuite", "Other", "AudioText", "T14896_ConfirmPass"};
    		wd = WebDriverLogin.getCyara(args);
    		result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
            WebDriverLogin.waitT(wd, 1500);
            if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
                System.out.println("");
            }
            wd.findElement(By.id("executeButton")).click();
            WebDriverLogin.waitT(wd, 80000);
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
  	   	//re-setup box
        try
    	{
    		
    		wd = WebDriverLogin.getWebAdmin();
    		WebDriverLogin.resetBoxAll(wd, box, box);
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
        	String[] folderList = {"DList", "TestSuite", "Other", "AudioText", "ATbox 890990 initial setup"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 132000);
	        String[] para = {"0","true"};
	        if(WebDriverLogin.RunErrorTable(wd, para) != 0)
	        	System.out.println("ATbox 890990 initial setup :: had errors");
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
