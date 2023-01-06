import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class DList5000 
{
	public static void main(String[] args) throws Exception
	{
		ChromeDriver wd;
		wd = WebDriverLogin.getWebAdmin();

        long startTime = System.currentTimeMillis();
        long currentTime = 0;
        long totalTime = 0;
        int wait = 0;
        
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl19_uxLbNumber")).click();
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
        
        while(!wd.findElement(By.tagName("html")).getText().contains("DList5000"))
        {
        	if(wd.findElement(By.tagName("html")).getText().contains("DList5000"))
        		break;
        	
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
            WebDriverLogin.waitT(wd, 2000);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys("DList5000");
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
            WebDriverLogin.waitT(wd, 2000);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtCustomWhereSrch")).sendKeys("7000>id");
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
            WebDriverLogin.waitT(wd, 200);
            wait = 700;
            
            for(int i = 0; i < 49; i++)
            {
            	 wd.findElement(By.id("uxChkDlistInternalSrch")).click();
            	 wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
            	 WebDriverLogin.waitT(wd, 4500+(i*wait/2));
            	 wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLblDistRepeaterPagerForwardOne")).click();
            	 WebDriverLogin.waitT(wd, 4500+(i*wait/2));
            	 if(i >= 1)
            		 wait = wait+i;
            	 
            	 currentTime   = System.currentTimeMillis();
                 totalTime = currentTime - startTime;
                 System.out.println("Step: "+i+"  Time: "+totalTime);
            }
            
            WebDriverLogin.waitT(wd, 4500+(wait*20));
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
        }
	}
}




