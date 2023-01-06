
package DListTUI;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T18530_DList_MAO_FWDTUI
{
	private static int result = 9;
	private static int Exception = -2;
	public static ChromeDriver wd = null;
	private static String FilePath = "\\\\CWENGFS\\Tests\\TestJars\\table\\ErrorTable.jar";
	//T18530_DList_MAO_FWDTUI-t0
	
	public static void main(String[] args) throws Exception
	{
	    result = 0;
	    try
	    {
		    //Reset DLists
		    wd = WebDriverLogin.getWebAdmin();
	  		WebDriverLogin.resetDList(wd, "900005");
	  		WebDriverLogin.resetDList(wd, "900006");
	  		WebDriverLogin.resetDList(wd, "1008");
	  		//Create DList for 1007
		    DList(wd, "1008", "2", "900005");
		    
		    //Reset Messages
		    WebDriverLogin.resetMessages(wd, "900005", "900006");
		    WebDriverLogin.resetMessages(wd, "1008", "1008");
		    wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += -109;
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		//Leave message to be forwarded
		try
		{
	        String[] folderList = {"DList", "TestSuite", "Leave_messageDList"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
			System.out.println("");
			}
			//
			wd.findElement(By.id("executeButton")).click();
			WebDriverLogin.waitT(wd, 95000);
			int tableR = 0;
			String[] para = {"0","true"};
			tableR = WebDriverLogin.RunErrorTable(wd, para);
			if(tableR != 0)
			{
				result += tableR;
				System.out.println("Leave_messageDList: "+tableR);
			}
			wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += -109;
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		//Set Caller services options
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.searchBoxRange(wd, "900005", "900006", 2000);
			for(int i = 1; i < 4; i+=2)
			{
			    WebDriverLogin.waitT(wd, 3000);
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl0"+i+"_uxLbNumber")).click();
			    WebDriverLogin.waitT(wd, 2500);
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_tab")).click();
			    WebDriverLogin.waitT(wd, 2500);
			    if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsMsgEditing")).isSelected())
				    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsMsgEditing")).click();
			    if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg")).isSelected())
				    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg")).click();
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Submit")).click();
				WebDriverLogin.waitT(wd, 2000);
				if(!wd.findElement(By.tagName("html")).getText().contains("Updated")) {
		            System.out.println("update failed");
		        }
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Close")).click();
			}
			DList(wd, "900005", "3", "900006");
			WebDriverLogin.waitT(wd, 1500);
			wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += -109;
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
  	   	//Forward message
		try
		{
			String[] folderList = {"DList", "TestSuite", "DListSetup", "3", "T18530_DList_MAO_FWDTUI"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
			if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
				System.out.println("");
			}
			wd.findElement(By.id("executeButton")).click();
			WebDriverLogin.waitT(wd, 205000);
			int tableR = 0;
	        String[] para = {"0","true"};
	        tableR = WebDriverLogin.RunErrorTable(wd, para);
	        if(tableR != 0)
	        {
	        	result += tableR;
	        	System.out.println("T18530_DList_MAO_FWDTUI failed: "+tableR);
	        }
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += -109;
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
  	   	//
  	   	try
  	   	{
	  	   	wd = WebDriverLogin.getWebAdmin();
	  	   	WebDriverLogin.searchBoxRange(wd, "900006", "900006", 3500);
	  	   	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbStatus")).click();
		   	WebDriverLogin.waitT(wd, 2500);
		   	String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_New_Value")).getText();//getAttribute("value");
		   	if(value == null)
		   	{
		   		result += -9999;
		   	}
		   	else if(value.contains("0"))
		  	{
		  		result += -200;
		  		System.out.println("box 900006 has no message");
		  	}
		  	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxStatusClose")).click();
		  	WebDriverLogin.waitT(wd, 2500);
	  	   	//reset 900005-06
		    WebDriverLogin.resetMessages(wd, "900005", "900006");
		    //
			wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += -109;
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
  	   	//
		System.exit(result);
	}
	
	public static void DList(ChromeDriver wd, String boxNumber, String dlistNum, String boxMember) throws InterruptedException
    {
		//create dlist
		String DListName = "DListMessage"+dlistNum;
		WebDriverLogin.searchBoxRange(wd, boxNumber, boxNumber, 2500);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		WebDriverLogin.waitT(wd, 2500);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
		WebDriverLogin.waitT(wd, 2500);
		if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
		{
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
			WebDriverLogin.waitT(wd, 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys(dlistNum);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
			WebDriverLogin.waitT(wd, 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys(boxMember);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys(boxMember);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
			WebDriverLogin.waitT(wd, 2000);
			
			wd.findElement(By.id("uxChkDlistInternalSrch")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
			WebDriverLogin.waitT(wd, 2500);
		
			if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
			    	result += -2002;          
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
    }
	/*
	public static void resetDList(ChromeDriver wd, String boxNum) throws InterruptedException
    {
	    //reset Local DLists
		WebDriverLogin.searchBoxRange(wd, boxNum, boxNum, 2500);
		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).isSelected()) {
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
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
		WebDriverLogin.waitT(wd, 4500);
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
		{}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
		WebDriverLogin.waitT(wd, 1500);
    }*/
	/*
	public static void resetMessages(ChromeDriver wd, String startNum, String endNum) throws InterruptedException
    {
	    WebDriverLogin.searchBoxRange(wd, startNum, endNum, 2500);
		if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected())
		    wd.findElement(By.id("uxChkboxsrtpr")).click();
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset")) {
		    System.out.println("");
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Boxes")) {
		    System.out.println("");
		}
		wd.findElement(By.linkText("Messages")).click();
		WebDriverLogin.waitT(wd, 500);
		if(!wd.findElement(By.id("uxChkResetMsgAll")).isSelected()) {
		    wd.findElement(By.id("uxChkResetMsgAll")).click();
		}
		if(!wd.findElement(By.tagName("html")).getText().contains("Submit")) {
		    System.out.println("");
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
		WebDriverLogin.waitT(wd, 1500);
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
		{}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
		WebDriverLogin.waitT(wd, 1000);
    }*/
}
