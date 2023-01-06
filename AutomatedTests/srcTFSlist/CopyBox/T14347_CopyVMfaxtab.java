
package CopyBox;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T14347_CopyVMfaxtab 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14347_CopyVMfaxtab-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		wd = WebDriverLogin.getWebAdmin();
		WebDriverLogin.resetBoxAll(wd, "900006", "900008");
		WebDriverLogin.searchBoxRange(wd, "900006", "900008");
		
		
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
        WebDriverLogin.waitT(wd, 1500);
        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes")).click();
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsMaxNumFaxes")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsMaxNumFaxes")).sendKeys("159");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsNewFaxRetention")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsNewFaxRetention")).sendKeys("99");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsSavedFaxRetention")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsSavedFaxRetention")).sendKeys("99");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsDelFaxRetention")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsDelFaxRetention")).sendKeys("99");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsCustSubscriberId")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsCustSubscriberId")).sendKeys("My Callegra Fax");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsLocalFaxNumber")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsLocalFaxNumber")).sendKeys("918019886821");
        
        
        result += options(wd, true);
        
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxBtnFaxSubmit")).click();
        WebDriverLogin.waitT(wd, 4000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
        	result += -10;
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxBtnFaxClose")).click();
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
        wd.findElement(By.linkText("Faxes")).click();
        result += copyOneBox(wd);
        if(!wd.findElement(By.id("uxChkResetFaxesAll")).isSelected())
            wd.findElement(By.id("uxChkResetFaxesAll")).click();
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
        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes")).click();
        WebDriverLogin.waitT(wd, 1000);
        result += options(wd, false);
        WebDriverLogin.waitT(wd, 500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxBtnFaxClose")).click();
        WebDriverLogin.waitT(wd, 2000);
		
		return result;
	}
	
	public static int copyOneBox(ChromeDriver wd) throws Exception
    {
		WebDriverLogin.waitT(wd, 1000);
    	int result = 0;
    	
        if(!wd.findElement(By.id("uxChkResetFaxesAll")).isSelected()) {
            wd.findElement(By.id("uxChkResetFaxesAll")).click();
        }
        
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetMaxFaxes")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetMaxFaxes")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetNewFaxRet")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetNewFaxRet")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetSavedFaxRet")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetSavedFaxRet")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetDelFaxRet")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetDelFaxRet")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetLocalFaxNumber")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetLocalFaxNumber")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("uxChkResetFaxStoreForward")).isSelected())
            wd.findElement(By.id("uxChkResetFaxStoreForward")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetSepCallFaxing")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetSepCallFaxing")).click();
        else
        	result += -2;

        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetCustSubID")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetCustSubID")).click();
        else
        	result += -2;
        
        
        WebDriverLogin.waitT(wd, 1000);
        if(wd.findElement(By.id("uxChkResetFaxesAll")).isSelected()) 
        {
            wd.findElement(By.id("uxChkResetFaxesAll")).click();
            WebDriverLogin.waitT(wd, 250);
            wd.findElement(By.id("uxChkResetFaxesAll")).click();
        }
        
        WebDriverLogin.waitT(wd, 1000);
        return result;
    }
	
	public static int options(ChromeDriver wd, boolean state)
	{
		int result = 0;
        
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParametersFaxStoreForward")).isSelected() && state == true)
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParametersFaxStoreForward")).click();
        else if(state == true || state == false && !wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParametersFaxStoreForward")).isSelected())
        	result += -10;
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParametersSeperateCallFaxing")).isSelected() && state == true)
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParametersSeperateCallFaxing")).click();
        else if(state == true || state == false && !wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParametersSeperateCallFaxing")).isSelected())
        	result += -10;
        
        String value = "";
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsMaxNumFaxes")).getAttribute("value");
        if(!value.contains("159"))
        	result += -10;
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsNewFaxRetention")).getAttribute("value");
        if(!value.contains("99"))
        	result += -10;
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsSavedFaxRetention")).getAttribute("value");
        if(!value.contains("99"))
        	result += -10;
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsDelFaxRetention")).getAttribute("value");
        if(!value.contains("99"))
        	result += -10;
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsCustSubscriberId")).getAttribute("value");
        if(!value.contains("My Callegra Fax"))
        	result += -10;
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsLocalFaxNumber")).getAttribute("value");
        if(!value.contains("918019886821"))
        	result += -10;
        
        
		return result;
	}
}
