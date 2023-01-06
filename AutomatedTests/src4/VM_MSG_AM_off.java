
import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;

public class VM_MSG_AM_off
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//WA_MSG_OS_AM_off-s0
	
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
        //
		try
    	{
    		String box = "1007";
    		WebDriverLogin.searchBoxRange(wd, box, box);
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
    		WebDriverLogin.waitT(wd, 2000);
            wd.findElement(By.linkText("Messages")).click();
            WebDriverLogin.waitT(wd, 1000);
            //
            //Turn Off Answer Message
            if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMakeMessage")).isSelected())
                wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsMakeMessage")).click();
            if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsForwardMessage")).isSelected())
                wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsForwardMessage")).click();
            if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAnswerMessage")).isSelected())
                wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAnswerMessage")).click();
            if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsContinuousMsgPlay")).isSelected())
                wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsContinuousMsgPlay")).click();
            WebDriverLogin.waitT(wd, 1000);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Submit")).click();
            WebDriverLogin.waitT(wd, 2000);
            if(!wd.findElement(By.tagName("html")).getText().contains("Updated")) {
                System.out.println("Urgent Message Option");
            }
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Close")).click();
    		//
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
