
package WebAdminCallOptions;

import java.util.List;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T13979_AT_MaxAudioTextDigits
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13979_AT_MaxAudioTextDigits-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		wd = WebDriverLogin.getWebAdmin();
		String box = "900001";
		String id = "";
        String errorId = "";
        String errorNotice = "";
		
		try
		{
			WebDriverLogin.resetCallOptions(wd, box, box);
			WebDriverLogin.searchBoxRange(wd, box, box, 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElementByLinkText("Call Options").click();
	        WebDriverLogin.waitT(wd, 1500);
	        //Maximum Audiotext Digits default value 4.
	        //Test Case 13979:WebAdmin - CallOptions - Call Options - Maximum Audiotext Digits
	        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxDdlCOAT_MaxAudiotextDigits")));
	        WebElement option = select.getFirstSelectedOption(); //Drop down menu prevents entering invalid values
			String value = option.getText();
	        if(!value.contains("4"))
	        	result += -10;
	        //
	        List<WebElement> option2 = select.getOptions();
	        value = "";
	        for(WebElement webElement : option2)
	        {
	        	value = value+" "+webElement.getText();
	        }
			if(!value.contains(" 1 2 3 4 5 6 7 8 9 10") || value.contains(" 0 1 2 3 4 5"))
	        	result += -10;
			option2.clear();
			//Greeting Replay Time default value 7.
			//Test Case 13980:WebAdmin - CallOptions - Call Options - Greeting Replay Time
			select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxDdlCOAT_GreetingReplayTime")));
	        option = select.getFirstSelectedOption(); //Drop down menu prevents entering invalid values
			value = option.getText();
	        if(!value.contains("7"))
	        	result += -10;
	        //
	        option2 = select.getOptions();
	        value = "";
	        for(WebElement webElement : option2)
	        {
	        	value = value+" "+webElement.getText();
	        }
			if(!value.contains(" 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60")
					|| value.contains(" 0 1 2 3 4 5"))
	        	result += -10;
			option2.clear();
			//Number of Greeting Plays default value 2.
			//Test Case 13981:WebAdmin - CallOptions - Call Options - Number of Greeting Plays
			select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxDdlCOAT_NumberofGreetingPlays")));
	        option = select.getFirstSelectedOption(); //Drop down menu prevents entering invalid values
			value = option.getText();
	        if(!value.contains("2"))
	        	result += -10;
	        //
	        option2 = select.getOptions();
	        value = "";
	        for(WebElement webElement : option2)
	        {
	        	value = value+" "+webElement.getText();
	        }
			if(!value.contains(" 1 2 3 4 5 6 7 8 9") || value.contains(" 0 1 2 3 4 5"))
	        	result += -10;
			option2.clear();
			//
			//
			String[] invalidDigits = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
	        		"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","!","$","%","^","&","(",")","@","*","#"};
        	//Transfer On Timeout Box
	        //Test Case 13982:WebAdmin Audiotext Call Options - Transfer On Timeout Box
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtCOAT_XfrOnTimeout";
	        errorId = "CO_RegularExpressionValidator9";
	        errorNotice = "Numeric values only";
	        result += checkField(wd, id, errorId, errorNotice, invalidDigits);
	        //Transfer On Error Box
	        //Test Case 13983:WebAdmin Audiotext Call Options - Transfer On Error Box
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtCOAT_XfrOnError";
	        errorId = "CO_RegularExpressionValidator10";
	        errorNotice = "Numeric values only";
	        result += checkField(wd, id, errorId, errorNotice, invalidDigits);
			//Test Case 13984:WebAdmin Audiotext Call Options - Services > Direct to box
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).isSelected())
				result += -10;
			
			
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOClose")).click();
	        WebDriverLogin.waitT(wd, 3000);
	        //
		}
	    catch (Exception ex)
	    {result+=-109;}
		
        wd.quit();
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
	
	