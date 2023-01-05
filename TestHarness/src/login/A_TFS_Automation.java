package login;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import login.SeanWebDriver;
import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class A_TFS_Automation 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static final String processName = "chrome.exe";
	private static final String driverName = "chromedriver.exe";
	private static final String TASKLIST = "tasklist";
	private static final String KILL = "taskkill /F /IM ";
	private static String FilePath = WebDriverLogin.getFilePath();
	//bugtesting-t0
	//bug testing
	
	public static void main(String[] args) throws Exception
	{
		//wd = WebDriverLogin.getWebAdmin();
		//WebDriverLogin.waitT(wd, 50);
		kill();
		int wait = 1000;
		result = 0;
		int i = 0;
		System.exit(result);//
		/*
		while(result == 0)
		{
			try
			{
				wd = SeanWebDriver.getCallWeb("1007", "4321");
				wd.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
				while(result == 0)
				{
					WebDriverLogin.waitT(wd, wait);
					wd.findElement(By.id("ctl00_uxPlaceHolderSubHeader_uxLbLogOut")).click();
					WebDriverLogin.waitT(wd, wait);
					wd.findElement(By.id("LinkButton1")).click();
					WebDriverLogin.waitT(wd, wait/3);
					wd.findElement(By.id("uxLogin_LoginButton")).click();
					
					i++;
				}
			}
			catch(Exception ex)
			{
				System.out.println("Wait: "+wait+"  iterations: "+i);
				wait += 1000;
				if(wd != null)
					wd.quit();
			}
		}
		
		wd = SeanWebDriver.getCallWeb("900005", "4321");
		wd.findElement(By.id("ctl00_uxCphNavigation_mail_content_uxLbNewMessage")).click();
		WebDriverLogin.waitT(wd, 500);
		wd.findElement(By.name("ctl00$uxCphMainContent$ucMessage$uxBtnTo")).click();
		WebDriverLogin.waitT(wd, 500);
		while(result == 0)
		{
			try
			{
				wd.findElement(By.id("ctl00_uxCphMainContent_ucMessage_ucAddressLookupMessage_uxRblSelectSearchSource_0")).click();
				WebDriverLogin.waitT(wd, wait);
				wd.findElement(By.id("ctl00_uxCphMainContent_ucMessage_ucAddressLookupMessage_uxRblSelectSearchSource_1")).click();
				WebDriverLogin.waitT(wd, wait);
				
				i++;
			}
			catch(Exception ex)
			{
				System.out.println("Wait: "+wait+"  iterations: "+i);
				wait += 50;
				if(wd != null)
					wd.quit();
			}
		}
		*/
		
		
		//kill();
		while(result != 1)
		{
			try
			{
		        //// Calls are not transfering on 6 digit numbers. needs looking into
		        String[] folderList = {"Voice Rec", "Login", "messagesLeave", "Leave_message"};
				wd = WebDriverLogin.getCyara(args);
				result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
		        WebDriverLogin.waitT(wd, 1500);
		        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
		            System.out.println("");
		        }
		        wd.findElement(By.id("executeButton")).click();
		        WebDriverLogin.waitT(wd, 50000);
		        String[] para = {"0","true"};
		        result += WebDriverLogin.RunErrorTable(wd, para);
		        wd.quit();
				wd = null;
			}
			catch(Exception ex)
			{
				result += -109;
				ex.printStackTrace();
				break;
			}
		}
		//WebDriverLogin.waitT(wd, 100);
		//WebDriverLogin.waitT(wd, 250);
		//WebDriverLogin.waitT(wd, 300);
		//WebDriverLogin.waitT(wd, 500);
		//WebDriverLogin.waitT(wd, 1000);
		//WebDriverLogin.waitT(wd, 2000);
		//WebDriverLogin.waitT(wd, 4000);
		
		
		//wd.quit();
        result = 0;
        System.exit(result);
	}
	
	public static void kill()
	{
		String javaName = "java.exe";
		try
		{
			Thread.sleep(500);
			if(isProcessRunning(processName))
			{
				killProcess(processName);
				Thread.sleep(250);
			}
			if(isProcessRunning(driverName))
			{
				killProcess(driverName);
				Thread.sleep(250);
			}
			if(isProcessRunning(javaName))
			{
				killProcess(javaName);
				Thread.sleep(250);
			}
		}
		catch (Exception ex)
		{
			System.err.println(ex);
            ex.printStackTrace();
		}
	}
	
	public static boolean isProcessRunning(String serviceName) throws Exception 
	{
		 Process p = Runtime.getRuntime().exec(TASKLIST);
		 BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		 String line;
		 while ((line = reader.readLine()) != null) 
		 {
			if(line.contains(serviceName)) 
			{
				return true;
			}
		 }
		 return false;
	}
	
	public static void killProcess(String serviceName) throws Exception 
	{
		Runtime.getRuntime().exec(KILL + serviceName);
	}
}
