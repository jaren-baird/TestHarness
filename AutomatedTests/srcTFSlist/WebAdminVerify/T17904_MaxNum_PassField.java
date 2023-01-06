
package WebAdminVerify;

import login.WebDriverLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class T17904_MaxNum_PassField
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//T17904_MaxNum_PassField-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    //reset box
		    String box = "900010";
		    WebDriverLogin.searchBoxRange(wd, box, box, 2500);
		    WebDriverLogin.resetBoxAll(wd, box, box);
		    WebDriverLogin.waitT(wd, 1000);
		    WebDriverLogin.enableBoxRange(wd, "899999", "899999");
	    	WebDriverLogin.searchBoxRange(wd, "899999", "899999", 2500);
	    	
		    //max digits passcode number
	    	WebDriverLogin.waitT(wd, 2000);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    WebDriverLogin.waitT(wd, 2000);
		    Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLength")));
			select.selectByVisibleText("10");
			WebDriverLogin.waitT(wd, 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
			WebDriverLogin.waitT(wd, 2500);
			
			//behavior is the passcode change succeeds and leaves a prompt to okay
		    Alert alert;
		    String passCode = "1342756809"; 
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_ChgPasscode")).click();
		    WebDriverLogin.waitT(wd, 1500);
		    wd.findElement(By.id("uxTxtPasscode")).clear();
	        wd.findElement(By.id("uxTxtPasscode")).sendKeys(passCode);
	        wd.findElement(By.id("uxTxtRetypePasscode")).clear();
	        wd.findElement(By.id("uxTxtRetypePasscode")).sendKeys(passCode);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnSubmitChangedPasscode")).click();
	        try 
		    { 
	        	WebDriverLogin.waitT(wd, 1000);
		    	alert = wd.switchTo().alert(); //alert present with acceptable passcode
		        alert.accept();
		    }   
		    catch (NoAlertPresentException ex) 
		    { 
		    	result += -101;
		    }
	        //behavior is the passcode change goes away
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_ChgPasscode")).click();
		    WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("uxTxtPasscode")).clear();
	        wd.findElement(By.id("uxTxtPasscode")).sendKeys(passCode+"1");
	        wd.findElement(By.id("uxTxtRetypePasscode")).clear();
	        wd.findElement(By.id("uxTxtRetypePasscode")).sendKeys(passCode+"1");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnSubmitChangedPasscode")).click();
	        try 
		    { 
	        	WebDriverLogin.waitT(wd, 1500);
		    	alert = wd.switchTo().alert(); //alert not present with unacceptable passcode length
		        alert.accept();
		        result += -102;
		    }   
		    catch (NoAlertPresentException ex) {}
	        
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
		
  	   	//
		System.exit(result);
	}
}
