
package WebAdminCallOptions;

import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class T13969_AT_RoutingOptsValid
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13969_AT_RoutingOptsValid-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String url = "";
		wd = WebDriverLogin.getWebAdmin();
		//wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverLogin.searchBoxRange(wd, "900001", "900001", 2000);
		//Test Case 13969:WebAdmin - CallOptions - Audiotext - Valid and invalid entries in routing options
		String checkData = "";
		String id = "";
		String errorId = "";
		String errorNotice = "";
		String[] invalidDigits = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
				"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","!","$","%","^","&","(",")"};
        String[] validNumerics = {"100","999","1000","9999","0"};
        
		try
		{
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.linkText("Call Options")).click();
			WebDriverLogin.waitT(wd, 2000);
			
			id = "ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtRoutingOptions_Key";
	        errorId = "CO_RegExValMaxDispaly";
	        errorNotice = "Numeric values only";
	        result += checkField(wd, id, errorId, errorNotice, validNumerics, true);
			//
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtRoutingOptions_Key";
	        errorId = "CO_RegExValMaxDispaly";
	        errorNotice = "Numeric values only";
	        result += checkField(wd, id, errorId, errorNotice, invalidDigits, false);
			
			
	        
		}
		catch(Exception ex)
		{result += -109;}
		
		//
		//
		
  	   	System.exit(result);
	}
	
	public static int checkField(ChromeDriver wd, String id, String errorId, String errorNotice, String[] invalidDigits, boolean valid)
	{
		int result = 0;
		String checkData = "";
		try
		{
			for(int i = 0; i < invalidDigits.length; i++)
			{
				wd.findElement(By.id(id)).clear();
				wd.findElement(By.id(id)).sendKeys(invalidDigits[i]);
				wd.findElement(By.id(id)).sendKeys(Keys.ENTER);
				WebDriverLogin.waitT(wd, 25);
				checkData = wd.findElement(By.id(errorId)).getText();
				if(checkData.contains(errorNotice) && valid==true || valid==false && !checkData.contains(errorNotice))
					result += -10;
			}
		}
		catch(Exception ex)
		{result += -10;}
		
		return result;
	}
}