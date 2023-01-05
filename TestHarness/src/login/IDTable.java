package login;

public class IDTable 
{
	//WebAdmin Main page
	public static String WebAdminMPBoxesID = "";
	public static String WebAdminMPIndividualStateButton_ctl01 = "ctl00_uxCphContent_ucBoxes_uxRepeater_ctl01_uxLb_Box_State"; //41_01_ux
	
	public static void main(String[] args)
	{
		String test = WebAdminMPIndividualStateButton_ctl01.replaceFirst("ctl01", "ctl03");
	}
}
