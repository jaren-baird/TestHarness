
package DListTUI;

import login.WebDriverLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class T15193_DList_CreateTUI
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//T15193_DList_CreateTUI-t0
	
	public static void main(String[] args) throws Exception
	{
	    result = 0;
	    try
	    {
	    	//reset box
		    wd = WebDriverLogin.getWebAdmin();
			wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		    WebDriverLogin.resetDListAll(wd, "900005", "900005");
		    WebDriverLogin.enableBoxRange(wd, "900005", "900005");
		    WebDriverLogin.enableBoxRange(wd, "1007", "1007");
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
			//run T15193_DList_CreateTUI Cyara
	        String[] folderList = {"DList", "TestSuite", "TUI", "2", "T15193_DList_CreateTUI"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
			//
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 130000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
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
	  	   	wd = WebDriverLogin.getWebAdmin();
	    	WebDriverLogin.searchBoxRange(wd, "900005", "900005", 3000);
		    //create dlist
		    String DListName = "DListAddOwner";
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
		    WebDriverLogin.waitT(wd, 2000);
		    //
		    try
	    	{
		    	WebDriverLogin.waitT(wd, 1500);
		    	if(!wd.findElement(By.id("uxChkLocalDList")).isSelected())
			        wd.findElement(By.id("uxChkLocalDList")).click();
		    	wd.findElement(By.id("uxLbEditDlist")).click();
		    	WebDriverLogin.waitT(wd, 3000);
	    	
		    	try
		    	{
		    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl01_uxChkMemberItem")).click();
		    		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl01_uxLblMemName_Val")).getText().contains("Cyara")) {
		                result += -10;
		            }
		    	}
		    	catch (Exception ex)
		    	{
		    		result += -10;
		    	}
	    	}
	    	catch (Exception ex)
	    	{
	    		result += -101;
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
		//
		System.exit(result);
	}
}
