package Step;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Util.Lib;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class GUIstepDefinition extends Lib {
	WebDriver driver;

	@Before
	public void initialize() {
		System.setProperty("WebDriver.Chrome.driver",
				"C:\\Users\\syful\\eclipse-workspace2\\BootCamp\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Given("^user is at united airlines homepage \"([^\"]*)\"$")
	public void united(String homepage) {
		driver.get(homepage);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@When("^user selects \"([^\"]*)\"$")
	public void steptwo(String oneway) throws IOException {
		driver.findElement(By.xpath(readproperties(driver, oneway))).click();
	}

	@And("^user enters location \"([^\"]*)\" \"([^\"]*)\"$")
	public void stepthree(String from, String city) throws IOException, InterruptedException {
		driver.findElement(By.xpath(readproperties(driver, from))).sendKeys(city);
		sleep(driver, 3);

	}

	@And("^user enters \"([^\"]*)\"$")
	public void stepfour(String city1) throws IOException, InterruptedException {
		driver.findElement(By.xpath(readproperties(driver, city1))).click();
		sleep(driver, 3);

	}

	@And("^user clicks \"([^\"]*)\"$")
	public void search(String findflights) throws IOException {
		driver.findElement(By.xpath(readproperties(driver, findflights))).click();
	}

	@And("^user waits 5 seconds$")
	public void searchwait() throws InterruptedException {
		sleep(driver, 5);
	}

	@And("^user is on the search result page$")
	public void searchpage() {
		System.out.println(driver.getTitle());
	}

	// reserved for printing results
	@And("^user prints the results$")
	public void result() {
		String united1 = driver.findElement(By.xpath("//*[@id=\"sr_product_ECONOMY-FLEXIBLE_291-3884-UA\"]/div/div[2]"))
				.getText();
		String united2 = driver.findElement(By.xpath("//*[@id=\"sr_product_ECONOMY-FLEXIBLE_291-4840-UA\"]/div/div[2]"))
				.getText();
		String united3 = driver.findElement(By.xpath("//*[@id=\"sr_product_ECONOMY-FLEXIBLE_291-3879-UA\"]/div/div[2]"))
				.getText();
		String united4 = driver.findElement(By.xpath("//*[@id=\"sr_product_ECONOMY-FLEXIBLE_291-3786-UA\"]/div/div[2]"))
				.getText();
		System.out.println(united1);
		System.out.println(united2);
		System.out.println(united3);
		System.out.println(united4);
		
	}

	@And("^user navigates to \"([^\"]*)\"$")
	public void navigate(String american) {
		driver.navigate().to(american);
	}

	@And("^user clears \"([^\"]*)\"$")
	public void newstep(String clearfield) throws IOException {
		driver.findElement(By.xpath(readproperties(driver, clearfield))).clear();
	}

	@And("^user enters key down to select PHL at \"([^\"]*)\"$")
	public void keydown(String from) throws IOException {
		driver.findElement(By.xpath(readproperties(driver, from))).sendKeys(Keys.DOWN);

	}

	@And("^user enters key down to select IAD at \"([^\"]*)\"$")
	public void keydown2(String to) throws IOException {
		driver.findElement(By.xpath(readproperties(driver, to))).sendKeys(Keys.DOWN);
	}

	@And("^user selects 2 \"([^\"]*)\"$")
	public void passengers(String aapass) throws IOException {
		Select sl = new Select(driver.findElement(By.xpath(readproperties(driver, aapass))));
		sl.selectByVisibleText("2");
	}

	@And("^user compares prices from both airlines$")
	public void compare() {

	}

	@After
	public void teardown() {
//		driver.manage().deleteAllCookies();
//		driver.close();
	}

}
