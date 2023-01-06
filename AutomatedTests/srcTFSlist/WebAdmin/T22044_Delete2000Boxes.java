
package WebAdmin;

import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T22044_Delete2000Boxes
{
	private static int result = 9;
	private static int exception = -109;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T22044_Delete2000Boxes-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String startNum = "910001";
		String endNum = "912000";
		
		try
    	{
			wd = WebDriverLogin.getWebAdmin();
			if(!searchYieldedResults(wd, "ctl00_uxCphContent_ucBoxes_uxLblBoxStatus", "Search Yielded", "1000", "90000"))
				WebDriverLogin.waitT(wd, 5000);//chrome does not display blank search results on first search
			
			//delete create
    		if(!searchYieldedResults(wd, "ctl00_uxCphContent_ucBoxes_uxLblBoxStatus", "Search Yielded No Results", startNum, endNum))
    			result += deleteBoxes(wd, startNum, endNum);
    		result += createBoxes(wd, startNum, "2000");
    		//check
    		WebDriverLogin.searchBoxRange(wd, startNum, endNum);
    		if(!searchYieldedResults(wd, "ctl00_uxCphContent_ucBoxes_uxLblBoxStatus", "Search Yielded 2000 Results", startNum, endNum))
    			result += fail();
    		//delete check
    		result += deleteBoxes(wd, startNum, endNum);
    		WebDriverLogin.searchBoxRange(wd, startNum, endNum);
    		if(!searchYieldedResults(wd, "ctl00_uxCphContent_ucBoxes_uxLblBoxStatus", "Search Yielded No Results", startNum, endNum))
    			result += fail();
            
    		wd.quit();
    		wd = null;
    	}
    	catch(Exception ex)
    	{
    		result += exception();
    		ex.printStackTrace();
    	}
    	finally
    	{
    		if(wd != null)
    			wd.quit();
    	}
		
		System.exit(result);
	}
	
	public static int deleteBoxes(ChromeDriver wd, String startNum, String endNum)
	{
		int result = 0;
		String value = "";
		try
		{
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Delete")).click();
			WebDriverLogin.waitT(wd, 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartBoxId")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartBoxId")).sendKeys(startNum);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtEndBoxId")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtEndBoxId")).sendKeys(endNum);
			
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbDelWarn_Submit")).click();
			WebDriverLogin.waitT(wd, 5000);
			for(int i = 0; i < 5; i++)
			{
				value = wd.findElementByTagName("html").getText();
	    		if(!value.contains("Boxes successfully deleted"))
	    			WebDriverLogin.waitT(wd, 10000);
	    		else
	    			break;
			}
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbDelWarn_Cancel")).click();
			WebDriverLogin.waitT(wd, 1500);
			
		}
		catch(Exception ex)
		{
			result += exception();
		}
		
		return result;
	}
	
	public static int createBoxes(ChromeDriver wd, String startNum, String createNum)
	{
		int result = 0;
		String value = "";
		
		try
		{
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_New")).click();
			WebDriverLogin.waitT(wd, 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtNumberOfBoxesToCreate")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtNumberOfBoxesToCreate")).sendKeys(createNum);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartAtNumber")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartAtNumber")).sendKeys(startNum);
			
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbNewBoxes_Submit")).click();
			WebDriverLogin.waitT(wd, 4000);
			for(int i = 0; i < 5; i++)
			{
				value = wd.findElementByTagName("html").getText();
	    		if(!value.contains("Boxes successfully"))
	    			WebDriverLogin.waitT(wd, 10000);
	    		else
	    			break;
			}
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbNewBoxes_Cancel")).click();
			WebDriverLogin.waitT(wd, 2500);
		}
		catch(Exception ex)
		{
			result += exception();
		}
		
		return result;
	}
	
	public static boolean searchYieldedResults(ChromeDriver wd, String id, String checkFor, String startNum, String endNum)
	{
		int i = 0;
		for(i = 0; i < 5; i++)
		{
			try
			{
				WebDriverLogin.searchBoxRange(wd, startNum, endNum, 2000);
				String value = wd.findElement(By.id(id)).getText();
				if(value.contains(checkFor))
					return true;
				else if(value.contains("Search Yielded"))
					return false;
				
			}
			catch(Exception ex)
			{
				WebDriverLogin.waitT(wd, 5000);
			}
		}
		if(i == 4)
			result += exception();
		
		return false;
	}
	
	public static int fail()
	{
		return -10;
	}
	
	public static int exception()
	{
		return exception;
	}
}
	
	