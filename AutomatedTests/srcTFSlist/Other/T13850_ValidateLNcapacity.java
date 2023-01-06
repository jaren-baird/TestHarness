
package Other;
import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class T13850_ValidateLNcapacity
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13850_ValidateLNcapacity-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		int checkRes = 0;
		//
		wd = WebDriverLogin.getWebAdmin();
		WebDriverLogin.waitT(wd, 1000);
		String ln = "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij";
		
		try
		{
			result += validateCapacity(wd, ln);
			checkRes = validateCapacity(wd, ln+"zzzz");
			if(checkRes != -10)
				result += -10;
			result += validateCapacity(wd, "");
	        
		}
	    catch (Exception ex)
	    {result+=-10;}
		
        wd.quit();
        System.exit(result);
	}
	
	public static int validateCapacity(ChromeDriver wd, String ln) throws InterruptedException
	{
		int result = 0;
		WebDriverLogin.searchBoxRange(wd, "900006", "900006");
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
        WebDriverLogin.waitT(wd, 2000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).sendKeys(ln);
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
        WebDriverLogin.waitT(wd, 2500);
        String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxLblUserStatus")).getText().toLowerCase();
        if(!value.contains("updated"))
        	result+=-10;
        
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).getAttribute("value").toLowerCase();
        if(!value.contains(ln))
        	result+=-10;
        
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
        WebDriverLogin.waitT(wd, 2000);
        
        return result;
	}
}
	
	