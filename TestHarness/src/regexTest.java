import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class regexTest 
{
	public static void main(String[] args) throws Exception
	{
		int result = -1;
		Pattern r = null;
    	Matcher m = null;
		String regexPattern = regexReplace(defaultString);
		String weebpage = defaultWebpage;
		String webpage = "<DocumentElement><Row><UserID>55</UserID><Login>jaren</Login><Session>cb3295da-5dee-c79e-d990-fd7880210557</Session>	<Date>2017-02-08T11:26:59.570</Date><Level>Low</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>SuccessfulPKIself-registration</Description></Row>"
				+ "<Row><UserID>55</UserID><Login>jaren</Login><Session>cb3295da-5dee-c79e-d990-fd7880210557</Session><Date>2017-02-08T11:27:50.140</Date><Level>Low</Level><Type>Create</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Created1newVoicemailboxesstartingatnumber13371337forclientWEBADMINTEST</Description></Row>"
				+ "<Row><UserID>55</UserID><Login>jaren</Login><Session>cb3295da-5dee-c79e-d990-fd7880210557</Session><Date>2017-02-08T11:28:45.170</Date><Level>Medium</Level><Type>Delete</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Deletedboxes:143to143</Description></Row>"
				+ "<Row><UserID>55</UserID><Login>jaren</Login><Session>cb3295da-5dee-c79e-d990-fd7880210557</Session><Date>2017-02-08T11:29:13.127</Date><Level>Low</Level><Type>Create</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Created2newVoicemailboxesstartingatnumber13371337forclientWEBADMINTEST</Description></Row>"
				+ "<Row><UserID>55</UserID><Login>jaren</Login><Session>cb3295da-5dee-c79e-d990-fd7880210557</Session><Date>2017-02-08T11:30:20.190</Date><Level>Low</Level><Type>Edit</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Updatedbox:143</Description></Row>"
				+ "<Row><UserID>55</UserID><Login>jaren</Login><Session>cb3295da-5dee-c79e-d990-fd7880210557</Session><Date>2017-02-08T11:31:05.153</Date><Level>Medium</Level><Type>Copy</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Copiedbox143FilterUser=2097020Messages=4177727Faxes=1279Groups=7Notifications=7CallOptions=16777215Connectivity=590269Greetings=16383VoiceRec=1Outbound=15toboxes:144</Description></Row>"
				+ "<Row><UserID>55</UserID><Login>jaren</Login><Session>cb3295da-5dee-c79e-d990-fd7880210557</Session><Date>2017-02-08T11:32:03.583</Date><Level>Medium</Level><Type>Reset</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>ResetboxesFilterUser=2080639Groups=-1:143to143</Description></Row>"
				+ "<Row><UserID>55</UserID><Login>jaren</Login><Session>cb3295da-5dee-c79e-d990-fd7880210557</Session><Date>2017-02-08T11:32:54.373</Date><Level>Medium</Level><Type>Delete</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Deletedboxes:143to144</Description></Row>"
				+ "<Row><UserID>55</UserID><Login>jaren</Login><Session>cb3295da-5dee-c79e-d990-fd7880210557</Session><Date>2017-02-08T11:33:18.667</Date><Level>High</Level><Type>Edit</Type><Category>Security</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>EditedSecuritySettings:MailboxMaxPasscodeRetention=3</Description></Row>"
				+ "<Row><UserID>55</UserID><Login>jaren</Login><Session>cb3295da-5dee-c79e-d990-fd7880210557</Session><Date>2017-02-08T11:33:22.850</Date><Level>High</Level><Type>Edit</Type><Category>Security</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>EditedSecuritySettings:MailboxMaxPasscodeRetention=4</Description></Row>"
				+ "<Row><UserID>55</UserID><Login>jaren</Login><Session>cb3295da-5dee-c79e-d990-fd7880210557</Session><Date>2017-02-08T11:33:30.780</Date><Level>High</Level><Type>Edit</Type><Category>SystemLog</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>EditedSystemLogParameters:UserActivityLevel=7UserActivityType=127UserActivityCategory=1023UserActivityResult=3</Description></Row>"
				+ "<Row><UserID>55</UserID><Login>jaren</Login><Session>cb3295da-5dee-c79e-d990-fd7880210557</Session><Date>2017-02-08T11:33:35.100</Date><Level>Medium</Level><Type>Edit</Type><Category>Maintenance</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>EditedMaintenanceSettings:</Description></Row>"
				+ "<Row><UserID>55</UserID><Login>jaren</Login><Session>cb3295da-5dee-c79e-d990-fd7880210557</Session><Date>2017-02-08T11:33:39.410</Date><Level>Medium</Level><Type>Edit</Type><Category>Clients</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Updatedclient'ReportTest'ID:9</Description></Row>"
				+ "<Row><UserID>55</UserID><Login>jaren</Login><Session>cb3295da-5dee-c79e-d990-fd7880210557</Session><Date>2017-02-08T11:33:44.490</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID1ViewBoxes=1EditBoxes=1CreateBoxes=1DeleteBoxes=1CopyBoxes=1RenumberBoxes=1ResetBoxes=1TelephonyServerControl=1</Description></Row>"
				+ "<Row><UserID>55</UserID><Login>jaren</Login><Session>cb3295da-5dee-c79e-d990-fd7880210557</Session><Date>2017-02-08T11:33:44.500</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID2ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0</Description></Row>"
				+ "<Row><UserID>55</UserID><Login>jaren</Login><Session>cb3295da-5dee-c79e-d990-fd7880210557</Session><Date>2017-02-08T11:33:44.507</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID7ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0</Description></Row>"
				+ "<Row><UserID>55</UserID><Login>jaren</Login><Session>cb3295da-5dee-c79e-d990-fd7880210557</Session><Date>2017-02-08T11:33:44.517</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID9ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0</Description></Row>"
				+ "<Row><UserID>55</UserID><Login>jaren</Login><Session>cb3295da-5dee-c79e-d990-fd7880210557</Session><Date>2017-02-08T11:33:44.523</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Updateduser:jarenID:55.BackupDB=1ViewClients=1EditClients=1CreateClients=1DeleteClients=1ViewSysParams=1EditSysParams=1ViewUsers=1EditUsers=1CreateUsers=1DeleteUsers=1ViewReports=1ViewSecuritySettings=1EditSecuritySettings=1</Description></Row>";
				//"</DocumentElement>";
		
		//Default
		//String[] rgxCompare = {reportLogin,reportSingleCreate,reportSingleDelete,reportDualCreate,reportEdit,reportCopy,reportReset,reportDualDelete//};
    	//		,reportSecurity,reportSecurity,reportSystemLog,reportMaintenance,reportClients,reportUsers,reportUsers2,reportUsers3,reportUsers4,reportUsers5};//
		//Reverse
		String[] rgxCompare = {reportUsers5,reportUsers4,reportUsers3,reportUsers2,reportUsers,reportClients,reportMaintenance,reportSystemLog,reportSecurity,reportSecurity
				,reportDualDelete,reportReset,reportCopy,reportEdit,reportDualCreate,reportSingleDelete,reportSingleCreate,reportLogin};
		
		String webpageArray[] = {webpageUsers5,webpageUsers4,webpageUsers3,webpageUsers2,webpageUsers,webpageClients,webpageMaintenance,webpageSystemLog,webpageSecurity,webpageSecurity
				,webpageDualDelete,webpageReset,webpageCopy,webpageEdit,webpageDualCreate,webpageSingleDelete,webpageSingleCreate,webpageLogin};
		
		for(int i = 0; i < rgxCompare.length; i ++)
		{
			if(!verifyReport(rgxCompare[i],webpageArray[i]))
			{
				System.out.println(rgxCompare[i] +" \ndid not verify\n "+ webpageArray[i]);
				result = -1-i;
			}
			else
				result = 0;
		}
		
		
		String combinedStr = buildString(rgxCompare);
		webpage = buildString(webpageArray);
    	
    	webpage = regexReplace(webpage);
    	combinedStr = regexReplace(combinedStr);
    	weebpage = regexReplace(weebpage);
    	
    	r = Pattern.compile(combinedStr);
    	m = r.matcher(webpage);
    	
    	System.out.println(webpage);
		System.out.println(combinedStr);
    	
    	if(m.matches())
        {
			result = 0;
        }
		else
        {
			System.out.println(farthestPoint(r ,webpage));
			//System.out.println(combinedStr.substring(farthestPoint(r , compareMe)));
			result = -71;
        }
		
		
		System.exit(result);
		/*
		
		 */
		/*
		System.out.println(replace);
		System.out.println("(rgx)<Row>(rgx)<UserID>55</UserID>(rgx)<Login>jaren</Login>(rgx)<Session>(rgx)</Session>(rgx)<Date>(rgx)</Date>(rgx)<Level>High</Level>(rgx)<Type>Edit</Type>(rgx)<Category>System Log</Category>(rgx)"
				+ "<Result>Success</Result>(rgx)<ErrorCode>1</ErrorCode>(rgx)<ErrorCode>1</ErrorCode>(rgx)<Description>Edited System Log Parameters: User Activity Level=7 User Activity Type=127 User Activity Category=1023 User Activity Result=3</Description>(rgx)</Row>(rgx)"); //compareMe.replaceAll("[A-Za-z_0-9<>\\-\\:\\.\\s/]*", "")
		*/
		/*
		String testString = "<Row><UserID>55</UserID><Login>jaren</Login><Session>1a299b05-faf2-37c8-9235-976246352bc7</Session><Date>2017-01-19T09:44:28.767</Date><Level>Low</Level><Type>Create</Type><Category>Boxes</Category><Result>Success</Result><Description>Created 1 new Voicemail boxes starting at number 13371337 for client WEBADMINTEST</Description></Row>";
		String testString2 = " <DocumentElement> <Row> <UserID>55</UserID> <Login>jaren</Login> <Session>1a299b05-faf2-37c8-9235-976246352bc7</Session> <Date>2017-01-19T09:44:28.767</Date> <Level>Low</Level> <Type>Create</Type> <Category>Boxes</Category> <Result>Success</Result> <Description>Created 1 new Voicemail boxes starting at number 13371337 for client WEBADMINTEST</Description> </Row> ";
				//"<Row><UserID>55</UserID><Login>jaren</Login><Session>1a299b05-faf2-37c8-9235-976246352bc7</Session><Date>2017-01-19T09:43:39.567</Date><Level>Low</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><Description>Successful PKI self-registration</Description></Row>";
				//"(rgx)<Row>(rgx)<UserID>55</UserID>(rgx)<Login>jaren</Login>(rgx)<Session>(rgx)</Session>(rgx)<Date>(rgx)</Date>(rgx)<Level>Low</Level>(rgx)<Type>Edit</Type>(rgx)<Category>Users</Category>(rgx)<Result>Success</Result>(rgx)<Description>Successful PKI self-registration</Description>(rgx)</Row>(rgx)<Row>(rgx)<UserID>55</UserID>(rgx)<Login>jaren</Login>(rgx)<Session>(rgx)</Session>(rgx)<Date>(rgx)</Date>(rgx)<Level>Low</Level>(rgx)<Type>Create</Type>(rgx)<Category>Boxes</Category>(rgx)<Result>Success</Result>(rgx)<Description>Created 1 new Voicemail boxes starting at number 13371337 for client WEBADMINTEST</Description>(rgx)</Row>(rgx)";
				//<DocumentElement>
    	String rgxCompare = "(rgx)<Row>(rgx)"
    			+ "<UserID>55</UserID>(rgx)<Login>jaren</Login>(rgx)<Session>(rgx)</Session>(rgx)<Date>(rgx)</Date>(rgx)"
    			+ "<Level>Low</Level>(rgx)<Type>Create</Type>(rgx)<Category>Boxes</Category>(rgx)<Result>Success</Result>(rgx)"
    			+ "<Description>Created 1 new Voicemail boxes starting at number 13371337 for client WEBADMINTEST</Description>(rgx)"
    			+ "</Row>(rgx)";
    	
    	String working = "This is a regex T<e>:.st";
    	String workingSample = ("<Row>(rgx)</Row>").replace("(rgx)","[A-Za-z_0-9<>\\-\\:\\.\\s/]*");
    	rgxCompare = rgxCompare.replace("(rgx)","[A-Za-z_0-9<>\\-\\:\\.\\s/]*");//"[A-Za-z_0-9<>\\-\\:\\.\\s/]*");//"[\\s\\S]*"
    	Pattern r = Pattern.compile(rgxCompare);//rgxCompare);
    	Matcher m = r.matcher(testString2);//testString);
    	System.out.println(testString2);
    	System.out.println(rgxCompare);
    	*/
	}
	
	public static int farthestPoint(Pattern pattern, String input) {
	    for (int i = input.length() - 1; i > 0; i--) {
	        Matcher matcher = pattern.matcher(input.substring(0, i));
	        if(!matcher.matches() && matcher.hitEnd()) {
	            return i;
	        }
	    }
	    return 0;
	}
	
		/*
		
		 */
	
	
	
	public static String regexReplace(String replaced)
    {
    	replaced = replaced.replace("(rgx)","[A-Za-z_0-9<>\\-\\:\\.\\s/=]*");
    	replaced = replaced.replaceAll("[\\r\\n\\s]", "");
    	replaced = replaced.replaceAll("[()]", "");
    	replaced = replaced.replaceAll("<DocumentElement>", "");
    	replaced = replaced.replaceAll("</DocumentElement>", "");
    	
    	return replaced;//<DocumentElement>
    }
	
	public static String buildString(String[] rgxCompare)
	{
    	String combinedStr = "";
    	
    	for(int i = 0; i < rgxCompare.length; i++)
    	{
    		combinedStr += rgxCompare[i];
    	}
		
		return combinedStr;
	}
	
	public static boolean verifyReport(String rgxReport, String webpage)
	{
		Pattern r = null;
    	Matcher m = null;
    	boolean result = false;
    	r = Pattern.compile(rgxReport);
    	m = r.matcher(webpage);

    	if(m.matches())
        {
			result = true;
        }
		else
        {
			//System.out.println(webpage);
			//System.out.println(rgxReport);
			result = false;
        }
		return result;
	}

	
	
	private static String reportLogin = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Low</Level><Type>Edit</Type><Category>Users</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>SuccessfulPKIself-registration</Description></Row>");

    private static String reportSingleCreate = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Low</Level><Type>Create</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Created1newVoicemailboxesstartingatnumber13371337forclientWEBADMINTEST</Description></Row>");

    private static String reportSingleDelete = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Delete</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Deletedboxes:(rgx)</Description></Row>");

    private static String reportDualCreate = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Low</Level><Type>Create</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Created2newVoicemailboxesstartingatnumber13371337forclientWEBADMINTEST</Description></Row>");

    private static String reportEdit = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Low</Level><Type>Edit</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Updatedbox:(rgx)</Description></Row>");

    private static String reportCopy = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Copy</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Copiedbox(rgx)</Description></Row>");

    private static String reportReset = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Reset</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Resetboxes(FilterUser=2080639Groups=-1):(rgx)</Description></Row>");

    private static String reportDualDelete = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Delete</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Deletedboxes:(rgx)</Description></Row>");
    
    private static String reportSecurity = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Security</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Edited Security Settings: Mailbox Max Passcode Retention= (rgx)</Description></Row>");
    
    private static String reportSystemLog = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>SystemLog</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>EditedSystemLogParameters:UserActivityLevel=7UserActivityType=127UserActivityCategory=1023UserActivityResult=3</Description></Row>");

    private static String reportMaintenance = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Edit</Type><Category>Maintenance</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>EditedMaintenanceSettings:</Description></Row>");

    private static String reportClients = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Edit</Type><Category>Clients</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Updatedclient'ReportTest'ID:9</Description></Row>");

    private static String reportUsers = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID1(ViewBoxes=1EditBoxes=1CreateBoxes=1DeleteBoxes=1CopyBoxes=1RenumberBoxes=1ResetBoxes=1TelephonyServerControl=1)</Description></Row>");

    private static String reportUsers2 = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID2(ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0)</Description></Row>");

    private static String reportUsers3 = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID7(ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0)</Description></Row>");

    private static String reportUsers4 = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID9(ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0)</Description></Row>");

    private static String reportUsers5 = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Updateduser:jarenID:55.BackupDB=1ViewClients=1EditClients=1CreateClients=1DeleteClients=1ViewSysParams=1EditSysParams=1ViewUsers=1EditUsers=1CreateUsers=1DeleteUsers=1ViewReports=1ViewSecuritySettings=1EditSecuritySettings=1</Description></Row>");
    
    /*
    private static String reportLogin = regexReplace("(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Low</Level><Type>Edit</Type><Category>Users</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>SuccessfulPKIself-registration</Description></Row>(rgx)");

    private static String reportSingleCreate = regexReplace("(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Low</Level><Type>Create</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Created1newVoicemailboxesstartingatnumber13371337forclientWEBADMINTEST</Description></Row>(rgx)");

    private static String reportSingleDelete = regexReplace("(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Delete</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Deletedboxes:(rgx)</Description></Row>(rgx)");

    private static String reportDualCreate = regexReplace("(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Low</Level><Type>Create</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Created2newVoicemailboxesstartingatnumber13371337forclientWEBADMINTEST</Description></Row>(rgx)");

    private static String reportEdit = regexReplace("(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Low</Level><Type>Edit</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Updatedbox:(rgx)</Description></Row>(rgx)");

    private static String reportCopy = regexReplace("(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Copy</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Copiedbox(rgx)(FilterUser=2097020Messages=4177727Faxes=1279Groups=7Notifications=7CallOptions=16777215Connectivity=590269Greetings=16383VoiceRec=1Outbound=15)(rgx)</Description></Row>(rgx)");

    private static String reportReset = regexReplace("(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Reset</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Resetboxes(FilterUser=2080639Groups=-1):(rgx)</Description></Row>(rgx)");

    private static String reportDualDelete = regexReplace("(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Delete</Type><Category>Boxes</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Deletedboxes:(rgx)</Description></Row>(rgx)");
    
    private static String reportSecurity = regexReplace("(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Security</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Edited Security Settings: Mailbox Max Passcode Retention= (rgx)</Description></Row>(rgx)");
    
    private static String reportSystemLog = regexReplace("(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>SystemLog</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>EditedSystemLogParameters:UserActivityLevel=7UserActivityType=127UserActivityCategory=1023UserActivityResult=3</Description></Row>(rgx)");

    private static String reportMaintenance = regexReplace("(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Edit</Type><Category>Maintenance</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>EditedMaintenanceSettings:</Description></Row>(rgx)");

    private static String reportClients = regexReplace("(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Edit</Type><Category>Clients</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Updatedclient'ReportTest'ID:9</Description></Row>(rgx)");

    private static String reportUsers = regexReplace("(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID1(ViewBoxes=1EditBoxes=1CreateBoxes=1DeleteBoxes=1CopyBoxes=1RenumberBoxes=1ResetBoxes=1TelephonyServerControl=1)</Description></Row>(rgx)");

    private static String reportUsers2 = regexReplace("(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID2(ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0)</Description></Row>(rgx)");

    private static String reportUsers3 = regexReplace("(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID7(ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0)</Description></Row>(rgx)");

    private static String reportUsers4 = regexReplace("(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID9(ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0)</Description></Row>(rgx)");

    private static String reportUsers5 = regexReplace("(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category>"
    		+ "<Result>Success</Result><ErrorCode>1</ErrorCode><Description>Updateduser:jarenID:55.BackupDB=1ViewClients=1EditClients=1CreateClients=1DeleteClients=1ViewSysParams=1EditSysParams=1ViewUsers=1EditUsers=1CreateUsers=1DeleteUsers=1ViewReports=1ViewSecuritySettings=1EditSecuritySettings=1</Description></Row>(rgx)");
    */
	
    private static String defaultString = "(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID9(ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0)</Description></Row>(rgx)(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>0</ErrorCode><Description>Updateduser:jarenID:55.BackupDB=1ViewClients=1EditClients=1CreateClients=1DeleteClients=1ViewSysParams=1EditSysParams=1ViewUsers=1EditUsers=1CreateUsers=1DeleteUsers=1ViewReports=1ViewSecuritySettings=1EditSecuritySettings=1</Description></Row>(rgx)";
    //(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Low</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>SuccessfulPKIself-registration</Description></Row>(rgx)(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Low</Level><Type>Create</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Created1newVoicemailboxesstartingatnumber13371337forclientWEBADMINTEST</Description></Row>(rgx)(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Delete</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Deletedboxes:(rgx)</Description></Row>(rgx)(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Low</Level><Type>Create</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Created2newVoicemailboxesstartingatnumber13371337forclientWEBADMINTEST</Description></Row>(rgx)(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Low</Level><Type>Edit</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Updatedbox:(rgx)</Description></Row>(rgx)(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Copy</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Copiedbox(rgx)(FilterUser=2097020Messages=4177727Faxes=1279Groups=7Notifications=7CallOptions=16777215Connectivity=590269Greetings=16383VoiceRec=1Outbound=15)(rgx)</Description></Row>(rgx)(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Reset</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Resetboxes(FilterUser=2080639Groups=-1):(rgx)</Description></Row>(rgx)
    //(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>SystemLog</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>EditedSystemLogParameters:UserActivityLevel=7UserActivityType=127UserActivityCategory=1023UserActivityResult=3</Description></Row>(rgx)
    //(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Edit</Type><Category>Maintenance</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>EditedMaintenanceSettings:</Description></Row>(rgx)
    //(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>Medium</Level><Type>Edit</Type><Category>Clients</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Updatedclient'ReportTest'ID:9</Description></Row>(rgx)
    //(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID1(ViewBoxes=1EditBoxes=1CreateBoxes=1DeleteBoxes=1CopyBoxes=1RenumberBoxes=1ResetBoxes=1TelephonyServerControl=1)</Description></Row>(rgx)
    //(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID2(ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0)</Description></Row>(rgx)
    //(rgx)<Row><UserID>55</UserID><Login>jaren</Login><Session>(rgx)</Session><Date>(rgx)</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID7(ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0)</Description></Row>(rgx)
    //private static String defaultString = "";
    //
    private static String defaultWebpage = "<Row><UserID>55</UserID><Login>jaren</Login><Session>64018525-0858-d2de-1d29-6cc9513f8db9</Session><Date>2017-02-03T13:37:36.703</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID9(ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0)</Description></Row><Row><UserID>55</UserID><Login>jaren</Login><Session>64018525-0858-d2de-1d29-6cc9513f8db9</Session><Date>2017-02-03T13:37:36.713</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>0</ErrorCode><Description>Updateduser:jarenID:55.BackupDB=1ViewClients=1EditClients=1CreateClients=1DeleteClients=1ViewSysParams=1EditSysParams=1ViewUsers=1EditUsers=1CreateUsers=1DeleteUsers=1ViewReports=1ViewSecuritySettings=1EditSecuritySettings=1</Description></Row></DocumentElement>";
    //<DocumentElement><Row><UserID>55</UserID><Login>jaren</Login><Session>64018525-0858-d2de-1d29-6cc9513f8db9</Session><Date>2017-02-03T13:30:54.807</Date><Level>Low</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>SuccessfulPKIself-registration</Description></Row><Row><UserID>55</UserID><Login>jaren</Login><Session>64018525-0858-d2de-1d29-6cc9513f8db9</Session><Date>2017-02-03T13:31:45.213</Date><Level>Low</Level><Type>Create</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Created1newVoicemailboxesstartingatnumber13371337forclientWEBADMINTEST</Description></Row><Row><UserID>55</UserID><Login>jaren</Login><Session>64018525-0858-d2de-1d29-6cc9513f8db9</Session><Date>2017-02-03T13:32:40.997</Date><Level>Medium</Level><Type>Delete</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Deletedboxes:142to142</Description></Row><Row><UserID>55</UserID><Login>jaren</Login><Session>64018525-0858-d2de-1d29-6cc9513f8db9</Session><Date>2017-02-03T13:33:06.130</Date><Level>Low</Level><Type>Create</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Created2newVoicemailboxesstartingatnumber13371337forclientWEBADMINTEST</Description></Row><Row><UserID>55</UserID><Login>jaren</Login><Session>64018525-0858-d2de-1d29-6cc9513f8db9</Session><Date>2017-02-03T13:34:12.960</Date><Level>Low</Level><Type>Edit</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Updatedbox:142</Description></Row><Row><UserID>55</UserID><Login>jaren</Login><Session>64018525-0858-d2de-1d29-6cc9513f8db9</Session><Date>2017-02-03T13:34:57.883</Date><Level>Medium</Level><Type>Copy</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Copiedbox142(FilterUser=2097020Messages=4177727Faxes=1279Groups=7Notifications=7CallOptions=16777215Connectivity=590269Greetings=16383VoiceRec=1Outbound=15)toboxes:143</Description></Row><Row><UserID>55</UserID><Login>jaren</Login><Session>64018525-0858-d2de-1d29-6cc9513f8db9</Session><Date>2017-02-03T13:35:56.887</Date><Level>Medium</Level><Type>Reset</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Resetboxes(FilterUser=2080639Groups=-1):142to142</Description></Row>
    //<Row><UserID>55</UserID><Login>jaren</Login><Session>64018525-0858-d2de-1d29-6cc9513f8db9</Session><Date>2017-02-03T13:36:47.713</Date><Level>Medium</Level><Type>Delete</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Deletedboxes:142to143</Description></Row>
    //<Row><UserID>55</UserID><Login>jaren</Login><Session>64018525-0858-d2de-1d29-6cc9513f8db9</Session><Date>2017-02-03T13:37:22.863</Date><Level>High</Level><Type>Edit</Type><Category>SystemLog</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>EditedSystemLogParameters:UserActivityLevel=7UserActivityType=127UserActivityCategory=1023UserActivityResult=3</Description></Row>
    //<Row><UserID>55</UserID><Login>jaren</Login><Session>64018525-0858-d2de-1d29-6cc9513f8db9</Session><Date>2017-02-03T13:37:27.087</Date><Level>Medium</Level><Type>Edit</Type><Category>Maintenance</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>EditedMaintenanceSettings:</Description></Row>
    //<Row><UserID>55</UserID><Login>jaren</Login><Session>64018525-0858-d2de-1d29-6cc9513f8db9</Session><Date>2017-02-03T13:37:31.557</Date><Level>Medium</Level><Type>Edit</Type><Category>Clients</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Updatedclient'ReportTest'ID:9</Description></Row>
    //<Row><UserID>55</UserID><Login>jaren</Login><Session>64018525-0858-d2de-1d29-6cc9513f8db9</Session><Date>2017-02-03T13:37:36.680</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID1(ViewBoxes=1EditBoxes=1CreateBoxes=1DeleteBoxes=1CopyBoxes=1RenumberBoxes=1ResetBoxes=1TelephonyServerControl=1)</Description></Row>
    //<Row><UserID>55</UserID><Login>jaren</Login><Session>64018525-0858-d2de-1d29-6cc9513f8db9</Session><Date>2017-02-03T13:37:36.687</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID2(ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0)</Description></Row>
    //<Row><UserID>55</UserID><Login>jaren</Login><Session>64018525-0858-d2de-1d29-6cc9513f8db9</Session><Date>2017-02-03T13:37:36.697</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID7(ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0)</Description></Row>
    //private static String defaultWebpage = "";
    //
    
    private static String webpageLogin = regexReplace("<DocumentElement><Row><UserID>55</UserID><Login>jaren</Login><Session>3a300663-8c42-ad09-e13f-066d5c602ca1</Session><Date>2017-02-15T14:45:20.100</Date><Level>Low</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>SuccessfulPKIself-registration</Description></Row>"
    		+ "");

    private static String webpageSingleCreate = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>3a300663-8c42-ad09-e13f-066d5c602ca1</Session><Date>2017-02-15T14:46:10.077</Date><Level>Low</Level><Type>Create</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Created1newVoicemailboxesstartingatnumber13371337forclientWEBADMINTEST</Description></Row>"
    		+ "");

    private static String webpageSingleDelete = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>3a300663-8c42-ad09-e13f-066d5c602ca1</Session><Date>2017-02-15T14:47:05.443</Date><Level>Medium</Level><Type>Delete</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Deletedboxes:143to143</Description></Row>"
    		+ "");

    private static String webpageDualCreate = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>3a300663-8c42-ad09-e13f-066d5c602ca1</Session><Date>2017-02-15T14:47:33.117</Date><Level>Low</Level><Type>Create</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Created2newVoicemailboxesstartingatnumber13371337forclientWEBADMINTEST</Description></Row>"
    		+ "");

    private static String webpageEdit = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>3a300663-8c42-ad09-e13f-066d5c602ca1</Session><Date>2017-02-15T14:48:41.317</Date><Level>Low</Level><Type>Edit</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Updatedbox:143</Description></Row>"
    		+ "");

    private static String webpageCopy = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>3a300663-8c42-ad09-e13f-066d5c602ca1</Session><Date>2017-02-15T14:49:25.363</Date><Level>Medium</Level><Type>Copy</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Copiedbox143FilterUser=2097020Messages=3915583Faxes=255Groups=7Notifications=7CallOptions=16777215Connectivity=590269Greetings=16383VoiceRec=1Outbound=15toboxes:144</Description></Row>"
    		+ "");

    private static String webpageReset = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>3a300663-8c42-ad09-e13f-066d5c602ca1</Session><Date>2017-02-15T14:50:27.337</Date><Level>Medium</Level><Type>Reset</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>ResetboxesFilterUser=2080639Groups=-1:143to143</Description></Row>"
    		+ "");

    private static String webpageDualDelete = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>3a300663-8c42-ad09-e13f-066d5c602ca1</Session><Date>2017-02-15T14:51:20.187</Date><Level>Medium</Level><Type>Delete</Type><Category>Boxes</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Deletedboxes:143to144</Description></Row>"
    		+ "");
    
    private static String webpageSecurity = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>3a300663-8c42-ad09-e13f-066d5c602ca1</Session><Date>2017-02-15T14:51:45.550</Date><Level>High</Level><Type>Edit</Type><Category>Security</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>EditedSecuritySettings:MailboxMaxPasscodeRetention=3</Description></Row>"
    		+ "");
    
    private static String webpageSecurity2 = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>3a300663-8c42-ad09-e13f-066d5c602ca1</Session><Date>2017-02-15T14:51:49.737</Date><Level>High</Level><Type>Edit</Type><Category>Security</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>EditedSecuritySettings:MailboxMaxPasscodeRetention=4</Description></Row>"
    		+ "");
    
    private static String webpageSystemLog = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>3a300663-8c42-ad09-e13f-066d5c602ca1</Session><Date>2017-02-15T14:51:57.737</Date><Level>High</Level><Type>Edit</Type><Category>SystemLog</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>EditedSystemLogParameters:UserActivityLevel=7UserActivityType=127UserActivityCategory=1023UserActivityResult=3</Description></Row>"
    		+ "");

    private static String webpageMaintenance = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>3a300663-8c42-ad09-e13f-066d5c602ca1</Session><Date>2017-02-15T14:52:01.933</Date><Level>Medium</Level><Type>Edit</Type><Category>Maintenance</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>EditedMaintenanceSettings:</Description></Row>"
    		+ "");

    private static String webpageClients = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>3a300663-8c42-ad09-e13f-066d5c602ca1</Session><Date>2017-02-15T14:52:06.413</Date><Level>Medium</Level><Type>Edit</Type><Category>Clients</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Updatedclient'ReportTest'ID:9</Description></Row>"
    		+ "");

    private static String webpageUsers = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>3a300663-8c42-ad09-e13f-066d5c602ca1</Session><Date>2017-02-15T14:52:11.297</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID1ViewBoxes=1EditBoxes=1CreateBoxes=1DeleteBoxes=1CopyBoxes=1RenumberBoxes=1ResetBoxes=1TelephonyServerControl=1</Description></Row>"
    		+ "");

    private static String webpageUsers2 = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>3a300663-8c42-ad09-e13f-066d5c602ca1</Session><Date>2017-02-15T14:52:11.307</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID2ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0</Description></Row>"
    		+ "");

    private static String webpageUsers3 = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>3a300663-8c42-ad09-e13f-066d5c602ca1</Session><Date>2017-02-15T14:52:11.330</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID7ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0</Description></Row>"
    		+ "");

    private static String webpageUsers4 = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>3a300663-8c42-ad09-e13f-066d5c602ca1</Session><Date>2017-02-15T14:52:11.347</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Createdclientcontrolrightsforuser:jarenID:55forclientID9ViewBoxes=0EditBoxes=0CreateBoxes=0DeleteBoxes=0CopyBoxes=0RenumberBoxes=0ResetBoxes=0TelephonyServerControl=0</Description></Row>"
    		+ "");

    private static String webpageUsers5 = regexReplace("<Row><UserID>55</UserID><Login>jaren</Login><Session>3a300663-8c42-ad09-e13f-066d5c602ca1</Session><Date>2017-02-15T14:52:11.357</Date><Level>High</Level><Type>Edit</Type><Category>Users</Category><Result>Success</Result><ErrorCode>1</ErrorCode><Description>Updateduser:jarenID:55.BackupDB=1ViewClients=1EditClients=1CreateClients=1DeleteClients=1ViewSysParams=1EditSysParams=1ViewUsers=1EditUsers=1CreateUsers=1DeleteUsers=1ViewReports=1ViewSecuritySettings=1EditSecuritySettings=1</Description></Row></DocumentElement>"
    		+ "");
    
    

}
