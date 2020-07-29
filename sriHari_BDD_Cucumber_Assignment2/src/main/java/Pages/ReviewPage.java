package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class ReviewPage extends BasePage{
	WebDriver dr;
	public ReviewPage(WebDriver executor) {
		this.dr = executor;
		PageFactory.initElements(executor, this);
	}
	public void review_the_selection_in_the_review(String f, String t) 
	{
	
		try {
			
			//Going to the review page
			for(String winHandle : dr.getWindowHandles())
			{
				dr.switchTo().window(winHandle);
			}
			
			dr.findElement(By.xpath("//span[@class='db' and contains(text(),'Hyderabad')]")).isDisplayed();
			dr.findElement(By.xpath("//span[@class='db' and contains(text(),'Bengaluru')]")).isDisplayed();
			
			int count = dr.findElements(By.xpath("//span[@class='fb mobdb']")).size();
			
			String temp= dr.findElement(By.xpath("(//span[@class='fb mobdb'])[1]")).getText();
			if(temp.equalsIgnoreCase(f)) {
				System.out.println("Start time is same "+temp);
			}
			String temp1= dr.findElement(By.xpath("(//span[@class='fb mobdb'])["+count+"]")).getText();
			if(temp1.equalsIgnoreCase(t)) {
				System.out.println("Start time is same "+t);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void review_the_selection_in_the_review(String ftym, String ttym, String returnf, String returnt) {
		try {
			
			//Going to the review page
			for(String winHandle : dr.getWindowHandles())
			{
				dr.switchTo().window(winHandle);
			}
			
			dr.findElement(By.xpath("(//span[@class='db' and contains(text(),'Hyderabad')])[1]")).isDisplayed();
			dr.findElement(By.xpath("(//span[@class='db' and contains(text(),'Bengaluru')])[1]")).isDisplayed();
			
			int count = dr.findElements(By.xpath("//span[@class='fb mobdb']")).size();
			
			String temp= dr.findElement(By.xpath("(//span[@class='fb mobdb'])[1]")).getText();
			if(temp.equalsIgnoreCase(ftym)) {
				System.out.println("Start time is same "+ftym);
			}
			String temp1= dr.findElement(By.xpath("(//span[@class='fb mobdb'])[4]")).getText();
			if(temp1.equalsIgnoreCase(ttym)) {
				System.out.println("Start time is same "+ttym);
			}
			String temp2= dr.findElement(By.xpath("(//span[@class='fb mobdb'])[5]")).getText();
			if(temp2.equalsIgnoreCase(returnf)) {
				System.out.println("Start time is same "+returnf);
			}
			String temp3= dr.findElement(By.xpath("(//span[@class='fb mobdb'])["+count+"]")).getText();
			if(temp3.equalsIgnoreCase(returnt)) {
				System.out.println("Start time is same "+returnf);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
}