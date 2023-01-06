
import login.WebDriverLogin;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

public class VM_AMP_on
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//WA_MSG_OS_AMP_on-s0
    
    public static void main(String[] args) throws Exception
    {
    	String box = "1007";
    	try
    	{
    		wd = WebDriverLogin.getWebAdmin();
    		WebDriverLogin.searchBoxRange(wd, box, box);
        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
        	WebDriverLogin.waitT(wd, 1000);
        	wd.findElement(By.linkText("Messages")).click();
            //Turn On Auto Message Play
        	WebDriverLogin.waitT(wd, 1500);
            if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAutoMsgPlay")).isSelected()) {
                wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAutoMsgPlay")).click();
            }
            WebDriverLogin.waitT(wd, 500);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Submit")).click();
            WebDriverLogin.waitT(wd, 1500);
            if(!wd.findElement(By.tagName("html")).getText().contains("Updated")) {
                System.out.println("Auto Message Play On");
            }
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Close")).click();
            WebDriverLogin.waitT(wd, 1500);
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
