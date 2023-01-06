
package DLIST;

import login.WebDriverLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class T15167_Search_EmptyFields
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//T15167_Search_EmptyFields-t0
	
	public static void main(String[] args) throws Exception
	{
	    result = 0;
	    String box = "900005";
	    
	    try
		{
	    	wd = WebDriverLogin.getWebAdmin();
			wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			WebDriverLogin.resetDListAll(wd, box, box);
	    	WebDriverLogin.enableBoxRange(wd, "900000", "900400");
	    	WebDriverLogin.searchBoxRange(wd, box, box, 2500);
		    //create dlist
		    String DListName = "DListAddOwner";
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
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
	        WebDriverLogin.waitT(wd, 3000);
	        
	        //determine boxes found
	        try
	        {
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtDistRepeaterPagerGotoPage")).clear();
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtDistRepeaterPagerGotoPage")).sendKeys("3");
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDistImgRepeaterPagerGotoPage")).click();
	        }
	        catch(Exception lowBoxCount)
	        {
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLblDistRepeaterPager2")).click();
	        }
	    	WebDriverLogin.waitT(wd, 3000);
	    	if(!wd.findElement(By.id("uxChkDlistInternalSrch")).isSelected())
		        wd.findElement(By.id("uxChkDlistInternalSrch")).click();
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
	    	WebDriverLogin.waitT(wd, 2000);
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
	    	WebDriverLogin.waitT(wd, 2500);
	    	if(!wd.findElement(By.id("uxChkLocalDList")).isSelected())
		        wd.findElement(By.id("uxChkLocalDList")).click();
	    	wd.findElement(By.id("uxLbEditDlist")).click();
	    	WebDriverLogin.waitT(wd, 3000);
	    	
	    	try
	    	{
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl01_uxChkMemberItem")).click();
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl199_uxChkMemberItem")).click();
	    	}
	    	catch (Exception ex)
	    	{
	    		result += -10;
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
