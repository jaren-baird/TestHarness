
import login.WebDriverLogin;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

public class Test_VoiceRec_NN
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	static String calledNumber = "5785@10.16.99.23";
	//A_VoiceRecCyara_NN-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		try
		{
			String[] folderList = {"Voice Rec", "Voice_Rec_NN"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        WebDriverLogin.waitT(wd, 500);
			wd.findElement(By.id("PhoneNo")).clear();
			wd.findElement(By.id("PhoneNo")).sendKeys(calledNumber);
			WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 50000);
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
		
        System.exit(result);
	}
}