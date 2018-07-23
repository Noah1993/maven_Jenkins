
package baseClass;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import automationFramework.GenericKeywords;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass extends GenericKeywords
{

	////////////////////////////////////////////////////////////////////////////////
	//Function Name  :
	//Purpose        :
	//Parameters     :
	//Return Value   :
	//Created by     :
	//Created on     :      
	//Remarks        :
	/////////////////////////////////////////////////////////////////////////////////
	//public static final String btn_DoneButton="done button option #xpath=//android.widget.Button[@resource-id='" + getConfigProperty("AppPackage1")+ ":id/help_submit_btn']";

	public String randomNumber;

	public BaseClass() {

		// TODO Auto-generated constructor stub
	}

	public void setup(String machineName,String host ,String port,
			String browser, String os, String browserVersion, String osVersion,String sheetNo) {
		testDataSheetNo=Integer.parseInt(sheetNo);
		setEnvironmentTimeouts();

		//openBrowser(machineName,host,port,browser,os,browserVersion,osVersion);
		currentExecutionMachineName(machineName.replace(" ",""));
		
		//capabilities.setCapability("recreateChromeDriverSessions", true);
		
	}

	public void setEnvironmentTimeouts()
	{
		setTimeouts();
	}
	public void closeAllSessions()
	{
		driver.quit();
	}
	
	@SuppressWarnings("unchecked")
	public void swipeLeft() {
		((AppiumDriver<WebElement>) driver).context("NATIVE_APP");
		Dimension size = ((AndroidDriver<WebElement>) driver).manage().window().getSize();
		
		
		int startx = (int) (size.width * 0.92);
		int endx = (int) (size.width * 0.21);
		int starty = size.height / 2;
		
		System.out.println("BEFOER SWIPE :: size"+size);
		System.out.println("BEFOER SWIPE :: startx"+startx);
		System.out.println("BEFOER SWIPE :: endx"+endx);
		System.out.println("BEFOER SWIPE :: starty"+starty);
		
		((AndroidDriver<WebElement>) driver).swipe(startx, starty, endx, starty, 1000);
		
		System.out.println("SWIPE is PERFORMEd Checkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
	}
	/*public void clickOnDoneOption()
	{
		clickOn(btn_DoneButton);
	}*/


}

