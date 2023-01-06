
package WebAdminVerify;

import login.WebDriverLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class T17903_MaxNum_BoxNumField
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//T17903_MaxNum_BoxNumField-t0
	
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    //
	    result = 0;
	    //reset box
	    WebDriverLogin.searchBoxRange(wd, "00000000001", "99999999990", 2500);
	    String boxes = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblBoxCount")).getText();
	    int boxesNum = 0;
	    
	    try 
	    {
	    	boxesNum = Integer.parseInt(boxes);
    	} 
	    catch (NumberFormatException e)
	    {
	    	result += -10;
	    }
	    
	    if(boxesNum < 0)
	    	result += -10;
	    
	    wd.quit();
		//
		
  	   	//
		System.exit(result);
	}
}
