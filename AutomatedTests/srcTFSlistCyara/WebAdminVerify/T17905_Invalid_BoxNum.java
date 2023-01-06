
package WebAdminVerify;

import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T17905_Invalid_BoxNum
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//T17905_Invalid_BoxNum-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		try
		{
			/*
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.enableBoxRange(wd, "899999", "899999");
			wd.quit();
			wd = null;*/
			result += WebDriverLogin.setupBox899999();
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
	    //
		try
		{
			String[] folderList = {"DList", "TestSuite", "Other", "Verify", "T17905_Invalid_BoxNum"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 60000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
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
  	   	//
		System.exit(result);
	}
}
