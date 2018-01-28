package stepsFile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SearchCareers {
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\CareersWraper\\src\\test\\resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();			
	}
	
	@After
	public void Cleaner() throws InterruptedException {
		try { Thread.sleep(2000);}
		catch (InterruptedException e) {}
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
		this.driver = null;
	}
	
	@Given("^User opens Avanade website$")
	public void user_opens_Avanade_website() throws Throwable {		
		String avanadeHomePage = "https://www.avanade.com/";
		driver.navigate().to(avanadeHomePage);
		Assert.assertEquals("Business Technology Solutions & Managed Services - Avanade", driver.getTitle());
	}

	@And("^User navigate to the /CAREERS/ and opens /ROLES AND LOCATIONS/$")
	public void user_navigate_to_the_CAREERS_and_opens_ROLES_AND_LOCATIONS() throws Throwable {
		String careersLocation = "//*[@id=\"main-navbar\"]/ul[1]/li[5]/a[1]";
		WebElement menu = driver.findElement(By.xpath(careersLocation));		
		Actions actions = new Actions(driver);
		actions.moveToElement(menu).perform();
		driver.findElement(By.linkText("Roles and Locations")).click();					
	}		

	@When("^User chooses /All Locations/ from /Countries/ drop-down menu$")
	public void user_chooses_All_Locations_from_Countries_drop_down_menu() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		try { Thread.sleep(2000);}
		catch (InterruptedException e) {}
		String countriesLocation = "//*[@id=\"countries\"]";
		WebElement location = driver.findElement(By.xpath(countriesLocation));
		location.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(location).perform();
		String locationApproval = "//*[@id=\"11111111-1111-1111-1111-111111111111\"]"; 
		driver.findElement(By.xpath(locationApproval)).click();					
	}	

	@And("^User clicks on /Search/ button$")
	public void user_clicks_on_Search_button() throws Throwable {	
		String searchButtonLocation = "//*[@id=\"jobsearchclick\"]";
		WebElement searchButton = driver.findElement(By.xpath(searchButtonLocation));
		searchButton.click();
		try { Thread.sleep(2000);}
		catch (InterruptedException e) {}
	}
	
	@And("^User enters /Krakow/ in /SearchBox/ field$")
	public void user_enters_Krakow_in_SearchBox_field() throws Throwable {
		String searchBoxLocation = "//*[@id=\"page\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/input";
		WebElement searchBox = driver.findElement(By.xpath(searchBoxLocation));
		searchBox.clear();
		String location = "Krakow";
		searchBox.sendKeys(location);
		try { Thread.sleep(2000);}
		catch (InterruptedException e) {}
	}

	@Then("^User checks if there is more than /5/ results for location Krakow$")
	public void user_checks_if_there_is_more_than_results_for_location_Krakow() throws Throwable {		
		String resultsLocation = "//*[@id=\"page\"]/div/div[2]/div[2]/div[3]/span[2]/div[1]/span/span[2]";
		String results = driver.findElement(By.xpath(resultsLocation)).getText();
		String resultsNumber = results.substring(0, results.length()-8);
		int actualNumber = Integer.parseInt(resultsNumber);
		int expectedNumber = 5;
		Assert.assertFalse(actualNumber > expectedNumber);
		try { Thread.sleep(2000);}
		catch (InterruptedException e) {}
	}
	
	@And("^User enters /Warsaw/ in /SearchBox/ field$")
	public void user_enters_Warsaw_in_SearchBox_field() throws Throwable {
		String searchBoxLocation = "//*[@id=\"page\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/input";
		WebElement searchBox = driver.findElement(By.xpath(searchBoxLocation));
		searchBox.clear();
		String location = "Warsaw";
		searchBox.sendKeys(location);
		try { Thread.sleep(2000);}
		catch (InterruptedException e) {}
	}

	@Then("^User checks if there is at least /1/ result for location Warsaw$")
	public void user_checks_if_there_is_at_least_result_for_location_Warsaw() throws Throwable {
		String resultsLocation = "//*[@id=\"page\"]/div/div[2]/div[2]/div[3]/span[2]/div[1]/span/span[2]";
		String results = driver.findElement(By.xpath(resultsLocation)).getText();
		String resultsNumber = results.substring(0, results.length()-8);
		int actualNumber = Integer.parseInt(resultsNumber);
		int expectedNumber = 1;		
		Assert.assertTrue(actualNumber >= expectedNumber);			    
	}
	
	@And("^User enters sentence: /entry level/ in /SearchBox/ field$")
	public void user_enters_sentence_entry_level_in_SearchBox_field() throws Throwable {
		
		WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"page\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/input"));
		searchBox.clear();
		String keyWords = "entry level";
		searchBox.sendKeys(keyWords);
		try { Thread.sleep(2000);}
		catch (InterruptedException e) {}
	}

	@And("^User checks if on of results is position /Entry Level Software Engineer, Seattle/$")
	public void user_checks_if_on_of_results_is_position_Entry_Level_Software_Engineer_Seattle() throws Throwable {
		String position = "Entry Level Software Engineer, Seattle";
		WebElement positionLocation = driver.findElement(By.linkText(position));
		positionLocation.click();	    
	}

	@Then("^User open job offer and checks if one of the qualifications is /Strong time management skills/$")
	public void user_open_job_offer_and_checks_if_one_of_the_qualifications_is_Strong_time_management_skills() throws Throwable {
		String skills = "Strong time management skills";
		WebElement skillsLocation = driver.findElement(By.xpath("//*[contains(text(),'" + skills + "')]"));
		Assert.assertEquals(true, skillsLocation.isDisplayed());
	}	
}
