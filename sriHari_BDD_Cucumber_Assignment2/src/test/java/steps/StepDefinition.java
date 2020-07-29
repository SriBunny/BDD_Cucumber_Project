package steps;

import org.openqa.selenium.WebDriver;

import Base.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class StepDefinition extends BasePage {
	
	WebDriver driver=null;
	String ftym,ttym,returnf,returnt=null;
	
	@Given("I launch goibibo site")
	public void i_launch_goibibo_site() {
		driver=BasePage.setExecution();
	}

	@When("I enter {string} and {string} places")
	public void i_enter_and_places(String string, String string2) {
		
		HOMEPAGE.select_one_way_trip();
		log.info("One way trip got selected.");
		HOMEPAGE.select_from_as_and_destination_as(string, string2);
		log.info("From and to places are entered.");
		
	}

	@Then("I enter round trip")
	public void i_enter_round_trip() {
		
		HOMEPAGE.select_round_trip();
		log.info("Round trip got selected.");
		
	}
	
	@When("Enter {string} and {string} places")
	public void enter_and_places(String string, String string2){
		
		HOMEPAGE.select_from_as_and_destination_as(string, string2);
		log.info("From and to places are entered.");
		
	}
	
	@And("I enter departure date and passesnger details")
	public void i_enter_departure_date_and_passesnger_details() {
		
		HOMEPAGE.select_the_departure_date();
		log.info("Departure date is entered.");
		HOMEPAGE.select_the_traveller_details();
		log.info("Traveller details are entered.");
		
	}

	@And("I verify for price up arrow and get the flight details")
	public void i_verify_for_price_up_arrow_and_get_the_flight_details() throws InterruptedException {
		
		log.info("Search button is clicked.");
		SEARCH.search_for_the_cheapest_flight();
		log.info("Searching for cheapest flight.");
		Thread.sleep(20000);
		ftym=SEARCH.getfTimer();
		ttym=SEARCH.gettTimer();
	}

	@And("I verify for price up arrow and get the flight details return")
	public void i_verify_for_price_up_arrow_and_get_the_flight_details_return() throws InterruptedException {
		
		log.info("Search button is clicked.");
		SEARCH.search_for_the_cheapest_flight();
		log.info("Searching for cheapest flight.");
		Thread.sleep(20000);
		ftym=SEARCH.getfTimerreturn();
		ttym=SEARCH.gettTimerreturn();
		returnf=SEARCH.getreturnfTimer();
		returnt=SEARCH.getreturntTimer();
		
	}
	
	@And("I enter book button")
	public void i_enter_book_button() throws InterruptedException {
	
		SEARCH.click_on_book_now();
		log.info("Book now button is clicked.");
		Thread.sleep(30000);
		
	}

	@And("I veriy the filght details in review page and search results page are same return.")
	public void i_veriy_the_filght_details_in_review_page_and_search_results_page_are_same_return() {
		
		REVIEW.review_the_selection_in_the_review(ftym,ttym,returnf,returnt);
		log.info("The flight details are same as in search page.");
		
	}
	
	@And("I veriy the filght details in review page and search results page are same.")
	public void i_veriy_the_filght_details_in_review_page_and_search_results_page_are_same() {
	
		REVIEW.review_the_selection_in_the_review(ftym,ttym);
		log.info("The flight details are same as in search page.");
		
	}
	
	@After
	public void doSomethingAfter() throws Exception {
		driver.quit();
	}
}