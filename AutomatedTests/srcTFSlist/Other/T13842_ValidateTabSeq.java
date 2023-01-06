
package Other;
import java.util.concurrent.TimeUnit;
import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class T13842_ValidateTabSeq
{
	private static int result = 9;
	private static int Exception = WebDriverLogin.getException();
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13842_ValidateTabSeq-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		wd = WebDriverLogin.getWebAdmin();
		WebDriverLogin.waitT(wd, 1000);
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String data = "";
		
		try
		{
			WebDriverLogin.searchBoxRange(wd, "900006", "900006");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        data = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_header")).getText();
	        //System.out.println(data);
	        data = data.replaceAll("\n", "");
	        //System.out.println(data);
	        if(!data.contains("BasicMessagesFaxesDist. ListsNotificationsCall OptionsConnectivityGreetingsVoice Rec.Outbound Delivery"))
	        	result += -10;
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
	        WebDriverLogin.waitT(wd, 2000);
		}
	    catch (Exception ex)
	    {result = -109;}
        
        wd.quit();
        System.exit(result);
	}
}
	
	