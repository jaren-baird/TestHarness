
import login.WebDriverLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class BoxNumberLogin
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	
	public static void main(String[] args) throws Exception
	{
		String[] args2 = {""};
        wd = WebDriverLogin.getCyara(args2);
        int i = 5;
        
		while (!wd.findElement(By.tagName("html")).getText().contains("Voice Rec")) {
        	wd.findElement(By.linkText("Cyara Testing")).click();
        	WebDriverLogin.waitT(wd, 1000);
        }
        while (!wd.findElement(By.tagName("html")).getText().contains("Login")) {
        	wd.findElement(By.linkText("Voice Rec")).click();
        	WebDriverLogin.waitT(wd, 1000);
        }
        wd.findElement(By.linkText("Login")).click();
        WebDriverLogin.waitT(wd, 1000);
        
        do
        {
	        wd.findElement(By.linkText("box number login")).click();
	        WebDriverLogin.waitT(wd, 1500);
	 
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        
			//
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 40000);
	        //String url = wd.getCurrentUrl();
	        //result = WebDriverLogin.RunErrorTable(url);
	        i++;
	        if((wd.findElement(By.tagName("html")).getText().contains("Connection Error")) || (wd.findElement(By.tagName("html")).getText().contains("No answer within 10 seconds")))
		    {
			    result = -999;
		    }
		    else if((wd.findElement(By.tagName("html")).getText().contains("Aborted")))
		    {
		    	result = -998;
		    }
        }while(result != -999 && result != -998);
        
  	   	//
        System.out.println("Program ran "+i+" Times");
  	   	wd.quit();
		System.exit(i);
	}
}

/*
	try
	{
		do
        {
	        wd.findElement(By.linkText("box number login")).click();
	        WebDriverLogin.waitT(wd, 1500);
	 
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        
			//
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 40000);
	        //String url = wd.getCurrentUrl();
	        //result = WebDriverLogin.RunErrorTable(url);
	        i++;
	        if((wd.findElement(By.tagName("html")).getText().contains("Connection Error")) || (wd.findElement(By.tagName("html")).getText().contains("No answer within 10 seconds")))
		    {
			    result = -999;
		    }
		    else if((wd.findElement(By.tagName("html")).getText().contains("Aborted")))
		    {
		    	result = -998;
		    }
        }while(result != -999 || result != -998);
	}
	catch (Exception ex){}
	finally
	{
		System.out.println("Program ran "+i+" Times");
  	   	wd.quit();
		System.exit(i);
	}
*/