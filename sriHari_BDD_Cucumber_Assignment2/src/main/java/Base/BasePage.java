package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.*;

public class BasePage {

	public static String configFile;
	public static String repoFile;
	public static String configFile1 = "src/main/java/config/config.properties";
	public String repoFile1 = "src/main/java/Base/Repository.properties";
	public static String driverPath = "";
	static WebDriver executor = null;
	public static HomePage HOMEPAGE = null;
	public static ReviewPage REVIEW = null;
	public static SearchResultsPage SEARCH = null;

	protected static Logger log = logs.getLogger(logs.class);
	
	public BasePage() {
		if (System.getProperty("user.dir").toString().contains("sriHari_BDD_Cucumber_Assignment2")) {
			configFile = System.getProperty("user.dir") + File.separator
					+configFile1;
			repoFile = System.getProperty("user.dir") + File.separator
					+ repoFile1;
			driverPath = System.getProperty("user.dir") + File.separator + "driver/";
		} else {
			configFile = System.getProperty("user.dir") + File.separator + "sriHari_BDD_Cucumber_Assignment2" + File.separator
					+ configFile1;
			repoFile = System.getProperty("user.dir") + File.separator + "sriHari_BDD_Cucumber_Assignment2" + File.separator
					+ repoFile1;
			driverPath = System.getProperty("user.dir") + File.separator + "sriHari_BDD_Cucumber_Assignment2" + File.separator
					+ "driver/";
		}
	}

	public static String getProperty(String fileName, String Key) {
		String result = "";
		try {
			Properties prop = new Properties();
			InputStream inputStream = new FileInputStream(fileName);
			prop.load(inputStream);
			result = prop.getProperty(Key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void quit() {
		executor.quit();
	}
	
	public static WebDriver setExecution() {
		try {
			String browser = getProperty(configFile, "browser");
			String url = getProperty(configFile, "url");

			if (browser.equalsIgnoreCase("chrome")) {
				System.out.println("Launching the chrome driver.......");
				System.setProperty("webdriver.chrome.driver", driverPath + File.separator + "chromedriver.exe");
				executor = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.out.println("Launching the firefox driver.......");
				System.setProperty("webdriver.gecko.driver", driverPath + File.separator + "geckodriver.exe");
				executor = new FirefoxDriver();
			}
			log.info("Browser got launched.");
			executor.manage().deleteAllCookies();
			executor.manage().window().maximize();
			executor.get(url);
			log.info("User navigated to "+url);
			HOMEPAGE=new HomePage(executor);
			REVIEW=new ReviewPage(executor);
			SEARCH=new SearchResultsPage(executor);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return executor;
	}

	public static WebDriver getDriver() {
		return BasePage.executor;
	}
}