
package DListTUI;
import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
//Test Case 19546:DLists - Using the phone edit list 0, 5 and 9
//Test Case 19549:DLists - Using the phone can you edit and changes the lists just set up in the client.

public class T19546_DListEdit_TUI 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T19546_DListEdit_TUI-t0
	
	public static void main(String[] args) throws Exception
	{
		String url = "";
		result = 0;
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverLogin.enableBoxRange(wd, "1007", "1008");
			WebDriverLogin.resetDListAll(wd, "900005", "900005");
			WebDriverLogin.searchBoxRange(wd, "900005", "900005");
	        WebDriverLogin.waitT(wd, 500);
			String DListName = "19546DListTest";
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
		    WebDriverLogin.waitT(wd, 2500);
		    int j = 0;
		    for(int i = 0; i < 3; i++)
		    {
			    if(!wd.findElement(By.tagName("html")).getText().contains(DListName+j))
		        {
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
		            WebDriverLogin.waitT(wd, 2000);
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName+j);
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys(j+"");
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
		            WebDriverLogin.waitT(wd, 2000);
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("1008");
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("1008");
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
		            WebDriverLogin.waitT(wd, 2000);
		            
					wd.findElement(By.id("uxChkDlistInternalSrch")).click();
					wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
					WebDriverLogin.waitT(wd, 2500);
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
		            WebDriverLogin.waitT(wd, 2500);
		            
			        if(!wd.findElement(By.tagName("html")).getText().contains(DListName+j))
			        	result += -2002;          
			    }
			    if(j==0)
			    	j=1;
			    j+=4;
		    }
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
		    WebDriverLogin.waitT(wd, 2000);
		    wd.quit();
			wd = null;
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
		//
		try
		{
			//Test Case 19546:DLists - Using the phone edit list 0, 5 and 9
	        String[] folderList = {"DList", "TestSuite", "DListSetup", "DList2", "T19546_DList_Edit0"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 170000);
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
		//
  	   	try
		{
  	   		//5
	  	   	String[] folderList = {"DList", "TestSuite", "DListSetup", "DList2", "T19546_DList_Edit5"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 170000);
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
  	   	
  	   	try
		{
  	   		//9
  		   	String[] folderList = {"DList", "TestSuite", "DListSetup", "DList2", "T19546_DList_Edit9"};
  			wd = WebDriverLogin.getCyara(args);
  			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
  			WebDriverLogin.waitT(wd, 1500);
  			if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
  				System.out.println("");
  			}
  			wd.findElement(By.id("executeButton")).click();
  			WebDriverLogin.waitT(wd, 166000);
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
  	   	//
        System.exit(result);
	}
}

