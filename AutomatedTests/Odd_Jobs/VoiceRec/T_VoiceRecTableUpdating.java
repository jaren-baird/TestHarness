package VoiceRec;

import java.util.Iterator;

import login.WebDriverLogin;
//import login.IDTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class T_VoiceRecTableUpdating 
{ 
	private static int result = 9;
	private static int Exception = -109;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String text = "";
	private static int debug = 0;
	private static String startBox = "900300";
	private static String endBox = "900399";
	//T_VoiceRecTableUpdating-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		
		int totalBoxes = Integer.parseInt(endBox)-Integer.parseInt(startBox);
		String[] voiceRecList = new String[totalBoxes+1];
		int[] disabledList = new int[totalBoxes+1]; //1 enabled 0 disabled
		for(int i = 0; i < voiceRecList.length; i++)
		{
			voiceRecList[i] = "John"+i+"!@#$%^&*(){}[]";
			disabledList[i] = 1;
		}
		
		try
		{
			if(debug != 1)
			{
				wd = WebDriverLogin.getWebAdmin();
				
				int i = 0;
	
				for (String name : voiceRecList) 
				{
					result += setName(wd, name, Integer.toString(Integer.parseInt(startBox)+i));
					i++;
				}
				
				WebDriverLogin.enableBoxRange(wd, startBox, endBox);
				WebDriverLogin.searchBoxRange(wd, startBox, endBox, 2500);
				
				wd.quit();
				wd = null;
			}
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
		
		//
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			int increm = 0;
			WebDriverLogin.enableBoxRange(wd, startBox, Integer.toString(Integer.parseInt(startBox)+increm));
			String value = "";
			for(int i = Integer.parseInt(startBox); i < Integer.parseInt(endBox); i+=100)
			{
				WebDriverLogin.searchBoxRange(wd, Integer.toString(i), Integer.toString(i+99), 2000);
				for(int j = 1; j < 200; j+=2)
				{
					if(j < 10)
						value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl0"+j+"_uxLb_Box_State")).getText();
					else
						value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl"+j+"_uxLb_Box_State")).getText();
					if(value.contains("Disabled"))
						disabledList[(i+((j-1)/2))-Integer.parseInt(startBox)] = 0; //(boxNum-Integer.parseInt(startBox))
				}
			}
			
			  
			int boxNum = 0;//Integer.parseInt(startBox);
			int toggle = 0;
			
			//String xmlPage = returnCustomReport(wd, "SELECT * FROM VoiceRecNames ORDER BY name");
			result += checkPage(wd, voiceRecList, disabledList);
			
			if(debug != 1)
			{
				increm = 10;
				for(int i = 0; i < increm; i++)
				{
					if(disabledList[i] == 1)
					{
						disableSingleBox(wd, Integer.toString(Integer.parseInt(startBox)+i));
						disabledList[i] = 0;
						result += checkPage(wd, voiceRecList, disabledList);
					}
				}
			
				for(int i = 10; i < 20; i+=increm)
				{
					if(disabledList[i] == 1 || disabledList[i] == 0)
					{
						boxNum = Integer.parseInt(startBox)+i;
						toggle = ToggleMultiSequence(wd, Integer.toString(boxNum), Integer.toString(boxNum+increm-1));
						for(int k = i; k < i+10; k++)
								disabledList[k] = toggle;
						result += checkPage(wd, voiceRecList, disabledList);
					}
				}
			}
			
			String firstBoxID = "";
			increm = 25;
			for(int i = 25; i < 75; i+=increm)
			{
				WebDriverLogin.searchBoxRange(wd, Integer.toString(Integer.parseInt(startBox)+i), endBox, 1500);
				firstBoxID = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbID")).getText();
				toggle = ToggleMultiSequenceID(wd, firstBoxID, Integer.toString(Integer.parseInt(firstBoxID)+increm-1));
				for(int k = i; k < i+increm; k++)
					disabledList[k] = toggle;
				result += checkPage(wd, voiceRecList, disabledList);
			}
			
			for(int i = 75; i < 80; i++)
			{
				//WebDriverLogin.searchBoxRange(wd, Integer.toString(Integer.parseInt(startBox)+i), endBox, 1500);
				WebDriverLogin.resetBoxAll(wd, Integer.toString(Integer.parseInt(startBox)+i), Integer.toString(Integer.parseInt(startBox)+i));
				for(int k = i; k < i+1; k++)
					disabledList[k] = 0;
				result += checkPage(wd, voiceRecList, disabledList);
			}
			
			increm = 10;
			for(int i = 80; i < 100; i+=increm)
			{
				//WebDriverLogin.searchBoxRange(wd, Integer.toString(Integer.parseInt(startBox)+i), endBox, 1500);
				WebDriverLogin.resetBoxAll(wd, Integer.toString(Integer.parseInt(startBox)+i), Integer.toString(Integer.parseInt(startBox)+i+increm-1));
				for(int k = i; k < i+increm; k++)
					disabledList[k] = 0;
				result += checkPage(wd, voiceRecList, disabledList);
			}
			
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
	
	public static int checkPage(ChromeDriver wd, String[] voiceRecList, int[] disabledList)
	{
		int result = 0;
		int i = 0;
		String xmlPage = returnCustomReport(wd, "SELECT * FROM VoiceRecNames ORDER BY name");
		for(String name : voiceRecList)
		{
			if(!xmlPage.contains(name) && disabledList[i] == 1)
			{
				System.out.println("Box name expected but not found: " + name + " ::Current result: " + result);
				result += -1;
			}
			else if(xmlPage.contains(name) && disabledList[i] == 0)
			{
				System.out.println("Box name found but not expected: " + name + " ::Current result: " + result);
				result += -1;
			}
			
			i++;
		}
		return result;
	}
	
	public static int ToggleMultiSequenceID(ChromeDriver wd, String nonSeqFirstBoxID, String nonSeqLastBoxID)
	{
		int toggle = 0;
		WebDriverLogin.waitT(wd, 1000);
		if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLb_Box_State")).getText().contains("Enabled"))
		{
			if(wd.findElement(By.id("uxChkboxsrtpr")).isSelected())
				wd.findElement(By.id("uxChkboxsrtpr")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLB_Box_State")).click();
			WebDriverLogin.waitT(wd, 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtBoxStatusRangeStart")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtBoxStatusRangeStart")).sendKeys(nonSeqFirstBoxID);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtBoxStatusRangeEnd")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtBoxStatusRangeEnd")).sendKeys(nonSeqLastBoxID);
			
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRbState_Disabled")).isSelected())
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRbState_Disabled")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxState_Multi_Submit")).click();
			WebDriverLogin.waitT(wd, 4000);
			toggle = 0;
		}
		else if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLb_Box_State")).getText().contains("Disabled"))
		{
			if(wd.findElement(By.id("uxChkboxsrtpr")).isSelected())
				wd.findElement(By.id("uxChkboxsrtpr")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLB_Box_State")).click();
			WebDriverLogin.waitT(wd, 2000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtBoxStatusRangeStart")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtBoxStatusRangeStart")).sendKeys(nonSeqFirstBoxID);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtBoxStatusRangeEnd")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtBoxStatusRangeEnd")).sendKeys(nonSeqLastBoxID);
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRbState_Enabled")).isSelected())
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRbState_Enabled")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxState_Multi_Submit")).click();
			WebDriverLogin.waitT(wd, 4000);
			toggle = 1;
		}
		
		return toggle;
	}
	
	public static int ToggleMultiSequence(ChromeDriver wd, String box, String endBox)
	{
		int toggle = 0;
		WebDriverLogin.searchBoxRange(wd, box, endBox, 1500);
		if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLb_Box_State")).getText().contains("Enabled"))
		{
			if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected())
				wd.findElement(By.id("uxChkboxsrtpr")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLB_Box_State")).click();
			WebDriverLogin.waitT(wd, 2000);
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRbState_Disabled")).isSelected())
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRbState_Disabled")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxState_Multi_Submit")).click();
			WebDriverLogin.waitT(wd, 2000);
			toggle = 0;
		}
		else if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLb_Box_State")).getText().contains("Disabled"))
		{
			if(!wd.findElement(By.id("uxChkboxsrtpr")).isSelected())
				wd.findElement(By.id("uxChkboxsrtpr")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLB_Box_State")).click();
			WebDriverLogin.waitT(wd, 2000);
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRbState_Enabled")).isSelected())
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRbState_Enabled")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxState_Multi_Submit")).click();
			WebDriverLogin.waitT(wd, 2000);
			toggle = 1;
		}
		
		return toggle;
	}
	
	public static void disableSingleBox(ChromeDriver wd, String box)
	{
		WebDriverLogin.searchBoxRange(wd, box, box, 1000);
		if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLb_Box_State")).getText().contains("Disabled"))
		{
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).isSelected())
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLb_Box_State")).click();
			WebDriverLogin.waitT(wd, 2000);
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRbState_Disabled")).isSelected())
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRbState_Disabled")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxState_Submit")).click();
			WebDriverLogin.waitT(wd, 2000);
		}
	}
	
	public static String returnCustomReport(ChromeDriver wd, String sqlQuery)
	{
		Actions builder = new Actions(wd);
        builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'System Parameters')]"))).perform();
        wd.findElement(By.id("ctl00_uxCphNavigation_uxLbReporting")).click();
        
        WebElement mySelectElm = wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingScripts")); 
        Select mySelect= new Select(mySelectElm);
        WebDriverLogin.waitT(wd, 1500);
        mySelect.selectByVisibleText("CustomReport.txt");
        wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingSelect")).click();
        WebDriverLogin.waitT(wd, 2000);
        wd.findElement(By.id("txtCustomSQL")).clear();
        wd.findElement(By.id("txtCustomSQL")).sendKeys(sqlQuery);
        wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingRun")).click();
        WebDriverLogin.waitT(wd, 2500);
        wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxLbReportingClose")).click();
        WebDriverLogin.waitT(wd, 2500);
        String url = wd.findElement(By.id("ctl00_uxCphContent_ucReporting_uxHpReportingDownload")).getAttribute("href");
        wd.get(url);
        WebDriverLogin.waitT(wd, 2500);
        String xmlPage = wd.findElementByTagName("html").getText();
        wd = WebDriverLogin.getWebAdminLogin(wd);
        return xmlPage;
	}
	
	public static int setName(ChromeDriver wd, String name, String box)
	{
		int result = 0;
		
		try
		{
 			
			if(!text.contains(name))
			{
				WebDriverLogin.searchBoxRange(wd, box, Integer.toString(Integer.parseInt(box)+99), 1500); //this will be able to skip completed name changes
				text = wd.findElementByTagName("html").getText();
				if(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbFName")).getText().contains(name))
					return result;
				wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		        WebDriverLogin.waitT(wd, 2500);
		        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).getText().contains(name))
		        {
		        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).clear();
		        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).sendKeys(name);
		        	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
		        	WebDriverLogin.waitT(wd, 4000);
		        }
		        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Close")).click();
		        WebDriverLogin.waitT(wd, 3500);
			}
	        /*wd.findElementByLinkText("Voice Rec.").click();
	        WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmVoiceRec_ucVmVoiceRec_uxBtnVoiceRec_Close")).click();
	        WebDriverLogin.waitT(wd, 2500);*/
		}
        catch(Exception ex)
		{
        	if(result < -1000)
        		return result;
			result += -10;
			ex.printStackTrace();
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLBtnStdSearch")).click();
			WebDriverLogin.waitT(wd, 2500);
			result += setName(wd, name, box);
		}
		
		return result;
	}
}

