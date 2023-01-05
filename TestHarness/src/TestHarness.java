import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.lang.Runtime;
import java.lang.Process;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TestHarness 
{
	private static String TEST_DIRNAME = "\\\\CWENGFS\\Tests\\TestJars\\";
	private static String LOGLOC = "\\\\CWENGFS\\Tests\\Logs\\";
	private static String JARNAME = "-";
	private static String FileType = ".jar";
	public static int debug = 0;
	public static int FileLength = 0;
	private static final String TASKLIST = "tasklist";
	private static final String KILL = "taskkill /F /IM ";
	private static final String processName = "firefox.exe";
	private static int retry = 0;
	
	@SuppressWarnings("null")
	public static void main(String[] args) 
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
    		FileLength = Dictionary.length;
    	else
    		System.exit(-99);
    	
		Scanner keyboard2 = null;
		int j = 0;
		int result = 0;
		int groupNum = 0;
		int[] TestGroup = new int[FileLength];
		TestGroup[FileLength-1] = 0;
		TestGroup[0] = j;

		//setup Groups and their numbers
		for(int i = 0; i < FileLength; i++)
		{
			if(i < FileLength-1)
			{
				if(CheckTest(Dictionary[i].toString()))
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
			if(TestGroup[FileLength-groupNum] != -1)
			{
				groupNum = TestGroup[FileLength-groupNum];
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
					logger.info("1 Dimension \n");
					for(int i = 0; i < (FileLength); i++)
					{
						if(TestGroup[i] != -1)
						{
							result = RunJar(Dictionary[i].toString());
							Print(Dictionary[i].toString(), TestGroup[i], i+1, FileLength, result, logger);
						}
					}
				}
				
				if(dimension == 2)//if(dimension == 2)
				{
					logger.info("2 Dimension \n");
					CurrentD = 0;
					String stage = "";
					String plaHldr = "";
					j = 0;
					
					for(int i = 0; i < groupNum +1; i++)//1st group
					{
						for(int k = 0; k < groupNum +1; k++)//2nd group
						{
							if(i != k && i != -1 && k != -1)
							{
								for(int s = 0; s < 3; s++)
								{
									if (s == 0)
										stage = "r";
									if (s == 1)
										stage = "s";
									if (s == 2)
										stage = "t";
									
									
									for(int n = 0; n < FileLength; n++)
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
							}
							CurrentD++;
						}
					}
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
		if(retry > 0)
		{
			retries = " Retries: "+retry;
		}
		
		if(debug == 1)
		{
			System.out.print("DEBUG:: ");
			logger.info("::DEBUG::");
		}
		if(result == 0)
		{
			System.out.print("Success: ");
			logger.info("Success: " + (current)+"/"+Length + " Group: " + group + " Current: " + plaHldr.replace(TEST_DIRNAME, "")+retries+ "\n"); 
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
						System.out.println("Connection Error: Choose 1 to continue or 0 to quit.");
						connection = keyboard.nextInt();
						if(connection == 0)
							throw new Exception("Connection Error");
						else if(connection == 1)
							logger.info("continuing from connection error");
					}
					else if(result == -998)
					{
						logger.info(result+" Aborted: " + (current)+"/"+Length + " Group: " + group + " Current: " + plaHldr.replace(TEST_DIRNAME, "") + "\n");
						System.out.println("Aborted current test: Choose 1 to continue or 0 to quit.");
						connection = keyboard.nextInt();
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
				System.out.print(result+" Failure: ");  
				logger.info(result+" Failure: " + (current)+"/"+Length + " Group: " + group + " Current: " + plaHldr.replace(TEST_DIRNAME, "")+retries+ "\n"); 
			}
		}
		System.out.println((current)+"/"+Length + " Group: " + group + " Current: " + plaHldr.replace(TEST_DIRNAME, ""));
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
		
		try
		{
			if(debug != 1)
			{
				do
				{
					process = Runtime.getRuntime().exec("java -jar " + FilePath);	
					process.waitFor();
					result = process.exitValue();
					if(isProcessRunning(processName))
					{
						killProcess(processName);
						Thread.sleep(500);
					}
					retry++;
					if(result == -1001)
					{
						process = Runtime.getRuntime().exec("java -jar \\\\CWENGFS\\Tests\\TestJars\\Reset_Messages_CallOptions.jar");	
						process.waitFor();
						result = 100;
					}
				}while(result == 100 && retry < 4);
			}
		}
		catch (Exception ex)
		{
			System.err.println(ex);
            ex.printStackTrace();
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
			if (line.contains(serviceName)) 
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
}	
