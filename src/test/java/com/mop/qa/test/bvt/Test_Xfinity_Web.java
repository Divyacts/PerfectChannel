package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.XfinityPage_Web_Mobile;
import com.mop.qa.testbase.TestBase;

public class Test_Xfinity_Web extends TestBase {
	
	
	 @Test
		public void VideoAuto_PC() throws Exception  {
		 try{
			 
		 XfinityPage_Web_Mobile cnngo = new XfinityPage_Web_Mobile(remoteDriver);
		 cnngo.enterUrl();
		 cnngo.signIn();
		 cnngo.PlayLiveVideo();
		 cnngo.PlayVOD();
		 
		 }catch(Exception e){
			 System.out.println(e);
		 }
	 }
	 
}
