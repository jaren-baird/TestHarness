
package DListTUI;

import login.WebDriverLogin;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class T18515_DList_GlobalBoxes
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T18515_DList_GlobalBoxes-t0
	
	public static void main(String[] args) throws Exception
	{
	    result = 0;
	    try
	    {
		    //reset Messages
		    //reset DLists
		    wd = WebDriverLogin.getWebAdmin();
		    WebDriverLogin.resetMessages(wd, "900005", "900006");
		    WebDriverLogin.resetDListAll(wd, "900005", "900007");
		    WebDriverLogin.enableBoxRange(wd, "900005", "900007");
		    WebDriverLogin.waitT(wd, 2500);
		    WebDriverLogin.searchBoxRange(wd, "900005", "900005");
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        if(wd.findElement(By.id("uxChkGlobalDListRightsService")).isSelected())
	        {
	        	wd.findElement(By.id("uxChkGlobalDListRightsService")).click();
	        	WebDriverLogin.waitT(wd, 500);
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxBtnDListService_Submit")).click();
	        	WebDriverLogin.waitT(wd, 4500);
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
	    
	    try
	    {
	    	wd = WebDriverLogin.getWebAdmin();
		    String DListName = "DListGlobalTest50";
		    WebDriverLogin.waitT(wd, 1500);
		    WebDriverLogin.searchBoxRange(wd, "900007", "900007");
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
		    WebDriverLogin.waitT(wd, 2500);
		    wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		    String value = "";
		    String ctlID = "";
		    String gdlID = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptGlobalDList_ctl"; //xx_uxChkGlobalDList
		    String gdlNum = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptGlobalDList_ctl";//xx_uxLblGlobalDlistNumber
		    int j = 1;
		    while(true)
		    {
		    	try
		    	{
		    		if(j < 10)
		    			ctlID = "0";
		    		else
		    			ctlID = "";
		    		value = gdlNum+(ctlID+Integer.toString(j))+"_uxLblGlobalDlistNumber";
		    		value = wd.findElement(By.id(value)).getText();
				    if(value.contains("50"))
				    {
				    	value = gdlID+(ctlID+Integer.toString(j))+"_uxChkGlobalDList";
					    if(!wd.findElement(By.id(value)).isSelected()) {
					        wd.findElement(By.id(value)).click();
					    }
					    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDeleteDlist")).click();
					    WebDriverLogin.waitT(wd, 1500);
					    break;
				    }
				    j++;
		    	}
		    	catch(Exception ex)
		    	{break;}
		    }
		    
		    
		    //Add mailbox to the D-list
		    if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
	            WebDriverLogin.waitT(wd, 2000);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
	            WebDriverLogin.waitT(wd, 1500);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys("50");
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("900006");
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("900006");
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
	            WebDriverLogin.waitT(wd, 1000);
	            
				wd.findElement(By.id("uxChkDlistInternalSrch")).click();
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
				WebDriverLogin.waitT(wd, 2500);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
	            WebDriverLogin.waitT(wd, 2500);
	            
		        if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
		        	result += -2002;          
		    }
		    else
		    	result += -10;
		    
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
	        String[] folderList = {"DList", "TestSuite", "DListSetup", "2", "T18515_DList_GlobalBoxes"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
			//
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 100000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
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
	    try
	    {
	  	   	wd = WebDriverLogin.getWebAdmin();
	  	   	WebDriverLogin.searchBoxRange(wd, "900006", "900006");
	  	   	//box 900006
	  	   	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbStatus")).click();
	  	   	WebDriverLogin.waitT(wd, 1500);
	  	   	String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_New_Value")).getText();//getAttribute("value");
	  	   	if(value == null)
	  	   	{
	  	   		result += -9999;
	  	   	}
	  	   	else if(value.contains("0"))
		  	{
	    		result += -200;
	    	}
		  	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxStatusClose")).click();
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
	    //
		System.exit(result);
	}
}
