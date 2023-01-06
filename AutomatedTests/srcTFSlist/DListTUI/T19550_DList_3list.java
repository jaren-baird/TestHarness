
package DListTUI;

import login.WebDriverLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
//Test Case 19550:DLists - Send a message to all 3 lists created from client.

public class T19550_DList_3list 
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//T19550_DList_3list-t0
	
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
	    result = 0;
	    
    	try
    	{
    		//reset Local DLists
    	    WebDriverLogin.resetDListAll(wd, "900005", "900005");
        	WebDriverLogin.enableBoxRange(wd, "900005", "900006");
        	WebDriverLogin.resetMessages(wd, "900005", "900006");
        	WebDriverLogin.searchBoxRange(wd, "900005", "900005", 2000);
    	    //create dlists
	    	String DListName = "DListMessage";
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbNumber")).click();
		    WebDriverLogin.waitT(wd, 1500);
	        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_tab")).click();
		    WebDriverLogin.waitT(wd, 1500);
		    int j = 0;
		    for(int i = 0; i < 3; i++)
		    {
			    if(!wd.findElement(By.tagName("html")).getText().contains(DListName+j))
		        {
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbAddDList")).click();
		            WebDriverLogin.waitT(wd, 2000);
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEditDlistName")).sendKeys(DListName+j);
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxDdlDlistNumber")).sendKeys(j+"");
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxRbAddInternal")).click();
		            WebDriverLogin.waitT(wd, 2000);
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtStartRange")).sendKeys("900006");
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxTxtEndRange")).sendKeys("900006");
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbSchInternal")).click();
		            WebDriverLogin.waitT(wd, 2000);
		            
					wd.findElement(By.id("uxChkDlistInternalSrch")).click();
					wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistSearchInternalAdd")).click();
					WebDriverLogin.waitT(wd, 2500);
		            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLBtnEditDlistApply")).click();
		            WebDriverLogin.waitT(wd, 2500);
		            
			        if(!wd.findElement(By.tagName("html")).getText().contains(DListName+j))
			        	result += -2002;          
			    }
			    if(j==0)
			    	j=1;
			    j+=4;
		    }
		    wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerVoiceMailProps_uxTpVmDistLists_ucVmDistributionLists_uxLbDlistCloseBtn")).click();
		    WebDriverLogin.waitT(wd, 2000);
		}
		catch(Exception ex){result += -109;}
		wd.quit();

		//
		//
        String[] folderList = {"DList", "TestSuite", "DListSetup", "DList2", "T19550_DList_3list"};
		wd = WebDriverLogin.getCyara(args);
		result += WebDriverLogin.cyaraFolderSearch(wd, folderList);
        WebDriverLogin.waitT(wd, 1500);
        if(!wd.findElement(By.tagName("html")).getText().contains("Save & Run")) {
            System.out.println("");
        }
		//
        wd.findElement(By.id("executeButton")).click();
        WebDriverLogin.waitT(wd, 195000);
        String[] para = {"0","true"};
        result = WebDriverLogin.RunErrorTable(wd, para);
        wd.quit();
  	   	//
        wd = WebDriverLogin.getWebAdmin();
        result += checkStatus(wd, "900006");
  	   	wd.quit();  
	}
	
	public static int checkStatus(ChromeDriver wd, String boxNum)
	{
		int result = 0;
		//
		try
		{
			WebDriverLogin.searchBoxRange(wd, boxNum, boxNum);
	  	   	String status = "ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLbStatus";
	  	   	wd.findElement(By.id(status)).click();
	  	   	WebDriverLogin.waitT(wd, 1500);
	  	   	String value = wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLblVoiceMsg_New_Value")).getText();//getAttribute("value");
	  	   	if(value ==null)
	  	   	{
	  	   		result = -9999;
	  	   	}
		  	if(value.contains("0") || !value.contains("3"))
		  	{
	    		result += -10;
	    		System.out.println("box "+boxNum+" failed");
	    	}
		  	wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLbBoxStatusClose")).click();
		  	WebDriverLogin.waitT(wd, 1500);
		}
		catch(Exception ex)
		{result += -109;}
		//
		return result;
	}
}
