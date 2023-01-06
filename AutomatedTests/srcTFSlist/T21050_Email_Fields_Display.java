
import login.WebDriverLogin;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class T21050_Email_Fields_Display
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//T21050_Email_Fields_Display-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String box = "900006";
		
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetBoxAll(wd, box, box);
		    WebDriverLogin.searchBoxRange(wd, box, box, 2000);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElementByLinkText("Notifications").click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationOne")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbEmail")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxTxtEmailAddress")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxTxtEmailAddress")).sendKeys("TestEmail@callware.com");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxTxtEmailAddress")).sendKeys(Keys.ENTER);
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxBtnEmailSubmit")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxTxtEmailAddress")).getAttribute("value");
	        if(!value.contains("TestEmail@callware.com"))
	        	result += fail();
	        //
	        wd.findElementByLinkText("Connectivity").click();
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxTxtEmailSettingsEmailAddress")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxTxtEmailSettingsEmailAddress")).sendKeys("TestEmail@callware.com");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxTxtEmailSettingsEmailAddress")).sendKeys(Keys.ENTER);
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxBtnConnectivitySubmit")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxTxtEmailSettingsEmailAddress")).getAttribute("value");
	        if(!value.contains("TestEmail@callware.com"))
	        	result += fail();
	        //admin users
	        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbAdminUsers")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        try
	        {
		        wd.findElement(By.linkText("AutomationTest")).click();
		        WebDriverLogin.waitT(wd, 1500);
		        if(wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtLogin")).getAttribute("value").contains("AutomationTest"))
		        {
		        	wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtEmail")).clear();
		        	wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtEmail")).sendKeys("TestEmail@callware.com");
		        	WebDriverLogin.waitT(wd, 500);
		        	wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxLbAdminUsersSubmit")).click();
		        	WebDriverLogin.waitT(wd, 2000);
		        	value = wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtEmail")).getAttribute("value");
			        if(!value.contains("TestEmail@callware.com"))
			        	result += fail();
		        }
		        else
		        	result += fail();
	        }
	        catch(Exception ex)
	        {
	        	result += exception();
	        }
	        
	        //TS Server
	        WebDriverLogin.waitT(wd, 1000);
	        Actions builder = new Actions(wd);
	        builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'Ts Servers')]"))).perform();
	        WebDriverLogin.waitT(wd, 100);
	        wd.findElement(By.linkText("WEBADMINTEST")).click();
	        WebDriverLogin.waitT(wd, 3000);
	        try
	        {
		        if(wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtMachineName")).getAttribute("value").contains("WEBADMINTEST"))
		        {
		        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtAdminEmail")).clear();
		        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtAdminEmail")).sendKeys("TestEmail@callware.com");
		        	WebDriverLogin.waitT(wd, 500);
		        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxBtnTsServerSubmit")).click();
		        	WebDriverLogin.waitT(wd, 2000);
		        	value = wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtAdminEmail")).getAttribute("value");
			        if(!value.contains("TestEmail@callware.com"))
			        	result += fail();
		        }
		        else
		        	result += fail();
	        }
	        catch(Exception ex)
	        {
	        	result += exception();
	        }
	        
	        //System Parameters
	        WebDriverLogin.waitT(wd, 1000);
	        //builder = new Actions(wd);
	        builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'System Parameters')]"))).perform();
	        WebDriverLogin.waitT(wd, 200);
	        wd.findElement(By.linkText("System Email")).click();
	        WebDriverLogin.waitT(wd, 3000);
	        try
	        {
		        if(wd.findElement(By.id("ctl00_uxCphContent_ucSysEmail_uxLblSysEmailSettings_Header")).getText().contains("System Email Settings"))
		        {
		        	wd.findElement(By.id("ctl00_uxCphContent_ucSysEmail_uxTxtEmailAddress")).clear();
		        	wd.findElement(By.id("ctl00_uxCphContent_ucSysEmail_uxTxtEmailAddress")).sendKeys("TestEmail@callware.com");
		        	WebDriverLogin.waitT(wd, 500);
		        	wd.findElement(By.id("ctl00_uxCphContent_ucSysEmail_uxBtnSysEmail_Submit")).click();
		        	WebDriverLogin.waitT(wd, 2000);
		        	value = wd.findElement(By.id("ctl00_uxCphContent_ucSysEmail_uxTxtEmailAddress")).getAttribute("value");
			        if(!value.contains("TestEmail@callware.com"))
			        	result += fail();
			        
			        wd.findElement(By.id("ctl00_uxCphContent_ucSysEmail_uxTxtEmailAddress")).clear();
			        WebDriverLogin.waitT(wd, 250);
			        wd.findElement(By.id("ctl00_uxCphContent_ucSysEmail_uxTxtEmailAddress")).sendKeys("jbaird@3mc.us");
			        WebDriverLogin.waitT(wd, 250);
			        wd.findElement(By.id("uxTxtUserPassword")).clear();
			        WebDriverLogin.waitT(wd, 250);
			        wd.findElement(By.id("uxTxtUserPassword")).sendKeys("wQz7x2!!");
			        WebDriverLogin.waitT(wd, 250);
			        wd.findElement(By.id("uxTxtPasswordConfirm")).clear();
			        WebDriverLogin.waitT(wd, 250);
			        wd.findElement(By.id("uxTxtPasswordConfirm")).sendKeys("wQz7x2!!");
			        WebDriverLogin.waitT(wd, 750);
			        
		        	wd.findElement(By.id("ctl00_uxCphContent_ucSysEmail_uxBtnSysEmail_Submit")).click();
		        	WebDriverLogin.waitT(wd, 2500);
		        }
		        else
		        	result += fail();
	        }
	        catch(Exception ex)
	        {
	        	result += exception();
	        }
	        
	        
			wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += exception();
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
	
	public static int exception()
	{
		return -109;
	}
	
	public static int fail()
	{
		return -10;
	}
}

/*
WebElement mySelectElm = wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingScripts")); 
Select mySelect= new Select(mySelectElm);
mySelect.selectByVisibleText("AdminActivityLog.txt");
wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingSelect")).click();*/
