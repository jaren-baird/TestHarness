
import login.WebDriverLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Reset_CRT_Tests
{
	private static int result = 9;
	private static int Exception = -2;
	public static boolean JITCflag = true;
	private static ChromeDriver wd = null;
	private static String FilePath = WebDriverLogin.getFilePath();
	//Reset_CRT_Tests
	
	public static void main(String[] args) throws Exception
	{
		wd = WebDriverLogin.getWebAdmin();
		
        //
		WebDriverLogin.searchBoxRange(wd, "1008", "1008");
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).isSelected()) {
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxChkItemBox")).click();
        }
        if(!wd.findElement(By.tagName("html")).getText().contains("Reset")) {
            System.out.println("");
        }
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
        if(!wd.findElement(By.tagName("html")).getText().contains("Reset Boxes")) {
            System.out.println("");
        }
        wd.findElement(By.linkText("Messages")).click();
        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetVoiceMessages")).isSelected()) {
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxTabContainerResetOptions_uxTpResetMessages_uxResetMessages_uxChkResetVoiceMessages")).click();
        }
        if(!wd.findElement(By.tagName("html")).getText().contains("Submit")) {
            System.out.println("");
        }
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
        if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) {
            System.out.println("");
        }
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();
/*        if(!wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl15_uxChkItemBox")).isSelected()) {
            wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxRepeater_ctl15_uxChkItemBox")).click();
        }
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLb_Box_Reset")).click();
        if(!wd.findElement(By.tagName("html")).getText().contains("Call Options")) {
            System.out.println("");
        }
        wd.findElement(By.linkText("Call Options")).click();
        if(!wd.findElement(By.id("uxChkResetCallOptAll")).isSelected()) {
            wd.findElement(By.id("uxChkResetCallOptAll")).click();
        }*/
        /*if(!wd.findElement(By.tagName("html")).getText().contains("Submit")) {
            System.out.println("");
        }
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetSubmit")).click();
        if(!wd.findElement(By.tagName("html")).getText().contains("Reset Successful.")) {
            System.out.println("Reset Successful");
        }
        wd.findElement(By.id("ctl00_uxCphContent_ucBoxes_uxLnkResetClose")).click();*/
		//
		
		wd.quit();
	}
}
