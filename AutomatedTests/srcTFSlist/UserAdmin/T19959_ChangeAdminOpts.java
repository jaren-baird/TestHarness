
package UserAdmin;

import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T19959_ChangeAdminOpts
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T19959_ChangeAdminOpts-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		wd = WebDriverLogin.getWebAdmin();
		WebDriverLogin.waitT(wd, 1000);
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String value = "";
		Alert alert;
		
		try
		{
			wd.findElement(By.id("ctl00_uxCphNavigation_uxLbAdminUsers")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(wd.findElement(By.tagName("html")).getText().contains("AutoDeleteTest"))
	        {
	        	wd.findElement(By.linkText("AutoDeleteTest")).click();
	        	WebDriverLogin.waitT(wd, 4000);
	        	wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxLbAdminUsersDelete")).click();
	        	//
		        try 
			    { 
		        	WebDriverLogin.waitT(wd, 2000);
			    	alert = wd.switchTo().alert();
			        alert.accept();
			        WebDriverLogin.waitT(wd, 4000);
			    } 
		        catch (Exception ex)
		        {
		        	result = -1000;
		        	wd.quit();
		            System.exit(result);
		        }
	        	//
	        }
	        
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxLbAdminUsersCreate")).click();
	        WebDriverLogin.waitT(wd, 6000);
	        wd.findElement(By.linkText("New User")).click();
	        WebDriverLogin.waitT(wd, 4000);
			//Login
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtLogin")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtLogin")).sendKeys("AutoDeleteTest");
			WebDriverLogin.waitT(wd, 500);
			value = wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtLogin")).getAttribute("value");
			if(!value.contains("AutoDeleteTest"))
				result += -10;
			//Email
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtEmail")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtEmail")).sendKeys("edited");
			WebDriverLogin.waitT(wd, 500);
			value = wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtEmail")).getAttribute("value");
			if(!value.contains("edited"))
				result += -10;
			//min password life
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMinPasswordLifetime")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMinPasswordLifetime")).sendKeys("11");
			WebDriverLogin.waitT(wd, 500);
			value = wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMinPasswordLifetime")).getAttribute("value");
			if(!value.contains("11"))
				result += -10;
			//
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMaxPasswordLifetime")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMaxPasswordLifetime")).sendKeys("333");
			WebDriverLogin.waitT(wd, 500);
			value = wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMaxPasswordLifetime")).getAttribute("value");
			if(!value.contains("333"))
				result += -10;
			//
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMaxInactivity")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMaxInactivity")).sendKeys("222");
			WebDriverLogin.waitT(wd, 500);
			value = wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMaxInactivity")).getAttribute("value");
			if(!value.contains("222"))
				result += -10;
			//
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkAlarmNotification", false);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewTsServers", false);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkEditTsServers", false);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkCreateTsServers", false);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkDeleteTsServer", false);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewAdmins", false);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkEditAdmins", false);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkCreateAdmins", false);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkDeleteAdmins", false);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkBackUpDB", false);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewSysParams", false);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkEditSysParams", false);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewReports", false);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewSecSettings", false);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkEditSecSettings", false);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkAccountEnabled", false);
			
			try
			{
				wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtID")).clear();
				wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtID")).sendKeys("99");
				WebDriverLogin.waitT(wd, 500);
				value = wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtID")).getAttribute("value");
				if(!value.contains("99"))
					result += -10;
				
				result += -10; //exception must be thrown on .clear() because field is not editable
			}
			catch (Exception ex)
			{}
			
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxLbAdminUsersSubmit")).click();
	        WebDriverLogin.waitT(wd, 4500);
	        
		}
	    catch (Exception ex)
	    {
	    	result+= -15;
	    	wd.quit();
	    	System.exit(result);
	    }
        wd.quit();
        //
        wd = WebDriverLogin.getWebAdmin();
		WebDriverLogin.waitT(wd, 1000);
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		value = "";
		
		try
		{
	        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbAdminUsers")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        wd.findElement(By.linkText("AutoDeleteTest")).click();
	        WebDriverLogin.waitT(wd, 4000);
			//Login
			value = wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtLogin")).getAttribute("value");
			if(!value.contains("AutoDeleteTest"))
				result += -10;
			//Email
			value = wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtEmail")).getAttribute("value");
			if(!value.contains("edited"))
				result += -10;
			//min password life
			value = wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMinPasswordLifetime")).getAttribute("value");
			if(!value.contains("11"))
				result += -10;
			//
			value = wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMaxPasswordLifetime")).getAttribute("value");
			if(!value.contains("333"))
				result += -10;
			//
			value = wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMaxInactivity")).getAttribute("value");
			if(!value.contains("222"))
				result += -10;
			//
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkAlarmNotification", true);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewTsServers", true);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkEditTsServers", true);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkCreateTsServers", true);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkDeleteTsServer", true);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewAdmins", true);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkEditAdmins", true);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkCreateAdmins", true);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkDeleteAdmins", true);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkBackUpDB", true);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewSysParams", true);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkEditSysParams", true);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewReports", true);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewSecSettings", true);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkEditSecSettings", true);
			result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkAccountEnabled", true);
	        WebDriverLogin.waitT(wd, 1000);
	        
	        try
			{
	        	wd.findElement(By.id("ctl00_uxCphNavigation_uxLbAdminUsers")).click();
		        WebDriverLogin.waitT(wd, 4000);
		        if(wd.findElement(By.tagName("html")).getText().contains("AutoDeleteTest"))
		        {
		        	wd.findElement(By.linkText("AutoDeleteTest")).click();
		        	WebDriverLogin.waitT(wd, 4000);
		        	wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxLbAdminUsersDelete")).click();
		        	//
			        try 
				    { 
			        	WebDriverLogin.waitT(wd, 2000);
				    	alert = wd.switchTo().alert();
				        alert.accept();
				        WebDriverLogin.waitT(wd, 3000);
				    } 
			        catch (Exception ex)
			        {
			        	result = -1000;
			        	wd.quit();
			            System.exit(result);
			        }
		        	//
		        }
		        
		        if(wd.findElement(By.tagName("html")).getText().contains("AutoDeleteTest"))
		        {
		        	result += -10;
		        }
			}
	        catch (Exception ex)
		    {result+= -14;}
	        
		}
	    catch (Exception ex)
	    {result+= -15;}
        
        wd.quit();
        System.exit(result);
	}
	
	public static int checkBoxChanged(ChromeDriver wd, String field, boolean check)
	{
		int result = 0;
		//
		if(check == false)
		{
			if(!wd.findElement(By.id(field)).isSelected())
				wd.findElement(By.id(field)).click();
		}
		else
		{
			if(!wd.findElement(By.id(field)).isSelected())
				result += -10;
		}
		//

		
		return result;
	}
}
	
	