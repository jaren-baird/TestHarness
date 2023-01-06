
package DLIST;

import login.WebDriverLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class T15162_Internal_AddVSR
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//T15162_Internal_AddVSR-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    //reset box
			//Enable boxes being used
			result += WebDriverLogin.resetDListAll(wd, "900050", "900095");
		    WebDriverLogin.enableBoxRange(wd, "900050", "900095");
	    	
	    	//reset Local DLists? may need to write a reset local dlist *range* function
		    WebDriverLogin.resetDListAll(wd, "900005", "900006");
	    	WebDriverLogin.searchBoxRange(wd, "900005", "900005", 2000);
		    //create dlist
		    String DListName = "DListAdd45";
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
		    WebDriverLogin.waitT(wd, 1000);
		    
		    
		    if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
	            WebDriverLogin.waitT(wd, 2000);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys("25");
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
	            WebDriverLogin.waitT(wd, 2000);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("900005");
	            //wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("1007");
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
	            WebDriverLogin.waitT(wd, 2000);
	            
				wd.findElement(By.id("uxChkDlistInternalSrch")).click();
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
				WebDriverLogin.waitT(wd, 2500);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
	            WebDriverLogin.waitT(wd, 2500);
	            
		        if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
		        	result += fail();         
		    }
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
		    
			//
		    WebDriverLogin.searchBoxRange(wd, "900005", "900005", 2500);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
		    WebDriverLogin.waitT(wd, 2000);
		    //check DList
		    if(wd.findElement(By.tagName("html")).getText().contains(DListName))
		    {
		    	if(!wd.findElement(By.id("uxChkLocalDList")).isSelected()) {
			        wd.findElement(By.id("uxChkLocalDList")).click();
			    }
		    	wd.findElement(By.id("uxLbEditDlist")).click();
		    	WebDriverLogin.waitT(wd, 1500);
		    	
		    	try
			    {
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl01_uxChkMemberItem")).click();
			    	if(!wd.findElement(By.tagName("html")).getText().contains("Randy Orton"))
			    		fail();
			    }
			    catch (Exception ex)
			    {
			    	result += fail();
			    }
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistClose")).click();
		    	WebDriverLogin.waitT(wd, 1500);
		    	
		    }
		    else
		    	result = fail();
		    
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
	
	public static int fail()
	{
		return -10;
	}
}
