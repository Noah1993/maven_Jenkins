package testCases;

import org.testng.annotations.AfterClass;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import javax.script.ScriptException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationFramework.GenericKeywords;
import baseClass.BaseClass;
import scenarios.CustomSignInTest;
import utilities.Common;
import utilities.OutputAndLog;

import org.testng.annotations.Listeners;

@Listeners({utilities.HtmlReport.class})  
public class TestCases
{
	BaseClass obj;
	CustomSignInTest customSignInTest;
	public static String staticOutPutDirectory = "";

	////////////////////////////////////////////////////////////////////////////////
	//Function Name  :
	//Purpose    	 :
	//Parameters  	 :
	//Return Value   :
	//Created by     :
	//Created on     :     
	//Remarks        :
	/////////////////////////////////////////////////////////////////////////////////

	public void TestStart(String testCaseDescription,String hostName,String testCaseName)
	{	

		obj.currentTestCaseName=testCaseName;
		obj.setEnvironmentTimeouts();
		obj.reportStart(testCaseName,testCaseDescription,hostName);
		obj.iterationCount.clear();
		obj.iterationCountInTextData();


	}
	
	@BeforeSuite
	public void suitePreconditions(){
		try{
			OutputAndLog.createOutputDirectory();
		}
		catch(Exception e){
			System.err.println("Error building Suite");
		}
	}
	
	/*@AfterSuite
	public void cleanUp(){
		try {
			Common.cleanup();
		} catch (Exception e) {
			System.err.println( e.toString());
		} finally {
			Syste.out.println( "###################################");
			Syste.out.println( "Script Execution Complete");
			Syste.out.println( "###################################");
		}
	}*/

	@BeforeClass
	@Parameters({"selenium.machinename", "selenium.host", "selenium.port", "selenium.browser", "selenium.os", "selenium.browserVersion", "selenium.osVersion","TestData.SheetNumber"})
	public void precondition(String machineName, String host, String port,String browser,String os,String browserVersion,String osVersion,String sheetNo)
	{
		
		try{
			
			obj=new BaseClass();
			obj.udid = "ZX1D64HN6H";
			if(os.contains("Android"))
			{
				obj.waitTime(10);
			}
			obj.setup(machineName, host, port,browser,os,browserVersion,osVersion,sheetNo);
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	@AfterClass
	public void closeSessions()
	{
		//ChromedriverHandler.chromeDriverHandlerThread().
		try{
			obj.closeAllSessions();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				Common.cleanup();
			} catch (Exception e) {
				System.err.println( e.toString());
			} finally {
				System.out.println( "###################################");
				System.out.println( "Script Execution Complete");
				System.out.println( "###################################");
			}
		}
	}

	@Test(alwaysRun=true)
	@Parameters({"selenium.machinename","selenium.host", "selenium.port", "selenium.browser", "selenium.os", "selenium.browserVersion", "selenium.osVersion","TestData.SheetNumber"})
	public void TC001(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion,String sheetNo,Method method) throws MalformedURLException, ScriptException, InterruptedException 
	{

		TestStart("Sample Load Google",machineName,method.getName());
		customSignInTest = new CustomSignInTest(obj);
		for(int i=0;i<customSignInTest.iterationCount.size();i++)
		{

			customSignInTest.dataRowNo=Integer.parseInt(customSignInTest.iterationCount.get(i).toString());
			customSignInTest.customSignInTestScenario(machineName,
					 host,  port,  browser,  os, 
					 browserVersion,  osVersion,  method.getName());			
		}
		obj.testFailure=customSignInTest.testFailure;
		TestEnd();
	}

	public void TestEnd() {
		obj.waitTime(1);
		if (obj.testFailure) {
			GenericKeywords.testFailed();
		}
	}
	@BeforeMethod
	public void before()
	{
		obj.testFailure=false;
	}

}
