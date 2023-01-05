
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.*;

public class ErrorTable 
{
	private static int result = 44;
	private static int Exception = -22;
	
	public static void main(String[] args)
	{
		boolean state = true;
		int step = 0;
		FirefoxDriver wd;
    	
		boolean exists = true;
		String url = "";
		
		if (args.length > 0) 
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
			//System.exit(-3);
			url = "http://10.16.97.26/CyaraWebPortal/1/Report/ResultDetails?testResultId=35311&MediaType=Voice";
		}
		
		wd = new FirefoxDriver();
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wd.get(url);
		wd.manage().window().maximize();
		wd.findElement(By.id("Username")).click();
		wd.findElement(By.id("Username")).clear();
		wd.findElement(By.id("Username")).sendKeys("fceleste");
		wd.findElement(By.id("Password")).click();
		wd.findElement(By.id("Password")).clear();
		wd.findElement(By.id("Password")).sendKeys("C@11ware1234");
		wd.findElement(By.id("loginButton")).click();
		
		
		if(wd != null)
		{
			int i = 0;
			wd.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
			
			while(!wd.findElement(By.tagName("html")).getText().contains("Answered") && i < 2 && !wd.findElement(By.tagName("html")).getText().contains("Failed"))
			{
				try 
				{
					i++;
					Thread.sleep(5000);
				} 
				catch (InterruptedException ex) 
				{
					System.err.println(ex);
					ex.printStackTrace();
				}
			}
			 
		    if((wd.findElement(By.tagName("html")).getText().contains("Connection Error")) || (wd.findElement(By.tagName("html")).getText().contains("No answer within 10 seconds")))
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
		
		wd.quit();
	    System.exit(result);
	}
	
	public static void CheckFailure(FirefoxDriver wd)
	{
		MailboxOneError(wd);
		
	}
	
	public static void MailboxOneError(FirefoxDriver wd)
	{
		
		if(wd.findElement(By.tagName("html")).getText().contains("steps but got 5"))
	    {
	    	result = 100;
	    	return;
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
		    
		}
		else if(wd.findElement(By.tagName("html")).getText().contains("steps but got 7"))
		{
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
			
			
		}
		
		if(wd.findElement(By.tagName("html")).getText().contains("Expected 37 steps but got"))
		{
			if(wd.findElement(By.tagName("html")).getText().contains("Leave_3_urgent_messages"))
			{
				result = 100;
		    	return;
			}
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
	    if(exists && result != Exception && (wd.findElement(By.tagName("html")).getText().contains("Expected " +step+" steps but got")))
	    {
		    result = 0;
	    } 
	}

}


