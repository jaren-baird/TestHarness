
package Other;
import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class T14004_ValidateMML
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14004_ValidateMML-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		wd = WebDriverLogin.getWebAdmin();
		WebDriverLogin.waitT(wd, 1000);
		String value ="";
		WebDriverLogin.resetMessages(wd, "900006", "900006");
		
		try
		{
			WebDriverLogin.searchBoxRange(wd, "900006", "900006");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_tab")).click();
		    WebDriverLogin.waitT(wd, 1500);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsMaxMsgLenth")).clear();
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsMaxMsgLenth")).sendKeys("99999");
		    WebDriverLogin.waitT(wd, 500);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Submit")).click();
		    WebDriverLogin.waitT(wd, 500);
		    value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxRvMaxMsgLength")).getText();
		    if(!value.contains("Maximum Message Length must be between 1 and 255"))
	        	result += -10;
		    WebDriverLogin.waitT(wd, 1500);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsMaxMsgLenth")).clear();
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsMaxMsgLenth")).sendKeys("255");
		    WebDriverLogin.waitT(wd, 1500);
		    
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Submit")).click();
		    WebDriverLogin.waitT(wd, 2000);
			if(!wd.findElement(By.tagName("html")).getText().contains("Updated")) {
	            System.out.println("update failed");
	        }
	        
	        WebDriverLogin.waitT(wd, 2500);
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsMaxMsgLenth")).getAttribute("value");
	        if(value.contains("255") && value.length() == 3)
	        	result = 0;
	        else
	        	result+=-10;
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Close")).click();
	        WebDriverLogin.waitT(wd, 2000);
		}
	    catch (Exception ex)
	    {result+=-10;}
		
        wd.quit();
        System.exit(result);
	}
}
	
	