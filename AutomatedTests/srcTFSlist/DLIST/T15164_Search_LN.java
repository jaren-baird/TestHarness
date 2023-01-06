
package DLIST;

import login.WebDriverLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class T15164_Search_LN
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//T15164_Search_LN-t0
	
	public static void main(String[] args) throws Exception
	{
	    result = 0;
	    try
	    {
	    	wd = WebDriverLogin.getWebAdmin();
			wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    WebDriverLogin.resetDListAll(wd, "900005", "900005");
	    	WebDriverLogin.enableBoxRange(wd, "900005", "900005");
	    	WebDriverLogin.searchBoxRange(wd, "900005", "900005", 3000);
		    //create dlist
		    String DListName = "DListAddLN";
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
		    WebDriverLogin.waitT(wd, 2500);
		    
		    //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys("25");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("900000");
	        //test search parameters
	        if(testSearchOptions(wd, "Remove", "Other") != -10)        
	        	result += -10;
	        result += testSearchOptions(wd, "", "O");
	        result += testSearchOptions(wd, "", "Ort");
	        result += testSearchOptions(wd, "", "Orton");
	        result += testSearchOptions(wd, "Ra", "Orton");
	        result += testSearchOptions(wd, "Randy", "Ort");
	        
			wd.findElement(By.id("uxChkDlistInternalSrch")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
			WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
	        	result += -2002;          
	
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
		    
			//
		    WebDriverLogin.searchBoxRange(wd, "900005", "900005", 2500);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
		    WebDriverLogin.waitT(wd, 2500);
		    //check DList
		    if(wd.findElement(By.tagName("html")).getText().contains(DListName))
		    {
		    	if(!wd.findElement(By.id("uxChkLocalDList")).isSelected()) {
			        wd.findElement(By.id("uxChkLocalDList")).click();
			    }
		    	wd.findElement(By.id("uxLbEditDlist")).click();
		    	WebDriverLogin.waitT(wd, 2500);
		    	
		    	try
			    {
		    		if(!wd.findElement(By.tagName("html")).getText().contains("Randy Orton"))
			        	result += -2003;
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl01_uxChkMemberItem")).click();
			    }
			    catch (Exception ex)
			    {
			    	result += -1000;
			    }
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistClose")).click();
		    	WebDriverLogin.waitT(wd, 2500);
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
		    	WebDriverLogin.waitT(wd, 2500);
		    }
		    else
		    	result = -10005;
		    
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
	
	public static int testSearchOptions(ChromeDriver wd, String firstName, String lastName)
    {
    	int result = 0;
    	
    	try
    	{
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtSchFirstName")).clear();
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtSchFirstName")).sendKeys(firstName);
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtSchLastName")).clear();
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtSchLastName")).sendKeys(lastName);
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Orton"))
	        	result += -10;
    	}
    	catch (Exception ex)
    	{
    		result += -101;
    	}
    	
    	return result;
    }
}
