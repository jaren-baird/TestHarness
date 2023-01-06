
package DListTUI;
import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
//Test Case 19543:DLists - Set up Distribution list using the telephone.
//Test Case 19544:DLists - Set up list 0 and 5.
//Test Case 19545:DLists - Set up list 9
//Test Case 19546:DLists - Using the phone edit list 0, 5 and 9
//Test Case 19547:DLists - Using the phone change the name of the lists
//Test Case 19548:DLists - From Callegra can you see the lists that you set up on the phone?
public class T19543_DListSetup_TUI 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T19543_DListSetup_TUI-t0
	
	public static void main(String[] args) throws Exception
	{
		String url = "";
		result = 0;
		//
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetDListAll(wd, "900005", "900005");
			WebDriverLogin.enableBoxRange(wd, "1000", "1009");
	        wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += except();
			ex.printStackTrace();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		//Test Case 19543:DLists - Set up Distribution list using the telephone.
		try
		{
	        String[] folderList = {"DList", "TestSuite", "DListSetup", "Set_up_DList_0"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 120000);
	        String[] para = {"0","true"};
	        int returnedRes = WebDriverLogin.RunErrorTable(wd, para);
	        if(returnedRes != 0)
	        	result += returnedRes;
	        wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += except();
			ex.printStackTrace();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
  	   	//Test Case 19544:DLists - Set up list 0 and 5.
		try
		{
	        String[] folderList = {"DList", "TestSuite", "DListSetup", "Set_up_DList_5"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 120000);
	        String[] para = {"0","true"};
	        int returnedRes = WebDriverLogin.RunErrorTable(wd, para);
	        if(returnedRes != 0)
	        	result += returnedRes;
	        wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += except();
			ex.printStackTrace();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
	   	//Test Case 19544:DLists - Set up list 9.
		try
		{
		   	String[] folderList = {"DList", "TestSuite", "DListSetup", "Set_up_DList_9"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
			WebDriverLogin.waitT(wd, 1500);
			if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
				System.out.println("");
			}
			wd.findElement(By.id("executeButton")).click();
			WebDriverLogin.waitT(wd, 120000);
			String[] para = {"0","true"};
			int returnedRes = WebDriverLogin.RunErrorTable(wd, para);
	        if(returnedRes != 0)
	        	result += returnedRes;
			wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += except();
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
			wd = WebDriverLogin.getWebAdmin();
	        WebDriverLogin.searchBoxRange(wd, "900005", "900005");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.linkText("Dist. Lists")).click();
	        WebDriverLogin.waitT(wd, 3000);
	        //DList 0
	        if(!wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl01$uxChkLocalDList")).isSelected()) 
	        	wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl01$uxChkLocalDList")).click();
	        if(wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl02$uxChkLocalDList")).isSelected())
	            wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl02$uxChkLocalDList")).click();
	        if(wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl03$uxChkLocalDList")).isSelected())
	        	wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl03$uxChkLocalDList")).click();
	
	        wd.findElement(By.id("uxLbEditDlist")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        try
	        {
	        	if(!wd.findElement(By.tagName("html")).getText().contains("Cyara Test Dummy"))
	        		result += fail();
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl01_uxChkMemberItem")).click();
	        }
	        catch (Exception ex)
	        {
	        	result += except();
	        }
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistClose")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        //DList5
	        if(wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl01$uxChkLocalDList")).isSelected()) 
	        	wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl01$uxChkLocalDList")).click();
	        if(!wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl02$uxChkLocalDList")).isSelected())
	            wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl02$uxChkLocalDList")).click();
	        if(wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl03$uxChkLocalDList")).isSelected())
	        	wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl03$uxChkLocalDList")).click();
	            
	        wd.findElement(By.id("uxLbEditDlist")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        try
	        {
	        	if(!wd.findElement(By.tagName("html")).getText().contains("Cyara Test Dummy"))
	        		result += fail();
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl01_uxChkMemberItem")).click();
	        }
	        catch (Exception ex)
	        {
	        	result += except();
	        }
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistClose")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        //DList9
	        if(wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl01$uxChkLocalDList")).isSelected()) 
	        	wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl01$uxChkLocalDList")).click();
	        if(wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl02$uxChkLocalDList")).isSelected())
	            wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl02$uxChkLocalDList")).click();
	        if(!wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl03$uxChkLocalDList")).isSelected())
	        	wd.findElement(By.name("ctl00$uxCphContent$ucBoxes$uxTabContainerVoiceMailProps$uxTpVmDistLists$ucVmDistributionLists$uxRptLocalList$ctl03$uxChkLocalDList")).click();
	        
	        wd.findElement(By.id("uxLbEditDlist")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        try
	        {
	        	if(!wd.findElement(By.tagName("html")).getText().contains("Cyara Test Dummy"))
	        		result += fail();
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl01_uxChkMemberItem")).click();
	        }
	        catch (Exception ex)
	        {
	        	result += except();
	        }
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistClose")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.quit();
			wd = null;
		}
		catch(Exception ex)
		{
			result += except();
			ex.printStackTrace();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
	   	//
        System.exit(result);
	}
	
	public static int except()
	{
		return -1000;
	}
	public static int fail()
	{
		return -10;
	}
}

