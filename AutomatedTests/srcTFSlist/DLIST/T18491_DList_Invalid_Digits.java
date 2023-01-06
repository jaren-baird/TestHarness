package DLIST;

import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class T18491_DList_Invalid_Digits 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T18491_DList_Invalid_Digits-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.searchBoxRange(wd, "1009", "1009");
	        
	        String DListName = "CreateADList";
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
		    WebDriverLogin.waitT(wd, 2500);
	
		    
		    //Create DList if missing
		    if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
		    {
		    	CreateDList(wd, DListName);
		    }
		    
		    if(!wd.findElement(By.id("uxChkLocalDList")).isSelected())
	    		wd.findElement(By.id("uxChkLocalDList")).click();
	    	wd.findElement(By.id("uxLbEditDlist")).click();
	    	WebDriverLogin.waitT(wd, 2500);
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
	    	WebDriverLogin.waitT(wd, 500);
	        String[] invalidDigitsList = { "“*”" , "”100”" , "!" , "@" , "#" , "$" , "%" , "^" , "&" , "*" , "(" , ")" , "-" , "=" , "_" , "+",
	        		"\\" , "]" , "[" , "\'" , ";" , "/" , "." , "," , "<" , ">" , "?" , ":" , "\"" , "{" , "}" , "|" , "~" , "`" , "" };
	        //
	        for(int i = 0; i < invalidDigitsList.length; i++)
	        {
	        	WebDriverLogin.waitT(wd, 2000);
	        	tryInvalidDigit(wd, invalidDigitsList[i]);
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
	
	public static void tryInvalidDigit(ChromeDriver wd, String invalidDigit) throws InterruptedException
	{
		wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("10000");
		
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).clear();
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys(invalidDigit);
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
		WebDriverLogin.waitT(wd, 2500);
		if(!wd.findElements(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptInternalMemberSearchResults_ctl01_uxChklDlistSch")).isEmpty()) //if(wd.findElement(By.tagName("html")).getText().contains("WEBADMINTEST"))
	    {
    		result += -10;
    		printInvalidDigit(invalidDigit);
	    }
    	
    	
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("10000");
		
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).clear();
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys(invalidDigit);
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
    	WebDriverLogin.waitT(wd, 2500);
    	if(!wd.findElements(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptInternalMemberSearchResults_ctl01_uxChklDlistSch")).isEmpty()) //if(wd.findElement(By.tagName("html")).getText().contains("WEBADMINTEST"))
	    {
    		result += -10;
    		printInvalidDigit(invalidDigit);
	    }
    	wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void printInvalidDigit(String digit)
	{
		System.out.println("Valid Digit Detected: "+digit);
	}
	
	public static void CreateDList(ChromeDriver wd ,String DListName) throws InterruptedException
	{
		if(wd.findElement(By.tagName("html")).getText().contains(DListName))
    		result = -2000;
    	
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
        WebDriverLogin.waitT(wd, 2500);
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
        	WebDriverLogin.waitT(wd, 2500);
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
        	WebDriverLogin.waitT(wd, 2500);
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
}

