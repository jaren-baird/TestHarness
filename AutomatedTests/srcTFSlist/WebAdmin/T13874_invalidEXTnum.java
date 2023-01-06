
package WebAdmin;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class T13874_invalidEXTnum
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13874_invalidEXTnum-t0
	
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
	        String[] invalidDigitsList = { "“*”" , "”100”" , "!" , "$" , "%" , "^" , "&" , "(" , ")" , "-" , "=" , "_" , "+",
	        		"\\" , "]" , "[" , "\'" , ";" , "/" , "." , "," , ")" , "<" , ">" , "?" , ":" , "\"" , "{" , "}" , "|" , "~" , "`",  
	        		"e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	        //
	        for(int i = 0; i < invalidDigitsList.length; i++)
	        {
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_ExtNumber")).clear();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_ExtNumber")).sendKeys(invalidDigitsList[i]);
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_ExtNumber")).sendKeys(Keys.ENTER);
		        WebDriverLogin.waitT(wd, 500);
		        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_RegularExpressionValidator1")).getText();
		        if(!value.contains("can only contain numbers 0-9"))
		        {
		        	result+=-10;
		        	System.out.println("Point of failure: "+invalidDigitsList[i]);
		        }
		        try
		        {
		        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
		        	WebDriverLogin.waitT(wd, 200);
		        	value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxLblUserStatus")).getText();
			        if(value.contains("Updated"))
			        {
			        	result+=-10;
			        }
		        	
		        	
		        }catch(Exception ex){}
	        }
	        
	        
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
	        WebDriverLogin.waitT(wd, 2000);
		}
	    catch (Exception ex)
	    {result+=-10;}
		
		//check box
        wd.quit();
        System.exit(result);
	}
}
	
	