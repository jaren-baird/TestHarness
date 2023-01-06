
package CopyBox;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T14354_CopyAudioTextCO 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14354_CopyAudioTextCO-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		//
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			//Enable boxes being used
			WebDriverLogin.enableBoxRange(wd, "900005", "900015");
			WebDriverLogin.resetBoxAll(wd, "890996", "890999");
			WebDriverLogin.searchBoxRange(wd, "890997", "890999");
			
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        
	        for(int i = 0; i < 10; i++)
	        {
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtRoutingOptions_Key")).clear();
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtRoutingOptions_Key")).sendKeys(""+i);
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtRoutingOptions_Number")).clear();
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtRoutingOptions_Number")).sendKeys(""+(i+900005));
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxLbAddRoutingOptions")).click();
	            WebDriverLogin.waitT(wd, 2500+(100*i));
	        }
	        
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtCOAT_OperatorBox")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtCOAT_OperatorBox")).sendKeys("1007");
	        WebDriverLogin.waitT(wd, 250);
	        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxDdlCOAT_MaxAudiotextDigits", "8");
	        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxDdlCOAT_GreetingReplayTime", "9");
	        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxDdlCOAT_NumberofGreetingPlays", "4");
	        WebDriverLogin.waitT(wd, 250);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtCOAT_XfrOnTimeout")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtCOAT_XfrOnTimeout")).sendKeys("1008");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtCOAT_XfrOnError")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtCOAT_XfrOnError")).sendKeys("1009");
	        WebDriverLogin.waitT(wd, 250);
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).isSelected()) 
	    		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxChkDirectToBox")).click();
	        
	        
	        
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
	        	result += fail();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOClose")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        //
	        
	        //
	        WebDriverLogin.searchBoxRange(wd, "890997", "890999");
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
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).sendKeys("890997");
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.linkText("Call Options")).click();
	        result += copyOneBox(wd);
	        if(!wd.findElement(By.id("uxChkResetCallOptAll")).isSelected())
	            wd.findElement(By.id("uxChkResetCallOptAll")).click();
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Copy Successful"))
	        	WebDriverLogin.waitT(wd, 4000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        //
	        result += checkBoxes(wd, "890998");
	        result += checkBoxes(wd, "890999");
	        //
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
        try
		{
        	wd = WebDriverLogin.getWebAdmin();
	        WebDriverLogin.searchBoxRange(wd, "890996", "890999");
	        if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected()) 
	        {
	        	wd.findElement(By.id("uxChkboxsrtpr")).click();
	        	if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl03_uxChkItemBox")).isSelected()) 
	        		wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl03_uxChkItemBox")).click();
	        }
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Copy")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTBResetBoxesNumber")).sendKeys("890997");
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.linkText("Call Options")).click();
	        result += copyOneBox(wd);
	        if(!wd.findElement(By.id("uxChkResetCallOptAll")).isSelected())
	            wd.findElement(By.id("uxChkResetCallOptAll")).click();
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Copy Successful"))
	        	WebDriverLogin.waitT(wd, 4000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        result += checkBoxes(wd, "890996");
	        //
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
		//
        System.exit(result);
	}
	
	public static void forceChange(ChromeDriver wd, String field, String value)
	{
		Select select = new Select(wd.findElement(By.id(field)));
		WebElement option = select.getFirstSelectedOption();
		String valueX = option.getText();
		try
		{
			while(!valueX.contains(value))
			{
				wd.findElement(By.id(field)).sendKeys(value);
				WebDriverLogin.waitT(wd, 1000);
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxLblCOAT_OperatorBox")).click();
				WebDriverLogin.waitT(wd, 1000);
				select = new Select(wd.findElement(By.id(field)));
				option = select.getFirstSelectedOption();
				valueX = option.getText();
			}
		}
		catch (Exception ex){}
	}
	
	public static int checkBoxes(ChromeDriver wd, String box) throws InterruptedException
	{
		int result = 0;
		
		WebDriverLogin.searchBoxRange(wd, box, box);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
        WebDriverLogin.waitT(wd, 1500);
        wd.findElement(By.id("__tab_ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions")).click();
        WebDriverLogin.waitT(wd, 4000);
        if(!wd.findElement(By.tagName("html")).getText().contains("Randy Orton"))
        	WebDriverLogin.waitT(wd, 12000);
        
        String value = "";
        value = wd.findElement(By.tagName("html")).getText();
        WebDriverLogin.waitT(wd, 2500);
        for(int i = 0; i < 10; i++)
        {
	        if(!value.contains(""+(i+900005)))
	        	result += fail();
        }
        //
        WebDriverLogin.waitT(wd, 2000);
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtCOAT_OperatorBox")).getAttribute("value");
        if(!value.contains("1007"))
        	result += fail();
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtCOAT_XfrOnTimeout")).getAttribute("value");
        if(!value.contains("1008"))
        	result += fail();
        value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxTxtCOAT_XfrOnError")).getAttribute("value");
        if(!value.contains("1009"))
        	result += fail();
        
        
        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxDdlCOAT_MaxAudiotextDigits")));
		WebElement option = select.getFirstSelectedOption();
		value = option.getText();
		if(!value.contains("8"))
        	result += fail();
		
		select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxDdlCOAT_GreetingReplayTime")));
		option = select.getFirstSelectedOption();
		value = option.getText();
		if(!value.contains("9"))
        	result += fail();
		
		select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxDdlCOAT_NumberofGreetingPlays")));
		option = select.getFirstSelectedOption();
		value = option.getText();
		if(!value.contains("4"))
        	result += fail();
        //
        //
        //
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerAutoAttendantProps_uxTpCallOptions_ucAttenCallOptions_AA_uxBtnCOClose")).click();
        WebDriverLogin.waitT(wd, 2500);
		
		return result;
	}
	
	public static int copyOneBox(ChromeDriver wd) throws Exception
    {
		WebDriverLogin.waitT(wd, 1000);
    	int result = 0;
    	
        if(!wd.findElement(By.id("uxChkResetCallOptAll")).isSelected()) {
            wd.findElement(By.id("uxChkResetCallOptAll")).click();
        }
        
        
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetOperatorBox_AA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetOperatorBox_AA")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetGreetingReplayTime_AA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetGreetingReplayTime_AA")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkXfrOnTimeout_AA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkXfrOnTimeout_AA")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetMaxAudioTextDgts_AA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkResetMaxAudioTextDgts_AA")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkNumGreetingPlays_AA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkNumGreetingPlays_AA")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkXfrOnError_AA")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetCallOptions_UcxResetCallOptions_uxChkXfrOnError_AA")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("uxResetRoutingOpts_AA")).isSelected())
            wd.findElement(By.id("uxResetRoutingOpts_AA")).click();
        else
        	result += fail();
        
        
        wd.findElement(By.linkText("Services")).click();
        WebDriverLogin.waitT(wd, 1000);
        if(wd.findElement(By.id("uxChxResetCOServices_AA")).isSelected())
            wd.findElement(By.id("uxChxResetCOServices_AA")).click();
        else
        	result += fail();
        
        WebDriverLogin.waitT(wd, 1000);
        
        
        if(wd.findElement(By.id("uxChkResetCallOptAll")).isSelected()) 
        {
            wd.findElement(By.id("uxChkResetCallOptAll")).click();
            WebDriverLogin.waitT(wd, 250);
            wd.findElement(By.id("uxChkResetCallOptAll")).click();
        }
        
        WebDriverLogin.waitT(wd, 1000);
        return result;
    }
	
	public static int fail()
	{
		return -10;
	}
}
