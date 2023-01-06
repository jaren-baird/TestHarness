
import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;

public class VM_RCTP_on
{
	private static int result = 0;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	
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
            if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkRemoveCallTransferPrompts")).isSelected()) {
                wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkRemoveCallTransferPrompts")).click();
            }
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxBtnCOSubmit")).click();
            if(!wd.findElement(By.tagName("html")).getText().contains("Updated")) {
                System.out.println("Remove Prompt");
            }
            WebDriverLogin.waitT(wd, 1000);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxBtnCOClose")).click();
            WebDriverLogin.waitT(wd, 2000);
            WebDriverLogin.searchBoxRange(wd, "1000", "1000");
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
            WebDriverLogin.waitT(wd, 2000);
            wd.findElement(By.linkText("Call Options")).click();
            WebDriverLogin.waitT(wd, 1500);
            if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).isSelected()) {
                wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).click();
            }
            WebDriverLogin.waitT(wd, 500);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOSubmit")).click();
            WebDriverLogin.waitT(wd, 3000);
            if(wd.findElement(By.tagName("html")).getText().contains("Updated")) {
                System.out.println("Add Direct To Box");
                result = 0;
            }
            else
            {
            	result = -1;
            }
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOClose")).click();
            //
            WebDriverLogin.waitT(wd, 1500);
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
		
		System.exit(result);
	}
}
