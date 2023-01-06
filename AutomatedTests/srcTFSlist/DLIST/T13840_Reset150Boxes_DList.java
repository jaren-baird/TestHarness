package DLIST;
import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class T13840_Reset150Boxes_DList 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13840_Reset150Boxes_DList-t0
	
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
	    //
	    result = 0;
	    String boxID = "";
	    WebDriverLogin.resetDList(wd, "900005");
	    WebDriverLogin.enableBoxRange(wd, "900050", "900249");
	    WebDriverLogin.searchBoxRange(wd, "900050", "900050", 1000);
	    boxID = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbID")).getText();
	    for(int i = 0; i < 2; i++)
	    {
	    	WebDriverLogin.searchBoxRange(wd, "900"+i+"50", "900"+(i+1)+"49", 1500);
	    	wd.findElement(By.id("uxChkboxsrtpr")).click();
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLB_Box_State")).click();
	    	WebDriverLogin.waitT(wd, 1500);
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRbState_Enabled")).click();
	    	WebDriverLogin.waitT(wd, 1000);
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxState_Multi_Submit")).click();
	    	WebDriverLogin.waitT(wd, 3000);
	    }
	    
	    WebDriverLogin.searchBoxRange(wd, "900005", "900005");
	    String DListName = "DListRemoval";
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	    WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
	    WebDriverLogin.waitT(wd, 1000);
	    //Delete DList
	    if(wd.findElement(By.tagName("html")).getText().contains(DListName))
	    {
	    	if(!wd.findElement(By.id("uxChkLocalDList")).isSelected())
	    		wd.findElement(By.id("uxChkLocalDList")).click();
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDeleteDlist")).click();
	    	WebDriverLogin.waitT(wd, 500);
	    }
	    
	    
	    if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
        {
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
            WebDriverLogin.waitT(wd, 2000); //miliseconds
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
            WebDriverLogin.waitT(wd, 2000);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("900050");
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("900200");
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
            WebDriverLogin.waitT(wd, 1500);
            
			wd.findElement(By.id("uxChkDlistInternalSrch")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLblDistRepeaterPager2")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.id("uxChkDlistInternalSrch")).click();//
			WebDriverLogin.waitT(wd, 500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
            WebDriverLogin.waitT(wd, 2500);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
            WebDriverLogin.waitT(wd, 2500);
            
	        if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
	        	result += -2002;          
	    }
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
	    
		//Test Case 13839:Box Reset - Test options for "Remove from all Distribution Lists"
	    WebDriverLogin.searchBoxRange(wd, "900005", "900005", 2500);
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	    WebDriverLogin.waitT(wd, 1500);
	    wd.findElement(By.linkText("Distribution Lists")).click();
	    WebDriverLogin.waitT(wd, 1000);
	    if(!wd.findElement(By.id("uxChkResetAllDlist")).isSelected()) {
	        wd.findElement(By.id("uxChkResetAllDlist")).click();
	    }
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtResetBoxesCopyRangeStart")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtResetBoxesCopyRangeStart")).sendKeys(boxID);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtResetBoxesCopyRangeEnd")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtResetBoxesCopyRangeEnd")).sendKeys((Integer.parseInt(boxID)+150)+"");
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	    WebDriverLogin.waitT(wd, 2500);
	    if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) {
	    	result -= 10;
	    }
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	    WebDriverLogin.waitT(wd, 2500);
	    
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
	    		wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl01_uxChkMemberItem")).click();
	    		result += -10000;
	    	}
	    	catch (Exception ex){}
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistClose")).click();
	    	WebDriverLogin.waitT(wd, 1500);
	    	
	    	//Delete DList
		    if(wd.findElement(By.tagName("html")).getText().contains(DListName))
		    {
		    	if(!wd.findElement(By.id("uxChkLocalDList")).isSelected())
		    		wd.findElement(By.id("uxChkLocalDList")).click();
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDeleteDlist")).click();
		    	WebDriverLogin.waitT(wd, 500);
		    }
	    }
	    else
	    	result = -10005;
	    
		wd.quit();
		System.exit(result);
	}
}
