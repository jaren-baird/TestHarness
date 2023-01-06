
package WebAdmin;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class T20744_ReportModuleToModule
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T20744_ReportModuleToModule-t0
	//Test Case 20744:WebAdmin - Validate the ability to browse from Reporting Module to other module without refreshing...
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			//System Parameters Reporting
			Actions builder = new Actions(wd);
	        
	        try
	        {
	        	builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'System Parameters')]"))).perform();
	        	WebDriverLogin.waitT(wd, 200);
		        wd.findElement(By.linkText("Reporting")).click();
		        WebDriverLogin.waitT(wd, 2000);
		        result += selectReport(wd, "AdminActivityLog.txt", "Users Activity Log Report");
		        result += selectReport(wd, "AlarmLog.txt", "Alarm Log Report");
		        result += selectReport(wd, "BoxHistoryReport.txt", "Box History Report");
		        result += selectReport(wd, "CountBoxesByBoxRights.txt", "Count Number of Boxes by Box Rights");
		        result += selectReport(wd, "CustomReport.txt", "Custom SQL Report");
		        result += selectReport(wd, "LastTimeUserLoggedIn.txt", "Find the last time a user logged in");
		        result += selectReport(wd, "Messages.txt", "Messages Report");
		        result += selectReport(wd, "UsersHistoryLog.txt", "Users History Log Report");
		        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
	        	WebDriverLogin.waitT(wd, 2000);
	        }
	        catch(Exception ez)
	        {
	        	result += -1090;
	        }
	        
	        wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += -109;
			ex.printStackTrace();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		
        System.exit(result);
	}
	
	public static int selectReport(ChromeDriver wd, String reportText, String reportTitle)
	{
		int result = 0;
		//
		try
		{
			WebDriverLogin.waitT(wd, 500);
	        WebElement mySelectElm = wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingScripts")); 
	        Select mySelect = new Select(mySelectElm);
	        String value = wd.findElementByTagName("html").getText();
	        if(value.contains(reportText))
	        {
		        mySelect.selectByVisibleText(reportText);//"AdminActivityLog.txt");
		        wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingSelect")).click();
		        WebDriverLogin.waitT(wd, 1000);
		        value = wd.findElement(By.id("ctl00_uxCphContent_ucReporting_lbReportingDescription")).getText();
		        if(!value.contains(reportTitle))
		        	result += -10;
	        }
		}
		catch(Exception ex)
		{
			result = -109;
		}
		//
		return result;
	}
}
	
	