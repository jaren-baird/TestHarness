package DListTUI;

import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class T18506_DList_LeaveMessage47
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = "\\\\CWENGFS\\Tests\\TestJars\\table\\ErrorTable.jar";
	//T18506_DList_LeaveMessage47-t0
	
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
	    //
	    result = 0;
	    
	    //reset 935000-9999
	    WebDriverLogin.searchBoxRange(wd, "935000", "939999");
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	    WebDriverLogin.waitT(wd, 2500);
	    wd.findElement(By.linkText("Messages")).click();
	    WebDriverLogin.waitT(wd, 2500);
	    if(!wd.findElement(By.id("uxChkResetMsgAll")).isSelected()) {
	        wd.findElement(By.id("uxChkResetMsgAll")).click();
	    }  
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtResetBoxesCopyRangeStart")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtResetBoxesCopyRangeStart")).sendKeys("74390");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtResetBoxesCopyRangeEnd")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtResetBoxesCopyRangeEnd")).sendKeys("79389");
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	    WebDriverLogin.waitT(wd, 3500);
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
    	WebDriverLogin.waitT(wd, 3500);
		wd.quit();
		wd = null;
		
		String[] args2 = {""};
		wd = WebDriverLogin.getCyara(args2);
		
		while (!wd.findElement(By.tagName("html")).getText().contains("DList")) {
        	wd.findElement(By.linkText("Cyara Testing")).click();
        	WebDriverLogin.waitT(wd, 1000);
        }
        while (!wd.findElement(By.tagName("html")).getText().contains("TestSuite")) {
        	wd.findElement(By.linkText("DList")).click();
        	WebDriverLogin.waitT(wd, 1000);
        }
        while (!wd.findElement(By.tagName("html")).getText().contains("DListSetup")) {
        	wd.findElement(By.linkText("TestSuite")).click();
        	WebDriverLogin.waitT(wd, 2000);
        }
        wd.findElement(By.linkText("DListSetup")).click();
        WebDriverLogin.waitT(wd, 4000);
        wd.findElement(By.linkText("2")).click();
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.linkText("T18506_DList47")).click();
        WebDriverLogin.waitT(wd, 1500);
 
        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
            System.out.println("");
        }
        
		//
        wd.findElement(By.id("executeButton")).click();
        WebDriverLogin.waitT(wd, 100000);
        String[] para = {"0","true"};
  	   	WebDriverLogin.RunErrorTable(wd, para);
		
  	   	//
  	   	wd.quit();
  	   	wd = null;
  	   	WebDriverLogin.waitT(wd, 900000);
  	   	while(wd == null)
  	   	{
  	   		wd = WebDriverLogin.getWebAdmin();
  	   		
  	   		try
  	   		{
  	   			WebDriverLogin.waitT(wd, 1500);
  	   			wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
  	   			WebDriverLogin.waitT(wd, 5500);
  	   		}
  	   		catch (Exception ex)
  	   		{
  	   			if(wd != null)
  	   				wd.quit();
  	   			wd = null;
  	   		}
  	   	}
  	   	
  	   	//reset 935000-9999
  	   	for(int i = 0; i < 5; i++)
  	   	{
  	   		WebDriverLogin.searchBoxRange(wd, "93"+(i+5)+"999", "93"+(i+5)+"999");
	  	   	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbStatus")).click();
	  	   	WebDriverLogin.waitT(wd, 1500);
	  	   	String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_New_Value")).getText();
	  	   	if(value == null)
	  	   	{
	  	   		result = -9999;
	  	   		break;
	  	   	}
		  	if(value.contains("0"))
		  	{
	    		result += -200;
	    		System.out.println("box 93"+(i+5)+"999 failed");
	    	}
		  	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxStatusClose")).click();
		  	WebDriverLogin.waitT(wd, 1500);
	  	}
	  	
  	   	
  	   	wd.quit();
		System.exit(result);
	}
}

