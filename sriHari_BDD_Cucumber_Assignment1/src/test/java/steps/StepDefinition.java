package steps;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class StepDefinition {

	protected static Logger log = logs.getLogger(logs.class);

	static WebDriver driver1;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public void setChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver1 = new ChromeDriver();
		driver.set(driver1);
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver1.manage().window().maximize();
		log.info("Chrome browser started.");
	}

	public void setfDriver() {

		System.setProperty("webdriver.gecko.driver", "Driver/geckodriver.exe");
		driver1 = new FirefoxDriver();
		driver.set(driver1);
		driver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver().manage().window().maximize();
		log.info("Firefox browser started.");
	}

	public WebDriver driver() {
		return driver.get();
	}

	@Before
	public void doSomethingBefor() throws Exception {
		log.info("Scenario started.");
	}

	@Given("Open {string}")
	public void open(String string) {
		System.out.println(string);
		if (string.equalsIgnoreCase("chrome")) {
			setChromeDriver();
			// driver().close();
		}

		else {
			setfDriver();
			// driver().close();
		}
	}

	public static String mailid = "";

	@When("Gillette India create account")
	public void gillette_india_create_account() throws InterruptedException {
		driver().get("https://www.gillette.co.in/en-in");
		Thread.sleep(5000);
		log.info("gillette india website got launched.");
		driver().findElement(By.xpath("//a[@title=\"REGISTER\"]")).click();
		log.info("Register button is clicked.");
		driver().findElement(By.xpath("//input[@data-key=\"firstName\"]")).sendKeys("Test");
		driver().findElement(By.xpath("//input[@data-key=\"lastName\"]")).sendKeys("Engineer");
		log.info("First name and last name are entered.");
		Random rand = new Random(); // instance of random class
		int upperbound = 1000;
		int generatedString = rand.nextInt(upperbound);
		mailid = "Test" + generatedString + "@gmail.com";

		driver().findElement(By.xpath("//input[@data-key=\"emailAddress\"]")).sendKeys(mailid);
		log.info("Email address is entered.");
		driver().findElement(By.xpath("//input[@data-key=\"newPassword\"]")).sendKeys("Test@123");
		driver().findElement(By.xpath("//input[@id=\"phdesktopbody_0_grs_account[password][confirm]\"]"))
				.sendKeys("Test@123");
		driver().findElement(By.xpath("//select[@data-key=\"birthdate[dateselect_month]\"]")).click();
		driver().findElement(By.xpath("//select[@data-key=\"birthdate[dateselect_month]\"]/option[@value=\"03\"]"))
				.click();

		driver().findElement(By.xpath("//select[@data-key=\"birthdate[dateselect_year]\"]")).click();
		driver().findElement(By.xpath("//select[@data-key=\"birthdate[dateselect_year]\"]/option[@value=\"1996\"]"))
				.click();
		driver().findElement(By.xpath("//input[@data-key=\"addressPostalCode\"]")).sendKeys("638402");
		driver().findElement(By.xpath("//input[@id=\"phdesktopbody_0_submit\"]")).click();
		
		log.info("Entered password and DOB and submitted.");
		Thread.sleep(5000);
	}

	@When("Sign in and Sign out")
	public void sign_in_and_sign_out() throws InterruptedException {
		driver().findElement(By.xpath("//input[@data-key=\"signInEmailAddress\"]")).sendKeys(mailid);
		log.info("Email address is entered.");
		driver().findElement(By.xpath("//input[@data-key=\"currentPassword\"]")).sendKeys("Test@123");
		log.info("Password is entered.");
		driver().findElement(By.xpath("//input[@value=\"Sign In\"]")).click();
		log.info("Sign in is clicked.");
		Thread.sleep(5000);

		driver().findElement(By.xpath("//a[@title=\"log out\"]")).click();
		driver().findElement(By.xpath("//a[@title=\"LOG OUT\"]")).click();
		log.info("Log out is done.");
	}

	@When("forgot passwprd")
	public void forgot_passwprd() {
		driver().findElement(By.xpath("//a[@title=\"password?\"]")).click();

		driver().findElement(By.xpath("//input[@data-key=\"signInEmailAddress\"]")).sendKeys(mailid);
		driver().findElement(By.xpath("//input[@value=\"Create Your New Password\"]")).click();
		log.info("Forgot password scenario.");
	}

	@Then("Verify gillette india")
	public void verify_gillette_india() {
		driver().findElement(By.xpath("//div[@id=\"phdesktopbody_0_afterSubmit\"]/div/h1")).getText();
		assertEquals("THANK YOU!",
				driver().findElement(By.xpath("//div[@id=\"phdesktopbody_0_afterSubmit\"]/div/h1")).getText());
		log.info("Verify Thanks message.");
	}

	@When("Gillette German create account")
	public void gillette_german_create_account() throws InterruptedException {
		driver().get("https://www.gillette.de/");
		Thread.sleep(5000);

		driver().findElement(By.xpath("//a[@class=\"responsiveAccountHeader_openAccountButton\"]")).click();
		// driver().findElement(By.xpath("//a[@class=\"responsiveAccountHeader_accountLogin
		// js-e2e-sign-in\"]")).click();
		driver().findElement(By.xpath("//button[@class=\"accountLogin_newAccountButton\"]")).click();

		driver().findElement(By.xpath("//input[@id=\"customerName\"]")).sendKeys("Test Engineer");
		;

		Random rand = new Random(); // instance of random class
		int upperbound = 1000;
		int generatedString = rand.nextInt(upperbound);
		mailid = "Test" + generatedString + "@gmail.com";

		driver().findElement(By.xpath("//input[@id=\"customerEmail\"]")).sendKeys(mailid);
		driver().findElement(By.xpath("//input[@id=\"confirmCustomerEmail\"]")).sendKeys(mailid);

		driver().findElement(By.xpath("//input[@id=\"customerPassword\"]")).sendKeys("Test@123");
		driver().findElement(By.xpath("//input[@id=\"confirmPassword\"]")).sendKeys("Test@123");
		JavascriptExecutor jse = (JavascriptExecutor) driver();
		jse.executeScript("window.scrollBy(0,400)");
		// jse.executeScript("arguments[0].scrollIntoView(true);",driver().findElement(By.xpath("//label[@class=\"accountSignUp_optOutLabel_RadioButtons\"]")));
		driver().findElement(By.xpath("//label[@class=\"accountSignUp_optOutLabel_RadioButtons\"]")).click();

		jse.executeScript("window.scrollBy(0,300)");
		driver().findElement(By.xpath("//button[@id=\"continue\"]")).click();
		log.info("German create account scnario.");

	}

	@When("Sign in and Sign out - German")
	public void sign_in_and_sign_out_german() {
		driver().findElement(By.xpath("//button[@class=\"myAccount_logOutButton js-tag-sign-out\"]")).click();
		// driver().findElement(By.xpath("//button[@title=\"Account menu\"]")).click();
		// driver().findElement(By.xpath("//a[@class=\"responsiveAccountHeader_accountLogin
		// js-e2e-sign-in\"]")).click();
		driver().findElement(By.xpath("//a[@class=\"responsiveAccountHeader_openAccountButton\"]")).click();

		driver().findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(mailid);
		driver().findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("Test@123");
		driver().findElement(By.xpath("//button[@id=\"login-submit\"]")).click();

		driver().findElement(By.xpath("//button[@class=\"myAccount_logOutButton js-tag-sign-out\"]")).click();
		log.info("German sign in scenario.");
	}

	@When("forgot passwprd - German")
	public void forgot_passwprd_german() throws InterruptedException {
		driver().findElement(By.xpath("//a[@class=\"responsiveAccountHeader_openAccountButton\"]")).click();

		driver().findElement(By.xpath("//button[@class=\"forgottenPasswordModal_trigger\"]")).click();
		driver().findElement(By.xpath("//input[@id=\"forgotten-password-email-field\"]")).sendKeys(mailid);
		driver().findElement(By.xpath("//input[@value=\"PASSWORT ZURÜCKSETZEN\"]")).click();

		// p[contains(.,"Anweisung zur Zurücksetzung deines Passwortes wurden an die
		// folgende Adresse gesendet")]
		Thread.sleep(5000);
		log.info("German forgot password scenario.");
	}

	@Then("Verify gillette - German")
	public void verify_gillette_german() {
		assertTrue(driver().findElement(By.xpath("//p[contains(.,\"Anweisung \")]")).isDisplayed());
		assertEquals(mailid, driver()
				.findElement(By.xpath("//span[@class=\"forgottenPasswordModal_dialog_success_email\"]")).getText());
		log.info("Verify thanks you message for german scenario.");
	}

	@When("Gillette France create account")
	public void gillette_france_create_account() throws InterruptedException {
		// Account creation
		driver().get("https://www.gillette.fr/");
		Thread.sleep(5000);

		driver().findElement(By.xpath("//a[@data-action-detail=\"Mon compte\"]")).click();

		Random rand = new Random(); // instance of random class
		int upperbound = 1000;
		int generatedString = rand.nextInt(upperbound);
		mailid = "Test" + generatedString + "@gmail.com";

		driver().findElement(By.xpath("//input[@id=\"email_create\"]")).sendKeys(mailid);

		driver().findElement(By.xpath("//button[@id=\"SubmitCreate\"]")).click();

		driver().findElement(By.xpath("//input[@id=\"customer_firstname\"]")).sendKeys("Test");
		;

		driver().findElement(By.xpath("//input[@id=\"customer_lastname\"]")).sendKeys("Engineer");
		;

		driver().findElement(By.xpath("//input[@id=\"email\"]")).sendKeys(mailid);

		driver().findElement(By.xpath("//input[@id=\"passwd\"]")).sendKeys("Test@123");

		JavascriptExecutor jse = (JavascriptExecutor) driver();
		jse.executeScript("window.scrollBy(0,100)");

		driver().findElement(By.xpath("//select[@id=\"years\"]")).click();

		driver().findElement(By.xpath("//select[@id=\"years\"]/option[@value=\"1996\"]")).click();

		driver().findElement(By.xpath("//select[@id=\"months\"]")).click();

		driver().findElement(By.xpath("//select[@id=\"months\"]/option[@value=\"3\"]")).click();

		driver().findElement(By.xpath("//select[@id=\"days\"]")).click();

		driver().findElement(By.xpath("//select[@id=\"days\"]/option[@value=\"5\"]")).click();

		jse.executeScript("window.scrollBy(0,300)");

		driver().findElement(By.xpath("//div[@id=\"uniform-newsletter\"]")).click();

		jse.executeScript("window.scrollBy(0,400)");
		log.info("France create account scenario.");
	}

	@After
	public void doSomethingAfter() throws Exception {
		log.info("Scenario completed.");
		driver().quit();
	}
}