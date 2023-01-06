package CopyBox;

import login.WebDriverLogin;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class T14344_CopyVB_SA
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14344_CopyVB_SA-t0
	//Test Case 14344
	
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
		result = 0;
		//
		WebDriverLogin.searchBoxRange(wd, "900119", "900121");
        if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected()) {
            wd.findElement(By.id("uxChkboxsrtpr")).click();
        }
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
        WebDriverLogin.waitT(wd, 2000);
        if(!wd.findElement(By.id("uxChkResetUserAll")).isSelected()) {
            wd.findElement(By.id("uxChkResetUserAll")).click();
        }
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
        WebDriverLogin.waitT(wd, 2500);
        if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) {
        }
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
        WebDriverLogin.waitT(wd, 2500);
        
        WebDriverLogin.searchBoxRange(wd, "900005", "900005");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
        WebDriverLogin.waitT(wd, 1000);
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
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLength")).sendKeys("0");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLength")).sendKeys("0");
        
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLifetime")).sendKeys("20");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLifetime")).sendKeys("99999999999999999");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLength")).sendKeys("2");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLength")).sendKeys("6");
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
        WebDriverLogin.waitT(wd, 2500);
        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
        	WebDriverLogin.waitT(wd, 4000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
        WebDriverLogin.waitT(wd, 2000);
        
        
        //Test Case 14344:Box copy - Copy User properties using Select All
        WebDriverLogin.searchBoxRange(wd, "900119", "900121");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl03_uxChkItemBox")).click();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl05_uxChkItemBox")).click();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Copy")).click();
        WebDriverLogin.waitT(wd, 2000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).sendKeys("900005");
        result += copyOneBox(wd, 2);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
        WebDriverLogin.waitT(wd, 6000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Copy Successful"))
    		result += -2000;
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
        WebDriverLogin.waitT(wd, 3000);
        for(int i = 900119; i < 900122; i++)
        {
	        WebDriverLogin.waitT(wd, 500);
	        WebDriverLogin.searchBoxRange(wd, Integer.toString(i), Integer.toString(i));
	        WebDriverLogin.waitT(wd, 500);
	        result += checkCopiedBox(wd);
        }
        
        wd.quit();
        System.exit(result);
	}
	
	public static int checkCopiedBox(ChromeDriver wd) throws Exception
    {
		int result = 0;
		String value = "";
		WebDriverLogin.waitT(wd, 250);
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
    	WebDriverLogin.waitT(wd, 2000);
    	value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Address1")).getAttribute("value");
    	if(!value.contains("RKO"))
    	{
    		result += -200;
    		System.out.println("Address1 failed");
    	}
    	value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Address2")).getAttribute("value");
    	if(!value.contains("Out of Nowhere"))
    	{
    		result += -200;
    		System.out.println("Address2 failed");
    	}
    	value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_AutoDisable")).getAttribute("value");
    	if(!value.contains("45"))
    	{
    		result += -200;
    		System.out.println("AutoDisable failed");
    	}
    	value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LongDistSuffix")).getAttribute("value");
    	if(!value.contains("91801"))
    	{
    		result += -200;
    		System.out.println("LongDistSuffix failed");
    	}
    	value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Account")).getAttribute("value");
    	if(!value.contains("555"))
    	{
    		result += -200;
    		System.out.println("Account failed");
    	}
    	value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLength")).getAttribute("value");
    	if(!value.contains("2"))
    	{
    		result += -200;
    		System.out.println("MinPassLength failed");
    	}
    	value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLength")).getAttribute("value");
    	if(!value.contains("6"))
    	{
    		result += -200;
    		System.out.println("MaxPassLength failed");
    	}
    	value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLifetime")).getAttribute("value");
    	if(!value.contains("20"))
    	{
    		result += -200;
    		System.out.println("MinPassLifetime failed");
    	}
    	value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLifetime")).getAttribute("value");
    	if(!value.contains("905"))
    	{
    		result += -200;
    		System.out.println("MaxPassLifetime failed");
    	}
    	if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxChkUser_ExtNumControl")).isSelected())
    	{
    		result += -200;
    		System.out.println("ExtNumControl failed");
    	}
    	
    	
    	
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
    	WebDriverLogin.waitT(wd, 2000);
    	return result;
    }
	
	public static int copyOneBox (ChromeDriver wd, int choice) throws Exception
    {
		WebDriverLogin.waitT(wd, 5000);
    	int result = 0;
    	
        if(!wd.findElement(By.id("uxChkResetAll")).isSelected() && choice == 1) {
            wd.findElement(By.id("uxChkResetAll")).click();
        }
        if(choice == 2)
        {
	        if(wd.findElement(By.id("uxChkResetUserAll")).isSelected())
	            wd.findElement(By.id("uxChkResetUserAll")).click();
	        WebDriverLogin.waitT(wd, 250);
	        wd.findElement(By.id("uxChkResetUserAll")).click();
        }
        WebDriverLogin.waitT(wd, 1500);
        if(!wd.findElement(By.id("uxChkResetAutoDisable")).isSelected())
        {
        	if(wd.findElement(By.id("uxChkResetUserAll")).isSelected())
        	{
	            wd.findElement(By.id("uxChkResetUserAll")).click();
	            WebDriverLogin.waitT(wd, 250);
	            wd.findElement(By.id("uxChkResetUserAll")).click();
        	}
        	else
        		wd.findElement(By.id("uxChkResetUserAll")).click();
        	WebDriverLogin.waitT(wd, 1500);
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
        try
        {
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
        }
        catch (Exception ex){}
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
        try
        {
	        if(wd.findElement(By.id("uxChkResetOwnerTS")).isSelected())
	            wd.findElement(By.id("uxChkResetOwnerTS")).click();
	        else
	        	result += -2;
        }
        catch (Exception ex){}
        
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
        WebDriverLogin.waitT(wd, 2500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Copy")).click();
        WebDriverLogin.waitT(wd, 2500);
        if(choice == 1) 
        {
        	if(wd.findElement(By.id("uxChkResetAll")).isSelected())
        		wd.findElement(By.id("uxChkResetAll")).click();
        	WebDriverLogin.waitT(wd, 500);
            wd.findElement(By.id("uxChkResetAll")).click();
            
            
        }
        if(choice == 2) 
        {
        	if(wd.findElement(By.id("uxChkResetUserAll")).isSelected())
        		wd.findElement(By.id("uxChkResetUserAll")).click();
            WebDriverLogin.waitT(wd, 1500);
            wd.findElement(By.id("uxChkResetUserAll")).click();
        }
        
        WebDriverLogin.waitT(wd, 1000);
        return result;
    }
	
}

