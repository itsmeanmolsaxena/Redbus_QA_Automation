package com.redbus.pages;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Invalid_login_redbus {
	WebDriver driver;

	// initialize the constructor
	public Invalid_login_redbus(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// locating elements which will be required in our script
	@FindBy(how = How.XPATH, using = "//i[@id='i-icon-profile']")
	private WebElement account;

	@FindBy(how = How.XPATH, using = "//li[@id='signInLink']")
	private WebElement signin;

	@FindBy(how = How.XPATH, using = "//ul[@id='selectedPhCode']")
	private WebElement dropdown;

	@FindBy(how = How.XPATH, using = "//input[@id='mobileNoInp']")
	private WebElement phone_number;

	@FindBy(how = How.XPATH, using = "//div[@id='recaptchaElement']")
	private WebElement popup;

	@FindBy(how = How.XPATH, using = "//div[@id='otp-container']")
	private WebElement OTP;

	@FindBy(how = How.XPATH, using = "//div[@class='server-error server-error-active error']")
	private WebElement error_msg;

	@FindBy(how = How.XPATH, using = "//span[@class='error-message-fixed error-message-full top-fix']")
	private WebElement blank_error;

	@FindBy(how = How.CLASS_NAME, using = "modalIframe")
	private WebElement frame;

	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[8]/div[1]")
	private WebElement googleIcon;

	public void sign_in() {
		account.click();

		signin.click();
	}

	public void country_code() throws InterruptedException {
		try {
			driver.switchTo().frame(frame);
			// String mainWindow = driver.getWindowHandle();
			dropdown.isDisplayed();
			dropdown.click();
			driver.findElement(By.xpath("//div[normalize-space()='Australia']")).click();
			Thread.sleep(5000);
		} catch (ElementNotInteractableException e) {
			System.out.println("Element is not tracable");
		}
	}

	public void phone_number_length_verification(String number) {
		try {
			phone_number.isDisplayed();
			phone_number.clear();
			phone_number.sendKeys(number);

		} catch (NoSuchElementException e) {
			System.out.println("Emenet is not tracable");
		}
	}

	public String click_captcha_and_otp() throws InterruptedException {
		String msg;
		popup.isDisplayed();
		popup.click();
		Thread.sleep(5000);
		try {
			OTP.isDisplayed();
			OTP.click();
			msg = "We are able to proceed";
		} catch (ElementClickInterceptedException e) {
			msg = "we are unable to proceed";
		}
		return msg;

	}

	public String phone_number_length_error() {
		try {
			error_msg.isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("element is not displayed");
		}
		return error_msg.getText();
	}

	public void empty_field_verification(String Number) throws InterruptedException {
		try {
			phone_number.isDisplayed();
			phone_number.sendKeys(Number);
			Thread.sleep(2000);
			phone_number.clear();
		} catch (NoSuchElementException e) {
			System.out.println("No element is present");
		}
	}

	public String blank_field_error() {
		try {
			blank_error.isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("No such element present");
		}
		return blank_error.getText();
	}

}
