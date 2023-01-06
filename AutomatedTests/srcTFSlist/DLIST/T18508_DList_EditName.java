package DLIST;

import login.WebDriverLogin;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class T18508_DList_EditName
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//T18508_DList_EditName-t0
	
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
		
	    //
	    result = 0;
	    //reset box
	    searchBoxRange(wd, "900005", "900005");
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
	    if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) {}
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	    WebDriverLogin.waitT(wd, 2500);
	    //create dlist
	    String DListName = "DListUnedited";
	    String EditDListName = "DListEdited";
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	    WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
	    WebDriverLogin.waitT(wd, 1000);
	    
	    
	    if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
        {
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
            WebDriverLogin.waitT(wd, 2000);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys("5");
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
            WebDriverLogin.waitT(wd, 2000);
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).clear();
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("900006");
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).clear();
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("900006");
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
            
            wd.findElement(By.id("uxChkDlistInternalSrch")).click();
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
        	WebDriverLogin.waitT(wd, 2000);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
            WebDriverLogin.waitT(wd, 2000);
                   
	    }
	    try
	    {
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
	    }
	    catch (Exception ex)
	    {
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistClose")).click();
		    WebDriverLogin.waitT(wd, 2000);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
		    WebDriverLogin.waitT(wd, 2000);
	    }
	    
	    WebDriverLogin.waitT(wd, 1500);
	    
	    searchBoxRange(wd, "900005", "900005");
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	    WebDriverLogin.waitT(wd, 2000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
	    WebDriverLogin.waitT(wd, 1000);
	    //change DList
	    String value = "";
	    if(wd.findElement(By.tagName("html")).getText().contains(DListName))
	    {
	    	if(!wd.findElement(By.id("uxChkLocalDList")).isSelected()) {
		        wd.findElement(By.id("uxChkLocalDList")).click();
		    }
	    	wd.findElement(By.id("uxLbEditDlist")).click();
	    	WebDriverLogin.waitT(wd, 2500);
	    	
	    	try
		    {
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl01_uxChkMemberItem")).click();
		    	value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).getAttribute("value");//wd.findElement(By.id("")).getText();
		  	   	if(value == null)
		  	   	{
		  	   		result = -9999;
		  	   	}
		  	   	else if(value.contains(DListName))
			  	{
			  	   	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).clear();
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(EditDListName);
			  	}
		  	   	else
		  	   		result += -100;
		    	
		  	   	WebDriverLogin.waitT(wd, 1500);
		  	   	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
		  	   	WebDriverLogin.waitT(wd, 2500);
		  	   	try
			    {
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
				    
			    }
			    catch (Exception ex)
			    {
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistClose")).click();
				    WebDriverLogin.waitT(wd, 2000);
				    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
				    WebDriverLogin.waitT(wd, 2000);
			    } 	
		    }
		    catch (Exception ex)
		    {
		    	result += -1000;
		    }
	    }
	    else
	    	result = -10005;
	    
	    
	    //confirm change
	    searchBoxRange(wd, "900005", "900005");
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	    WebDriverLogin.waitT(wd, 1500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
	    WebDriverLogin.waitT(wd, 1000);
	    if(!wd.findElement(By.id("uxChkLocalDList")).isSelected()) {
	        wd.findElement(By.id("uxChkLocalDList")).click();
	    }
    	wd.findElement(By.id("uxLbEditDlist")).click();
    	WebDriverLogin.waitT(wd, 1500);
	    
	    try
	    {
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl01_uxChkMemberItem")).click();
	    	value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).getAttribute("value");
	  	   	if(value == null)
	  	   	{
	  	   		result = -9999;
	  	   	}
	  	   	else if(value.contains(EditDListName))
		  	{
	  	   		
		  	}
	  	   	else
	  	   		result += -100;
	    	
	  	   	WebDriverLogin.waitT(wd, 1500);
	  	   	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
	  	   	WebDriverLogin.waitT(wd, 4500);
	  	   	try
		    {
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
			    
		    }
		    catch (Exception ex)
		    {
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistClose")).click();
			    WebDriverLogin.waitT(wd, 2000);
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
			    WebDriverLogin.waitT(wd, 2000);
		    }   	
	    }
	    catch (Exception ex)
	    {
	    	result += -1000;
	    }
	    
		wd.quit();
		System.exit(result);
	}
	
	public static void searchBoxRange(ChromeDriver wd, String start, String end) throws InterruptedException
	{
		WebDriverLogin.waitT(wd, 2500);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartRange")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartRange")).sendKeys(start);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtEndRange")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtEndRange")).sendKeys(end);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLBtnStdSearch")).click();
        WebDriverLogin.waitT(wd, 2500);
	}

}

