
package OtherTUI;
import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class T13859_WebAdmin_BasicTab4
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13859_WebAdmin_BasicTab4-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.waitT(wd, 1000);
			Alert alert;
			result += WebDriverLogin.resetBoxAll(wd, "900006", "900006");
			WebDriverLogin.searchBoxRange(wd, "900006", "900006");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_ChgPasscode")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        String value = "";
	        String[] invalidDigitsList = { "!" , "@" , "#" , "$" , "%" , "^" , "&" , "*" };
	        //
	        for(int i = 0; i < invalidDigitsList.length; i++)
	        {
	        	wd.findElement(By.id("uxTxtPasscode")).clear();
		        wd.findElement(By.id("uxTxtPasscode")).sendKeys(invalidDigitsList[i]);
		        wd.findElement(By.id("uxTxtRetypePasscode")).clear();
		        wd.findElement(By.id("uxTxtRetypePasscode")).sendKeys(invalidDigitsList[i]);
		        wd.findElement(By.id("uxTxtRetypePasscode")).sendKeys(Keys.ENTER);
		        WebDriverLogin.waitT(wd, 500);
		        value = wd.findElement(By.id("RegExValChgPasscode")).getText();
		        if(!value.contains("Numeric values only"))
		        	result += fail();
	        }
	        
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("uxTxtPasscode")).clear();
	        wd.findElement(By.id("uxTxtPasscode")).sendKeys("5641");
	        wd.findElement(By.id("uxTxtRetypePasscode")).clear();
	        wd.findElement(By.id("uxTxtRetypePasscode")).sendKeys("5641");
	        //if(wd.findElement(By.tagName("html")).getText().contains("Numeric values only"))
	        	//result += fail();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnSubmitChangedPasscode")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        alert = wd.switchTo().alert();
	        alert.accept();
	        
	        
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_ChgPasscode")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("uxTxtPasscode")).sendKeys("5");
	        wd.findElement(By.id("uxTxtRetypePasscode")).sendKeys("5");
	        WebDriverLogin.waitT(wd, 1500);//
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxLblChgPwStatus")).getText();
	        if(value.contains("Passcode must be between"))
	        	result += fail();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnSubmitChangedPasscode")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        alert = wd.switchTo().alert();
	        alert.accept();
	        
	        //Validate cannot have sequence passcode
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_ChgPasscode")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("uxTxtPasscode")).sendKeys("1234");
	        wd.findElement(By.id("uxTxtRetypePasscode")).sendKeys("1234");
	        WebDriverLogin.waitT(wd, 1500);//
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnSubmitChangedPasscode")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxLblChgPwStatus")).getText();
	        if(!value.contains("Passcodes cannot be in sequence"))
	        	result += fail();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnSubmitChangePcClose")).click();
	        
	        
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLength")).sendKeys("4");
		    WebDriverLogin.waitT(wd, 100);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
		    WebDriverLogin.waitT(wd, 3000);
		    //passcode length below minimum and above maximum
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_ChgPasscode")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("uxTxtPasscode")).sendKeys("35");
	        wd.findElement(By.id("uxTxtRetypePasscode")).sendKeys("35");
	        WebDriverLogin.waitT(wd, 1500);//
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnSubmitChangedPasscode")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxLblChgPwStatus")).getText();
	        if(!value.contains("Passcode must be between"))
	        	result += fail();
	        //
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("uxTxtPasscode")).sendKeys("35794");
	        wd.findElement(By.id("uxTxtRetypePasscode")).sendKeys("35794");
	        WebDriverLogin.waitT(wd, 1500);//
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnSubmitChangedPasscode")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxLblChgPwStatus")).getText();
	        if(!value.contains("Passcode must be between"))
	        	result += fail();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnSubmitChangePcClose")).click();
	        
	        
	        //passcode changed
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_ChgPasscode")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("uxTxtPasscode")).sendKeys("7512");
	        wd.findElement(By.id("uxTxtRetypePasscode")).sendKeys("7512");
	        WebDriverLogin.waitT(wd, 1500);//
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnSubmitChangedPasscode")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        alert = wd.switchTo().alert();
	        alert.accept();
	        WebDriverLogin.waitT(wd, 1500);
	        
	        
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result  += exceptionRes();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		
		
		//Validate passcode in TUI
		try
		{
	        String[] folderList = {"DList", "TestSuite", "Other", "T13862_ValidatePass"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
			//
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 45000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result  += exceptionRes();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		
        System.exit(result);
	}
	
	public static int fail()
	{
		return -10;
	}
	
	public static int exceptionRes()
	{
		return -109;
	}
}
	
	