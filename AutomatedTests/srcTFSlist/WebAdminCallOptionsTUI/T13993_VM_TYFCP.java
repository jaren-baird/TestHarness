
package WebAdminCallOptionsTUI;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class T13993_VM_TYFCP
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13993_VM_TYFCP-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String box = "900005";
		//Test Case 13986:WebAdmin - CallOptions > Add Programmable Speed Dial
		
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			//wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebDriverLogin.resetCallOptions(wd, box, box);
			WebDriverLogin.enableBoxRange(wd, box, box);
			//WebDriverLogin.searchBoxRange(wd, box, box);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.linkText("Call Options")).click();
			WebDriverLogin.waitT(wd, 2000);
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkRemovePromptThankYou")).isSelected())
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkRemovePromptThankYou")).click();
			else
				result += fail();
	        //
			WebDriverLogin.waitT(wd, 500);
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
			wd = WebDriverLogin.getCyara(args);
			String[] folderList = {"DList", "TestSuite", "TUI", "TSCallOpts", "T13993_VM_TYFCP"};
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 55000);//55000
	        String[] para = {"5","false"};
			result += WebDriverLogin.RunErrorTable(wd, para);
			wd.quit();
			wd = null;
	        /*if(!wd.findElement(By.tagName("html")).getText().contains("Answered"))
	        	WebDriverLogin.waitT(wd, 15000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Step 5: No match"))
	        	result += fail();*/
		}
		catch(Exception ex)
		{
			result += -109;
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
  	   	try
  	   	{
	  	   	wd = WebDriverLogin.getWebAdmin();
	  	   	WebDriverLogin.searchBoxRange(wd, box, box);
	  	   	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.linkText("Call Options")).click();
			WebDriverLogin.waitT(wd, 2000);
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkRemovePromptThankYou")).isSelected())
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkRemovePromptThankYou")).click();
	        //
			WebDriverLogin.waitT(wd, 500);
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
			wd = WebDriverLogin.getCyara(args);
			String[] folderList = {"DList", "TestSuite", "TUI", "TSCallOpts", "T13993_VM_TYFCP"};
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 50000);
	        String[] para = {"0","true"};
			result += WebDriverLogin.RunErrorTable(wd, para);
		}
		catch(Exception ex)
		{
			result += -109;
		}
  	   	finally
		{
			if(wd != null)
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
					result += fail();
			}
		}
		catch(Exception ex)
		{
			result += -109;
		}
		
		return result;
	}
	
	public static int fail()
	{
		return -10;
	}
}
