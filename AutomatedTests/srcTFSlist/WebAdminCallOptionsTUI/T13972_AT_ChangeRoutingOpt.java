
package WebAdminCallOptionsTUI;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class T13972_AT_ChangeRoutingOpt 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13972_AT_ChangeRoutingOpt-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String url = "";
		String box = "900001";
		
		//wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//Test Case 13972:WebAdmin - CallOptions - Audiotext - Change the previously entered 4 digit number
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.enableBoxRange(wd, "1007", "1007");
			WebDriverLogin.enableBoxRange(wd, box, Integer.toString(Integer.parseInt(box)+5));
			WebDriverLogin.resetCallOptions(wd, box, box);
			WebDriverLogin.searchBoxRange(wd, box, box, 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.linkText("Call Options")).click();
			WebDriverLogin.waitT(wd, 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtRoutingOptions_Key")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtRoutingOptions_Key")).sendKeys("99999"); //only 4 digits accepted
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtRoutingOptions_Key")).sendKeys(Keys.ENTER);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtRoutingOptions_Number")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtRoutingOptions_Number")).sendKeys("1007");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtRoutingOptions_Number")).sendKeys(Keys.ENTER);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxLbAddRoutingOptions")).click();
			WebDriverLogin.waitT(wd, 3000);
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).isSelected())
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).click();
			WebDriverLogin.waitT(wd, 500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOSubmit")).click();
			WebDriverLogin.waitT(wd, 3500);
			wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += ExceptionResult();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		//
		try
		{
			String[] folderList = {"DList", "TestSuite", "Other", "AudioText", "AudioText2", "T13972_AT_ChangeRoutingOpt"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 98000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += ExceptionResult();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
  	   	//
		try
		{
	  	   	wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.searchBoxRange(wd, box, box);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.linkText("Call Options")).click();
	        WebDriverLogin.waitT(wd, 3500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Randy Orton"))
	        	result += -10;
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOClose")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += ExceptionResult();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		try
		{
	  	   	//Test Case 13973:WebAdmin - CallOptions - Audiotext - Dial a previous routing number
	        String[] folderList = {"DList", "TestSuite", "Other", "AudioText", "AudioText2", "T13973_AT_ListenRoutingOpt"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 82000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += ExceptionResult();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
  	   	//test listen with multiple routing options
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.searchBoxRange(wd, box, box, 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.linkText("Call Options")).click();
			WebDriverLogin.waitT(wd, 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtRoutingOptions_Key")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtRoutingOptions_Key")).sendKeys("1234"); //
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtRoutingOptions_Key")).sendKeys(Keys.ENTER);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtRoutingOptions_Number")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtRoutingOptions_Number")).sendKeys("1007");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtRoutingOptions_Number")).sendKeys(Keys.ENTER);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxLbAddRoutingOptions")).click();
			WebDriverLogin.waitT(wd, 3000);
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).isSelected())
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).click();
			WebDriverLogin.waitT(wd, 500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOSubmit")).click();
			WebDriverLogin.waitT(wd, 3500);
			wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += ExceptionResult();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		try
		{
	  	   	//Test Case 13973:WebAdmin - CallOptions - Audiotext - Dial a previous routing number
			WebDriverLogin.waitT(wd, 30000); //wait for cache to update routing options list
	        String[] folderList = {"DList", "TestSuite", "Other", "AudioText", "AudioText2", "T13973_AT_ListenRoutingOpt_case1"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 137000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += ExceptionResult();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		//
        System.exit(result);
	} 
	
	public static int ExceptionResult()
	{
		return -109;
	}
}
