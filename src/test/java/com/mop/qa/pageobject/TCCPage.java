package com.mop.qa.pageobject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;

/**
 * SignOnPage class
 * 
 * @author Cognizant
 */
public class TCCPage extends PageBase {
	// UI Map object definitions

	@FindBy(id = "User")
	private WebElement userID;

	@FindBy(id = "Password")
	private WebElement password;

	@FindBy(className = "buttonstylenormal")
	private WebElement login;
	
	@FindBy(xpath = "//*[@id='ADVANCED_IMG']")
	private WebElement advImage;
	
	@FindBy(xpath = "//*[@id='Environment']")
	private WebElement env;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Out')]")
	private WebElement signOut;
	
	@FindBy(xpath = "//*[@id='listRRpt_WSJ']/table/tbody/tr/td[2]")
	private WebElement viewJobs;
	
	
	
	TestBase test = new TestBase();

	
	
	public TCCPage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	public TCCPage(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}
	
	public void enterUrl() throws Exception {
		String url = getAppProperties("ApplicationUrl"); 
		enterUrl(url);
	}
	
	public void enterAsiaUrl() throws Exception {
		String url = getAppProperties("AsiaUrl"); 
		enterUrl(url);
	}
	
	public void enterEMUSUrl() throws Exception {
		String url = getAppProperties("EMUSUrl"); 
		enterUrl(url);
	}
	
	public void checkHomePageLoad() throws IOException {
		try {
		
		Thread.sleep(1000);
		if(viewJobs.isDisplayed()) {
		 Assert.assertEquals(true, viewJobs.isDisplayed(), "Login Succesfull");
		 ExtentUtility.getTest().log(LogStatus.PASS, 
					"Home page loaded Successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
		 
		}catch (Exception ex) {
			System.out.println("checkHomePageLoad Exception" + ex);
			ExtentUtility.getTest().log(LogStatus.FAIL, 
					"Exception in home page loaded",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			
		} 
	}
 

	private void login(String user, String pwd) throws Exception {
		String url = getAppProperties("ApplicationUrl"); 
		
		if (url.equalsIgnoreCase("http://nyjdweb01d.christies.com:1276/jde/")) {
			click(advImage,"Advance ImageClick");
			enterText(env, "JUA910", "Environment");
		}
		userID.clear();
		enterText(userID, user, "Username");
		
		password.clear();
		enterText(password, pwd, "Password");
		click(login,"login Click");

	}

	public JdeHomePage login2nd() throws Exception {
		String user = rds.getValue("General_Data", test.currentTest, "Username");
		String pwd = rds.getValue("General_Data", test.currentTest, "Password"); 
		String url = getAppProperties("ApplicationUrl");
		if (url.equalsIgnoreCase("http://nyjdweb01d.christies.com:1276/jde/")) {
			click(advImage,"Advance ImageClick");
			enterText(env, "JUA910", "Environment");
		}
		userID.clear();
		enterText(userID, user, "Username");
		password.clear();
		enterText(password, pwd, "Password");
		click(login,"login Click");
		return new JdeHomePage(remoteDriver);
	}

	public JdeHomePage Approverlogin() throws Exception {
		String userNameData = rds.getValue("P2P", test.currentTest, "ApprUser");
		String passwordData = rds.getValue("P2P", test.currentTest, "ApprPwd");
		String url = getAppProperties("ApplicationUrl");
		if (url.equalsIgnoreCase("http://nyjdweb01d.christies.com:1276/jde/")) {
			click(advImage,"Advance ImageClick");
			enterText(env, "JUA910", "Environment");
		}
		userID.clear();
		enterText(userID, userNameData, "Username");
		password.clear();
		enterText(password, passwordData, "Password");
		click(login,"login Click");
		return new JdeHomePage(remoteDriver);
	} 

	public JdeHomePage loginAsValidUser() throws Exception {
		String user = rds.getValue("General_Data", test.currentTest, "Username");
		String pwd = rds.getValue("General_Data", test.currentTest, "Password");  
		login(user, pwd);
		return new JdeHomePage(remoteDriver); 
	}
	
	public JdeHomePage loginAsValidUser(String sheetname) throws Exception {
		String user = rds.getValue(sheetname, test.currentTest, "Username");
		String pwd = rds.getValue(sheetname, test.currentTest, "Password");  
		login(user, pwd);
		return new JdeHomePage(remoteDriver); 
		
	}
	
	public void logout() throws Exception{
		click(signOut, "signOut");
		clickAlert();
	}


}