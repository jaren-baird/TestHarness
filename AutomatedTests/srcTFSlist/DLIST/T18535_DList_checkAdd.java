
package DLIST;
import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class T18535_DList_checkAdd
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T18535_DList_checkAdd-t0
	
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
	    //
	    result = 0;
	    
	    //reset Local DLists
	    WebDriverLogin.resetDList(wd, "900005");
  		WebDriverLogin.enableBoxRange(wd, "900000", "900005");
	    
  		//create DList
	    WebDriverLogin.searchBoxRange(wd, "900005", "900005");
	    String DListName = "DListCheck";
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	    WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
	    WebDriverLogin.waitT(wd, 1000);
	    
	    if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
        {
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
            WebDriverLogin.waitT(wd, 2000);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
            WebDriverLogin.waitT(wd, 2000);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("900000");
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("900005");
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
	    wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl01$uxChkLocalDList")).click();
	    wd.findElement(By.id("uxLbEditDlist")).click();
	    WebDriverLogin.waitT(wd, 1500);
	    
	    try
	    {
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl01_uxChkMemberItem")).click();
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl03_uxChkMemberItem")).click();
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl05_uxChkMemberItem")).click();
	    }
	    catch (Exception ex)
	    {
	    	result += -1000;
	    	System.out.println("DList failed to find boxes added");
	    }
	    try
	    {
	    	wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl07_uxChkMemberItem")).click();
	    	result += -1000;
	    	System.out.println("DList had too many boxes added which means an incorrect box type was found");
	    }catch (Exception ex){}
	    
	    WebDriverLogin.waitT(wd, 1500);
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistClose")).click();
	    WebDriverLogin.waitT(wd, 1500);
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
	    WebDriverLogin.waitT(wd, 1000);
		wd.quit();
		System.exit(result);
	}
}
