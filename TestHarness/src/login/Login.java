package login;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import login.WebDriverLogin;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.*;


public class Login 
{
	public static void main(String[] args) throws Exception
	{
		int result = 0;
		int count = 0;
		String testName = "box number login"; //"box number login" //"box number Lv Msg"

		String ip = "10.16.97.26";
		boolean exists;
		
		ChromeDriver wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wd.get("http://"+ip+"/CyaraWebPortal/public/login");
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
        if(!wd.findElement(By.tagName("html")).getText().contains("Cyara Testing")) {
            System.out.println("");
        }
        wd.findElement(By.linkText("Cyara Testing")).click();
        wd.findElement(By.linkText("Voice Rec")).click();
        while (!wd.findElement(By.tagName("html")).getText().contains("Login")) {
            System.out.println("");
            WebDriverLogin.waitT(wd, 1000);
            wd.findElement(By.linkText("Voice Rec")).click();
        }
        wd.findElement(By.linkText("Login")).click();
        while (!wd.findElement(By.tagName("html")).getText().contains(testName)) {
            System.out.println("verifyTextPresent failed");
            WebDriverLogin.waitT(wd, 1000);
            wd.findElement(By.linkText("Login")).click();
        }
        wd.findElement(By.linkText(testName)).click();
        wd.findElement(By.id("executeButton")).click();
		WebDriverLogin.waitT(wd, 40000);
        
        if(wd != null)
		{
        	wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			exists = (wd.findElement(By.tagName("html")).getText().contains("Connection Error") || wd.findElement(By.tagName("html")).getText().contains("No answer within 10 seconds")); 
		    if(exists)
		    {
			    result = -999;
			    System.out.println("Connection Error");
		    }
		    
		    while(result == 0)
		    {
		    	if(wd.findElement(By.tagName("html")).getText().contains("Answered") && !wd.findElement(By.tagName("html")).getText().contains("Aborted"))
		    	{
		    		exists = (wd.findElement(By.tagName("html")).getText().contains("Failed"));  
				    if(exists)
				    {
					    result = -1;
					    System.out.println("Failed");
				    }
					exists = (wd.findElement(By.tagName("html")).getText().contains("Success"));
				    if(exists && result == 0 && wd.findElement(By.tagName("html")).getText().contains("Answered"))
				    {
					    result = 0;
					    count += 1;
					    System.out.println(count);
					    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					    if(!wd.findElement(By.tagName("html")).getText().contains(testName)) {
				            System.out.println("verifyTextPresent failed");
				        }
				        wd.findElement(By.linkText(testName)).click();
				        WebDriverLogin.waitT(wd, 1000);
				        wd.findElement(By.id("executeButton")).click();
				        WebDriverLogin.waitT(wd, 30000);
				        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				    }  
		    	}
		    	else if(wd.findElement(By.tagName("html")).getText().contains("Aborted"))
		    	{
				    result = -100;
				    System.out.println("Aborted");
		    	}
		    	else
		    	{
		    		result = -101;
		    	}
		    }
		    
		    
		}
        wd.quit();
    	System.exit(result);
	}
}
