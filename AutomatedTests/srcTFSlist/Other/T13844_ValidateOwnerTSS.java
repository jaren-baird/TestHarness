
package Other;
import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class T13844_ValidateOwnerTSS
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13844_ValidateOwnerTSS-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		wd = WebDriverLogin.getWebAdmin();
		WebDriverLogin.waitT(wd, 1000);
		
		try
		{
			result += changeOwnerTSS(wd, "webadmin", "900006");
			result += changeOwnerTSS(wd, "report", "900006");
	       
		}
	    catch (Exception ex)
	    {
	    	result = -109;
    	}
        
        wd.quit();
        System.exit(result);
	}
	
	public static int changeOwnerTSS(ChromeDriver wd, String ownerTSS, String box) throws InterruptedException
	{
		int result = 0;
		WebDriverLogin.searchBoxRange(wd, box, box);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
        WebDriverLogin.waitT(wd, 2000);
        String cha = String.valueOf(ownerTSS.charAt(0));
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_OwnerTss")).sendKeys(cha);
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
        WebDriverLogin.waitT(wd, 1500);
        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
        	WebDriverLogin.waitT(wd, 12000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
        WebDriverLogin.waitT(wd, 2000);
        
        WebDriverLogin.searchBoxRange(wd, box, box);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
        WebDriverLogin.waitT(wd, 2000);
        String value = "";
        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_OwnerTss")));
        WebElement option = select.getFirstSelectedOption();
		value = option.getText().toLowerCase();
        if(!value.contains(ownerTSS.toLowerCase()))
        {
        	if(!String.valueOf(value.charAt(0)).contains(cha))
        		result += -10;
        }
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
        WebDriverLogin.waitT(wd, 2000);
        
        return result;
	}
}
	
	