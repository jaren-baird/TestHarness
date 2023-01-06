
package WebAdminCallOptionsTUI;

import login.WebDriverLogin;
import login.ErrorTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class T13998_VM_ExtAbsence
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13998_VM_ExtAbsence-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String box = "900005";
		
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			//wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebDriverLogin.resetCallOptions(wd, box, box);
			WebDriverLogin.enableBoxRange(wd, box, box);
			//WebDriverLogin.searchBoxRange(wd, box, box, 1000);
			//Test Case 13986:WebAdmin - CallOptions > Add Programmable Speed Dial
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_ExtNumber")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_ExtNumber")).sendKeys(Keys.ENTER);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
	        
			WebDriverLogin.waitT(wd, 3500);
			wd.findElement(By.linkText("Call Options")).click();
			WebDriverLogin.waitT(wd, 2000);
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkExtendedMailbox")).isSelected())
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkExtendedMailbox")).click();
			
			WebDriverLogin.waitT(wd, 100);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxBtnCOSubmit")).click();
	        WebDriverLogin.waitT(wd, 3500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxBtnCOClose")).click();
	        WebDriverLogin.waitT(wd, 2000);
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
		try
		{
	        //// Calls are not transfering on 6 digit numbers. needs looking into
	        String[] folderList = {"DList", "TestSuite", "TUI", "TSCallOpts", "T13998_VM_ExtAbsence"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 105000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
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
			wd = WebDriverLogin.getWebAdmin();
	  	   	WebDriverLogin.resetCallOptions(wd, box, box);
	  	   	wd.quit();
		}
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
		{
			result += -109;
		}
		
		return result;
	}
}