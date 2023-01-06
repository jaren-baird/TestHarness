import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class UseWebDriver 
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
		
		String DListName = "CreateADList";
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxLbNumber")).click();
        WebDriverLogin.waitT(wd, 1500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
	    WebDriverLogin.waitT(wd, 2500);
	    //Delete DList
	    if(wd.findElement(By.tagName("html")).getText().contains(DListName))
	    {
	    	if(!wd.findElement(By.id("uxChkLocalDList")).isSelected())
	    		wd.findElement(By.id("uxChkLocalDList")).click();
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDeleteDlist")).click();
	    	WebDriverLogin.waitT(wd, 500);
	    }
	    
	    //Create DList
	    if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
	    {
	    	if(wd.findElement(By.tagName("html")).getText().contains(DListName))
	    		result = -2000;
	    	
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).click();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys("30");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("1007");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("1007");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Cyara"))
	        {
	        	wd.quit();
	        	result = -2001;
	        	System.exit(result);
	        }
	        else
	        {
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
	        
	        if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
	        	result = -2002;
	        else
	        	result = 0;
	    }
        
		wd.quit();
		System.exit(result);
	}
	
}
