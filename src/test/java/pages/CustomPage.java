package pages;

import baseClass.BaseClass;
import iSafe.ApplicationKeywords;

public class CustomPage extends ApplicationKeywords
{
	public CustomPage(BaseClass obj) {super(obj);}
	boolean verifyPageLoad = false;
	public static final String obj_PageLoad
		= " SIGN IN "
		+ "#id=legend";
	public static final String txt_PageLoad
		= "SIGN IN";
	public static final String obj_Shortname
		= " Shortname "
		+ "#id=USERLBL";
	public static final String obj_NetworkPassword
		= " Password "
		+ "#id=PASSWORDLBL";
	public static final String obj_LogIn
		= " Log In "
		+ "#id=SUBMITFORM";
	public static final String txt_shortname
		= "ldapstest6";
	public static final String txt_password
		= "Start18";
	public static final String obj_ChangeStore
		= " CHANGE STORE "
		//+ "#id=changeStoreId";
		+ "#xpath=//div[@id='fixedMenuBar']/div/div/ul/li/*[@id=\"changeStoreId\"]";
	//*[@id="changeStoreId"]
	public static final String sel_Store
		= " Please Select a Store. "
		+ "#id=storeHeaderSelect";
	public static final String obj_Change
		= " CHANGE "
		+ "#id=changeStoreHeaderId";
	
	public boolean verifyPageLoad() {
		Boolean result = getText(obj_PageLoad).contains(txt_PageLoad);
		if(result){
			testStepPassed("Page loaded successfully found = "+txt_PageLoad);
			verifyPageLoad = true;
		} else {testStepFailed("Did not see page load text = "+txt_PageLoad
				+ " *** Actual = "+getText(obj_PageLoad));
			verifyPageLoad = false;}
		return verifyPageLoad;
	}
	
	public void logIn(String shortname, String password) {
		if (shortname.equals("@DEFAULT")) {shortname = txt_shortname;}
		if (password.equals("@DEFAULT")) {password = txt_password;}
		typeIn(obj_Shortname, shortname);
		typeIn(obj_NetworkPassword, password);
		clickOn(obj_LogIn);
	}
}
