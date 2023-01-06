
package OtherTUI;
import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T14013_Validate_AnswerM
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14013_Validate_AnswerM-t0
	//Test Case 14013:WebAdmin - Messages - Answer message checked by default
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetMessages(wd, "900005", "900005");
			WebDriverLogin.resetCallOptions(wd, "900005", "900005");
			WebDriverLogin.searchBoxRange(wd, "900005", "900005", 1500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_tab")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAnswerMessage")).isSelected())
	        	result += -10;
	        else
	        {
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxChkOwnerSvcsAnswerMessage")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Submit")).click();
		        WebDriverLogin.waitT(wd, 2000);
	        }
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmMessages_ucVmMessages_uxBtnMessage_Close")).click();
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
		
		try
		{
			String[] folderList = {"DList", "TestSuite", "Messaging", "LeaveAMessage", "T14013_Validate_AnswerM"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 160000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
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
		
	    System.exit(result);
	}
}
	
	