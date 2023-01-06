
package WebAdminCallOptions;

import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T13967_CallOpts_EachBoxType
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13967_CallOpts_EachBoxType-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String url = "";
		wd = WebDriverLogin.getWebAdmin();
		wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverLogin.enableBoxRange(wd, "900000", "900006");
		//Test Case 13961:WebAdmin - GreetingTab - Greet - Greeting\Passcode\Name edit
		try
		{
			if(!checkCallOptionTab(wd, "900000")) //voicemail
				result += -5;
			if(!checkCallOptionTab(wd, "900001")) //AudioText
				result += -10;
			if(checkCallOptionTab(wd, "900002")) //UCD
				result += -20;
			if(checkCallOptionTab(wd, "900003")) //Fax Only
				result += -33;
			if(!checkCallOptionTab(wd, "900004")) //Teacher Box
				result += -40;
			
			wd.quit();
			//
		}
		catch(Exception ex)
		{result += -109;}
		//
		//
		
  	   	System.exit(result);
	}
	
	public static boolean checkCallOptionTab(ChromeDriver wd, String box) throws InterruptedException
	{
		int resultCO = 0;
		boolean hasCallOpt = false;
		try
		{
			WebDriverLogin.searchBoxRange(wd, box, box, 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.linkText("Call Options")).click();
			WebDriverLogin.waitT(wd, 2000);
			String value = wd.findElement(By.tagName("html")).getText().toLowerCase();
			if(!value.contains("call options"))
				resultCO += -10;
			if(!value.contains("services"))
				resultCO += -10;	
		}
		catch(Exception ex)
		{resultCO += -109;}
		
		if(resultCO != 0)
			hasCallOpt = false;
		else 
			hasCallOpt = true;
		wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
		WebDriverLogin.waitT(wd, 2000);
		
		return hasCallOpt;
	}
}