
import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;

public class VM_SD_on
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//WA_MSG_OS_SDD_on-s0
	
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
        //
		try
    	{
    		String box = "1007";
    		WebDriverLogin.searchBoxRange(wd, box, box);
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
    		WebDriverLogin.waitT(wd, 2000);
            wd.findElement(By.linkText("Call Options")).click();
            WebDriverLogin.waitT(wd, 1000);
            //
            if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkSpeed_SpeedDial")).isSelected()) {
                wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkSpeed_SpeedDial")).click();
            }
            WebDriverLogin.waitT(wd, 1000);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Key")).click();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Key")).clear();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Key")).sendKeys("1");
            
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Number")).click();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Number")).clear();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Number")).sendKeys("6887");
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxBtnAddProgSpeedDial")).click();
            WebDriverLogin.waitT(wd, 2000);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Key")).click();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Key")).clear();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Key")).sendKeys("5");
            WebDriverLogin.waitT(wd, 1000);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Number")).click();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Number")).clear();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Number")).sendKeys("6789");
            WebDriverLogin.waitT(wd, 1000);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxBtnAddProgSpeedDial")).click();
            WebDriverLogin.waitT(wd, 1000);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxBtnCOSubmit")).click();
            WebDriverLogin.waitT(wd, 2000);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxBtnCOClose")).click();
            if(!wd.findElement(By.tagName("html")).getText().contains("Updated")) {
                System.out.println("Speed Dial Enabled");
            }
            WebDriverLogin.waitT(wd, 2000);
    		//
    		wd.quit();
    		wd = null;
    		result = 0;
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
		
		System.exit(result);
	}
}
