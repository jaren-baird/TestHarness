
package Other;
import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class T13857_WebAdmin_BasicTab2
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13857_WebAdmin_BasicTab2-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		wd = WebDriverLogin.getWebAdmin();
		WebDriverLogin.waitT(wd, 1000);
		Alert alert;
		result = WebDriverLogin.resetBoxAll(wd, "900006", "900006");
		try
		{
			WebDriverLogin.searchBoxRange(wd, "900006", "900006");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_ChgPasscode")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("uxTxtPasscode")).sendKeys("abc0");
	        wd.findElement(By.id("uxTxtRetypePasscode")).sendKeys("abc0");
	        WebDriverLogin.waitT(wd, 1500);//
	        if(!wd.findElement(By.tagName("html")).getText().contains("Numeric values only"))
	        	result+=-10;
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnSubmitChangedPasscode")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("uxTxtPasscode")).clear();
	        wd.findElement(By.id("uxTxtPasscode")).sendKeys("8463");
	        wd.findElement(By.id("uxTxtRetypePasscode")).clear();
	        wd.findElement(By.id("uxTxtRetypePasscode")).sendKeys("8463");
	        if(wd.findElement(By.tagName("html")).getText().contains("Numeric values only"))
	        	result+=-10;
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnSubmitChangedPasscode")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        alert = wd.switchTo().alert();
	        alert.accept();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
	        WebDriverLogin.waitT(wd, 2000);
		}
	    catch (Exception ex)
	    {result+=-10;}
        
        wd.quit();
        System.exit(result);
	}
}
	
	