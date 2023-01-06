
package UserAdmin;

import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T19965_66_FieldsMaxChars
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T19965_66_FieldsMaxChars-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String value = "";
		
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			wd.findElement(By.id("ctl00_uxCphNavigation_uxLbAdminUsers")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElementByTagName("html").getText().contains("AutomationTest"))
	        	creatAdminUser(wd, "AutomationTest");
        	wd.findElement(By.linkText("AutomationTest")).click();
        	WebDriverLogin.waitT(wd, 2000);
	        
			//Login
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtLogin")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtLogin")).sendKeys("123456789012345678901234567890123456789012345678909");
			WebDriverLogin.waitT(wd, 500);
			value = wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtLogin")).getAttribute("value");
			if(value.contains("123456789012345678901234567890123456789012345678909"))
				result += fail();
			else if(!value.contains("12345678901234567890123456789012345678901234567890"))
				result += fail();
			//
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxLnkBtnChgPwdAdmin")).click();
			WebDriverLogin.waitT(wd, 1500);
			//New pass
			wd.findElement(By.id("uxTxtAdminNewPwd")).clear();
			wd.findElement(By.id("uxTxtAdminNewPwd")).sendKeys("1234567890123456789012345678909");
			WebDriverLogin.waitT(wd, 500);
			value = wd.findElement(By.id("uxTxtAdminNewPwd")).getAttribute("value");
			if(value.contains("1234567890123456789012345678909"))
				result += fail();
			else if(!value.contains("123456789012345678901234567890"))
				result += fail();
			//Confirm
			wd.findElement(By.id("uxTxtAdminConfPwd")).clear();
			wd.findElement(By.id("uxTxtAdminConfPwd")).sendKeys("1234567890123456789012345678909");
			WebDriverLogin.waitT(wd, 500);
			value = wd.findElement(By.id("uxTxtAdminConfPwd")).getAttribute("value");
			if(value.contains("1234567890123456789012345678909"))
				result += fail();
			else if(!value.contains("123456789012345678901234567890"))
				result += fail();
			//Confirm
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
	
	public static void creatAdminUser(ChromeDriver wd, String adminUser)
	{
		wd.findElement(By.id("ctl00_uxCphNavigation_uxLbAdminUsers")).click();
        WebDriverLogin.waitT(wd, 2000);
		wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxLbAdminUsersCreate")).click();
		WebDriverLogin.waitT(wd, 1500);
		wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtLogin")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtLogin")).sendKeys(adminUser);
		WebDriverLogin.waitT(wd, 10000);
		wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxLbAdminUsersSubmit")).click();
		WebDriverLogin.waitT(wd, 5000);
		/*if(!wd.findElementByTagName("html").getText().contains("AutomationTest"))
    	creatAdminUser(wd, "AutomationTest");*/
	}
	
	public static int fail()
	{
		return -10;
	}
}
	
	