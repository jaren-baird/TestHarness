package DLIST;

import login.WebDriverLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class T18504_Add5000_DList
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	//T18504_Add5000_DList-t0
	
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
		
	    //
	    result = 0;
	    String DListName = "DListAdd5000";
	    //reset box
	    searchBoxRange(wd, "900005", "900005");
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	    WebDriverLogin.waitT(wd, 1500);
	    wd.findElement(By.linkText("Distribution Lists")).click();
	    WebDriverLogin.waitT(wd, 1000);
	    if(!wd.findElement(By.id("uxChkResetDlistAll")).isSelected()) {
	        wd.findElement(By.id("uxChkResetDlistAll")).click();
	    }
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	    WebDriverLogin.waitT(wd, 2500);
	    if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) {
	    	result -= 10;
	    }
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	    WebDriverLogin.waitT(wd, 2500);
	    //create dlist
	    
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	    WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
	    WebDriverLogin.waitT(wd, 1000);
	    
	    
	    if(!wd.findElement(By.tagName("html")).getText().contains(DListName))
        {
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
            WebDriverLogin.waitT(wd, 2000);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys("47");
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
            WebDriverLogin.waitT(wd, 2000);
            
            int wait = 1500;
            int j = 5;
            int k = 0;
            long startTime = System.currentTimeMillis();
            long currentTime = 0;
            long totalTime = 0;
            long waitTime = 0;
            
            try
            {
	            for(int i = 0; i < 50; i++)
	            {
	            	startTime = System.currentTimeMillis();
	            	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).clear();//93 ji 00
		        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys(("93"+j)+(k+"00"));
		        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).clear();//93 99 99
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys(("93"+j)+(k+"99"));
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
		            
		            WebDriverLogin.waitT(wd, 2500+(wait)+i*50);
		            currentTime   = System.currentTimeMillis();
		            totalTime = currentTime - startTime;
		            System.out.println("Wait Time: "+(2500+(wait)+i*50)+" StepA: "+i+"  Time: "+totalTime);
		            
		            startTime = System.currentTimeMillis();
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
		        	
		        	currentTime   = System.currentTimeMillis();
	                totalTime = currentTime - startTime;
	                System.out.println("Wait Time: "+(wait+1500)+" StepB: "+i+"  Time: "+totalTime);
	            }
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
	            WebDriverLogin.waitT(wd, 25000);
            }
            catch (Exception ex)
            {
            	result += -1000;
            }
                   
	    }
	    try
	    {
	    	
		    WebDriverLogin.waitT(wd, 5000);
	    }
	    catch (Exception ex){}
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
	    WebDriverLogin.waitT(wd, 15000);
	    
	    /*searchBoxRange(wd, "900005", "900005");
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	    WebDriverLogin.waitT(wd, 20000);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
	    WebDriverLogin.waitT(wd, 20000);
	    //check DList
	    if(wd.findElement(By.tagName("html")).getText().contains(DListName))
	    {
	    	if(!wd.findElement(By.id("uxChkLocalDList")).isSelected()) {
		        wd.findElement(By.id("uxChkLocalDList")).click();
		    }
	    	wd.findElement(By.id("uxLbEditDlist")).click();
	    	WebDriverLogin.waitT(wd, 45000);
	    	
	    	try
		    {
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl01_uxChkMemberItem")).click();
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl893_uxChkMemberItem")).click();
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl7421_uxChkMemberItem")).click();
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRptCurrentMembers_ctl9999_uxChkMemberItem")).click();
		    }
		    catch (Exception ex)
		    {
		    	
		    }
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistClose")).click();
	    	WebDriverLogin.waitT(wd, 1500);
	    	
	    }
	    else
	    	result = -10005;*/
	    
		wd.quit();
		System.exit(result);
	}
	
	public static void searchBoxRange(ChromeDriver wd, String start, String end) throws InterruptedException
	{
		WebDriverLogin.waitT(wd, 2500);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartRange")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartRange")).sendKeys(start);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtEndRange")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtEndRange")).sendKeys(end);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLBtnStdSearch")).click();
        WebDriverLogin.waitT(wd, 2500);
	}

}
