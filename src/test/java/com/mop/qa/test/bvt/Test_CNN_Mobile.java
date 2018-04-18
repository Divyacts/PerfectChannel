package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.CnngoPage_Web_Mobile;
import com.mop.qa.testbase.TestBase;

public class Test_CNN_Mobile extends TestBase {
	@Test
		public void VideoAuto_Mobile() throws Exception  {
		 try{
			 
		 CnngoPage_Web_Mobile cnngo = new CnngoPage_Web_Mobile(appiumDriver);
		 cnngo.enterUrl();
		 cnngo.playVideo_mobile();
		 cnngo.adValidation_Mobile();
		 cnngo.motionDetect_Mobile();
		 cnngo.pauseVideoMobile();
		 cnngo.forward();
		 cnngo.rewind();
		 cnngo.testClosedCaptionMobile();
		 }catch(Exception e){
			 System.out.println(e);
		 }
	 }
	
	
	 
}
