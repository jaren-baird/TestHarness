package DLIST;

import java.util.concurrent.TimeUnit;
import login.WebDriverLogin;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class T18486_Check_LnG_DList_Options 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T18486_Check_LnG_DList-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String DListName = "CreateADList";
		String box = "900007";
        //
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetDListAll(wd, box, box);
			WebDriverLogin.searchBoxRange(wd, box, box, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
		    WebDriverLogin.waitT(wd, 2500);
		    if(!wd.findElement(By.id("uxChkGlobalDListRightsService")).isSelected())
		    {
		    	wd.findElement(By.id("uxChkGlobalDListRightsService")).click();
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxBtnDListService_Submit")).click();
		    	WebDriverLogin.waitT(wd, 2500);
		    }
		    //Create DList if not found
		    if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
		    {
		    	if(wd.findElement(By.tagName("html")).getText().contains(DListName))
		    		result += -10;
		    	
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
		        WebDriverLogin.waitT(wd, 1000);
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName);
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys("30");
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
		        
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("900005");
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("900005");
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
		        WebDriverLogin.waitT(wd, 2500);
		        if(!wd.findElement(By.tagName("html")).getText().contains("Randy"))
		        	result += -10;
	        	wd.findElement(By.id("uxChkDlistInternalSrch")).click();
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
	        	WebDriverLogin.waitT(wd, 2000);
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
	        	WebDriverLogin.waitT(wd, 1000);
	        	if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
	        	{
	        		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistClose")).click();
	        	}
		    }
		    
		    if(!wd.findElement(By.id("uxChkLocalDList")).isSelected())
	    		wd.findElement(By.id("uxChkLocalDList")).click();
	    	wd.findElement(By.id("uxLbEditDlist")).click();
	    	WebDriverLogin.waitT(wd, 500);
	    	
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddExternal")).click();
	    	WebDriverLogin.waitT(wd, 1000);
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtAddExternal")).clear();
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtAddExternal")).sendKeys("53304");
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddExternal")).click();
	    	if(!wd.findElement(By.tagName("html")).getText().contains("External"))
	        	result += -10; //
	    	WebDriverLogin.waitT(wd, 500);
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
	    	WebDriverLogin.waitT(wd, 1500);
	    	try
	    	{
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistClose")).click();
        	}
	    	catch(Exception ex){}
	    	
	    	String GDListName = "CREATEaGDL";
		    
		    //Create DList if not found
		    if(!wd.findElement(By.tagName("html")).getText().contains(GDListName))
		    {
		    	if(wd.findElement(By.tagName("html")).getText().contains(GDListName))
		    		result += -2000;
		    	
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
		        WebDriverLogin.waitT(wd, 1000);
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(GDListName);
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys("90");
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
		        
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("900005");
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("900005");
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
		        WebDriverLogin.waitT(wd, 2500);
		        if(!wd.findElement(By.tagName("html")).getText().contains("Randy"))
		        	result += -10;
		        
	        	wd.findElement(By.id("uxChkDlistInternalSrch")).click();
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
	        	WebDriverLogin.waitT(wd, 2000);
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
	        	WebDriverLogin.waitT(wd, 1000);
	        	if(!wd.findElement(By.tagName("html")).getText().contains(GDListName))
	        		result += -10;
	        	
	        	try
		    	{
	        		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistClose")).click();
	        		result += -109;
		    	}
		    	catch(Exception ex){}
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
