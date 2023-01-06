
package WebAdminCallOptionsTUI;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class T13986_VM_SpeedDialValid
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T13986_VM_SpeedDialValid-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		String box = "900005";
		String checkData = "";
		String id = "";
		String errorId = "";
		String errorNotice = "";
		String[] invalidDigits = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
				"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","!","$","%","^","&","(",")"};
        String[] invalidNumerics = {"10","99","100","9999"};
        
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			//wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebDriverLogin.resetCallOptions(wd, box, box);
			WebDriverLogin.enableBoxRange(wd, "1008", "1008");
			WebDriverLogin.searchBoxRange(wd, box, box, 1000);
			//Test Case 13986:WebAdmin - CallOptions > Add Programmable Speed Dial
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.linkText("Call Options")).click();
			WebDriverLogin.waitT(wd, 2000);
			
			id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Key";
	        errorId = "CO_RegularExpressionValidator1";
	        errorNotice = "Numeric values only";
	        result += checkField(wd, id, errorId, errorNotice, invalidDigits, false);
			//
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Key";
	        errorId = "CO_RegularExpressionValidator1";
	        errorNotice = "Numeric values only";
	        result += checkField(wd, id, errorId, errorNotice, invalidNumerics, true);
	        //
	        id = "ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Number";
	        errorId = "CO_RegularExpressionValidator2";
	        errorNotice = "Numeric values only";
	        result += checkField(wd, id, errorId, errorNotice, invalidDigits, false);
			//
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkSpeed_SpeedDial")).isSelected())
	        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxChkSpeed_SpeedDial")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Key")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Key")).sendKeys("4");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Key")).sendKeys(Keys.ENTER);
			
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Number")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Number")).sendKeys("1008");
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxTxtProgSpeedDial_Number")).sendKeys(Keys.ENTER);
	        
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxBtnAddProgSpeedDial")).click();
			WebDriverLogin.waitT(wd, 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmCallOptions_Vm_ucVmCallOptions_VM_uxBtnCOSubmit")).click();
			WebDriverLogin.waitT(wd, 3000);
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
		try
		{
			String[] folderList = {"DList", "TestSuite", "Other", "SpeedDial", "T13985_VM_SpeedDialValid"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 110000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
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
	
	public static int checkField(ChromeDriver wd, String id, String errorId, String errorNotice, String[] invalidDigits, boolean valid)
	{
		int result = 0;
		String checkData = "";
		try
		{
			for(int i = 0; i < invalidDigits.length; i++)
			{
				wd.findElement(By.id(id)).clear();
				wd.findElement(By.id(id)).sendKeys(invalidDigits[i]);
				wd.findElement(By.id(id)).sendKeys(Keys.ENTER);
				WebDriverLogin.waitT(wd, 25);
				checkData = wd.findElement(By.id(errorId)).getText();
				if(checkData.contains(errorNotice) && valid==true || valid==false && !checkData.contains(errorNotice))
					result += -10;
			}
		}
		catch(Exception ex)
		{result += -10;}
		
		return result;
	}
}