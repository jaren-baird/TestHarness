package DLIST;

import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T18485_Create_a_DList
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T18485_Create_a_DList-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String box = "900007";
        String DListName = "CreateADList";
        
        try
        {
        	wd = WebDriverLogin.getWebAdmin();
        	WebDriverLogin.enableBoxRange(wd, "900005", "900005");
        	WebDriverLogin.resetDListAll(wd, box, box);
        	WebDriverLogin.searchBoxRange(wd, box, box);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
		    WebDriverLogin.waitT(wd, 2500);
		    
		    //Create DList
		    if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
		    {
		    	//if(wd.findElement(By.tagName("html")).getText().contains(DListName))
		    		//result += fail();
		    	
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
		        if(!wd.findElement(By.tagName("html")).getText().contains("Randy") && !wd.findElement(By.tagName("html")).getText().contains("Report Test"))
		        {
		        	result += fail();
		        }
		        else
		        {
		        	wd.findElement(By.id("uxChkDlistInternalSrch")).click();
		        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
		        	WebDriverLogin.waitT(wd, 2500);
		        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
		        	WebDriverLogin.waitT(wd, 3000);
		        	if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
		        	{
		        		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistClose")).click();
		        	}
		        	
		        	if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
			        	result += fail();
		        	//Delete DList
				    if(wd.findElement(By.tagName("html")).getText().contains(DListName))
				    {
				    	if(!wd.findElement(By.id("uxChkLocalDList")).isSelected())
				    		wd.findElement(By.id("uxChkLocalDList")).click();
				    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDeleteDlist")).click();
				    	WebDriverLogin.waitT(wd, 1000);
				    }
				    if(wd.findElement(By.tagName("html")).getText().contains(DListName))
			    		result += fail();
		        }	
		    }
	        //
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
	
	public static int fail()
	{
		return -10;
	}
}
