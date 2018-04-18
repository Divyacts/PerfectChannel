package com.mop.qa.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase;


public class GenerateChargeOrderRequisiton extends PageBase {

	protected GenerateChargeOrderRequisiton(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);
	}

	// UI Map object definitions
	@FindBy(xpath = "//input[@id='C0_159']")
	private WebElement branchPlantField;

	// @FindBy(id = "C0_159")
	// private WebElement branchPlantField;

	@FindBy(xpath = "//input[@id='C0_13']")
	private WebElement orderNoField;

	@FindBy(id = "e1menuAppIframe")
	private WebElement iframe;

	@FindBy(id = "hc_Find")
	private WebElement searchButton;

	@FindBy(xpath = "//*[@id='qbeRow0_1']/td[2]/div/nobr/input")
	private WebElement orderNoTableField;

	@FindBy(xpath = "//*[@id='G0_1_R0']/td[1]/div/input")
	private WebElement selectCheckBox;

	@FindBy(id = "ROW_EXIT_BUTTON")
	private WebElement rowExitButton;

	@FindBy(xpath = "//*[@id='HE0_156']//nobr[contains(text(),'Order')]")
	private WebElement orderRelease;

	@FindBy(xpath = "//*[@id='hc_OK']")
	private WebElement saveButton;

	@FindBy(xpath = "//*[@id='FORM_EXIT_BUTTON']")
	private WebElement formExitButton;

	// *[@id='HE0_36']//nobr[contains(text(),'Generate')]
	@FindBy(xpath = "//*[@id='HE0_36']/tbody/tr/td[2]/span/nobr")
	private WebElement generateOrdersButton;

	@FindBy(xpath = "//*[@id='HE0_86']//nobr[contains(text(),'Review')]")
	private WebElement reviewOrdersButton;

	@FindBy(xpath = "//img[@id='hc_Close']")
	private WebElement closeButton;

	// *[@id="G0_1_R0"]/td[2]/div
	@FindBy(xpath = "//*[@id='G0_1_R0']/td[2]/div")
	private WebElement orderNumberFieldAfterGenerate;

	String propertyFileName = "Data.properties";

	public OrderInquiryChargePage generatingChargeOrderRequisition() {
		try {
			System.out.println("Generate Charge Order Requistion");


			remoteDriver.switchTo().frame(iframe);
			enterText(branchPlantField, "*", "branchPlantField");


			// getting order number from excel
			// String orderNumber= dataTable.getData("General_Data",
			// "Order Value");
			// String orderNumber="18000044";
			//Actions action = new Actions(driver);
			orderNoField.clear();
			String orderValue = getJDEAppProperties("OrderValue");
			enterText(orderNoField, orderValue, "orderNoField");
			Thread.sleep(2000);
			click(searchButton, "searchButton");
			Thread.sleep(5000);
			click(selectCheckBox, "selectCheckBox");
			click(rowExitButton, "rowExitButton");
			click(orderRelease, "orderRelease");
			Thread.sleep(3000);
			Thread.sleep(3000);
			click(saveButton, "saveButton");
			Thread.sleep(3000);
			click(formExitButton, "formExitButton");
			Thread.sleep(3000);
			moveToElement(reviewOrdersButton, "reviewOrdersButton");
			click(reviewOrdersButton, "reviewOrdersButton"); 
			Thread.sleep(6000);
			// reviewOrdersButton.click();
			click(formExitButton, "formExitButton");
			Thread.sleep(5000); 
			moveToElement(generateOrdersButton, "generateOrdersButton");
			click(generateOrdersButton, "generateOrdersButton");
			Thread.sleep(5000);
			String orderNumberAfterGenerate = orderNumberFieldAfterGenerate
					.getText();
			
			propertiesJdeWrite("OrderNumber", orderNumberAfterGenerate);
			Thread.sleep(2000);
			System.out.println(orderNumberAfterGenerate);
			Thread.sleep(3000); 
			click(closeButton,"closeButton");
			Thread.sleep(5);
			remoteDriver.switchTo().defaultContent();
		} catch (Exception ex) {
			System.out.println(" Inside Generate Charge Order Requistion" + ex);

		}
		return new OrderInquiryChargePage(remoteDriver);

	}

}
