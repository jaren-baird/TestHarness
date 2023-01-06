
import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class VM_MSG_COSvcs_EMA_on
{
	public static void main(String[] args) throws Exception
	{
		ChromeDriver wd;
		wd = WebDriverLogin.getWebAdmin();
        //
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl15_uxLbNumber")).click();
        if(!wd.findElement(By.tagName("html")).getText().contains("Call Options")) {
            System.out.println("");
        }
        wd.findElement(By.linkText("Call Options")).click();
        //"ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkExtendedMailbox"
        //Turn Off Extended Mailbox Absence
        
        if(!wd.findElement(By.tagName("html")).getText().contains("Services")) {
            System.out.println("12");
        }
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkExtendedMailbox")).isSelected()) {
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkExtendedMailbox")).click();
        }
       
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxBtnCOSubmit")).click();
        if(!wd.findElement(By.tagName("html")).getText().contains("Updated")) {
            System.out.println("Remove Prompt: Extended Mailbox Absence");
        }
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxBtnCOClose")).click();
		//
		
		wd.quit();
	}
    
    public static boolean isAlertPresent(ChromeDriver wd) 
    {
        try 
        {
            wd.switchTo().alert();
            return true;
        } 
        catch (NoAlertPresentException e) 
        {
            return false;
        }
    }

}