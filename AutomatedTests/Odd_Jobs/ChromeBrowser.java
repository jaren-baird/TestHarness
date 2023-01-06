import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeBrowser 
{
	public static void ChromeDriver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\libraries\\chromedriver\\chromedriver.exe");
		WebDriver driver =  new ChromeDriver();
		
		
	}

}
