
package TUI;

import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class T14947_TUI_Teacher_CallIn
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14947_TUI_Teacher_CallIn-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverLogin.waitT(wd, 1000);
			//WebDriverLogin.searchBoxRange(wd, "899990", "899990");
			if(!WebDriverLogin.checkBoxExists(wd, "899990"))
				result += WebDriverLogin.createTBoxWebAdmin(wd, "899990");
			else
				WebDriverLogin.resetBoxAll(wd, "899990", "899990");
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
		//
		try
		{
	        String[] folderList = {"DList", "TestSuite", "TUI", "A_Teacher_Setup"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 240000);
	        String[] para = {"0","true"};
	        if(WebDriverLogin.RunErrorTable(wd, para) != 0)
	            System.out.println("setup failed: A_Teacher_Setup");
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
        //
		try
		{
	        String[] folderList = {"DList", "TestSuite", "TUI", "T14947_Teacher_CL"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
			//
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 48000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
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
        //
        System.exit(result);
	}
}
	