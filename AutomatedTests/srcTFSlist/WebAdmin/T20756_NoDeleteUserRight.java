
package WebAdmin;

import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T20756_NoDeleteUserRight
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T20756_NoDeleteUserRight-t0
	//Test Case 20756:Validate the ability to delete a "User" with no rights to delete a user.
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(!wd.findElement(By.id("ctl00_uxCphHeader_uxLblLoggedIn")).getText().toLowerCase().contains("jaren"))
			{
				result += -9;
				wd.quit();
				System.exit(result);
			}
			toggleDeleteUserRight(wd, false); //off
			wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += fail();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		//ctl00_uxCphContent_ucAdminUsers_uxLbAdminUsersDelete
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverLogin.waitT(wd, 500);
			wd.findElement(By.id("ctl00_uxCphNavigation_uxLbAdminUsers")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        if(!wd.findElementByTagName("html").getText().contains("jaren"))
	        	creatAdminUser(wd, "jaren");
	        wd.findElementByLinkText("jaren").click();
	        WebDriverLogin.waitT(wd, 1500);
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxChkDeleteAdmins")).isSelected())
	        	result += fail();
	        wd.findElementByLinkText("AutomationTest").click();
	        WebDriverLogin.waitT(wd, 1500);
	        String value = wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtLogin")).getAttribute("value");
	        if(value.contains("AutomationTest"))
	        {
	        	try
	        	{
	        		wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		        	if(wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxLbAdminUsersDelete")).isDisplayed())
		        		result += fail();
	        	}
	        	catch(Exception ex)
	        	{}
	        }
	        else
	        	result += fail();
	        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += fail();
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
			wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			toggleDeleteUserRight(wd, true); //on
			wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += fail();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		
        System.exit(result);
	}
	
	public static void toggleDeleteUserRight(ChromeDriver wd, boolean state)
	{
		WebDriverLogin.waitT(wd, 500);
		if(!wd.findElement(By.id("ctl00_uxCphHeader_uxLblLoggedIn")).getText().toLowerCase().contains("jaren"))
			result += fail();
		else
		{
			wd.findElement(By.id("ctl00_uxCphNavigation_uxLbAdminUsers")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElementByLinkText("jaren").click();
	        WebDriverLogin.waitT(wd, 1500);
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxChkDeleteAdmins")).isSelected() && state == false)
	        	wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxChkDeleteAdmins")).click();
	        else if(!wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxChkDeleteAdmins")).isSelected() && state == true)
	        	wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxChkDeleteAdmins")).click();
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxLbAdminUsersSubmit")).click();
	        WebDriverLogin.waitT(wd, 3000);
	        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
	        WebDriverLogin.waitT(wd, 1500);
		}
	}
	
	public static void creatAdminUser(ChromeDriver wd, String adminUser)
	{
		wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxLbAdminUsersCreate")).click();
		WebDriverLogin.waitT(wd, 1500);
		wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtLogin")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxTxtLogin")).sendKeys(adminUser);
		WebDriverLogin.waitT(wd, 500);
		wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxLbAdminUsersSubmit")).click();
		WebDriverLogin.waitT(wd, 2000);
		/*if(!wd.findElementByTagName("html").getText().contains("AutomationTest"))
    	creatAdminUser(wd, "AutomationTest");*/
	}
	
	public static int fail()
	{
		return -10;
	}
}
	
	