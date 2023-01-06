
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.*;

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

public class Admin_Activity_Log
{
	//-t0
	private static int result = 0;
	private static String url = "";
	private static int minuteStartTime = 0;
	private static String debugDate = "";
	private static int debug = 1;
	
	public static void main(String[] args) throws Exception
	{
		ChromeDriver wd = null;
		
		program: try
	    {
			wd = WebDriverLogin.getWebAdmin();
	        
	        Calendar cal = Calendar.getInstance();
	        String startMeridian = "AM";
	        String endMeridian = "AM";
	        String dateString = "";
	        int startTime = 0;
	        int endTime = 0;
	        int today = 0;
	        int hour = cal.get(Calendar.HOUR_OF_DAY);
	        
	        if(hour == 12)
	        {
	        	startTime = 11;
	        	endTime = 1;
	        	endMeridian = "PM";
	        }
	        else if(hour > 12)
	        {
	        	if(hour-1 == 12 || hour-13 == 0)
	        		startTime = 11;
	        	else
	        	{
	        		startTime = hour-13;
	        		startMeridian = "PM";
	        	}
	        	endTime = hour-12;
	        	endMeridian = "PM";
	        }
	        else
	        {
	        	if(hour-1 <= 0)
	        	{
	        		today = -1;
	        		startTime = 11;
	        		startMeridian = "PM";
	        	}
	        	else
	        	{
	        		startTime = hour-1;
	        	}
	        	endTime = hour;
	        }
	        //Testing
	        if(debug != 0)
	        {
	        	startTime = 1;
	        	endTime = 3;
	        	startMeridian = "PM";
	        	endMeridian = "PM";
	        	//dateString
	        	today = 0;
	        	minuteStartTime = 0;
	        	debugDate = "2/15/2017";
	        }
	        //
	        
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkDefault(wd);
	        if(result != 0)
	        	break program;

	        //
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkDateDesc(wd);
	        if(result != 0)
	        	break program;
	        //
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkDateAsc(wd);
	        if(result != 0)
	        	break program;

	        //
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkSecurity(wd);
	        if(result != 0)
	        	break program;
	        //
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkSystemLog(wd);
	        if(result != 0)
	        	break program;
	        //
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkMaintenanceLog(wd);
	        if(result != 0)
	        	break program;
	        //
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkClientsLog(wd);
	        if(result != 0)
	        	break program;
	        //
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkUsersLog(wd);
	        if(result != 0)
	        	break program;
	        //
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkBoxesLog(wd);
	        if(result != 0)
	        	break program;
	        //
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkCreateType(wd);
	        if(result != 0)
	        	break program;
	        //
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkDeleteType(wd);
	        if(result != 0)
	        	break program;
	        //
	        
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkSuccess(wd);
	        if(result != 0)
	        	break program;
	        //
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkFailure(wd);
	        if(result != 0)
	        	break program;
	        //
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkLevelAsc(wd);
	        if(result != 0)
	        	break program;
	        //
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkLevelDesc(wd);
	        if(result != 0)
	        	break program;
	        //
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkTypeAsc(wd);
	        if(result != 0)
	        	break program;
	        //
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkTypeDesc(wd);
	        if(result != 0)
	        	break program;
	        //
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkCategoryAsc(wd);
	        if(result != 0)
	        	break program;
	        //
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkCategoryDesc(wd);
	        if(result != 0)
	        	break program;
	        //
	        
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkResultAsc(wd);
	        if(result != 0)
	        	break program;
	        //
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkResultDesc(wd);
	        if(result != 0)
	        	break program;
	        
	        //
 	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkDescriptionAsc(wd);
	        if(result != 0)
	        	break program;
	        //
	        openReporting(wd);
	        inputTime(wd, cal, endTime, startTime, startMeridian, endMeridian, dateString, today);
	        result = checkDescriptionDesc(wd);
	        if(result != 0)
	        	break program;
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
            return false;
        }
    }
    
    public static int checkDefault(ChromeDriver wd) throws InterruptedException
	{	
    	//default + Types
    	int result = -10;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportLogin,reportSingleCreate,reportSingleDelete,reportDualCreate,reportEdit,reportCopy,reportReset,reportDualDelete
    			,reportSecurity,reportSecurity,reportSystemLog,reportMaintenance,reportClients,reportUsers,reportUsers2,reportUsers3,reportUsers4,reportUsers5};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
		if(m.matches()) 
        {
			result = 0;
        }
		else
        {
			System.out.println(webpage);
	    	System.out.println(combinedStr);
	    	System.out.println(farthestPoint(r ,webpage));
			result = -11;
        }
		
