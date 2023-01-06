
import login.WebDriverLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class WebAdmin_ResetBasicOptions
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//WA_TS_BoxReset-r0
	
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
        //
        result = 0;
        
        try
        {
	        //Test Case 13814:Box Reset - Reset basic options (user)
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).isSelected()) {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        if(!wd.findElement(By.id("uxChkResetUserAll")).isSelected()) {
	            wd.findElement(By.id("uxChkResetUserAll")).click();
	        }
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        result += checksuccess(wd);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        //Test Case 13818:Box Reset - "Remove from all distribution lists" reset option
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).isSelected()) {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.linkText("Distribution Lists")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.id("uxChkResetAllDlist")).isSelected()) {
	            wd.findElement(By.id("uxChkResetAllDlist")).click();
	        }
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        result += checksuccess(wd);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 2500);
			
	        //Test Case 13817:Box Reset - Reset the distribution lists
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).isSelected()) {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.linkText("Distribution Lists")).click();
	        if(!wd.findElement(By.id("uxChkResetDlistAll")).isSelected()) {
	            wd.findElement(By.id("uxChkResetDlistAll")).click();
	        }
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        result += checksuccess(wd);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        //Test Case 13819:Box Reset - Reset the notifications
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).isSelected()) {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.linkText("Notifications")).click();
	        if(!wd.findElement(By.id("uxChkResetNotifAll")).isSelected()) {
	            wd.findElement(By.id("uxChkResetNotifAll")).click();
	        }
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        result += checksuccess(wd);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        //Test Case 13816:Box Reset - Reset the faxes
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).isSelected()) {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.linkText("Faxes")).click();
	        if(!wd.findElement(By.id("uxChkResetFaxesAll")).isSelected()) {
	            wd.findElement(By.id("uxChkResetFaxesAll")).click();
	        }
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        result += checksuccess(wd);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        //Test Case 13821:Box Reset - Reset the connectivity settings
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).isSelected()) {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.linkText("Connectivity")).click();
	        if(!wd.findElement(By.id("uxChkResetConnAll")).isSelected()) {
	            wd.findElement(By.id("uxChkResetConnAll")).click();
	        }
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        result += checksuccess(wd);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        //Test Case 13822:Box Reset - Reset box audio greetings and services settings
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).isSelected()) {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.linkText("Greetings")).click();
	        if(!wd.findElement(By.id("uxChkResetGrtAll")).isSelected()) {
	            wd.findElement(By.id("uxChkResetGrtAll")).click();
	        }
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        result += checksuccess(wd);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        //Test Case 13823:Box Reset - Reset voice rec. nick name and names
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).isSelected()) {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.linkText("Voice Rec.")).click();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetVoiceRec_uxChkResetVoRecNames")).isSelected()) {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetVoiceRec_uxChkResetVoRecNames")).click();
	        }
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        result += checksuccess(wd);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        //Test Case 13824:Box reset - Reset outbound delivery options
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).isSelected()) {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.linkText("Outbound Delivery")).click();
	        if(!wd.findElement(By.id("uxChkResetODAll")).isSelected()) {
	            wd.findElement(By.id("uxChkResetODAll")).click();
	        }
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        result += checksuccess(wd);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        //Test Case 13825:Box Reset - Select all in the reset screen
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).isSelected()) {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.linkText("Basic")).click();
	        if(!wd.findElement(By.id("uxChkResetAll")).isSelected()) {
	            wd.findElement(By.id("uxChkResetAll")).click();
	        }
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        result += checksuccess(wd);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        //Test Case 13826:Box Reset - Clear all in the reset screen
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).isSelected()) {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.linkText("Basic")).click();
	        if(!wd.findElement(By.id("uxChkResetAll")).isSelected()) {
	            wd.findElement(By.id("uxChkResetAll")).click();
	        }
	        WebDriverLogin.waitT(wd, 500);
	        if(wd.findElement(By.id("uxChkResetAll")).isSelected()) {
	            wd.findElement(By.id("uxChkResetAll")).click();
	        }
	        WebDriverLogin.waitT(wd, 1000);
	        if(wd.findElement(By.id("uxChkResetAll")).isSelected())
	        	result += -1002;
	        if(wd.findElement(By.id("uxChkResetAutoDisable")).isSelected())
	        	result += -1003;
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        //Test Case 13831:Box Reset - Reset a box greeting
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).isSelected()) {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.linkText("Greetings")).click();
	        if(!wd.findElement(By.id("uxChkResetGrtAll")).isSelected()) {
	            wd.findElement(By.id("uxChkResetGrtAll")).click();
	        }
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        result += checksuccess(wd);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        //Test Case 13837:box reset - Reset mailbox name
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).isSelected()) {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.linkText("Basic")).click();
	        if(!wd.findElement(By.id("uxChkResetFirstName")).isSelected()) {
	            wd.findElement(By.id("uxChkResetFirstName")).click();
	        }
	        if(!wd.findElement(By.id("uxChkResetLastName")).isSelected()) {
	            wd.findElement(By.id("uxChkResetLastName")).click();
	        }
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        result += checksuccess(wd);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        //Test Case 13839:Box Reset - Test options for "Remove from all Distribution Lists"
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).isSelected()) {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.linkText("Distribution Lists")).click();
	        if(!wd.findElement(By.id("uxChkResetAllDlist")).isSelected()) {
	            wd.findElement(By.id("uxChkResetAllDlist")).click();
	        }
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        result += checksuccess(wd);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
			wd.quit();
			WebDriverLogin.clearMWI();
		}
		catch(Exception ex)
		{
			result += -109;
		}
		
		System.exit(result);
	}
	
	public static int checksuccess(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		WebDriverLogin.waitT(wd, 3500);
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
		{
			WebDriverLogin.waitT(wd, 5500);
			if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful."))
			{
				WebDriverLogin.waitT(wd, 7500);
				if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful."))
		        	result -= 10;
			}
        }
		return result;
	}
}
