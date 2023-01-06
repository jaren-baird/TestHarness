
import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Cyara_editDLists_s0 
{
	//WA_TS_tui_EditDLists-s0
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//Test Case 19549:DLists - Using the phone can you edit and changes the lists just set up in the client.
	
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //
        
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl17_uxLbNumber")).click();
        wd.findElement(By.linkText("Dist. Lists")).click();
        WebDriverLogin.waitT(wd, 2000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
        WebDriverLogin.waitT(wd, 2000);
        
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys("Testsuite DList");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys("8");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
        WebDriverLogin.waitT(wd, 2000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
        WebDriverLogin.waitT(wd, 2000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Testsuite DList"))
            result = -10;
        else
        	result = 0;
        
        if(!wd.findElement(By.tagName("html")).getText().contains("Close")) {
            System.out.println("");
        }
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
        WebDriverLogin.waitT(wd, 500);
		//
		
		wd.quit();
		System.exit(result);
	}
}

