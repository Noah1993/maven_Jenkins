package scenarios;
import pages.CustomPage;
import pages.CustomCustomerInquiry;
import baseClass.BaseClass;
import iSafe.ApplicationKeywords;

public class CustomSignInTest extends ApplicationKeywords{
	private BaseClass obj;
	private CustomPage customPage;
	private CustomCustomerInquiry customCustomerInquiry;
	
	public CustomSignInTest(BaseClass obj){super(obj);this.obj=obj;}

	public void createObjects(String browser){
		obj.driver=driver;
		obj.currentBrowser=browser;
		customPage = new CustomPage(obj);
		customCustomerInquiry = new CustomCustomerInquiry(obj);}
	
	public void destroyObjects(){
		customPage = new CustomPage(obj);
		customCustomerInquiry = new CustomCustomerInquiry(obj);}

	public void customSignInTestScenario(String machineName,
		String host, String port, String browser, String os, 
		String browserVersion, String osVersion, String tcId){
		try{openBrowser(machineName, host, port, browser, os, browserVersion, 
				osVersion);
			createObjects(browser);
			navigateTo("https://tst-custom.tmw.com");
			customPage.verifyPageLoad();
			customPage.logIn("@DEFAULT", "@DEFAULT");
			customCustomerInquiry.verifyPageLoad();
		}catch(Exception e){testStepFailed(e.toString());
		}finally{driver.quit();destroyObjects();}
		testStepInfo("");
		testStepInfo("*******************************");
		testStepInfo("Test Execution Completed");
		testStepInfo("*******************************");}}