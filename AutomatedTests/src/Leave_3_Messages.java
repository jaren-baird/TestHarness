
import login.WebDriverLogin;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

public class Leave_3_Messages 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//Leave_3_Message
	
	public static void main(String[] args) throws Exception
	{
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.searchBoxRange(wd, "1000", "1000");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.linkText("Call Options")).click();
			WebDriverLogin.waitT(wd, 1000);
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).isSelected())
			{
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).click();
				WebDriverLogin.waitT(wd, 1000);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOSubmit")).click();
				WebDriverLogin.waitT(wd, 4000);
			}
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOClose")).click();
			WebDriverLogin.waitT(wd, 1000);
			wd.quit();
			wd = null;
			//
			//
			String[] folderList = {"Leave_3_messages"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
			WebDriverLogin.waitT(wd, 1500);
			if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
			    System.out.println("");
			}
			wd.findElement(By.id("executeButton")).click();
			WebDriverLogin.waitT(wd, 175000);
			String[] para = {"0","true"};
			result = WebDriverLogin.RunErrorTable(wd, para);
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
}