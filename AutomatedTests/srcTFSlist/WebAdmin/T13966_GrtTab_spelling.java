
package WebAdmin;

import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T13966_GrtTab_spelling
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13966_GrtTab_spelling-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String value = "";
		//
		wd = WebDriverLogin.getWebAdmin();
		
		try
		{
			WebDriverLogin.resetGreetingTab(wd, "900006", "900006");
			WebDriverLogin.searchBoxRange(wd, "900006", "900006", 1500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElementByLinkText("Greetings").click();
	        WebDriverLogin.waitT(wd, 1500);
	        //
	        value = wd.findElement(By.tagName("html")).getText();
	        if(!value.contains("Time Blocks Scheduling"))
	        	result += -10;
	        if(!value.contains("Audio Greetings"))
	        	result += -10;
	        if(!value.contains("Start Time"))
	        	result += -10;
	        if(!value.contains("Owner Services"))
	        	result += -10;
	        if(!value.contains("Multi Language Greetings"))
	        	result += -10;
	        if(!value.contains("Greeting/Passcode/Name Edit"))
	        	result += -10;
	        if(!value.contains("Prompts Caller For Language"))
	        	result += -10;
	        if(!value.contains("Keep Language Throughout Call"))
	        	result += -10;
	        
	        
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_LblSlctTimeBlk")).getText().contains("Selected Time Block"))
	        	result += -10;
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_grtSTBLblHour")).getText().contains("Hour"))
	        	result += -10;
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_grtSTBLblMin")).getText().contains("Minute"))
	        	result += -10;
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_STB_GrtLBL_DefGreet")).getText().contains("Default Greeting"))
	        	result += -10;
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_STB_GrtLBL_BsyGreet")).getText().contains("Busy Greeting"))
	        	result += -10;
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_STB_GrtLBL_NAGreet")).getText().contains("No Answer Greeting"))
	        	result += -10;
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxLblGreetingLength")).getText().contains("Length(seconds)"))
	        	result += -10;
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxLblGreetingMaxNumGreetings")).getText().contains("Maximum Number of Greetings"))
	        	result += -10;
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxLblGreeting_AudDefGreeting")).getText().contains("Default Greeting"))
	        	result += -10;
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxLblGreeting_AudBusyGreeting")).getText().contains("Busy Greeting"))
	        	result += -10;
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxLblGreeting_AudNoAnsGreeting")).getText().contains("No Answer Greeting"))
	        	result += -10;
	        
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsClose")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        //
		}
	    catch (Exception ex)
	    {result+=-109;}
		
        wd.quit();
        System.exit(result);
	}
	
	
}
	
	