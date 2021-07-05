package com.redbus.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage_redbus {

	WebDriver driver;

	// initialize the constructor
	public HomePage_redbus(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// locating elements which will be required in our script
	@FindBy(how = How.XPATH, using = "//li[@data-link='https://www.redbus.in/info/OfferTerms#FIRST']//img")
	private WebElement code;

	@FindBy(how = How.XPATH, using = "//h4[normalize-space()='Use code FIRSTSave up to Rs 150 on bus tickets']")
	private WebElement first_offer;

	@FindBy(how = How.XPATH, using = "//li[@data-link='https://www.redbus.in/redbuscares']//img")
	private WebElement redbus_care;

	@FindBy(how = How.XPATH, using = "//ul[@class='amountRange']//li[1]//span[1]")
	private WebElement amount;

	@FindBy(how = How.XPATH, using = "//input[@value='yes']")
	private WebElement anonymous;

	@FindBy(how = How.XPATH, using = "//div[normalize-space()='DONATE NOW']")
	private WebElement donate;

	@FindBy(how = How.XPATH, using = "//div[normalize-space()='Paytm']")
	private WebElement paytm;

	@FindBy(how = How.XPATH, using = "//div[normalize-space()='Debit Card']")
	private WebElement debit_card;

	@FindBy(how = How.XPATH, using = "//div[normalize-space()='Net Banking']")
	private WebElement netBanking;

	@FindBy(how = How.XPATH, using = "//div[normalize-space()='Other Wallets']")
	private WebElement wallet;

	@FindBy(how = How.XPATH, using = "//div[normalize-space()='PhonePe']")
	private WebElement phonepe;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='PAY NOW']")
	private WebElement pay_now;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Oops! Your payment could not be completed successf')]")
	private WebElement Paytm_warning;

	@FindBy(how = How.XPATH, using = "//div[@class='valErr'][normalize-space()='* Please enter valid card number']")
	private WebElement debit_card_error;

	@FindBy(how = How.XPATH, using = "//select[@class='dropdown']")
	private WebElement net_Banking_drop_down;

	@FindBy(how = How.XPATH, using = "//img[@class='bank-logo']")
	private WebElement amazon_pay_wallet;

	@FindBy(how = How.XPATH, using = "//h1[normalize-space()='Login with your Amazon account']")
	private WebElement amazon_login;

	@FindBy(how = How.XPATH, using = "//h1[normalize-space()='Login to PhonePe']")
	private WebElement phonepe_login;

	@FindBy(how = How.XPATH, using = "//div[@class='manageHeaderLbl']")
	private WebElement manage_booking;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Cancel')]")
	private WebElement cancel_button;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Change Travel Date')]")
	private WebElement change_button;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Change Travel Date')]")
	private WebElement show_ticket;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Email/SMS')]")
	private WebElement email_button;
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='reactContentMount']/div/div[@class='bodyContainer']/div[@class='paymentContainer fr']/div[@class='otherAmountContainer']/span[@class='otherAmounttxt']/input[1]")
	private WebElement amount_box;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='amountRange']//li[1]//span[1]")
	private WebElement amount_200;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'500')]")
	private WebElement amount_500;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'1000')]")
	private WebElement amount_1000;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'2000')]")
	private WebElement amount_2000;
	

	public String amount_box_get_text() {
		return driver.findElement(By.id("otherAmount")).getText();
	}

	public void amount_click_200() {
		redbus_care.click();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		amount_200.click();
	}
	
	public void amount_click_500() {
		amount_500.click();
	}
	
	public void amount_click_1000() {
		amount_1000.click();
	}
	
	public void amount_click_2000() {
		amount_2000.click();
	}

	public void first_ride_offer() {
		code.click();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

	}

	public String code_text() {
		return first_offer.getText();
	}

	public void RedBus_Cares_donation() {
		redbus_care.click();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		amount.click();
		anonymous.click();
		donate.click();
	}

	public void Paytm_payment() throws InterruptedException {
		paytm.click();
		pay_now.click();
		Thread.sleep(5000);
	}

	public String paytm_text() {
		return driver.getCurrentUrl();
	}

	public void Debit_Card_payment() throws InterruptedException {

		debit_card.click();
		pay_now.click();
		Thread.sleep(5000);
	}

	public String debit_card_text() {
		return debit_card_error.getText();
	}

	public void NetBanking_payment() throws InterruptedException {

		netBanking.click();
		Thread.sleep(5000);
	}

	public String Bank_options_text() {
		return net_Banking_drop_down.getText();
	}

	public void Phonepe_payment() throws InterruptedException {
		phonepe.click();
		pay_now.click();
		Thread.sleep(5000);
	}

	public String phonepe_text() {
		return phonepe_login.getText();
	}

	public void wallet_payment() throws InterruptedException {
		wallet.click();
		Thread.sleep(5000);
	}

	public String wallet_visible() throws InterruptedException {
		String msg;
		if (amazon_pay_wallet.isDisplayed() == true) {
			amazon_pay_wallet.click();
			pay_now.click();
			Thread.sleep(5000);
			msg = amazon_login.getText();
		} else {
			msg = "Element is not displayed";
		}
		return msg;
	}

	public void Manage_boking_Options() {
		manage_booking.click();
	}

	public String cancel_URL() {
		cancel_button.click();
		return driver.getCurrentUrl();
	}

	public String change_URL() {
		driver.navigate().back();
		manage_booking.click();
		change_button.click();
		return driver.getCurrentUrl();
	}

	public String show_URL() {
		driver.navigate().back();
		manage_booking.click();
		show_ticket.click();
		return driver.getCurrentUrl();
	}

	public String email_URL() {
		driver.navigate().back();
		manage_booking.click();
		email_button.click();
		return driver.getCurrentUrl();
	}

}
