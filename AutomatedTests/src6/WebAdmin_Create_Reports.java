
import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebAdmin_Create_Reports
{
	//-s0
	public static ChromeDriver wd = null;
	public static ChromeDriver admin = null;
	private static int result = 0;
	private static int boxNumber = 899990;
	private static int boxAmount = 2; //must be at least 2
	
	public static void main(String[] args) throws Exception
	{
		String url = "";
		if(args != null && args.length != 0 && args[0].contains("webadmin:"))
			url = args[0].replace("webadmin:", "");
		else
			url = "https://webadmintest/WebAdmin/Login.aspx";
		
		wd = null;
		admin = null;
		ProfilesIni profile = new ProfilesIni();
	    FirefoxProfile ffProfile = profile.getProfile("default");
	    
	    
	    Alert alert = null;
	    
	    program: try
	    {
	        admin = null;
	        admin.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	        admin.get("https://webadmintest/WebAdmin/Login.aspx");
	        admin.manage().window().maximize();
	        admin = logon(admin, alert, "administrator", url);
	        ///*
	        cleanUp(admin, alert, "ctl00_uxCphContent_ucAdminUsers_1");
	        
	        wd = null;
	        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	        wd.get("https://webadmintest/WebAdmin/Login.aspx");
	        wd.manage().window().maximize();
	        wd = logon(wd, alert, "jaren", url);
	        cleanUp(admin, alert, "ctl00_uxCphContent_ucAdminUsers_55");
	        //*/
	        if(result != 0)
	        	break program;
	        
	        // generate Admin Activity Logs, UserID: 55
	        result = adminActivityLogGeneration(wd); //(admin);
	        //

	        //
	    }
	    catch (Exception ex)
		{
			System.err.println(ex);
			ex.printStackTrace();
        }
	    finally
	    {
	    	if(wd != null)
	    		wd.quit();
	    	
	    	if(admin != null)
	    	{
	    		//cleanUp(admin, alert, "ctl00_uxCphContent_ucAdminUsers_55");
	    		admin.quit();
	    	}
	    	
	    }
		
		System.exit(result);
	}
	
	public static int adminActivityLogGeneration(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		result = testSingleCreateDelete(wd); //-110
		if(result != 0)
		{
			System.out.println("testSingleCreateDelete Failed: "+result);
			return result;
		}
		else
		{
			System.out.println("testSingleCreateDelete Success: "+result);
		}
		result = createBoxes(wd); //-10
		if(result != 0)
		{
			System.out.println("createBoxes Failed: "+result);
			return result;
		}
		else
		{
			System.out.println("createBoxes Success: "+result);
		}
		
		result = editBox(wd); //-30
		if(result != 0)
		{
			System.out.println("editBox Failed: "+result);
			return result;
		}
		else
		{
			System.out.println("editBox Success: "+result);
		}
		result = copyBox(wd); //-40
		if(result != 0)
		{
			System.out.println("copyBox Failed: "+result);
			return result;
		}
		else
		{
			System.out.println("copyBox Success: "+result);
		}
		result = resetBox(wd); //-50
		if(result != 0)
		{
			System.out.println("resetBox Failed: "+result);
			return result;
		}
		else
		{
			System.out.println("resetBox Success: "+result);
		}
		
		result = deleteBoxes(wd); //-20
		if(result != 0)
		{
			System.out.println("deleteBoxes Failed: "+result);
			return result;
		}
		else
		{
			System.out.println("deleteBoxes Success: "+result);
		}
		
		result = securityLog(wd); //-60
		if(result != 0)
		{
			System.out.println("securityLog Failed: "+result);
			return result;
		}
		else
		{
			System.out.println("securityLog Success: "+result);
		}
		result = systemLog(wd); //-70
		if(result != 0)
		{
			System.out.println("systemLog Failed: "+result);
			return result;
		}
		else
		{
			System.out.println("systemLog Success: "+result);
		}
		result = maintenanceLog(wd); //-80
		if(result != 0)
		{
			System.out.println("maintenanceLog Failed: "+result);
			return result;
		}
		else
		{
			System.out.println("maintenanceLog Success: "+result);
		}
		result = clientLog(wd); //-90
		if(result != 0)
		{
			System.out.println("clientLog Failed: "+result);
			return result;
		}
		else
		{
			System.out.println("clientLog Success: "+result);
		}
		result = usersLog(wd); //-100
		if(result != 0)
		{
			System.out.println("usersLog Failed: "+result);
			return result;	
		}
		else
		{
			System.out.println("usersLog Success: "+result);
		}
		
		return result;
	}
	
	public static int usersLog(ChromeDriver wd) throws InterruptedException
	{
		int result = -100;
		wd.findElement(By.id("ctl00_uxCphNavigation_uxLbAdminUsers")).click();
		WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_55")).click();
        
        wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxLbAdminUsersSubmit")).click();
        WebDriverLogin.waitT(wd, 2000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Changes Accepted"))
        	result = -101;
        else
        	result = 0;
        WebDriverLogin.waitT(wd, 1000);
		
		return result;
	}
	
	public static int clientLog(ChromeDriver wd) throws InterruptedException
	{
		int result = -90;
		Actions builder = new Actions(wd);
        builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'Ts Servers')]"))).perform();
        wd.findElement(By.id("ctl00_uxCphNavigation_9")).click();
        
        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxBtnTsServerSubmit")).click();
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Changes Accepted"))
        	result = -91;
        else
        	result = 0;
        WebDriverLogin.waitT(wd, 1000);
		
		return result;
	}
	
	public static int maintenanceLog(ChromeDriver wd) throws InterruptedException
	{
		int result = -80;
		Actions builder = new Actions(wd);
		builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'System Parameters')]"))).perform();
        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbMaintenance")).click();
        
        wd.findElement(By.id("ctl00_uxCphContent_ucMaintenance_uxBtnSubmitMaintenance")).click();
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Change Accepted"))
        	result = -81;
        else
        	result = 0;
        WebDriverLogin.waitT(wd, 1000);
		
		return result;
	}
	
	public static int systemLog(ChromeDriver wd) throws InterruptedException
	{
		int result = -70;
		Actions builder = new Actions(wd);
        builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'System Parameters')]"))).perform();
        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbSystemLog")).click();
        
        wd.findElement(By.id("ctl00_uxCphContent_ucSysLog_uxBtnSystemLogSubmit")).click();
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Change Accepted"))
        	result = -71;
        else
        	result = 0;
        WebDriverLogin.waitT(wd, 1000);
		
		return result;
	}
	
	public static int securityLog(ChromeDriver wd) throws InterruptedException
	{
		int result = -60;
		WebDriverLogin.waitT(wd, 1000);
		Actions builder = new Actions(wd);
        builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'System Parameters')]"))).perform();
        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbSecuritySettings")).click();
        WebDriverLogin.waitT(wd, 2000);
        
        wd.findElement(By.id("ctl00_uxCphContent_ucSecuritySettings_uxTxtMSSMaxPassRetention")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucSecuritySettings_uxTxtMSSMaxPassRetention")).sendKeys("3");
        wd.findElement(By.id("ctl00_uxCphContent_ucSecuritySettings_uxBtnSecSettings_Submit")).click();
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
        	result = -61;
        
        builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'System Parameters')]"))).perform();
        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbSecuritySettings")).click();
        WebDriverLogin.waitT(wd, 1000);
        wd.findElement(By.id("ctl00_uxCphContent_ucSecuritySettings_uxTxtMSSMaxPassRetention")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucSecuritySettings_uxTxtMSSMaxPassRetention")).sendKeys("4");
        wd.findElement(By.id("ctl00_uxCphContent_ucSecuritySettings_uxBtnSecSettings_Submit")).click();
        WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
        	result = -62;
        else
        	result = 0;
        
        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
        WebDriverLogin.waitT(wd, 1000);
        
        
        return result;
	}
	
	public static int resetBox(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		boolean success = false;
		//if, Search Yielded 2 Results: success = true
		success = checkBoxesExist(wd, true, 0);
		if(!success)
		{
			result = -50;
			return result;
		}
		
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
		WebDriverLogin.waitT(wd, 1000);
		wd.findElement(By.id("uxChkResetUserAll")).click();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
		
		WebDriverLogin.waitT(wd, 1000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful."))
        {
        	result = -51;
        	return result;
        }
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
        WebDriverLogin.waitT(wd, 1000);
		
		return result;
	}
	
	public static int copyBox(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		boolean success = false;
		//if, Search Yielded 2 Results: success = true
		success = checkBoxesExist(wd, true, 0);
		if(!success)
			return -40;
		
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl03_uxChkItemBox")).click();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Copy")).click();
		WebDriverLogin.waitT(wd, 1000);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).sendKeys(Integer.toString(boxNumber));
        wd.findElement(By.id("uxChkResetAll")).click();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
        WebDriverLogin.waitT(wd, 5000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Copy Successful."))
        	result = -41;
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
        
        //if, Search Yielded # Results: success = true
  		success = checkBoxesExist(wd, true, 0);
  		if(!success)
  			result += -42;
      		
		return result;
	}
	
	public static int editBox(ChromeDriver wd) throws InterruptedException
	{
		int result = 0;
		boolean success = false;
		//if, Search Yielded # Results: success = true
		success = checkBoxesExist(wd, true, 0);
		if(!success)
			return -30;
		
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		WebDriverLogin.waitT(wd, 1000);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).sendKeys("Edit Report");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).sendKeys("Generation");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
        WebDriverLogin.waitT(wd, 1000);
        if(wd.findElement(By.tagName("html")).getText().contains("Updated"))
        	result = 0;
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
        WebDriverLogin.waitT(wd, 1000);
        
		
		return result;
	}
	
	public static int deleteBoxes(ChromeDriver wd) throws InterruptedException
	{	
		int result = -20;
		boolean success = false;
		//if, Search Yielded # Results: success = true
		success = checkBoxesExist(wd, true, 0);
		
		if(!success)
			return result;
		
		wd.findElement(By.id("uxChkboxsrtpr")).click();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Delete")).click();
		
		do
			WebDriverLogin.waitT(wd, 1500);
		while(wd.findElements(By.id("ctl00_uxCphContent_ucBoxes_uxLbDelWarn_Submit")).isEmpty());
		WebDriverLogin.waitT(wd, 2000);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbDelWarn_Submit")).click();
		WebDriverLogin.waitT(wd, 2000);
		if(!wd.findElement(By.tagName("html")).getText().contains("Boxes successfully deleted")) 
		{   //Multiple delete, log generation check
			result = -21;
			return result;
		}
		
		if(!wd.findElements(By.id("ctl00_uxCphContent_ucBoxes_uxLbDelWarn_Cancel")).isEmpty())
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbDelWarn_Cancel")).click();
		//if, Search Yielded No Results: success = true
		success = checkBoxesExist(wd, false, 0);
		
		if(success == true)
			result = 0;
		else
			result = -22;
		
		return result;
	}
	
	public static int createBoxes(ChromeDriver wd) throws InterruptedException
	{
		int result = -10;
		int i = 0;
		boolean success = false;
		
		//if, Search Yielded No Results: success = true
		success = checkBoxesExist(wd, false, 0);
		if(!success)
			return result;
		
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_New")).click();
		do
			WebDriverLogin.waitT(wd, 2500);
		while(wd.findElements(By.id("ctl00_uxCphContent_ucBoxes_uxLbNewBoxes_Submit")).isEmpty());
			
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtNumberOfBoxesToCreate")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtNumberOfBoxesToCreate")).sendKeys(Integer.toString(boxAmount));
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartAtNumber")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartAtNumber")).sendKeys(Integer.toString(boxNumber));
		new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxDdlOwnerTss"))).selectByVisibleText("WEBADMINTEST");
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbNewBoxes_Submit")).click();
		do
		{
			WebDriverLogin.waitT(wd, 3000);
			i++;
		}
		while(!wd.findElement(By.tagName("html")).getText().contains("New Boxes Created.") && i < 5);
		if(!wd.findElement(By.tagName("html")).getText().contains("New Boxes Created."))
		{
			result = -11;
			return result;
		}
		if(!wd.findElements(By.id("ctl00_uxCphContent_ucBoxes_uxLbNewBoxes_Cancel")).isEmpty())
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbNewBoxes_Cancel")).click();
		
		//if, Search Yielded # Results: success = true
		success = checkBoxesExist(wd, true, 0);
		
		if(success)
			result = 0;
		else
			result = -12;
		
		return result;
	}
	
	public static int testSingleCreateDelete(ChromeDriver wd) throws InterruptedException
	{
		int result = -110;
		int i = 0;
		boolean success = false;
		
		//if, Search Yielded No Results: success = true
		success = checkBoxesExist(wd, false, 1);
		if(!success)
			return result;
		
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_New")).click();
		do
			WebDriverLogin.waitT(wd, 2500);
		while(wd.findElements(By.id("ctl00_uxCphContent_ucBoxes_uxLbNewBoxes_Submit")).isEmpty());
			
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtNumberOfBoxesToCreate")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtNumberOfBoxesToCreate")).sendKeys("1");
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartAtNumber")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartAtNumber")).sendKeys(Integer.toString(boxNumber));
		new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxDdlOwnerTss"))).selectByVisibleText("WEBADMINTEST");
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbNewBoxes_Submit")).click();
		do
		{
			WebDriverLogin.waitT(wd, 3000);
			i++;
		}
		while(!wd.findElement(By.tagName("html")).getText().contains("New Boxes Created.") && i < 5);
		if(!wd.findElement(By.tagName("html")).getText().contains("New Boxes Created."))
		{
			result = -111;
			return result;
		}
		if(!wd.findElements(By.id("ctl00_uxCphContent_ucBoxes_uxLbNewBoxes_Cancel")).isEmpty())
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbNewBoxes_Cancel")).click();
		
		//if, Search Yielded # Results: success = true
		success = checkBoxesExist(wd, true, 1);
		
		if(success)
			result = 0;
		else
		{
			result = -112;
			return result;
		}
		
		wd.findElement(By.id("uxChkboxsrtpr")).click();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Delete")).click();
		
		do
			WebDriverLogin.waitT(wd, 1500);
		while(wd.findElements(By.id("ctl00_uxCphContent_ucBoxes_uxLbDelWarn_Submit")).isEmpty());
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbDelWarn_Submit")).click();
		WebDriverLogin.waitT(wd, 3000);
		if(!wd.findElement(By.tagName("html")).getText().contains("Boxes successfully deleted")) 
		{
			result = -113;
			return result;
		}
		
		if(!wd.findElements(By.id("ctl00_uxCphContent_ucBoxes_uxLbDelWarn_Cancel")).isEmpty())
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbDelWarn_Cancel")).click();
		//if, Search Yielded No Results: success = true
		success = checkBoxesExist(wd, false, 0);
		
		if(success == true)
			result = 0;
		else
			result = -114;
		
		return result;
	}
	
	public static boolean checkBoxesExist(ChromeDriver wd, boolean exists, int boxAmount2) throws InterruptedException
	{
		boolean success = false;
		if(boxAmount2 == 0)
			boxAmount2 = boxAmount;
		
		if(wd.findElement(By.tagName("html")).getText().contains("Boxes")) //ensure we're on boxes tab
			wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
		
		WebDriverLogin.waitT(wd, 1500);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartRange")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartRange")).sendKeys(Integer.toString(boxNumber));
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtEndRange")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtEndRange")).sendKeys(Integer.toString(boxNumber+boxAmount2-1));
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLBtnStdSearch")).click();
		WebDriverLogin.waitT(wd, 1000);
		if(exists == true)
		{
			if(wd.findElement(By.tagName("html")).getText().contains("Search Yielded "+boxAmount2+" Results"))
				success = true;
			else
				success = false;
		}
		if(exists == false)
		{
			if(wd.findElement(By.tagName("html")).getText().contains("Search Yielded No Results"))
				success = true;
			else
				success = false;
		}
		WebDriverLogin.waitT(wd, 1000);
		return success;
	}
    
    public static void cleanUp(ChromeDriver admin, Alert alert, String account) throws InterruptedException
    {
    	//function to bypass webadmin's inability to login as separate users
    	WebDriverLogin.waitT(wd, 1000);
    	admin.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
    	WebDriverLogin.waitT(wd, 1000);
    	if(admin.findElement(By.tagName("html")).getText().contains("Boxes"))
    	{
    		//do nothing
    	}
    	else if(admin.findElement(By.tagName("html")).getText().contains("User Name") || admin.findElement(By.tagName("html")).getText().contains("Password"))
        {
    		admin.findElement(By.id("uxLogin_UserName")).click();
    		admin.findElement(By.id("uxLogin_UserName")).clear();
    		admin.findElement(By.id("uxLogin_UserName")).sendKeys("administrator");
    		admin.findElement(By.id("uxLogin_Password")).click();
	        admin.findElement(By.id("uxLogin_Password")).clear();
	        admin.findElement(By.id("uxLogin_Password")).sendKeys("[short jitc]");
	        admin.findElement(By.id("uxLogin_LoginButton")).click();
	        alert = admin.switchTo().alert();
	        alert.accept();
        }
        else if(admin.findElement(By.tagName("html")).getText().contains("Agree"))
        {
        	admin.findElement(By.id("uxBtnAgreeButton")).click();
            alert = admin.switchTo().alert();
            alert.accept();
        }
    	
    	do
    	{
    		admin.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
            WebDriverLogin.waitT(wd, 1500);
    		admin.findElement(By.id("ctl00_uxCphNavigation_uxLbAdminUsers")).click();
            WebDriverLogin.waitT(wd, 500);
            do
            {
	            admin.findElement(By.id(account)).click();
	            WebDriverLogin.waitT(wd, 1500);
            }
            while(admin.findElement(By.tagName("html")).getText().contains("Association Cleared"));
            admin.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxLnxBtnClearCN")).click();
            WebDriverLogin.waitT(wd, 2500);
    	}
    	while(!admin.findElement(By.tagName("html")).getText().contains("Association Cleared"));
    }
    
    public static ChromeDriver logon(ChromeDriver login, Alert alert, String account, String url)
    {
    	login = WebDriverLogin.getWebAdmin();
        
        return login;
    }
}
