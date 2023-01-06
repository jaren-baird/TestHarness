
package CopyBox;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T14346_CopyVMsMulti 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14346_CopyVMsMulti-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			result += WebDriverLogin.resetMessages(wd, "900006", "900008");
			WebDriverLogin.searchBoxRange(wd, "900006", "900008", 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_tab")).click();
	        WebDriverLogin.waitT(wd, 2500);
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
	        	result += fail();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Close")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        //
	        WebDriverLogin.searchBoxRange(wd, "900006", "900008", 3000);
	        if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected()) 
	        {
	        	wd.findElement(By.id("uxChkboxsrtpr")).click();
	        	if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).isSelected()) 
	        		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Copy")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).sendKeys("900006");
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.linkText("Messages")).click();
	        result += copyOneBox(wd);
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Copy Successful"))
	        {
	        	WebDriverLogin.waitT(wd, 15000);
	        	if(!wd.findElement(By.tagName("html")).getText().contains("Copy Successful"))
		    		result += -2000;
	        }
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        //
	        result += checkBoxes(wd, "900007");
	        result += checkBoxes(wd, "900008");
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
	
	public static int checkBoxes(ChromeDriver wd, String box) throws InterruptedException
	{
		int result = 0;
		
		WebDriverLogin.searchBoxRange(wd, box, box, 2500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
        WebDriverLogin.waitT(wd, 2500);
        wd.findElement(By.cssSelector("#__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages > span")).click();
        WebDriverLogin.waitT(wd, 2500);
        result += options(wd, false);
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Close")).click();
        WebDriverLogin.waitT(wd, 2000);
		
		return result;
	}
	
	public static int copyOneBox(ChromeDriver wd) throws Exception
    {
		WebDriverLogin.waitT(wd, 2500);
    	int result = 0;
    	
        if(!wd.findElement(By.id("uxChkResetMsgAll")).isSelected()) {
            wd.findElement(By.id("uxChkResetMsgAll")).click();
        }
        
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetMaxMessages")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetMaxMessages")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetMaxMessageLength")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetMaxMessageLength")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetDelMessageRet")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetDelMessageRet")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetRRMessages")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetRRMessages")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetNewMessageRet")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetNewMessageRet")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetSavedMessageRet")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetSavedMessageRet")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetMakeMessage")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetMakeMessage")).click();
        else
        	result += fail();

        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetAnswerMessage")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetAnswerMessage")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetMessageDelivery")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetMessageDelivery")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetAutoPlay")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetAutoPlay")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetRemoveDateTime")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetRemoveDateTime")).click();
        else
        	result += fail();
        //}
        
        
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetForwardMessage")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetForwardMessage")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetGetFIFO")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetGetFIFO")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("uxChkResetCMP")).isSelected())
            wd.findElement(By.id("uxChkResetCMP")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetQuickPlay")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetQuickPlay")).click();
        else
        	result += fail();
        wd.findElement(By.linkText("Caller Services")).click();
        WebDriverLogin.waitT(wd, 2500);
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetCallerServices_uxChkResetRemoveRecordMessage")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetCallerServices_uxChkResetRemoveRecordMessage")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetCallerServices_uxChkResetUrgent")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetCallerServices_uxChkResetUrgent")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetCallerServices_uxChkResetMessageEdit")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetCallerServices_uxChkResetMessageEdit")).click();
        else
        	result += fail();
        
        WebDriverLogin.waitT(wd, 2500);
        
        if(wd.findElement(By.id("uxChkResetMsgAll")).isSelected()) 
        {
        	
    		wd.findElement(By.id("uxChkResetMsgAll")).click();
    		WebDriverLogin.waitT(wd, 500);
        	wd.findElement(By.id("uxChkResetMsgAll")).click();
        	WebDriverLogin.waitT(wd, 250);
        	if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetMaxMessages")).isSelected()) 
        		wd.findElement(By.id("uxChkResetMsgAll")).click();
        	
        }
        else
        	wd.findElement(By.id("uxChkResetMsgAll")).click();
        
        
        WebDriverLogin.waitT(wd, 2500);
        return result;
    }
	
	public static int options(ChromeDriver wd, boolean state)
	{
		int result = 0;
		WebDriverLogin.waitT(wd, 1500);
		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMakeMessage")).isSelected())
            result += fail();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsForwardMessage")).isSelected())
            result += fail();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAnswerMessage")).isSelected())
            result += fail();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsContinuousMsgPlay")).isSelected())
            result += fail();
        
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMsgQuickPlay")).isSelected() && state == true)
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMsgQuickPlay")).click();
        else if(state == true || state == false && !wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMsgQuickPlay")).isSelected())
        	result += fail();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMsgDelivery")).isSelected() && state == true)
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMsgDelivery")).click();
        else if(state == true || state == false && !wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMsgDelivery")).isSelected())
        	result += fail();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsRemoveHeader")).isSelected() && state == true)
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsRemoveHeader")).click();
        else if(state == true || state == false && !wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsRemoveHeader")).isSelected())
        	result += fail();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAutoMsgPlay")).isSelected() && state == true)
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAutoMsgPlay")).click();
        else if(state == true || state == false && !wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAutoMsgPlay")).isSelected())
        	result += fail();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsGetFIFO")).isSelected() && state == true)
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsGetFIFO")).click();
        else if(state == true || state == false && !wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsGetFIFO")).isSelected())
        	result += fail();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsRemovePrompt")).isSelected() && state == true)
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsRemovePrompt")).click();
        else if(state == true || state == false && !wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsRemovePrompt")).isSelected())
        	result += fail();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsMsgEditing")).isSelected() && state == true)
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsMsgEditing")).click();
        else if(state == true || state == false && !wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsMsgEditing")).isSelected())
        	result += fail();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg")).isSelected() && state == true)
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg")).click();
        else if(state == true || state == false && !wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg")).isSelected())
        	result += fail();
        
        String value = "";
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParams_MaxNumMessages")).getAttribute("value");
        if(!value.contains("599"))
        	result += fail();
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsMaxMsgLenth")).getAttribute("value");
        if(!value.contains("4"))
        	result += fail();
        value = wd.findElement(By.id("uxTxtMessageParamsNewMsgRetention")).getAttribute("value");
        if(!value.contains("99"))
        	result += fail();
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsSavedMsgRetention")).getAttribute("value");
        if(!value.contains("99"))
        	result += fail();
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsDeletedMsgRetention")).getAttribute("value");
        if(!value.contains("99"))
        	result += fail();
        
		return result;
	}
	
	public static int fail()
	{
		return -10;
	}
}
