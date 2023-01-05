import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.lang.Runtime;
import java.lang.Process;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.openqa.selenium.chrome.ChromeDriver;

import login.WebDriverLogin;

public class TestHarnessAuto 
{
	private static ChromeDriver wd = null;
	public static long loopTime = 1*60*60*1000; //Repeat time in milliseconds (8*60*60*1000) 8 hours
	private static String TEST_DIRNAME = "\\\\CWENGFS\\Tests\\TestJars\\TestJarsDev\\";  			//"\\\\CWENGFS\\Tests\\TestJars\\";
	private static String LOGLOC = "C:\\Logs\\";  	//"\\\\CWENGFS\\Tests\\Logs\\";
	private static String JARNAME = "-";
	private static String FileType = ".jar";
	private static String processArgs = "java.exe -jar "; //program used with initial arg //trailing space required
	public static int debug = 0; //1 to enable 0 to disable
	public static int tcresult = 0; //debug must not be 1 and tcresult must be 0 to run TCResult
	public static int fileLength = 0;
	private static final String TASKLIST = "tasklist";
	private static final String KILL = "taskkill /F /IM ";
	private static final String processName = "chrome.exe";
	private static final String driverName = "chromedriver.exe";
	private static int retry = 0;
	private static String webAdminReset = "Reset_Messages_CallOptions.jar";
	private static String TCResult = "TCResult\\TCResults.exe";
	private static int[] runsFails = null;
	
