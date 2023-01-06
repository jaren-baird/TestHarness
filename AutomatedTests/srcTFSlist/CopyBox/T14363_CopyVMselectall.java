
package CopyBox;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T14363_CopyVMselectall 
{
	private static int result = 9;
	private static int exception = -10000;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14363_CopyVMselectall-t0
	public static int fail()
	{
		return -10;
	}
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetBoxAll(wd, "900006", "900008");
			WebDriverLogin.enableBoxRange(wd, "900006", "900017");
			WebDriverLogin.searchBoxRange(wd, "900006", "900008", 3000);
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
			
	        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        WebDriverLogin.searchBoxRange(wd, "900006", "900008", 2500);
	        if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected()) 
	        {
	        	wd.findElement(By.id("uxChkboxsrtpr")).click();
	        	if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).isSelected()) 
	        		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Copy")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).sendKeys("900006");
	        WebDriverLogin.waitT(wd, 2500);
	        result += checkCopy(wd);
	        WebDriverLogin.waitT(wd, 1000);
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
		
		WebDriverLogin.searchBoxRange(wd, box, box);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
        WebDriverLogin.waitT(wd, 3000);
		result += checkMSGsettingsVM(wd);
		result += checkDListTab(wd);
        result += checkTeleNotif(wd);
        result += checkCallOptions(wd);
        result += checkVMconnectivity(wd);
        result += checkVMAudioGrt(wd);
        result += checkVMOutboundD(wd);
        result += checkVRec(wd);
        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
        
		return result;
	}
	
	public static int checkMSGsettingsVM(ChromeDriver wd)
	{
		int result = 0;
		
		try
		{
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.linkText("Messages")).click();
			WebDriverLogin.waitT(wd, 2500);
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMakeMessage")).isSelected())
	            result += fail();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsForwardMessage")).isSelected())
	            result += fail();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAnswerMessage")).isSelected())
	            result += fail();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsContinuousMsgPlay")).isSelected())
	            result += fail();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMsgQuickPlay")).isSelected())
	        	result += fail();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMsgDelivery")).isSelected())
	        	result += fail();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsRemoveHeader")).isSelected())
	        	result += fail();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAutoMsgPlay")).isSelected())
	        	result += fail();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsGetFIFO")).isSelected())
	        	result += fail();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsRemovePrompt")).isSelected())
	        	result += fail();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsMsgEditing")).isSelected())
	        	result += fail();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg")).isSelected())
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
	        WebDriverLogin.waitT(wd, 500);
		}
		catch(Exception ex)
		{
			result += exception;
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
			WebDriverLogin.waitT(wd, 2500);
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptLocalList_ctl01_uxLblLocalDlistName")).getAttribute("title");
	        if(!value.contains("DList11"))
	        	result += fail();
	        
	        while(!wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl01$uxChkLocalDList")).isSelected()) {
	            wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl01$uxChkLocalDList")).click();
	            WebDriverLogin.waitT(wd, 1500);
	        }
	        
	        wd.findElement(By.id("uxLbEditDlist")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        try
	        {
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl01_uxChkMemberItem")).click();
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl21_uxChkMemberItem")).click();
	        }
	        catch(Exception ex){
	        	result += -500;
	        	fail();
	        }
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistClose")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        //
	        //
		}
		catch(Exception ex)
		{
			result += exception;
			fail();
		}
		
		return result;
	}
	
	public static int checkTeleNotif(ChromeDriver wd)
	{
		int result = 0;
		
		try
		{
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.linkText("Notifications")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationOne")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        String value = "";
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_DialingString")).getAttribute("value");
	        if(!value.contains("1007"))
	        	result += fail();
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_OwnerProgrammableNumber")).getAttribute("value");
	        if(!value.contains("4"))
	        	result += fail();
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_NumOfMsgs")).getAttribute("value");
	        if(!value.contains("5"))
	        	result += fail();
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_NumOfAttempts")).getAttribute("value");
	        if(!value.contains("2"))
	        	result += fail();
	        
	        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxDdlTelePager_OwnerProgDigits")));
			WebElement option = select.getFirstSelectedOption();
			value = option.getText();
			if(!value.contains("5"))
	        	result += fail();
			select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxDdlStartTimeHour")));
			option = select.getFirstSelectedOption();
			value = option.getText();
			if(!value.contains("5"))
	        	result += fail();
			select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxDdlEndTimeHour")));
			option = select.getFirstSelectedOption();
			value = option.getText();
			if(!value.contains("5"))
	        	result += fail();
			select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxDdlDelayHour")));
			option = select.getFirstSelectedOption();
			value = option.getText();
			if(!value.contains("10"))
	        	result += fail();
			select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxDdlRetryHour")));
			option = select.getFirstSelectedOption();
			value = option.getText();
			if(!value.contains("10"))
	        	result += fail();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).isSelected())
	        	result += fail();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkSunday")).isSelected())
	        	result += fail();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkSaturday")).isSelected())
	        	result += fail();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkTelePager_IgnoreDistMsgs")).isSelected())
	        	result += fail();
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkQueueStartEndTime")).isSelected())
	        	result += fail();
	        WebDriverLogin.waitT(wd, 500);
		}
		catch(Exception ex)
		{
			result += exception;
			fail();
		}
		
		return result;
	}
	
	public static int checkCallOptions(ChromeDriver wd)
	{
		int result = 0;
		String value = "";
		
		try
		{
			WebDriverLogin.waitT(wd, 2000);
			wd.findElement(By.linkText("Call Options")).click();
	        WebDriverLogin.waitT(wd, 3500);
	        value = wd.findElement(By.tagName("html")).getText();
	        for(int i = 0; i < 10; i++)
	        {
		        if(!value.contains(""+(i+900005)))
		        	result += fail();
	        }
	        //
	        WebDriverLogin.waitT(wd, 500);
		}
		catch(Exception ex)
		{
			result += exception;
			fail();
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
	        WebDriverLogin.waitT(wd, 2500);
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxTxtEmailSettingsServerAddress")).getAttribute("value");
	        if(!value.contains("fake.address.com"))
	        	result += fail();
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxTxtEmailSettingsUserName")).getAttribute("value");
	        if(!value.contains("username"))
	        	result += fail();
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxTxtEmailSettingsEmailAddress")).getAttribute("value");
	        if(!value.contains("fake@email.com"))
	        	result += fail();
	        
	        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxDdlConnectivityRightsLevel")));
			WebElement option = select.getFirstSelectedOption();
			value = option.getText();
			if(!value.contains("Power User"))
	        	result += fail();
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxChkGlobalFuntionalityGlobalExt")).isSelected())
	        	result += fail();
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxChkGlobalFunctionalityGlobalMwi")).isSelected())
	        	result += fail();
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmConnectivity_ucVmConnectivity_uxChkGlobalFunctionalityGlobalNotification")).isSelected())
	        	result += fail();
			WebDriverLogin.waitT(wd, 500);
		}
		catch(Exception ex)
		{
			result += exception;
			fail();
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
	        WebDriverLogin.waitT(wd, 2500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Time Blocks Scheduling")) 
			{
				WebDriverLogin.waitT(wd, 12500);
				if(!wd.findElement(By.tagName("html")).getText().contains("Time Blocks Scheduling")) 
					WebDriverLogin.waitT(wd, 35000);
			}
	        
	        
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxTxtGreetingLength")).getAttribute("value");
	        if(!value.contains("120"))
	        	result += fail();
	        
	        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreetingMaxNumGreetings")));
			WebElement option = select.getFirstSelectedOption();
			value = option.getText();
			if(!value.contains("9"))
	        	result += fail();
			select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudDefGreeting")));
			option = select.getFirstSelectedOption();
			value = option.getText();
			if(!value.contains("2"))
	        	result += fail();
			select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudBusyGreeting")));
			option = select.getFirstSelectedOption();
			value = option.getText();
			if(!value.contains("3"))
	        	result += fail();
			select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudNoAnsGreeting")));
			option = select.getFirstSelectedOption();
			value = option.getText();
			if(!value.contains("4"))
	        	result += fail();
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkGreetingGrtPassNameEdit")).isSelected())
	        	result += fail();
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkGreetingMultiLangGreetings")).isSelected())
	        	result += fail();
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkGreetingPromptCallerLanguage")).isSelected())
	        	result += fail();
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkGreetingKeepLanguage")).isSelected())
	        	result += fail();
			WebDriverLogin.waitT(wd, 500);
	        //
		}
		catch(Exception ex)
		{
			result += exception;
			fail();
		}
		
		return result;
	}
	
	public static int checkVMOutboundD(ChromeDriver wd)
	{
		int result = 0;
		
		try
		{
			WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.linkText("Outbound Delivery")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        if(!wd.findElement(By.id("uxChkMessageFaxBroadcast")).isSelected())
	        	result += fail();
	        if(!wd.findElement(By.id("uxChkImmediateBroadcast")).isSelected())
	        	result += fail();
	        String value = "";
	        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmOutboundDelivery_ucVmOutboundDelivery_uxDdlDeliveryAttempts")));
			WebElement option = select.getFirstSelectedOption();
			value = option.getText();
			if(!value.contains("3"))
	        	result += fail();
			select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmOutboundDelivery_ucVmOutboundDelivery_uxDdlOutboundDel_Hour")));
			option = select.getFirstSelectedOption();
			value = option.getText();
			if(!value.contains("5"))
	        	result += fail();
	        WebDriverLogin.waitT(wd, 500);
		}
		catch(Exception ex)
		{
			result += exception;
			fail();
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
	        if(!value.contains("Stone Cold"))
	            result += fail();
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName1")).getAttribute("value");
			if(!value.contains("Steve Austin")) 
				result += fail();
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName2")).getAttribute("value");
			if(!value.contains("The Viper")) 
				result += fail();
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName3")).getAttribute("value");
			if(!value.contains("Randy Orton")) 
				result += fail();
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName4")).getAttribute("value");
			if(!value.contains("Big Guy Bain")) 
				result += fail();
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName5")).getAttribute("value");
			if(!value.contains("Hulk Hogan")) 
				result += fail();
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName6")).getAttribute("value");
			if(!value.contains("John Cena")) 
				result += fail();
		}
		catch(Exception ex)
		{
			result += exception;
			fail();
		}
		
		return result;
	}
	
	
	
	
	public static int MSGsettingsVM(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		
		wd.findElement(By.linkText("Messages")).click();
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
        
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Submit")).click();
        WebDriverLogin.waitT(wd, 4000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
        	result += fail();
		
		return result;
	}
	
	public static int FaxesTab(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		
		wd.findElement(By.linkText("Faxes")).click();
        WebDriverLogin.waitT(wd, 2500);
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
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmFaxes_ucVmFaxes_uxBtnFaxSubmit")).click();
        WebDriverLogin.waitT(wd, 4000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
        	result += fail();
		
		return result;
	}
	
	public static int DListTab(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		
		wd.findElement(By.linkText("Dist. Lists")).click();
        WebDriverLogin.waitT(wd, 2500);
	    if(!wd.findElement(By.tagName("html")).getText().contains("DList11"))
        {
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
            WebDriverLogin.waitT(wd, 2500);
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
        WebDriverLogin.waitT(wd, 2000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxBtnDListService_Submit")).click();
        WebDriverLogin.waitT(wd, 4000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
        {
        	WebDriverLogin.waitT(wd, 5000);
        	if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
            	result += fail();
        }
		
		return result;
	}
	
	public static int TeleNotif(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		
		wd.findElement(By.linkText("Notifications")).click();
        WebDriverLogin.waitT(wd, 2500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationOne")).click();
        WebDriverLogin.waitT(wd, 2500);
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
		
		wd.findElement(By.linkText("Call Options")).click();
        WebDriverLogin.waitT(wd, 2500);
        
        for(int i = 0; i < 10; i++)
        {
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtRoutingOptions_Key")).clear();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtRoutingOptions_Key")).sendKeys(""+i);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtRoutingOptions_Number")).clear();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtRoutingOptions_Number")).sendKeys(""+(i+900005));
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxLbAddRoutingOptions")).click();
            WebDriverLogin.waitT(wd, 4500+(500*i));
        }
        
        WebDriverLogin.waitT(wd, 2500);
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkCO_RoutingOptions")).isSelected()) 
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkCO_RoutingOptions")).click();
        WebDriverLogin.waitT(wd, 2500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxBtnCOSubmit")).click();
        WebDriverLogin.waitT(wd, 4000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
        	result += fail();
		
		return result;
	}
	
	public static int VMconnectivity(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		
		wd.findElement(By.linkText("Connectivity")).click();
        WebDriverLogin.waitT(wd, 2500);
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
        	result += fail();
		
		return result;
	}
	
	public static int VMAudioGrt(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		
		WebDriverLogin.waitT(wd, 2500);
		wd.findElement(By.linkText("Greetings")).click();
        WebDriverLogin.waitT(wd, 2500);
        
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
        	result += fail();
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxChkGreetingGrtPassNameEdit")).click();
        }
        
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsSubmit")).click();
        WebDriverLogin.waitT(wd, 4000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
        	result += fail();
		
		return result;
	}
	
	public static int VRecVM(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		
        wd.findElement(By.linkText("Voice Rec.")).click();
        WebDriverLogin.waitT(wd, 2500);
        CheckNames(wd);
        WebDriverLogin.waitT(wd, 500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxBtnVoiceRec_Submit")).click();
        WebDriverLogin.waitT(wd, 4000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
        	result += fail();
        
		return result;
	}
	
	public static int VMOutboundD(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		
		wd.findElement(By.linkText("Outbound Delivery")).click();
        WebDriverLogin.waitT(wd, 2500);
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
        	result += fail();
		
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
			result += exception;
			fail();
		}
	}
	

	public static int checkCopy(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		//
		WebDriverLogin.waitT(wd, 1000);
		while(!wd.findElement(By.id("uxChkResetAutoDisable")).isSelected())
        {
        	if(wd.findElement(By.id("uxChkResetAll")).isSelected())
        	{
	            wd.findElement(By.id("uxChkResetAll")).click();
	            WebDriverLogin.waitT(wd, 250);
	            wd.findElement(By.id("uxChkResetAll")).click();
        	}
        	else
        		wd.findElement(By.id("uxChkResetAll")).click();
        	WebDriverLogin.waitT(wd, 1500);
        }
		wd.findElement(By.linkText("Messages")).click();
		WebDriverLogin.waitT(wd, 2500);
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
        WebDriverLogin.waitT(wd, 2000);
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
        WebDriverLogin.waitT(wd, 2000);
        //
        //
        wd.findElement(By.linkText("Faxes")).click();
        WebDriverLogin.waitT(wd, 2500);
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetMaxFaxes")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetMaxFaxes")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetNewFaxRet")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetNewFaxRet")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetSavedFaxRet")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetSavedFaxRet")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetDelFaxRet")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetDelFaxRet")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetLocalFaxNumber")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetLocalFaxNumber")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("uxChkResetFaxStoreForward")).isSelected())
            wd.findElement(By.id("uxChkResetFaxStoreForward")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetSepCallFaxing")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetSepCallFaxing")).click();
        else
        	result += fail();

        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetCustSubID")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetFaxes_UxResetFaxes_uxChkResetCustSubID")).click();
        else
        	result += fail();
        //
        //
        wd.findElement(By.linkText("Distribution Lists")).click();
        WebDriverLogin.waitT(wd, 2500);
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetDList_UcxResetDlist_uxChkResetLocalDList")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetDList_UcxResetDlist_uxChkResetLocalDList")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("uxChkResetDListControl")).isSelected())
            wd.findElement(By.id("uxChkResetDListControl")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("uxChkResetDListRights")).isSelected())
            wd.findElement(By.id("uxChkResetDListRights")).click();
        else
        	result += fail();
        //
        //
        wd.findElement(By.linkText("Notifications")).click();
        WebDriverLogin.waitT(wd, 2500);
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetNotifPlans")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetNotifPlans")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetNotifCtrl")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetNotifCtrl")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetWakeupCtrl")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetNotifications_uxChkResetWakeupCtrl")).click();
        else
        	result += fail();
        //
        //
        wd.findElement(By.linkText("Call Options")).click();//
        WebDriverLogin.waitT(wd, 2500);
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetOperatorBox")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetOperatorBox")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetNAOption")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetNAOption")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetBusyOption")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetBusyOption")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetRecordandXfr")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetRecordandXfr")).click();
        else
        	result += fail();
        wd.findElement(By.linkText("Routing Options")).click();//
        WebDriverLogin.waitT(wd, 2500);
        if(wd.findElement(By.id("uxChkResetCallOptsPRO")).isSelected())
            wd.findElement(By.id("uxChkResetCallOptsPRO")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("uxChkResetCallOptsVRO")).isSelected())
            wd.findElement(By.id("uxChkResetCallOptsVRO")).click();
        else
        	result += fail();
        wd.findElement(By.linkText("Speed Dial")).click();//
        WebDriverLogin.waitT(wd, 2500);
        if(wd.findElement(By.id("uxChkResetPrSpeedDial")).isSelected())
            wd.findElement(By.id("uxChkResetPrSpeedDial")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("uxChkResetSpeedDial")).isSelected())
            wd.findElement(By.id("uxChkResetSpeedDial")).click();
        else
        	result += fail();
        wd.findElement(By.linkText("Call Queuing")).click();//
        WebDriverLogin.waitT(wd, 2500);
        if(wd.findElement(By.id("uxChkResetNumQueuedCallers")).isSelected())
            wd.findElement(By.id("uxChkResetNumQueuedCallers")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("uxChkResetAnnounceBox")).isSelected())
            wd.findElement(By.id("uxChkResetAnnounceBox")).click();
        else
        	result += fail();
        wd.findElement(By.linkText("Call Supervision")).click();//
        WebDriverLogin.waitT(wd, 2500);
        if(wd.findElement(By.id("uxChkResetSupervise")).isSelected())
            wd.findElement(By.id("uxChkResetSupervise")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("uxChkRngsBeforeNoAns")).isSelected())
            wd.findElement(By.id("uxChkRngsBeforeNoAns")).click();
        else
        	result += fail();
        wd.findElement(By.linkText("Services")).click();//
        WebDriverLogin.waitT(wd, 2500);
        if(wd.findElement(By.id("uxChkResetThanksforCalling")).isSelected())
            wd.findElement(By.id("uxChkResetThanksforCalling")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("uxChkResetOrigMessageOptionAlt")).isSelected())
            wd.findElement(By.id("uxChkResetOrigMessageOptionAlt")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("uxChkResetExitToOtherBox")).isSelected())
            wd.findElement(By.id("uxChkResetExitToOtherBox")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("uxChkResetCallBackExtSndr")).isSelected())
            wd.findElement(By.id("uxChkResetCallBackExtSndr")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("uxChkResetCallScreen")).isSelected())
            wd.findElement(By.id("uxChkResetCallScreen")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("uxChkResetXMA")).isSelected())
            wd.findElement(By.id("uxChkResetXMA")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("uxChkResetCallXfrPrmpts")).isSelected())
            wd.findElement(By.id("uxChkResetCallXfrPrmpts")).click();
        else
        	result += fail();
        //
        //
        wd.findElement(By.linkText("Connectivity")).click();//
        WebDriverLogin.waitT(wd, 2500);
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxChkResetUserRights")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxChkResetUserRights")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxChkResetDUFA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxChkResetDUFA")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetServerAddr")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetServerAddr")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetUserName")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetUserName")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetUserPasswd")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetUserPasswd")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetEmailAddr")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpResetEmailSettings_uxChkResetEmailAddr")).click();
        else
        	result += fail();
        wd.findElement(By.linkText("Global Functionality")).click();//
        WebDriverLogin.waitT(wd, 2500);
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpGlobalFunctionality_uxChkResetGlobalExt")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpGlobalFunctionality_uxChkResetGlobalExt")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpGlobalFunctionality_uxChkResetGlobalMWI")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpGlobalFunctionality_uxChkResetGlobalMWI")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpGlobalFunctionality_uxChkResetGlobalNotif")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetConnectivity_uxResetConnectivity_uxTabContainerResetConnectivity_uxTpGlobalFunctionality_uxChkResetGlobalNotif")).click();
        else
        	result += fail();
        //
        //
        wd.findElement(By.linkText("Greetings")).click();//
        WebDriverLogin.waitT(wd, 2500);
        wd.findElement(By.linkText("Time Block Scheduling")).click();
        WebDriverLogin.waitT(wd, 2500);
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtTimeBlock_uxChkResetTimeBlockSch")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtTimeBlock_uxChkResetTimeBlockSch")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtTimeBlock_uxChkResetDailySchedule")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtTimeBlock_uxChkResetDailySchedule")).click();
        else
        	result += fail();
        wd.findElement(By.linkText("Audio Greetings")).click();//
        WebDriverLogin.waitT(wd, 2500);
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetGrtName")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetGrtName")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetGrtGreeting")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetGrtGreeting")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetGrtLength")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetGrtLength")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetMaxGreetings")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetMaxGreetings")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetDefGrt")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetDefGrt")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetBsyGrt")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetBsyGrt")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetGrtNAGrt")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtAudioGrt_uxChkResetGrtNAGrt")).click();
        else
        	result += fail();
        wd.findElement(By.linkText("Services")).click();
        WebDriverLogin.waitT(wd, 2500);
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtServices_uxChkResetMultiLangGrt")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtServices_uxChkResetMultiLangGrt")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtServices_uxChkResetGrtPromptCallerForLang")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtServices_uxChkResetGrtPromptCallerForLang")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtServices_uxChkResetGrtPCodeName")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtServices_uxChkResetGrtPCodeName")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtServices_uxChkResetGrtKeepLang")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtServices_uxChkResetGrtKeepLang")).click();
        else
        	result += fail();
        //
        //
        wd.findElement(By.linkText("Outbound Delivery")).click();
        WebDriverLogin.waitT(wd, 2500);
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkDeliveryAttmpts")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkDeliveryAttmpts")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkDeliveryRxTime")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkDeliveryRxTime")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkMsgFaxBroadcast")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkMsgFaxBroadcast")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkImmedBroadcast")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkImmedBroadcast")).click();
        else
        	result += fail();
        //
        //
        wd.findElement(By.linkText("Voice Rec.")).click();
        WebDriverLogin.waitT(wd, 2500);
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetVoiceRec_uxChkResetVoRecNames")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetVoiceRec_uxChkResetVoRecNames")).click();
        WebDriverLogin.waitT(wd, 1250);
        wd.findElement(By.linkText("Basic")).click();
        do
        {
        	if(wd.findElement(By.id("uxChkResetAll")).isSelected())
        	{
	            wd.findElement(By.id("uxChkResetAll")).click();
	            WebDriverLogin.waitT(wd, 1250);
	            wd.findElement(By.id("uxChkResetAll")).click();
        	}
        	else
        		wd.findElement(By.id("uxChkResetAll")).click();
        	WebDriverLogin.waitT(wd, 1500);
        }while(!wd.findElement(By.id("uxChkResetAutoDisable")).isSelected());
        
		return result;
	}
}
