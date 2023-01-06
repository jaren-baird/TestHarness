
	import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;


	public class Cyara_editDLists_t1
	{
		private static int result = 9;
		private static int Exception = -2;
		public static boolean JITCflag = true;
		private static ChromeDriver wd = null;
		private static String FilePath = WebDriverLogin.getFilePath();

		//Test Case 19549:DLists - Using the phone can you edit and changes the lists just set up in the client.
		//WA_TS_tui_EditDLists-t1
		
		public static void main(String[] args) throws Exception
		{
			String DListName = "EditDList8";
			wd = WebDriverLogin.getWebAdmin();
			try
	    	{
	    		WebDriverLogin.resetDListAll(wd, "1008", "1008");
	    		WebDriverLogin.searchBoxRange(wd, "1008", "1008");
	    		
			    //Create DList
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			    WebDriverLogin.waitT(wd, 1500);
			    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
			    WebDriverLogin.waitT(wd, 1000);
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
		        WebDriverLogin.waitT(wd, 1000);
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName);
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys("8");
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
		        
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("1007");
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("1007");
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
		        WebDriverLogin.waitT(wd, 2500);


	        	wd.findElement(By.id("uxChkDlistInternalSrch")).click();
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
	        	WebDriverLogin.waitT(wd, 2000);
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
	        	WebDriverLogin.waitT(wd, 1000);
				
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
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
	        //
			//
			try
			{
				String[] folderList = {"DList", "TestSuite", "DListSetup", "Edit DList8 Name"};
				wd = WebDriverLogin.getCyara(args);
				result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
		        WebDriverLogin.waitT(wd, 1500);
		        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
		            System.out.println("");
		        }
		        wd.findElement(By.id("executeButton")).click();
		        WebDriverLogin.waitT(wd, 120000);
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
