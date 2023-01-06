
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

public class Box_History
{
	//-t3
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
        mySelect.selectByVisibleText("BoxHistoryReport.txt");
        
        wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingSelect")).click();
        wd.findElement(By.id("txtBoxID(s)")).sendKeys("8");
        
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        //Date date = new Date();
        //String dateString = sdf.format(date);
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);    
        String dateString = sdf.format(cal.getTime());
        wd.findElement(By.id("caltxtboxStartDate")).clear();
        wd.findElement(By.id("caltxtboxStartDate")).sendKeys(dateString);
        cal.add(Calendar.DATE, 2);
        dateString = sdf.format(cal.getTime());
        wd.findElement(By.id("caltxtboxEndDate")).clear();
        wd.findElement(By.id("caltxtboxEndDate")).sendKeys(dateString);
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
		
		wd.quit();
		System.exit(result);
	}
	
	public static void CheckFields(ChromeDriver wd) throws InterruptedException
	{
		WebDriverLogin.waitT(wd, 1000);
		if(!wd.findElement(By.tagName("html")).getText().contains("Login")) 
        {
			result += -1;
        }
		if(!wd.findElement(By.tagName("html")).getText().contains("WEBADMINTEST")) 
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
