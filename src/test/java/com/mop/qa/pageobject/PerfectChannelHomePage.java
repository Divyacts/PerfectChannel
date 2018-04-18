package com.mop.qa.pageobject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.mop.qa.testbase.PageBase;


public class PerfectChannelHomePage extends PageBase {
	// UI Map object definitions

	@FindBy(xpath = "//*[@id='UserName']")
	private WebElement userID;

	@FindBy(xpath = "//*[@id='Password']")
	private WebElement password;

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement login;
	
	


	public PerfectChannelHomePage(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}


	public void enterUrl() throws Exception {
		String url = getAppProperties("PCAdminUrl"); 
		enterUrl(url);
	}
	
	public void login(String user,String pass) throws Exception{
		
		enterText(userID, user, "userID");
		enterText(password, pass, "password");
		click(login,"login"); 
	}

public String findSaleinPC() throws InterruptedException, IOException
{
	Thread.sleep(5000); 
	WebElement Webtable=remoteDriver.findElement(By.xpath("//*[@id='main']/table"));
	List<WebElement> TotalRowCount=Webtable.findElements(By.xpath("//*[@id='main']/table/tbody/tr"));
	String perfectChannellId = null;
	System.out.println("No. of Rows in the WebTable: "+TotalRowCount.size());
   
	 int numberOfRows  = TotalRowCount.size();
     for(int i=2;i<=numberOfRows;i++) 
     { 
         WebElement salenumber = remoteDriver.findElement(By.xpath("//*[@id='main']/table/tbody/tr["+i+"]/td[2]"));
         WebElement saleStatus = remoteDriver.findElement(By.xpath("//*[@id='main']/table/tbody/tr["+i+"]/td[4]"));
         String sale = getJDEAppProperties("SaleNumber"); 
         if(salenumber.getText().equalsIgnoreCase(sale) && saleStatus.getText().equalsIgnoreCase("Live")){
        	 WebElement element2 = remoteDriver.findElement(By.xpath("//*[@id='main']/table/tbody/tr["+i+"]/td[1]"));
        	 perfectChannellId  =  element2.getText(); 
        	 System.out.println("perfectChannellId"+perfectChannellId);
        	 propertiesJdeWrite("PerfectChannel", perfectChannellId); 	  
        	 break;
         }

         
     }
	return perfectChannellId;
	} 




public PerfectChannelSaleEditPage saleAPIvalidations() throws Exception
{
	Thread.sleep(5000); 
	WebElement Webtable=remoteDriver.findElement(By.xpath("//*[@id='main']/table"));
	List<WebElement> TotalRowCount=Webtable.findElements(By.xpath("//*[@id='main']/table/tbody/tr"));
	String perfectChannellId = null;
	System.out.println("No. of Rows in the WebTable: "+TotalRowCount.size());
	String sale = getJDEAppProperties("SaleNumber"); 
	 int numberOfRows  = TotalRowCount.size();
     for(int i=2;i<=numberOfRows;i++) 
     { 
         WebElement salenumber = remoteDriver.findElement(By.xpath("//*[@id='main']/table/tbody/tr["+i+"]/td[2]"));
         WebElement saleStatus = remoteDriver.findElement(By.xpath("//*[@id='main']/table/tbody/tr["+i+"]/td[4]"));
         
         if(salenumber.getText().equalsIgnoreCase(sale) && saleStatus.getText().equalsIgnoreCase("Live")){
        	 WebElement element2 = remoteDriver.findElement(By.xpath("//*[@id='main']/table/tbody/tr["+i+"]/td[5]"));
        	 click(element2, "EDIT Button CLICK"); 
        	 Thread.sleep(5000);
        	 break;
         }

          
     }
	return new PerfectChannelSaleEditPage(remoteDriver);
	} 


}