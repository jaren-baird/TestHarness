import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.*;

import login.WebDriverLogin;
import login.WebDriverLoginLegacy;

public class ErrorTableFX 
{
	private static int result = 44;
	private static int Exception = -22;
	private static FirefoxDriver wd = null;
	private static String cyaraCalledNum = "5897@10.16.99.23";
	
	public static int errortable(String[] args)
	{
		main(args);
		return result;
	}
	
	public static void main(String[] args)
	{
		boolean state = true;
		int step = 0;
		FirefoxDriver wd = null;
    	
		boolean exists = true;
		String url = "";
		
		if(args.length > 0) 
		{
		    try 
		    {
		        step = Integer.parseInt(args[0]);
		        if(args[1].equals("true"))
	        		state = true;
		        else
		        	state = false;
		        url = args[2];
		        
		    } 
		    catch (NumberFormatException ex) 
		    {
		        System.err.println("Argument" + args[0] + " must be an integer.");
		        System.exit(Exception - 100);
		    }
		}
		else
		{
			System.exit(-3);
			//url = "http://10.16.97.38/CyaraWebPortal/1/Report/ResultDetails?mediaType=1&testResultId=129431";
		}
		
		wd = WebDriverLoginLegacy.getCyara(args);
		wd.get(url);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {}
		
		if(wd != null)
		{
			int i = 0;
			wd.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
			String text = wd.findElement(By.tagName("html")).getText();
			while(!wd.findElement(By.tagName("html")).getText().contains("Answered") && i < 12)  // && !wd.findElement(By.tagName("html")).getText().contains("Other Failure")
			{
				if(wd.findElement(By.tagName("html")).getText().contains("Connection Error") || wd.findElement(By.tagName("html")).getText().contains("Internal Error") || wd.findElement(By.tagName("html")).getText().contains("Other Failure") || wd.findElement(By.tagName("html")).getText().contains("No answer"))
					break;
				try 
				{
					wd.quit();
					Thread.sleep(2000);
					wd = WebDriverLoginLegacy.getCyara(args);
					wd.get(url);
					i++;
					Thread.sleep(10000);
				} 
				catch (InterruptedException ex) 
				{
					System.err.println(ex);
					ex.printStackTrace();
				}
			}
			 
		    if((wd.findElement(By.tagName("html")).getText().contains("Connection Error")) || (wd.findElement(By.tagName("html")).getText().contains("No answer within 10 seconds")) || wd.findElement(By.tagName("html")).getText().contains("Internal Error"))
		    {
			    result = -999;
		    }
		    else if((wd.findElement(By.tagName("html")).getText().contains("Aborted")))
		    {
		    	result = -998;
		    }
		    else if(step == 0 && state == true)
			{
				exists = (wd.findElement(By.tagName("html")).getText().contains("Success"));
			    if(exists && result != Exception && wd.findElement(By.tagName("html")).getText().contains("Answered"))
			    {
				    result = 0;
			    }
			    exists = (wd.findElement(By.tagName("html")).getText().contains("Failed"));  
			    if(exists && result != Exception)
			    {
				    result = -1;
				    System.out.println("Failed");
				    CheckFailure(wd);
			    }   
			}
		    else if(step != 0 && state == false)
			{
				FalseState(wd, exists, step);
			}
			
			
		}
		
		if(false)//wd.findElement(By.tagName("html")).getText().contains("Internal Error") || wd.findElement(By.tagName("html")).getText().contains("steps but got 2") || wd.findElement(By.tagName("html")).getText().contains("No answer within 10 seconds"))
	    {
	    	try 
	    	{
	    		Thread.sleep(2500);
	    		By css = By.cssSelector("a[href*='/CyaraWebPortal/1/TestCase/Edit/']");
	    		WebElement element = wd.findElement(css);
	    		((JavascriptExecutor)wd).executeScript("arguments[0].click();" , element);
	    		
				Thread.sleep(2500);
				wd.findElement(By.id("PhoneNo")).clear();
		    	wd.findElement(By.id("PhoneNo")).sendKeys(cyaraCalledNum);
		    	wd.findElement(By.id("saveButton")).click();
 			} catch (Exception ex) {result = 5897;}
	    }
		wd.quit();
	    System.exit(result);
	}
	
