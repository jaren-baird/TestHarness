
package Other;
import java.util.concurrent.TimeUnit;
import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class T13843_ValidateAutoDisable
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13843_ValidateAutoDisable-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		wd = WebDriverLogin.getJITCWebAdmin();
		result = WebDriverLogin.resetBoxAll(wd, "900006", "900006");
		if(wd == null)
		{
			System.out.println("nonJITC");
			wd.quit();
	        System.exit(result);
		}
		WebDriverLogin.waitT(wd, 1000);
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		try
		{
			WebDriverLogin.searchBoxRange(wd, "900006", "900006");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_AutoDisable")).clear();
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_AutoDisable")).sendKeys("31");
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
	        	result += -10;
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
	        WebDriverLogin.waitT(wd, 1000);
	        
	        WebDriverLogin.searchBoxRange(wd, "900006", "900006");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_AutoDisable")).getAttribute("value");
    		if(!value.contains("31"))
	        	result+=-10;
	        
		}
	    catch (Exception ex)
	    {result+= -15;}
        
        wd.quit();
        System.exit(result);
	}
}
	
	