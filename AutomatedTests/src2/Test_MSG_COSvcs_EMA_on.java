
import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

public class Test_MSG_COSvcs_EMA_on
{
	private static int result = 9;
	private static int Exception = -2;
	private static String FilePath = "\\\\CWENGFS\\Tests\\TestJars\\table\\ErrorTable.jar";
	
	public static void main(String[] args) throws Exception
	{
		String url = "";
		String ip = "";
		if(args == null || args.length == 0)
			ip = "10.16.97.26";
		else
			ip = args[0];
		
		ChromeDriver wd;
    	wd = new ChromeDriver();
    	
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        
        wd.get("http://"+ip+"/CyaraWebPortal/public/login");
        wd.manage().window().maximize();
        wd.findElement(By.id("Username")).click();
        wd.findElement(By.id("Username")).clear();
        wd.findElement(By.id("Username")).sendKeys("fceleste");
        wd.findElement(By.id("Password")).click();
        wd.findElement(By.id("Password")).clear();
        wd.findElement(By.id("Password")).sendKeys("[short jitc]1234");
        wd.findElement(By.id("loginButton")).click();
        wd.findElement(By.cssSelector("a.brand")).click();
        wd.findElement(By.linkText("Test Cases")).click();
        wd.findElement(By.cssSelector("a[title=\"Test Cases & Blocks\"]")).click();
        if(!wd.findElement(By.tagName("html")).getText().contains("Cyara Testing")) {
            System.out.println("");
        }
        wd.findElement(By.linkText("Cyara Testing")).click();
		//
        wd.findElement(By.linkText("Owner Services")).click();
        if(!wd.findElement(By.tagName("html")).getText().contains("Pages")) {
            System.out.println(" ");
        }
        if(!wd.findElement(By.tagName("html")).getText().contains("2")) {
            System.out.println(" ");
        }
        wd.findElement(By.linkText("2")).click();
        wd.findElement(By.linkText("VM_MSG_CS_EMA_login")).click();
        if(!wd.findElement(By.tagName("html")).getText().contains("Associated Steps")) {
            System.out.println(" ");
        }
        if(!wd.findElement(By.tagName("html")).getText().contains("Insert Block")) {
            System.out.println(" ");
        }
        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
            System.out.println(" ");
        }
        wd.findElement(By.id("executeButton")).click();
       WebDriverLogin.waitT(wd, 65000);    
		
       if(result != Exception)
       {
    	   url = wd.getCurrentUrl();
    	   RunJar(url);
       }
       
       wd.quit();
       System.exit(result);
	}
    
   public static boolean isAlertPresent(ChromeDriver wd) 
   {
       try 
       {
           wd.switchTo().alert();
           return true;
       } 
       catch (NoAlertPresentException e) 
       {
       	result = Exception;
           return false;
       }
   }
    
   public static void RunJar(String url)
	{
		Process process = null;
		result = 99;
		
		try
		{
			process = Runtime.getRuntime().exec("java -jar " + FilePath + " 0" + " true " + url);
			process.waitFor();
			result = process.exitValue();
		}
		catch (Exception ex)
		{
			System.err.println(ex);
            ex.printStackTrace();
		}
	}
}
