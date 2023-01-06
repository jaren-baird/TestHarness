
import java.util.concurrent.TimeUnit;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebAdmin_ResetMultiBox 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//1WebAdmin_ResetMultiBox-t0
	//Test Case 13825:Box Reset - Select all in the reset screen
	//Test Case 13827:Box Reset - Clicking submit in the reset screen
	//Test Case 13828:Box Reset - Clicking Close in the reset screen
	//Test Case 13830:box Reset - Reset multiple boxes
    //Test Case 13832:Box Reset - Reset multiple boxes that are different box types
    //Test Case 13833:box Reset - Select Entire Box (select all) when resetting multiple box types
    //Test Case 13834:box Reset - Select Entire Box (select all) when resetting multiple box types. When asked to confirm Select no
	public static int fail()
	{
		return -10;
	}
	
	public static void main(String[] args) throws Exception
	{
        result = 0;
        String voiceB = "899991";
        String audioB = "899992";
        String ucdB = "899993";
        String faxB = "899994";
        String teacherB = "899995";
    	
        try
        {
        	wd = WebDriverLogin.getWebAdmin();
        	wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        	
        	if(!checkForBoxes(wd, voiceB, teacherB, "5"))
        	{
        		initiateCreation(wd, voiceB, "V");
				initiateCreation(wd, audioB, "A");
				initiateCreation(wd, ucdB, "U");
				initiateCreation(wd, faxB, "F");
				initiateCreation(wd, teacherB, "T");
        	}
        	else
        		WebDriverLogin.enableBoxRange(wd, voiceB, teacherB);
        	
        	wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebDriverLogin.searchBoxRange(wd, voiceB, teacherB, 2000);
            String startRange = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbID")).getText();
            String endRange = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl09_uxLbID")).getText();
	        setVoicemail(wd, voiceB, "ResetTestBox1");
	        setAudiotext(wd, audioB, "ResetTestBox2");
	        setUCD(wd, ucdB, "ResetTestBox3");
	        setFaxOnly(wd, faxB, "ResetTestBox4");
	        setTeacherBox(wd, teacherB, "ResetTestBox5");
	        WebDriverLogin.searchBoxRange(wd, voiceB, teacherB);
	        resetMultiBoxType(wd);
	        findFNTest(wd, "ResetTestBox1", true);
	        findFNTest(wd, "ResetTestBox2", true);
	        findFNTest(wd, "ResetTestBox3", true);
	        findFNTest(wd, "ResetTestBox4", true);
	        findFNTest(wd, "ResetTestBox5", true);
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtResetBoxesCopyRangeStart")).sendKeys(startRange);//899991
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtResetBoxesCopyRangeEnd")).sendKeys(endRange);//899995
	        WebDriverLogin.waitT(wd, 250);
	        if(!wd.findElement(By.id("uxChkResetAll")).isSelected()) {
	            wd.findElement(By.id("uxChkResetAll")).click();
	        }
	        WebDriverLogin.waitT(wd, 250);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        result += checksuccess(wd, "Reset Successful.");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 4500);
	        WebDriverLogin.searchBoxRange(wd, voiceB, teacherB, 2500);
	        findFNTest(wd, "ResetTestBox1", false);
	        findFNTest(wd, "ResetTestBox2", false);
	        findFNTest(wd, "ResetTestBox3", false);
	        findFNTest(wd, "ResetTestBox4", false);
	        findFNTest(wd, "ResetTestBox5", false);
	        //
	        result += findVRTest(wd, "ResetTestBox1", false, voiceB);
	        result += findVRTest(wd, "ResetTestBox2", false, audioB);
	        result += findVRTest(wd, "ResetTestBox3", false, ucdB);
	        result += findVRTest(wd, "ResetTestBox4", false, faxB);
	        result += findVRTest(wd, "ResetTestBox5", false, teacherB);
	        
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
        System.exit(result);
	}
	
	public static int findVRTest(ChromeDriver wd, String nickName, boolean found, String boxNumber)
	{
		int result = 0;
		
		WebDriverLogin.searchBoxRange(wd, boxNumber, boxNumber, 2500);
    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		WebDriverLogin.waitT(wd, 2500);
		if(wd.findElement(By.tagName("html")).getText().contains("Voice Rec."))
			wd.findElement(By.linkText("Voice Rec.")).click();
		else
			wd.findElement(By.linkText("Voice Rec")).click();
		WebDriverLogin.waitT(wd, 2500);
		String value = wd.findElement(By.tagName("html")).getText();
		if(!value.contains(nickName))
		{
			if(found == true)
				result += fail();
		}
		else
		{
			if(found == false)
				result += fail();
		}

		WebDriverLogin.waitT(wd, 500);
		wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
		WebDriverLogin.waitT(wd, 2500);
		
		return result;
    }
	
	public static void resetMultiBoxType(ChromeDriver wd) throws InterruptedException
	{
		WebDriverLogin.waitT(wd, 2000);
		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl03_uxChkItemBox")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl03_uxChkItemBox")).click();
		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl05_uxChkItemBox")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl05_uxChkItemBox")).click();
		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl07_uxChkItemBox")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl07_uxChkItemBox")).click();
		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl09_uxChkItemBox")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl09_uxChkItemBox")).click();
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
		result += checksuccess(wd, "Not all boxes checked were of the same type. Enter a range of boxes.");
		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
		WebDriverLogin.waitT(wd, 2000);
	}
	
	public static void findFNTest(ChromeDriver wd, String FName, boolean found)
    {
		if(!wd.findElement(By.tagName("html")).getText().contains(FName))
		{
			if(found == true)
				result += fail();
		}
		else
		{
			if(found == false)
				result += fail();
		}
    }
	
	public static void setParameter(ChromeDriver wd, String idValue, String value)
	{
		try
		{
			WebDriverLogin.waitT(wd, 2000);
			wd.findElement(By.id(idValue)).clear();
			wd.findElement(By.id(idValue)).sendKeys(value);
		}
		catch(Exception ex)
		{
			WebDriverLogin.waitT(wd, 2000);
			wd.findElement(By.id(idValue)).clear();
			wd.findElement(By.id(idValue)).sendKeys(value);
		}
	}
	
	public static void setVoicemail(ChromeDriver wd, String boxNumber, String boxFName) throws InterruptedException
    {
		try
		{
			WebDriverLogin.searchBoxRange(wd, boxNumber, boxNumber, 2500);
	        if(wd.findElement(By.tagName("html")).getText().contains(boxNumber))
	        {
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
				WebDriverLogin.waitT(wd, 3500);
				setParameter(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName", boxFName);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
				WebDriverLogin.waitT(wd, 3500);
				wd.findElement(By.linkText("Voice Rec.")).click();
				WebDriverLogin.waitT(wd, 2500);
				setParameter(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_NickName", boxFName);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxBtnVoiceRec_Submit")).click();
				WebDriverLogin.waitT(wd, 3500);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxBtnVoiceRec_Close")).click();
				WebDriverLogin.waitT(wd, 2500);
	        }
		}
		catch(Exception ex)
		{
			WebDriverLogin.waitT(wd, 2500);
		}
    }
	
	public static void setAudiotext(ChromeDriver wd, String boxNumber, String boxFName) throws InterruptedException
    {
		try
		{
			WebDriverLogin.searchBoxRange(wd, boxNumber, boxNumber, 1000);
	        if(wd.findElement(By.tagName("html")).getText().contains(boxNumber))
	        {
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
				WebDriverLogin.waitT(wd, 2500);
				setParameter(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpUser_ctl01_uxTxtUser_FirstName", boxFName);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpUser_ctl01_uxBtnUser_Submit")).click();
				WebDriverLogin.waitT(wd, 2500);
				wd.findElement(By.linkText("Voice Rec")).click();
				WebDriverLogin.waitT(wd, 2500);
				setParameter(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpVoiceRec_ucAttenVoiceRec_uxTxtVoiceRec_NickName", boxFName);
				WebDriverLogin.waitT(wd, 1500);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpVoiceRec_ucAttenVoiceRec_uxBtnVoiceRec_Submit")).click();
				WebDriverLogin.waitT(wd, 4500);
				try
				{
					wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpVoiceRec_ucAttenVoiceRec_uxBtnVoiceRec_Close")).click();
					WebDriverLogin.waitT(wd, 3500);
				}
				catch(Exception ex)
				{
					WebDriverLogin.waitT(wd, 5500);
					wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpVoiceRec_ucAttenVoiceRec_uxBtnVoiceRec_Close")).click();
					WebDriverLogin.waitT(wd, 5500);
				}
	        }
		}
		catch(Exception ex)
		{
			WebDriverLogin.waitT(wd, 2500);
		}
    }
	
	public static void setUCD(ChromeDriver wd, String boxNumber, String boxFName) throws InterruptedException
    {
		try
		{
			WebDriverLogin.searchBoxRange(wd, boxNumber, boxNumber, 2500);
	        if(wd.findElement(By.tagName("html")).getText().contains(boxNumber))
	        {
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
				WebDriverLogin.waitT(wd, 3500);
				setParameter(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName", boxFName);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
				WebDriverLogin.waitT(wd, 3500);
				wd.findElement(By.linkText("Voice Rec.")).click();
				WebDriverLogin.waitT(wd, 2500);
				setParameter(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_NickName", boxFName);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxBtnVoiceRec_Submit")).click();
				WebDriverLogin.waitT(wd, 3500);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxBtnVoiceRec_Close")).click();
				WebDriverLogin.waitT(wd, 2500);
	        }
		}
		catch(Exception ex)
		{
			WebDriverLogin.waitT(wd, 2500);
		}
    }
	
	public static void setFaxOnly(ChromeDriver wd, String boxNumber, String boxFName) throws InterruptedException
    {
		try
		{
			WebDriverLogin.searchBoxRange(wd, boxNumber, boxNumber, 2500);
	        if(wd.findElement(By.tagName("html")).getText().contains(boxNumber))
	        {
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
				WebDriverLogin.waitT(wd, 3500);
				setParameter(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName", boxFName);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
				WebDriverLogin.waitT(wd, 3500);
				wd.findElement(By.linkText("Voice Rec.")).click();
				WebDriverLogin.waitT(wd, 2500);
				setParameter(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_NickName", boxFName);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxBtnVoiceRec_Submit")).click();
				WebDriverLogin.waitT(wd, 3500);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxBtnVoiceRec_Close")).click();
				WebDriverLogin.waitT(wd, 2500);
	        }
		}
		catch(Exception ex)
		{
			WebDriverLogin.waitT(wd, 2500);
		}
    }
	
	public static void setTeacherBox(ChromeDriver wd, String boxNumber, String boxFName) throws InterruptedException
    {
		try
		{
	    	WebDriverLogin.searchBoxRange(wd, boxNumber, boxNumber, 2500);
	        if(wd.findElement(By.tagName("html")).getText().contains(boxNumber))
	        {
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
				WebDriverLogin.waitT(wd, 3500);
				setParameter(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName", boxFName);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
				WebDriverLogin.waitT(wd, 3500);
				wd.findElement(By.linkText("Voice Rec.")).click();
				WebDriverLogin.waitT(wd, 2500);
				setParameter(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_NickName", boxFName);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxBtnVoiceRec_Submit")).click();
				WebDriverLogin.waitT(wd, 3500);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxBtnVoiceRec_Close")).click();
				WebDriverLogin.waitT(wd, 2500);
	        }
		}
		catch(Exception ex)
		{
			WebDriverLogin.waitT(wd, 2500);
		}
    }
	
	public static int checksuccess(ChromeDriver wd, String data) throws InterruptedException
	{
		int result = 0;
		WebDriverLogin.waitT(wd, 3500);
		if(!wd.findElement(By.tagName("html")).getText().contains(data)) 
		{
			WebDriverLogin.waitT(wd, 5500);
			if(!wd.findElement(By.tagName("html")).getText().contains(data))
			{
				WebDriverLogin.waitT(wd, 7500);
				if(!wd.findElement(By.tagName("html")).getText().contains(data))
		        	result += fail();
			}
        }
		return result;
	}
	
	public static void createNewBox(ChromeDriver wd, String box, String boxType)
	{
		try
		{
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_New")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtNumberOfBoxesToCreate")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtNumberOfBoxesToCreate")).sendKeys("1");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartAtNumber")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartAtNumber")).sendKeys(box);
			//wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxDdlOwnerTss")).sendKeys("W");
			//wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxDdlOwnerTss")).sendKeys(Keys.ENTER);
			WebDriverLogin.waitT(wd, 500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxDdlDefPropertyType")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxDdlDefPropertyType")).sendKeys(boxType);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxDdlDefPropertyType")).sendKeys(Keys.ENTER);
			WebDriverLogin.waitT(wd, 250);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbNewBoxes_Submit")).click();
			WebDriverLogin.waitT(wd, 2500);
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblNewBoxStatus")).getText().contains("New Boxes Created."))
				WebDriverLogin.waitT(wd, 12000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbNewBoxes_Cancel")).click();
			WebDriverLogin.waitT(wd, 2500);
		}
		catch(Exception ex)
		{
			result += -109;
		}
	}
	
	public static void initiateCreation(ChromeDriver wd, String box, String boxType)
	{
		try
		{
			//String value = "";
			//WebDriverLogin.searchBoxRange(wd, box, box, 2500);
			//value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblBoxStatus")).getText();
			if(!checkForBoxes(wd, box, box, "1"))//(value.contains("Yielded No Result"))
				createNewBox(wd, box, boxType);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static boolean checkForBoxes(ChromeDriver wd, String box, String box2, String number)
	{
		try
		{
			String value = "";
			WebDriverLogin.searchBoxRange(wd, box, box2, 1500);
			try
			{
				value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblBoxStatus")).getText();
			}
			catch(Exception webadminError)
			{
				value = wd.findElementByTagName("html").getText();
			}
			if(value.contains("Search Yielded "+number+" Result"))
				return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return false;
	}
}
