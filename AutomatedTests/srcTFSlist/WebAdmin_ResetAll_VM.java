
import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebAdmin_ResetAll_VM 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//1WebAdmin_ResetAll_VM-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//resetBoxAll(wd, "900006", "900006");
			//not using the standard function here because our purpose is to find bugs without using work around fixes found in the webdriverlogin
			resetBoxAll(wd, "900006", "900006"); 
			WebDriverLogin.enableBoxRange(wd, "900006", "900025");
			WebDriverLogin.searchBoxRange(wd, "900006", "900006");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
			result += VRecVM(wd);
			result += MSGsettingsVM(wd);
			result += DListTab(wd);
	        result += TeleNotif(wd);
	        result += CallOptions(wd);
	        result += VMconnectivity(wd);
	        result += VMAudioGrt(wd);
	        result += VMOutboundD(wd);
	        result += FaxesVM(wd);
			
	        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        WebDriverLogin.searchBoxRange(wd, "900006", "900006");
	    	if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        result += checkReset(wd);
	        WebDriverLogin.waitT(wd, 500);
	        resetBoxAll(wd, "900006", "900006");
	        //
	        result += checkBoxes(wd, "900006");
	        
	        wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += resultException();
			ex.printStackTrace();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		//
		
        System.exit(result);
	}
	
	public static int checkBoxes(ChromeDriver wd, String box) throws InterruptedException
	{
		int result = 0;
		
		WebDriverLogin.searchBoxRange(wd, box, box);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
        WebDriverLogin.waitT(wd, 2000);
		result += checkMSGsettingsVM(wd);
		result += checkDListTab(wd);
        result += checkTeleNotif(wd);
        result += checkCallOptions(wd);
        result += checkVMconnectivity(wd);
        result += checkVMAudioGrt(wd);
        result += checkVMOutboundD(wd);
        result += checkVRec(wd);
        result += checkFaxesVM(wd);
        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
        
		return result;
	}
	
	public static int checkMSGsettingsVM(ChromeDriver wd)
	{
		int result = 0;
		
		try
		{
			WebDriverLogin.waitT(wd, 1000);
			wd.findElement(By.linkText("Messages")).click();
			WebDriverLogin.waitT(wd, 1500);
			//default on 
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMakeMessage")).isSelected())
	            result += resultFailure();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsForwardMessage")).isSelected())
	            result += resultFailure();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAnswerMessage")).isSelected())
	            result += resultFailure();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsContinuousMsgPlay")).isSelected())
	            result += resultFailure();
	        //default off
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMsgQuickPlay")).isSelected())
	        	result += resultFailure();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMsgDelivery")).isSelected())
	        	result += resultFailure();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsRemoveHeader")).isSelected())
	        	result += resultFailure();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAutoMsgPlay")).isSelected())
	        	result += resultFailure();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsGetFIFO")).isSelected())
	        	result += resultFailure();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsRemovePrompt")).isSelected())
	        	result += resultFailure();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsMsgEditing")).isSelected())
	        	result += resultFailure();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg")).isSelected())
	        	result += resultFailure();
	        
	        String value = "";
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParams_MaxNumMessages")).getAttribute("value");
	        if(value.contains("599"))
	        	result += resultFailure();
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsMaxMsgLenth")).getAttribute("value");
	        if(value.contains("4"))
	        	result += resultFailure();
	        value = wd.findElement(By.id("uxTxtMessageParamsNewMsgRetention")).getAttribute("value");
	        if(value.contains("99"))
	        	result += resultFailure();
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsSavedMsgRetention")).getAttribute("value");
	        if(value.contains("99"))
	        	result += resultFailure();
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxTxtMessageParamsDeletedMsgRetention")).getAttribute("value");
	        if(value.contains("99"))
	        	result += resultFailure();
	        WebDriverLogin.waitT(wd, 500);
		}
		catch(Exception ex)
		{
			result += resultException();
		}
		
		return result;
	}
	
	public static int checkFaxesVM(ChromeDriver wd)
	{
		int result = 0;
		
		try
		{
			WebDriverLogin.waitT(wd, 500);
			wd.findElement(By.linkText("Faxes")).click();
			WebDriverLogin.waitT(wd, 1500);
	        //default off
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParamsNewFaxRetentionPerm")).isSelected())
	        	result += resultFailure();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParamsSavedFaxRetentionPerm")).isSelected())
	        	result += resultFailure();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParamsDelFaxRetentionPerm")).isSelected())
	        	result += resultFailure();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParametersFaxStoreForward")).isSelected())
	        	result += resultFailure();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParametersSeperateCallFaxing")).isSelected())
	        	result += resultFailure();
	        //
	        String value = "";
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsMaxNumFaxes")).getAttribute("value");
	        if(value.contains("254"))
	        	result += resultFailure();
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsNewFaxRetention")).getAttribute("value");
	        if(value.contains("13"))
	        	result += resultFailure();
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsSavedFaxRetention")).getAttribute("value");
	        if(value.contains("13"))
	        	result += resultFailure();
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsDelFaxRetention")).getAttribute("value");
	        if(value.contains("6"))
	        	result += resultFailure();
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsCustSubscriberId")).getAttribute("value");
	        if(value.contains("555"))
	        	result += resultFailure();
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsLocalFaxNumber")).getAttribute("value");
	        if(value.contains("555"))
	        	result += resultFailure();
	        
	        WebDriverLogin.waitT(wd, 500);
		}
		catch(Exception ex)
		{
			//result += resultException();
		}
		
		return result;
	}

	public static int checkDListTab(ChromeDriver wd)
	{
		int result = 0;
		String value = "";
		
		try
		{
			wd.findElement(By.linkText("Dist. Lists")).click();
			WebDriverLogin.waitT(wd, 2000);
	        value = wd.findElement(By.tagName("html")).getText();
	        if(value.contains("DList11"))
	        	result += resultFailure();
		}
		catch(Exception ex)
		{
			result += resultException();
		}
		
		return result;
	}
	
	public static int checkTeleNotif(ChromeDriver wd)
	{
		int result = 0;
		
		try
		{
			WebDriverLogin.waitT(wd, 1000);
			wd.findElement(By.linkText("Notifications")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        
	        String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_lb_NotificationType1")).getText();
	        if(!value.contains("--Empty--"))
	        	result += resultFailure();
		}
		catch(Exception ex)
		{
			result += resultException();
		}
		
		return result;
	}
	
	public static int checkCallOptions(ChromeDriver wd)
	{
		int result = 0;
		String value = "";
		
		try
		{
			WebDriverLogin.waitT(wd, 1500);
			wd.findElement(By.linkText("Call Options")).click();
	        WebDriverLogin.waitT(wd, 3500);
	        //default on
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkExitToOtherBox")).isSelected())
	            result += resultFailure();
	        //default off
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkCO_RoutingOptions")).isSelected())
	        	result += resultFailure();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkSpeed_SpeedDial")).isSelected())
	        	result += resultFailure();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkCO_SuperviseCalls")).isSelected())
	        	result += resultFailure();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkRemovePromptThankYou")).isSelected())
	        	result += resultFailure();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkOriginalMessage")).isSelected())
	        	result += resultFailure();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkCallBackSender")).isSelected())
	        	result += resultFailure();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkCallScreening")).isSelected())
	        	result += resultFailure();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkExtendedMailbox")).isSelected())
	        	result += resultFailure();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkRemoveCallTransferPrompts")).isSelected())
	        	result += resultFailure();
	        WebDriverLogin.waitT(wd, 500);
		}
		catch(Exception ex)
		{
			result += resultException();
		}
		
		return result;
	}
	
	public static int checkVMconnectivity(ChromeDriver wd)
	{
		int result = 0;
		String value = "";
		
		try
		{
			wd.findElement(By.linkText("Connectivity")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxTxtEmailSettingsServerAddress")).getAttribute("value");
	        if(value.contains("fake.address.com"))
	        	result += resultFailure();
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxTxtEmailSettingsUserName")).getAttribute("value");
	        if(value.contains("username"))
	        	result += resultFailure();
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxTxtEmailSettingsEmailAddress")).getAttribute("value");
	        if(value.contains("fake@email.com"))
	        	result += resultFailure();
	        
	        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxDdlConnectivityRightsLevel")));
			WebElement option = select.getFirstSelectedOption();
			value = option.getText();
			if(value.contains("Power User"))
	        	result += resultFailure();
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxChkGlobalFuntionalityGlobalExt")).isSelected())
	        	result += resultFailure();
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxChkGlobalFunctionalityGlobalMwi")).isSelected())
	        	result += resultFailure();
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxChkGlobalFunctionalityGlobalNotification")).isSelected())
	        	result += resultFailure();
			WebDriverLogin.waitT(wd, 500);
		}
		catch(Exception ex)
		{
			result += resultException();
		}
		
		return result;
	}
	
	public static int checkVMAudioGrt(ChromeDriver wd)
	{
		int result = 0;
		String value = "";
		
		try
		{
			wd.findElement(By.linkText("Greetings")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Time Blocks Scheduling")) 
			{
				WebDriverLogin.waitT(wd, 12500);
				if(!wd.findElement(By.tagName("html")).getText().contains("Time Blocks Scheduling")) 
					WebDriverLogin.waitT(wd, 35000);
			}
	        
	        
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxTxtGreetingLength")).getAttribute("value");
	        if(value.contains("120"))
	        	result += resultFailure();
	        
	        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreetingMaxNumGreetings")));
			WebElement option = select.getFirstSelectedOption();
			value = option.getText();
			if(value.contains("9"))
	        	result += resultFailure();
			select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudDefGreeting")));
			option = select.getFirstSelectedOption();
			value = option.getText();
			if(value.contains("2"))
	        	result += resultFailure();
			select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudBusyGreeting")));
			option = select.getFirstSelectedOption();
			value = option.getText();
			if(value.contains("3"))
	        	result += resultFailure();
			select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudNoAnsGreeting")));
			option = select.getFirstSelectedOption();
			value = option.getText();
			if(value.contains("4"))
	        	result += resultFailure();
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkGreetingGrtPassNameEdit")).isSelected())
	        	result += resultFailure();
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkGreetingMultiLangGreetings")).isSelected())
	        	result += resultFailure();
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkGreetingPromptCallerLanguage")).isSelected())
	        	result += resultFailure();
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkGreetingKeepLanguage")).isSelected())
	        	result += resultFailure();
			WebDriverLogin.waitT(wd, 500);
	        //
		}
		catch(Exception ex)
		{
			result += resultException();
		}
		
		return result;
	}
	
	public static int checkVMOutboundD(ChromeDriver wd)
	{
		int result = 0;
		
		try
		{
			WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.linkText("Outbound Delivery")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        if(wd.findElement(By.id("uxChkMessageFaxBroadcast")).isSelected())
	        	result += resultFailure();
	        if(wd.findElement(By.id("uxChkImmediateBroadcast")).isSelected())
	        	result += resultFailure();
	        String value = "";
	        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmOutboundDelivery_ucVmOutboundDelivery_uxDdlDeliveryAttempts")));
			WebElement option = select.getFirstSelectedOption();
			value = option.getText();
			if(value.contains("3"))
	        	result += resultFailure();
			select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmOutboundDelivery_ucVmOutboundDelivery_uxDdlOutboundDel_Hour")));
			option = select.getFirstSelectedOption();
			value = option.getText();
			if(value.contains("5"))
	        	result += resultFailure();
	        WebDriverLogin.waitT(wd, 500);
		}
		catch(Exception ex)
		{
			result += resultException();
		}
		
		return result;
	}
	
	public static int checkVRec(ChromeDriver wd)
	{
		int result = 0;
		
		try
		{
	        
	        wd.findElement(By.linkText("Voice Rec.")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        String value = "";
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_NickName")).getAttribute("value");
	        if(value.contains("Stone Cold"))
	            result += resultFailure();
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName1")).getAttribute("value");
			if(value.contains("Steve Austin")) 
				result += resultFailure();
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName2")).getAttribute("value");
			if(value.contains("The Viper")) 
				result += resultFailure();
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName3")).getAttribute("value");
			if(value.contains("Randy Orton")) 
				result += resultFailure();
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName4")).getAttribute("value");
			if(value.contains("Big Guy Bain")) 
				result += resultFailure();
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName5")).getAttribute("value");
			if(value.contains("Hulk Hogan")) 
				result += resultFailure();
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName6")).getAttribute("value");
			if(value.contains("John Cena")) 
				result += resultFailure();
		}
		catch(Exception ex)
		{
			result += resultException();
		}
		
		return result;
	}
	
	
	
	
	public static int MSGsettingsVM(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		
		wd.findElement(By.linkText("Messages")).click();
        WebDriverLogin.waitT(wd, 1500);
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
        
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMsgQuickPlay")).isSelected())
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMsgQuickPlay")).click();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMsgDelivery")).isSelected())
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMsgDelivery")).click();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsRemoveHeader")).isSelected())
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsRemoveHeader")).click();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAutoMsgPlay")).isSelected())
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAutoMsgPlay")).click();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsGetFIFO")).isSelected())
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsGetFIFO")).click();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsRemovePrompt")).isSelected())
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsRemovePrompt")).click();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsMsgEditing")).isSelected())
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsMsgEditing")).click();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg")).isSelected())
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg")).click();
        //default on
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMakeMessage")).isSelected())
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMakeMessage")).click();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsForwardMessage")).isSelected())
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsForwardMessage")).click();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAnswerMessage")).isSelected())
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAnswerMessage")).click();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsContinuousMsgPlay")).isSelected())
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsContinuousMsgPlay")).click();
        
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Submit")).click();
        WebDriverLogin.waitT(wd, 4000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
        	result += resultFailure();
		
		return result;
	}
	
	public static int FaxesVM(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		try
		{
			wd.findElement(By.linkText("Faxes")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsMaxNumFaxes")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsMaxNumFaxes")).sendKeys("255");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsNewFaxRetention")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsNewFaxRetention")).sendKeys("13");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsSavedFaxRetention")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsSavedFaxRetention")).sendKeys("13");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsDelFaxRetention")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsDelFaxRetention")).sendKeys("6");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsCustSubscriberId")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsCustSubscriberId")).sendKeys("555");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsLocalFaxNumber")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxTxtFaxParamsLocalFaxNumber")).sendKeys("555");
	        WebDriverLogin.waitT(wd, 500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParamsNewFaxRetentionPerm")).isSelected())
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParamsNewFaxRetentionPerm")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParamsSavedFaxRetentionPerm")).isSelected())
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParamsSavedFaxRetentionPerm")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParamsDelFaxRetentionPerm")).isSelected())
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParamsDelFaxRetentionPerm")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParametersFaxStoreForward")).isSelected())
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParametersFaxStoreForward")).click();
	        WebDriverLogin.waitT(wd, 500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParametersSeperateCallFaxing")).isSelected())
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxChkFaxParametersSeperateCallFaxing")).click();
	        
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxBtnFaxSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
	        	result += resultFailure();
		}
		catch(Exception ex)
		{
			result += resultException();
		}
		
		return result;
	}
	
	public static int DListTab(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		
		wd.findElement(By.linkText("Dist. Lists")).click();
        WebDriverLogin.waitT(wd, 1500);
	    if(!wd.findElement(By.tagName("html")).getText().contains("DList11"))
        {
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
            WebDriverLogin.waitT(wd, 2000);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys("DList11");
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys("11");
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
            WebDriverLogin.waitT(wd, 2000);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("900007");
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("900017");
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
            WebDriverLogin.waitT(wd, 2000);
			wd.findElement(By.id("uxChkDlistInternalSrch")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
			WebDriverLogin.waitT(wd, 2500);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
            WebDriverLogin.waitT(wd, 2500);
            
	        if(!wd.findElement(By.tagName("html")).getText().contains("DList11"))
	        	result += -2002;          
	    }
		
        if(!wd.findElement(By.id("uxChkDListControlService")).isSelected()) 
    		wd.findElement(By.id("uxChkDListControlService")).click();
        if(!wd.findElement(By.id("uxChkGlobalDListRightsService")).isSelected()) 
    		wd.findElement(By.id("uxChkGlobalDListRightsService")).click();
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxBtnDListService_Submit")).click();
        WebDriverLogin.waitT(wd, 4000);
        while(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
        	result += resultFailure();
		
		return result;
	}
	
	public static int TeleNotif(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		
		wd.findElement(By.linkText("Notifications")).click();
        WebDriverLogin.waitT(wd, 1500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationOne")).click();
        WebDriverLogin.waitT(wd, 1500);
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).isSelected()) 
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).click();
        //
        WebDriverLogin.waitT(wd, 1000);
        forceValue(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_DialingString", "1007");
        forceValue(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_OwnerProgrammableNumber", "4");
        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxDdlTelePager_OwnerProgDigits", "5");
        forceValue(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_NumOfMsgs", "5");
        forceValue(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_NumOfAttempts", "2");
        //
        WebDriverLogin.waitT(wd, 250);
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkTelePager_IgnoreDistMsgs")).isSelected()) 
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkTelePager_IgnoreDistMsgs")).click();
        WebDriverLogin.waitT(wd, 250);
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkQueueStartEndTime")).isSelected()) 
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkQueueStartEndTime")).click();
        //
        WebDriverLogin.waitT(wd, 250);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxDdlStartTimeHour")).sendKeys("5");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxDdlEndTimeHour")).sendKeys("5");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxDdlDelayHour")).sendKeys("1");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxDdlRetryHour")).sendKeys("1");
        //
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkSunday")).isSelected()) 
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkSunday")).click();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkSaturday")).isSelected()) 
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkSaturday")).click();
        //
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxBtnTelephonePagerSubmit")).click();
        WebDriverLogin.waitT(wd, 4000);
        if(!wd.findElement(By.tagName("html")).getText().toLowerCase().contains("changes accepted"))
    		result += -2000;
		
		return result;
	}
	
	public static int CallOptions(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		int j = 0;
		try
		{
			wd.findElement(By.linkText("Call Options")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        
	        for(int i = 0; i < 10; i++)
	        {
	        	try
	        	{
		        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtRoutingOptions_Key")).clear();
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtRoutingOptions_Key")).sendKeys(""+i);
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtRoutingOptions_Number")).clear();
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtRoutingOptions_Number")).sendKeys(""+(i+900005));
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxLbAddRoutingOptions")).click();
		            WebDriverLogin.waitT(wd, 2500+(100*i)+(2000*j));
	        	}
	            catch(Exception ex)
	            {
	            	j++;
	            	WebDriverLogin.waitT(wd, 2500+(2000*j));
	            	i--;
	            	result += resultFailure();
	            	System.out.println("Routing Options slow page update caused exception thrown: " + j);
	            }
	        }
	        
	        WebDriverLogin.waitT(wd, 2500+(2000*j));
	        //default on
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkExitToOtherBox")).isSelected())
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkExitToOtherBox")).click();
	        //default off
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkCO_RoutingOptions")).isSelected())
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkCO_RoutingOptions")).click();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkSpeed_SpeedDial")).isSelected())
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkSpeed_SpeedDial")).click();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkCO_SuperviseCalls")).isSelected())
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkCO_SuperviseCalls")).click();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkRemovePromptThankYou")).isSelected())
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkRemovePromptThankYou")).click();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkOriginalMessage")).isSelected())
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkOriginalMessage")).click();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkCallBackSender")).isSelected())
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkCallBackSender")).click();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkCallScreening")).isSelected())
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkCallScreening")).click();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkExtendedMailbox")).isSelected())
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkExtendedMailbox")).click();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkRemoveCallTransferPrompts")).isSelected())
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkRemoveCallTransferPrompts")).click();
	        //
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxBtnCOSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
	        	result += resultFailure();
		}
		catch(Exception ex)
		{
			result += resultException();
		}
		return result;
	}
	
	public static int VMconnectivity(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		
		wd.findElement(By.linkText("Connectivity")).click();
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
        	result += resultFailure();
		
		return result;
	}
	
	public static int VMAudioGrt(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		
		WebDriverLogin.waitT(wd, 500);
		wd.findElement(By.linkText("Greetings")).click();
        WebDriverLogin.waitT(wd, 2000);
        
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxTxtGreetingLength")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxTxtGreetingLength")).sendKeys("120");
        
        WebDriverLogin.waitT(wd, 250);
        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreetingMaxNumGreetings", "9");
        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudDefGreeting", "2");
        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudBusyGreeting", "3");
        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudNoAnsGreeting", "4");
        WebDriverLogin.waitT(wd, 250);
        
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkGreetingGrtPassNameEdit")).isSelected()) 
        {
        	result += resultFailure();
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkGreetingGrtPassNameEdit")).click();
        }
        
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsSubmit")).click();
        WebDriverLogin.waitT(wd, 4000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
        	result += resultFailure();
		
		return result;
	}
	
	public static int VRecVM(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		
        wd.findElement(By.linkText("Voice Rec.")).click();
        WebDriverLogin.waitT(wd, 1500);
        CheckNames(wd);
        WebDriverLogin.waitT(wd, 500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxBtnVoiceRec_Submit")).click();
        WebDriverLogin.waitT(wd, 4000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
        	result += resultFailure();
        
		return result;
	}
	
	public static int VMOutboundD(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		
		wd.findElement(By.linkText("Outbound Delivery")).click();
        WebDriverLogin.waitT(wd, 1000);
        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmOutboundDelivery_ucVmOutboundDelivery_uxDdlDeliveryAttempts", "3");
        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmOutboundDelivery_ucVmOutboundDelivery_uxDdlOutboundDel_Hour", "5");
        if(!wd.findElement(By.id("uxChkMessageFaxBroadcast")).isSelected()) 
    		wd.findElement(By.id("uxChkMessageFaxBroadcast")).click();
        WebDriverLogin.waitT(wd, 1500);
        if(!wd.findElement(By.id("uxChkImmediateBroadcast")).isSelected()) 
    		wd.findElement(By.id("uxChkImmediateBroadcast")).click();
        WebDriverLogin.waitT(wd, 500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmOutboundDelivery_ucVmOutboundDelivery_uxBtnOutboundDelSubmit")).click();
        WebDriverLogin.waitT(wd, 4000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
        	result += resultFailure();
		
		return result;
	}
	
	public static void forceChange(ChromeDriver wd, String field, String value)
	{
		Select select = new Select(wd.findElement(By.id(field)));
		WebElement option = select.getFirstSelectedOption();
		String valueX = option.getText();
		try
		{
			while(!valueX.contains(value))
			{
				wd.findElement(By.id(field)).sendKeys(value);
				WebDriverLogin.waitT(wd, 1000);
				wd.findElement(By.id("loggedin_user_control")).click();
				WebDriverLogin.waitT(wd, 1000);
				select = new Select(wd.findElement(By.id(field)));
				option = select.getFirstSelectedOption();
				valueX = option.getText();
			}
		}
		catch (Exception ex){}
	}
	
	public static void forceValue(ChromeDriver wd, String field, String value)
	{
		String valueX = wd.findElement(By.id(field)).getAttribute("value");
		try
		{
			while(!valueX.contains(value))
			{
				wd.findElement(By.id(field)).clear();
				wd.findElement(By.id(field)).sendKeys(value);
				WebDriverLogin.waitT(wd, 250);
				wd.findElement(By.id("loggedin_user_control")).click();
				WebDriverLogin.waitT(wd, 250);
				valueX = wd.findElement(By.id(field)).getAttribute("value");
			}
		}
		catch (Exception ex){}
	}
	
	public static void CheckNames(ChromeDriver wd)
	{
		String value = "";
		try
		{
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_NickName")).getAttribute("value");
	        if(!value.contains("Stone Cold"))
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_NickName")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_NickName")).clear();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_NickName")).sendKeys("Stone Cold");
	        }
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName1")).getAttribute("value");
			if(!value.contains("Steve Austin")) 
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName1")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName1")).clear();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName1")).sendKeys("Steve Austin");
	        }
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName2")).getAttribute("value");
			if(!value.contains("The Viper")) 
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName2")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName2")).clear();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName2")).sendKeys("The Viper");
	        }
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName3")).getAttribute("value");
			if(!value.contains("Randy Orton")) 
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName3")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName3")).clear();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName3")).sendKeys("Randy Orton");
	        }
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName4")).getAttribute("value");
			if(!value.contains("Big Guy Bain")) 
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName4")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName4")).clear();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName4")).sendKeys("Big Guy Bain");
	        }
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName5")).getAttribute("value");
			if(!value.contains("Hulk Hogan")) 
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName5")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName5")).clear();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName5")).sendKeys("Hulk Hogan");
	        }
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName6")).getAttribute("value");
			if(!value.contains("John Cena")) 
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName6")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName6")).clear();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName6")).sendKeys("John Cena");
	        }
		}
		catch(Exception ex)
		{
			result += resultException();
		}
	}
	
	
	public static int checkReset(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		//
		WebDriverLogin.waitT(wd, 1000);
    	if(!wd.findElement(By.id("uxChkResetAll")).isSelected())
    	{
            wd.findElement(By.id("uxChkResetAll")).click();
            WebDriverLogin.waitT(wd, 250);
            wd.findElement(By.id("uxChkResetAll")).click();
    	}
    	else
    		wd.findElement(By.id("uxChkResetAll")).click();
    	
    	WebDriverLogin.waitT(wd, 1500);
		wd.findElement(By.linkText("Messages")).click();
		WebDriverLogin.waitT(wd, 1000);
		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetMaxMessages")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetMaxMessages")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetMaxMessageLength")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetMaxMessageLength")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetDelMessageRet")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetDelMessageRet")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetRRMessages")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetRRMessages")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetNewMessageRet")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetNewMessageRet")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetSavedMessageRet")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetSavedMessageRet")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetMakeMessage")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetMakeMessage")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetAnswerMessage")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetAnswerMessage")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetMessageDelivery")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetMessageDelivery")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetAutoPlay")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetAutoPlay")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetRemoveDateTime")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetRemoveDateTime")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetForwardMessage")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetForwardMessage")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetGetFIFO")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetGetFIFO")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("uxChkResetCMP")).isSelected())
            wd.findElement(By.id("uxChkResetCMP")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetQuickPlay")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetOwnerServices_uxChkResetQuickPlay")).click();
        else
        	resultFailure();
        wd.findElement(By.linkText("Caller Services")).click();
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetCallerServices_uxChkResetRemoveRecordMessage")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetCallerServices_uxChkResetRemoveRecordMessage")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetCallerServices_uxChkResetUrgent")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetCallerServices_uxChkResetUrgent")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetCallerServices_uxChkResetMessageEdit")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxTabContainerResetServices_uxTpResetCallerServices_uxChkResetMessageEdit")).click();
        else
        	resultFailure();
        WebDriverLogin.waitT(wd, 1000);
        //
        //
        wd.findElement(By.linkText("Faxes")).click();
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetMaxFaxes")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetMaxFaxes")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetNewFaxRet")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetNewFaxRet")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetSavedFaxRet")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetSavedFaxRet")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetDelFaxRet")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetDelFaxRet")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetLocalFaxNumber")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetLocalFaxNumber")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("uxChkResetFaxStoreForward")).isSelected())
            wd.findElement(By.id("uxChkResetFaxStoreForward")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetSepCallFaxing")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetSepCallFaxing")).click();
        else
        	resultFailure();

        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetCustSubID")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetCustSubID")).click();
        else
        	resultFailure();
        //
        //
        wd.findElement(By.linkText("Distribution Lists")).click();
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetDList_UcxResetDlist_uxChkResetLocalDList")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetDList_UcxResetDlist_uxChkResetLocalDList")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("uxChkResetDListControl")).isSelected())
            wd.findElement(By.id("uxChkResetDListControl")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("uxChkResetDListRights")).isSelected())
            wd.findElement(By.id("uxChkResetDListRights")).click();
        else
        	resultFailure();
        //
        //
        wd.findElement(By.linkText("Notifications")).click();
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetNotifPlans")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetNotifPlans")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetNotifCtrl")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetNotifCtrl")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetWakeupCtrl")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetWakeupCtrl")).click();
        else
        	resultFailure();
        //
        //
        wd.findElement(By.linkText("Call Options")).click();//
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetOperatorBox")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetOperatorBox")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetNAOption")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetNAOption")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetBusyOption")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetBusyOption")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetRecordandXfr")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetRecordandXfr")).click();
        else
        	resultFailure();
        wd.findElement(By.linkText("Routing Options")).click();//
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.id("uxChkResetCallOptsPRO")).isSelected())
            wd.findElement(By.id("uxChkResetCallOptsPRO")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("uxChkResetCallOptsVRO")).isSelected())
            wd.findElement(By.id("uxChkResetCallOptsVRO")).click();
        else
        	resultFailure();
        wd.findElement(By.linkText("Speed Dial")).click();//
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.id("uxChkResetPrSpeedDial")).isSelected())
            wd.findElement(By.id("uxChkResetPrSpeedDial")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("uxChkResetSpeedDial")).isSelected())
            wd.findElement(By.id("uxChkResetSpeedDial")).click();
        else
        	resultFailure();
        wd.findElement(By.linkText("Call Queuing")).click();//
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.id("uxChkResetNumQueuedCallers")).isSelected())
            wd.findElement(By.id("uxChkResetNumQueuedCallers")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("uxChkResetAnnounceBox")).isSelected())
            wd.findElement(By.id("uxChkResetAnnounceBox")).click();
        else
        	resultFailure();
        wd.findElement(By.linkText("Call Supervision")).click();//
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.id("uxChkResetSupervise")).isSelected())
            wd.findElement(By.id("uxChkResetSupervise")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("uxChkRngsBeforeNoAns")).isSelected())
            wd.findElement(By.id("uxChkRngsBeforeNoAns")).click();
        else
        	resultFailure();
        wd.findElement(By.linkText("Services")).click();//
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.id("uxChkResetThanksforCalling")).isSelected())
            wd.findElement(By.id("uxChkResetThanksforCalling")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("uxChkResetOrigMessageOptionAlt")).isSelected())
            wd.findElement(By.id("uxChkResetOrigMessageOptionAlt")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("uxChkResetExitToOtherBox")).isSelected())
            wd.findElement(By.id("uxChkResetExitToOtherBox")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("uxChkResetCallBackExtSndr")).isSelected())
            wd.findElement(By.id("uxChkResetCallBackExtSndr")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("uxChkResetCallScreen")).isSelected())
            wd.findElement(By.id("uxChkResetCallScreen")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("uxChkResetXMA")).isSelected())
            wd.findElement(By.id("uxChkResetXMA")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("uxChkResetCallXfrPrmpts")).isSelected())
            wd.findElement(By.id("uxChkResetCallXfrPrmpts")).click();
        else
        	resultFailure();
        //
        //
        wd.findElement(By.linkText("Connectivity")).click();//
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxChkResetUserRights")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxChkResetUserRights")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxChkResetDUFA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxChkResetDUFA")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetServerAddr")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetServerAddr")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetUserName")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetUserName")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetUserPasswd")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetUserPasswd")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetEmailAddr")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetEmailAddr")).click();
        else
        	resultFailure();
        wd.findElement(By.linkText("Global Functionality")).click();//
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpGlobalFunctionality_uxChkResetGlobalExt")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpGlobalFunctionality_uxChkResetGlobalExt")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpGlobalFunctionality_uxChkResetGlobalMWI")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpGlobalFunctionality_uxChkResetGlobalMWI")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpGlobalFunctionality_uxChkResetGlobalNotif")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpGlobalFunctionality_uxChkResetGlobalNotif")).click();
        else
        	resultFailure();
        //
        //
        wd.findElement(By.linkText("Greetings")).click();//
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.linkText("Time Block Scheduling")).click();
        WebDriverLogin.waitT(wd, 500);
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtTimeBlock_uxChkResetTimeBlockSch")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtTimeBlock_uxChkResetTimeBlockSch")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtTimeBlock_uxChkResetDailySchedule")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtTimeBlock_uxChkResetDailySchedule")).click();
        else
        	resultFailure();
        wd.findElement(By.linkText("Audio Greetings")).click();//
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetGrtName")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetGrtName")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetGrtGreeting")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetGrtGreeting")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetGrtLength")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetGrtLength")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetMaxGreetings")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetMaxGreetings")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetDefGrt")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetDefGrt")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetBsyGrt")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetBsyGrt")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetGrtNAGrt")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetGrtNAGrt")).click();
        else
        	resultFailure();
        wd.findElement(By.linkText("Services")).click();
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtServices_uxChkResetMultiLangGrt")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtServices_uxChkResetMultiLangGrt")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtServices_uxChkResetGrtPromptCallerForLang")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtServices_uxChkResetGrtPromptCallerForLang")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtServices_uxChkResetGrtPCodeName")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtServices_uxChkResetGrtPCodeName")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtServices_uxChkResetGrtKeepLang")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtServices_uxChkResetGrtKeepLang")).click();
        else
        	resultFailure();
        //
        //
        wd.findElement(By.linkText("Outbound Delivery")).click();
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkDeliveryAttmpts")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkDeliveryAttmpts")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkDeliveryRxTime")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkDeliveryRxTime")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkMsgFaxBroadcast")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkMsgFaxBroadcast")).click();
        else
        	resultFailure();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkImmedBroadcast")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkImmedBroadcast")).click();
        else
        	resultFailure();
        //
        //
        wd.findElement(By.linkText("Voice Rec.")).click();
        WebDriverLogin.waitT(wd, 1000);
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetVoiceRec_uxChkResetVoRecNames")).isSelected())
        	resultFailure();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
    	WebDriverLogin.waitT(wd, 1000);
        
		return result;
	}
	
	public static int resetBoxAll(ChromeDriver wd, String startNum, String endNum) throws InterruptedException
    {//reset all available settings
		int result = 0;
		String rangeExtend = "0";
		
		try
		{
			for(int i = Integer.parseInt(startNum); i <= Integer.parseInt(endNum); i+=100)
			{
				if(Integer.parseInt(endNum)-i >= 100)
					rangeExtend = Integer.toString(i+99);
				else if(Integer.parseInt(endNum)-i >= 1 && Integer.parseInt(endNum)-i < 100)
					rangeExtend = endNum;
				else
					rangeExtend = Integer.toString(i);
				WebDriverLogin.waitT(wd, 1000);
				WebDriverLogin.enableBoxRange(wd, Integer.toString(i), rangeExtend);
				WebDriverLogin.searchBoxRange(wd, Integer.toString(i), rangeExtend, 1000);
				WebDriverLogin.waitT(wd, 1500);
			    //
				if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected())
				    wd.findElement(By.id("uxChkboxsrtpr")).click();
				if(!wd.findElement(By.tagName("html")).getText().contains("Reset")) {
				    System.out.println("");
				}
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
				if(!wd.findElement(By.tagName("html")).getText().contains("Reset Boxes")) {
				    System.out.println("");
				}
				WebDriverLogin.waitT(wd, 2500);
				if(!wd.findElement(By.id("uxChkResetAll")).isSelected()) {
				    wd.findElement(By.id("uxChkResetAll")).click();
				}
				if(!wd.findElement(By.tagName("html")).getText().contains("Submit")) {
				    System.out.println("");
				}
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
				WebDriverLogin.waitT(wd, 2500);
				if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
				{
					WebDriverLogin.waitT(wd, 12500);
					if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
						result += resultFailure();
				}
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
				WebDriverLogin.waitT(wd, 2000);
			}
		}
		catch(Exception ex)
		{
			result += resultException();
		}
		
		return result;
    }
	
	public static int resultFailure()
	{
		int result = -10;
		return result;
	}
	public static int resultException()
	{
		int result = -109;
		return result;
	}
}
