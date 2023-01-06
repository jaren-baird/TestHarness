
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

public class Alarm_Log_Report
{
	private static int result = 0;
	
	public static void main(String[] args) throws Exception
	{
		ChromeDriver wd;
		wd = WebDriverLogin.getWebAdmin();
        //
        //WebElement we = wd.findElement(By.xpath("//a[contains(text(),'System Parameters')]"));
        Actions builder = new Actions(wd);
        builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'System Parameters')]"))).perform();
        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbReporting")).click();
        
        WebElement mySelectElm = wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingScripts")); 
        Select mySelect= new Select(mySelectElm);
        mySelect.selectByVisibleText("AlarmLog.txt");
        
        //wd.findElement(By.linkText("AlarmLog")).click();
        wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingSelect")).click();
        wd.findElement(By.id("caltxtboxStartDate")).clear();
        wd.findElement(By.id("caltxtboxStartDate")).sendKeys("8/6/2016");
        wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingRun")).click();
        //
        CheckFields(wd);
        //
		//
		
		wd.quit();
		
		System.exit(result);
	}
	
	public static void CheckFields(ChromeDriver wd) throws InterruptedException
	{
		WebDriverLogin.waitT(wd, 1000);
		if(!wd.findElement(By.tagName("html")).getText().contains("Notified Admins")) 
        {
			result += -1;
        }
		if(!wd.findElement(By.tagName("html")).getText().contains("Channel temporarily locked")) 
        {
			result += -3;
        }
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
