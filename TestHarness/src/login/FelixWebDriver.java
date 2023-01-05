
package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

//Getters and Setters //Cyara //WebAdmin
//Error Table
//Search Box function
//WebAdmin Reset Section
//Setup individual boxes
//Clear MWI

public class FelixWebDriver 
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String chromedriver = "C:\\selenium\\libraries\\chromedriver\\chromedriver.exe";	//Felix needs to change this
	private static String profilePath = "C:\\Users\\jbaird.CALLWARE\\AppData\\Local\\Google\\Chrome\\User Data"; //Felix needs to change this
	public static String FilePath = "\\\\CWENGFS\\Tests\\TestJars\\ErrorTable.jar";
	private static String cyaraIP = "10.16.97.37";
	private static String webadminIP = "https://2016dc.callware.com/WebAdmin/";//"https://webadmintest/WebAdmin/Login.aspx";
	//Getters and Setters
	public static void main(String[] args) throws Exception
	{
		wd = getWebAdmin();
		if(!wd.findElement(By.tagName("html")).getText().contains("Logged in as"))
			result = -1;
		else
			result = 0;
		wd.quit();
		wd = getCyara(args);
		if(!wd.findElement(By.tagName("html")).getText().contains("Test Cases & Blocks"))
			result += -2;
		wd.quit();
		
		System.exit(result);
	}
	
	//Cyara
	public static ChromeDriver getCyara(String[] args)
	{
		wd = new ChromeDriver();
		
		if(wd != null) 
	    {
			wd = CyaraSingleton(args);
	    }
	    return wd;
	} 
	protected static ChromeDriver CyaraSingleton(String[] args)
	{
		String ip = "";
		String url = "";
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        
        while(url.contains("about:blank") || !url.contains("http://"+cyaraIP+"/CyaraWebPortal/public/login"))
    	{
			try 
			{
				waitT(wd, 2000);
				wd.get("http://"+cyaraIP+"/CyaraWebPortal/public/login");
				waitT(wd, 2000);
				url = wd.getCurrentUrl();
			}
			catch
			(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
    	}
        
        
        wd.manage().window().maximize();
        wd.findElement(By.id("Username")).click();
        wd.findElement(By.id("Username")).clear();
        wd.findElement(By.id("Username")).sendKeys("fceleste");
        wd.findElement(By.id("Password")).click();
        wd.findElement(By.id("Password")).clear();
        wd.findElement(By.id("Password")).sendKeys("C@11ware1234");
        wd.findElement(By.id("loginButton")).click();
        wd.findElement(By.cssSelector("a.brand")).click();
        wd.findElement(By.linkText("Test Cases")).click();
        wd.findElement(By.cssSelector("a[title=\"Test Cases & Blocks\"]")).click();
		
		return wd;
	}//Cyara
	
	public static ChromeDriver implicitlyWaitSetter(ChromeDriver wd)
	{
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//new org.openqa.selenium.firefox.
		return wd;
	}
	
	//Chrome Profile
	public static ChromeDriver getFirefoxProfile()
	{
		
		try
		{
			System.setProperty("webdriver.chrome.driver", chromedriver);
			
			String file = profilePath;
			ChromeOptions options = new ChromeOptions();
			options.addArguments("user-data-dir="+profilePath);
			
			wd = new ChromeDriver(options);
		}
		catch(Exception ex)
		{
			System.err.println(ex);
            ex.printStackTrace();
		}
			
		return wd;
	}
	
	//WebAdmin
	public static ChromeDriver getWebAdmin() 
	{
		
		try
		{
			wd = getFirefoxProfile();
			
			if(wd != null) 
			{
				wd = WebAdminSingleton();
			}
			if(result != 0 && wd != null)
			{
				wd = null;
			}
			else if(result == -1001 && wd == null)
			{
				System.out.println("WebAdmin failed Login");
				getWebAdmin();
			}
		}
		catch(Exception ex)
		{
			System.err.println(ex);
            ex.printStackTrace();
		}
		
		return wd;
	}
	
	public static ChromeDriver getJITCWebAdmin() 
	{
		result = -1;
		//ProfilesIni profile = null;
	    //FirefoxProfile ffProfile = null;
			
		while(result != 0)
		{
			//profile = new ProfilesIni();
			//ffProfile = profile.getProfile("default");
			wd = new ChromeDriver();//wd = getFirefoxProfile();
			
			if(wd != null) 
			{
				wd = WebAdminSingleton();
			}
			if(result != 0)
			{
				wd.quit();
				wd = null;
			}
		}
		if(JITCflag = true)
			return wd;
		else
			return null;
	}
	
	public static ChromeDriver getWebAdminLogin(ChromeDriver wd) 
	{
		result = -1;
			
		while(result != 0)
		{
			if(wd != null) 
			{
				wd = WebAdminSingleton();
			}
			if(result != 0)
			{
				wd.quit();
				wd = null;
			}
		}
		
		return wd;
	}
	
	protected static ChromeDriver WebAdminSingleton() 
	{
	      // Exists only to defeat instantiation.
		result = 0;
		try 
        {//wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        	wd.manage().window().maximize();
        } catch (Exception ex) {}
		String url = "";
		int i = 1;
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        url = wd.getCurrentUrl();
        if(url.length() < 1 || url.contains("about:blank") || wd.findElement(By.tagName("html")).getText().contains("User Name"))
        {
	        try 
	        {
	        	while(url.contains("about:blank") || url.length() < 1 && i < 3)
	        	{
					waitT(wd, 100+1000*i);
					wd.get(webadminIP);
					url = wd.getCurrentUrl();
					if(url.length() < 1 || url.contains("about:blank"))
						waitT(wd, 1000+2000*i);
					i++;
	        	}
	        	if(!wd.getCurrentUrl().contains(webadminIP))
	        	{
	        		result = -2;
	        		return wd;
	        	}
				
			}
	        catch(Exception ex)
			{
	        	ex.printStackTrace();
	        	return null;
        	}
	        
	        
	        Alert alert;
	        if(wd.findElement(By.tagName("html")).getText().contains("User Name") || wd.findElement(By.tagName("html")).getText().contains("Password"))
	        {
		        wd.findElement(By.id("uxLogin_UserName")).click();
		        wd.findElement(By.id("uxLogin_UserName")).clear();
		        //wd.findElement(By.id("uxLogin_UserName")).sendKeys("administrator");
		        wd.findElement(By.id("uxLogin_UserName")).sendKeys("jaren");
		        wd.findElement(By.id("uxLogin_Password")).click();
		        wd.findElement(By.id("uxLogin_Password")).clear();
		        //wd.findElement(By.id("uxLogin_Password")).sendKeys("C@11ware");
		        wd.findElement(By.id("uxLogin_Password")).sendKeys("J@ren008");
		        wd.findElement(By.id("uxLogin_LoginButton")).click();
	        }
	        else if(wd.findElement(By.tagName("html")).getText().contains("Agree"))
	        {
	        	wd.findElement(By.id("uxBtnAgreeButton")).click();
	        } 
	        else
	        {
	        	wd.quit();
	        	System.exit(-1001);
	        }  
	        try 
		    { 
		    	alert = wd.switchTo().alert();
		        alert.accept();
		    }   
		    catch (NoAlertPresentException ex) 
		    { 
		    	JITCflag = false;
		    	//nonJitc
		    }
	        waitT(wd, 1000);
	        url = wd.getCurrentUrl();
	        
        }
        if(url.contains(webadminIP))
        {//failure to login
        	result = -1001;
        	wd.quit();
        	wd = null;
        	return wd;
        }
        result = 0;
        return wd;
	}//WebAdmin End
	
	public static ChromeDriver waitT(ChromeDriver wd, int time)
	{
		long multiplier = 1000*1000;
		long estimatedTime = 0;
		long begin = 0;
		long limit = 19999L; //math time is 220 milliseconds
        long largestPrimeFactor = 0;
        
		if(time > 10000)
			multiplier = 1000*1000;
		if(time <= 0)
			time = 1000;
		if(time > 0 && time <= 300)
			limit = 9001; //math time is 48 milliseconds
		if(time > 600000)
			time = 600000;
		long Timer = time;
		
		try 
		{
			
			Timer = Timer * multiplier;
			//Thread.sleep(time * multiplier);
			//
			int i = 0;
			Timer = System.nanoTime()+Timer;//;
			while(true)
			{
				begin = System.nanoTime();
				if(Timer < begin ||i>3005)// && multiplier == 1)
				{
					//estimatedTime = ((int)(Timer - begin)/(10^9));//
					//System.out.println("Time(m): "+time +" ;i: "+i);
					break;
				}
				//estimatedTime = ((int)(Timer - begin)/(10^5));//
				//System.out.println("Time(s): "+estimatedTime+" ;nanoTime: "+ (Timer-begin));
				
		        for (long number = 2; number < limit; number++) {
		            if(isPrime(number)) {
		                if((limit % number == 0)){
		                    largestPrimeFactor = number; 
		                }
		            }
		        }
		        i++;
			}
			//
			
			
		} 
		catch (Exception never) 
		{
			//this should basically never throw
			System.out.println(never);
			never.printStackTrace();
		}
		return wd;
	}
	public static boolean isPrime(long number) {
        for (int i = 2; i < number; i++) {
            if(number % i == 0) {
                return false; 
            }
        }
        return true; 
    }
}
	