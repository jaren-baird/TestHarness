
package DLIST;

import login.WebDriverLogin;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T18499_Add200to500_DList
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//T18499_Add200to500_DList_CP-t0
	
	public static void main(String[] args) throws Exception
	{
	    result = 0;
	    String DListName = "DListAdd500";
	    try
	    {
		    wd = WebDriverLogin.getWebAdmin();
		    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    WebDriverLogin.resetDListAll(wd, "900005", "900005");
		    
		    for(int i = 0; i<5; i++)
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
		    
		    //create dlist
		    WebDriverLogin.searchBoxRange(wd, "900005", "900005", 2500);
		    
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
		    WebDriverLogin.waitT(wd, 2000);
		    
		    if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
	            WebDriverLogin.waitT(wd, 2000);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys("35");
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
	            WebDriverLogin.waitT(wd, 2500);
	            
	            int wait = 700;
	            
	            for(int i = 0; i < 5; i++)
	            {//boxes wont show up if they're disabled, add section to enable these boxes beforehand
	            	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).clear();
		        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("900"+i+"50");
		        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).clear();
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("900"+(i+1)+"49");
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
		            WebDriverLogin.waitT(wd, 2500+(i*wait/2));
		            wd.findElement(By.id("uxChkDlistInternalSrch")).click();
		        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
		        	WebDriverLogin.waitT(wd, 2500+(i*wait/2));
		        	if(i >= 1)
		        		wait = wait+i*200;
	            }
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
	            WebDriverLogin.waitT(wd, 2000);
	                   
		    }
		    try
		    {
		    	if(!wd.findElement(By.id("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl01$uxChkLocalDList")).isSelected())
		    	{
		    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
		    	    WebDriverLogin.waitT(wd, 1000);
		    	}
		    	else
		    	{
		    		wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
		    	}
	    		WebDriverLogin.waitT(wd, 2000);
		    }
		    catch (Exception ex)
		    {
		    	//wd.quit();
		    	//wd = WebDriverLogin.getWebAdmin();
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
	    //
	    //
	    try
	    {
	    	wd = WebDriverLogin.getWebAdmin();
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
		    	WebDriverLogin.waitT(wd, 4500);
		    	
		    	try
			    {
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl01_uxChkMemberItem")).click();
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl11_uxChkMemberItem")).click();
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl21_uxChkMemberItem")).click();
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl31_uxChkMemberItem")).click();
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl41_uxChkMemberItem")).click();
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl51_uxChkMemberItem")).click();
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl61_uxChkMemberItem")).click();
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl71_uxChkMemberItem")).click();
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl81_uxChkMemberItem")).click();
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl91_uxChkMemberItem")).click();
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl893_uxChkMemberItem")).click();
			    }
			    catch (Exception ex)
			    {
			    	result += -1000;
			    }
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistClose")).click();
		    	WebDriverLogin.waitT(wd, 1500);
		    	
		    }
		    else
		    	result = -10005;
		    
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
	    
		System.exit(result);
	}
}
