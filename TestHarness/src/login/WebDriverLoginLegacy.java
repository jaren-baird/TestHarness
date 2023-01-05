package login;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.Select;

//Getters and Setters //Cyara //WebAdmin
//Error Table
//Search Box function
//WebAdmin Reset Section
//Setup individual boxes
//Clear MWI

public class WebDriverLoginLegacy 
{
	private static int result = 9;
	public static boolean JITCflag = true;
	private static FirefoxDriver wd = null;
	private static String FilePath = "\\\\CWENGFS\\Tests\\TestJars\\ErrorTable.jar";
	private static String cyaraIP = "10.16.97.38";
	private static String webadminIP = "https://webadmintest/WebAdmin/Login.aspx";
	//Getters and Setters
	public static void main(String[] args) throws Exception
	{
		wd = getWebAdmin();
		if(!wd.findElement(By.tagName("html")).getText().contains("Logged in as"))
			result = -1;
		else
			result = 0;
		wd.quit();
		wd = getCyara(args);
		if(!wd.findElement(By.tagName("html")).getText().contains("Test Cases & Blocks"))
			result += -2;
		wd.quit();
		
		System.exit(result);
	}
	
	public static String getFilePath()
	{
		return FilePath;
	}
	//Cyara
	public static FirefoxDriver getCyara(String[] args)
	{
		//ProfilesIni profile = new ProfilesIni();
	    //FirefoxProfile ffProfile = profile.getProfile("default");
		wd = new FirefoxDriver();
		
		if(wd != null) 
	    {
			wd = CyaraSingleton(args);
	    }
	    return wd;
	} 
	protected static FirefoxDriver CyaraSingleton(String[] args)
	{
		String ip = "";
		String url = "";
		/*
		if(args == null || args.length == 0)
		{
			ip = cyaraIP;
		}
		else if(args[0].contains(".") && args[0].length() > 1)
		{
			ip = cyaraIP;//args[0];
		}
		else
			ip = cyaraIP;
		*/
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        
        //wd.get("http://"+ip+"/CyaraWebPortal/public/login"); //10.16.97.38/CyaraWebPortal/1/home
        
        while(url.contains("about:blank") || !url.contains("http://"+cyaraIP+"/CyaraWebPortal/public/login"))
    	{
			try 
			{
				waitT(wd, 2000);
				wd.get("http://"+cyaraIP+"/CyaraWebPortal/public/login");
				waitT(wd, 2000);
				url = wd.getCurrentUrl();
			}
			catch(Exception ex)
			{
				
			}
    	}
        
        wd.manage().window().maximize();
        wd.findElement(By.id("Username")).click();
        wd.findElement(By.id("Username")).clear();
        wd.findElement(By.id("Username")).sendKeys("fceleste");
        wd.findElement(By.id("Password")).click();
        wd.findElement(By.id("Password")).clear();
        wd.findElement(By.id("Password")).sendKeys("");
        wd.findElement(By.id("loginButton")).click();
        wd.findElement(By.cssSelector("a.brand")).click();
        wd.findElement(By.linkText("Test Cases")).click();
        wd.findElement(By.cssSelector("a[title=\"Test Cases & Blocks\"]")).click();
		
		return wd;
	}//Cyara
	
	public static FirefoxDriver implicitlyWaitSetter(FirefoxDriver wd)
	{
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		return wd;
	}
	//WebAdmin
	public static FirefoxDriver getWebAdmin() 
	{
		result = -1;
	    ProfilesIni profile = new ProfilesIni();
	    FirefoxProfile ffProfile = profile.getProfile("default");
	    
		try
		{
			//wd = new ChromeDriver();
			//wd = new FirefoxDriver(ffProfile); //legacy login
			
			if(wd != null) 
			{
				wd = WebAdminSingleton();
			}
			if(result != 0 && wd != null)
			{
				wd = null;
			}
			else if(result == -1001 && wd == null)
			{
				System.out.println("WebAdmin failed Login");
			}
		}
		catch(Exception ex)
		{
			System.err.println(ex);
            ex.printStackTrace();
		}
		
		return wd;
	}
	
	public static FirefoxDriver getJITCWebAdmin() 
	{
		result = -1;
		//ProfilesIni profile = null;
	    //FirefoxProfile ffProfile = null;
			
		while(result != 0)
		{
			//profile = new ProfilesIni();
			//ffProfile = profile.getProfile("default");
			wd = new FirefoxDriver();
			
			if(wd != null) 
			{
				wd = WebAdminSingleton();
			}
			if(result != 0)
			{
				wd.quit();
				wd = null;
			}
		}
		if(JITCflag = true)
			return wd;
		else
			return null;
	}
	
