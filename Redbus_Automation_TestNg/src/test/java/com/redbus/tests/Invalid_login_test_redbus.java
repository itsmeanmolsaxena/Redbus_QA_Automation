package com.redbus.tests;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.redbus.pages.Invalid_login_redbus;
import com.relevantcodes.extentreports.LogStatus;

import utility.Redbus_BaseTest;
import utility.Utils;

public class Invalid_login_test_redbus extends Redbus_BaseTest{

	
	private String Sheet = "Search Bus";
	
	@Test
	public void blank_field_error() throws InterruptedException {
		Invalid_login_redbus login = new Invalid_login_redbus(driver);
		HashMap<String, String> data = new HashMap<String, String>();
		String Testcase = "Invalid";
		data = reader.getRowTestData(Sheet, Testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String Number = data.get("Number");
		Utils.toCheckExecutionRequired(executionRequired);
		login.sign_in();
		logger.info("clicked on sign in button");
		login.country_code();
		login.empty_field_verification(Number);
		try {
			String info = login.click_captcha_and_otp();
			logger.info(info);
			if(info == "we are able to proceed") {
				String msg = login.blank_field_error();
				logger.info(msg);
			}
			else {
				logger.info("Element click is intercepted");
			}
		}
		catch (NoSuchElementException e) {
			logger.info("We are unable to proceed due to recaptcha issue.");
		}
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@Test
	public void phone_number_length() throws InterruptedException {
		Invalid_login_redbus login = new Invalid_login_redbus(driver);
		HashMap<String, String> data = new HashMap<String, String>();
		String Testcase = "Invalid";
		data = reader.getRowTestData(Sheet, Testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		String Number = data.get("Number");
		Utils.toCheckExecutionRequired(executionRequired);
		login.sign_in();
		logger.info("clicked on sign in button");
		login.country_code();
		login.phone_number_length_verification(Number);
		
		try {
			String info = login.click_captcha_and_otp();
			logger.info(info);
			if(info == "we are able to proceed") {
				String msg = login.phone_number_length_error();
				logger.info(msg);
			}
			else {
				logger.info("Element click is intercepted");
			}
		}
		catch (NoSuchElementException e) {
			logger.info("We are unable to proceed due to recaptcha issue.");
		}	
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
}
