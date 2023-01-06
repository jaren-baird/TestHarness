package DListTUI;
import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class T18493_DList_LeaveMessage
{
	private static int result = 9;
	private static int Exception = -2;
	public static ChromeDriver wd = null;
	private static String FilePath = "\\\\CWENGFS\\Tests\\TestJars\\table\\ErrorTable.jar";
	//T18493_DList_LeaveMessage-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
	    String DListName = "DListAdd";
	    
		try
		{
		    wd = WebDriverLogin.getWebAdmin();
		    WebDriverLogin.resetDList(wd, "900005");
		    WebDriverLogin.resetMessages(wd, "900005", "900005");
		    WebDriverLogin.resetMessages(wd, "900050", "900060");
		    WebDriverLogin.enableBoxRange(wd, "900005", "900060");
		    //Add (5 to 10) mailboxes to the D-list
		    
	    	WebDriverLogin.searchBoxRange(wd, "900005", "900005");
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
		    WebDriverLogin.waitT(wd, 2500);
		    if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
	            WebDriverLogin.waitT(wd, 2000);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
	            WebDriverLogin.waitT(wd, 2000);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys("2");
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("900050");
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("900060");
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
		    wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl01$uxChkLocalDList")).click();
		    wd.findElement(By.id("uxLbEditDlist")).click();
		    WebDriverLogin.waitT(wd, 1500);
		    
		    try
		    {
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl01_uxChkMemberItem")).click();
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl03_uxChkMemberItem")).click();
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl05_uxChkMemberItem")).click();
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl07_uxChkMemberItem")).click();
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl09_uxChkMemberItem")).click();
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl11_uxChkMemberItem")).click();
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl13_uxChkMemberItem")).click();
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl15_uxChkMemberItem")).click();
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl17_uxChkMemberItem")).click();
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl19_uxChkMemberItem")).click();
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl21_uxChkMemberItem")).click();
		    }
		    catch (Exception ex)
		    {
		    	result += -1000;
		    }
		    
		    WebDriverLogin.waitT(wd, 2500);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistClose")).click();
		    WebDriverLogin.waitT(wd, 2500);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
		    WebDriverLogin.waitT(wd, 1000);
		     
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
		//
		try
		{
	        String[] folderList = {"DList", "TestSuite", "DListSetup", "T18493_DList"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 100000);
	        String[] para = {"0","true"};
	        int table = WebDriverLogin.RunErrorTable(wd, para);
	        if(table != 0)
	        {
	        	result += table;//
	        	System.out.println("Leave message error");
	        }
			
	  	   	//
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
		
		try
		{
  	   		wd = WebDriverLogin.getWebAdmin();
	  	   	WebDriverLogin.searchBoxRange(wd, "900050", "900060");
	  	   	//box 900050-900060
	  	   	String status = "";
	  	   	for(int i = 1; i < 22; i+=2)
	  	   	{
	  	   		if(i<10)
	  	   			status = "ctl00_uxCphContent_ucBoxes_uxRepeater_ctl0"+i+"_uxLbStatus";
	  	   		else if(i<100)
	  	   			status = "ctl00_uxCphContent_ucBoxes_uxRepeater_ctl"+i+"_uxLbStatus";
		  	   	wd.findElement(By.id(status)).click();
		  	   	WebDriverLogin.waitT(wd, 1500);
		  	   	String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_New_Value")).getText();//getAttribute("value");
		  	   	if(value == null)
		  	   	{
		  	   		result += -9999;
		  	   		break;
		  	   	}
			  	if(value.contains("0"))
			  	{
		    		result += -200;
		    		System.out.println("box 9000"+(50+(i-1)/2)+" failed");
		    	}
			  	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxStatusClose")).click();
			  	WebDriverLogin.waitT(wd, 1500);
		  	}
	  	   	
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
}
