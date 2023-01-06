
package WebAdmin;

import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T20746_VM_DefaultMaxPassLifetime
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//T20746_VM_DefaultMaxPassLifetime-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String box = "900007";
		
		try
		{
			wd = WebDriverLogin.getWebAdmin();
		    WebDriverLogin.resetBoxAll(wd, box, box);
			WebDriverLogin.searchBoxRange(wd, box, box, 1500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2000);
			wd.findElementByLinkText("Basic").click();
			WebDriverLogin.waitT(wd, 1500);
			Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLifetime")));
	        WebElement option = select.getFirstSelectedOption();
			String value = option.getText();
	        if(!value.contains("180"))
	        {
	        	result += -10;
	        }
			
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
			WebDriverLogin.waitT(wd, 2000);

			wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += -109;
			ex.printStackTrace();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
  	   	//
		System.exit(result);
	}
}
