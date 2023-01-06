
package CopyBox;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T14362_CopyVRecVM 
{
	private static int result = 9;
	private static int Exception = -109;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14362_CopyVRecVM-t0
	public static int fail()
	{
		return -10;
	}
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetBoxAll(wd, "900006", "900008");
			WebDriverLogin.searchBoxRange(wd, "900006", "900008");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.linkText("Voice Rec.")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        
	        CheckNames(wd);
	        
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxBtnVoiceRec_Submit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
	        	result += fail();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxBtnVoiceRec_Close")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        
	        WebDriverLogin.searchBoxRange(wd, "900006", "900008");
	        if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected()) 
	        {
	        	wd.findElement(By.id("uxChkboxsrtpr")).click();
	        	if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).isSelected()) 
	        		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Copy")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).sendKeys("900006");
	        WebDriverLogin.waitT(wd, 250);
	        wd.findElement(By.linkText("Voice Rec.")).click();
	        WebDriverLogin.waitT(wd, 500);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetVoiceRec_uxChkResetVoRecNames")).isSelected())
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetVoiceRec_uxChkResetVoRecNames")).click();
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Copy Successful"))
	    		result += fail();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        //
	        
	        //
	        result += checkBoxes(wd, "900007");
	        result += checkBoxes(wd, "900008");
	        
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
		
        System.exit(result);
	}
	
	public static int checkBoxes(ChromeDriver wd, String box) throws InterruptedException
	{
		int result = 0;
		try
		{
			WebDriverLogin.searchBoxRange(wd, box, box);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.linkText("Voice Rec.")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        
	        String value = "";
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_NickName")).getAttribute("value");
	        if(!value.contains("Stone Cold"))
	            result += fail();
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName1")).getAttribute("value");
			if(!value.contains("Steve Austin")) 
				result += fail();
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName2")).getAttribute("value");
			if(!value.contains("The Viper")) 
				result += fail();
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName3")).getAttribute("value");
			if(!value.contains("Randy Orton")) 
				result += fail();
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName4")).getAttribute("value");
			if(!value.contains("Big Guy Bain")) 
				result += fail();
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName5")).getAttribute("value");
			if(!value.contains("Hulk Hogan")) 
				result += fail();
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName6")).getAttribute("value");
			if(!value.contains("John Cena")) 
				result += fail();
			
	        
	        WebDriverLogin.waitT(wd, 250);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxBtnVoiceRec_Close")).click();
	        WebDriverLogin.waitT(wd, 2000);
		}
		catch(Exception ex)
		{
			result += Exception;
		}
		
		return result;
	}
	
	public static void CheckNames(ChromeDriver wd)
	{
		String value = "";
		try
		{
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_NickName")).getAttribute("value");
	        if(!value.contains("Stone Cold"))
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_NickName")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_NickName")).clear();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_NickName")).sendKeys("Stone Cold");
	        }
	        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName1")).getAttribute("value");
			if(!value.contains("Steve Austin")) 
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName1")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName1")).clear();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName1")).sendKeys("Steve Austin");
	        }
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName2")).getAttribute("value");
			if(!value.contains("The Viper")) 
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName2")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName2")).clear();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName2")).sendKeys("The Viper");
	        }
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName3")).getAttribute("value");
			if(!value.contains("Randy Orton")) 
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName3")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName3")).clear();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName3")).sendKeys("Randy Orton");
	        }
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName4")).getAttribute("value");
			if(!value.contains("Big Guy Bain")) 
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName4")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName4")).clear();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName4")).sendKeys("Big Guy Bain");
	        }
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName5")).getAttribute("value");
			if(!value.contains("Hulk Hogan")) 
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName5")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName5")).clear();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName5")).sendKeys("Hulk Hogan");
	        }
			value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName6")).getAttribute("value");
			if(!value.contains("John Cena")) 
	        {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName6")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName6")).clear();
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxTxtVoiceRec_OtherName6")).sendKeys("John Cena");
	        }
		}
		catch(Exception ex)
		{
			result += Exception;
		}
	}
}
