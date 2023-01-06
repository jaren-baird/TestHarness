
package DLIST;

import login.WebDriverLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class T15169_Remove_CurrentMembers
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//T15169_Remove_CurrentMembers-t0
	
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
		wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    //
	    result = 0;
	    //reset box
	    WebDriverLogin.searchBoxRange(wd, "900005", "900005", 2500);
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	    WebDriverLogin.waitT(wd, 1500);
	    wd.findElement(By.linkText("Distribution Lists")).click();
	    WebDriverLogin.waitT(wd, 1000);
	    if(!wd.findElement(By.id("uxChkResetDlistAll")).isSelected()) {
	        wd.findElement(By.id("uxChkResetDlistAll")).click();
	    }
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	    WebDriverLogin.waitT(wd, 2500);
	    if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbResetWarning")).getText().contains("Reset Successful.")) {
	    	result -= 10;
	    }
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	    WebDriverLogin.waitT(wd, 2500);
	    //Enable boxes being used
    	WebDriverLogin.searchBoxRange(wd, "900005", "900005", 2500);
    	wd.findElement(By.id("uxChkboxsrtpr")).click();
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLB_Box_State")).click();
    	WebDriverLogin.waitT(wd, 1500);
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRbState_Enabled")).click();
    	WebDriverLogin.waitT(wd, 1000);
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxState_Multi_Submit")).click();
    	
    	
    	WebDriverLogin.searchBoxRange(wd, "900005", "900005", 3000);
	    //create dlist
	    String DListName = "DListAddOwner";
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	    WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
	    WebDriverLogin.waitT(wd, 1000);
	    
	    //
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
        WebDriverLogin.waitT(wd, 2000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys("25");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
        WebDriverLogin.waitT(wd, 3000);
        
    	if(!wd.findElement(By.id("uxChkDlistInternalSrch")).isSelected())
	        wd.findElement(By.id("uxChkDlistInternalSrch")).click();
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
    	WebDriverLogin.waitT(wd, 2000);
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
    	WebDriverLogin.waitT(wd, 1500);
    	if(!wd.findElement(By.id("uxChkLocalDList")).isSelected())
	        wd.findElement(By.id("uxChkLocalDList")).click();
    	wd.findElement(By.id("uxLbEditDlist")).click();
    	WebDriverLogin.waitT(wd, 3000);
    	
    	try
    	{
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl01_uxChkMemberItem")).click();
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl199_uxChkMemberItem")).click();
    		if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl199_uxChkMemberItem")).isSelected())
    	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl199_uxChkMemberItem")).click();
    	}
    	catch (Exception ex)
    	{
    		result = -10;
    	}
    	
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl03_uxChkMemberItem")).click();
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl05_uxChkMemberItem")).click();
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl07_uxChkMemberItem")).click();
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl09_uxChkMemberItem")).click();
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbCurMembersRemove")).click();
    	WebDriverLogin.waitT(wd, 2000);
    	//
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl01_uxChkMemberItem")).click();
    	try
    	{
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl191_uxChkMemberItem")).click();
    		result = -10;
    	}
    	catch (Exception ex)
    	{}
    	
    	wd.findElement(By.id("uxChkDlistMemberAll")).click();
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbCurMembersRemove")).click();
    	WebDriverLogin.waitT(wd, 2000);
    	try
    	{
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl01_uxChkMemberItem")).click();
    		result = -10;
    	}
    	catch (Exception ex)
    	{}
    	
    	
		wd.quit();
		System.exit(result);
	}
}
