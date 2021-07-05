package com.redbus.pages;

import java.util.NoSuchElementException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchBus_redbus {
	WebDriver driver;

	// initialize the constructor
	public SearchBus_redbus(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// locating elements which will be required in our script
	@FindBy(how = How.XPATH, using = "//a[@id='redBus']")
	private WebElement Bus_ticket;

	@FindBy(how = How.XPATH, using = "//input[@id='txtSource']")
	private WebElement Start;

	@FindBy(how = How.CSS, using = "#txtDestination")
	private WebElement Destination;

	@FindBy(how = How.XPATH, using = "//input[@id='txtOnwardCalendar']")
	private WebElement Show_Date;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Search Buses']")
	private WebElement Search;

	@FindBy(how = How.CSS, using = "div.search:nth-child(1) div.srp-data.clearfix div.filter-sec.fl.w-20 div.filter-details.f-12.d-color div.details ul.dept-time.dt-time-filter:nth-child(3) li.checkbox:nth-child(2) > label.custom-checkbox:nth-child(2)")
	private WebElement Departure_Time;

	@FindBy(how = How.XPATH, using = "//body/section[@id='rh_main']/div[@id='mBWrapper']/div[@id='root']/div[1]/div[2]/div[2]/div[1]/ul[1]/li[1]")
	private WebElement D_time;

	@FindBy(how = How.XPATH, using = "//ul[3]//li[3]//label[1]")
	private WebElement AC_Bus_Type;

	@FindBy(how = How.XPATH, using = "//li[@title='AC']")
	private WebElement Type;

	@FindBy(how = How.XPATH, using = "//ul[@class='dept-time at-time-filter']//li[3]//label[1]")
	private WebElement Arrival;

	@FindBy(how = How.XPATH, using = "//li[@title='12 pm to 6 pm']")
	private WebElement A_Time;

	@FindBy(how = How.XPATH, using = "//ul[5]//li[3]//label[1]")
	private WebElement Boarding;

	@FindBy(how = How.XPATH, using = "//li[@title='RK Ashram']")
	private WebElement B_Point;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='DROPPING POINT']")
	private WebElement Drop;

	@FindBy(how = How.CSS, using = "label[title='Bareilly Satellite']")
	private WebElement Location;

	@FindBy(how = How.XPATH, using = "//div[@class='button btn-apply dp-apply']")
	private WebElement apply;

	@FindBy(how = How.XPATH, using = "//li[@title='Bareilly Satellite']")
	private WebElement D_Point;

	@FindBy(how = How.XPATH, using = "//div[@class='onward-modify-btn g-button clearfix fl']")
	private WebElement modify;

	@FindBy(how = How.XPATH, using = "//input[@id='onward_cal']")
	private WebElement Calendar;

	@FindBy(how = How.XPATH, using = "//div[@id='rb-calmiddle']//span[contains(text(),'23')]")
	private WebElement New_Date;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='SEARCH']")
	private WebElement Update_Search;

	@FindBy(how = How.XPATH, using = "//input[@id='dest']")
	private WebElement Update_destination;

	@FindBy(how = How.XPATH, using = "//span[@id='switchButton']")
	private WebElement swipebtn;

	@FindBy(how = How.XPATH, using = "//input[@id='src']")
	private WebElement src_empty;

	@FindBy(how = How.XPATH, using = "//input[@id='dest']")
	private WebElement dest_empty;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Enter valid source']")
	private WebElement src_error;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Enter valid Destination']")
	private WebElement dest_error;

	public String header() {
		return driver.getTitle();
	}

	public void Enter_Start_Point(String start_point) throws InterruptedException {
		try {
			Bus_ticket.isDisplayed();
			Bus_ticket.click();
			Thread.sleep(5000);
			Start.isDisplayed();
			Start.clear();
			Start.sendKeys(start_point);
			Thread.sleep(5000);
			Start.click();
			Start.sendKeys(Keys.ENTER);
		} catch (NoSuchElementException e) {
			System.out.println("Element is not displayed");
		}
	}

	public void Enater_Dest_Point(String dest_point) throws InterruptedException {
		try {
			Destination.isDisplayed();
			Destination.clear();
			Destination.sendKeys(dest_point);
			Thread.sleep(5000);
			Destination.click();
			Destination.sendKeys(Keys.ENTER);

		} catch (NoSuchElementException e) {
			System.out.println("Element is not displayed");
		}
	}

	public void choose_date_and_Search(String Date) {
		try {
			Show_Date.sendKeys(Date);
			Show_Date.sendKeys(Keys.ENTER);
		} catch (NoSuchElementException e) {
			System.out.println("Element is not displayed");
		}
	}

	public void search_click() throws InterruptedException {
		try {
			Search.isDisplayed();
			Search.click();

		} catch (NoSuchElementException e) {
			System.out.println("element is not present");
		}

	}

	public void filter_departure_time() {
		try {
			Departure_Time.isDisplayed();
			Departure_Time.click();
		} catch (NoSuchElementException e) {
			System.out.println("Element is not displayed");
		}
	}

	public String dept_time_text() {
		return D_time.getText();
	}

	public void filter_bus_type() throws InterruptedException {
		try {
			AC_Bus_Type.isDisplayed();
			AC_Bus_Type.click();
			;
		} catch (NoSuchElementException e) {
			System.out.println("Element is not displayed");
		}
	}

	public String bus_type_text() {
		return Type.getText();
	}

	public void filter_arrival_time() {
		try {
			Arrival.isDisplayed();
			Arrival.click();
		} catch (NoSuchElementException e) {
			System.out.println("Element is not displayed");
		}
	}

	public String arrival_text() {
		
		return A_Time.getText();
	}

	public void filter_boarding_Point() {
		try {
			Boarding.isDisplayed();
			Boarding.click();
			;
		} catch (NoSuchElementException e) {
			System.out.println("Element is not displayed");
		}
	}

	public String boarding_point_text() {
		return B_Point.getText();
	}

	public void filter_Drop_location() {
		try {
			Drop.isDisplayed();
			Drop.click();
			
			Location.isDisplayed();
			Location.click();
			
			apply.isDisplayed();
			apply.click();
		} catch (NoSuchElementException e) {
			System.out.println("Element is not displayed");
		}
	}

	public String Drop_text() {
		return D_Point.getText();
	}

	public void Update_Ride() {
		try {
			modify.isDisplayed();
			modify.click();
			Calendar.isDisplayed();
			Calendar.click();
			New_Date.isDisplayed();
			New_Date.click();
		} catch (NoSuchElementException e) {
			System.out.println("Element is not displayed");
		}
	}

	public void Update_destination_place(String new_place) throws InterruptedException {
		modify.isDisplayed();
		modify.click();
		Thread.sleep(10000);
		Update_destination.clear();
		Update_destination.sendKeys(new_place);
		Update_destination.click();
		Update_destination.sendKeys(Keys.ENTER);
	}

	public void Search_update() {
		Update_Search.click();
	}

	public void empty_source_and_dest() throws InterruptedException {
		modify.click();
		
		src_empty.clear();
		src_empty.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(5000);
		
		dest_empty.clear();
		dest_empty.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(5000);
		Update_destination.click();
	}

	public String error_src_empty_msg() {
		return src_error.getText();
	}

	public String error_dest_empty_msg() {
		return dest_error.getText();
	}
	
	public void swipe_function() {
		modify.isDisplayed();
		modify.click();
		
		swipebtn.click();
	}	
}
