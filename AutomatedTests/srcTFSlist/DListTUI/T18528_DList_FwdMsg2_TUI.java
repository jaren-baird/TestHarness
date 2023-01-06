
package DListTUI;

import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T18528_DList_FwdMsg2_TUI
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T18528_DList_FwdMsg2_TUI-t0
	
	public static void main(String[] args) throws InterruptedException 
	{
		result = 0;
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverLogin.resetMessages(wd, "1007", "1008");
			WebDriverLogin.searchBoxRange(wd, "1007", "1007", 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2000);
			wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages")).click();
			WebDriverLogin.waitT(wd, 2500);
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg")).isSelected())
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Submit")).click();
			WebDriverLogin.waitT(wd, 2500);
			if(!wd.findElement(By.tagName("html")).getText().contains("Updated")){}
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Close")).click();
			//reset Local DLists
			WebDriverLogin.resetDListAll(wd, "900005", "900006");
			WebDriverLogin.resetMessages(wd, "900005", "900006");
			WebDriverLogin.searchBoxRange(wd, "900005", "900006", 3500);
			//create dlist
			String DListName = "18528DListTest";
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
		    WebDriverLogin.waitT(wd, 2500);
		    if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
	            WebDriverLogin.waitT(wd, 2000);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys("2");
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
	            WebDriverLogin.waitT(wd, 2000);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("900005");
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("900005");
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
	            WebDriverLogin.waitT(wd, 2000);
	            
				wd.findElement(By.id("uxChkDlistInternalSrch")).click();
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
				WebDriverLogin.waitT(wd, 2500);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
	            WebDriverLogin.waitT(wd, 2500);
	            
		        if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
		        {
		        	result += -2002;
		        	System.out.println("DList creation 1 failed");
		        }
		    }
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
		    //create dlist
	  		String DListName2 = "DListFWD";
	  		WebDriverLogin.waitT(wd, 3500);
	  	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	  	    WebDriverLogin.waitT(wd, 2500);
	  	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
	  	    WebDriverLogin.waitT(wd, 2500);
	  	    if(!wd.findElement(By.tagName("html")).getText().contains(DListName2))
	  	    {
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
			    WebDriverLogin.waitT(wd, 2000);
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName2);
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys("3");
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
			    WebDriverLogin.waitT(wd, 2000);
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("1008");
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("1008");
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
			    WebDriverLogin.waitT(wd, 2000);
	              
	  			wd.findElement(By.id("uxChkDlistInternalSrch")).click();
	  			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
	  			WebDriverLogin.waitT(wd, 2500);
	  			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
	  			WebDriverLogin.waitT(wd, 2500);
	              
	  	        if(!wd.findElement(By.tagName("html")).getText().contains(DListName2))
	  	        {
	  	        	result += -2002;
	  	        	System.out.println("DList creation 2 failed");
	  	        }
	  	    }
	  	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
	  	    wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += exceptionRes();
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
			wd = WebDriverLogin.getWebAdmin();
			wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverLogin.searchBoxRange(wd, "1008", "1008", 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2000);
			wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages")).click();
			WebDriverLogin.waitT(wd, 2500);
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg")).isSelected())
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsUrgentMsg")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Submit")).click();
			WebDriverLogin.waitT(wd, 2500);
			if(!wd.findElement(By.tagName("html")).getText().contains("Updated")){}
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Close")).click();
			wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += exceptionRes();
			ex.printStackTrace();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
	    //
		String url = "";
		int tableR = 0;
		
		try
		{
	        String[] folderList = {"DList", "TestSuite", "DListSetup", "3", "T18527_DList_MSG"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
			//
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 105000);
	        url = wd.getCurrentUrl();
	        tableR = 0;
	        String[] para = {"0","true"};
	        tableR = WebDriverLogin.RunErrorTable(wd, para);
	        if(tableR != 0)
	        {
	        	result += tableR;
	        	System.out.println("T18527_DList_MSG failed: "+tableR);
	        }
	        wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += exceptionRes();
			ex.printStackTrace();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
  	   	//
  	   	//
		try
		{
			String[] folderList = {"DList", "TestSuite", "DListSetup", "3", "T18528_DList_ForwardMsg"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
			if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
				System.out.println("");
			}
			wd.findElement(By.id("executeButton")).click();
			WebDriverLogin.waitT(wd, 172000);
			url = wd.getCurrentUrl();
			tableR = 0;
			String[] para = {"0","true"};
			tableR = WebDriverLogin.RunErrorTable(wd, para);
	        if(tableR != 0)
	        {
	        	result += tableR;
	        	System.out.println("T18528_DList_ForwardMsg: "+tableR);
	        }
	        wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += exceptionRes();
			ex.printStackTrace();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
	   	//
	   	//
		try
		{
			String[] folderList = {"DList", "TestSuite", "DListSetup", "3", "T18528_DList_ForwardMsg2"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
			if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
				System.out.println("");
			}
			wd.findElement(By.id("executeButton")).click();
			WebDriverLogin.waitT(wd, 185000);
			url = wd.getCurrentUrl();
			tableR = 0;
			String[] para = {"0","true"};
			tableR = WebDriverLogin.RunErrorTable(wd, para);
	        if(tableR != 0)
	        {
	        	result += tableR;
	        	System.out.println("T18528_DList_ForwardMsg2: "+tableR);
	        }
	        wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += exceptionRes();
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
		   	wd = WebDriverLogin.getWebAdmin();
		   	wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  	   	WebDriverLogin.searchBoxRange(wd, "900005", "900005", 2500);
	  	   	//box 900005, 1007, 1008
	  	   	
	  	   	for(int i = 0; i < 3; i++)
	  	   	{
	   			
		  	   	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbStatus")).click();
		  	   	WebDriverLogin.waitT(wd, 1500);
		  	   	String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_New_Value")).getText();//getAttribute("value");
		  	   	if(value == null)
		  	   	{
		  	   		result = -9999;
		  	   		System.out.println("Box Status new message value was null");
		  	   		break;
		  	   	}
			  	if(value.contains("0"))
			  	{
		    		result += -200;
		    		System.out.println("Box Status new message value was 0");
		    	}
			  	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxStatusClose")).click();
			  	WebDriverLogin.waitT(wd, 1500);
			  	if(i == 0)
			  		WebDriverLogin.searchBoxRange(wd, "1007", "1007");
			  	else if(i == 1)
			  		WebDriverLogin.searchBoxRange(wd, "1008", "1008");
		  	}
	  	   	
	  	   	wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += exceptionRes();
			ex.printStackTrace();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
	  	   	
		System.exit(result);
		
	}
	
	public static int exceptionRes()
	{
		return -109;
	}
}
