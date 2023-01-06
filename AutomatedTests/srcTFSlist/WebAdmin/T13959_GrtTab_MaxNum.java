
package WebAdmin;

import java.util.List;
import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T13959_GrtTab_MaxNum
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13959_GrtTab_MaxNum-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetGreetingTab(wd, "900006", "900006");
			WebDriverLogin.searchBoxRange(wd, "900006", "900006", 1500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElementByLinkText("Greetings").click();
	        WebDriverLogin.waitT(wd, 1500);
	        //
	        //Maximum Number of Greetings
	        //Test Case 13959:WebAdmin - GreetingTab - Greet - Maximum number of greetings
	        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreetingMaxNumGreetings")));
	        WebElement option = select.getFirstSelectedOption();
			String value = option.getText();
	        if(!value.contains("1"))
	        	result += -10;
	        //
	        List<WebElement> option2 = select.getOptions();
	        value = "";
	        for(WebElement webElement : option2)
	        {
	        	value = value+" "+webElement.getText();
	        }
			if(!value.contains(" 1 2 3 4 5 6 7 8 9"))
	        	result += -10;
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsClose")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        //
		}
	    catch (Exception ex)
	    {
	    	result+=-109;
    	}
		
        wd.quit();
        System.exit(result);
	}
}
	
	