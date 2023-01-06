
import login.WebDriverLogin;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

public class Test_CS_on
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//WA_MSG_CS_CS_on-t0
	
	public static void main(String[] args) throws Exception
	{
		try
		{
			String[] folderList = {"Owner Services", "2", "VM_CS_on"}; //??? wd.findElement(By.xpath("//*[@id='tree']/ul/li[1]/ul/li[3]/ul/li[2]/span/a")).click();
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 82000);
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