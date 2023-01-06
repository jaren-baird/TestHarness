
package DListTUI;
import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class T18502_DList_LeaveMessage35
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T18502_DList_LeaveMessage35-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		
		try
		{
			wd = WebDriverLogin.getWebAdmin();
		    //
		    
		    //resetup 900005
		    WebDriverLogin.resetBoxAll(wd, "900005", "900005");
		    WebDriverLogin.setupBox900005();
		    
		    
		    //reset 900050-549
	        
	        for(int i = 0; i < 5; i++)
	        {
	        	WebDriverLogin.searchBoxRange(wd, "900"+i+"50", "900"+(i+1)+"49", 2000);
	        	
	        	wd.findElement(By.id("uxChkboxsrtpr")).click();
	    	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	    	    WebDriverLogin.waitT(wd, 2500);
	    	    wd.findElement(By.linkText("Messages")).click();
	    	    WebDriverLogin.waitT(wd, 2500);
	    	    if(!wd.findElement(By.id("uxChkResetMsgAll")).isSelected()) {
	    	        wd.findElement(By.id("uxChkResetMsgAll")).click();
	    	    }
	    	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	    	    WebDriverLogin.waitT(wd, 2500);
	    	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        	WebDriverLogin.waitT(wd, 2500);
	        }
		    
	        //create dlist
		    String DListName = "DList500";
		    WebDriverLogin.resetDList(wd, "900005");
		    WebDriverLogin.searchBoxRange(wd, "900005", "900005");
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
		    WebDriverLogin.waitT(wd, 2500);
		    
		    
		    if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
	            WebDriverLogin.waitT(wd, 2000);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys("35");
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
	            WebDriverLogin.waitT(wd, 2000);
            
	            int wait = 2500;
	            int j = 5;
	            int k = 0;
	            long startTime = System.currentTimeMillis();
	            long currentTime = 0;
	            long totalTime = 0;
	            long waitTime = 0;
	            
	            try
	            {
		            for(int i = 0; i < 5; i++)
		            {
		            	startTime = System.currentTimeMillis();
		            	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).clear();
			        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("900"+i+"50");
			        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).clear();
			            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("900"+(i+1)+"49");
			            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
			            WebDriverLogin.waitT(wd, 2500+(wait)+i*50);
			            currentTime   = System.currentTimeMillis();
			            totalTime = currentTime - startTime;
			            //System.out.println("Wait Time: "+(2500+(wait)+i*50)+" StepA: "+i+"  Time: "+totalTime);
			            //startTime = System.currentTimeMillis();
			            wd.findElement(By.id("uxChkDlistInternalSrch")).click();
			        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
			        	WebDriverLogin.waitT(wd, 1500+(wait));
			        	if(i >= 1)
			        		wait = wait+i*50;
			        	k++;
			        	if(k == 10)
			        	{
			        		j++;
			        		k=0;
			        		if(j==10)
			        			break;
			        	}
			        	//currentTime   = System.currentTimeMillis();
		                //totalTime = currentTime - startTime;
		                //System.out.println("Wait Time: "+(wait+1500)+" StepB: "+i+"  Time: "+totalTime);
		            }
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
		            WebDriverLogin.waitT(wd, 5000);
	            }
	            catch (Exception ex)
	            {
	            	result += -1000;
	            }
		    }
		    WebDriverLogin.waitT(wd, 2000);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
		    WebDriverLogin.waitT(wd, 5000);
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
	        String[] folderList = {"DList", "TestSuite", "DListSetup", "T18502_DList35"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 100000);
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
	  	   	wd = WebDriverLogin.getWebAdmin();
	  	   	WebDriverLogin.waitT(wd, 1500);
	  	   	//box 900050-900549
	  	   	for(int i = 0; i < 5; i++)
	  	   	{
	  	   		WebDriverLogin.searchBoxRange(wd, "900"+i+"50", "900"+(i+1)+"49", 2500);
		  	   	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbStatus")).click();
		  	   	WebDriverLogin.waitT(wd, 1500);
		  	   	String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_New_Value")).getText();
		  	   	if(value == null)
		  	   	{
		  	   		result += -9999;
		  	   		break;
		  	   	}
			  	if(value.contains("0"))
			  	{
		    		result += -200;
		    		System.out.println("box 9000"+(50+(i-1)/2)+" failed");
		    	}
			  	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxStatusClose")).click();
			  	WebDriverLogin.waitT(wd, 1500);
		  	}
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

