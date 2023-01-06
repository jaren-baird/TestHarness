
import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class VM_Voice_Rec
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
        //
		try
    	{
    		String box = "1007";
    		WebDriverLogin.searchBoxRange(wd, box, box);
    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
    		WebDriverLogin.waitT(wd, 2000);
    		wd.findElement(By.cssSelector("#__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec > span")).click();
            //wd.findElement(By.linkText("Messages")).click();
            WebDriverLogin.waitT(wd, 1500);
            //
            //
            if(!wd.findElement(By.tagName("html")).getText().contains("Voice Recognition Additional Names"))
                System.out.println("verifyTextPresent failed");
            CheckNames(wd);
            
            WebDriverLogin.waitT(wd, 500);
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxBtnVoiceRec_Submit")).click();
            WebDriverLogin.waitT(wd, 1500);
            if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
                System.out.println("Voice Rec wasn't updated");
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxBtnVoiceRec_Close")).click();
            WebDriverLogin.waitT(wd, 1500);
            //
    		wd.quit();
    		wd = null;
    		result = 0;
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
	
	public static void CheckNames(ChromeDriver wd)
	{
		String value = "";
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
}
