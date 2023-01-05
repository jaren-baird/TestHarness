import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class Test_SD_on
{
	private static int result = 9;
	private static int Exception = -2;
	
	public static void main(String[] args) throws Exception
	{
		String ip = "";
		if (args == null || args.length == 0)
			ip = "10.16.97.26";
		else
			ip = args[0];
		
		FirefoxDriver wd;
		wd = new FirefoxDriver();
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
        if (!wd.findElement(By.tagName("html")).getText().contains("Cyara Testing")) {
            System.out.println("");
        }
        wd.findElement(By.linkText("Cyara Testing")).click();
        wd.findElement(By.linkText("Owner Services")).click();
        if (!wd.findElement(By.tagName("html")).getText().contains("Pages")) {
            System.out.println(" ");
        }
        if (!wd.findElement(By.tagName("html")).getText().contains("3")) {
            System.out.println(" ");
        }
        wd.findElement(By.linkText("3")).click();
        wd.findElement(By.linkText("VM_SDD_on")).click();
        if (!wd.findElement(By.tagName("html")).getText().contains("Associated Steps")) {
            System.out.println(" ");
        }
        if (!wd.findElement(By.tagName("html")).getText().contains("Insert Block")) {
            System.out.println(" ");
        }
        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
            System.out.println(" ");
        }
        if (!(wd.findElements(By.cssSelector("span.brand")).size() != 0)) {
            System.out.println(" ");
        }
        wd.findElement(By.id("executeButton")).click();
       Thread.sleep(55000);
       
       wd.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
       boolean exists = (wd.findElement(By.tagName("html")).getText().contains("Success"));
       wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
       if(exists && result != Exception)
    	   result = 0;
		
       wd.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
       exists = (wd.findElement(By.tagName("html")).getText().contains("Failed"));
       wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);    
       if(exists && result != Exception)
    	   result = -1;
       
       wd.quit();
       System.exit(result);
	}
    
    public static boolean isAlertPresent(FirefoxDriver wd) 
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

}