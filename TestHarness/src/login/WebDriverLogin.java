package login;

//import login.SeanWebDriver;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import login.ErrorTable;

//Getters and Setters //Cyara Index //WebAdmin Index
//Error Table
//Search Box function
//WebAdmin Reset Section
//Setup individual boxes
//Clear MWI

public class WebDriverLogin 
{
	public static String chromedriver = setVariable("chromedriver"); //"C:\\selenium\\libraries\\chromedriver\\chromedriver.exe";
	public static String profilePath = setVariable("profilePath"); //"C:\\Users\\jbaird.CALLWARE\\AppData\\Local\\Google\\Chrome\\User Data";
	public static int result = 9;
	public static boolean JITCflag = true;
	public static ChromeDriver wd = null;
	public static String FilePath = setVariable("FilePath"); //"\\\\CWENGFS\\Tests\\TestJars\\ErrorTable.jar";
	public static String cyaraIP = setVariable("cyaraIP"); //"10.16.97.37";//"10.16.97.38";
	public static String webadminIP = setVariable("webadminIP"); //"https://qatestsp3/webadmin/"; //"https://2016vm4fc/webadmin/";//"https://webadmintest/WebAdmin/";
	public static final int Exception = -109;
	public static long varMultiplier = 1000*1000; //millisecond*1000=nanosecond 1000*1000 = 1 second
	public static String calledNumber = setVariable("calledNumber"); //"5789@10.16.99.23";
	public static String webAdminUser = setVariable("webAdminUser"); //"administrator"; //"jaren";
	public static String webAdminPW = setVariable("webAdminPW"); //""; //"AgentString@007";
	
	//Getters and Setters 			 
	public static void main(String[] args) throws Exception
	{
		/*
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
		*/
		runSetups();
		System.exit(result);
	}
	
	public static String getcyaraIP()
	{return cyaraIP;}
	public static String getwebadminIP()
	{return webadminIP;}
	public static String getchromedriver()
	{return chromedriver;}
	public static String getprofilePath()
	{return profilePath;}
	public static String getFilePath()
	{return FilePath;}
	public static int getException()
	{return Exception;}
	//Cyara Index
	public static ChromeDriver getCyara(String[] args)
	{
		if(true)
			//return null; //ignore cyara
		//
		System.setProperty("webdriver.chrome.driver", chromedriver);
		wd = new ChromeDriver();
		try { Thread.sleep(2000); } catch (InterruptedException e) {}
		
		if(wd != null) 
	    {
			do
			{
				wd = CyaraSingleton(args);
			}while(!wd.getCurrentUrl().toLowerCase().contains(cyaraIP.toLowerCase()));
	    }
	    return wd;
	} 
	protected static ChromeDriver CyaraSingleton(String[] args)
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
		try
		{
	        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	        //wd.get("http://"+ip+"/CyaraWebPortal/public/login"); //10.16.97.38/CyaraWebPortal/1/home
			try 
			{
				waitT(wd, 1000);
				wd.get("http://"+cyaraIP+"/CyaraWebPortal/public/login");
				waitT(wd, 2000);
				url = wd.getCurrentUrl();
			} catch (Exception ex) {}
		    
			try
			{
		        wd.manage().window().maximize();
		        wd.findElement(By.id("Username")).click();
		        wd.findElement(By.id("Username")).clear();
		        wd.findElement(By.id("Username")).sendKeys("fceleste");
		        wd.findElement(By.id("Password")).click();
		        wd.findElement(By.id("Password")).clear();
		        wd.findElement(By.id("Password")).sendKeys("[short jitc]1234");
		        wd.findElement(By.id("loginButton")).click();
		        waitT(wd, 500);
			} catch (Exception ex) {}
	        wd.findElement(By.cssSelector("a.brand")).click();
	        waitT(wd, 500);
	        wd.findElement(By.linkText("Test Cases")).click();
	        waitT(wd, 500);
	        wd.findElement(By.cssSelector("a[title=\"Test Cases & Blocks\"]")).click();
	        waitT(wd, 500);
		}
        catch (Exception ignore){}
		
