
package TeacherTUI;

import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class T18763_68_Teacher_admin2
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T18763_68_Teacher_admin2-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			result = WebDriverLogin.resetBoxAll(wd, "899990", "899990");
			WebDriverLogin.searchBoxRange(wd, "899990", "899990");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2500);
			String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Mwi")).getAttribute("value");
		    WebDriverLogin.waitT(wd, 500);
		    
		    if(value.length() > 1)
		    {
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Mwi")).clear();
		    	WebDriverLogin.waitT(wd, 250);	
		    }
		    
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLifetime")).sendKeys("0");
		    WebDriverLogin.waitT(wd, 1500);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
		    WebDriverLogin.waitT(wd, 4000);
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
		
		try
		{
			//setup 899990
	        String[] folderList = {"DList", "TestSuite", "Teacher", "T18728_setup"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 187000);
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
		
		try
		{
	        //run leave msg
	        String[] folderList = {"DList", "TestSuite", "Teacher", "3", "T18763_Leave_message"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 55000);
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
        
		try
		{
	        //run T18763_64_66_68_admin2
	        String[] folderList = {"DList", "TestSuite", "Teacher", "3", "T18763_68_admin2"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 145000);
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
        
        System.exit(result);
	}
}
	