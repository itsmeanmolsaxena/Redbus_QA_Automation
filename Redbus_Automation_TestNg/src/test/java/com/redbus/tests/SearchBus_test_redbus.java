package com.redbus.tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.redbus.pages.SearchBus_redbus;
import com.relevantcodes.extentreports.LogStatus;
import utility.Redbus_BaseTest;
import utility.Utils;

public class SearchBus_test_redbus extends Redbus_BaseTest {

	private String sheetName = "Search Bus";

	@Test
	public void search_bus() throws InterruptedException {
		HashMap<String, String> data = new HashMap<String, String>();
		String Terstcase = "Search Bus";
		data = reader.getRowTestData(sheetName, Terstcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		Utils.toCheckExecutionRequired(executionRequired);
		String Source = data.get("Source");
		String Destination = data.get("Destination");
		String Date = data.get("Date of Travel");
		SearchBus_redbus search = new SearchBus_redbus(driver);
		search.Enter_Start_Point(Source);
		logger.info("We have entered the Start Point.");
		search.Enater_Dest_Point(Destination);
		logger.info("We have entered the destination.");
		search.choose_date_and_Search(Date);
		search.search_click();
		logger.info("We have hit the search button after giving date.");
		String msg_exp = search.header();
		String msg_actual = driver.getTitle();
		Assert.assertEquals(msg_actual, msg_exp);
		logger.info("Header title is :- " + msg_exp);
		logger.info("We have successfully got the result of search bus operation.");
	}

	@Test
	public void Deaparture_filter() throws InterruptedException {
		SearchBus_redbus search = new SearchBus_redbus(driver);
		search_bus();
		search.filter_departure_time();
		logger.info("One of the Departure time filter is applied");
		String msg_exp_1 = search.dept_time_text();
		String msg_actual_1 = prop.getProperty("dept_time_filter");
		Assert.assertEquals(msg_actual_1, msg_exp_1);
		logger.info("Departure time filter applied is :- " + msg_exp_1);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test
	public void BusType_filter() throws InterruptedException {

		SearchBus_redbus search = new SearchBus_redbus(driver);
		search_bus();
		search.filter_bus_type();
		logger.info("One of the Bus type filter is applied.");
		String msg_exp_1 = search.bus_type_text();
		String msg_actual_1 = prop.getProperty("bus_type_filter");
		Assert.assertEquals(msg_actual_1, msg_exp_1);
		logger.info("Bus type filter applied is :- " + msg_exp_1);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test
	public void ArrivalTime_filter() throws InterruptedException {

		SearchBus_redbus search = new SearchBus_redbus(driver);
		search_bus();
		search.filter_arrival_time();
		logger.info("One of the arrival time filter is applied.");
		String msg_exp_1 = search.arrival_text();
		String msg_actual_1 = prop.getProperty("arrival_time_filter");
		Assert.assertEquals(msg_actual_1, msg_exp_1);
		logger.info("Arrival time filter applied is :- " + msg_exp_1);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test
	public void BoardingPoint_filter() throws InterruptedException {
		SearchBus_redbus search = new SearchBus_redbus(driver);
		search_bus();
		search.filter_boarding_Point();
		logger.info("One of the boarding point filter is applied.");
		String msg_exp_1 = search.boarding_point_text();
		String msg_actual_1 = prop.getProperty("boarding_point_filter");
		Assert.assertEquals(msg_actual_1, msg_exp_1);
		logger.info("Boarding point filter applied is :- " + msg_exp_1);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test
	public void DroppiongPoint_filter() throws InterruptedException {

		SearchBus_redbus search = new SearchBus_redbus(driver);
		search_bus();
		search.filter_Drop_location();
		logger.info("One of the dropping point filter is applied.");
		String msg_exp_1 = search.Drop_text();
		String msg_actual_1 = prop.getProperty("dropping_point_filter");
		Assert.assertEquals(msg_actual_1, msg_exp_1);
		logger.info("Droping point filter applied is :- " + msg_exp_1);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test
	public void Modify_date() throws InterruptedException {

		SearchBus_redbus search = new SearchBus_redbus(driver);
		search_bus();
		search.Update_Ride();
		logger.info("We have updated the date of travel.");
		search.Search_update();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test
	public void Modify_Destination() throws InterruptedException {

		SearchBus_redbus search = new SearchBus_redbus(driver);
		search_bus();
		HashMap<String, String> data = new HashMap<String, String>();
		String Testcase = "Modify Place";
		data = reader.getRowTestData(sheetName, Testcase);
		String executionRequired = data.get("Execution Required").toLowerCase();
		Utils.toCheckExecutionRequired(executionRequired);

		String place = data.get("New Dest");
		search.Update_destination_place(place);
		logger.info("We have updated the destination");
		search.Search_update();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test
	public void Modify_Swipe_places() throws InterruptedException {

		SearchBus_redbus search = new SearchBus_redbus(driver);
		search_bus();
		search.swipe_function();
		logger.info("We have swiped the destination and source place.");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test
	public void Modify_empty_Field_Verification() throws InterruptedException {
		SearchBus_redbus search = new SearchBus_redbus(driver);
		search_bus();
		search.empty_source_and_dest();
		String msg_1 = search.error_dest_empty_msg();
		String msg_2 = search.error_src_empty_msg();
		logger.info("Error msg says that :- " + msg_2);
		logger.info("Error msg says that :- " + msg_1);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

}