		return wd;
	}//Cyara
	
	public static ChromeDriver implicitlyWaitSetter(ChromeDriver wd)
	{
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//new org.openqa.selenium.firefox.
		return wd;
	}
	
	//Firefox Profile
	public static ChromeDriver getFirefoxProfile(String profile)
	{
		
		try
		{
			System.setProperty("webdriver.chrome.driver", chromedriver);
			
			String file = profilePath;
			ChromeOptions options = new ChromeOptions();
			options.addArguments("user-data-dir="+profile);
			//
			//options.addArguments("disable-infobars"); // disabling infobars
			//options.addArguments("--disable-extensions"); // disabling extensions
			//options.addArguments("--disable-gpu"); // applicable to windows os only
			//options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
			//options.addArguments("--headless");
			//options.addArguments("--no-sandbox"); // Bypass OS security model
			//
			wd = new ChromeDriver(options);
			waitT(wd, 2000);
		}
		catch(Exception ex)
		{
			System.err.println(ex);
            ex.printStackTrace();
		}
			
		return wd;
	}
	
	//WebAdmin Index
	public static ChromeDriver getWebAdmin() 
	{
		
		try
		{
			do
			{
				try
				{
					if(wd != null)
						wd.quit();
				} catch (Exception ex) {}
				wd = null;
				wd = getFirefoxProfile(profilePath);
				
				if(wd != null) 
				{
					wd = WebAdminSingleton(webadminIP, webAdminUser, webAdminPW);
				}
			}while(!wd.getCurrentUrl().toLowerCase().contains(webadminIP.toLowerCase()));
			if(result != 0 && wd != null)
			{
				wd = null;
			}
			else if(result == -1001 && wd == null)
			{
				System.out.println("WebAdmin failed Login");
			}
			Thread.sleep(1000);
		}
		catch(Exception ex)
		{
			System.err.println(ex);
            ex.printStackTrace();
		}
		wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return wd;
	}
	
	public static ChromeDriver getWebAdmin(String profile) 
	{
		
		try
		{
			wd = null;
			wd = getFirefoxProfile(profile);
			
			if(wd != null) 
			{
				wd = WebAdminSingleton(webadminIP, webAdminUser, webAdminPW);
			}
			if(result != 0 && wd != null)
			{
				wd = null;
			}
			else if(result == -1001 && wd == null)
			{
				System.out.println("WebAdmin failed Login");
			}
			Thread.sleep(1000);
		}
		catch(Exception ex)
		{
			System.err.println(ex);
            ex.printStackTrace();
		}
		wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return wd;
	}
	
	public static ChromeDriver getJITCWebAdmin() 
	{
		result = -1;
		//ProfilesIni profile = null;
	    //FirefoxProfile ffProfile = null;
			
		while(result != 0)
		{
			//profile = new ProfilesIni();
			//ffProfile = profile.getProfile("default");
			wd = getFirefoxProfile(profilePath);//wd = getFirefoxProfile();
			
			if(wd != null) 
			{
				wd = WebAdminSingleton(webadminIP, webAdminUser, webAdminPW);
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
	
	public static ChromeDriver getWebAdminLogin(ChromeDriver wd) 
	{
		result = -1;
			
		while(result != 0)
		{
			if(wd != null) 
			{
				wd = WebAdminSingleton(webadminIP, webAdminUser, webAdminPW);
			}
			if(result != 0)
			{
				wd.quit();
				wd = null;
			}
		}
		
		return wd;
	}
	
	protected static ChromeDriver WebAdminSingleton(String webadminIP, String webAdminUser, String webAdminPW)
	{
		result = 0;
		try 
        {wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        	wd.manage().window().maximize();
        } catch (Exception ex) {}
		String url = "";
		int i = 1;
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        do
        {
	        url = wd.getCurrentUrl();
	        
	        try 
	        {
	        	do
	        	{
					waitT(wd, 100+1000*i);
					wd.get(webadminIP);
					url = wd.getCurrentUrl();
					if(url.length() < 1 || !url.toLowerCase().contains(webadminIP))
						waitT(wd, 1000+2000*i);
					i++;
		        }while(!url.toLowerCase().contains(webadminIP) || url.length() < 1 && i < 10);
		        if(!wd.getCurrentUrl().toLowerCase().contains(webadminIP.toLowerCase()))
		        {
			        result = -2;
			        return wd;
		        }
				
			} 
	        catch(Exception ex){ex.printStackTrace();}
		        
	        String loginbutton = "";
	        try{loginbutton = wd.findElement(By.id("uxLblLogin")).getText();}
	        catch(Exception idontcare){}
	        
	        if(url.length() < 1 || url.contains("google") || loginbutton.contains("Login"))
	        {
		        Alert alert;
		        waitT(wd, 1500);
		        if(wd.findElement(By.tagName("html")).getText().contains("User Name") || wd.findElement(By.tagName("html")).getText().contains("Password"))
		        {
			        wd.findElement(By.id("uxLogin_UserName")).click();
			        wd.findElement(By.id("uxLogin_UserName")).clear();
			        wd.findElement(By.id("uxLogin_UserName")).sendKeys(webAdminUser); //("jaren");
			        wd.findElement(By.id("uxLogin_Password")).click();
			        wd.findElement(By.id("uxLogin_Password")).clear();
			        wd.findElement(By.id("uxLogin_Password")).sendKeys(webAdminPW);
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
		        	waitT(wd, 1500+500*i);
			    	alert = wd.switchTo().alert();
			        alert.accept();
			    }   
			    catch (NoAlertPresentException ex) 
			    { 
			    	JITCflag = false;
			    	//nonJitc
			    }
		        waitT(wd, 1000+500*i);
		        url = wd.getCurrentUrl();
		        
	        }
        }while(!url.toLowerCase().contains("main.aspx"));
        
        if(false)
        {//todo: failure to login
        
        }
        else
        {
        	try
        	{
	        	wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
        	}
        	catch(Exception ex){waitT(wd, 12000);}
        	waitT(wd, 2000);
        }
        result = 0;
        return wd;
	}//WebAdmin End
	public static ChromeDriver getWebAdmin(String webadminIP, String webAdminUser, String webAdminPW) 
	{
		try
		{
			wd = null;
			wd = getFirefoxProfile(profilePath);
			
			if(wd != null) 
			{
				wd = WebAdminSingleton(webadminIP, webAdminUser, webAdminPW); //pass in your own webadmin
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
	}//WebAdminInputParameters End
	//Error Table
	/*public static int RunErrorTable(String url)
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
 	}*/
	public static int RunErrorTable(ChromeDriver wd, String[] para)
 	{
 		//Process process = null;
 		int result = -2;
 		//step = Integer.parseInt(args[0]);
        //if(args[1].equals("true"))
    		//state = true;
 		try
 		{
 			result = ErrorTable.errorTable(wd, para);
 			
 		}
 		catch (Exception ex)
 		{
 			System.err.println(ex);
 			ex.printStackTrace();
 			result = -109;
 		}
 		
 		return result;
 	}
	//Search Box function
	public static void searchBoxRange(ChromeDriver wd, String start, String end, int miliseconds)
	{
		waitT(wd, miliseconds/2);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartRange")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartRange")).sendKeys(start);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtEndRange")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtEndRange")).sendKeys(end);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLBtnStdSearch")).click();
		waitT(wd, miliseconds+500);
		String value = wd.findElementByTagName("html").getText();
        if(!value.contains(start) && !value.contains("Search Yielded No Results")) //if web page is slow then we wait more
        {
        	waitT(wd, miliseconds*2);
        }
	}
	
	public static void searchBoxRange(ChromeDriver wd, String start, String end)
	{
		waitT(wd, 2500);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartRange")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartRange")).sendKeys(start);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtEndRange")).clear();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtEndRange")).sendKeys(end);
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLBtnStdSearch")).click();
		waitT(wd, 3500);
		String value = wd.findElementByTagName("html").getText();
        if(!value.contains(start) && !value.contains("Search Yielded No Results"))
        {
        	waitT(wd, 5000);
        }
	}
	
	//WebAdmin Reset Section
	public static int resetDListAll(ChromeDriver wd, String startNum, String endNum) throws InterruptedException
    {//reset all DLists
		int result = 0;
		String rangeExtend = "0";
		
		try
		{
			for(int i = Integer.parseInt(startNum); i <= Integer.parseInt(endNum); i+=100)
			{
				if(Integer.parseInt(endNum)-i >= 100)
					rangeExtend = Integer.toString(i+99);
				else if(Integer.parseInt(endNum)-i >= 1 && Integer.parseInt(endNum)-i < 100)
					rangeExtend = endNum;
				else
					rangeExtend = Integer.toString(i);
				waitT(wd, 1000);
			    searchBoxRange(wd, Integer.toString(i), rangeExtend, 2500);
				if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected())
				    wd.findElement(By.id("uxChkboxsrtpr")).click();
				if(!wd.findElement(By.tagName("html")).getText().contains("Reset")) {
				    System.out.println("");
				}
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
				if(!wd.findElement(By.tagName("html")).getText().contains("Reset Boxes")) {
				    System.out.println("");
				}
				wd.findElement(By.linkText("Distribution Lists")).click();
				waitT(wd, 500);
				if(!wd.findElement(By.id("uxChkResetDlistAll")).isSelected()) {
				    wd.findElement(By.id("uxChkResetDlistAll")).click();
				}
				if(!wd.findElement(By.tagName("html")).getText().contains("Submit")) {
				    System.out.println("");
				}
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
				waitT(wd, 3500);
				if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
				{result += -10;}
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
				waitT(wd, 3500);
			}
		}
		catch(Exception ex)
		{result += -109;}
		return result;
    }
	public static int resetDList(ChromeDriver wd, String boxNum) throws InterruptedException
    {//reset Local DLists
		int result = 0;
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
		waitT(wd, 500);
		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetDList_UcxResetDlist_uxChkResetLocalDList")).isSelected()) {
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetDList_UcxResetDlist_uxChkResetLocalDList")).click();
		}
		if(!wd.findElement(By.tagName("html")).getText().contains("Submit")) {
		    System.out.println("");
		}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
		waitT(wd, 4500);
		if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
		{result += -10;}
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
		waitT(wd, 3500);
		return result;
    }
	
	public static int resetMessages(ChromeDriver wd, String startNum, String endNum) throws InterruptedException
    {//reset all messages
		int result = 0;
		String rangeExtend = "0";
		try
		{
			for(int i = Integer.parseInt(startNum); i <= Integer.parseInt(endNum); i+=100)
			{
				if(Integer.parseInt(endNum)-i >= 100)
					rangeExtend = Integer.toString(i+99);
				else if(Integer.parseInt(endNum)-i >= 1 && Integer.parseInt(endNum)-i < 100)
					rangeExtend = endNum;
				else
					rangeExtend = Integer.toString(i);
				waitT(wd, 1000);
			    searchBoxRange(wd, Integer.toString(i), rangeExtend, 2000);
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
				waitT(wd, 3500);
				if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
				{}
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
				waitT(wd, 3500);
			}
		}
		catch(Exception ex)
		{result += -109;}
		return result;
    }
	
	public static int resetCallOptions(ChromeDriver wd, String startNum, String endNum) throws InterruptedException
    {//reset all call options
		int result = 0;
		String rangeExtend = "0";
		try
		{
			for(int i = Integer.parseInt(startNum); i <= Integer.parseInt(endNum); i+=100)
			{
				if(Integer.parseInt(endNum)-i >= 100)
					rangeExtend = Integer.toString(i+99);
				else if(Integer.parseInt(endNum)-i >= 1 && Integer.parseInt(endNum)-i < 100)
					rangeExtend = endNum;
				else
					rangeExtend = Integer.toString(i);
				waitT(wd, 1000);
			    searchBoxRange(wd, Integer.toString(i), rangeExtend, 2000);
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
				waitT(wd, 3500);
				if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
				{}
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
				waitT(wd, 3500);
			}
		}
		catch(Exception ex)
		{result += -109;}
		return result;
    }
	
	public static int resetBoxAll(ChromeDriver wd, String startNum, String endNum) throws InterruptedException
    {//reset all available settings
		int result = 0;
		String rangeExtend = "0";
		
		try
		{
			for(int i = Integer.parseInt(startNum); i <= Integer.parseInt(endNum); i+=100)
			{
				if(Integer.parseInt(endNum)-i >= 100)
					rangeExtend = Integer.toString(i+99);
				else if(Integer.parseInt(endNum)-i >= 1 && Integer.parseInt(endNum)-i < 100)
					rangeExtend = endNum;
				else
					rangeExtend = Integer.toString(i);
				waitT(wd, 1500);
				enableBoxRange(wd, Integer.toString(i), rangeExtend);
			    searchBoxRange(wd, Integer.toString(i), rangeExtend, 1500);
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
						result += -10;
				}
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
				waitT(wd, 3500);
			}
		}
		catch(Exception ex)
		{result += -109;}
		result += rangeClearMWI(wd, startNum, startNum);
		return result;
    }
	
	public static int resetTimeBlocks(ChromeDriver wd, String startNum, String endNum) throws InterruptedException
    {//reset Daily Time Block Schedule
		int result = 0;
		String rangeExtend = "0";
		try
		{
			for(int i = Integer.parseInt(startNum); i <= Integer.parseInt(endNum); i+=100)
			{
				if(Integer.parseInt(endNum)-i >= 100)
					rangeExtend = Integer.toString(i+99);
				else if(Integer.parseInt(endNum)-i >= 1 && Integer.parseInt(endNum)-i < 100)
					rangeExtend = endNum;
				else
					rangeExtend = Integer.toString(i);
				waitT(wd, 1000);
			    searchBoxRange(wd, Integer.toString(i), rangeExtend, 2000);
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
				waitT(wd, 3500);
				if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
				{}
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
				waitT(wd, 3500);
			}
		}
		catch(Exception ex)
		{result += -109;}
		return result;
    }
	
	public static int resetGreetingTab(ChromeDriver wd, String startNum, String endNum) throws InterruptedException
    {//reset all greetings tab
		int result = 0;
		String rangeExtend = "0";
		try
		{
			for(int i = Integer.parseInt(startNum); i <= Integer.parseInt(endNum); i+=100)
			{
				if(Integer.parseInt(endNum)-i >= 100)
					rangeExtend = Integer.toString(i+99);
				else if(Integer.parseInt(endNum)-i >= 1 && Integer.parseInt(endNum)-i < 100)
					rangeExtend = endNum;
				else
					rangeExtend = Integer.toString(i);
				waitT(wd, 1000);
			    searchBoxRange(wd, Integer.toString(i), rangeExtend, 2000);
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
				waitT(wd, 3500);
				if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) 
				{}
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
				waitT(wd, 3500);
			}
		}
		catch(Exception ex)
		{result += -109;}
		return result;
    }
	
	public static int resetNotifications(ChromeDriver wd, String startNum, String endNum) throws InterruptedException
    {//reset all notification options
		int result = 0;
		String rangeExtend = "0";
		try
		{
			for(int i = Integer.parseInt(startNum); i <= Integer.parseInt(endNum); i+=100)
			{
				if(Integer.parseInt(endNum)-i >= 100)
					rangeExtend = Integer.toString(i+99);
				else if(Integer.parseInt(endNum)-i >= 1 && Integer.parseInt(endNum)-i < 100)
					rangeExtend = endNum;
				else
					rangeExtend = Integer.toString(i);
				waitT(wd, 1000);
			    searchBoxRange(wd, Integer.toString(i), rangeExtend, 2000);
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
				waitT(wd, 3500);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
				waitT(wd, 3500);
			}
		}
		catch(Exception ex)
		{result += -109;}
		return result;
    }
	//Reset Section End
	//Setup individual boxes
	public static void runSetups()
	{
		setupBox899997();
		setupBox899998();
	}
	
	public static void setupBox900005()
	{
		String box = "900005";
		int result = 0;
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetBoxAll(wd, box, box);
			WebDriverLogin.enableBoxRange(wd, box, box);
			WebDriverLogin.searchBoxRange(wd, box, box);
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
		
		String[] args = {};
		try
		{
			String[] folderList = {"Voice Rec", "Login", "setupBoxes", "VMbox initial setup 900005"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 190000);
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
	}
	
	public static void setupBox899997()
	{
		String box = "899997";
		int result = 0;
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetBoxAll(wd, box, box);
			WebDriverLogin.enableBoxRange(wd, box, box);
			WebDriverLogin.searchBoxRange(wd, box, box);
	    	waitT(wd, 2500);
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    waitT(wd, 1000);
	        wd.findElement(By.linkText("Basic")).click();
	        waitT(wd, 1000);
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).sendKeys("Permanent");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).sendKeys("Message Retention");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLifetime")).sendKeys("0");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLifetime")).sendKeys("0");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLength")).sendKeys("0");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLength")).sendKeys("0");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLifetime")).sendKeys("1");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLifetime")).sendKeys("99999999999999999");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
	        //
	        waitT(wd, 4000);
	        String value = wd.findElement(By.tagName("html")).getText();
	        if(!value.contains("Updated"))
	        	result += -10;
		    waitT(wd, 1500);
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
		
		String[] args = {};
		try
		{
			String[] folderList = {"Voice Rec", "Login", "setupBoxes", "VMbox initial setup 899997"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 210000);
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
	}
	
	public static void setupBox899998()
	{
		String box = "899998";
		int result = 0;
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetBoxAll(wd, box, box);
			WebDriverLogin.enableBoxRange(wd, box, box);
			WebDriverLogin.searchBoxRange(wd, box, box);
	    	waitT(wd, 3500);
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    waitT(wd, 3000);
	        wd.findElement(By.linkText("Basic")).click();
	        waitT(wd, 3000);
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).sendKeys("1 Day");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).sendKeys("Message Retention");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLifetime")).sendKeys("0");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLifetime")).sendKeys("0");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLength")).sendKeys("0");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLength")).sendKeys("0");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLifetime")).sendKeys("1");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLifetime")).sendKeys("99999999999999999");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
	        //
	        waitT(wd, 4000);
	        String value = wd.findElement(By.tagName("html")).getText();
	        if(!value.contains("Updated"))
	        	result += -10;
		    waitT(wd, 1500);
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
		
		String[] args = {};
		try
		{
			String[] folderList = {"Voice Rec", "Login", "setupBoxes", "VMbox initial setup 899998"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 210000);
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
	}
	
	public static int setupBox900006grt() throws InterruptedException
	{
		String[] args = {};
		String url = "";
		int result = 0;
		
		//Setup 900006
		try
		{
			wd = getWebAdmin();
			resetBoxAll(wd, "900006", "900006");
		    //
			searchBoxRange(wd, "900006", "900006", 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			waitT(wd, 2500);
			wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings")).click();
			waitT(wd, 2500);
			//
			forceElementChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreetingMaxNumGreetings", "3");
			forceElementChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudDefGreeting", "1");
			forceElementChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudBusyGreeting", "2");
			forceElementChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxDdlGreeting_AudNoAnsGreeting", "3");
			
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsSubmit")).click();
			waitT(wd, 2500);
			if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
			{
				System.out.println("Update failed");
			}
		  	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmGreetings_ucVmGreetings_uxBtnGreetingsClose")).click();
		  	waitT(wd, 2000);
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
	        String[] folderList = {"DList", "TestSuite", "Greeting", "setupGrt", "VMbox 900006 box setup"};
			wd = getCyara(args);
			result += cyaraFolderSearch(wd, folderList);
	        waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        waitT(wd, 190000);
	        String[] para = {"0","true"};
	        result += RunErrorTable(wd, para);
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
		
		return result;
	}
	
	public static void forceElementChange(ChromeDriver wd, String valueID, String valueNew)
	{
		Select select = null;
		WebElement option = null;
		String value = "";
		do
		{
			wd.findElement(By.id(valueID)).sendKeys(valueNew);
			waitT(wd, 500);
			select = new Select(wd.findElement(By.id(valueID)));
			option = select.getFirstSelectedOption();
			value = option.getText();
		}
		while(!value.contains(valueNew));
		waitT(wd, 500);
	}
	
	public static int setupBox899999() throws InterruptedException
	{
		String box = "899999";
		int result = 0;
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetBoxAll(wd, box, box);
	    	WebDriverLogin.searchBoxRange(wd, box, box, 2500);
	    	
		    //max digits passcode number
	    	waitT(wd, 3000);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    waitT(wd, 3000);
		    Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLength")));
			select.selectByVisibleText("10");
			waitT(wd, 3000);
	
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).sendKeys("The Tester");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).sendKeys("Robot");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_OwnerTss")).sendKeys("W");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_OwnerTss")).sendKeys(Keys.ENTER);
	        
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
	        //
	        waitT(wd, 5000);
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
		
		try
		{
			String[] args = {};
			String[] folderList = {"Voice Rec", "Login", "setupBoxes", "VMbox 899999 setup"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 200000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
	        
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
	    
	    return result;
	}//Individual box setup End
	
	//Clear MWI
	public static int clearMWI() throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
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
	
	public static int clearMWI(ChromeDriver wd, String boxNumber) throws Exception
	{
		int result = 0;
        //
		result = checkBox(wd, boxNumber);
		
		return result;
	}
	
	protected static int rangeClearMWI(ChromeDriver wd, String startNum, String endNum) throws InterruptedException
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
				WebDriverLogin.searchBoxRange(wd, (Integer.toString(Integer.parseInt(startNum)+i)), endNum, 2500);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
				waitT(wd, 2500);
				String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Mwi")).getAttribute("value");
				
			    waitT(wd, 500);
			    
			    if(value.length() > 1)
			    {
			    	//System.out.println(value);
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Mwi")).clear();
			    	waitT(wd, 500);
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
			    	waitT(wd, 4000);
			    }
			    
			    wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
			    waitT(wd, 3000);
			}
		}
	    catch (Exception ex)
	    {
	    	waitT(wd, 2000);
	    	wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
	    	waitT(wd, 4000);
	    }
		return result;
	}
	protected static int checkBox(ChromeDriver wd, String num) throws InterruptedException
	{//check for MWI setting
		int result = 0;
		
		try
		{
			WebDriverLogin.searchBoxRange(wd, num, num);
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
	public static int createVmNotificationTele(ChromeDriver wd, String box) throws InterruptedException
	{
		int result = 0;
		try
		{
			searchBoxRange(wd, box, box);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        waitT(wd, 2500);
	        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications")).click();
	        waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationOne")).click();
	        waitT(wd, 2500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).click();
	        //
	        waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_DialingString")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_DialingString")).sendKeys("1007");
	        waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_OwnerProgrammableNumber")).clear();
	        waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_OwnerProgrammableNumber")).sendKeys("4");
	        waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxDdlTelePager_OwnerProgDigits")).sendKeys("5");
	        waitT(wd, 550);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_NumOfMsgs")).clear();
	        waitT(wd, 550);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_NumOfMsgs")).sendKeys("5");
	        waitT(wd, 550);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_NumOfAttempts")).clear();
	        waitT(wd, 550);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxTxtTelePager_NumOfAttempts")).sendKeys("2");
	        //
	        waitT(wd, 550);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkTelePager_IgnoreDistMsgs")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkTelePager_IgnoreDistMsgs")).click();
	        waitT(wd, 550);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkQueueStartEndTime")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucTelephonePagerNotification_uxChkQueueStartEndTime")).click();
	        //
	        waitT(wd, 550);
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
	        waitT(wd, 2500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Changes Accepted"))
	        	result += -10;
	        
		}
		catch (Exception ex)
		{
			result += -102;
		}
		finally
		{
			waitT(wd, 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
		}
		
		return result;
	}
	
	public static int createVmNotificationEmail(ChromeDriver wd, String box) throws InterruptedException
	{
		int result = 0;
		try
		{
			searchBoxRange(wd, box, box);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        waitT(wd, 2500);
	        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications")).click();
	        waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationTwo")).click();
	        waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbEmail")).click();
	        waitT(wd, 2500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).click();
	        waitT(wd, 1500);
	        //
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEmailNotification_uxBtnEmailSubmit")).click();
	        waitT(wd, 2500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Changes Accepted"))
	        	result += -10;
	        
		}
		catch (Exception ex)
		{
			result += -102;
		}
		finally
		{
			waitT(wd, 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
		}
		
		return result;
	}
	
	public static int createVmNotificationWakeUp(ChromeDriver wd, String box) throws InterruptedException
	{
		int result = 0;
		try
		{
			searchBoxRange(wd, box, box);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        waitT(wd, 2500);
	        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications")).click();
	        waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationThree")).click();
	        waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbWakeUp")).click();
	        waitT(wd, 2500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).click();
	        waitT(wd, 1500);
	        //
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxBtnWakeUpSubmit")).click();
	        waitT(wd, 2500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Changes Accepted"))
	        	result += -10;
	        
		}
		catch (Exception ex)
		{
			result += -102;
		}
		finally
		{
			waitT(wd, 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
		}
		
		return result;
	}
	
	public static int createVmNotificationEscalation(ChromeDriver wd, String box) throws InterruptedException
	{
		int result = 0;
		try
		{
			searchBoxRange(wd, box, box);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        waitT(wd, 2500);
	        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications")).click();
	        waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationFour")).click();
	        waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbEscalation")).click();
	        waitT(wd, 2500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).click();
	        waitT(wd, 1500);
	        //
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucEscalationNotification_uxBtnEscalationSubmit")).click();
	        waitT(wd, 2500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Changes Accepted"))
	        	result += -10;
	        
		}
		catch (Exception ex)
		{
			result += -102;
		}
		finally
		{
			waitT(wd, 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotifCloseBtn")).click();
		}
		
		return result;
	}
	
	//End of Notification
	public static boolean checkBoxExists(ChromeDriver wd, String  box)
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
	
	public static int enableBoxRange(ChromeDriver wd, String startNum, String endNum)
	{
		int result = 0;
		String rangeExtend = "0";
		try
		{
			for(int i = Integer.parseInt(startNum); i <= Integer.parseInt(endNum); i+=100)
			{
				if(Integer.parseInt(endNum)-i >= 100)
					rangeExtend = Integer.toString(i+99);
				else if(Integer.parseInt(endNum)-i >= 1 && Integer.parseInt(endNum)-i < 100)
					rangeExtend = endNum;
				else
					rangeExtend = Integer.toString(i);
					
			    searchBoxRange(wd, Integer.toString(i), rangeExtend, 1000);
			    String value = wd.findElementByTagName("html").getText();
			    if(!value.contains("Search Yielded No Results"))
		        {
				    //enable section
				    wd.findElement(By.id("uxChkboxsrtpr")).click();
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLB_Box_State")).click();
			    	waitT(wd, 2000);
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRbState_Enabled")).click();
			    	waitT(wd, 250);
			    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxState_Multi_Submit")).click();
			    	waitT(wd, 2000);
		        }
			}
		}
		catch(Exception ex)
		{result += -109;}
		return result;
	}
	
	public static int disableBoxRange(ChromeDriver wd, String startNum, String endNum)
	{
		int result = 0;
		String rangeExtend = "0";
		try
		{
			for(int i = Integer.parseInt(startNum); i <= Integer.parseInt(endNum); i+=100)
			{
				if(Integer.parseInt(endNum)-i >= 100)
					rangeExtend = Integer.toString(i+99);
				else if(Integer.parseInt(endNum)-i >= 1 && Integer.parseInt(endNum)-i < 100)
					rangeExtend = endNum;
				else
					rangeExtend = Integer.toString(i);
					
			    searchBoxRange(wd, Integer.toString(i), rangeExtend, 2500);
			    //enable section
			    wd.findElement(By.id("uxChkboxsrtpr")).click();
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLB_Box_State")).click();
		    	waitT(wd, 2000);
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRbState_Disabled")).click();
		    	waitT(wd, 250);
		    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxState_Multi_Submit")).click();
		    	waitT(wd, 2000);
			}
		}
		catch(Exception ex)
		{result += -109;}
		return result;
	}
	
	public static int createTBoxWebAdmin(ChromeDriver wd, String box)
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
	
	public static int createVMBoxWebAdmin(ChromeDriver wd, String box)
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
			clickThis.selectByVisibleText("QATESTSP3");
			//
			dropDownListBox = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxDdlDefPropertyType")); 
			clickThis = new Select(dropDownListBox);
			clickThis.selectByVisibleText("Voicemail");
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
	
	public static int deleteBoxWebAdmin(ChromeDriver wd, String box)
	{
		int result = 0;
		try 
		{
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Delete")).click();
			waitT(wd, 2500);
			
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartBoxId")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartBoxId")).sendKeys(box);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtEndBoxId")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtEndBoxId")).sendKeys(box);
			
			waitT(wd, 1000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbDelWarn_Submit")).click();
			waitT(wd, 2500);
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblDeleteWarningStatus")).getText().contains("Boxes successfully deleted"))
				result += -10;
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbDelWarn_Cancel")).click();
			waitT(wd, 2500);
			
		} 
		catch (Exception ex) 
		{result += -10;}
		
		return result;
	}
	
	public static int cyaraFolderSearch(ChromeDriver wd, String[] folderList)
	{
		int result = 0;
		int j = 0;
		try
		{
			while(!wd.findElement(By.tagName("html")).getText().contains("CallOptions"))
			{
				wd.findElement(By.linkText("Cyara Testing")).click();
				waitT(wd, 500);
			}
			for(int i = 0; i < folderList.length-1; i++)
			{
				try
				{
					do
					{
			        	wd.findElement(By.linkText(folderList[i])).click();
			        	waitT(wd, 1000);
			        	j++;
			        	if(j > 50)
			        	{
			        		result += -9000;
			        		return result;
			        	}
			        }while(!wd.findElement(By.tagName("html")).getText().contains(folderList[i+1]));
				}catch(Exception idontcare){}
			}
			
			wd.findElement(By.linkText(folderList[folderList.length-1])).click();
		}
		catch (Exception ex){result += -10;}
		
		waitT(wd, 500);
		wd.findElement(By.id("PhoneNo")).clear();
		wd.findElement(By.id("PhoneNo")).sendKeys(calledNumber);//("5884@10.16.99.23"); //5897@10.16.99.23
		waitT(wd, 500);
		
		return result;
	}
	
	public static ChromeDriver waitTWA(ChromeDriver wd, int time)
	{
		time = time + time/2;
		waitT(wd, time);
		return wd;
	}
	
	public static ChromeDriver waitT(ChromeDriver wd, int time)
	{
		long multiplier = varMultiplier;
		long estimatedTime = 0;
		long begin = 0;
		long limit = 9999L; // 19999L math time is 220 milliseconds
        long largestPrimeFactor = 0;
        
		if(time > 10000)
			multiplier = 1000*1000;
		if(time <= 0)
			time = 1000;
		if(time > 0 && time <= 300)
			limit = 9001; //math time is 48 milliseconds
		if(time > 0 && time <= 50)
			limit = 1001; //math time is <48 milliseconds
		if(time > 600000000)
			time = 600000000;
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
				if(Timer < begin)// && multiplier == 1)
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
			//this should never throw
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
	
	public static String returnCustomReport(ChromeDriver wd, String sqlQuery)
	{
		Actions builder = new Actions(wd);
        builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'System Parameters')]"))).perform();
        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbReporting")).click();
        
        WebElement mySelectElm = wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingScripts")); 
        Select mySelect= new Select(mySelectElm);
        WebDriverLogin.waitT(wd, 1500);
        mySelect.selectByVisibleText("CustomReport.txt");
        wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingSelect")).click();
        WebDriverLogin.waitT(wd, 2000);
        wd.findElement(By.id("txtCustomSQL")).clear();
        wd.findElement(By.id("txtCustomSQL")).sendKeys(sqlQuery);
        wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingRun")).click();
        WebDriverLogin.waitT(wd, 2500);
        wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingClose")).click();
        WebDriverLogin.waitT(wd, 2500);
        String url = wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxHpReportingDownload")).getAttribute("href");
        wd.get(url);
        WebDriverLogin.waitT(wd, 2500);
        String xmlPage = wd.findElementByTagName("html").getText();
        wd = WebDriverLogin.getWebAdminLogin(wd);
        return xmlPage;
	}
	
	public static String getVariableName(String variableName, boolean defaultSettings, Properties prop)
	{
		String configValue = "";
		try
		{
			if(!defaultSettings)
				if(prop.getProperty("WebDriverLogin."+variableName).length() > 0)
					configValue = prop.getProperty("WebDriverLogin."+variableName);
		}
		catch (Exception ex)
		{
			configValue = "";
		}
		
		return configValue;
	}
	
	public static int thrownException()
	{
		return Exception;
	}
	
	public static String setVariable(String variableName)
	{
		boolean defaultSettings = false;
		String chromedriver = "C:\\selenium\\libraries\\chromedriver\\chromedriver.exe";
		String profilePath = "C:\\Users\\jbaird.CALLWARE\\AppData\\Local\\Google\\Chrome\\User Data";
		String FilePath = "\\\\CWENGFS\\Tests\\TestJars\\ErrorTable.jar";             
		String cyaraIP = "10.16.97.37";//"10.16.97.38";
		String webadminIP = "https://qatestsp3/webadmin/"; //"https://2016vm4fc/webadmin/";//"https://webadmintest/WebAdmin/";
		String calledNumber = "5789@10.16.99.23";
		String webAdminUser = "administrator"; //"jaren";
		String webAdminPW = "[long jitc]"; //"Agent@007";
		String returnValue = "";
		
		String fileName = "WebDriverLogin.config";
		String pathName = WebDriverLogin.class.getProtectionDomain().getCodeSource().getLocation().getPath(); 
		// get the path of the .jar 
		try {
			pathName = URLDecoder.decode(pathName,"utf-8");
		} catch (UnsupportedEncodingException e) {} 
		// convert the path format from HTML to UTF 
		pathName = pathName.substring(1,pathName.lastIndexOf("/") ); 
		//create a new string by removing the garbage 
		//System.out.println(pathName + "/" + fileName); // this is for debugging - see the results 
		fileName = (pathName + "/" + fileName);
		
		Properties prop = new Properties();
		InputStream is = null;
		try {
		    is = new FileInputStream(fileName);
		} catch (Exception ex) {defaultSettings = true;}
		try {
		    prop.load(is);
		} catch (Exception ex) {defaultSettings = true;}
		
		returnValue = getVariableName(variableName, defaultSettings, prop);
		
		if(variableName.contains("chromedriver"))
		{
			if(returnValue.length() < 1)
				returnValue = chromedriver;
		}
		else if(variableName.contains("profilePath"))
		{
			if(returnValue.length() < 1)
				returnValue = profilePath;
		}
		else if(variableName.contains("FilePath"))
		{
			if(returnValue.length() < 1)
				returnValue = FilePath;
		}
		else if(variableName.contains("cyaraIP"))
		{
			if(returnValue.length() < 1)
				returnValue = cyaraIP;
		}
		else if(variableName.contains("webadminIP"))
		{
			if(returnValue.length() < 1)
				returnValue = webadminIP;
		}
		else if(variableName.contains("calledNumber"))
		{
			if(returnValue.length() < 1)
				returnValue = calledNumber;
		}
		else if(variableName.contains("webAdminUser"))
		{
			if(returnValue.length() < 1)
				returnValue = webAdminUser;
		}
		else if(variableName.contains("webAdminPW"))
		{
			if(returnValue.length() < 1)
				returnValue = webAdminPW;
		}
		
		return returnValue;
	}
	/*
	public static void progRoutOptBroken(ChromeDriver wd)
	{
		wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		try
		{
			WebDriverLogin.waitT(wd, 500);
			wd.findElementByLinkText("Call Options").click();
			WebDriverLogin.waitT(wd, 1000);
			wd.findElementByLinkText("Routing Options").click();
			WebDriverLogin.waitT(wd, 1000);
			wd.findElement(By.id("uxChkResetCallOptsPRO")).click();
		}
		catch(Exception ex)
		{
			try
			{
				//wd.findElement(By.id("uxResetRoutingOpts_AA")).click();  //no longer broken
			}
			catch(Exception e){}
		}
	}*/
	
	
	/*
	//WebDriverLogin variables
	public static String chromedriver = "C:\\selenium\\libraries\\chromedriver\\chromedriver.exe";
	public static String profilePath = "C:\\Users\\jbaird.CALLWARE\\AppData\\Local\\Google\\Chrome\\User Data";
	public static int result = 9;
	public static boolean JITCflag = true;
	public static ChromeDriver wd = null;
	public static String FilePath = "\\\\CWENGFS\\Tests\\TestJars\\ErrorTable.jar";
	public static String cyaraIP = "10.16.97.37";//"10.16.97.38";
	public static String webadminIP = "https://fc-filthy/WebAdmin/";//"https://webadmintest/WebAdmin/";
	public static final int Exception = -109;
	public static long varMultiplier = 1000*1000; //millisecond*1000=nanosecond 1000*1000 = 1 second
	public static String calledNumber = "5861@10.16.99.23";
	public static String webAdminUser = "jaren";
	public static String webAdminPW = "[long jitc]";
	
	//SeanWebDriver variables
	public static String chromedriver = SeanWebDriver.chromedriver;
	public static String profilePath = SeanWebDriver.profilePath;
	public static int result = 9;
	public static boolean JITCflag = true;
	public static ChromeDriver wd = null;
	public static String FilePath = SeanWebDriver.FilePath;
	public static String cyaraIP = SeanWebDriver.cyaraIP;
	public static String webadminIP = SeanWebDriver.webadminIP;
	public static final int Exception = -109;
	public static long varMultiplier = SeanWebDriver.varMultiplier; //millisecond*1000=nanosecond 1000*1000 = 1 second
	public static String calledNumber = SeanWebDriver.calledNumber;
	public static String webAdminUser = SeanWebDriver.webAdminUser;
	public static String webAdminPW = SeanWebDriver.webAdminPW;
	*/
	/*
	public static int webAdminRightsOn(ChromeDriver wd, String userName)
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
	
	public static int webAdminRightsOff(ChromeDriver wd, String userName)
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
	
	public static void checkBoxToggle(ChromeDriver wd, String field, boolean state)
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