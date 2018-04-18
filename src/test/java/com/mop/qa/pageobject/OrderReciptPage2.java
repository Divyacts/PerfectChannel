package com.mop.qa.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.TestBase;

public class OrderReciptPage2 extends PageBase {
	// UI Map object definitions

	@FindBy(id = "e1menuAppIframe")
	private WebElement menuIframe;

	@FindBy(xpath = "//a/img[@id='hc_Find']")
	private WebElement searchButton;

	@FindBy(xpath = "//a/img[@id='hc_Select']")
	private WebElement selectButton;

	@FindBy(xpath = "//a/img[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[1]/div/input")
	private WebElement checkBox;

	@FindBy(xpath = "//*[@id='G0_1_R1']/td[1]/div/input")
	private WebElement checkBox1;

	@FindBy(id = "//*[@id='selectAll0_1']")
	private WebElement selectAll;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[3]/div/input")
	private WebElement RecCnt1;

	@FindBy(xpath = "//*[@id='G0_1_R1']/td[3]/div/input")
	private WebElement RecCnt2;

	@FindBy(xpath = "//*[@id='E0_1']")
	private WebElement warning;

	@FindBy(xpath = "//*[@id='modelessTabHeaders']/tbody/tr/td/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr/td/font/img")
	private WebElement warning1;

	public OrderReciptPage2(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);

	}
	TestBase test = new TestBase();

	public OrderReciptPage orderRecipt() throws InterruptedException {
		try {
			Thread.sleep(3000);
			// driver.switchTo().frame(menuIframe);
			click(checkBox, "checkBox");
			String recCnt = rds.getValue("P2P", test.currentTest, "ReciptCnt");
			System.out.println("recCnt" + recCnt);
			Thread.sleep(3000);
			enterText(RecCnt1, recCnt, "RecCnt1");
			Thread.sleep(3000);
			// checkBox1.click();
			// RecCnt2.clear();
			// RecCnt2.sendKeys(recCnt);
			Thread.sleep(3000);
			click(saveButton, "saveButton");
			Thread.sleep(3000);
			System.out.println("in first save");
			Thread.sleep(5000);
			click(saveButton, "saveButton");
			Thread.sleep(5000);
			// saveButton.click();
			// boolean warning =
			// existsElement("//*[@id='modelessTabHeaders']/tbody/tr/td/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr/td/font/img");
			/*
			 * try { driver.findElement(By.xpath(
			 * "//*[@id='modelessTabHeaders']/tbody/tr/td/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr/td/font/img"
			 * )); saveButton.click(); }catch (NoSuchElementException e) {
			 * System.out.println("No Warning Proceed"); }
			 */
			/*
			 * if (warning) { System.out.println("in if save");
			 * saveButton.click(); Thread.sleep(3000); }
			 */
		} catch (Exception ex) {
			System.out.println("Inside Order Recipt 2" + ex);
		}
		return new OrderReciptPage(remoteDriver);
	}

	public boolean existsElement(String ele) {

		return true;
	}
}
