
package UserAdmin;

import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;

public class T19958_ModifyAllOpts
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T19958_ModifyAllOpts-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String value = "";
		
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.waitT(wd, 1000);
			wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			wd.findElement(By.id("ctl00_uxCphNavigation_uxLbAdminUsers")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(wd.findElementByTagName("html").getText().contains("AutomationTest"))
	        	deleteAdminUser(wd, "AutomationTest");
        	creatAdminUser(wd, "AutomationTest");
	        wd.findElement(By.linkText("AutomationTest")).click();
	        WebDriverLogin.waitT(wd, 4000);
			//Login
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtLogin")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtLogin")).sendKeys("edited");
			WebDriverLogin.waitT(wd, 500);
			
			//Email
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtEmail")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtEmail")).sendKeys("edited");
			WebDriverLogin.waitT(wd, 500);
			
			//min password life
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMinPasswordLifetime")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMinPasswordLifetime")).sendKeys("11");
			WebDriverLogin.waitT(wd, 500);
			
			//max password life
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMaxPasswordLifetime")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMaxPasswordLifetime")).sendKeys("333");
			WebDriverLogin.waitT(wd, 500);
			
			//max inactivity
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMaxInactivity")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMaxInactivity")).sendKeys("222");
			WebDriverLogin.waitT(wd, 500);
			
			//
			for(int i = 0; i < 2; i++)
			{
				value = wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtLogin")).getAttribute("value");
				if(!value.contains("edited"))
					result += fail();
				value = wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtEmail")).getAttribute("value");
				if(!value.contains("edited"))
					result += fail();
				value = wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMinPasswordLifetime")).getAttribute("value");
				if(!value.contains("11"))
					result += fail();
				value = wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMaxPasswordLifetime")).getAttribute("value");
				if(!value.contains("333"))
					result += fail();
				value = wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtMaxInactivity")).getAttribute("value");
				if(!value.contains("222"))
					result += fail();
				
				result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkAlarmNotification");
				result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewTsServers");
				result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkEditTsServers");
				result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkCreateTsServers");
				result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkDeleteTsServer");
				result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewAdmins");
				result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkEditAdmins");
				result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkCreateAdmins");
				result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkDeleteAdmins");
				result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkBackUpDB");
				result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewSysParams");
				result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkEditSysParams");
				result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewReports");
				result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewSecSettings");
				result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkEditSecSettings");
				result += checkBoxChanged(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkAccountEnabled");
				
				try
				{
					wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtID")).clear();
					wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtID")).sendKeys("99");
					WebDriverLogin.waitT(wd, 500);
					value = wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtID")).getAttribute("value");
					if(!value.contains("99"))
						result += fail();
					
					result += fail(); //exception must be thrown on .clear() because field is not editable
				}catch (Exception ex){}
				if(i == 0)
				{
					wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxLbAdminUsersSubmit")).click();
					WebDriverLogin.waitT(wd, 2000);
					wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
					WebDriverLogin.waitT(wd, 2000);
					wd.findElement(By.id("ctl00_uxCphNavigation_uxLbAdminUsers")).click();
			        WebDriverLogin.waitT(wd, 2000);
			        wd.findElement(By.linkText("edited")).click();
			        WebDriverLogin.waitT(wd, 2000);
				}
				else
				{
					wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxLbAdminUsersDelete")).click();
					try 
				    { 
						WebDriverLogin.waitT(wd, 1500);
				    	Alert alert = wd.switchTo().alert();
				        alert.accept();
				    }   
				    catch (NoAlertPresentException ex) {}
					WebDriverLogin.waitT(wd, 1500);
					if(!wd.findElementByTagName("html").getText().contains("AutomationTest"))
			        	creatAdminUser(wd, "AutomationTest");
				}
			}
			WebDriverLogin.waitT(wd, 1000);
			
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
	
	public static int checkBoxChanged(ChromeDriver wd, String field)
	{
		int result = 0;
		boolean wasSelected = false; 
		boolean isSelected = false;
		
		if(wd.findElement(By.id(field)).isSelected())
			wasSelected = true;
		else
			wasSelected = false;
		//
		wd.findElement(By.id(field)).click();
		//
		if(wd.findElement(By.id(field)).isSelected())
			isSelected = true;
		else
			isSelected = false;
		
		if(wasSelected == isSelected)
			result = fail();
		
		return result;
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
	
	public static void deleteAdminUser(ChromeDriver wd, String adminUser)
	{
		try
		{
			wd.findElement(By.id("ctl00_uxCphNavigation_uxLbAdminUsers")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.linkText(adminUser)).click();
	        WebDriverLogin.waitT(wd, 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxLbAdminUsersDelete")).click();
			try 
		    { 
				WebDriverLogin.waitT(wd, 1500);
		    	Alert alert = wd.switchTo().alert();
		        alert.accept();
		    }   
		    catch (NoAlertPresentException ex) {}
			wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
			WebDriverLogin.waitT(wd, 2000);
		}
		catch (Exception adminUserNotFound){}
	}
	
	public static int fail()
	{
		return -10;
	}
	
}
	
	