
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

public class Mailboxes_Never_Logged_In
{
	//-t2
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
        mySelect.selectByVisibleText("ShowMailBoxesThatHaventLoggedIn.txt");
        
        wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingSelect")).click();
        wd.findElement(By.id("caltxtboxSelecttheBeginDate")).clear();
        wd.findElement(By.id("caltxtboxSelecttheBeginDate")).sendKeys("9/16/2000");
        wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingRun")).click();

        WebDriverLogin.waitT(wd, 1000);
        if(wd.findElement(By.tagName("html")).getText().contains("Download File"))
        {
            wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxHpReportingDownload")).click();
            WebDriverLogin.waitT(wd, 500);
        }
        //
        CheckFields(wd);
        //
		
        System.out.println(result);
		wd.quit();
		System.exit(result);
	}
	
	public static void CheckFields(ChromeDriver wd)
	{
		for(int i = 0; i < 13; i++)
		{
			if(wd.findElement(By.tagName("html")).getText().contains("<row ID='"+i+"' Number='"+(1000+i)+"'/>")) 
	        {
				result += -10;
	        }
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



