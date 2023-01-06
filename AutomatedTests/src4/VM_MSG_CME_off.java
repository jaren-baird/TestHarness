
import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class VM_MSG_CME_off
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//WA_MSG_CS_CME_off-s0
	
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
        //
		try
    	{
    		String box = "1007";
    		WebDriverLogin.searchBoxRange(wd, "1000", "1000");
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
       		WebDriverLogin.waitT(wd, 2500);
       		wd.findElement(By.linkText("Call Options")).click();
       		WebDriverLogin.waitT(wd, 1000);
       		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).isSelected())
       			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).click();
       		WebDriverLogin.waitT(wd, 1000);
       		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOSubmit")).click();
       		WebDriverLogin.waitT(wd, 4000);
       		if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
       			result += -10;
       		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOClose")).click();
       		WebDriverLogin.waitT(wd, 2000);
            //
       		//
       		WebDriverLogin.searchBoxRange(wd, "1007", "1007");
       		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
       		WebDriverLogin.waitT(wd, 1000);
            wd.findElement(By.cssSelector("#__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages > span")).click();
            if(!wd.findElement(By.tagName("html")).getText().contains("Message Parameters")) {
                System.out.println("verifyTextPresent failed");
            }     
            WebDriverLogin.waitT(wd, 1000);
            //Turn off Caller Message Editing
            if(!wd.findElement(By.tagName("html")).getText().contains("Caller Services")) {
                System.out.println("13");
            }
            if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsMsgEditing")).isSelected()) {
                wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkCallerSvcsMsgEditing")).click();
            }
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Submit")).click();
            WebDriverLogin.waitT(wd, 1000);
            if(!wd.findElement(By.tagName("html")).getText().contains("Updated")) {
                System.out.println("Caller Message Editing Off");
            }
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Close")).click();
            WebDriverLogin.waitT(wd, 1000);
            //Reset option
            
    		wd.quit();
    		wd = null;
    		result = 0;
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
}
