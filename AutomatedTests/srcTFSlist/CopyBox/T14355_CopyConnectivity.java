
package CopyBox;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T14355_CopyConnectivity 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14355_CopyConnectivity-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		wd = WebDriverLogin.getWebAdmin();
		WebDriverLogin.resetBoxAll(wd, "900006", "900008");
		WebDriverLogin.searchBoxRange(wd, "900006", "900008");
		
		
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
        WebDriverLogin.waitT(wd, 1500);
        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity")).click();
        WebDriverLogin.waitT(wd, 1500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxDdlConnectivityRightsLevel")).sendKeys("P");
        WebDriverLogin.waitT(wd, 500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxLblConnectivityRightsLevel")).click();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxTxtEmailSettingsServerAddress")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxTxtEmailSettingsServerAddress")).sendKeys("fake.address.com");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxTxtEmailSettingsUserName")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxTxtEmailSettingsUserName")).sendKeys("username");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxTxtEmailSettingsEmailAddress")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxTxtEmailSettingsEmailAddress")).sendKeys("fake@email.com");
        
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxChkGlobalFuntionalityGlobalExt")).isSelected()) 
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxChkGlobalFuntionalityGlobalExt")).click();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxChkGlobalFunctionalityGlobalMwi")).isSelected()) 
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxChkGlobalFunctionalityGlobalMwi")).click();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxChkGlobalFunctionalityGlobalNotification")).isSelected()) 
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxChkGlobalFunctionalityGlobalNotification")).click();
        
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxBtnConnectivitySubmit")).click();
        WebDriverLogin.waitT(wd, 4000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
        	result += -10;//System.out.println("");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxBtnConnectivityClose")).click();
        WebDriverLogin.waitT(wd, 2000);
        //
        
        //
        //WebDriverLogin.waitT(wd, 1000);
        WebDriverLogin.searchBoxRange(wd, "900006", "900008");
        //WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected()) 
        {
        	wd.findElement(By.id("uxChkboxsrtpr")).click();
        	if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).isSelected()) 
        		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
        }
        WebDriverLogin.waitT(wd, 500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Copy")).click();
        WebDriverLogin.waitT(wd, 2000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).sendKeys("900006");
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.linkText("Connectivity")).click();
        result += copyOneBox(wd);
        if(!wd.findElement(By.id("uxChkResetConnAll")).isSelected())
            wd.findElement(By.id("uxChkResetConnAll")).click();
        WebDriverLogin.waitT(wd, 500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
        WebDriverLogin.waitT(wd, 4000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Copy Successful"))
    		result += -2000;
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
        WebDriverLogin.waitT(wd, 4000);
        //
        
        //
        result += checkBoxes(wd, "900007");
        result += checkBoxes(wd, "900008");
        
        wd.quit();
        System.exit(result);
	}
	
	public static int checkBoxes(ChromeDriver wd, String box) throws InterruptedException
	{
		int result = 0;
		
		WebDriverLogin.searchBoxRange(wd, box, box);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
        WebDriverLogin.waitT(wd, 1500);
        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity")).click();
        WebDriverLogin.waitT(wd, 2000);
        
        String value = "";
        //
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxTxtEmailSettingsServerAddress")).getAttribute("value");
        if(!value.contains("fake.address.com"))
        	result += -10;
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxTxtEmailSettingsUserName")).getAttribute("value");
        if(!value.contains("username"))
        	result += -10;
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxTxtEmailSettingsEmailAddress")).getAttribute("value");
        if(!value.contains("fake@email.com"))
        	result += -10;
        
        
        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxDdlConnectivityRightsLevel")));
		WebElement option = select.getFirstSelectedOption();
		value = option.getText();
		if(!value.contains("Power User"))
        	result += -10;
        //
		
        //
		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxChkGlobalFuntionalityGlobalExt")).isSelected())
        	result += -10;
		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxChkGlobalFunctionalityGlobalMwi")).isSelected())
        	result += -10;
		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxChkGlobalFunctionalityGlobalNotification")).isSelected())
        	result += -10;
        //
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxBtnConnectivityClose")).click();
        WebDriverLogin.waitT(wd, 2500);
		
		return result;
	}
	
	public static int copyOneBox(ChromeDriver wd) throws Exception
    {
		WebDriverLogin.waitT(wd, 1000);
    	int result = 0;
    	
        if(!wd.findElement(By.id("uxChkResetConnAll")).isSelected()) {
            wd.findElement(By.id("uxChkResetConnAll")).click();
        }
        
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxChkResetUserRights")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxChkResetUserRights")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxChkResetDUFA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxChkResetDUFA")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetServerAddr")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetServerAddr")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetUserName")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetUserName")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetUserPasswd")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetUserPasswd")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetEmailAddr")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetEmailAddr")).click();
        else
        	result += -2;


        
        wd.findElement(By.linkText("Global Functionality")).click();
        WebDriverLogin.waitT(wd, 1000);
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpGlobalFunctionality_uxChkResetGlobalExt")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpGlobalFunctionality_uxChkResetGlobalExt")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpGlobalFunctionality_uxChkResetGlobalMWI")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpGlobalFunctionality_uxChkResetGlobalMWI")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpGlobalFunctionality_uxChkResetGlobalNotif")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpGlobalFunctionality_uxChkResetGlobalNotif")).click();
        else
        	result += -2;
        WebDriverLogin.waitT(wd, 1000);
        if(wd.findElement(By.id("uxChkResetConnAll")).isSelected()) 
        {
            wd.findElement(By.id("uxChkResetConnAll")).click();
            WebDriverLogin.waitT(wd, 250);
            wd.findElement(By.id("uxChkResetConnAll")).click();
        }
        
        WebDriverLogin.waitT(wd, 1000);
        return result;
    }
}
