
package SpeedDial;

import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class T14917_SPD20digit
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14917_SPD20digit-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		String value = "";
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetCallOptions(wd, "900005", "900005");
			WebDriverLogin.enableBoxRange(wd, "900005", "900005");
			WebDriverLogin.searchBoxRange(wd, "900005", "900005");
	    	
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm")).click();
		    WebDriverLogin.waitT(wd, 2500);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Key")).sendKeys("4");
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Number")).sendKeys("12345678901234567890");
		    WebDriverLogin.waitT(wd, 1000);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxBtnAddProgSpeedDial")).click();
		    WebDriverLogin.waitT(wd, 1000);
		    if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkSpeed_SpeedDial")).isSelected()) {
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkSpeed_SpeedDial")).click();
			    WebDriverLogin.waitT(wd, 1000);
		    }
		    
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxBtnCOSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxBtnCOClose")).click();
		    WebDriverLogin.waitT(wd, 3000);
		    wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += -109;
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		//
		try
		{
	        String[] folderList = {"DList", "TestSuite", "Other", "SpeedDial", "T14917_SPD20digit"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 180000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
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
}
	