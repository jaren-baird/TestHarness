
package WebAdminCallOptions;

import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class T13995_VM_ExitExt
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13995_VM_ExitExt-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String url = "";
		String box = "900005";
		wd = WebDriverLogin.getWebAdmin();
		//wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverLogin.resetCallOptions(wd, box, box);
		
		//Defaults, checked/unchecked
		//Test Case 13995:WebAdmin - CallOptions - Services - Exit to Another Box or Extension
		//Test Case 13997:WebAdmin - CallOptions - Services >Call Screening
        
		try
		{
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_OwnerTss")).sendKeys("W");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_OwnerTss")).sendKeys(Keys.ENTER);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_ExtNumber")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_ExtNumber")).sendKeys("6789");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
	        
			WebDriverLogin.waitT(wd, 3500);
			wd.findElement(By.linkText("Call Options")).click();
			WebDriverLogin.waitT(wd, 2000);
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkExitToOtherBox")).isSelected())
			{
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkExitToOtherBox")).click();
				result += -10;
			}
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkCallScreening")).isSelected())
				result += -10; //default unchecked
			
				
	        //
			WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxBtnCOSubmit")).click();
	        WebDriverLogin.waitT(wd, 3500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxBtnCOClose")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.quit();
	  	   	//
	  	   	//
	        
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
				WebDriverLogin.waitT(wd, 50);
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