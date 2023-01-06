
import login.WebDriverLogin;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

public class Test_MSG_AMP_off_savemsg2
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//WA_MSG_OS_AMP_off-t12
	
	public static void main(String[] args) throws Exception
	{
		try
		{
			String[] folderList = {"Owner Services", "AMP_off", "2", "VM_MSG_AMP_off_SAVEMSG"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 90000);
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