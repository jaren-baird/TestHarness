
package Greeting;

import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T18554_Greeting_Length
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T18554_Greeting_Length-t0
	
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
		result = 0;
	    //
		WebDriverLogin.searchBoxRange(wd, "900006", "900006", 2500);
		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).isSelected()) {
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
		}
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset")) {
		    System.out.println("");
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Boxes")) {
		    System.out.println("");
		}
		wd.findElement(By.linkText("Greetings")).click();
		WebDriverLogin.waitT(wd, 250);
		if(!wd.findElement(By.id("uxChkResetGrtAll")).isSelected()) {
		    wd.findElement(By.id("uxChkResetGrtAll")).click();
		}
		if(!wd.findElement(By.tagName("html")).getText().contains("Submit")) {
		    System.out.println("");
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
		WebDriverLogin.waitT(wd, 1500);
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
		{
		    System.out.println("reset failed");
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
		
		//
		WebDriverLogin.waitT(wd, 1500);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		WebDriverLogin.waitT(wd, 750);
		wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings")).click();
		WebDriverLogin.waitT(wd, 1500);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxTxtGreetingLength")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxTxtGreetingLength")).sendKeys("9999999");
		WebDriverLogin.waitT(wd, 750);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsSubmit")).click();
		WebDriverLogin.waitT(wd, 1500);
		if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
		{}
		WebDriverLogin.waitT(wd, 1500);
		String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxTxtGreetingLength")).getAttribute("value");
		
		if(value == null)
			result += -1000;
		else if(value.length() == 0)
	   	{
			result += -300;
			System.out.println("Value was blank");
	   	}
	   	else if(Integer.parseInt(value) > 9999)
	  	{
	  		result += -200;
	  		System.out.println("Maximum Number of seconds greater than 9999");
	  	}
	   	else if(value.contains("9999"))
	   		System.out.println("Maximum Number of seconds is 9999");
	   	else
	   		result = -1;
	  	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsClose")).click();
	  	WebDriverLogin.waitT(wd, 1500);
		wd.quit();
		//
  	   	System.exit(result);
	}
}