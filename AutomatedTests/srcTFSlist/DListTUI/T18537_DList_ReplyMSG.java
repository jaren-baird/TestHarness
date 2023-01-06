
package DListTUI;

import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T18537_DList_ReplyMSG
{
	private static int result = 9;
	private static int Exception = -2;
	public static ChromeDriver wd = null;
	private static String FilePath = "\\\\CWENGFS\\Tests\\TestJars\\table\\ErrorTable.jar";
	//T18537_DList_ReplyMSG-t0
	
	public static void main(String[] args) throws Exception
	{
	    result = 0;
	    try
	    {
		    //Reset DLists
		    wd = WebDriverLogin.getWebAdmin();
		    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    WebDriverLogin.resetDList(wd, "1008");
	  		//Create DList for 1007
		    DList(wd, "1008", "2", "900005");
		    
		    //Reset Messages
		    WebDriverLogin.resetMessages(wd, "900005", "900005");
		    WebDriverLogin.resetMessages(wd, "1008", "1008");
		    //WebDriverLogin.resetMessages(wd, "1007", "1007");
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
		//Leave message to be forwarded
	    try
	    {
	        String[] folderList = {"DList", "TestSuite", "Leave_messageDList"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
			System.out.println("");
			}
			//
			wd.findElement(By.id("executeButton")).click();
			WebDriverLogin.waitT(wd, 95000);
			//String url = wd.getCurrentUrl();
			String[] para = {"0","true"};
			if(WebDriverLogin.RunErrorTable(wd, para) != 0)
				System.out.println("error occured in Leave_messageDList");
			
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
  	   	//Reply message
	    try
		{
			String[] folderList = {"DList", "TestSuite", "DListSetup", "3", "T18537_DList_ReplyMSG"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 152000);
	        String[] para = {"0","true"};
 	        int failed = WebDriverLogin.RunErrorTable(wd, para);
 	        if(failed != 0)
				result += failed;
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
  	   	try
  	   	{
	  	   	wd = WebDriverLogin.getWebAdmin();
	  	   	wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  	   	WebDriverLogin.searchBoxRange(wd, "1008", "1008", 2500);
	  	   	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbStatus")).click();
		   	WebDriverLogin.waitT(wd, 2500);
		   	String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_New_Value")).getText();//getAttribute("value");
		   	if(value == null)
		   	{
		   		result = -9999;
		   	}
		   	else if(value.contains("0"))
		  	{
		  		result += -10;
		  		System.out.println("box 1008 has no message");
		  	}
		  	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxStatusClose")).click();
		  	WebDriverLogin.waitT(wd, 1500);
	  	   	
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
	
	public static void DList(ChromeDriver wd, String boxNumber, String dlistNum, String boxMember) throws InterruptedException
    {
		//create dlist
		String DListName = "DListMessage"+dlistNum;
		WebDriverLogin.searchBoxRange(wd, boxNumber, boxNumber, 2500);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		WebDriverLogin.waitT(wd, 2500);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
		WebDriverLogin.waitT(wd, 2500);
		if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
		{
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys(dlistNum);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys(boxMember);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys(boxMember);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
			WebDriverLogin.waitT(wd, 2000);
			
			wd.findElement(By.id("uxChkDlistInternalSrch")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
			WebDriverLogin.waitT(wd, 2500);
		
			if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
			    	result += -2002;          
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
    }
}
