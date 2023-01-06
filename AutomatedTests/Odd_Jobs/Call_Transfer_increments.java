
import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;


public class Call_Transfer_increments
{
	private static int result = 0;
	private static int Exception = -2;
	private static String FilePath = "\\\\CWENGFS\\Tests\\TestJars\\table\\ErrorTable.jar";
	//Test Case 19547:DLists - Using the phone change the name of the lists
	//WA_TS_tui_EditDLists-t0
	
	public static void main(String[] args) throws Exception
	{
		String url = "";
		String ip = "";
		if(args == null || args.length == 0)
		{
			ip = "10.16.97.26";
		}
		else
		{
			ip = args[0];
		}
		
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
        
        while (!wd.findElement(By.tagName("html")).getText().contains("DList")) {
        	wd.findElement(By.linkText("Cyara Testing")).click();
        	WebDriverLogin.waitT(wd, 1000);
        }
        while (!wd.findElement(By.tagName("html")).getText().contains("TestSuite")) {
        	wd.findElement(By.linkText("DList")).click();
        	WebDriverLogin.waitT(wd, 1000);
        }
        while (!wd.findElement(By.tagName("html")).getText().contains("DListSetup")) {
        	wd.findElement(By.linkText("TestSuite")).click();
        	WebDriverLogin.waitT(wd, 1000);
        }
        wd.findElement(By.linkText("DListSetup")).click();
        
        JavascriptExecutor js = (JavascriptExecutor) wd;
        
        for(int i = 1; i < 11; i++)
        {
	        wd.findElement(By.linkText("Call Transfer")).click();
	        js.executeScript("document.getElementById('Div_Id').innerHTML="+ ("0."+i));
	        //edtPsst editable editable-click
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
			//
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 60000);
        }
        
        if(result != Exception)
        {
     	   //url = wd.getCurrentUrl();
     	   //RunJar(url);
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
