
import login.WebDriverLogin;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;

public class WakeUpNotifRepeat 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	private static int minuteStartTime = 0;
	//
	
	public static void main(String[] args) 
	{
		result = 0;
		String box = "1009";
		Calendar cal = null;
        String meridian = "AM";
        int startHour = 0;
        int endHour = 0;
        int startMinute = 0;
        int endMinute = 0;
        int hour = 0;
        int minute = 0;
        int i = 0;
        
		try
    	{
			wd = WebDriverLogin.getWebAdmin();
    		WebDriverLogin.searchBoxRange(wd, box, box);
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
    		WebDriverLogin.waitT(wd, 2500);
            wd.findElement(By.linkText("Notifications")).click();
            WebDriverLogin.waitT(wd, 2500);
            
			while(true)
			{
				cal = Calendar.getInstance();
		        hour = cal.get(Calendar.HOUR_OF_DAY);
		        minute = cal.get(Calendar.MINUTE);
		        
		        if(hour < 12)
		        {
		        	startHour = hour==0 ? 12 : hour;
		        	meridian = "AM";
		        }
		        else if(hour > 12)
		        {
		        	startHour = hour-12;
		        	meridian = "PM";
		        }
		        else
		        {
		        	startHour = 12;
		        	meridian = "PM";
		        }
		        startMinute = minute;
		        
		        try
		        {
			        if(endHour <= hour || endMinute <= startMinute)
			        {
		        		endHour = hour+1;
			        	endMinute = i==0 ? startMinute+2 : startMinute+1;
			        	if(endMinute >= 60 && startHour != 12)
			        		startHour++;
			        	
			        	result += changePlan(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationOne", startHour, endMinute, meridian); //
			        	result += changePlan(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationTwo", startHour, endMinute, meridian);
			        	result += changePlan(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationThree", startHour, endMinute, meridian);
			        	result += changePlan(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxLbNotificationFour", startHour, endMinute, meridian);
			        	i++;
			        }
		        }
		        catch(Exception ignore)
		        {
		        	i+=10;
		        	result += -10;
		        	ignore.printStackTrace(); //page might be slow
		        	WebDriverLogin.waitT(wd, 15000);
		        }
		        
	    		if(result <= -1000 || i >= 180)
	    			break;
			}
			
            WebDriverLogin.waitT(wd, 1500);
            wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
            WebDriverLogin.waitT(wd, 1500);
            WebDriverLogin.searchBoxRange(wd, box, box, 2000);
            WebDriverLogin.resetNotifications(wd, box, box);
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
		
	}
	
	public static int changePlan(ChromeDriver wd, String plan, int hour, int minuteNum, String meridian)
	{
		int result = 0;
		String minute = Integer.toString(minuteNum);
		String dialingString = "4001";
		if(minuteNum >= 60)
			minute = "00";
		else if(minute.length() == 1)
			minute = "0" + minute;
		
		try
		{
			WebDriverLogin.waitT(wd, 500);
			wd.findElement(By.id(plan)).click();
	    	WebDriverLogin.waitT(wd, 2500);
	    	if(wd.findElement(By.tagName("html")).getText().contains("Omit For Urgent"))
	    	{
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbEmail")).click();
	    		WebDriverLogin.waitT(wd, 5500);
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxRbWakeUp")).click();
	    		WebDriverLogin.waitT(wd, 12500);
	    	}
	    	//
	    	if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).isSelected())
	    	{
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_uxChkEnabled")).click();
	    		WebDriverLogin.waitT(wd, 2500);
	    	}
	    	if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtDialingString")).getAttribute("value").contains(dialingString))
	    	{
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtDialingString")).clear();
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtDialingString")).sendKeys(dialingString);
	    	}
	    	if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtNumberOfAttempts")).getAttribute("value").contains("99"))
	    	{
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtNumberOfAttempts")).clear();
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxTxtNumberOfAttempts")).sendKeys("99");
	    	}
	    	
    		WebElement mySelectElm = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlStartTimeHour")); 
	        Select mySelect= new Select(mySelectElm);
	        mySelect.selectByVisibleText(Integer.toString(hour));
	    	//
	    	mySelectElm = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlStartTimeMinute")); 
	        mySelect= new Select(mySelectElm);
	        mySelect.selectByVisibleText(minute);
	    	//
	        mySelectElm = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlRetryMinute")); 
	        mySelect= new Select(mySelectElm);
	        mySelect.selectByVisibleText("01");
	        //
	        mySelectElm = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxDdlStartTimeAmPm")); 
	        mySelect= new Select(mySelectElm);
	        mySelect.selectByVisibleText(meridian);
	        //
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxBtnWakeUpSubmit")).click();
	    	WebDriverLogin.waitT(wd, 2500);
	    	if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmNotifications_ucVmNotifications_ucWakeUpNotification_uxLblWakeUpStatus")).getText().contains("Changes Accepted"))
	    		result += -1;
		}
		catch(Exception ex)
    	{
    		result += -10;
    		ex.printStackTrace(); //page might be slow
        	WebDriverLogin.waitT(wd, 15000);
    	}
		
		return result;
	}
}
