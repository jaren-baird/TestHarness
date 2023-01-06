
package DListTUI;

import java.util.concurrent.TimeUnit;
import login.WebDriverLogin;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class T18521_DList_LeaveMessage46
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T18521_DList_LeaveMessage46-t0
	
	public static void main(String[] args) throws Exception
	{
	    result = 0;
	    try
		{
	    	wd = WebDriverLogin.getWebAdmin();
	    	WebDriverLogin.searchBoxRange(wd, "900005", "900005", 2500);
		    wd.findElement(By.id("uxChkboxsrtpr")).click();
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
		    WebDriverLogin.waitT(wd, 2500);
		    wd.findElement(By.linkText("Messages")).click();
		    WebDriverLogin.waitT(wd, 2000);
		    if(!wd.findElement(By.id("uxChkResetMsgAll")).isSelected()) {
		        wd.findElement(By.id("uxChkResetMsgAll")).click();
		    }
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
		    WebDriverLogin.waitT(wd, 2500);
		    if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) {
		    	result += 10;
		    }
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
	    try
		{
	    	String[] folderList = {"DList", "TestSuite", "DListSetup", "2", "T18521_DList_LeaveMessage46"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
			if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
				System.out.println("");
			}
			//
			wd.findElement(By.id("executeButton")).click();
			WebDriverLogin.waitT(wd, 95000);
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
	    	wd = WebDriverLogin.getWebAdmin();
	  	   	//box 900005
	  	   	WebDriverLogin.searchBoxRange(wd, "900005", "900005", 3500);
	  	   	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbStatus")).click();
	  	   	WebDriverLogin.waitT(wd, 1500);
	  	   	String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_New_Value")).getText();//getAttribute("value");
	  	   	if(value == null)
	  	   	{
	  	   		result = -9999;
	  	   	}
	  	   	else if(value.contains("0"))
		  	{
	    		result += -200;
	    		System.out.println("box 900005 failed");
	    	}
		  	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxStatusClose")).click();
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
  	   	
		System.exit(result);
	}
}
