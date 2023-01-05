
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class findMWInum
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static FirefoxDriver wd = null;
	//private static String FilePath = WebDriverLogin.getFilePath();
	//T18485_Create_a_DList-t0
	/*
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
		result = 0;
        //
        
		result += checkBox(wd, "1007");
		result += checkBox(wd, "1008");
		result += checkBox(wd, "1009");
		result += checkBox(wd, "900005");
        
		wd.quit();
		System.exit(result);
	}
	
	public static int runFindMWInum() throws InterruptedException
	{
		wd = WebDriverLogin.getWebAdmin();
		int boxNum = 0;
		result = 0;
        //
        
		boxNum = checkBox(wd, "1007");
		if(boxNum != 0)
		{
			result += -1007;
			boxNum = 0;
		}
		boxNum = checkBox(wd, "1008");
		if(boxNum != 0)
		{
			result += -1008;
			boxNum = 0;
		}
		boxNum = checkBox(wd, "1009");
		if(boxNum != 0)
		{
			result += -1009;
			boxNum = 0;
		}
		boxNum = checkBox(wd, "900005");
		if(boxNum != 0)
		{
			result += -900000;
			boxNum = 0;
		}
        
		if(wd != null)
			wd.quit();
		
		return result;
	}
	
	public static int checkBox(FirefoxDriver wd, String num) throws InterruptedException
	{
		int result = 0;
		
		try
		{
			WebDriverLogin.searchBoxRange(wd, num, num);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			Thread.sleep(2500);
			String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Mwi")).getAttribute("value");
			
		    Thread.sleep(500);
		    
		    if(value.length() > 1)
		    {
		    	//System.out.println(value);
		    	result = -900005;
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Mwi")).clear();
		    	Thread.sleep(250);
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
		    	Thread.sleep(4000);
		    }
		    
		    wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
		    Thread.sleep(1500);
		}
	    catch (Exception ex)
	    {
	    	result += -9999;
	    }
		return result;
	}*/
}
