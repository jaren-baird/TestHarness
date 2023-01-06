package Removed;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import login.SeanWebDriver;
import login.WebDriverLogin;


public class T13507_Add_A_DList_CallWeb 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//Test Case 13507:WEB - NewMessage - Add Distribution List
	//T13507_Add_A_DList_CallWeb-t0
	
	public static void main(String[] args) throws Exception
	{
		result = 0;
		try
		{
			//reset DLists for 1007
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetDListAll(wd, "865000", "865000");
			wd.quit();
			
			//CallegraWeb
			String box = "865000";
			String boxPass = "4321";
			//Login voicemail
			wd = SeanWebDriver.getCallWeb(box, boxPass);
			
		    wd.findElement(By.id("ctl00_uxCphNavigation_notes_header")).click();
		    WebDriverLogin.waitT(wd, 1000);
		    wd.findElement(By.id("ctl00_uxCphNavigation_notes_content_uxLbDistributionLists")).click();
		    WebDriverLogin.waitT(wd, 1000);
		    wd.findElement(By.id("ctl00_uxCphMainContent_ucDistributionLists_uxImgBtnCreateDList")).click();
		    WebDriverLogin.waitT(wd, 1000);
		    wd.findElement(By.id("ctl00_uxCphMainContent_ucDistributionLists_ucAddressLookUp_uxTxtDListName")).clear();
		    wd.findElement(By.id("ctl00_uxCphMainContent_ucDistributionLists_ucAddressLookUp_uxTxtDListName")).sendKeys("jeongTestDList");
		    
		    wd.findElement(By.id("ctl00_uxCphMainContent_ucDistributionLists_ucAddressLookUp_uxTxtBoxNumberLocal")).clear();
		    wd.findElement(By.id("ctl00_uxCphMainContent_ucDistributionLists_ucAddressLookUp_uxTxtBoxNumberLocal")).sendKeys("865000");
		    
		
		    wd.findElement(By.id("ctl00_uxCphMainContent_ucDistributionLists_ucAddressLookUp_uxBtnAddToRecipentListLocal")).click();
		    WebDriverLogin.waitT(wd, 1000);
		    wd.findElement(By.id("ctl00_uxCphMainContent_ucDistributionLists_ucAddressLookUp_uxBtnSaveDList")).click();
		    WebDriverLogin.waitT(wd, 1000);
		    
		    String value = wd.findElementByTagName("html").getText();
		    if(!value.contains("jeongTestDList"))
		    	result += -10;
		  
		    wd.findElement(By.id("ctl00_uxCphMainContent_ucDistributionLists_uxLocalRepeater_ctl00_uxLbEditLocalList")).click();
		    WebDriverLogin.waitT(wd, 1000);
		    value = wd.findElementByTagName("html").getText();
		    if(!value.contains("Jeong Test"))
		    	result += -10;
		    
			wd.findElement(By.id("ctl00_uxPlaceHolderSubHeader_uxLbLogOut")).click();
			WebDriverLogin.waitT(wd, 1000);
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

}








/*
			wd = SeanWebDriver.getCallWeb(box, boxPass);
			WebDriverLogin.waitT(wd, 500);
			wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			String value = wd.findElementByTagName("html").getText();
			if(!value.contains("Box Number: 1007"))
				result += -10;
			
			wd.findElement(By.id("ctl00_uxCphNavigation_notes_header")).click();
			WebDriverLogin.waitT(wd, 500);
			wd.findElement(By.id("ctl00_uxCphNavigation_notes_content_uxLbDistributionLists")).click();
			WebDriverLogin.waitT(wd, 1000);
			wd.findElement(By.id("ctl00_uxCphMainContent_ucDistributionLists_uxImgBtnCreateDList")).click();
			WebDriverLogin.waitT(wd, 500);				
			//create DList
			wd.findElement(By.id("ctl00_uxCphMainContent_ucDistributionLists_ucAddressLookUp_uxTxtDListName")).clear();
			wd.findElement(By.id("ctl00_uxCphMainContent_ucDistributionLists_ucAddressLookUp_uxTxtDListName")).sendKeys("CallegraWebTest");
			wd.findElement(By.id("ctl00_uxCphMainContent_ucDistributionLists_ucAddressLookUp_uxTxtBoxNumberLocal")).clear();
			wd.findElement(By.id("ctl00_uxCphMainContent_ucDistributionLists_ucAddressLookUp_uxTxtBoxNumberLocal")).sendKeys("1008");
			
			wd.findElement(By.id("ctl00_uxCphMainContent_ucDistributionLists_ucAddressLookUp_uxBtnAddToRecipentListLocal")).click();
			WebDriverLogin.waitT(wd, 500);
			wd.findElement(By.id("ctl00_uxCphMainContent_ucDistributionLists_ucAddressLookUp_uxBtnSaveDList")).click();
			WebDriverLogin.waitT(wd, 500);
			//confirm DList name
			value = wd.findElementByTagName("html").getText();
			if(!value.contains("CallegraWebTest"))
				result += -10;
			//open DList we just created
			wd.findElement(By.id("ctl00_uxCphMainContent_ucDistributionLists_uxLocalRepeater_ctl00_uxLbEditLocalList")).click();
			WebDriverLogin.waitT(wd, 500);
			value = wd.findElementByTagName("html").getText();
			if(!value.contains("The Rock"))
				result += -10;
			
 */