	public static void main(String[] args) 
    {
		//WebDriverLogin.waitT(wd, (3*60*60*1000)); //stall for 3 hours before running today 6/20/19
		Timer timer = new Timer();
		try 
		{
			timer.schedule(new TimerTask() 
			{
			    public void run() 
			    {
			    	File setup = new File(TEST_DIRNAME);
			    	File[] Dictionary = setup.listFiles(new FilenameFilter()
					{
					    public boolean accept(File dir, String name) 
					    {
					        return name.contains(JARNAME) && name.endsWith(FileType);
					    }
					});
			    	if(Dictionary != null)
			    		fileLength = Dictionary.length;
			    	else
			    		System.exit(-99);
			    	
			    	//initialize/check times run/fail array
			    	if(runsFails == null || runsFails.length != fileLength)
			    	{
			    		runsFails = new int[fileLength];
			    		runsFails[0] = 1;
			    	}
			    	else
			    	{
			    		runsFails[0] = runsFails[0] + 1; //total runs incremented
			    	}
			    	
					Scanner keyboard2 = null;
					int j = 0;
					int result = 0;
					int groupNum = 0;
					int[] TestGroup = new int[fileLength];
					TestGroup[fileLength-1] = 0;
					TestGroup[0] = j;

					//setup Groups and their numbers
					for(int i = 0; i < fileLength; i++)
					{
						if(i < fileLength-1)
						{
							if(true)//CheckTest(Dictionary[i].toString()))
							{
								if(compare(Dictionary[i].toString(), Dictionary[i+1].toString()))
								{
									
									TestGroup[i] = j;
									TestGroup[i+1] = j;
					
								}
								else
								{
									j++;
									TestGroup[i+1] = j;
								}
							}
							else
							{
								TestGroup[i] = -1;
								TestGroup[i+1] = -1;
							}
						}
						
						System.out.println(TestGroup[i] + ": " + Dictionary[i].toString());	
					}
					while(true)
					{
						groupNum++;
						if(TestGroup[fileLength-groupNum] != -1)
						{
							groupNum = TestGroup[fileLength-groupNum];
							break;
						}
					}
					
					int Length2D = ((groupNum+1)*(groupNum+1)) - 2;
					int CurrentD = 0;
					Scanner keyboard = null;
					int dimension = 1;
					String timeLog = new SimpleDateFormat("MM-dd-yyyy_HH;mm;ss").format(Calendar.getInstance().getTime());
					Logger logger = null;
					FileHandler fh = null;
			    	
					try
					{
						logger = Logger.getLogger("MyLog");
						fh = new FileHandler(LOGLOC+timeLog+".log");
						logger.addHandler(fh);
				        SimpleFormatter formatter = new SimpleFormatter();  
				        fh.setFormatter(formatter);  
				        logger.setUseParentHandlers(false);
						
						while (true)
						{
							if(dimension == 0)
								break;
							
							if(dimension == 1)
							{
								oneDimension(logger, TestGroup, result, Dictionary);
							}
							
							if(dimension == 2)//if(dimension == 2)
							{
								twoDimension(logger, TestGroup, result, Dictionary, CurrentD, Length2D, groupNum);
							}
							dimension = 0;
						}
					}
					catch (Exception ex)
					{
						System.err.println(ex);
						ex.printStackTrace();
						logger.info(ex.toString());
						logger.info(ex.getMessage());
			        }
					finally
					{
						if(keyboard != null)
							keyboard.close();
						if(setup != null)
							setup.delete();
						if(keyboard2 != null)
							keyboard2.close();
						
						if(logger != null)
							logger.removeHandler(fh);
						if(fh != null)
							fh.close();
					} 
			    }
			}, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2016-2-25 20:00:00"), loopTime); //Repeat time in milliseconds (8*60*60*1000) 8 hours
		} 
		catch (ParseException e) 
		{
			System.err.println(e);
			e.printStackTrace();
		} 
    }
	
	
	
	public static void groupTest(String plaHldr, String stage, int group, Logger logger, int current, int length) throws Exception
	{
		int result = -1;
		if(plaHldr.replaceAll("[0-9]", "").substring(plaHldr.length()-(FileType.length()+2), plaHldr.length()-(FileType.length()+1)).equals(stage))
		{
			result = RunJar(plaHldr);
			Print(plaHldr, group, current, length, result, logger);
		}
	}
	
	public static void Print(String plaHldr, int group, int current, int Length, int result, Logger logger) throws Exception
	{
		Scanner keyboard = null;
		int connection = 0;
		String retries = "";
		String failsCounter = "";
		if(retry > 0)
		{
			retries = " Retries: "+retry;
		}
		
		if(debug == 1)
		{
			System.out.print("DEBUG:: ");
			logger.info("::DEBUG::");
		}
		if(result == 0 || result == 3)
		{
			if(result == 3)
			{
				System.out.print("SKIPPED:: ");
				logger.info("::SKIPPED::");
			}
			if(runsFails[current] > 0)
			{
				failsCounter = " :Fails/Runs:" +runsFails[current]+ "/" +runsFails[0];
			}
			System.out.print("Success: ");
			logger.info("Success: " + (current)+"/"+Length + " Group: " + group + " Current: " + 
			plaHldr.replace(TEST_DIRNAME, "") + failsCounter + retries + "\n"); 
		}
		else
		{
			if(result == -999 || result == -998)
			{
				keyboard = null;
				try
				{
					keyboard = new Scanner(System.in);
					if(result == -999)
					{
						logger.info(result+" Connection Error: " + (current)+"/"+Length + " Group: " + group + " Current: " + plaHldr.replace(TEST_DIRNAME, "") + "\n");
						//System.out.println("Connection Error: Choose 1 to continue or 0 to quit.");
						connection = 1;//keyboard.nextInt(); //connection = 1;
						Thread.sleep(120000);
						if(connection == 0)
							throw new Exception("Connection Error");
						else if(connection == 1)
							logger.info("continuing from connection error");
					}
					else if(result == -998)
					{
						logger.info(result+" Aborted: " + (current)+"/"+Length + " Group: " + group + " Current: " + plaHldr.replace(TEST_DIRNAME, "") + "\n");
						System.out.println("Aborted current test: Choose 1 to continue or 0 to quit.");
						connection = 1; //connection = keyboard.nextInt(); //connection = 1;
						//Thread.sleep(120000);
						if(connection == 0)
							throw new Exception("Aborted");
						else if(connection == 1)
							logger.info("continuing from Abort");
					}
				}
				finally
				{
					if(keyboard != null)
						keyboard.close();
				}
			}
			else
			{
				//runsFails update, index 0 tracks total runs
				runsFails[current] = runsFails[current] + 1;
				System.out.print(result+" Failure: ");  
				logger.info(result+" Failure: " + (current)+"/"+Length + " Group: " + group + " Current: " + 
				plaHldr.replace(TEST_DIRNAME, "")+retries+ " :Fails/Runs:" +runsFails[current]+ "/" +runsFails[0]+ "\n"); 
			}
		}
		System.out.println((current)+"/"+Length + " Group: " + group + " Current: " + 
		plaHldr.replace(TEST_DIRNAME, "") + " :Fails/Runs:" +runsFails[current]+ "/" +runsFails[0]);
		if(result != 3) //3 is skipped
			TCResult(plaHldr, result, runsFails[current], runsFails[0]);
	}
	
	public static boolean compare(String string, String string2)
	{
		//string = (String)string.substring(0, string.length()-(FileType.length()+3)).replaceAll("[0-9]", "");
		//string2 = (String)string2.substring(0, string2.length()-(FileType.length()+3)).replaceAll("[0-9]", "");
		string = (String)string.replaceAll("[0-9]", "");
		string = (String)string.substring(0, string.length()-(FileType.length()+2));
		string2 = (String)string2.replaceAll("[0-9]", "");
		string2 = (String)string2.substring(0, string2.length()-(FileType.length()+2));
		return (string.contains(string2));
	}
	
	public static int RunJar(String FilePath)
	{
		Process process = null;
		int result = 0;
		retry = -1;
		boolean waitResult = true;
		boolean currentWorkingHours = getTimeOfDay(); //if true then we are running during work hours
		
		try
		{
			if(debug != 1)
			{
				do
				{
					Thread.sleep(500);
					if(isProcessRunning(processName))
					{
						killProcess(processName);
						Thread.sleep(2250);
					}
					if(isProcessRunning(driverName))
					{
						killProcess(driverName);
						Thread.sleep(2250);
					}
					if(isProcessRunning("java.exe"))
					{
						killProcess("java.exe");
						Thread.sleep(2250);
					}
					Thread.sleep(1250);
					if(currentWorkingHours != true && FilePath.toLowerCase().contains("voicereccyara") || !FilePath.toLowerCase().contains("voicereccyara"))
					{
						Runtime rt = Runtime.getRuntime();
						process = rt.exec(processArgs +"\""+ FilePath +"\"");
						
						try
						{
							//if(process != null)
			                     //process.destroy();
							waitResult = process.waitFor(20, TimeUnit.MINUTES);
							result = process.exitValue();
						}
						catch(Exception ex)
						{
							result = -9001;
				            System.err.println(ex);
				            ex.printStackTrace();
						}
					}
					else
						result = 3; //skipping this test at this time of day
					retry++;
				}while(result == 100 && retry < 2 || result == 1 && retry < 4);
			}
		}
		catch (Exception ex)
		{
			System.err.println(ex);
            ex.printStackTrace();
            result = -9002;
		}
		
		return result;
	}
	
	
	
	public static boolean CheckTest(String testName)
	{
		String RX = "-" + testName.replaceAll("[0-9]", "").charAt(testName.length()-(FileType.length()+2)) + "0";
		return (CheckExists(RX, "-r0", testName) && CheckExists(RX, "-s0", testName) && CheckExists(RX, "-t0", testName) );
	}
	
	public static boolean CheckExists(String param1, String param2, String testName)
	{
		if(!param1.equals(param2))
		{
			File file = new File(testName.replace(param1, param2));
			if(file.exists())
				return true;
			else
				System.out.println("\nMissing: " + testName.replace(param1, param2));
		}
		else
			return true;

		return false;
	}
	
	
	public static void setDebug(int debug)
	{
		TestHarnessAuto.debug = debug;
	}
	
	public static boolean isProcessRunning(String serviceName) throws Exception 
	{
		 Process p = Runtime.getRuntime().exec(TASKLIST);
		 BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		 String line;
		 while ((line = reader.readLine()) != null) 
		 {
			if(line.contains(serviceName)) 
			{
				return true;
			}
		 }
		 return false;
	}
	
	public static void killProcess(String serviceName) throws Exception 
	{
		Runtime.getRuntime().exec(KILL + serviceName);
	}
	
	public static void TCResult(String test, int result, int totalFails, int totalRuns)
	{
		Process process = null;
		String path = TEST_DIRNAME+TCResult;
		String resultString = "";
		test = test.replace(TEST_DIRNAME, "");
		test = test.replace(".jar", "");
		
		if(result == 0)
			resultString = "pass";
		else if(totalFails*2 > totalRuns)
			resultString = "fail";
		
		try
		{
			if(debug != 1 && tcresult == 0)//(false)//
			{
				process = Runtime.getRuntime().exec(path +" "+ test +" "+ resultString);
				Thread.sleep(2000);
			}
		}
		catch (Exception ex)
		{
			System.err.println(ex);
            ex.printStackTrace();
		}
	}
	
	public static void oneDimension(Logger logger, int[] TestGroup, int result, File[] Dictionary)
	{
		long startTime = 0;
		int estimatedTime = 0;
		
		logger.info("1 Dimension \n");
		for(int i = 0; i < (fileLength); i++)
		{
			if(TestGroup[i] != -1)
			{
				try
				{
					//startTime = System.nanoTime();
					result = RunJar(Dictionary[i].toString());
					if(result == 1)
						Thread.sleep(1000);
					if(result < -900000)
						System.out.println(""+result);
					Print(Dictionary[i].toString(), TestGroup[i], i+1, fileLength, result, logger);
					//estimatedTime = ((int)(System.nanoTime() - startTime/(10^9)));
					//System.out.println("Time(s): "+estimatedTime);
				}
				catch (Exception ex){}
			}
			//verify system state T18493_DList_LeaveMessage-t0
			/*if(TestGroup[i] != -1)
			{
				try
				{
					//startTime = System.nanoTime();
					result = RunJar("\\\\CWENGFS\\Tests\\TestJars\\TestJarsDev\\T18493_DList_LeaveMessage-t0.jar");
					if(result == 1)
						Thread.sleep(1000);
					if(result < 0)
						System.out.println("Verifing test has failed "+result);
					//Print(Dictionary[i].toString(), TestGroup[i], i+1, fileLength, result, logger);
					//estimatedTime = ((int)(System.nanoTime() - startTime/(10^9)));
					//System.out.println("Time(s): "+estimatedTime);
				}
				catch (Exception ex){}
			}*/
		}
	}
	
	public static void twoDimension(Logger logger, int[] TestGroup, int result, File[] Dictionary, int CurrentD, int Length2D, int groupNum)
	{
		logger.info("2 Dimension \n");
		CurrentD = 0;
		String stage = "";
		String plaHldr = "";
		int j = 0;
		
		for(int i = 0; i < groupNum +1; i++)//1st group
		{
			for(int k = 0; k < groupNum +1; k++)//2nd group
			{
				if(i != k && i != -1 && k != -1)
				{
					for(int s = 0; s < 3; s++)
					{
						if(s == 0)
							stage = "r";
						if(s == 1)
							stage = "s";
						if(s == 2)
							stage = "t";
						
						try
						{
							for(int n = 0; n < fileLength; n++)
							{
								if(TestGroup[n] == i)
								{
									plaHldr = Dictionary[n].toString();
									groupTest(plaHldr, stage, TestGroup[n], logger, CurrentD, Length2D);
								}
								if(TestGroup[n] == k)
								{
									plaHldr = Dictionary[n].toString();
									groupTest(plaHldr, stage, TestGroup[n], logger, CurrentD, Length2D);
								}
							}
						}
						catch (Exception ex){}
					}
				}
				CurrentD++;
			}
		}
	}
	
	public static boolean getTimeOfDay()
	{
		try
		{
			Calendar calendar = Calendar.getInstance();
		    calendar.getTime();
		    int hours = calendar.HOUR_OF_DAY;
		    // 8 am to 6 pm conisdered working hours
		    if(hours < 8 || hours > 18)
		    	return true; //skip certain tests if run during work hours
		    else
		    	return false;
		}
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    	return true;
	    }
	}
}	

