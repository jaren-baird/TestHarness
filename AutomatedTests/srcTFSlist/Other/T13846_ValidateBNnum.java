
package Other;
import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class T13846_ValidateBNnum
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13846_ValidateBNnum-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		wd = WebDriverLogin.getWebAdmin();
		WebDriverLogin.waitT(wd, 1000);
		
		try
		{
			WebDriverLogin.searchBoxRange(wd, "900006", "900006");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        String value = "";
	        String[] invalidDigitsList = { "“*”" , "”100”" , "!" , "#" , "$" , "%" , "^" , "&" , "(" , ")" , "-" , "=" , "_" , "+",
	        		"\\" , "]" , "[" , "\'" , ";" , "/" , "." , "," , ")" , "<" , ">" , "?" , ":" , "\"" , "{" , "}" , "|" , "~" , "`",  
	        		"e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	        //
	        for(int i = 0; i < invalidDigitsList.length; i++)
	        {
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Number")).clear();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Number")).sendKeys(invalidDigitsList[i]);
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Number")).sendKeys(Keys.ENTER);
		        WebDriverLogin.waitT(wd, 500);
		        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_RegularExpressionValidator3")).getText();
		        if(!value.contains("can only contain numbers"))
		        	result+=-10;
	        }
	        
	        
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
	        WebDriverLogin.waitT(wd, 2000);
		}
	    catch (Exception ex)
	    {result+=-10;}
		
        wd.quit();
        System.exit(result);
	}
}
	
	