package Removed;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import login.SeanWebDriver;
import login.WebDriverLogin;


public class T13450_CallegraWeb_Login 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//Test Case 13450:WEB - Login to CallegraWeb with each box type (voicemail, fax only)
	//T13450_CallegraWeb_Login-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		try
		{
			
			String box = "1007";
			String boxPass = "4321";
			//Login voicemail
			wd = SeanWebDriver.getCallWeb(box, boxPass);
			wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			String value = wd.findElementByTagName("html").getText();
			if(!value.contains("Box Number: 1007"))
				result += -10;
			wd.findElement(By.id("ctl00_uxPlaceHolderSubHeader_uxLbLogOut")).click();
			wd.quit();
		    //Login Fax only
			
			String boxfax = "900003";
			String boxfaxPass = "4321";
			wd = SeanWebDriver.getCallWeb(boxfax, boxfaxPass);
			if(!value.contains("Box Number: 900003"))
				result += -10;
			wd.findElement(By.id("ctl00_uxPlaceHolderSubHeader_uxLbLogOut")).click();
			//wd.findElement(By.id("ctl00_uxPlaceHolderSubHeader_uxHl_OnlineHelp")).click();
		    //
		    
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


