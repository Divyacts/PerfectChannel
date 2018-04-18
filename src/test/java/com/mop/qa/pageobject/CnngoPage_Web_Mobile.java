package com.mop.qa.pageobject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;

public class CnngoPage_Web_Mobile extends PageBase {

	public static org.openqa.selenium.Point location = null;
	public static float playx = 0;
	public static float playy = 0;
	public static org.openqa.selenium.Dimension size = null;

	public CnngoPage_Web_Mobile(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	public CnngoPage_Web_Mobile(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}

	@FindBy(xpath = "//*[@id='subsection']/div[2]/div/div[1]/ul/li[1]/article/div/div[1]/a/img")
	private WebElement Video;

	@FindBy(xpath = "//*[@id='player-videoHub0--video-element-1']")

	private WebElement VideoMobile;

	@FindBy(xpath = "//*[@id=\"player-videoHub0\"]/div[8]/div[2]/div")

	private WebElement time;

	@FindBy(xpath = "//div[contains(@class,'vjs-current-time') and contains(@class,'vjs-time-controls')]/div[@class='vjs-current-time-display']")

	private WebElement time1;

	@FindBy(xpath = "//*[@id=\"player-videoHub0\"]/div[8]/div[7]/div[1]/div[3]")

	private WebElement slider;

	@FindBy(xpath = "//div[@class='vjs-progress-control vjs-control']//div[contains(@class,'vjs-slider-handle')]")

	private List<WebElement> slider1;

	@FindBy(xpath = "//div[@class='vjs-tech']/video[1]")
	private WebElement VideoPlayer;

	@FindBy(xpath = "//div[@aria-label='play video']")
	private WebElement btnPlayVideo;

	@FindBy(xpath = "//div[contains(@class,'vjs-fullscreen-control') and contains(@class,'vjs-control')]")
	private WebElement VideoPlayerFullScreen;

	@FindBy(id = "player-videoHub0--video-element-1")
	private WebElement VideoPlayerMobile;

	@FindBy(xpath = "//div[contains(@class,'vjs-play-control') and contains(@class,'vjs-playing')]")
	private WebElement btnPause;

	@FindBy(xpath = "//div[contains(@class,'vjs-play-control') and contains(@class,'vjs-paused')]")
	private WebElement btnPlay;

	@FindBy(className = "theoplayer-configuration-control vjs-control")
	private WebElement settingsIcon;

	@FindBy(xpath = "//div[contains(@class,'vjs-subtitles-button')]")
	private WebElement CCIcon;

	@FindBy(xpath = "//div[contains(@class,'vjs-subtitles-button')]//ul[contains(@class,'vjs-menu-content')]/li[3]")
	private WebElement CCONIcon;

	public void enterUrl() throws Exception {
		enterUrl("http://edition.cnn.com/shows/amanpour");
		Thread.sleep(3000);
	}

	public void playVideo_pc() throws Exception {

		click(Video, "Play Button");
		Thread.sleep(5000);
		
	}
	public void playVideo_mobile() throws Exception {
		
		click(Video, "Play Button");
		Thread.sleep(3000);
		
			click(btnPlayVideo, "Video Play Button");
	}

	public void adValidation_Mobile() throws Exception {

		Mat img2 = Imgcodecs.imread("preprocess\\ad1.PNG", Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
		Thread.sleep(5000);
		if (CheckImageinVideo(img2, 0.9)) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Advertisement is not Playing ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			System.out.println("Ad is not  playing");
		} else {
			ExtentUtility.getTest().log(LogStatus.INFO, "Advertisement is Playing ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			System.out.println("Ad is playing");
			Thread.sleep(25000);
			CheckImageinVideo(img2, 3);
		}

	}

	public void adValidation_PC() throws Exception {

		Mat img2 = Imgcodecs.imread("preprocess\\ccn_logo.png", Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
		Thread.sleep(5000);
		if (CheckImageinVideo(img2, 1)) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Advertisement is not Playing ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			System.out.println("Ad is not playing");
		} else {
			ExtentUtility.getTest().log(LogStatus.INFO, "Advertisement is Playing ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			System.out.println("Ad is playing");
			CheckImageinVideo(img2, 3);
		}

	}

	public void motionDetect_PC() throws IOException, InterruptedException {
		location = VideoPlayer.getLocation();
		size = VideoPlayer.getSize();

		AppDetect_VideoPlayDesktop(location, size);
		Thread.sleep(3000);
	}

	public void motionDetect_Mobile() throws IOException, InterruptedException {
		location = VideoPlayer.getLocation();
		size = VideoPlayer.getSize();
		AppDetect_VideoPlay(location, size);
		//Thread.sleep(3000);
	}

	public void pauseVideo_PC() throws Exception {
		clickByJse(btnPause, "Pause Button");
		Thread.sleep(3000);
		AppDetect_VideoPause_Desktop(location, size);

	}

	public void pauseVideoMobile() throws Exception {
		// click(VideoMobile, "Pause Button");
		clickByJse(btnPause, "Pause Button");
		//Thread.sleep(3000);
		AppDetect_VideoPause(location, size);

	}

	public void forward() throws Exception {

		String before = getText(time1).replace("Current Time", "").trim();
		System.out.println(before);

		dragAndDropThumb(slider1.get(0), 20);
		Thread.sleep(2000);
		clickByJse(btnPlay, "Play  Button");
		Thread.sleep(2000);
		clickByJse(btnPause, "Pause  Button");

		String after = getText(time1).replace("Current Time", "").trim();
		System.out.println(after);

		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
		Date timeB4 = sdf.parse(before);
		Date timeaftr = sdf.parse(after);

		if (timeaftr.after(timeB4)) {
			System.out.println("Video is Fast Forwarded from " + before + " to " + after + " Successfully");
			ExtentUtility.getTest().log(LogStatus.PASS,
					"Video is Fast Forwarded from " + before + " to " + after + " Successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} else {
			System.out.println("Video Fast Forward Failed");
			ExtentUtility.getTest().log(LogStatus.FAIL, "Video Fast Forward Failed",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

	public void forwardMobile() throws Exception {

		String before = getText(time).replace("Current Time", "").trim();
		System.out.println(before);
		dragAndDropThumb(slider, 35);
		Thread.sleep(2000);
		click(btnPlay, "Play Button");
		String after = getText(time).replace("Current Time", "").trim();
		System.out.println(after);

		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
		Date timeB4 = sdf.parse(before);
		Date timeaftr = sdf.parse(after);
		System.out.println(timeaftr);
		if (timeaftr.after(timeB4)) {
			ExtentUtility.getTest().log(LogStatus.PASS,
					"Video is Fast Forwarded from " + before + " to " + after + " Successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} else {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Video Fast Forward Failed",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

	public void rewind() throws Exception {

		String before = getText(time1).replace("Current Time", "").trim();
		System.out.println(before);

		dragAndDropThumb(slider1.get(0), -30);
		Thread.sleep(2000);
		clickByJse(btnPlay, "Play Button");
		Thread.sleep(1000);
		clickByJse(btnPause, "Pause Button");

		String after = getText(time1).replace("Current Time", "").trim();
		System.out.println(after);

		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
		Date timeB4 = sdf.parse(before);
		Date timeaftr = sdf.parse(after);
		if (timeaftr.before(timeB4)) {
			System.out.println("Video is Rewound from " + before + " to " + after + " Successfully");
			ExtentUtility.getTest().log(LogStatus.PASS,
					"Video is Rewound from " + before + " to " + after + " Successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} else {
			System.out.println("Video Rewind Failed");
			ExtentUtility.getTest().log(LogStatus.FAIL, "Video Rewind Failed",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

	public void rewindMobile() throws Exception {
		System.out.println("touched");
		Thread.sleep(3000);
		click(VideoMobile, "Pause Button");
		String before = getText(time).replace("Current Time", "").trim();
		System.out.println(before);
		dragAndDropThumb(slider, -20);
		Thread.sleep(2000);
		click(btnPlay, "Play Button");
		String after = getText(time).replace("Current Time", "").trim();
		System.out.println(after);
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
		Date timeB4 = sdf.parse(before);
		Date timeaftr = sdf.parse(after);
		if (timeaftr.before(timeB4)) {
			ExtentUtility.getTest().log(LogStatus.PASS,
					"Video is Rewound from " + before + " to " + after + " Successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} else {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Video Rewind Failed",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

	public void testClosedCaptionMobile() throws Exception {

		clickByJse(CCIcon, "CC button");
		clickByJse(CCONIcon, "CC ON Icon");
		clickByJse(btnPlay, "Play Button");
		String cc = extract_Text_with_coordinates(34, 343, 1020, 550, 3);
		if (cc.length() > 1) {
			System.out.println(cc.replaceAll("[^A-Za-z]", " ").trim());
			System.out.println("Closed Caption is showing");
			ExtentUtility.getTest().log(LogStatus.PASS, "Closed Caption is showing",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} else {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Closed Caption is not showing",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			System.out.println("Closed Caption is not showing");
		}

	}

	public void testClosedCaptionPC() throws Exception {

		clickByJse(CCIcon, "CC button");
		clickByJse(CCONIcon, "CC ON Icon");
		clickByJse(btnPlay, "Play Button");
		String cc = extract_Text_Desktop(location, size);
		if (cc.length() > 1) {
			System.out.println(cc.replaceAll("[^A-Za-z]", " ").trim());
			System.out.println("Closed Caption is showing");
			ExtentUtility.getTest().log(LogStatus.PASS, "Closed Caption is showing",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} else {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Closed Caption is not showing",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			System.out.println("Closed Caption is not showing");
		}

	}
}
