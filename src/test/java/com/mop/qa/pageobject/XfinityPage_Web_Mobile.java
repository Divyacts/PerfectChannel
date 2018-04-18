package com.mop.qa.pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase;

import io.appium.java_client.AppiumDriver;

public class XfinityPage_Web_Mobile extends PageBase {

	public static org.openqa.selenium.Point location = null;
	public static float playx = 0;
	public static float playy = 0;
	public static org.openqa.selenium.Dimension size = null;

	public XfinityPage_Web_Mobile(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	public XfinityPage_Web_Mobile(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}

	@FindBy(xpath = "//a[.='Sign In']")
	private List <WebElement> linkSignIn;

	@FindBy(id = "user")

	private WebElement txtUserName;

	@FindBy(id = "passwd")

	private WebElement txtPassword;

	@FindBy(id = "sign_in")

	private WebElement btnSignIn;

	@FindBy(id = "nav-2")

	private WebElement linkLiveTV;

	@FindBy(xpath = "//*[@id='nav-menu-2']/li[1]/a")

	private WebElement ListAllChannels;

	@FindBy(id = "search")
	private WebElement txtbxSearch;

	@FindBy(id = "results")
	private WebElement resultsList;

	@FindBy(xpath = "//div[@class='results-container style-scope tv-search-results']")
	private List<WebElement> channelList;

	@FindBy(xpath = "//*[@id='grid']/tv-grid-row[1]/div/a[1]")
	private WebElement firstShowinList;

	@FindBy(name = "watch")
	private WebElement btnWatch;

	@FindBy(xpath = "//div[.='Yes']")
	private WebElement btnYes;

	@FindBy(xpath = "//h2[.='Adding device...']")
	private WebElement settingsIcon;

	@FindBy(id = "deviceName")
	private WebElement txtBxDeviceName;

	@FindBy(id = "next")
	private WebElement btnContinue;
	
	@FindBy(xpath = "//h2[.='Featured']")
	private WebElement txtfeatured;

	@FindBy(xpath = "//h2[@class='title style-scope tv-page-grid']")
	private WebElement labelShowDetails;
	
	@FindBy(xpath = "//tv-metadata-primary[@class='style-scope tv-listing-detail x-scope tv-metadata-primary-0']")
	private WebElement labelShowDetails1;
	
	@FindBy(id = "cc")
	private WebElement iconCC;
	
	@FindBy(xpath = "//button[@aria-label='Close Player']")
	private WebElement iconclose;
	
	@FindBy(xpath = "//*[@id='nav-3']")
	private WebElement linkBrowse;
	
	@FindBy(xpath = "//*[@id='nav-menu-3']/li[2]/a")
	private WebElement linkMovies;
	
	@FindBy(xpath = "//*[@id='carousel']/ol/li[1]")
	private WebElement firstMovieInList;
	
	
	
	public void enterUrl() throws Exception {
		enterUrl("https://tv.xfinity.com/");
	}

	public void signIn() throws Exception {

		click(linkSignIn.get(0), "Sign In Link");
		Thread.sleep(2000);
		enterText(txtUserName, "cimqafour", "Username");
		enterText(txtPassword, "LiveStream11", "Password");
		Thread.sleep(6000);
		click(btnSignIn, "Sign In button");
		Thread.sleep(7000);
		
	}
	
	public void PlayLiveVideo() throws Exception{
		
		waitForInvisibilityOfElement("//h2[.='Adding device...']");
		click(btnYes, "Yes Button");
		enterText(txtBxDeviceName, "Desktop", "Device Name");
		click(btnContinue, "Continue Button");
		waitForVisibilityOfElement(txtfeatured);
		click(linkLiveTV, "Live TV Link");
		click(ListAllChannels, "All Channels Link");
		waitForVisibilityOfElement(firstShowinList);
		click(firstShowinList, "First Show");
		waitForVisibilityOfElement(btnWatch);
		System.out.println("Show Details are "+labelShowDetails.getText()+labelShowDetails1.getText());
		if(iconCC.isDisplayed()){
			System.out.println("Closed caption option is avialble for this video");
		}
		else
			System.out.println("Closed caption option is not avialble for this video");
		
		click(btnWatch, "Watch Button");
		waitForVisibilityOfElement(iconclose);
		Thread.sleep(6000);
		clickByJse(iconclose, "Close button");
	}

	public void PlayVOD() throws Exception {
		
		click(linkBrowse, "Browse");
		click(linkMovies, "Movies");
		waitForVisibilityOfElement(txtfeatured);
		click(firstMovieInList, "First Movie");
		waitForVisibilityOfElement(btnWatch);
		click(btnWatch, "Watch Button");
	}
}
