
package CopyBox;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T14361_CopyVM_ODO 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T14361_CopyVM_ODO-t0
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
	        wd.findElement(By.linkText("Outbound Delivery")).click();
	        WebDriverLogin.waitT(wd, 2000);
	        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmOutboundDelivery_ucVmOutboundDelivery_uxDdlDeliveryAttempts", "3");
	        forceChange(wd, "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmOutboundDelivery_ucVmOutboundDelivery_uxDdlOutboundDel_Hour", "5");
	        if(!wd.findElement(By.id("uxChkMessageFaxBroadcast")).isSelected()) 
	    		wd.findElement(By.id("uxChkMessageFaxBroadcast")).click();
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.id("uxChkImmediateBroadcast")).isSelected()) 
	    		wd.findElement(By.id("uxChkImmediateBroadcast")).click();
	        WebDriverLogin.waitT(wd, 500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmOutboundDelivery_ucVmOutboundDelivery_uxBtnOutboundDelSubmit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Updated"))
	        	result += fail();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmOutboundDelivery_ucVmOutboundDelivery_uxBtnOutboundDelClose")).click();
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
	        WebDriverLogin.waitT(wd, 1000);
	        wd.findElement(By.linkText("Outbound Delivery")).click();
	        result += copyOneBox(wd);
	        if(!wd.findElement(By.id("uxChkResetODAll")).isSelected())
	            wd.findElement(By.id("uxChkResetODAll")).click();
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
				wd.findElement(By.id("loggedin_user_control")).click();
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
        wd.findElement(By.linkText("Outbound Delivery")).click();
        WebDriverLogin.waitT(wd, 1000);
        
        if(!wd.findElement(By.id("uxChkMessageFaxBroadcast")).isSelected())
        	result += fail();
        if(!wd.findElement(By.id("uxChkImmediateBroadcast")).isSelected())
        	result += fail();
        
        String value = "";
        Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmOutboundDelivery_ucVmOutboundDelivery_uxDdlDeliveryAttempts")));
		WebElement option = select.getFirstSelectedOption();
		value = option.getText();
		if(!value.contains("3"))
        	result += fail();
		select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmOutboundDelivery_ucVmOutboundDelivery_uxDdlOutboundDel_Hour")));
		option = select.getFirstSelectedOption();
		value = option.getText();
		if(!value.contains("5"))
        	result += fail();
		
        
        WebDriverLogin.waitT(wd, 500);
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmOutboundDelivery_ucVmOutboundDelivery_uxBtnOutboundDelClose")).click();
        WebDriverLogin.waitT(wd, 2000);
		
		return result;
	}
	
	public static int copyOneBox(ChromeDriver wd) throws Exception
    {
		WebDriverLogin.waitT(wd, 1000);
    	int result = 0;
    	
        if(!wd.findElement(By.id("uxChkResetODAll")).isSelected()) {
            wd.findElement(By.id("uxChkResetODAll")).click();
        }
        
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkDeliveryAttmpts")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkDeliveryAttmpts")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkDeliveryRxTime")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkDeliveryRxTime")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkMsgFaxBroadcast")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkMsgFaxBroadcast")).click();
        else
        	result += fail();
        if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkImmedBroadcast")).isSelected())
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTrResetOutDelivery_uxChkImmedBroadcast")).click();
        else
        	result += fail();
        
        WebDriverLogin.waitT(wd, 1000);
        if(wd.findElement(By.id("uxChkResetODAll")).isSelected()) 
        {
            wd.findElement(By.id("uxChkResetODAll")).click();
            WebDriverLogin.waitT(wd, 250);
            wd.findElement(By.id("uxChkResetODAll")).click();
        }
        
        WebDriverLogin.waitT(wd, 1000);
        return result;
    }
}
