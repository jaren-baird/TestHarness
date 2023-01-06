
package WebAdmin;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class T20750_ValidateMaintenance_SystemParameters
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T20750_ValidateMaintenance_SystemParameters-t0
	//Test Case 20750:WebAdmin - Validate that the Maintenance settings in System Parameters can be modified and saved.
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			//System Parameters
			Actions builder = new Actions(wd);
	        
	        try
	        {
	        	builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'System Parameters')]"))).perform();
	        	WebDriverLogin.waitT(wd, 200);
		        wd.findElement(By.linkText("Maintenance")).click();
		        WebDriverLogin.waitT(wd, 2000);
	        	if(selectElementString(wd, "ctl00_uxCphContent_ucMaintenance_uxDdlMaint_Hour", "12 AM", true, "3 AM") != 0)
	        		System.out.println("Maintenance Hour wasn't 12 AM");
	        	if(selectElementString(wd, "ctl00_uxCphContent_ucMaintenance_uxDdlLinkManagerHeartbeat", "1 minutes", true, "30 seconds") != 0)
	        		System.out.println("Link Manager Heartbeat Interval wasn't disabled"); // changed from disabled due to email heartbeat spam
	        	wd.findElement(By.id("ctl00_uxCphContent_ucMaintenance_uxBtnSubmitMaintenance")).click();
	        	WebDriverLogin.waitT(wd, 2000);
	        	if(!wd.findElement(By.id("ctl00_uxCphContent_ucMaintenance_uxLblMaint_Status")).getText().contains("Change Accepted"))
	        		result += -10;
	        	wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
	        	WebDriverLogin.waitT(wd, 2500);
	        	//
	        	builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'System Parameters')]"))).perform();
	        	WebDriverLogin.waitT(wd, 200);
		        wd.findElement(By.linkText("Maintenance")).click();
		        WebDriverLogin.waitT(wd, 2000);
	        	result += selectElementString(wd, "ctl00_uxCphContent_ucMaintenance_uxDdlMaint_Hour", "3 AM", true, "12 AM");
	        	result += selectElementString(wd, "ctl00_uxCphContent_ucMaintenance_uxDdlLinkManagerHeartbeat", "30 seconds", true, "1 minutes");
	        	wd.findElement(By.id("ctl00_uxCphContent_ucMaintenance_uxBtnSubmitMaintenance")).click();
	        	WebDriverLogin.waitT(wd, 2000);
	        	wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
	        	WebDriverLogin.waitT(wd, 2000);
	        }
	        catch(Exception ex)
	        {
	        	result += -109;
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
	
	public static int selectElementString(ChromeDriver wd, String eID, String currentValue, boolean state, String newValue)
	{
		int result = 0;
		//
		try
		{
			WebDriverLogin.waitT(wd, 200);
			Select select = new Select(wd.findElement(By.id(eID)));
	        WebElement option = select.getFirstSelectedOption();
			String value = option.getText();
	        if(!value.contains(currentValue) && state == true)
	        {
	        	result += -10;
	        	System.out.println(eID);
	        }
	        else if(value.contains(currentValue) && state == false)
	        {
	        	result += -10;
	        	System.out.println(eID);
	        }
	        else
	        {
	    		select.selectByVisibleText(newValue);
	        }
			WebDriverLogin.waitT(wd, 200);
		}
		catch(Exception ex)
		{
			result += -109;
		}
		//
		return result;
	}
}
	
	