	public static FirefoxDriver getWebAdminLogin(FirefoxDriver wd) 
	{
		result = -1;
			
		while(result != 0)
		{
			if(wd != null) 
			{
				wd = WebAdminSingleton();
			}
			if(result != 0)
			{
				wd.quit();
				wd = null;
			}
		}
		
		return wd;
	}
	
	protected static FirefoxDriver WebAdminSingleton() 
	{
	      // Exists only to defeat instantiation.
		result = 0;
		try 
        {
        	wd.manage().window().maximize();
        } catch (Exception ex) {}
		String url = "";
		int i = 1;
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        url = wd.getCurrentUrl();
        if(url.length() < 1 || url.contains("about:blank") || wd.findElement(By.tagName("html")).getText().contains("User Name"))
        {
	        try 
	        {
	        	while(url.contains("about:blank") || url.length() < 1 && i < 3)
	        	{
					waitT(wd, 500+1000*i);
					wd.get(webadminIP);
					url = wd.getCurrentUrl();
					if(url.length() < 1 || url.contains("about:blank"))
						waitT(wd, 1000+2000*i);
					i++;
	        	}
	        	if(!wd.getCurrentUrl().contains(webadminIP))
	        	{
	        		result = -2;
	        		return wd;
	        	}
				
			}catch(Exception ex)
			{
				result+=-109;
				wd = null;
				return wd;
			}
	        
	        
	        Alert alert;
	        if(wd.findElement(By.tagName("html")).getText().contains("User Name") || wd.findElement(By.tagName("html")).getText().contains("Password"))
	        {
		        wd.findElement(By.id("uxLogin_UserName")).click();
		        wd.findElement(By.id("uxLogin_UserName")).clear();
		        //wd.findElement(By.id("uxLogin_UserName")).sendKeys("administrator");
		        wd.findElement(By.id("uxLogin_UserName")).sendKeys("jaren");
		        wd.findElement(By.id("uxLogin_Password")).click();
		        wd.findElement(By.id("uxLogin_Password")).clear();
		        //wd.findElement(By.id("uxLogin_Password")).sendKeys("C@11ware");
		        wd.findElement(By.id("uxLogin_Password")).sendKeys("J@ren008");
		        wd.findElement(By.id("uxLogin_LoginButton")).click();
	        }
	        else if(wd.findElement(By.tagName("html")).getText().contains("Agree"))
	        {
	        	wd.findElement(By.id("uxBtnAgreeButton")).click();
	        } 
	        else
	        {
	        	wd.quit();
	        	System.exit(-1001);
	        }  
	        try 
		    { 
		    	alert = wd.switchTo().alert();
		        alert.accept();
		    }   
		    catch (NoAlertPresentException ex) 
		    { 
		    	JITCflag = false;
		    	//nonJitc
		    }
	        waitT(wd, 500);
	        url = wd.getCurrentUrl();
	        
        }
        if(url.contains(webadminIP))
        {//failure to login
        	result = -1001;
        	wd.quit();
        	wd = null;
        	return wd;
        }
        result = 0;
        return wd;
	}//WebAdmin End
	
