package DListTUI;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class T18527_DList_FwdMsg_TUI 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T18527_DList_FwdMsg_TUI-t0
	
	public static void main(String[] args) throws InterruptedException 
	{
		result = 0;
		try
		{//turn direct to box on function
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.searchBoxRange(wd, "1000", "1000");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.linkText("Call Options")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).isSelected())
	        {
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).click();
		        WebDriverLogin.waitT(wd, 1000);
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOSubmit")).click();
		        WebDriverLogin.waitT(wd, 4000);
	        }
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOClose")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += ExceptionVal();
			ex.printStackTrace();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		//
		String box = "900005";
		String box2 = Integer.toString(Integer.parseInt(box)+1);
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			//
			WebDriverLogin.resetDListAll(wd, box, box);
			WebDriverLogin.resetMessages(wd, box, box2);
			WebDriverLogin.searchBoxRange(wd, box, box2, 2500);
			//create dlist
			String DListName = "18527DListTest";
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
		    WebDriverLogin.waitT(wd, 2000);
		    if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
	            WebDriverLogin.waitT(wd, 2000);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys("2");
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
	            WebDriverLogin.waitT(wd, 2000);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("900005");
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("900005");
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
		    wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += ExceptionVal();
			ex.printStackTrace();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		//
		//
		try
		{
	        String[] folderList = {"DList", "TestSuite", "DListSetup", "3", "T18527_DList_MSG"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
			//
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 145000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
	        wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += ExceptionVal();
			ex.printStackTrace();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
  	   	//
  	   	//
		try
		{
			String[] folderList = {"DList", "TestSuite", "DListSetup", "3", "T18527_DList_ForwardMsg"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
			if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
				System.out.println("");
			}
			//
			wd.findElement(By.id("executeButton")).click();
			WebDriverLogin.waitT(wd, 185000);
			String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
		   	//
	        wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += ExceptionVal();
			ex.printStackTrace();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
	   	
	   	try
	   	{
		   	wd = WebDriverLogin.getWebAdmin();
	  	   	WebDriverLogin.searchBoxRange(wd, box, box2);
	  	   	//box 900005-900006
	  	   	String status = "";
	  	   	for(int i = 1; i < 4; i+=2)
	  	   	{
	   			status = "ctl00_uxCphContent_ucBoxes_uxRepeater_ctl0"+i+"_uxLbStatus";
		  	   	wd.findElement(By.id(status)).click();
		  	   	WebDriverLogin.waitT(wd, 1500);
		  	   	String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_New_Value")).getText();//getAttribute("value");
		  	   	if(value == null)
		  	   	{
		  	   		result += -9999;
		  	   		break;
		  	   	}
			  	if(value.contains("0"))
			  	{
		    		result += -200;
		    		System.out.println("box ctl00_uxCphContent_ucBoxes_uxRepeater_ctl0"+i+"_uxLbStatus failed");
		    	}
			  	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxStatusClose")).click();
			  	WebDriverLogin.waitT(wd, 1500);
		  	}
	  	   	wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += ExceptionVal();
			ex.printStackTrace();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
	   	
		System.exit(result);
	}
	
	public static int ExceptionVal()
	{
		return -109;
	}

}
