
package Other;
import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class T14005_ValidateNSDmsgR
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14005_ValidateNSDmsgR-t0
	//Test Case 14005:Validate that "(New, Saved, Deleted) Message Retention" field can only accept up to 4 numeric character legth (1-255)
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		
		
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.waitT(wd, 1000);
			WebDriverLogin.resetMessages(wd, "900006", "900006");
			WebDriverLogin.searchBoxRange(wd, "900006", "900006");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_tab")).click();
		    
	        result += messageRetention(wd, "uxTxtMessageParamsNewMsgRetention");
	        result += messageRetention(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsSavedMsgRetention");
	        result += messageRetention(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsDeletedMsgRetention");
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Close")).click();
	        WebDriverLogin.waitT(wd, 2000);
		}
	    catch (Exception ex)
	    {
	    	result+=-109;
	    }
		
	    wd.quit();
	    System.exit(result);
	}
	
	public static int messageRetention(ChromeDriver wd, String field) throws InterruptedException
	{
		int result = 0;
		WebDriverLogin.waitT(wd, 1000);
		String value = "";
		String[] testArray = {"99999", "0", "256", "*", "“*”" , "”100”" , "!" , "#" , "$" , "%" , "^" , "&" , "(" , ")" , "-" , "=" , "_" , "+",
    		"\\" , "]" , "[" , "\'" , ";" , "/" , "." , "," , ")" , "<" , ">" , "?" , ":" , "\"" , "{" , "}" , "|" , "~" , "`",  
    		"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		for(int i = 0; i < testArray.length; i++)
		{
			wd.findElement(By.id(field)).clear();
		    wd.findElement(By.id(field)).sendKeys(testArray[i]);
		    wd.findElement(By.id(field)).sendKeys(Keys.ENTER);
		    WebDriverLogin.waitT(wd, 10);
		    value = wd.findElement(By.tagName("html")).getText();
		    if(!value.contains("message retention must be between 1 and 255"))
	        	result += -10;
		    
		}
		
		
	    WebDriverLogin.waitT(wd, 1500);
	    wd.findElement(By.id(field)).clear();
	    wd.findElement(By.id(field)).sendKeys("255");
	    WebDriverLogin.waitT(wd, 1500);
	    
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Submit")).click();
	    WebDriverLogin.waitT(wd, 2000);
		if(!wd.findElement(By.tagName("html")).getText().contains("Updated")) {
            System.out.println("update failed");
        }
        
        WebDriverLogin.waitT(wd, 2500);
        value = wd.findElement(By.id(field)).getAttribute("value");
        if(!value.contains("255") && value.length() != 3)
        	result+=-10;
		
		return result;
	}
}
	
	