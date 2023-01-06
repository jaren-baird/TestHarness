
package GreetingTUI;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T18462_Greeting_MaxField
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T18462_Greeting_MaxField-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String url = "";
		try
		{
			//Setup 900006
			int retval = WebDriverLogin.setupBox900006grt();
			if(retval != 0)
				System.out.println("Error occured in WebDriverLogin.setupBox900006grt() Err: " + retval);
			//
	  	   	String box = "900006";
	  	   	wd = WebDriverLogin.getWebAdmin();
	  	   	WebDriverLogin.searchBoxRange(wd, box, box);
	  	   	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    WebDriverLogin.waitT(wd, 2500);
		    wd.findElement(By.linkText("Greetings")).click();
		    WebDriverLogin.waitT(wd, 2500);
		    Select select = null;
			WebElement option = null;
			String value = "";
			while(!value.contains("4"))
			{
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreetingMaxNumGreetings")).sendKeys("4");
				WebDriverLogin.waitT(wd, 500);
				select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreetingMaxNumGreetings")));
				option = select.getFirstSelectedOption();
				value = option.getText();
			}
			WebDriverLogin.waitT(wd, 500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsSubmit")).click();
			WebDriverLogin.waitT(wd, 3000);
		  	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsClose")).click();
		  	WebDriverLogin.waitT(wd, 3000);
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
		//
		try
		{
	        String[] folderList = {"DList", "TestSuite", "Greeting", "GRTPG1", "T18462_MaxField"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 260000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
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
		//
  	   	System.exit(result);
	}
}