
package DListTUI;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
////Test Case 19547:DLists - Using the phone change the name of the lists

public class T19547_DListEdit_Name 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T19547_DListEdit_Name-t0
	
	public static void main(String[] args) throws Exception
	{
		String url = "";
		result = 0;
		try
		{
			String[] folderList = {"DList", "TestSuite", "DListSetup", "Edit_DList_Name"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
			WebDriverLogin.waitT(wd, 1500);
			if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
				System.out.println("");
			}
			wd.findElement(By.id("executeButton")).click();
			WebDriverLogin.waitT(wd, 120000);
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
	