	public static void CheckFailure(FirefoxDriver wd)
	{
		MailboxOneError(wd);
		
	}
	
	
	public static void MailboxOneError(FirefoxDriver wd)
	{
		if(wd.findElement(By.tagName("html")).getText().contains("Step 1") && wd.findElement(By.tagName("html")).getText().contains("Response time exceeded Major Threshold"))
		{
			result = 100;
	    	return;
		}
		
		if(wd.findElement(By.tagName("html")).getText().contains("steps but got 5"))
	    {
	    	result = 100;
	    	return;
	    }
		else if(wd.findElement(By.tagName("html")).getText().contains("Step 5: No match"))
		{
			if(wd.findElement(By.tagName("html")).getText().contains("VM_UMO_on"))
			{
				result = 100;
		    	return;
			}
		}
		else if(wd.findElement(By.tagName("html")).getText().contains("steps but got 6"))
		{
			if(wd.findElement(By.tagName("html")).getText().contains("VM_MSG_AMPMD_off_"))
		    {
		    	result = 100;
		    	return;
		    }
			if(wd.findElement(By.tagName("html")).getText().contains("VM_MSG_AMP_off"))
		    {
		    	result = 100;
		    	return;
		    }
			if(wd.findElement(By.tagName("html")).getText().contains("VM_MSG_MD_off_"))
		    {
		    	result = 100;
		    	return;
		    }
			if(wd.findElement(By.tagName("html")).getText().contains("VM_FM_off"))
		    {
		    	result = 100;
		    	return;
		    }
		    if(wd.findElement(By.tagName("html")).getText().contains("VM_SDD_on"))
		    {
		    	result = 100;
		    	return;
		    }
		    if(wd.findElement(By.tagName("html")).getText().contains("VM_MM_off"))
		    {
		    	result = 100;
		    	return;
		    }
		    if(wd.findElement(By.tagName("html")).getText().contains("VM_MSG_CS_EMA"))
		    {
		    	result = 100;
		    	return;
		    }
		    if(wd.findElement(By.tagName("html")).getText().contains("VM_FIFO_on"))
		    {
		    	result = 100;
		    	return;
		    }
		    if(wd.findElement(By.tagName("html")).getText().contains("VM_MQP_off"))
		    {
		    	result = 100;
		    	return;
		    }
		    if(wd.findElement(By.tagName("html")).getText().contains("VM_RHI"))
		    {
		    	result = 100;
		    	return;
		    }
		    if(wd.findElement(By.tagName("html")).getText().contains("VM_CMP_off"))
		    {
		    	result = 100;
		    	return;
		    }
		    if(wd.findElement(By.tagName("html")).getText().contains("VM_CME_on"))
		    {
		    	result = 100;
		    	return;
		    }
		    if(wd.findElement(By.tagName("html")).getText().contains("VM_UMO_on"))
		    {
		    	result = 100;
		    	return;
		    }
		    
		}
		else if(wd.findElement(By.tagName("html")).getText().contains("steps but got 7"))
		{
			result = 100;
	    	return;
			/*
			if(wd.findElement(By.tagName("html")).getText().contains("VM_MD_UMO_on"))
		    {
		    	result = 100;
		    	return;
		    }
			if(wd.findElement(By.tagName("html")).getText().contains("VM_FM_off"))
		    {
		    	result = 100;
		    	return;
		    }
			if(wd.findElement(By.tagName("html")).getText().contains("VM_MD_on"))
		    {
		    	result = 100;
		    	return;
		    }
			if(wd.findElement(By.tagName("html")).getText().contains("VM_MQP_on"))
		    {
		    	result = 100;
		    	return;
		    }
		    if(wd.findElement(By.tagName("html")).getText().contains("AMPMD_off"))
		    {
		    	result = 100;
		    	return;
		    }
		    if(wd.findElement(By.tagName("html")).getText().contains("VM_MSG_MD_off"))
		    {
		    	result = 100;
		    	return;
		    }
		    if(wd.findElement(By.tagName("html")).getText().contains("Leave_3_messages"))
		    {
		    	result = 100;
		    	return;
		    }
		    if(wd.findElement(By.tagName("html")).getText().contains("Leave_3_urgent_messages"))
		    {
		    	result = 100;
		    	return;
		    }
		    */

		}
		else if(wd.findElement(By.tagName("html")).getText().contains("VM_MSG_on") && wd.findElement(By.tagName("html")).getText().contains("Step 4"))
		{
			result = 100;
			return;
		}
		else if(wd.findElement(By.tagName("html")).getText().contains("steps but got 1") || wd.findElement(By.tagName("html")).getText().contains("Step 1: No match"))
		{
			result = 100;
			return;
		}
		else if(wd.findElement(By.tagName("html")).getText().contains("steps but got 2") || wd.findElement(By.tagName("html")).getText().contains("Step 2: No match"))
		{
			result = 100;
			return;
		}
		else if(wd.findElement(By.tagName("html")).getText().contains("steps but got 3") || wd.findElement(By.tagName("html")).getText().contains("Step 3: No match"))
		{
			result = 100;
			return;
		}
		else if(wd.findElement(By.tagName("html")).getText().contains("steps but got 4")) //|| wd.findElement(By.tagName("html")).getText().contains("Step 4: No match"))
		{
			result = 100;
			return;
		}
		else if(wd.findElement(By.tagName("html")).getText().contains("VM_CMP_off") && (wd.findElement(By.tagName("html")).getText().contains("steps but got 10") || wd.findElement(By.tagName("html")).getText().contains("steps but got 8")))
		{
			result = 100;
			return;
		}
			
		if(wd.findElement(By.tagName("html")).getText().contains("Leave_message"))
		{
			if(wd.findElement(By.tagName("html")).getText().contains("Step 4: No match"))
			{
				result = 100;
				return;
			}
		}
		
		
		if(wd.findElement(By.tagName("html")).getText().contains("Expected 37 steps"))
		{
			result = 100;
	    	return;
		}
		if(wd.findElement(By.tagName("html")).getText().contains("No Call Engines were able to make the call"))
		{
			result = 100;
			try 
			{
				Thread.sleep(10000);
			} 
			catch (InterruptedException ex) 
			{
				ex.printStackTrace();
			}
	    	return;
		}
		
		
	}
	
	public static void FalseState(FirefoxDriver wd, boolean exists, int step)
	{
		exists = (wd.findElement(By.tagName("html")).getText().contains("Success"));
	    if(exists && result != Exception && wd.findElement(By.tagName("html")).getText().contains("Answered"))
	    {
		    result = -1;
		    System.out.println("Failed");
	    }
	    exists = (wd.findElement(By.tagName("html")).getText().contains("Failed"));  
	    if(exists && result != Exception )
	    {
	    	if(wd.findElement(By.tagName("html")).getText().contains("Expected " +step+" steps but got"))
	    		result = 0;
	    	else if(wd.findElement(By.tagName("html")).getText().contains("Step " +step+": No match"))
	    		result = 0;	
	    }
	}
}


/*

865070-865080 Audiotext
865090 VM,865091-93 AT, 865094 UCD, 890001-10 890900-13 AT, 890914-16 VM Night Maintenance NewSavDel, 890917-890999 AT, 899990 TeachB
box 900000-900004 use all types (00 VM)(01 AT)(02 UCD)(03 FO)(04 TB)
Boxes 900005(Randy Orton)-900250 type voicemail



























*/

