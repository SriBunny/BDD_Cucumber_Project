package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class HomePage extends BasePage {

	WebDriver dr;

	String MonthToBeSelected = "August 2020";
	String DAY = "10";

	public HomePage(WebDriver executor) {
		this.dr = executor;
		PageFactory.initElements(executor, this);
	}

	public void select_one_way_trip() {
		// Selecting one way trip
		try {
			WebElement round = dr.findElement(By.id("roundTrip"));
			round.click();
			WebElement one = dr.findElement(By.id("oneway"));
			one.click();
			System.out.println("One way button is selected......");
		} catch (Throwable e) {
			System.out.println("Element Not Found" + e.getMessage());
		}
	}

	public void select_round_trip() {
		// Selecting two way trip
		try {
			WebElement round = dr.findElement(By.id("roundTrip"));
			round.click();
			System.out.println("round trip button is selected......");
		} catch (Throwable e) {
			System.out.println("Element Not Found" + e.getMessage());
		}
	}

	public void select_from_as_and_destination_as(String fromCity, String toCity) {
		try {
			// Selecting from
			WebElement from = dr.findElement(By.id("gosuggest_inputSrc"));
			System.out.println("From city field is visible......");
			from.sendKeys(fromCity);
			Thread.sleep(3000);
			from.sendKeys(Keys.ARROW_DOWN);
			from.sendKeys(Keys.ENTER);
			System.out.println("From city name has been entered......");
			// Selecting destination
			WebElement to = dr.findElement(By.id("gosuggest_inputDest"));
			System.out.println("To city field is visible......");
			to.sendKeys(toCity);
			Thread.sleep(3000);
			to.sendKeys(Keys.ARROW_DOWN);
			to.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			System.out.println("To city name has been entered......");
		} catch (Throwable e) {
			System.out.println("Element Not Found" + e.getMessage());
		}
	}

	public void select_the_departure_date() {
		try {
			// Selecting departure date
			WebElement dd = dr.findElement(By.id("departureCalendar"));
			System.out.println("Departure date picker is visible......");
			dd.click();
			// Logic for Expected Date Picker
			while (true) {
				String monthOnPage = dr.findElement(By.xpath("//div[@class='DayPicker-Caption' and @role='heading']"))
						.getText();
				if (monthOnPage.equals(MonthToBeSelected)) {
					break;
				} else {
					dr.findElement(By
							.xpath("//span[@role='button' and @class='DayPicker-NavButton DayPicker-NavButton--next']"))
							.click();
				}
			}
			System.out.println("Choosing the departure date......");
			dr.findElement(
					By.xpath("//div[@class='DayPicker-Week']/div[@class='DayPicker-Day']/div[text()=" + DAY + "]"))
					.click();

		}

		catch (Throwable e) {
			System.out.println("Element Not Found" + e.getMessage());
		}
	}

	public void select_the_traveller_details() {
		try {

			// Counting the travellers
			WebElement traveller = dr.findElement(By.id("pax_label"));
			System.out.println("Travellers button is visible......");
			traveller.click();
			System.out.println("Travellers button has beenclicked......  ");
			WebElement adult = dr.findElement(By.id("adultPaxBox"));
			System.out.println("Adult field is visible......");
			adult.clear();
			System.out.println("Entering the number of adult travellers......");
			adult.sendKeys("2");
			WebElement child = dr.findElement(By.id("childPaxBox"));
			System.out.println("Child field is visible......");
			child.clear();
			System.out.println("Entering the number of child travellers......");
			child.sendKeys("1");
			WebElement close = dr.findElement(By.id("pax_close"));
			System.out.println("Clicking the close sign......");
			close.click();
		} catch (Throwable e) {
			System.out.println("Element Not Found" + e.getMessage());
		}

	}

}