		return result;
	}
    
    public static int checkDateDesc(ChromeDriver wd) throws InterruptedException
    {
    	//Date descending + types
    	int result = -20;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("rdlDate_1")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
    	String[] rgxCompare = {reportUsers5,reportUsers4,reportUsers3,reportUsers2,reportUsers,reportClients,reportMaintenance,reportSystemLog,
    			reportSecurity,reportSecurity,reportDualDelete,reportReset,reportCopy,reportEdit,reportDualCreate,reportSingleDelete,reportSingleCreate,reportLogin};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
		for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	//date descending
		combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(webpage);
	    	System.out.println(combinedStr);
	    	System.out.println(farthestPoint(r ,webpage));
			result = -21;
        }
    	
    	return result;
    }
    
    public static int checkDateAsc(ChromeDriver wd) throws InterruptedException
    {
    	//Date ascending + types
    	int result = -30;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("rdlDate_0")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportLogin,reportSingleCreate,reportSingleDelete,reportDualCreate,reportEdit,reportCopy,reportReset,reportDualDelete
    			,reportSecurity,reportSecurity,reportSystemLog,reportMaintenance,reportClients,reportUsers,reportUsers2,reportUsers3,reportUsers4,reportUsers5};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(webpage);
	    	System.out.println(combinedStr);
	    	System.out.println(farthestPoint(r ,webpage));
			result = -31;
        }
		
		return result;
    }
    
    public static int checkSystemLog(ChromeDriver wd) throws InterruptedException
    {
    	//System Category + types
    	int result = -40;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("cklCategory_2")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
    	String rgxCompare = reportSystemLog;
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	rgxCompare = regexReplace(rgxCompare);
    	
    	r = Pattern.compile(rgxCompare);
    	m = r.matcher(webpage);
    	
    	if(m.matches()) 
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -41;
        }
    	
		return result;
    }
    
    public static int checkMaintenanceLog(ChromeDriver wd) throws InterruptedException
    {
    	//Maintenance Category + types
    	int result = -50;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("cklCategory_5")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
    	String rgxCompare = reportMaintenance;
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	rgxCompare = regexReplace(rgxCompare);
    	
    	r = Pattern.compile(rgxCompare);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -51;
        }
		
		return result;
    }
    
    public static int checkClientsLog(ChromeDriver wd) throws InterruptedException
    {
    	//Client Category + types
    	int result = -60;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("cklCategory_7")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
    	String rgxCompare = reportClients;
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	rgxCompare = regexReplace(rgxCompare);
    	
    	r = Pattern.compile(rgxCompare);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -61;
        }
		
		return result;
    }
    
    public static int checkUsersLog(ChromeDriver wd) throws InterruptedException
    {
    	//Users Category + types
    	int result = -70;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("cklCategory_6")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportLogin,reportUsers,reportUsers2,reportUsers3,reportUsers4,reportUsers5};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(combinedStr);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -71;
        }
		
		return result;
    }
    
    public static int checkBoxesLog(ChromeDriver wd) throws InterruptedException
    {
    	//Boxes Category + types
    	int result = -80;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("cklCategory_8")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportSingleCreate,reportSingleDelete,reportDualCreate,reportEdit,reportCopy,reportReset,reportDualDelete};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -81;
        }
		
		return result;
    }
    
    public static int checkCreateType(ChromeDriver wd) throws InterruptedException
    {
    	//Create Type
    	int result = -90;
    	wd.findElement(By.id("cklType_0")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportSingleCreate,reportDualCreate};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -91;
        }
		
		return result;
    }
    
    public static int checkDeleteType(ChromeDriver wd) throws InterruptedException
    {
    	//Delete Type
    	int result = -100;
        wd.findElement(By.id("cklType_1")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportSingleDelete,reportDualDelete};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -101;
        }
		
		return result;
    }
    
    public static int checkSuccess(ChromeDriver wd) throws InterruptedException
    {
    	//Success
    	int result = -110;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("cklResult_1")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportLogin,reportSingleCreate,reportSingleDelete,reportDualCreate,reportEdit,reportCopy,reportReset,reportDualDelete
        		,reportSecurity,reportSecurity,reportSystemLog,reportMaintenance,reportClients,reportUsers,reportUsers2,reportUsers3,reportUsers4,reportUsers5};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -111;
        }
		
		return result;
    }
    
    public static int checkFailure(ChromeDriver wd) throws InterruptedException
    {
    	//Failure
    	int result = -120;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("cklResult_0")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
    	String combinedStr = "(rgx)<DocumentElement />";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	combinedStr = regexReplace(combinedStr);
    	
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(combinedStr);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -121;
        }
		
		return result;
    }
    
    public static int checkLevelHigh(ChromeDriver wd) throws InterruptedException
    {
    	//Level High
    	int result = -132;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("cklLevel_0")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportSecurity,reportSecurity,reportSystemLog
        		,reportUsers,reportUsers2,reportUsers3,reportUsers4,reportUsers5};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -133;
        }
		
		return result;
    }
    
    public static int checkLevelMid(ChromeDriver wd) throws InterruptedException
    {
    	//Level Mid
    	int result = -134;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("cklLevel_1")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportSingleDelete,reportCopy,reportReset,reportDualDelete,reportMaintenance,reportClients};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -135;
        }
		
		return result;
    }
    
    public static int checkLevelLow(ChromeDriver wd) throws InterruptedException
    {
    	//Level Low
    	int result = -136;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("cklLevel_2")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportLogin,reportSingleCreate,reportDualCreate,reportEdit};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -137;
        }
		
		return result;
    }
    
    public static int checkLevelAsc(ChromeDriver wd) throws InterruptedException
    {
    	//Level Ascending
    	int result = -130;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("rdlLevel_0")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportSecurity,reportSecurity,reportSystemLog,reportUsers,reportUsers2,reportUsers3,reportUsers4,reportUsers5,reportSingleDelete,
        		reportCopy,reportReset,reportDualDelete,reportMaintenance,reportClients,reportLogin,reportSingleCreate,reportDualCreate,reportEdit};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -131;
        }
		
		return result;
    }
    
    public static int checkLevelDesc(ChromeDriver wd) throws InterruptedException
    {
    	//Level Descending
    	int result = -140;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("rdlLevel_1")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportLogin,reportSingleCreate,reportDualCreate,reportEdit,reportSingleDelete,reportCopy,reportReset,reportDualDelete,reportMaintenance,
        		reportClients,reportSecurity,reportSecurity,reportSystemLog,reportUsers,reportUsers2,reportUsers3,reportUsers4,reportUsers5};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -141;
        }
		
		return result;
    }
    
    public static int checkTypeAsc(ChromeDriver wd) throws InterruptedException
    {
    	//Type Ascending
    	int result = -150;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("rdlType_0")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportSingleCreate,reportDualCreate,reportSingleDelete,reportDualDelete,reportLogin,reportEdit,reportSecurity,reportSecurity,
        		reportSystemLog,reportMaintenance,reportClients,reportUsers,reportUsers2,reportUsers3,reportUsers4,reportUsers5,reportCopy,reportReset};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -151;
        }
		
		return result;
    }
    
    public static int checkTypeDesc(ChromeDriver wd) throws InterruptedException
    {
    	//Type Descending
    	int result = -160;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("rdlType_1")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportReset,reportCopy,reportLogin,reportEdit,reportSecurity,reportSecurity,reportSystemLog,reportMaintenance,reportClients,
        		reportUsers,reportUsers2,reportUsers3,reportUsers4,reportUsers5,reportSingleDelete,reportDualDelete,reportSingleCreate,reportDualCreate};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -161;
        }
		
		return result;
    }
    
    public static int checkCategoryAsc(ChromeDriver wd) throws InterruptedException
    {
    	//Category Ascending
    	int result = -170;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("rdlCategory_0")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportSecurity,reportSecurity,reportSystemLog,reportMaintenance,reportLogin,reportUsers,reportUsers2,reportUsers3,reportUsers4,
        		reportUsers5,reportClients,reportSingleCreate,reportSingleDelete,reportDualCreate,reportEdit,reportCopy,reportReset,reportDualDelete};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -171;
        }
		
		return result;
    }
    
    public static int checkCategoryDesc(ChromeDriver wd) throws InterruptedException
    {
    	//Category Descending
    	int result = -180;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("rdlCategory_1")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportSingleCreate,reportSingleDelete,reportDualCreate,reportEdit,reportCopy,reportReset,reportDualDelete,reportClients,reportLogin,
        		reportUsers,reportUsers2,reportUsers3,reportUsers4,reportUsers5,reportMaintenance,reportSystemLog,reportSecurity,reportSecurity};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -181;
        }
		
		return result;
    }
    
    public static int checkResultAsc(ChromeDriver wd) throws InterruptedException
    {
    	//Result Ascending
    	int result = -190;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("rdlResult_0")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportLogin,reportSingleCreate,reportSingleDelete,reportDualCreate,reportEdit,reportCopy,reportReset,reportDualDelete
        		,reportSecurity,reportSecurity,reportSystemLog,reportMaintenance,reportClients,reportUsers,reportUsers2,reportUsers3,reportUsers4,reportUsers5};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -191;
        }
		
		return result;
    }
    
    public static int checkResultDesc(ChromeDriver wd) throws InterruptedException
    {
    	//Result Descending
    	int result = -200;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("rdlResult_1")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportLogin,reportSingleCreate,reportSingleDelete,reportDualCreate,reportEdit,reportCopy,reportReset,reportDualDelete
        		,reportSecurity,reportSecurity,reportSystemLog,reportMaintenance,reportClients,reportUsers,reportUsers2,reportUsers3,reportUsers4,reportUsers5};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -201;
        }
		
		return result;
    }
    
    public static int checkDescriptionAsc(ChromeDriver wd) throws InterruptedException
    {
    	//Description Ascending
    	int result = -210;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("rdlDescription_0")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportCopy,reportSingleCreate,reportDualCreate,reportUsers,reportUsers2,reportUsers3,reportUsers4,reportSingleDelete,reportDualDelete,
        		  reportMaintenance,reportSecurity,reportSecurity,reportSystemLog,reportReset,reportLogin,reportEdit,reportClients,reportUsers5};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -211;
        }
		
		return result;
    }
    
    public static int checkDescriptionDesc(ChromeDriver wd) throws InterruptedException
    {
    	//Description Descending
    	int result = -220;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("rdlDescription_1")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportUsers5,reportClients,reportEdit,reportLogin,reportReset,reportSystemLog,reportSecurity,reportSecurity,reportMaintenance,
        		reportDualDelete,reportSingleDelete,reportUsers4,reportUsers3,reportUsers2,reportUsers,reportDualCreate,reportSingleCreate,reportCopy};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -221;
        }
		
		return result;
    }
    
    public static int checkSecurity(ChromeDriver wd) throws InterruptedException
    {
    	//Category Security 
    	int result = -230;
    	wd.findElement(By.id("cklType_0")).click();
        wd.findElement(By.id("cklType_1")).click();
        wd.findElement(By.id("cklType_2")).click();
        wd.findElement(By.id("cklType_3")).click();
        wd.findElement(By.id("cklType_5")).click();
        wd.findElement(By.id("cklType_6")).click();
        wd.findElement(By.id("cklCategory_0")).click();
        result = runReporting(wd);
        if(result != 0)
        	return result;
        
        String webpage = wd.getPageSource();
        String[] rgxCompare = {reportSecurity,reportSecurity};
    	String combinedStr = "";
    	Pattern r = null;
    	Matcher m = null;
    	webpage = regexReplace(webpage);
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
    	
    	combinedStr = regexReplace(combinedStr);
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(rgxCompare);
			System.out.println(webpage);
			System.out.println(farthestPoint(r ,webpage));
			result = -231;
        }
		
		return result;
    }
    
    public static int runReporting(ChromeDriver wd) throws InterruptedException
    {
    	int result = -1;
    	WebDriverLogin.waitT(wd, 1000);
    	if(wd.findElements(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingRun")).isEmpty())
    		return result;
    	else
    		result = 0;
    	
    	wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingRun")).click();
        WebDriverLogin.waitT(wd, 500);
        if(!wd.findElement(By.tagName("html")).getText().contains("Download File"))
        {
        	wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingClose")).click();
        	WebDriverLogin.waitT(wd, 1000);
        }
        wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxHpReportingDownload")).click();
        WebDriverLogin.waitT(wd, 3000);
        
        return result;
    }
    
    public static void openReporting(ChromeDriver wd) throws InterruptedException
    {
    	WebDriverLogin.waitT(wd, 2000);
    	String isXML = wd.getCurrentUrl();
    	if(!isXML.endsWith(".xml"))
    	{
    		if(!wd.findElements(By.id("ctl00_uxCphNavigation_uxLbBoxes")).isEmpty())
        		wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
    	}
    	else
    		wd = WebDriverLogin.getWebAdmin();
        
        WebDriverLogin.waitT(wd, 3000);
        Actions builder = new Actions(wd);
        builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'System Parameters')]"))).perform();
        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbReporting")).click();
        WebDriverLogin.waitT(wd, 3000);
        WebElement mySelectElm = wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingScripts")); 
        Select mySelect= new Select(mySelectElm);
        mySelect.selectByVisibleText("AdminActivityLog.txt");
        wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingSelect")).click();
    }
    
    public static void inputTime(ChromeDriver wd, Calendar cal, int endTime, int startTime, String startMeridian, String endMeridian, String dateString, int today) throws InterruptedException
    {
    	WebDriverLogin.waitT(wd, 3000);
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        wd.findElement(By.id("txtUserID(s)")).sendKeys("55");
        new Select(wd.findElement(By.id("hourEndTime"))).selectByVisibleText(Integer.toString(endTime));
        new Select(wd.findElement(By.id("hourStartTime"))).selectByVisibleText(Integer.toString(startTime));
        new Select(wd.findElement(By.id("ampmStartTime"))).selectByVisibleText(startMeridian);
        new Select(wd.findElement(By.id("ampmEndTime"))).selectByVisibleText(endMeridian);
    	wd.findElement(By.id("minuteEndTime")).sendKeys("59");
        cal.add(Calendar.DATE, today);
        dateString = sdf.format(cal.getTime());
        wd.findElement(By.id("caltxtboxStartDate")).clear();
        wd.findElement(By.id("caltxtboxStartDate")).sendKeys(dateString);
        cal.add(Calendar.DATE, 0);
        dateString = sdf.format(cal.getTime());
        wd.findElement(By.id("caltxtboxEndDate")).clear();
        wd.findElement(By.id("caltxtboxEndDate")).sendKeys(dateString);
        
        //testing
        if(debug != 0)
        {
        	wd.findElement(By.id("minuteStartTime")).sendKeys(Integer.toString(minuteStartTime));
        	
        	wd.findElement(By.id("caltxtboxStartDate")).clear();
            wd.findElement(By.id("caltxtboxStartDate")).sendKeys(debugDate);
            wd.findElement(By.id("caltxtboxEndDate")).clear();
            wd.findElement(By.id("caltxtboxEndDate")).sendKeys(debugDate);
        }
    }
    
    public static int farthestPoint(Pattern pattern, String input) {
	    for (int i = input.length() - 1; i > 0; i--) {
	        Matcher matcher = pattern.matcher(input.substring(0, i));
	        if(!matcher.matches() && matcher.hitEnd()) {
	            return i;
	        }
	    }
	    return 0;
	}
    
    public static String regexReplace(String replaced)
    {
    	replaced = replaced.replace("(rgx)","[A-Za-z_0-9<>\\-\\:\\.\\s/=]*");
    	replaced = replaced.replaceAll("[\\r\\n\\s]", "");
    	replaced = replaced.replaceAll("[()]", "");
    	replaced = replaced.replaceAll("<DocumentElement>", "");
    	replaced = replaced.replaceAll("</DocumentElement>", "");
    	
    	return replaced;//<DocumentElement>
    }
    
    private static String reportLogin = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Low</Level><Type>Edit</Type><Category>Users</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>SuccessfulPKIself-registration</Description></Row>");

    private static String reportSingleCreate = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Low</Level><Type>Create</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Created1newVoicemailboxesstartingatnumber13371337forclientWEBADMINTEST</Description></Row>");

    private static String reportSingleDelete = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Delete</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Deletedboxes:(rgx)</Description></Row>");

    private static String reportDualCreate = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Low</Level><Type>Create</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Created2newVoicemailboxesstartingatnumber13371337forclientWEBADMINTEST</Description></Row>");

    private static String reportEdit = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Low</Level><Type>Edit</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Updatedbox:(rgx)</Description></Row>");

    private static String reportCopy = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Copy</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Copiedbox(rgx)</Description></Row>");

    private static String reportReset = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Reset</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Resetboxes(FilterUser=2080639Groups=-1):(rgx)</Description></Row>");

    private static String reportDualDelete = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Delete</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Deletedboxes:(rgx)</Description></Row>");
    
    private static String reportSecurity = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Security</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Edited Security Settings: Mailbox Max Passcode Retention= (rgx)</Description></Row>");
    
    private static String reportSystemLog = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>SystemLog</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>EditedSystemLogParameters:UserActivityLevel=7UserActivityType=127UserActivityCategory=1023UserActivityResult=3</Description></Row>");

    private static String reportMaintenance = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Edit</Type><Category>Maintenance</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>EditedMaintenanceSettings:</Description></Row>");

    private static String reportClients = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Edit</Type><Category>Clients</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Updatedclient'ReportTest'ID:9</Description></Row>");

    private static String reportUsers = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID1(ViewBoxes=1EditBoxes=1CreateBoxes=1DeleteBoxes=1CopyBoxes=1RenumberBoxes=1ResetBoxes=1TelephonyServerControl=1)</Description></Row>");

    private static String reportUsers2 = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID2(ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0)</Description></Row>");

    private static String reportUsers3 = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID7(ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0)</Description></Row>");

    private static String reportUsers4 = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID9(ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0)</Description></Row>");

    private static String reportUsers5 = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Updateduser:jarenID:55.BackupDB=1ViewClients=1EditClients=1CreateClients=1DeleteClients=1ViewSysParams=1EditSysParams=1ViewUsers=1EditUsers=1CreateUsers=1DeleteUsers=1ViewReports=1ViewSecuritySettings=1EditSecuritySettings=1</Description></Row>");
    
    
    /*
    private static String reportLogin = regexReplace("(rgx)55(rgx)jaren(rgx)Low(rgx)Edit(rgx)Users(rgx)"
			+ "Success(rgx)Successful PKI self-registration(rgx)");

    private static String reportSingleCreate = regexReplace("(rgx)55(rgx)jaren(rgx)Low(rgx)Create(rgx)Boxes(rgx)"
			+ "Success(rgx)Created 1 new Voicemail boxes starting at number 13371337 for client WEBADMINTEST(rgx)");

    private static String reportSingleDelete = regexReplace("(rgx)55(rgx)jaren(rgx)Medium(rgx)Delete(rgx)Boxes(rgx)"
			+ "Success(rgx)Deleted boxes:(rgx)");

    private static String reportDualCreate = regexReplace("(rgx)55(rgx)jaren(rgx)Low(rgx)Create(rgx)Boxes(rgx)"
			+ "Success(rgx)Created 2 new Voicemail boxes starting at number 13371337 for client WEBADMINTEST(rgx)");

    private static String reportEdit = regexReplace("(rgx)55(rgx)jaren(rgx)Low(rgx)Edit(rgx)Boxes(rgx)"
			+ "Success(rgx)Updated box:(rgx)");

    private static String reportCopy = regexReplace("(rgx)55(rgx)jaren(rgx)Medium(rgx)Copy(rgx)Boxes(rgx)"
			+ "Success(rgx)Copied box (rgx) (Filter User=2097020 Messages=4177727 Faxes=1279 Groups=7 Notifications=7 Call Options=16777215 Connectivity=590269 Greetings=16383 Voice Rec=1 Outbound=15) to boxes: 91(rgx)");

    private static String reportReset = regexReplace("(rgx)55(rgx)jaren(rgx)Medium(rgx)Reset(rgx)Boxes(rgx)"
			+ "Success(rgx)Reset boxes (Filter User=2080639 Groups=-1): (rgx)");

    private static String reportDualDelete = regexReplace("(rgx)55(rgx)jaren(rgx)Medium(rgx)Delete(rgx)Boxes(rgx)"
    		+ "Success(rgx)Deleted boxes: (rgx)");
    
    private static String reportSystemLog = regexReplace("(rgx)55(rgx)jaren(rgx)High(rgx)Edit(rgx)System Log(rgx)"
			+ "Success(rgx)1(rgx)Edited System Log Parameters: User Activity Level=7 User Activity Type=127 User Activity Category=1023 User Activity Result=3(rgx)");

    private static String reportMaintenance = regexReplace("(rgx)55(rgx)jaren(rgx)Medium(rgx)Edit(rgx)Maintenance(rgx)"
			+ "Success(rgx)Edited Maintenance Settings:(rgx)");

    private static String reportClients = regexReplace("(rgx)55(rgx)jaren(rgx)Medium(rgx)Edit(rgx)Clients(rgx)"
			+ "Success(rgx)Updated client 'Report Test' ID: (rgx)");

    private static String reportUsers = regexReplace("(rgx)55(rgx)jaren(rgx)High(rgx)Edit(rgx)Users(rgx)"
			+ "Success(rgx)1(rgx)Created client control rights for user: jaren ID: 55 for client ID 1 (ViewBoxes=1 EditBoxes=1 CreateBoxes=1 DeleteBoxes=1 CopyBoxes=1 RenumberBoxes=1 ResetBoxes=1 TelephonyServerControl=1 )(rgx)");

    private static String reportUsers2 = regexReplace("(rgx)55(rgx)jaren(rgx)High(rgx)Edit(rgx)Users(rgx)"
			+ "Success(rgx)1(rgx)Created client control rights for user: jaren ID: 55 for client ID 2 (ViewBoxes=0 EditBoxes=0 CreateBoxes=0 DeleteBoxes=0 CopyBoxes=0 RenumberBoxes=0 ResetBoxes=0 TelephonyServerControl=0 )(rgx)");

    private static String reportUsers3 = regexReplace("(rgx)55(rgx)jaren(rgx)High(rgx)Edit(rgx)Users(rgx)"
			+ "Success(rgx)1(rgx)Created client control rights for user: jaren ID: 55 for client ID 7 (ViewBoxes=0 EditBoxes=0 CreateBoxes=0 DeleteBoxes=0 CopyBoxes=0 RenumberBoxes=0 ResetBoxes=0 TelephonyServerControl=0 )(rgx)");

    private static String reportUsers4 = regexReplace("(rgx)55(rgx)jaren(rgx)High(rgx)Edit(rgx)Users(rgx)"
			+ "Success(rgx)1(rgx)Created client control rights for user: jaren ID: 55 for client ID 9 (ViewBoxes=0 EditBoxes=0 CreateBoxes=0 DeleteBoxes=0 CopyBoxes=0 RenumberBoxes=0 ResetBoxes=0 TelephonyServerControl=0 )(rgx)");

    private static String reportUsers5 = regexReplace("(rgx)55(rgx)jaren(rgx)High(rgx)Edit(rgx)Users(rgx)"
			+ "Success(rgx)0(rgx)Updated user: jaren ID: 55. BackupDB=1ViewClients=1EditClients=1CreateClients=1DeleteClients=1ViewSysParams=1EditSysParams=1ViewUsers=1EditUsers=1CreateUsers=1DeleteUsers=1ViewReports=1ViewSecuritySettings=1EditSecuritySettings=1(rgx)");
*/

}
    

    
/*
*
*
<DocumentElement>
<Row>
<UserID>55</UserID>
<Login>jaren</Login>
<Session>1a299b05-faf2-37c8-9235-976246352bc7</Session>
<Date>2017-01-19T09:43:39.567</Date>
<Level>Low</Level>
<Type>Edit</Type>
<Category>Users</Category>
<Result>Success</Result>
<Description>Successful PKI self-registration</Description>
</Row>
<DocumentElement>
<Row>
<UserID>55</UserID>
<Login>jaren</Login>
<Session>1a299b05-faf2-37c8-9235-976246352bc7</Session>
<Date>2017-01-19T09:43:39.567</Date>
<Level>Low</Level>
<Type>Edit</Type>
<Category>Users</Category>
<Result>Success</Result>
<Description>Successful PKI self-registration</Description>
</Row>
<Row>
<UserID>55</UserID>
<Login>jaren</Login>
<Session>1a299b05-faf2-37c8-9235-976246352bc7</Session>
<Date>2017-01-19T09:44:28.767</Date>
<Level>Low</Level>
<Type>Create</Type>
<Category>Boxes</Category>
<Result>Success</Result>
<Description>Created 1 new Voicemail boxes starting at number 13371337 for client WEBADMINTEST</Description>
</Row>
<Row>
<UserID>55</UserID>
<Login>jaren</Login>
<Session>1a299b05-faf2-37c8-9235-976246352bc7</Session>
<Date>2017-01-19T09:45:21.910</Date>
<Level>Medium</Level>
<Type>Delete</Type>
<Category>Boxes</Category>
<Result>Success</Result>
<Description>Deleted boxes: 92 to 92</Description>
</Row>
<Row>
<UserID>55</UserID>
<Login>jaren</Login>
<Session>1a299b05-faf2-37c8-9235-976246352bc7</Session>
<Date>2017-01-19T09:45:49.567</Date>
<Level>Low</Level>
<Type>Create</Type>
<Category>Boxes</Category>
<Result>Success</Result>
<Description>Created 2 new Voicemail boxes starting at number 13371337 for client WEBADMINTEST</Description>
</Row>
<Row>
<UserID>55</UserID>
<Login>jaren</Login>
<Session>1a299b05-faf2-37c8-9235-976246352bc7</Session>
<Date>2017-01-19T09:46:55.103</Date>
<Level>Low</Level>
<Type>Edit</Type>
<Category>Boxes</Category>
<Result>Success</Result>
<Description>Updated box: 92</Description>
</Row>
<Row>
<UserID>55</UserID>
<Login>jaren</Login>
<Session>1a299b05-faf2-37c8-9235-976246352bc7</Session>
<Date>2017-01-19T09:47:39.310</Date>
<Level>Medium</Level>
<Type>Copy</Type>
<Category>Boxes</Category>
<Result>Success</Result>
<Description>Copied box 92 (Filter User=2097020 Messages=4177727 Faxes=1279 Groups=7 Notifications=7 Call Options=16777215 Connectivity=590269 Greetings=16383 Voice Rec=1 Outbound=15) to boxes: 93</Description></Row><Row><UserID>55</UserID><Login>jaren</Login><Session>1a299b05-faf2-37c8-9235-976246352bc7</Session><Date>2017-01-19T09:48:35.327</Date><Level>Medium</Level><Type>Reset</Type><Category>Boxes</Category><Result>Success</Result><Description>Reset boxes (Filter User=2080639 Groups=-1): 92 to 92</Description>
</Row>
<Row>
<UserID>55</UserID>
<Login>jaren</Login>
<Session>1a299b05-faf2-37c8-9235-976246352bc7</Session>
<Date>2017-01-19T09:49:25.397</Date>
<Level>Medium</Level>
<Type>Delete</Type>
<Category>Boxes</Category>
<Result>Success</Result>
<Description>Deleted boxes: 92 to 93</Description>
</Row>
<Row>
<UserID>55</UserID>
<Login>jaren</Login>
<Session>1a299b05-faf2-37c8-9235-976246352bc7</Session>
<Date>2017-01-19T09:49:59.123</Date>
<Level>High</Level>
<Type>Edit</Type>
<Category>System Log</Category>
<Result>Success</Result>
<Description/>
</Row>
<Row>
<UserID>55</UserID>
<Login>jaren</Login>
<Session>1a299b05-faf2-37c8-9235-976246352bc7</Session>
<Date>2017-01-19T09:50:03.443</Date>
<Level>Medium</Level>
<Type>Edit</Type>
<Category>Maintenance</Category>
<Result>Success</Result>
<Description>Edited Maintenance Settings:</Description>
</Row>
<Row>
<UserID>55</UserID>
<Login>jaren</Login>
<Session>1a299b05-faf2-37c8-9235-976246352bc7</Session>
<Date>2017-01-19T09:50:07.813</Date>
<Level>Medium</Level>
<Type>Edit</Type>
<Category>Clients</Category>
<Result>Success</Result>
<Description>Updated client 'Report Test' ID: 9</Description>
</Row>
<Row>
<UserID>55</UserID>
<Login>jaren</Login>
<Session>1a299b05-faf2-37c8-9235-976246352bc7</Session>
<Date>2017-01-19T09:50:13.130</Date>
<Level>High</Level>
<Type>Edit</Type>
<Category>Users</Category>
<Result>Failure</Result>
<Description>Created client control rights for user: jaren ID: 55 for client ID 55 (ViewBoxes=1 EditBoxes=1 CreateBoxes=1 DeleteBoxes=1 CopyBoxes=1 RenumberBoxes=1 ResetBoxes=1 TelephonyServerControl=1 )</Description></Row><Row><UserID>55</UserID><Login>jaren</Login><Session>1a299b05-faf2-37c8-9235-976246352bc7</Session><Date>2017-01-19T09:50:13.137</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Failure</Result><Description>Created client control rights for user: jaren ID: 55 for client ID 55 (ViewBoxes=0 EditBoxes=0 CreateBoxes=0 DeleteBoxes=0 CopyBoxes=0 RenumberBoxes=0 ResetBoxes=0 TelephonyServerControl=0 )</Description>
</Row>
<Row>
<UserID>55</UserID>
<Login>jaren</Login>
<Session>1a299b05-faf2-37c8-9235-976246352bc7</Session>
<Date>2017-01-19T09:50:13.147</Date>
<Level>High</Level>
<Type>Edit</Type>
<Category>Users</Category>
<Result>Failure</Result>
<Description>Created client control rights for user: jaren ID: 55 for client ID 55 (ViewBoxes=0 EditBoxes=0 CreateBoxes=0 DeleteBoxes=0 CopyBoxes=0 RenumberBoxes=0 ResetBoxes=0 TelephonyServerControl=0 )</Description>
</Row>
<Row>
<UserID>55</UserID>
<Login>jaren</Login>
<Session>1a299b05-faf2-37c8-9235-976246352bc7</Session>
<Date>2017-01-19T09:50:13.153</Date>
<Level>High</Level>
<Type>Edit</Type>
<Category>Users</Category>
<Result>Failure</Result>
<Description>Created client control rights for user: jaren ID: 55 for client ID 55 (ViewBoxes=0 EditBoxes=0 CreateBoxes=0 DeleteBoxes=0 CopyBoxes=0 RenumberBoxes=0 ResetBoxes=0 TelephonyServerControl=0 )</Description>
</Row>
<Row>
<UserID>55</UserID>
<Login>jaren</Login>
<Session>1a299b05-faf2-37c8-9235-976246352bc7</Session>
<Date>2017-01-19T09:50:13.163</Date>
<Level>High</Level>
<Type>Edit</Type>
<Category>Users</Category>
<Result>Failure</Result>
<Description>Updated user: jaren ID: 55. BackupDB=1ViewClients=1EditClients=1CreateClients=1DeleteClients=1ViewSysParams=1EditSysParams=1ViewUsers=1EditUsers=1CreateUsers=1DeleteUsers=1ViewReports=1ViewSecuritySettings=1EditSecuritySettings=1</Description>
</Row>
<Row>
<UserID>55</UserID>
<Login>jaren</Login>
<Session>66108075-664d-4749-06f2-b179d74941e8</Session>
<Date>2017-01-19T09:05:13.880</Date>
<Level>Low</Level>
<Type>Edit</Type>
<Category>Users</Category>
<Result>Success</Result>
<Description>Successful PKI self-registration</Description>
</Row>
<Row>
<UserID>55</UserID>
<Login>jaren</Login>
<Session>66108075-664d-4749-06f2-b179d74941e8</Session>
<Date>2017-01-19T09:06:02.043</Date>
<Level>Low</Level>
<Type>Create</Type>
<Category>Boxes</Category>
<Result>Success</Result>
<Description>Created 2 new Voicemail boxes starting at number 13371337 for client WEBADMINTEST</Description>
</Row>
<Row>
<UserID>55</UserID>
<Login>jaren</Login>
<Session>66108075-664d-4749-06f2-b179d74941e8</Session>
<Date>2017-01-19T09:07:06.993</Date>
<Level>Medium</Level>
<Type>Delete</Type>
<Category>Boxes</Category>
<Result>Success</Result>
<Description>Deleted boxes: 92 to 93</Description>
</Row>
</DocumentElement>
*/
