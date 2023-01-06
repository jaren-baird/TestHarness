
import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Cyara_setupDLists_s0 
{
	//WA_TS_tui_SetupDLists-s0
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//reset local DLists
	
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        
        //
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl17_uxChkItemBox")).isSelected()) {
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl17_uxChkItemBox")).click();
        }
        if(!wd.findElement(By.tagName("html")).getText().contains("Reset")) {
            System.out.println("");
        }
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
        if(!wd.findElement(By.tagName("html")).getText().contains("Reset Boxes")) {
            System.out.println("");
        }
        wd.findElement(By.linkText("Distribution Lists")).click();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetDList_UcxResetDlist_uxChkResetLocalDList")).isSelected()) {
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetDList_UcxResetDlist_uxChkResetLocalDList")).click();
        }
        if(!wd.findElement(By.tagName("html")).getText().contains("Submit")) {
            System.out.println("");
        }
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
        WebDriverLogin.waitT(wd, 1500);
        if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
        {
            result = -10;
        }
        else
        	result = 0;
        
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();

		//
		
		wd.quit();
		System.exit(result);
	}
}
