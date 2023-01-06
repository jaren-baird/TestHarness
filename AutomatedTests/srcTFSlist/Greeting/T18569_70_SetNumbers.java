
package Greeting;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T18569_70_SetNumbers
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T18569_70_SetNumbers-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
	    //
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetGreetingTab(wd, "900006", "900006");
			WebDriverLogin.searchBoxRange(wd, "900006", "900006", 1000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 1500);
			wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings")).click();
			WebDriverLogin.waitT(wd, 2500);
			forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreetingMaxNumGreetings", "3");
			forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudDefGreeting", "1");
			forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudBusyGreeting", "2");
			WebDriverLogin.waitT(wd, 1000);
			
			Select select = null;
			WebElement option = null;
			String value = "";
			int i = 0;
			while(!value.contains("3"))
			{
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudNoAnsGreeting")).sendKeys("3");
				WebDriverLogin.waitT(wd, 1000);
				select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudNoAnsGreeting")));
				option = select.getFirstSelectedOption();
				value = option.getText();
				if(i > 20)
				{
					result += -10000;
					break;
				}
				i++;
			}
			
			WebDriverLogin.waitT(wd, 1500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsSubmit")).click();
			WebDriverLogin.waitT(wd, 1500);
			if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
			{
				System.out.println("Update failed");
			}
	
			if(!selectOption(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudDefGreeting").contains("1"))
				result += -10;
			if(!selectOption(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudBusyGreeting").contains("2"))
				result += -20;
			if(!selectOption(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudNoAnsGreeting").contains("3"))
				result += -40;
			
		  	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsClose")).click();
		  	WebDriverLogin.waitT(wd, 2000);
		  	wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += -109;
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		//
		
  	   	System.exit(result);
	}
	
	public static String selectOption(ChromeDriver wd, String id) throws InterruptedException
	{
		String value = "";
		Select select = null;
		WebElement option = null;

		WebDriverLogin.waitT(wd, 1000);
		select = new Select(wd.findElement(By.id(id)));
		option = select.getFirstSelectedOption();
		value = option.getText();
		
		return value;
	}
	
	public static void forceChange(ChromeDriver wd, String field, String value)
	{
		Select select = new Select(wd.findElement(By.id(field)));
		WebElement option = select.getFirstSelectedOption();
		String valueX = option.getText();
		try
		{
			while(!valueX.contains(value))
			{
				wd.findElement(By.id(field)).sendKeys(value);
				WebDriverLogin.waitT(wd, 250);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxLblGreetingLength")).click();
				WebDriverLogin.waitT(wd, 250);
				select = new Select(wd.findElement(By.id(field)));
				option = select.getFirstSelectedOption();
				valueX = option.getText();
			}
		}
		catch (Exception ex){}
	}
}