package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.CnngoPage_Web_Mobile;
import com.mop.qa.testbase.TestBase;

public class Test_CNN_PC extends TestBase {
	
	
	 @Test
		public void VideoAuto_PC() throws Exception  {
		 try{
		 CnngoPage_Web_Mobile cnngo = new CnngoPage_Web_Mobile(remoteDriver);
		 cnngo.enterUrl();
		/* cnngo.playVideo_pc();
		 cnngo.adValidation_PC();
		 cnngo.motionDetect_PC();
		 cnngo.pauseVideo_PC();
		 cnngo.forward();
		 cnngo.rewind();
		 cnngo.testClosedCaptionPC();*/
		 }catch(Exception e){
			 System.out.println(e);
		 }
	 }
	 
}
