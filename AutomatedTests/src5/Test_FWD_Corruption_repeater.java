
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

public class Test_FWD_Corruption_repeater
{
	private static int result = 9;
	private static int Exception = -2;
	private static String FilePath = "\\\\CWENGFS\\Tests\\TestJars\\table\\ErrorTable.jar";
	
	public static void main(String[] args) throws Exception
	{   
		String url = "\\\\CWENGFS\\Tests\\TestJars\\zWA_OS_misc_FWDcorrupt-t0.jar";
		String url2 = "\\\\CWENGFS\\Tests\\TestJars\\zWA_OS_misc_FWDcorrupt-t2.jar";
		
        for(int i = 0; i < 2; i++)
        {
        	do
        	{
        		RunJar(url);
        		RunJar(url2);
        	}
        	while(result == 0);
        }
		
       
       System.exit(result);
	}
    
	public static boolean isAlertPresent(ChromeDriver wd) 
    {
        try 
        {
            wd.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException e) 
        {
        	result = Exception;
            return false;
        }
    }
    
    public static void RunJar(String url)
 	{
 		Process process = null;
 		result = 99;
 		
 		try
 		{
 			process = Runtime.getRuntime().exec("java -jar " + url);
 			process.waitFor();
 			result = process.exitValue();
 		}
 		catch (Exception ex)
 		{
 			System.err.println(ex);
             ex.printStackTrace();
 		}
 	}
}
