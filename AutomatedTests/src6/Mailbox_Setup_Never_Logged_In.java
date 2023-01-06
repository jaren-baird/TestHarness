
import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Mailbox_Setup_Never_Logged_In
{
	//-t0
	private static int result = 0;
	
	public static void main(String[] args) throws Exception
	{
		ChromeDriver wd;
		wd = WebDriverLogin.getWebAdmin();
        //
        Actions builder = new Actions(wd);
        builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'System Parameters')]"))).perform();
        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbReporting")).click();
        
        WebElement mySelectElm = wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingScripts")); 
        Select mySelect= new Select(mySelectElm);
        mySelect.selectByVisibleText("CountMailBoxesThatHaveBeenSetupandNotLoggedIn.txt");
        
        wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingSelect")).click();
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Show all mail boxes that have been setup, but never logged in."))
        	result += -5;
        
        wd.findElement(By.id("caltxtboxSelecttheBeginDate")).clear();
        wd.findElement(By.id("caltxtboxSelecttheBeginDate")).sendKeys("9/12/2016");
        wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingRun")).click();
        //
        if(!wd.findElement(By.tagName("html")).getText().contains("15467") && !wd.findElement(By.tagName("html")).getText().contains("Count")) 
        	result += -10;
        //
		
        System.out.println(result);
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
            return false;
        }
    }

}
