
package WebAdminCallOptions;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class T13978_AT_OperatorValid 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13978_AT_OperatorValid-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		
		String box = "900001";
		String id = "";
        String errorId = "";
        String errorNotice = "";
        wd = WebDriverLogin.getWebAdmin();
		
		//wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//Test Case 13978:WebAdmin - Audiotext box Call Options - Operator Box valid boxes
		try
		{
			WebDriverLogin.searchBoxRange(wd, box, box, 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.linkText("Call Options")).click();
			WebDriverLogin.waitT(wd, 2000);
	        String[] invalidDigits = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
	        		"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","!","$","%","^","&","(",")","@","*","#"};
        	//Dialing String
	        //Test Case 13930:WebAdmin - NotificationTab - Wakeup - Dialing String with invalid digits
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtCOAT_OperatorBox";
	        errorId = "CO_RegularExpressionValidator8";
	        errorNotice = "Numeric values only";
	        result += checkField(wd, id, errorId, errorNotice, invalidDigits);
			//
	        WebDriverLogin.waitT(wd, 1500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOClose")).click();
			WebDriverLogin.waitT(wd, 3500);
			wd.quit();
			//
		}
		catch(Exception ex)
		{result += -109;}
  	   	//
        System.exit(result);
	}
	
	public static int checkField(ChromeDriver wd, String id, String errorId, String errorNotice, String[] validDigits)
	{
		int result = 0;
		String checkData = "";
		errorNotice = errorNotice.toLowerCase();
		try
		{
			for(int i = 0; i < validDigits.length; i++)
			{
				wd.findElement(By.id(id)).clear();
				wd.findElement(By.id(id)).sendKeys(validDigits[i]);
				wd.findElement(By.id(id)).sendKeys(Keys.ENTER);
				WebDriverLogin.waitT(wd, 100);
				checkData = wd.findElement(By.id(errorId)).getText().toLowerCase();
				if(!checkData.contains(errorNotice))
					result += -10;
			}
		}
		catch(Exception ex)
		{result += -10;}
		
		return result;
	}
}