	//Error Table
	public static int RunErrorTable(String url)
 	{
 		Process process = null;
 		int result = -2;
 		
 		try
 		{
 			process = Runtime.getRuntime().exec("java -jar " + FilePath + " 0" + " true " + url);
 			process.waitFor();
 			result = process.exitValue();
 		}
 		catch (Exception ex)
 		{
 			System.err.println(ex);
 			ex.printStackTrace();
 		}
 		
 		return result;
 	}
	//Search Box function
	public static void searchBoxRange(FirefoxDriver wd, String start, String end, int miliseconds) throws InterruptedException
	{
		waitT(wd, miliseconds);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartRange")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartRange")).sendKeys(start);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtEndRange")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtEndRange")).sendKeys(end);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLBtnStdSearch")).click();
        waitT(wd, miliseconds);
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).getText().contains(start))
        	searchBoxRange(wd, start, end);
	}
	
	public static void searchBoxRange(FirefoxDriver wd, String start, String end) throws InterruptedException
	{
		waitT(wd, 3500);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartRange")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartRange")).sendKeys(start);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtEndRange")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtEndRange")).sendKeys(end);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLBtnStdSearch")).click();
        waitT(wd, 3500);
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).getText().contains(start))
        {
        	waitT(wd, 10000);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).getText().contains(start))
	        	searchBoxRange(wd, start, end);
        }
	}
	
	//WebAdmin Reset Section
	public static void resetDList(FirefoxDriver wd, String boxNum) throws InterruptedException
    {//reset Local DLists
		searchBoxRange(wd, boxNum, boxNum, 3000);
		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).isSelected()) {
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
		}
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset")) {
		    System.out.println("");
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Boxes")) {
		    System.out.println("");
		}
		wd.findElement(By.linkText("Distribution Lists")).click();
		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetDList_UcxResetDlist_uxChkResetLocalDList")).isSelected()) {
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetDList_UcxResetDlist_uxChkResetLocalDList")).click();
		}
		if(!wd.findElement(By.tagName("html")).getText().contains("Submit")) {
		    System.out.println("");
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
		waitT(wd, 4500);
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
		{}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
		waitT(wd, 1500);
    }
	
	public static void resetMessages(FirefoxDriver wd, String startNum, String endNum) throws InterruptedException
    {//reset all messages
	    searchBoxRange(wd, startNum, endNum, 3000);
		if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected())
		    wd.findElement(By.id("uxChkboxsrtpr")).click();
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset")) {
		    System.out.println("");
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Boxes")) {
		    System.out.println("");
		}
		wd.findElement(By.linkText("Messages")).click();
		waitT(wd, 500);
		if(!wd.findElement(By.id("uxChkResetMsgAll")).isSelected()) {
		    wd.findElement(By.id("uxChkResetMsgAll")).click();
		}
		if(!wd.findElement(By.tagName("html")).getText().contains("Submit")) {
		    System.out.println("");
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
		waitT(wd, 1500);
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
		{}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
		waitT(wd, 1000);
    }
	
	public static void resetCallOptions(FirefoxDriver wd, String startNum, String endNum) throws InterruptedException
    {//reset all call options
	    searchBoxRange(wd, startNum, endNum, 3000);
		if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected())
		    wd.findElement(By.id("uxChkboxsrtpr")).click();
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset")) {
		    System.out.println("");
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Boxes")) {
		    System.out.println("");
		}
		wd.findElement(By.linkText("Call Options")).click();
		waitT(wd, 500);
		if(!wd.findElement(By.id("uxChkResetCallOptAll")).isSelected()) {
		    wd.findElement(By.id("uxChkResetCallOptAll")).click();
		}
		if(!wd.findElement(By.tagName("html")).getText().contains("Submit")) {
		    System.out.println("");
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
		waitT(wd, 1500);
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
		{}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
		waitT(wd, 1000);
    }
	
	public static int resetBoxAll(FirefoxDriver wd, String startNum, String endNum) throws InterruptedException
    {//reset all available settings
		int result = 0;
		enableBoxRange(wd, startNum, endNum);
    	searchBoxRange(wd, startNum, endNum, 1500);
    	waitT(wd, 1500);
	    //
		if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected())
		    wd.findElement(By.id("uxChkboxsrtpr")).click();
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset")) {
		    System.out.println("");
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Boxes")) {
		    System.out.println("");
		}
		waitT(wd, 2500);
		if(!wd.findElement(By.id("uxChkResetAll")).isSelected()) {
		    wd.findElement(By.id("uxChkResetAll")).click();
		}
		if(!wd.findElement(By.tagName("html")).getText().contains("Submit")) {
		    System.out.println("");
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
		waitT(wd, 2500);
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
		{
			waitT(wd, 12500);
			if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
				waitT(wd, 35000);
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
		waitT(wd, 2000);
		result += rangeClearMWI(wd, startNum, startNum);
		
		return result;
    }
	
	public static void resetTimeBlocks(FirefoxDriver wd, String startNum, String endNum) throws InterruptedException
    {//reset Daily Time Block Schedule
	    searchBoxRange(wd, startNum, endNum, 3000);
		if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected())
		    wd.findElement(By.id("uxChkboxsrtpr")).click();
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset")) {
		    System.out.println("");
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Boxes")) {
		    System.out.println("");
		}
		wd.findElement(By.linkText("Greetings")).click();
		waitT(wd, 500);
		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtTimeBlock_uxChkResetDailySchedule")).isSelected()) {
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetGreetings_uxResetGreetings_uxTabContainerResetGreetings_uxTpGrtTimeBlock_uxChkResetDailySchedule")).click();
		}
		if(!wd.findElement(By.tagName("html")).getText().contains("Submit")) {
		    System.out.println("");
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
		waitT(wd, 1500);
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
		{}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
		waitT(wd, 1000);
    }
	
	public static void resetGreetingTab(FirefoxDriver wd, String startNum, String endNum) throws InterruptedException
    {//reset all greetings tab
	    searchBoxRange(wd, startNum, endNum, 3000);
		if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected())
		    wd.findElement(By.id("uxChkboxsrtpr")).click();
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset")) {
		    System.out.println("");
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Boxes")) {
		    System.out.println("");
		}
		wd.findElement(By.linkText("Greetings")).click();
		waitT(wd, 500);
		if(!wd.findElement(By.id("uxChkResetGrtAll")).isSelected()) {
		    wd.findElement(By.id("uxChkResetGrtAll")).click();
		}
		if(!wd.findElement(By.tagName("html")).getText().contains("Submit")) {
		    System.out.println("");
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
		waitT(wd, 1500);
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
		{}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
		waitT(wd, 1000);
    }
	
	public static void resetNotifications(FirefoxDriver wd, String startNum, String endNum) throws InterruptedException
    {//reset all notification options
	    searchBoxRange(wd, startNum, endNum, 3000);
		if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected())
		    wd.findElement(By.id("uxChkboxsrtpr")).click();
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset")) {
		    System.out.println("");
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Boxes")) {
		    System.out.println("");
		}
		waitT(wd, 1000);
		wd.findElement(By.linkText("Notifications")).click();
		waitT(wd, 1000);
		if(!wd.findElement(By.id("uxChkResetNotifAll")).isSelected()) {
		    wd.findElement(By.id("uxChkResetNotifAll")).click();
		}
		if(!wd.findElement(By.tagName("html")).getText().contains("Submit")) {
		    System.out.println("");
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
		waitT(wd, 1500);
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
		{}
		waitT(wd, 1000);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
		waitT(wd, 1000);
    }
	//Reset Section End
	//Setup individual boxes
	public static void setupBox900005() throws InterruptedException
	{
		String box = "900005";
		wd = getWebAdmin();
		resetBoxAll(wd, box, box);
		searchBoxRange(wd, box, box);
		wd.findElement(By.id("uxChkboxsrtpr")).click();
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLB_Box_State")).click();
    	waitT(wd, 1500);
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRbState_Enabled")).click();
    	waitT(wd, 1000);
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxState_Multi_Submit")).click();
    	waitT(wd, 2500);
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	    waitT(wd, 1000);
        wd.findElement(By.linkText("Basic")).click();
        waitT(wd, 1000);
        //
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).sendKeys("Randy");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).sendKeys("Orton");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Address1")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Address1")).sendKeys("RKO");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Address2")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Address2")).sendKeys("Out of Nowhere");
        
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLifetime")).sendKeys("0");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLifetime")).sendKeys("0");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLength")).sendKeys("0");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLength")).sendKeys("0");
        
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLifetime")).sendKeys("20");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLifetime")).sendKeys("99999999999999999");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLength")).sendKeys("2");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLength")).sendKeys("6");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_AutoDisable")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_AutoDisable")).sendKeys("45");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_OwnerTss")).sendKeys("R");
        //
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Account")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Account")).sendKeys("555");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LongDistSuffix")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LongDistSuffix")).sendKeys("91801");
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxChkUser_ExtNumControl")).isSelected()) {
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxChkUser_ExtNumControl")).click();
        }
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_ExtNumEditLen")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_ExtNumEditLen")).sendKeys("10");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
        //
        waitT(wd, 4000);
        String value = wd.findElement(By.tagName("html")).getText();
        if(!value.contains("Updated"))
        	result += -10;
	    waitT(wd, 1500);
	    wd.quit();
		
		
		String[] args = {};
		wd = getCyara(args);
		
		while (!wd.findElement(By.tagName("html")).getText().contains("DList")) {
        	wd.findElement(By.linkText("Cyara Testing")).click();
        	waitT(wd, 1000);
        }
        while (!wd.findElement(By.tagName("html")).getText().contains("TestSuite")) {
        	wd.findElement(By.linkText("DList")).click();
        	waitT(wd, 1000);
        }
        while (!wd.findElement(By.tagName("html")).getText().contains("DListSetup")) {
        	wd.findElement(By.linkText("TestSuite")).click();
        	waitT(wd, 2000);
        }
        wd.findElement(By.linkText("VMbox 900005 initial setup")).click();
        waitT(wd, 2000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
            System.out.println("");
        }
        
		//
        wd.findElement(By.id("executeButton")).click();
        waitT(wd, 190000);
	    if(!wd.findElement(By.tagName("html")).getText().contains("Answered"))
	    	waitT(wd, 40000);
	    wd.quit();
	}
	
	public static void setupBox900006grt() throws InterruptedException
	{
		String[] args = {};
		String url = "";
		
		//Setup 900006
		wd = getWebAdmin();
		resetBoxAll(wd, "900006", "900006");
	    //
		searchBoxRange(wd, "900006", "900006", 2500);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		waitT(wd, 1500);
		wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings")).click();
		waitT(wd, 1000);
		
		Select select = null;
		WebElement option = null;
		String value = "";
		//
		while(!value.contains("3"))
		{
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreetingMaxNumGreetings")).sendKeys("3");
			waitT(wd, 500);
			select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreetingMaxNumGreetings")));
			option = select.getFirstSelectedOption();
			value = option.getText();
		}
		while(!value.contains("1"))
		{
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudDefGreeting")).sendKeys("1");
			waitT(wd, 500);
			select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudDefGreeting")));
			option = select.getFirstSelectedOption();
			value = option.getText();
		}
		waitT(wd, 200);
		while(!value.contains("2"))
		{
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudBusyGreeting")).sendKeys("2");
			waitT(wd, 500);
			select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudBusyGreeting")));
			option = select.getFirstSelectedOption();
			value = option.getText();
		}
		waitT(wd, 200);
		while(!value.contains("3"))
		{
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudNoAnsGreeting")).sendKeys("3");
			waitT(wd, 500);
			select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudNoAnsGreeting")));
			option = select.getFirstSelectedOption();
			value = option.getText();
		}
		waitT(wd, 500);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsSubmit")).click();
		waitT(wd, 2500);
		if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
		{
			System.out.println("Update failed");
		}
	  	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsClose")).click();
	  	waitT(wd, 2000);
		wd.quit();
		//
		
		//
	    wd = getCyara(args);
		while (!wd.findElement(By.tagName("html")).getText().contains("DList")) {
        	wd.findElement(By.linkText("Cyara Testing")).click();
        	waitT(wd, 1000);
        }
        while (!wd.findElement(By.tagName("html")).getText().contains("TestSuite")) {
        	wd.findElement(By.linkText("DList")).click();
        	waitT(wd, 1000);
        }
        while (!wd.findElement(By.tagName("html")).getText().contains("DListSetup")) {
        	wd.findElement(By.linkText("TestSuite")).click();
        	waitT(wd, 2000);
        }
        wd.findElement(By.linkText("Greeting")).click();
        waitT(wd, 1000);
        wd.findElement(By.linkText("setupGrt")).click();
        waitT(wd, 4000);
        wd.findElement(By.linkText("VMbox 900006 box setup")).click();
        waitT(wd, 1500);
        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
            System.out.println("");
        }
        wd.findElement(By.id("executeButton")).click();
        waitT(wd, 190000);
        url = wd.getCurrentUrl();
        result += RunErrorTable(url);
  	   	wd.quit();
		//
	}
	
	public static int setupBox899999() throws InterruptedException
	{
		String box = "899999";
		int result = 0;
		wd = getWebAdmin();
		resetBoxAll(wd, box, box);
    	searchBoxRange(wd, box, box, 2500);
    	
	    //max digits passcode number
    	waitT(wd, 2000);
	    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	    waitT(wd, 2000);
	    Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLength")));
		select.selectByVisibleText("10");
		waitT(wd, 1000);

        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).sendKeys("The Tester");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).clear();
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).sendKeys("Robot");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_OwnerTss")).sendKeys("W");
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_OwnerTss")).sendKeys(Keys.ENTER);
        
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
        //
        waitT(wd, 4000);
	    wd.quit();
		
		
		String[] args = {};
		wd = getCyara(args);
		
		while (!wd.findElement(By.tagName("html")).getText().contains("DList")) {
        	wd.findElement(By.linkText("Cyara Testing")).click();
        	waitT(wd, 1000);
        }
        while (!wd.findElement(By.tagName("html")).getText().contains("TestSuite")) {
        	wd.findElement(By.linkText("DList")).click();
        	waitT(wd, 1000);
        }
        while (!wd.findElement(By.tagName("html")).getText().contains("DListSetup")) {
        	wd.findElement(By.linkText("TestSuite")).click();
        	waitT(wd, 2000);
        }
        wd.findElement(By.linkText("VMbox 899999 setup")).click();
        waitT(wd, 2000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
            System.out.println("");
        }
        
		//
        wd.findElement(By.id("executeButton")).click();
        waitT(wd, 200000);
        String url = wd.getCurrentUrl();
        result += RunErrorTable(url);
	    if(!wd.findElement(By.tagName("html")).getText().contains("Answered"))
	    	waitT(wd, 40000);
	    wd.quit();
	    
	    return result;
	}//Individual box setup End
	
	//Clear MWI
	public static int clearMWI() throws Exception
	{
		wd = getWebAdmin();
		int result = 0;
        //
        
		result += checkBox(wd, "1007");
		result += checkBox(wd, "1008");
		result += checkBox(wd, "1009");
		result += checkBox(wd, "900005");
        
		if(wd != null)
			wd.quit();
		
		return result;
	}
	
	public static int clearMWI(String boxNumber) throws Exception
	{
		wd = getWebAdmin();
		int result = 0;
        //
        
		result += checkBox(wd, boxNumber);
        
		if(wd != null)
			wd.quit();
		
		return result;
	}
	
	protected static int rangeClearMWI(FirefoxDriver wd, String startNum, String endNum) throws InterruptedException
	{
		int result = 0;
		int length = 0;
		wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		try
		{
			length = Integer.parseInt(endNum)-(Integer.parseInt(startNum)-1);
		}
		catch(Exception ex)
		{
			return -9;
		}
		
		try
		{
			for(int i = 0; i < length; i++)
			{
				searchBoxRange(wd, (Integer.toString(Integer.parseInt(startNum)+i)), endNum);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
				waitT(wd, 2500);
				String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Mwi")).getAttribute("value");
				
			    waitT(wd, 500);
			    
			    if(value.length() > 1)
			    {
			    	//System.out.println(value);
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Mwi")).clear();
			    	waitT(wd, 250);
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
			    	waitT(wd, 4000);
			    }
			    
			    wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
			    waitT(wd, 2000);
			}
		}
	    catch (Exception ex)
	    {
	    	waitT(wd, 1000);
	    	wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
	    	waitT(wd, 2000);
	    }
		return result;
	}
	protected static int checkBox(FirefoxDriver wd, String num) throws InterruptedException
	{//check for MWI setting
		int result = 0;
		
		try
		{
			searchBoxRange(wd, num, num);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			waitT(wd, 2500);
			String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Mwi")).getAttribute("value");
			
		    waitT(wd, 500);
		    
		    if(value.length() > 1)
		    {
		    	//System.out.println(value);
		    	result = Integer.parseInt("-"+value);
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Mwi")).clear();
		    	waitT(wd, 250);
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
		    	waitT(wd, 4000);
		    }
		    
		    wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
		    waitT(wd, 1500);
		}
	    catch (Exception ex)
	    {}
		return result;
	}
	//End of MWI functions
	
	
	
	//Create Notification Plans
	public static int createVmNotificationTele(FirefoxDriver wd, String box) throws InterruptedException
	{
		int result = 0;
		try
		{
			searchBoxRange(wd, box, box);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        waitT(wd, 1500);
	        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications")).click();
	        waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationOne")).click();
	        waitT(wd, 1500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).click();
	        //
	        waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_DialingString")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_DialingString")).sendKeys("1007");
	        waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_OwnerProgrammableNumber")).clear();
	        waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_OwnerProgrammableNumber")).sendKeys("4");
	        waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxDdlTelePager_OwnerProgDigits")).sendKeys("5");
	        waitT(wd, 250);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_NumOfMsgs")).clear();
	        waitT(wd, 250);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_NumOfMsgs")).sendKeys("5");
	        waitT(wd, 250);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_NumOfAttempts")).clear();
	        waitT(wd, 250);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_NumOfAttempts")).sendKeys("2");
	        //
	        waitT(wd, 250);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkTelePager_IgnoreDistMsgs")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkTelePager_IgnoreDistMsgs")).click();
	        waitT(wd, 250);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkQueueStartEndTime")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkQueueStartEndTime")).click();
	        //
	        waitT(wd, 250);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxDdlStartTimeHour")).sendKeys("5");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxDdlEndTimeHour")).sendKeys("5");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxDdlDelayHour")).sendKeys("1");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxDdlRetryHour")).sendKeys("1");
	        //
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkSunday")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkSunday")).click();
	        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkSaturday")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkSaturday")).click();
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxBtnTelephonePagerSubmit")).click();
	        waitT(wd, 1000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Changes Accepted"))
	        	result += -10;
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
		}
		catch (Exception ex)
		{
			result += -102;
		}
		
		return result;
	}
	
	public static int createVmNotificationEmail(FirefoxDriver wd, String box) throws InterruptedException
	{
		int result = 0;
		try
		{
			searchBoxRange(wd, box, box);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        waitT(wd, 1500);
	        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications")).click();
	        waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationTwo")).click();
	        waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbEmail")).click();
	        waitT(wd, 1500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).click();
	        waitT(wd, 1000);
	        //
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxBtnEmailSubmit")).click();
	        waitT(wd, 1000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Changes Accepted"))
	        	result += -10;
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
		}
		catch (Exception ex)
		{
			result += -102;
		}
		
		return result;
	}
	
	public static int createVmNotificationWakeUp(FirefoxDriver wd, String box) throws InterruptedException
	{
		int result = 0;
		try
		{
			searchBoxRange(wd, box, box);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        waitT(wd, 1500);
	        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications")).click();
	        waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationThree")).click();
	        waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbWakeUp")).click();
	        waitT(wd, 1500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).click();
	        waitT(wd, 1000);
	        //
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxBtnWakeUpSubmit")).click();
	        waitT(wd, 1000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Changes Accepted"))
	        	result += -10;
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
		}
		catch (Exception ex)
		{
			result += -102;
		}
		
		return result;
	}
	
	public static int createVmNotificationEscalation(FirefoxDriver wd, String box) throws InterruptedException
	{
		int result = 0;
		try
		{
			searchBoxRange(wd, box, box);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        waitT(wd, 1500);
	        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications")).click();
	        waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationFour")).click();
	        waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbEscalation")).click();
	        waitT(wd, 1500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).click();
	        waitT(wd, 1000);
	        //
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxBtnEscalationSubmit")).click();
	        waitT(wd, 1000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Changes Accepted"))
	        	result += -10;
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
		}
		catch (Exception ex)
		{
			result += -102;
		}
		
		return result;
	}
	
	//End of Notification
	public static boolean checkBoxExists(FirefoxDriver wd, String  box)
	{
		boolean exists = false;
		wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		try 
		{
			searchBoxRange(wd, box, box, 1500);
			waitT(wd, 1500);
			if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblBoxStatus")).getText().contains("Search Yielded No Results"))
				exists = false;
			else
				exists = true;
		} 
		catch (Exception ex) 
		{exists = false;}
		
		
		return exists;
	}
	
	public static int enableBoxRange(FirefoxDriver wd, String startNum, String endNum)
	{
		result = 0;
		try
		{
			searchBoxRange(wd, startNum, endNum, 2500);
		    //enable section
		    wd.findElement(By.id("uxChkboxsrtpr")).click();
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLB_Box_State")).click();
	    	waitT(wd, 1000);
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRbState_Enabled")).click();
	    	waitT(wd, 250);
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxState_Multi_Submit")).click();
	    	waitT(wd, 1000);
		}
		catch (Exception ex)
		{result += -10;}
	    
    	return result;
	}
	
	public static int createBoxWebAdmin(FirefoxDriver wd, String box)
	{
		int result = 0;
		try 
		{
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_New")).click();
			waitT(wd, 2000);
			
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtNumberOfBoxesToCreate")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtNumberOfBoxesToCreate")).sendKeys("1");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartAtNumber")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartAtNumber")).sendKeys(box);
			
			
			WebElement dropDownListBox = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxDdlOwnerTss")); 
			Select clickThis = new Select(dropDownListBox);
			clickThis.selectByVisibleText("Report Test");
			//
			dropDownListBox = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxDdlDefPropertyType")); 
			clickThis = new Select(dropDownListBox);
			clickThis.selectByVisibleText("Teacher Box");
			//
			waitT(wd, 1000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbNewBoxes_Submit")).click();
			waitT(wd, 2500);
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblNewBoxStatus")).getText().contains("New Boxes Created"))
				result += -10;
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbNewBoxes_Cancel")).click();
			waitT(wd, 2000);
			
		} 
		catch (Exception ex) 
		{result += -10;}
		
		return result;
	}
	
	public static int cyaraFolderSearch(FirefoxDriver wd, String[] folderList)
	{
		int result = 0;
		int j = 0;
		try
		{
			wd.findElement(By.linkText("Cyara Testing")).click();
			waitT(wd, 1000);
			for(int i = 0; i < folderList.length-1; i++)
			{
				try{
				while (!wd.findElement(By.tagName("html")).getText().contains(folderList[i+1])) {
		        	wd.findElement(By.linkText(folderList[i])).click();
		        	waitT(wd, 1000);
		        	j++;
		        	if(j > 50)
		        	{
		        		result += -9000;
		        		return result;
		        	}
		        }}catch(Exception idontcare){}
			}
			
			wd.findElement(By.linkText(folderList[folderList.length-1])).click();
		}
		catch (Exception ex){result += -10;}
		
		return result;
	}
	
	public static FirefoxDriver waitT(FirefoxDriver wd, int time)
	{
		long multiplier = 1000*1000; //1 second
		long estimatedTime = 0;
		long begin = 0;
		long limit = 19999L; //math time is 220 milliseconds
        long largestPrimeFactor = 0;
        
		if(time > 10000)
			multiplier = 1000*1000;
		if(time <= 0)
			time = 1000;
		if(time > 0 && time <= 300)
			limit = 9001; //math time is 48 milliseconds
		if(time > 600000)
			time = 600000;
		long Timer = time;
		
		try 
		{
			
			Timer = Timer * multiplier;
			//Thread.sleep(time * multiplier);
			//
			int i = 0;
			Timer = System.nanoTime()+Timer;//;
			while(true)
			{
				begin = System.nanoTime();
				if(Timer < begin ||i>3005)// && multiplier == 1)
				{
					//estimatedTime = ((int)(Timer - begin)/(10^9));//
					//System.out.println("Time(m): "+time +" ;i: "+i);
					break;
				}
				//estimatedTime = ((int)(Timer - begin)/(10^5));//
				//System.out.println("Time(s): "+estimatedTime+" ;nanoTime: "+ (Timer-begin));
				
		        for (long number = 2; number < limit; number++) {
		            if(isPrime(number)) {
		                if((limit % number == 0)){
		                    largestPrimeFactor = number; 
		                }
		            }
		        }
		        i++;
			}
			//
			
			
		} 
		catch (Exception never) 
		{
			//this should basically never throw
			System.out.println(never);
			never.printStackTrace();
		}
		return wd;
	}
	public static boolean isPrime(long number) {
        for (int i = 2; i < number; i++) {
            if(number % i == 0) {
                return false; 
            }
        }
        return true; 
    }
	/*
	public static int webAdminRightsOn(FirefoxDriver wd, String userName)
	{
		int result = 0;
		
		try
		{
			wd.findElement(By.id("ctl00_uxCphNavigation_uxLbAdminUsers")).click();
	        waitT(wd, 4000);
	        wd.findElement(By.linkText(userName)).click();
	        waitT(wd, 4000);
			//
	        checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewTsServers", true);
	        checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkEditTsServers", true);
	        checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkCreateTsServers", true);
	        checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkDeleteTsServer", true);
	        checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkCreateAdmins", true);
	        checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkDeleteAdmins", true);
			checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkBackUpDB", true);
			checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewSysParams", true);
			checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkEditSysParams", true);
			checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewReports", true);
			checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewSecSettings", true);
			checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkEditSecSettings", true);
			checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkAccountEnabled", true);
			waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxLbAdminUsersSubmit")).click();
	        waitT(wd, 2000);
		}
	    catch (Exception ex)
	    {
	    	result+= -15;
	    }
		
		return result;
	}
	
	public static int webAdminRightsOff(FirefoxDriver wd, String userName)
	{
		int result = 0;
		
		try
		{
			wd.findElement(By.id("ctl00_uxCphNavigation_uxLbAdminUsers")).click();
	        waitT(wd, 4000);
	        wd.findElement(By.linkText(userName)).click();
	        waitT(wd, 4000);
			//
	        checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkAlarmNotification", false);
	        checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewTsServers", false);
	        checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkEditTsServers", false);
	        checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkCreateTsServers", false);
	        checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkDeleteTsServer", false);
	        checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkCreateAdmins", false);
	        checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkDeleteAdmins", false);
			checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkBackUpDB", false);
			checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewSysParams", false);
			checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkEditSysParams", false);
			checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewReports", false);
			checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkViewSecSettings", false);
			checkBoxToggle(wd, "ctl00_uxCphContent_ucAdminUsers_uxChkEditSecSettings", false);
	        waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucAdminUsers_uxLbAdminUsersSubmit")).click();
	        waitT(wd, 2000);
	        
		}
	    catch (Exception ex)
	    {
	    	result+= -15;
	    }
		
		return result;
	}
	
	public static void checkBoxToggle(FirefoxDriver wd, String field, boolean state)
	{
		if(state == true)
		{
			if(!wd.findElement(By.id(field)).isSelected())
				wd.findElement(By.id(field)).click();
		}
		else if(state == false)
		{
			if(wd.findElement(By.id(field)).isSelected())
				wd.findElement(By.id(field)).click();
		}
	}
	*/
	
	
	
	
}

/*
WebDriverLogin

865070-865080 Audiotext
865090 VM,865091-93 AT, 865094 UCD, 890001-10 890900-13 AT, 890914-16 VM Night Maintenance NewSavDel, 890917-890999 AT, 899990 TeachB
box 900000-900004 use all types (00 VM)(01 AT)(02 UCD)(03 FO)(04 TB)
Boxes 900005(Randy Orton)-900250 type voicemail










Automate box creation:
890990-890999 AT, 899990 TeachBox  
box 900000-900004 use all types (00 VM)(01 AT)(02 UCD)(03 FO)(04 TB)
Boxes 900005(Randy Orton)-900250 type voicemail














*/