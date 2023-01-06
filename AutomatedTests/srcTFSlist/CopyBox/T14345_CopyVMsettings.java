
package CopyBox;
import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class T14345_CopyVMsettings 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14345_CopyVMsettings-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		wd = WebDriverLogin.getWebAdmin();
		WebDriverLogin.resetBoxAll(wd, "900006", "900007");
		WebDriverLogin.searchBoxRange(wd, "900006", "900007");
		
		
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
        WebDriverLogin.waitT(wd, 1500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_tab")).click();
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParams_MaxNumMessages")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParams_MaxNumMessages")).sendKeys("599");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsMaxMsgLenth")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsMaxMsgLenth")).sendKeys("4");
        wd.findElement(By.id("uxTxtMessageParamsNewMsgRetention")).clear();
        wd.findElement(By.id("uxTxtMessageParamsNewMsgRetention")).sendKeys("99");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsSavedMsgRetention")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsSavedMsgRetention")).sendKeys("99");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsDeletedMsgRetention")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsDeletedMsgRetention")).sendKeys("99");
        
        result += options(wd, true);
        
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Submit")).click();
        WebDriverLogin.waitT(wd, 4000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
        	result += -10;
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Close")).click();
        WebDriverLogin.waitT(wd, 2000);
        //
        
        //
        //WebDriverLogin.waitT(wd, 1000);
        WebDriverLogin.searchBoxRange(wd, "900006", "900007");
        //WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl03_uxChkItemBox")).isSelected()) {
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl03_uxChkItemBox")).click();
        }
        WebDriverLogin.waitT(wd, 500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Copy")).click();
        WebDriverLogin.waitT(wd, 2000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).sendKeys("900006");
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.linkText("Messages")).click();
        result += copyOneBox(wd);
        if(!wd.findElement(By.id("uxChkResetMsgAll")).isSelected())
            wd.findElement(By.id("uxChkResetMsgAll")).click();
        WebDriverLogin.waitT(wd, 500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
        WebDriverLogin.waitT(wd, 4000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Copy Successful"))
    		result += -2000;
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
        WebDriverLogin.waitT(wd, 4000);
        //
        
        //
        WebDriverLogin.searchBoxRange(wd, "900007", "900007");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
        WebDriverLogin.waitT(wd, 1500);
        wd.findElement(By.cssSelector("#__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages > span")).click();
        WebDriverLogin.waitT(wd, 1000);
        result += options(wd, false);
        WebDriverLogin.waitT(wd, 500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Close")).click();
        WebDriverLogin.waitT(wd, 2000);
        
        wd.quit();
        System.exit(result);
	}
	
	public static int copyOneBox(ChromeDriver wd) throws Exception
    {
		WebDriverLogin.waitT(wd, 1000);
    	int result = 0;
    	
        if(!wd.findElement(By.id("uxChkResetMsgAll")).isSelected()) {
            wd.findElement(By.id("uxChkResetMsgAll")).click();
        }
        
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetMaxMessages")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetMaxMessages")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetMaxMessageLength")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetMaxMessageLength")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetDelMessageRet")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetDelMessageRet")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetRRMessages")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetRRMessages")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetNewMessageRet")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetNewMessageRet")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetSavedMessageRet")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetSavedMessageRet")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetMakeMessage")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetMakeMessage")).click();
        else
        	result += -2;

        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetAnswerMessage")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetAnswerMessage")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetMessageDelivery")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetMessageDelivery")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetAutoPlay")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetAutoPlay")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetRemoveDateTime")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetRemoveDateTime")).click();
        else
        	result += -2;
        //}
        
        
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetForwardMessage")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetForwardMessage")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetGetFIFO")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetGetFIFO")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("uxChkResetCMP")).isSelected())
            wd.findElement(By.id("uxChkResetCMP")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetQuickPlay")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetQuickPlay")).click();
        else
        	result += -2;
        wd.findElement(By.linkText("Caller Services")).click();
        WebDriverLogin.waitT(wd, 1000);
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetCallerServices_uxChkResetRemoveRecordMessage")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetCallerServices_uxChkResetRemoveRecordMessage")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetCallerServices_uxChkResetUrgent")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetCallerServices_uxChkResetUrgent")).click();
        else
        	result += -2;
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetCallerServices_uxChkResetMessageEdit")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetCallerServices_uxChkResetMessageEdit")).click();
        else
        	result += -2;
        WebDriverLogin.waitT(wd, 1000);
        if(wd.findElement(By.id("uxChkResetMsgAll")).isSelected()) 
        {
            wd.findElement(By.id("uxChkResetMsgAll")).click();
            WebDriverLogin.waitT(wd, 250);
            wd.findElement(By.id("uxChkResetMsgAll")).click();
        }
        
        WebDriverLogin.waitT(wd, 1000);
        return result;
    }
	
	public static int options(ChromeDriver wd, boolean state)
	{
		int result = 0;
		
		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMakeMessage")).isSelected())
            result += -10;
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsForwardMessage")).isSelected())
            result += -10;
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAnswerMessage")).isSelected())
            result += -10;
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsContinuousMsgPlay")).isSelected())
            result += -10;
        
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMsgQuickPlay")).isSelected() && state == true)
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMsgQuickPlay")).click();
        else if(state == true || state == false && !wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMsgQuickPlay")).isSelected())
        	result += -10;
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMsgDelivery")).isSelected() && state == true)
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMsgDelivery")).click();
        else if(state == true || state == false && !wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMsgDelivery")).isSelected())
        	result += -10;
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsRemoveHeader")).isSelected() && state == true)
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsRemoveHeader")).click();
        else if(state == true || state == false && !wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsRemoveHeader")).isSelected())
        	result += -10;
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAutoMsgPlay")).isSelected() && state == true)
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAutoMsgPlay")).click();
        else if(state == true || state == false && !wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAutoMsgPlay")).isSelected())
        	result += -10;
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsGetFIFO")).isSelected() && state == true)
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsGetFIFO")).click();
        else if(state == true || state == false && !wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsGetFIFO")).isSelected())
        	result += -10;
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsRemovePrompt")).isSelected() && state == true)
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsRemovePrompt")).click();
        else if(state == true || state == false && !wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsRemovePrompt")).isSelected())
        	result += -10;
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsMsgEditing")).isSelected() && state == true)
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsMsgEditing")).click();
        else if(state == true || state == false && !wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsMsgEditing")).isSelected())
        	result += -10;
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg")).isSelected() && state == true)
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg")).click();
        else if(state == true || state == false && !wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg")).isSelected())
        	result += -10;
        
        String value = "";
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParams_MaxNumMessages")).getAttribute("value");
        if(!value.contains("599"))
        	result += -10;
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsMaxMsgLenth")).getAttribute("value");
        if(!value.contains("4"))
        	result += -10;
        value = wd.findElement(By.id("uxTxtMessageParamsNewMsgRetention")).getAttribute("value");
        if(!value.contains("99"))
        	result += -10;
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsSavedMsgRetention")).getAttribute("value");
        if(!value.contains("99"))
        	result += -10;
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsDeletedMsgRetention")).getAttribute("value");
        if(!value.contains("99"))
        	result += -10;
        
		return result;
	}
}
