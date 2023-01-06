package Removed;

import login.WebDriverLogin;
import login.SeanWebDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A_TFS_Automation 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//
	private static String chromedriver = "C:\\selenium\\libraries\\chromedriver\\chromedriver.exe";
	private static String profilePath = "C:\\Users\\jbaird.CALLWARE\\AppData\\Local\\Google\\Chrome\\User Data";
	//bugtesting-t0
	//bug testing
	
	public static void main(String[] args) throws Exception
	{
	    //
	    result = 0;
	    try
	    {
	    	while(true)
	    	{
    			String[] folderList = {"DList", "TestSuite", "Login test"};
    			wd = WebDriverLogin.getCyara(args);
    			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
    	        WebDriverLogin.waitT(wd, 1500);
    	        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
    	            System.out.println("");
    	        }
    	        wd.findElement(By.id("executeButton")).click();
    	        WebDriverLogin.waitT(wd, 46000);
    	        String[] para = {"0","true"};
    	        result += WebDriverLogin.RunErrorTable(wd, para);
    	  	   	wd.quit();
    	  	   	wd = null;
    	  	   	WebDriverLogin.waitT(wd, 600000);
	    	}
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	    
	    /*
	    //reset Local DLists
	    WebDriverLogin.resetDListAll(wd, "900005", "900149");
    	WebDriverLogin.enableBoxRange(wd, "900005", "900149");
    	WebDriverLogin.resetMessages(wd, "900005", "900149");
    	wd.quit();
    	*/
    	
    	
    	/*
		long myint = -1;
		Scanner keyboard = new Scanner(System.in);
		int wait = 1;
		while(myint != 0)
		{
			try
			{
				System.out.println("Choose wait");
				wait = keyboard.nextInt();
				if(wait <= 300)
				{
					System.out.println("Choose math limit");
					myint = keyboard.nextLong();
				}
				waitT(wd, wait, myint);
			}
			catch(Exception ex)
			{
				System.out.println("You entered an invalid string");
			}
		}*/
		
		
		/*
		wd = WebDriverLogin.getWebAdmin();
		
		wd.quit();
        result = 0;
        System.exit(result);*/
	}
	
	
	public static ChromeDriver waitT(ChromeDriver wd, int time)
	{
		long multiplier = 1000*1000;
		long estimatedTime = 0;
		long begin = 0;
		long limit = 19999L; //math time is 220 milliseconds
        long largestPrimeFactor = 0;
        
		if(time > 10000)
			multiplier = 1000*1000;
		if(time <= 0)
			time = 1000;
		if(time > 50 && time <= 300)
			limit = 9001; //math time is 48 milliseconds
		if(time > 0 && time <= 50)
			limit = 1001; //math time is <48 milliseconds
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
					System.out.println("Time(m): "+time +" ;i: "+i);
					break;
				}
				estimatedTime = ((int)(Timer - begin)/(10^5));//
				System.out.println("Time(s): "+estimatedTime+" ;nanoTime: "+ (Timer-begin));
				
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
	
	public static void clickLinkByHref(String href) 
	{
        List<WebElement> anchors = wd.findElements(By.tagName("a"));
        Iterator<WebElement> i = anchors.iterator();

        while(i.hasNext()) 
        {
            WebElement anchor = i.next();
            if(anchor.getAttribute("href").contains(href)) 
            {
                anchor.click();
                break;
            }
        }
    }
}
