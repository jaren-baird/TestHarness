
package UserAdmin;

import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T19972_Rights_ViewBoxProp
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T19972_Rights_ViewBoxProp-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		wd = WebDriverLogin.getWebAdmin();
		WebDriverLogin.waitT(wd, 1000);
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String value = "";
		//setup
		try
		{
			try
			{
				//WebDriverLogin.webAdminRightsOff(wd, "jaren");
			}
		    catch (Exception ex)
		    {
		    	result+= -15;
		    }
			
			//
			
			
			try
			{
				wd.findElement(By.id("ctl00_uxCphNavigation_uxLbAdminUsers")).click();
		        WebDriverLogin.waitT(wd, 4000);
		        if(wd.findElement(By.tagName("html")).getText().contains("jaren"))
		        {
		        	wd.findElement(By.linkText("jaren")).click();
		        	WebDriverLogin.waitT(wd, 4000);
		        }
		        else
		        {
		        	wd.quit();
		            System.exit(-1000);
		        }
		        
		        if(wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxChkViewTsServers")).isSelected())
					wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxChkViewTsServers")).click();
		        WebDriverLogin.waitT(wd, 100);
		        wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxLbAdminUsersSubmit")).click();
		        WebDriverLogin.waitT(wd, 2000);
		        
		        wd.findElement(By.id("ctl00_uxCphHeader_uxLbLogOut")).click();
		        wd = WebDriverLogin.getWebAdminLogin(wd);
		        
		        wd.quit();
			}
			catch (Exception ex)
			{
				result += -10;
				wd.quit();
		        System.exit(result);
			}
		}
		finally
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.waitT(wd, 1000);
			//WebDriverLogin.webAdminRightsOn(wd, "jaren");
			wd.quit();
		}
		
        //
		
        System.exit(result);
	}

	public static void checkBoxToggle(ChromeDriver wd, String field, boolean state)
	{
		if(state == true)
		{
			if(!wd.findElement(By.id(field)).isSelected())
				wd.findElement(By.id(field)).click();
		}
		else if(state == false)
		{
			if(wd.findElement(By.id(field)).isSelected())
				wd.findElement(By.id(field)).click();
		}
	}
	
}
	
	