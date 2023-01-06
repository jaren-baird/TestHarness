
package DLIST;

import login.WebDriverLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class T15165_Search_Owner
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//T15165_Search_Owner-t0
	
	public static void main(String[] args) throws Exception
	{
	    result = 0;
	    try
	    {
		    wd = WebDriverLogin.getWebAdmin();
		    //Report Test
	        //First TS
	        //WEBADMINTEST
		    result += checkOwners(wd);
			wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		    //
		    WebDriverLogin.resetDList(wd, "900005");
		    //reset boxes & Enable boxes being used
		    WebDriverLogin.resetBoxAll(wd, "900150", "900154");
		    
		    //WebDriverLogin.enableBoxRange(wd, "900150", "900154"); resetBoxAll does this
	    	//WebDriverLogin.searchBoxRange(wd, "900150", "900154", 1500);
	    	
	    	//change owners
	    	changeTSSowner(wd, "900150", "R");
	    	changeTSSowner(wd, "900151", "F");
	    	changeTSSowner(wd, "900152", "W");
	    	changeTSSowner(wd, "900153", "R");
	    	changeTSSowner(wd, "900154", "F");
	    	
	    	WebDriverLogin.searchBoxRange(wd, "900005", "900005", 3000);
		    //create dlist
		    String DListName = "DListAddOwner";
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
		    WebDriverLogin.waitT(wd, 2000);
		    
		    //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys("25");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("900150");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("900154");
	        
	        //test search parameters
	        result += testSearchOptions(wd, "Report Test", 2);
	        result += testSearchOptions(wd, "First TS", 2);
	        result += testSearchOptions(wd, "WEBADMINTEST", 1);
		    
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
	
	public static void changeTSSowner(ChromeDriver wd, String boxNum, String tssOwner)
	{
		try 
		{
			WebDriverLogin.searchBoxRange(wd, boxNum, boxNum, 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_OwnerTss")).click();
			WebDriverLogin.waitT(wd, 250);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_OwnerTss")).sendKeys("w");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_OwnerTss")).sendKeys(Keys.ENTER);
			WebDriverLogin.waitT(wd, 250);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).click();
			WebDriverLogin.waitT(wd, 250);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_OwnerTss")).sendKeys(tssOwner);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_OwnerTss")).sendKeys(Keys.ENTER);
			WebDriverLogin.waitT(wd, 250);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_ID")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
			WebDriverLogin.waitT(wd, 2500);
		} 
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	
	}
	
	public static int testSearchOptions(ChromeDriver wd, String ownerTSS, int validBoxes)
    {
    	int result = 0;
    	String control = ownerTSS.substring(0, 1);
    	try
    	{
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlSchOwner")).click();
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlSchOwner")).sendKeys(control);
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        if(validBoxes == 1)
	        {
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptInternalMemberSearchResults_ctl01_uxChklDlistSch")).click();
	        	try
	        	{
	        		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptInternalMemberSearchResults_ctl02_uxChklDlistSch")).click();
	        		result = -101;
	        	}
	        	catch (Exception ex)
	        	{}
	        }
	        else if(validBoxes == 2)
	        {
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptInternalMemberSearchResults_ctl01_uxChklDlistSch")).click();
        		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptInternalMemberSearchResults_ctl02_uxChklDlistSch")).click();
        		
	        	try
	        	{
	        		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptInternalMemberSearchResults_ctl03_uxChklDlistSch")).click();
	        		result = -102;
	        	}
	        	catch (Exception ex)
	        	{}
	        }
	        else
	        	result = -1;
    	}
    	catch (Exception ex)
    	{
    		result = -103;
    	}
    	
    	return result;
    }
	
	public static int checkOwners(ChromeDriver wd)
	{
		String owners = "";
		int result = 0;
		Actions builder = new Actions(wd);
        builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'Ts Servers')]"))).perform();
        WebDriverLogin.waitT(wd, 2000);
        String data = wd.findElementByTagName("html").getText();
        if(!data.contains("Report Test"))
        	owners += "R";
        if(!data.contains("First TS"))
        	owners += "F";
        if(!data.contains("WEBADMINTEST"))
        	owners += "W";
        
        if(owners.length() > 0)
        {
        	if(owners.contains("R"))
        	{
        		builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'Ts Servers')]"))).perform();
        		wd.findElement(By.id("ctl00_uxCphNavigation_NewTSServer")).click();
            	WebDriverLogin.waitT(wd, 2000);
	        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtMachineName")).clear();
	        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtMachineName")).sendKeys("Report Test");
	        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxBtnTsServerSubmit")).click();
	        	WebDriverLogin.waitT(wd, 2000);
	        	if(!wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxLblTsStatus")).getText().contains("Changes Accepted"))
	        	{
	        		result += -10;
	        	}
        	}
        	if(owners.contains("F"))
        	{
        		builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'Ts Servers')]"))).perform();
        		wd.findElement(By.id("ctl00_uxCphNavigation_NewTSServer")).click();
            	WebDriverLogin.waitT(wd, 2000);
	        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtMachineName")).clear();
	        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtMachineName")).sendKeys("First TS");
	        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxBtnTsServerSubmit")).click();
	        	WebDriverLogin.waitT(wd, 2000);
	        	if(!wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxLblTsStatus")).getText().contains("Changes Accepted"))
	        	{
	        		result += -10;
	        	}
        	}
        	if(owners.contains("W"))
        	{
        		builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'Ts Servers')]"))).perform();
        		wd.findElement(By.id("ctl00_uxCphNavigation_NewTSServer")).click();
            	WebDriverLogin.waitT(wd, 2000);
	        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtMachineName")).clear();
	        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtMachineName")).sendKeys("WEBADMINTEST");
	        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxBtnTsServerSubmit")).click();
	        	WebDriverLogin.waitT(wd, 2000);
	        	if(!wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxLblTsStatus")).getText().contains("Changes Accepted"))
	        	{
	        		result += -10;
	        	}
        	}
        }
        
        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
        WebDriverLogin.waitT(wd, 2000);
        return result;
	}
}
