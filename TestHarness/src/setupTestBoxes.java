
import login.WebDriverLogin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class setupTestBoxes 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	
	public static void main(String[] args) throws Exception
	{
		result = 0; //0
		boolean reset = true; //true;

		try
    	{
			System.out.println("createOwnerTSS exited with: " + createOwnerTSS());
			
			wd = WebDriverLogin.getWebAdmin();
			if(result == 0)
			{
				//V=Voicemail A=Audiotext F=Fax Only T=Teacher Box U=UCD
				String type = "true";//"true";
				if(type.contains("true"))
				{
					if(!checkForBoxes(wd, "1000", "1009", "10"))
					{
						for(int i = 1000; i < 1010; i++)
						{
							if(i == 1000 || i == 1004)
								type = "A";
							else
								type = "V";
							initiateCreation(wd, Integer.toString(i), type);
						}
					}
					if(!checkForBoxes(wd, "865069", "865069", "1"))
					{
						for(int i = 865069; i <= 865069; i++)
						{
							initiateCreation(wd, Integer.toString(i), "V");
						}
					}
					if(!checkForBoxes(wd, "865070", "865080", "11"))
					{
						for(int i = 865070; i <= 865080; i++)
						{
							initiateCreation(wd, Integer.toString(i), "A");
						}
					}
					if(!checkForBoxes(wd, "890990", "890999", "10"))
					{
						for(int i = 890990; i <= 890999; i++)
						{
							initiateCreation(wd, Integer.toString(i), "A");
						}
					}
					initiateCreation(wd, "865000", "V");
					initiateCreation(wd, "899992", "A");
					initiateCreation(wd, "899997", "V");
					initiateCreation(wd, "899998", "V");
					initiateCreation(wd, "899999", "V");
					initiateCreation(wd, "899990", "T");
					initiateCreation(wd, "900000", "V");
					initiateCreation(wd, "900001", "A");
					initiateCreation(wd, "900002", "U");
					initiateCreation(wd, "900003", "F");
					initiateCreation(wd, "900004", "T");
					
					if(checkForBoxes(wd, "900005", "900250", "No"))
					{
						initiateCreation(wd, "900005", "V246");
					}
					else if(!checkForBoxes(wd, "900005", "900250", "246")) // if 0 just generate all later
					{
						int j = 900000;
						while(checkForBoxes(wd, Integer.toString(j), Integer.toString(j+10), "11"))
						{
							j+=10;
						}
						for(int i = j; i <= 900250; i++)
						{
							initiateCreation(wd, Integer.toString(i), "V");
						}
					}
					if(checkForBoxes(wd, "900300", "900399", "No"))
					{
						initiateCreation(wd, "900300", "V100");
					}
					else if(!checkForBoxes(wd, "900300", "900399", "100"))
					{
						int j = 900300;
						while(checkForBoxes(wd, Integer.toString(j), Integer.toString(j+10), "11"))
						{
							j+=10;
						}
						for(int i = j; i <= 900399; i++)
						{
							initiateCreation(wd, Integer.toString(i), "V");
						}
					}
				}
			}
			//initiateCreation(wd, "1008", "V");
			//initiateCreation(wd, "1009", "V");
			/*
			865070-865080 AT
			890990-890999 AT
			899990 Teacher
			899997&8 Retention tests VM
			899999&900000 VM
			900000 VM -01 AT -02 UCD -03 Fax -04 Teacher
			900005-900255 VM
			 */
			//
			//Cyara Testing\DList\TestSuite\TUI\GrtTab\GrtSetupTab VMbox 900001 initial setup
			if(reset)
			{
				reset899999(wd);
				WebDriverLogin.waitT(wd, 2000);
				WebDriverLogin.resetBoxAll(wd, "1007", "1008");
				WebDriverLogin.resetBoxAll(wd, "865000", "865000");
				WebDriverLogin.resetBoxAll(wd, "865070", "865070");
				WebDriverLogin.resetBoxAll(wd, "899997", "899997");
				WebDriverLogin.resetBoxAll(wd, "899998", "899998");
				WebDriverLogin.resetBoxAll(wd, "900000", "900000");
				WebDriverLogin.resetBoxAll(wd, "900001", "900001");
				WebDriverLogin.resetBoxAll(wd, "900003", "900003");
				WebDriverLogin.resetBoxAll(wd, "900005", "900005");
			}
			
    		wd.quit();
    		wd = null;
    	}
    	catch(Exception ex)
    	{
    		result += exceptionResult();
    		ex.printStackTrace();
    	}
    	finally
    	{
    		if(wd != null)
    			wd.quit();
    	}
		//
		int check = 0;
		if(reset)//
		{
			try
			{
				setupBox899999(); //webadmin settings
				String[] unused = {};
				String[] file = {"Voice Rec","Login","setupBoxes","VMbox 899999 setup"};
				check = runCyara(wd, file, unused, 160000);
				if(check != 0)
				{
					result += check;
					System.out.println("Test failed: "+file[file.length-1]);
					pauseDebug();
				}
			}catch(Exception none){}
			try
			{
				String[] unused = {};
				String[] file = {"Voice Rec","Login","setupBoxes","VMbox initial setup 865000"};
				check = runCyara(wd, file, unused, 160000);
				if(check != 0)
				{
					result += check;
					System.out.println("Test failed: "+file[file.length-1]);
					pauseDebug();
				}
			}catch(Exception none){}
			try
			{
				String[] unused = {};
				String[] file = {"Voice Rec","Login","setupBoxes","VMbox initial setup 865070"};
				check = runCyara(wd, file, unused, 160000);
				if(check != 0)
				{
					result += check;
					System.out.println("Test failed: "+file[file.length-1]);
					pauseDebug();
				}
			}catch(Exception none){}
			try
			{
				String[] unused = {};
				String[] file = {"Voice Rec","Login","setupBoxes","VMbox initial setup 899997"};
				check = runCyara(wd, file, unused, 160000);
				if(check != 0)
				{
					result += check;
					System.out.println("Test failed: "+file[file.length-1]);
					pauseDebug();
				}
			}catch(Exception none){}
			try
			{
				String[] unused = {};
				String[] file = {"Voice Rec","Login","setupBoxes","VMbox initial setup 899998"};
				check = runCyara(wd, file, unused, 160000);
				if(check != 0)
				{
					result += check;
					System.out.println("Test failed: "+file[file.length-1]);
					pauseDebug();
				}
			}catch(Exception none){}
			try
			{
				String[] unused = {};
				String[] file = {"Voice Rec","Login","setupBoxes","VMbox initial setup 900000"};
				check = runCyara(wd, file, unused, 160000);
				if(check != 0)
				{
					result += check;
					System.out.println("Test failed: "+file[file.length-1]);
					pauseDebug();
				}
			}catch(Exception none){}
			try
			{
				String[] unused = {};
				String[] file = {"Voice Rec","Login","setupBoxes","VMbox initial setup 900001"};
				check = runCyara(wd, file, unused, 160000);
				if(check != 0)
				{
					result += check;
					System.out.println("Test failed: "+file[file.length-1]);
					pauseDebug();
				}
			}catch(Exception none){}
			try
			{
				String[] unused = {};
				String[] file = {"Voice Rec","Login","setupBoxes","VMbox initial setup 900003"};
				check = runCyara(wd, file, unused, 160000);
				if(check != 0)
				{
					result += check;
					System.out.println("Test failed: "+file[file.length-1]);
					pauseDebug();
				}
			}catch(Exception none){}
			try
			{
				setupBox900005(); //webadmin settings
				String[] unused = {};
				String[] file = {"Voice Rec","Login","setupBoxes","VMbox initial setup 900005"};
				check = runCyara(wd, file, unused, 160000);
				if(check != 0)
				{
					result += check;
					System.out.println("Test failed: "+file[file.length-1]);
					pauseDebug();
				}
			}catch(Exception none){}
			try
			{
				String[] unused = {};
				String[] file = {"Voice Rec","Login","VMbox initial setup 1007"};
				check = runCyara(wd, file, unused, 160000);
				if(check != 0)
				{
					result += check;
					System.out.println("Test failed: "+file[file.length-1]);
					pauseDebug();
				}
			}catch(Exception none){}
			try
			{
				String[] unused = {};
				String[] file = {"Voice Rec","Login","VMbox initial setup 1008"};
				check = runCyara(wd, file, unused, 160000);
				if(check != 0)
				{
					result += check;
					System.out.println("Test failed: "+file[file.length-1]);
					pauseDebug();
				}
			}catch(Exception none){}
		}
		
		
		/*
		try
		{
			
			wd = WebDriverLogin.getWebAdmin();
			createNewBox(wd, "900005", "W");
			createNewBox(wd, "899999", "W");
			wd.quit();
			setupBox900005();
			setupBox899999();
		}
		catch(Exception ex){}*/
		
		System.exit(result);
	}
	
	public static void createNewBox(ChromeDriver wd, String box, String boxType)
	{
		String numberToCreate = "1";
		
		try
		{
			if(boxType.length() > 1)
			{
				numberToCreate = boxType.substring(1);	
				boxType = boxType.substring(0, 1);
			}
			WebDriverLogin.waitT(wd, 3500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_New")).click();
			WebDriverLogin.waitT(wd, 3500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtNumberOfBoxesToCreate")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtNumberOfBoxesToCreate")).sendKeys(numberToCreate);
			WebDriverLogin.waitT(wd, 1000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartAtNumber")).clear();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTxtStartAtNumber")).sendKeys(box);
			//wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxDdlOwnerTss")).sendKeys("W");
			//wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxDdlOwnerTss")).sendKeys(Keys.ENTER);
			WebDriverLogin.waitT(wd, 1000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxDdlDefPropertyType")).click();
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxDdlDefPropertyType")).sendKeys(boxType);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxDdlDefPropertyType")).sendKeys(Keys.ENTER);
			WebDriverLogin.waitT(wd, 1500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbNewBoxes_Submit")).click();
			WebDriverLogin.waitT(wd, 3500);
			if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblNewBoxStatus")).getText().contains("New Boxes Created."))
				WebDriverLogin.waitT(wd, 12000);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbNewBoxes_Cancel")).click();
			WebDriverLogin.waitT(wd, 3500);
		}
		catch(Exception ex)
		{
			result += exceptionResult();
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
			WebDriverLogin.searchBoxRange(wd, box, box2, 2500);
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
	
	public static int runCyara(ChromeDriver wd, String[] file, String[] args, int wait)
	{
		int result = 0;
		try
		{
			String[] folderList = file;
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, wait);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
	  	   	wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += exceptionResult();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		
		return result;
	}
	
	public static void setupBox900005() throws InterruptedException
	{
		String box = "900005";
		
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetBoxAll(wd, box, box);
			WebDriverLogin.searchBoxRange(wd, box, box, 1500);
	    	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
	    	WebDriverLogin.waitT(wd, 2500);
	        wd.findElement(By.linkText("Basic")).click();
	        WebDriverLogin.waitT(wd, 2500);
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).sendKeys("Randy");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).sendKeys("Orton");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Address1")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Address1")).sendKeys("RKO");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Address2")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Address2")).sendKeys("Out of Nowhere");
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLifetime")).sendKeys("0");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLifetime")).sendKeys("0");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLength")).sendKeys("0");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLength")).sendKeys("0");
	        
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLifetime")).sendKeys("20");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLifetime")).sendKeys("99999999999999999");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MinPassLength")).sendKeys("2");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLength")).sendKeys("6");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_AutoDisable")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_AutoDisable")).sendKeys("45");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_OwnerTss")).sendKeys("R");
	        //
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Account")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_Account")).sendKeys("555");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LongDistSuffix")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LongDistSuffix")).sendKeys("91801");
	        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxChkUser_ExtNumControl")).isSelected()) {
	            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxChkUser_ExtNumControl")).click();
	        }
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_ExtNumEditLen")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_ExtNumEditLen")).sendKeys("10");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
	        //
	        WebDriverLogin.waitT(wd, 4000);
	        String value = wd.findElement(By.tagName("html")).getText();
	        if(!value.contains("Updated"))
	        	result += -10;
	        WebDriverLogin.waitT(wd, 1500);
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += exceptionResult();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		/*
		try
		{
			String[] args = {};
	        String[] folderList = {"Voice Rec", "Login", "setupBoxes", "VMbox initial setup 900005"};
			wd = WebDriverLogin.getCyara(args);
			result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
	        WebDriverLogin.waitT(wd, 1500);
	        if (!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
	            System.out.println("");
	        }
	        wd.findElement(By.id("executeButton")).click();
	        WebDriverLogin.waitT(wd, 1900000);
	        String[] para = {"0","true"};
	        result += WebDriverLogin.RunErrorTable(wd, para);
	  	   	wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += exceptionResult();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}*/
	}
	
	public static int setupBox899999() throws InterruptedException
	{
		String box = "899999";
		int result = 0;
		try
		{
			wd = WebDriverLogin.getWebAdmin();
			WebDriverLogin.resetBoxAll(wd, box, box);
	    	WebDriverLogin.searchBoxRange(wd, box, box, 2500);
		    //max digits passcode number
	    	WebDriverLogin.waitT(wd, 2500);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    WebDriverLogin.waitT(wd, 2500);
		    Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLength")));
			select.selectByVisibleText("10");
			WebDriverLogin.waitT(wd, 2000);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_FirstName")).sendKeys("The Tester");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).clear();
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxTxtUser_LastName")).sendKeys("Robot");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_OwnerTss")).sendKeys("W");
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_OwnerTss")).sendKeys(Keys.ENTER);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
	        WebDriverLogin.waitT(wd, 4000);
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += exceptionResult();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		/*
		try
		{
			String[] args = {};
		    String[] file = {"DList","TestSuite","initSetup","initial_setup_899999"};
		    runCyara(wd, file, args, 200000);
		    wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += exceptionResult();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}*/
	    
	    return result;
	}
	
	public static void reset899999(ChromeDriver wd)
	{
		try 
		{
			WebDriverLogin.resetBoxAll(wd, "899999", "899999");
			WebDriverLogin.searchBoxRange(wd, "899999", "899999", 2500);
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    WebDriverLogin.waitT(wd, 2000);
		    Select select = new Select(wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxDdlUser_MaxPassLength")));
			select.selectByVisibleText("10");
			WebDriverLogin.waitT(wd, 2500);
			wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmUser_ctl01_uxBtnUser_Submit")).click();
			WebDriverLogin.waitT(wd, 4500);
			wd.findElement(By.id("ctl00_uxCphNavigation_uxLbBoxes")).click();
			WebDriverLogin.waitT(wd, 2500);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int exceptionResult()
	{
		return -109;
	}
	
	public static void pauseDebug()
	{
		System.out.println("Error");
	}
	//Create OwnerTSS
	public static int createOwnerTSS()
	{
		int result = 0;
		wd = WebDriverLogin.getWebAdmin();
		
		try
		{
			//Report Test
	        //First TS
	        //WEBADMINTEST
			Actions builder = new Actions(wd);
			wd.findElement(By.xpath("//a[contains(text(),'Ts Servers')]")).click();
	        WebDriverLogin.waitT(wd, 1000);
	        String value = wd.findElement(By.tagName("html")).getText();
	        builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'Ts Servers')]"))).perform();
	        if(!value.contains("Report Test"))
	        {
	        	wd.findElement(By.id("ctl00_uxCphNavigation_NewTSServer")).click();
	        	WebDriverLogin.waitT(wd, 1500);
	        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtMachineName")).clear();
		        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtMachineName")).sendKeys("Report Test");
		        if(!wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkPhoneControl")).isSelected())
		        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkPhoneControl")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxBtnTsServerSubmit")).click();
		        WebDriverLogin.waitT(wd, 3500);
	        	builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'Ts Servers')]"))).perform();
	        }
	        if(!value.contains("First TS"))
	        {
	        	wd.findElement(By.id("ctl00_uxCphNavigation_NewTSServer")).click();
	        	WebDriverLogin.waitT(wd, 1500);
	        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtMachineName")).clear();
		        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtMachineName")).sendKeys("First TS");
		        if(!wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkPhoneControl")).isSelected())
		        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkPhoneControl")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxBtnTsServerSubmit")).click();
		        WebDriverLogin.waitT(wd, 3500);
	        	builder.moveToElement(wd.findElement(By.xpath("//a[contains(text(),'Ts Servers')]"))).perform();
	        }
	        if(!value.contains("WEBADMINTEST"))
	        {
	        	wd.findElement(By.id("ctl00_uxCphNavigation_NewTSServer")).click();
	        	WebDriverLogin.waitT(wd, 1500);
	        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtMachineName")).clear();
		        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxTxtMachineName")).sendKeys("WEBADMINTEST");
		        if(!wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkPhoneControl")).isSelected())
		        	wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxChkPhoneControl")).click();
		        wd.findElement(By.id("ctl00_uxCphContent_ucTsServer_uxBtnTsServerSubmit")).click();
		        WebDriverLogin.waitT(wd, 3500);
	        }
	        wd.quit();
	  	   	wd = null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			result += exceptionResult();
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
		
		return result;
	}
}

/*
865070-865080 AT
890990-890999 AT
899990 Teacher
899997&8 Retention tests VM
899999&900000 VM
900000 VM -01 AT -02 UCD -03 Fax -04 Teacher
900005-900255 VM










*/