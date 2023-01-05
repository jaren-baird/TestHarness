package login;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

import login.WebDriverLogin;
//Dev version Error Table
public class ErrorTable 
{
	private static int result = 44;
	private static int Exception = -109;
	private static ChromeDriver wd = null;
	//private static String cyaraCalledNum = "5897@10.16.99.23";
	
	public static int errorTable(ChromeDriver wd, String[] args)
	{
		boolean state = true;
		boolean exists = true;
		int step = 0;
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
		        //url = args[2];
		        
		    } 
		    catch (NumberFormatException ex) 
		    {
		        System.err.println("Argument" + args[0] + " must be an integer.");
		        return Exception;
		    }
		}
		
		//wd = WebDriverLogin.getCyara(args);
		//wd.get(url);
		WebDriverLogin.waitT(wd, 1500);
		
		if(wd != null)
		{
			int i = 0;
			wd.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
			String text = wd.findElement(By.tagName("html")).getText();
			while(!text.contains("Answered"))// && i < 24)  // && !wd.findElement(By.tagName("html")).getText().contains("Other Failure")
			{
				if(text.contains("Connection Error") || text.contains("Internal Error") || text.contains("Other Failure") || text.contains("No answer") || text.contains("Aborted"))
					break;
				else
					text = wd.findElement(By.tagName("html")).getText();
				try 
				{
					i++;
					WebDriverLogin.waitT(wd, 10000);
				} 
				catch (Exception ex) 
				{
					System.err.println(ex);
					ex.printStackTrace();
				}
			}
			
			text = wd.findElement(By.tagName("html")).getText();
		    if((text.contains("Connection Error")) || (text.contains("No answer within 10 seconds")) || text.contains("Internal Error"))
		    {
			    result = -999;
		    }
		    else if((text.contains("Aborted")))
		    {
		    	result = -998;
		    }
		    else if(step == 0 && state == true)
			{
				exists = (text.contains("Success"));
			    if(exists && result != Exception && text.contains("Answered"))
			    {
				    result = 0;
			    }
			    exists = (text.contains("Failed"));  
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

		return result;
	}
	
	public static void main(String[] args)
	{
		boolean state = true;
		int step = 0;
		ChromeDriver wd = null;
    	
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
		
		wd = WebDriverLogin.getCyara(args);
		wd.get(url);
		WebDriverLogin.waitT(wd, 1500);
		
		if(wd != null)
		{
			int i = 0;
			wd.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
			String text = wd.findElement(By.tagName("html")).getText();
			while(!wd.findElement(By.tagName("html")).getText().contains("Answered") && i < 25)  // && !wd.findElement(By.tagName("html")).getText().contains("Other Failure")
			{
				if(wd.findElement(By.tagName("html")).getText().contains("Connection Error") || wd.findElement(By.tagName("html")).getText().contains("Internal Error") || wd.findElement(By.tagName("html")).getText().contains("Other Failure") || wd.findElement(By.tagName("html")).getText().contains("No answer"))
					break;
				try 
				{
					wd.quit();
					WebDriverLogin.waitT(wd, 2000);
					wd = WebDriverLogin.getCyara(args);
					wd.get(url);
					i++;
					WebDriverLogin.waitT(wd, 10000);
				} 
				catch (Exception ex) 
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
			
		    if(!wd.findElement(By.tagName("html")).getText().contains("Answered"))
		    {
			    result = -209;
		    }
		}
		
		/*
		if(false)//wd.findElement(By.tagName("html")).getText().contains("Internal Error") || wd.findElement(By.tagName("html")).getText().contains("steps but got 2") || wd.findElement(By.tagName("html")).getText().contains("No answer within 10 seconds"))
	    {
	    	try 
	    	{
	    		WebDriverLogin.waitT(wd, 2500);
	    		By css = By.cssSelector("a[href*='/CyaraWebPortal/1/TestCase/Edit/']");
	    		WebElement element = wd.findElement(css);
	    		((JavascriptExecutor)wd).executeScript("arguments[0].click();" , element);
	    		
				WebDriverLogin.waitT(wd, 2500);
				wd.findElement(By.id("PhoneNo")).clear();
		    	wd.findElement(By.id("PhoneNo")).sendKeys(cyaraCalledNum);
		    	wd.findElement(By.id("saveButton")).click();
 			} catch (Exception ex) {result = 5897;}
	    }*/
		
		wd.quit();
	    System.exit(result);
	}
	
	public static void CheckFailure(ChromeDriver wd)
	{
		//MailboxOneError(wd);
		mailboxCrashStep2(wd);
	}
	
	public static void FalseState(ChromeDriver wd, boolean exists, int step)
	{
		exists = (wd.findElement(By.tagName("html")).getText().contains("Success"));
	    if(exists && result != Exception && wd.findElement(By.tagName("html")).getText().contains("Answered"))
	    {
		    result = 0;
	    }
	    else
	    {
	    	result = -1;
		    System.out.println("Failed being answered");
	    }
	    exists = (wd.findElement(By.tagName("html")).getText().contains("Failed"));  
	    if(exists && result != Exception )
	    {
	    	if(wd.findElement(By.tagName("html")).getText().contains("Expected " +step+" steps but got"))
	    		result = 0;
	    	else if(wd.findElement(By.tagName("html")).getText().contains("Step " +step+": No match"))
	    		result = 0;	
	    }
	    else
	    	result += -10;
	}
	
	public static void mailboxCrashStep2(ChromeDriver wd)
	{
		if(wd.findElement(By.tagName("html")).getText().contains("steps but got 2"))
	    {
	    	result = -1000000;
	    	return;
	    }
	}
	
	/*
	public static void MailboxOneError(ChromeDriver wd)
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
		    ///

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
			WebDriverLogin.waitT(wd, 10000);
			
	    	return;
		}
		
		
	}*/
	
	
}


/*

865070-865080 Audiotext
865090 VM,865091-93 AT, 865094 UCD, 890001-10 890900-13 AT, 890914-16 VM Night Maintenance NewSavDel, 890917-890999 AT, 899990 TeachB
box 900000-900004 use all types (00 VM)(01 AT)(02 UCD)(03 FO)(04 TB)
Boxes 900005(Randy Orton)-900250 type voicemail



























*/

