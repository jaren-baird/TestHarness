
package WebAdmin;

import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class T20749_CreateNewTSS
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T20749_CreateNewTSS-t0
	//Test Case 20749:WebAdmin - Validate the ability to create a new Telephony Server using "new TS Server" options
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//New TS Server
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			//System Parameters
			Actions builder = new Actions(wd);
			wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	        try
	        {
	        	//if webadmintest does not exist
	        	try
	        	{
		        	//modify TS Server
		        	builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'Ts Servers')]"))).perform();
		        	WebDriverLogin.waitT(wd, 200);
			        wd.findElement(By.linkText("WEBADMINTEST")).click();
			        WebDriverLogin.waitT(wd, 2000);
			        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtMachineName")).clear();//WEBADMINTEST
			        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtMachineName")).sendKeys("saveModifiedName");
			        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtDescription")).clear();//Cyara Automation
			        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtDescription")).sendKeys("saveModifiedDescription");
			        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtAdminEmail")).clear();//TestEmail@callware.com
			        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtAdminEmail")).sendKeys("saveModified@callware.com");
			        if(wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkPhoneControl")).isSelected())
			        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkPhoneControl")).click();
			        if(!wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkBroadcastEnabled")).isSelected())
			        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkBroadcastEnabled")).click();
			        if(!wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkBroadcastVoice")).isSelected())
			        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkBroadcastVoice")).click();
			        if(!wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkBroadcastFax")).isSelected())
			        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkBroadcastFax")).click();
			        if(!wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkLinkMngr")).isSelected())
			        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkLinkMngr")).click();
			        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxBtnTsServerSubmit")).click();
			        WebDriverLogin.waitT(wd, 2500);
			        //
			        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
			        WebDriverLogin.waitT(wd, 2000);
	        	}
	        	catch(Exception ez)
	        	{
	        		result += -1090;
	        	}
	        	//if saveModifiedName didn't save
	        	try
	        	{
	        		builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'Ts Servers')]"))).perform();
		        	WebDriverLogin.waitT(wd, 200);
			        wd.findElement(By.linkText("saveModifiedName")).click();
			        WebDriverLogin.waitT(wd, 2000);
			        String value = wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtMachineName")).getAttribute("value");
			        if(value.contains("saveModifiedName"))
			        {
				        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtMachineName")).clear();//saveModifiedName
				        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtMachineName")).sendKeys("WEBADMINTEST");
			        }
			        else
			        	result += fail();
			        value = wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtDescription")).getAttribute("value");
			        if(value.contains("saveModifiedDescription"))
			        {
				        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtDescription")).clear();//saveModifiedDescription
				        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtDescription")).sendKeys("Cyara Automation");
			        }
			        else
			        	result += fail();
			        value = wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtAdminEmail")).getAttribute("value");
			        if(value.contains("saveModified@callware.com"))
			        {
				        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtAdminEmail")).clear();//saveModified@callware.com
				        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtAdminEmail")).sendKeys("TestEmail@callware.com");
			        }
			        else
			        	result += fail();
			        //
			        if(!wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkPhoneControl")).isSelected())
			        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkPhoneControl")).click();
			        else
			        	result += fail();
			        if(wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkBroadcastEnabled")).isSelected())
			        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkBroadcastEnabled")).click();
			        else
			        	result += fail();
			        if(wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkBroadcastVoice")).isSelected())
			        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkBroadcastVoice")).click();
			        else
			        	result += fail();
			        if(wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkBroadcastFax")).isSelected())
			        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkBroadcastFax")).click();
			        else
			        	result += fail();
			        if(wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkLinkMngr")).isSelected())
			        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkLinkMngr")).click();
			        else
			        	result += fail();
			        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxBtnTsServerSubmit")).click();
			        WebDriverLogin.waitT(wd, 2500);
			        //
	        	}
		        catch(Exception ez)
		        {
		        	result += -1090;
		        }
			        
		        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
		        
		        WebDriverLogin.waitT(wd, 1000);
		        
	        }
	        catch(Exception ez)
	        {
	        	ez.printStackTrace();
	        	result += -109;
	        }
	        
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
	
	public static int fail()
	{
		return -10;
	}
}
	
	