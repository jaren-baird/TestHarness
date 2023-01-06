
package WebAdminTUI;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class T13961_GrtTab_GPNedit
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13961_GrtTab_GPNedit-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String url = "";
		
		//Test Case 13961:WebAdmin - GreetingTab - Greet - Greeting\Passcode\Name edit
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.searchBoxRange(wd, "900005", "900005", 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLifetime")).sendKeys("0");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLifetime")).sendKeys(Keys.ENTER);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
			WebDriverLogin.waitT(wd, 4000);
			if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
				result += fail();
			//
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings")).click();
			WebDriverLogin.waitT(wd, 2000);
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkGreetingGrtPassNameEdit")).isSelected())
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkGreetingGrtPassNameEdit")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsSubmit")).click();
			WebDriverLogin.waitT(wd, 4000);
			if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
				result += fail();
			//
			wd.findElement(By.linkText("Call Options")).click();
			WebDriverLogin.waitT(wd, 2000);
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkSpeed_SpeedDial")).isSelected())
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkSpeed_SpeedDial")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxBtnCOSubmit")).click();
			WebDriverLogin.waitT(wd, 4000);
			if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
				result += fail();
			
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
		}////
		try
		{
		    wd = WebDriverLogin.getCyara(args);
		    String[] folderList = {"Cyara Testing","DList","TestSuite","TUI","GrtTab","T13961_GPNedit_OFF"};
		    WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 92000);
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
		}
		//
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.searchBoxRange(wd, "900005", "900005", 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings")).click();
			WebDriverLogin.waitT(wd, 2000);
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkGreetingGrtPassNameEdit")).isSelected())
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkGreetingGrtPassNameEdit")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsSubmit")).click();
			WebDriverLogin.waitT(wd, 4000);
			if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
				result += fail();
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
		}////
		try
		{
		    wd = WebDriverLogin.getCyara(args);
		    String[] folderList = {"Cyara Testing","DList","TestSuite","TUI","GrtTab","T13961_GPNedit_ON"};
		    WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 129000);
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
		}
		//900001 Audio Text
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.searchBoxRange(wd, "900001", "900001", 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings")).click();
			WebDriverLogin.waitT(wd, 2000);
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxChkGreetingGrtPassNameEdit")).isSelected())
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxChkGreetingGrtPassNameEdit")).click();
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxChkGreetingAllowNameAudioBoxes")).isSelected())
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxChkGreetingAllowNameAudioBoxes")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxBtnGreetingsSubmit")).click();
			WebDriverLogin.waitT(wd, 4000);
			if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
				result += fail();
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
		}////
		try
		{
		    wd = WebDriverLogin.getCyara(args);
		    String[] folderList = {"Cyara Testing","DList","TestSuite","TUI","GrtTab","T13961_AT_GPNedit_OFF"};
		    WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 70000);
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
		}
		//900001 AudioText
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.searchBoxRange(wd, "900001", "900001", 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings")).click();
			WebDriverLogin.waitT(wd, 2000);
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxChkGreetingGrtPassNameEdit")).isSelected())
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxChkGreetingGrtPassNameEdit")).click();
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxChkGreetingAllowNameAudioBoxes")).isSelected())
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxChkGreetingAllowNameAudioBoxes")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTbGreetings_ucAttenGreetings_uxBtnGreetingsSubmit")).click();
			WebDriverLogin.waitT(wd, 4000);
			if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
				result += fail();
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
		}////
		try
		{
		    wd = WebDriverLogin.getCyara(args);
		    String[] folderList = {"Cyara Testing","DList","TestSuite","TUI","GrtTab","T13961_AT_GPNedit_ON"};
		    WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 65000);
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
		}
		//
		
  	   	System.exit(result);
	}
	
	public static int fail()
	{
		return -10;
	}
}
