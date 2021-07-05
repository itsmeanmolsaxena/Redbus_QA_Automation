package com.redbus.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import com.redbus.pages.HomePage_redbus;
import com.relevantcodes.extentreports.LogStatus;

import utility.Redbus_BaseTest;

public class HomePage_test_redbus extends Redbus_BaseTest {

	@Test
	public void first_ride_offer() {
		HomePage_redbus home = new HomePage_redbus(driver);
		home.first_ride_offer();
		logger.info("Use Code First Offer is clicked");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String code = home.code_text();
		logger.info("This offer says :- " + code);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test
	public void Donation_amount_check() throws InterruptedException {

		HomePage_redbus home = new HomePage_redbus(driver);
		home.amount_click_200();
		logger.info("clicked for 200/-");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		home.amount_click_500();
		logger.info("clicked for 500/-");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		home.amount_click_1000();
		logger.info("clicked for 1000/-");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		home.amount_click_2000();
		logger.info("clicked for 2000/-");
	}

	@Test
	public void Manage_booking_options() {

		HomePage_redbus home = new HomePage_redbus(driver);
		home.Manage_boking_Options();
		logger.info("Site is opened and we have clicked Manage Booking option");
		String URL_1 = home.cancel_URL();
		String URL_2 = home.change_URL();
		String URL_3 = home.email_URL();
		String URL_4 = home.show_URL();
		logger.info(URL_1);
		logger.info(URL_2);
		logger.info(URL_3);
		logger.info(URL_4);

	}

	@Test
	public void Redbus_Cares_DebitCard() throws InterruptedException {

		HomePage_redbus home = new HomePage_redbus(driver);
		home.RedBus_Cares_donation();
		logger.info("We have clicked on Redbus Cares button");
		home.Debit_Card_payment();
		logger.info("Payment method is selected as debit card");
		logger.info("Leaving details empty");
		String msg = home.debit_card_text();
		logger.info("Error msg says that :- " + msg);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	}

	@Test
	public void Redbus_Cares_NetBanking() throws InterruptedException {
		HomePage_redbus home = new HomePage_redbus(driver);
		home.RedBus_Cares_donation();
		logger.info("We have clicked on Redbus Cares button");
		home.NetBanking_payment();
		logger.info("Payment method is selected as Net Banking");
		String msg = home.Bank_options_text();
		logger.info("These are the banks available in net banking option :- \n " + msg);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	}

	@Test
	public void Redbus_Cares_OtherWallets() throws InterruptedException {

		HomePage_redbus home = new HomePage_redbus(driver);
		home.RedBus_Cares_donation();
		logger.info("We have clicked on Redbus Cares button");
		home.wallet_payment();
		logger.info("Payment method is selected as other wallets");
		String msg = home.wallet_visible();
		logger.info("We have clicked on amazon pay and we are redirected to :- " + msg);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test
	public void Redbus_Cares_Paytm() throws InterruptedException {

		HomePage_redbus home = new HomePage_redbus(driver);
		home.RedBus_Cares_donation();
		logger.info("We have clicked on Redbus Cares button");
		home.Paytm_payment();
		logger.info("Payment method is selected as Paytm");
		String msg = home.paytm_text();
		logger.info("The url of that page is :- " + msg);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test
	public void Redbus_Cares_PhonePe() throws InterruptedException {

		HomePage_redbus home = new HomePage_redbus(driver);
		home.RedBus_Cares_donation();
		logger.info("We have clicked on Redbus Cares button");
		home.Phonepe_payment();
		logger.info("Payment method is selected as Phonepe");
		String msg = home.phonepe_text();
		logger.info("We are redirected to :- " + msg);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

}
