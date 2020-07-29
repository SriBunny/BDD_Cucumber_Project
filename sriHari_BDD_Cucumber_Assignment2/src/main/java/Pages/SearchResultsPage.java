package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BasePage;

public class SearchResultsPage extends BasePage{
	WebDriver dr;
	
	public SearchResultsPage(WebDriver executor) {
		this.dr = executor;
		PageFactory.initElements(executor, this);
	}

	public void search_for_the_cheapest_flight() 
	{
		try
		{
			//Searching for flight
			WebElement search=dr.findElement(By.id("gi_search_btn"));
			System.out.println("Search button is visible......");
			search.click();
			System.out.println("Search button has been clicked......");

		}
		catch(Throwable e)
		{
			System.out.println("Element Not Found"  +e.getMessage());
		}
	}

	public void click_on_book_now() 
	{
		try
		{
			//Clicking on book now button
			WebDriverWait wait = new WebDriverWait(dr,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='button']")));
			List<WebElement> a=dr.findElements(By.cssSelector("input[type='button']"));
			System.out.println("Book now buttons are visible......");
			a.get(0).click();
			System.out.println("Cheapest flight has been booked......");
		}
		catch(Throwable e)
		{
			System.out.println("Element Not Found"  +e.getMessage());
		}
	}

	public String getfTime() 
	{
		String text=null;
		try
		{
			text=dr.findElement(By.xpath("(//span[@data-cy='depTime'])[1]")).getText();
		}
		catch(Throwable e)
		{
			System.out.println("Element Not Found"  +e.getMessage());
		}
		return text;
	}
	
	public String gettTime() 
	{
		String text=null;
		try
		{
			text=dr.findElement(By.xpath("(//span[@data-cy='arrTime'])[1]")).getText();
		}
		catch(Throwable e)
		{
			System.out.println("Element Not Found"  +e.getMessage());
		}
		return text;
	}

	public String getfTimer() {
		String text=null;
		try
		{
			dr.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			text=dr.findElement(By.xpath("(//span[@data-cy='depTime'])[1]")).getText();
		}
		catch(Throwable e)
		{
			System.out.println("Element Not Found"  +e.getMessage());
		}
		return text;
	}
	
	public String gettTimer() {
		String text=null;
		try
		{
			text=dr.findElement(By.xpath("(//span[@data-cy='arrTime'])[1]")).getText();
		}
		catch(Throwable e)
		{
			System.out.println("Element Not Found"  +e.getMessage());
		}
		return text;
	}
	
	public String getfTimerreturn() {
		String text=null;
		try
		{
			dr.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			text=dr.findElement(By.xpath("(//span[@class='fb ico16 quicks'])[1]")).getText();
		}
		catch(Throwable e)
		{
			System.out.println("Element Not Found"  +e.getMessage());
		}
		return text;
	}

	public String gettTimerreturn() {
		String text=null;
		try
		{
			text=dr.findElement(By.xpath("(//span[@class='fb ico16 quicks'])[2]")).getText();
		}
		catch(Throwable e)
		{
			System.out.println("Element Not Found"  +e.getMessage());
		}
		return text;
	}
	public String getreturnfTimer() {
		String text=null;
		try
		{
			text=dr.findElement(By.xpath("(//span[@class='fb ico16 quicks'])[3]")).getText();
		}
		catch(Throwable e)
		{
			System.out.println("Element Not Found"  +e.getMessage());
		}
		return text;
	}
	public String getreturntTimer() {
		String text=null;
		try
		{
			text=dr.findElement(By.xpath("(//span[@class='fb ico16 quicks'])[4]")).getText();
		}
		catch(Throwable e)
		{
			System.out.println("Element Not Found"  +e.getMessage());
		}
		return text;
	}
	
}