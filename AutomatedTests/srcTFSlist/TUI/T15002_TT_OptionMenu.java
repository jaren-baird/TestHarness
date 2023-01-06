
package TUI;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class T15002_TT_OptionMenu
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T15002_TT_OptionMenu-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String url = "";
		//
		
        //run 14994_15002
  		String[] folderList = {"DList", "TestSuite", "TUI", "2", "T15002_TT_OptionMenu"};
		wd = WebDriverLogin.getCyara(args);
		result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
        WebDriverLogin.waitT(wd, 1500);
  		if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
  			System.out.println("");
  		}
  		wd.findElement(By.id("executeButton")).click();
  		WebDriverLogin.waitT(wd, 225000);
  		String[] para = {"0","true"};
        result = WebDriverLogin.RunErrorTable(wd, para);
  			
  		wd.quit();
        
        System.exit(result);
	}
}
	