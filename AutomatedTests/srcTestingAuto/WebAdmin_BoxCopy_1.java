
import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class WebAdmin_BoxCopy_1 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//WA_TS_wa_BoxCopy-t0
	//This test is deprecated and handled by separate tests now
	
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
        WebDriverLogin.searchBoxRange(wd, "900005", "900006");
        
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
        WebDriverLogin.waitT(wd, 1500);
        
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).sendKeys("Randy");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).sendKeys("Orton");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Address1")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Address1")).sendKeys("RKO");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Address2")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Address2")).sendKeys("Out of Nowhere");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLifetime")).sendKeys("0");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLifetime")).sendKeys("0");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLifetime")).sendKeys("2");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLifetime")).sendKeys("99999999999999999");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_AutoDisable")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_AutoDisable")).sendKeys("45");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_OwnerTss")).sendKeys("R");
        try{
        	//wd.findElement(By.linkText("Report Test")).click();
        }catch (Exception ex){}
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Account")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Account")).sendKeys("555");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LongDistSuffix")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LongDistSuffix")).sendKeys("91801");
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxChkUser_ExtNumControl")).isSelected()) {
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxChkUser_ExtNumControl")).click();
        }
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_ExtNumEditLen")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_ExtNumEditLen")).sendKeys("10");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
        WebDriverLogin.waitT(wd, 1000);
         while(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
        	WebDriverLogin.waitT(wd, 8000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
        WebDriverLogin.waitT(wd, 2000);
        
        //Test Case 14341:Box copy - Copy voicemail box User Properties from one mailbox to another
        result = 0;
        WebDriverLogin.waitT(wd, 1000);
        WebDriverLogin.searchBoxRange(wd, "900005", "900006");
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl03_uxChkItemBox")).isSelected()) {
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl03_uxChkItemBox")).click();
        }
        WebDriverLogin.waitT(wd, 2000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Copy")).click();
        WebDriverLogin.waitT(wd, 2000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).sendKeys("900005");
        result += copyOneBox(wd, 1);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
        WebDriverLogin.waitT(wd, 4000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Copy Successful"))
    		result += -2000;
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
        WebDriverLogin.waitT(wd, 4000);
        WebDriverLogin.searchBoxRange(wd, "900006", "900006");
        result += checkCopiedBox(wd);
        
        //Test Case 14342:Box copy - Copy User Properties to 10 mailboxes
        WebDriverLogin.waitT(wd, 10000);
        WebDriverLogin.searchBoxRange(wd, "900007", "900017");
        WebDriverLogin.waitT(wd, 10000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Copy")).click();
        WebDriverLogin.waitT(wd, 2000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).sendKeys("900005");
        WebDriverLogin.waitT(wd, 3000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtResetBoxesCopyRangeStart")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtResetBoxesCopyRangeStart")).sendKeys("79449");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtResetBoxesCopyRangeEnd")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtResetBoxesCopyRangeEnd")).sendKeys("79459");
        result += copyOneBox (wd, 1);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
        WebDriverLogin.waitT(wd, 6000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Copy Successful"))
    		result += -2000;
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
        WebDriverLogin.waitT(wd, 10000);
        WebDriverLogin.searchBoxRange(wd, "900007", "900007");
        WebDriverLogin.waitT(wd, 10000);
        result += checkCopiedBox(wd);
        
        //Test Case 14343:Box copy - Copy User Properties to 100 mailboxes
        WebDriverLogin.waitT(wd, 5000);
        WebDriverLogin.searchBoxRange(wd, "900018", "900118");
        WebDriverLogin.waitT(wd, 5000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Copy")).click();
        WebDriverLogin.waitT(wd, 3000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).sendKeys("900005");
        WebDriverLogin.waitT(wd, 3000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtResetBoxesCopyRangeStart")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtResetBoxesCopyRangeStart")).sendKeys("79460");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtResetBoxesCopyRangeEnd")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtResetBoxesCopyRangeEnd")).sendKeys("79560");
        result += copyOneBox(wd, 1);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
        WebDriverLogin.waitT(wd, 6000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Copy Successful"))
    		result += -2000;
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
        WebDriverLogin.waitT(wd, 5000);
        WebDriverLogin.searchBoxRange(wd, "900019", "900019");
        WebDriverLogin.waitT(wd, 5000);
        result += checkCopiedBox(wd);
        
        //Test Case 14344:Box copy - Copy User properties using Select All
        WebDriverLogin.waitT(wd, 5000);
        WebDriverLogin.searchBoxRange(wd, "900119", "900121");
        WebDriverLogin.waitT(wd, 5000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl03_uxChkItemBox")).click();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl05_uxChkItemBox")).click();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Copy")).click();
        WebDriverLogin.waitT(wd, 2000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).sendKeys("900005");
        result += copyOneBox(wd, 2);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
        WebDriverLogin.waitT(wd, 4000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
        WebDriverLogin.waitT(wd, 2000);
        WebDriverLogin.searchBoxRange(wd, "900119", "900119");
        WebDriverLogin.waitT(wd, 2000);
        result += checkCopiedBox(wd);
        
        wd.quit();
        System.exit(result);
        
	}
	
	public static int checkCopiedBox(ChromeDriver wd) throws Exception
    {
		int result = 0;
		WebDriverLogin.waitT(wd, 2000);
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
    	WebDriverLogin.waitT(wd, 2000);
    	if(!wd.findElement(By.tagName("html")).getText().contains("RKO"))
    		result += -200;
    	if(!wd.findElement(By.tagName("html")).getText().contains("Out of Nowhere"))
    		result += -200;
    	if(!wd.findElement(By.tagName("html")).getText().contains("45"))
    		result += -200;
    	if(!wd.findElement(By.tagName("html")).getText().contains("91801"))
    		result += -200;
    	if(!wd.findElement(By.tagName("html")).getText().contains("555"))
    		result += -200;
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
    	WebDriverLogin.waitT(wd, 2000);
    	return result;
    }
	
	public static int copyOneBox (ChromeDriver wd, int choice) throws Exception
    {
		WebDriverLogin.waitT(wd, 1000);
    	int result = 0;
    	
        if(!wd.findElement(By.id("uxChkResetAll")).isSelected() && choice == 1) {
            wd.findElement(By.id("uxChkResetAll")).click();
        }
        if(!wd.findElement(By.id("uxChkResetUserAll")).isSelected() && choice == 2) {
            wd.findElement(By.id("uxChkResetUserAll")).click();
        }
        
        if(wd.findElement(By.id("uxChkResetAutoDisable")).isSelected())
            wd.findElement(By.id("uxChkResetAutoDisable")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("uxChkResetAccount")).isSelected())
            wd.findElement(By.id("uxChkResetAccount")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("uxChkResetPasscode")).isSelected())
            wd.findElement(By.id("uxChkResetPasscode")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("uxChkResetLanguage")).isSelected())
            wd.findElement(By.id("uxChkResetLanguage")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("uxChkResetAddress1")).isSelected())
            wd.findElement(By.id("uxChkResetAddress1")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("uxChkResetAddress2")).isSelected())
            wd.findElement(By.id("uxChkResetAddress2")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("uxChkLongDistance")).isSelected())
            wd.findElement(By.id("uxChkLongDistance")).click();
        else
        	result += -2;
        /*if(wd.findElement(By.id("uxChkResetOwnerTS")).isSelected())
            wd.findElement(By.id("uxChkResetOwnerTS")).click();
        else
        	result += -2;*/
        
        //if(JITCflag == true) {
        if(wd.findElement(By.id("uxChkResetMinPassCodeLength")).isSelected())
            wd.findElement(By.id("uxChkResetMinPassCodeLength")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("uxChkResetMaxPasscodeLength")).isSelected())
            wd.findElement(By.id("uxChkResetMaxPasscodeLength")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("uxChkResetMinPasscodeLife")).isSelected())
            wd.findElement(By.id("uxChkResetMinPasscodeLife")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("uxChkResetMaxPasscodeLife")).isSelected())
            wd.findElement(By.id("uxChkResetMaxPasscodeLife")).click();
        else
        	result += -2;
        //}
        
        
        if(wd.findElement(By.id("uxChkResetMWI")).isSelected())
            wd.findElement(By.id("uxChkResetMWI")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("uxChkResetExtNumber")).isSelected())
            wd.findElement(By.id("uxChkResetExtNumber")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("uxChkResetExtNumEditLength")).isSelected())
            wd.findElement(By.id("uxChkResetExtNumEditLength")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("uxChkResetOctel")).isSelected())
            wd.findElement(By.id("uxChkResetOctel")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("uxChkResetExtNumberCtrl")).isSelected())
            wd.findElement(By.id("uxChkResetExtNumberCtrl")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("uxChkResetTelePhoneNumber")).isSelected())
            wd.findElement(By.id("uxChkResetTelePhoneNumber")).click();
        else
        	result += -2;

        if(wd.findElement(By.id("uxChkResetAll")).isSelected() && choice == 1) {
            wd.findElement(By.id("uxChkResetAll")).click();
            WebDriverLogin.waitT(wd, 250);
            wd.findElement(By.id("uxChkResetAll")).click();
        }
        if(wd.findElement(By.id("uxChkResetUserAll")).isSelected() && choice == 2) {
            wd.findElement(By.id("uxChkResetUserAll")).click();
            WebDriverLogin.waitT(wd, 250);
            wd.findElement(By.id("uxChkResetUserAll")).click();
        }
        
        WebDriverLogin.waitT(wd, 1000);
        return result;
    }
}
