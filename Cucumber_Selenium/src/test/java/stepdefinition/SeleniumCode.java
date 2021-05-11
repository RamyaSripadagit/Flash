package stepdefinition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import org.junit.experimental.categories.CategoryValidator;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;

import ObjectRepo.ObjectRepo;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/javaFeatures", glue = { "seleniumgluecode" })

public class SeleniumCode {
	WebDriver driver = null;

	@Given("^User Navigate to values Page$")
	public void userNavigateValuesPage() throws Throwable {

		// please note dummy chrome driver path

		System.setProperty("webdriver.chrome.driver", "/lib/chromeDriver/chromedriver.exe");

		// Instantiating driver object
		driver = new ChromeDriver();

		// Using get() method to open a webpage
		driver.get("https://www.exercise1.com/values ");
		assertTrue("Browser launched with values page", true);
	}

	@Then("^User verify the right count values appear on the screen$")
	public void rightCountValuesAppearOnScreen() throws Throwable {

		ObjectRepo or = new ObjectRepo();
		;
		String txt_val = or.xpathtxt_val;
		List<WebElement> rightCountVal = driver.findElements(By.xpath(txt_val));
		int i = rightCountVal.size();

		testdataRead td = new testdataRead();
		String totalValueCount = td.totalValueCount;
		if (totalValueCount.equals("i")) {

			assertTrue("right count of value on the screen is as expected", true);
		} else {
			assertFalse("value count not matches with actual and expected", false);
		}
		for (int j = 0; j < rightCountVal.size(); j++) {
			String valueRightside = rightCountVal.get(j).getText();
			String value1 = td.values_1;
			String value2 = td.values_2;
			String value3 = td.values_3;
			String value4 = td.values_4;
			String value5 = td.values_5;

			if (valueRightside.equalsIgnoreCase(value1) || valueRightside.equalsIgnoreCase(value2)
					|| valueRightside.equalsIgnoreCase(value3) || valueRightside.equalsIgnoreCase(value4)
					|| valueRightside.equalsIgnoreCase(value5)) {
				assertTrue("right count values appear on the screen are as per expected testdata", true);
			} else {
				assertFalse("right count values appear on the screen are not as per expected testdata", false);
			}
		}
	}

	@And("^values on the screen are greater than zero$")
	public void valuesOnScreenValidation() throws Throwable {

		ObjectRepo or = new ObjectRepo();
		; // class nmae
		String txt_val = or.xpathtxt_val;
		List<WebElement> rightCountVal = driver.findElements(By.xpath(txt_val));
		int i = rightCountVal.size();
		for (int j = 0; j < rightCountVal.size(); j++) {
			String valueRightside = rightCountVal.get(j).getText();

			testdataRead td = new testdataRead();
			String RightCountNotEqualsToZero = td.RightCountNotEqualsTo_Zero;

			if (valueRightside.equalsIgnoreCase(RightCountNotEqualsToZero)) {
				assertFalse(" values on the screen are not greater than zero", false);
			} else {
				assertTrue("values on the screen are  greater than zero", true);
			}
		}
	}

	@Then("^Need to verify the total balance is correct based on the values listed on the screen and Need to verify the total balance matches the sum of the values$")
	public void calculateSumOfAllValuesAndVerifyWithFinalTotal() throws Throwable {

		int total = 0;
		String amt = null;
		ObjectRepo or = new ObjectRepo();
		;
		String txt_val = or.xpathtxt_val;
		List<WebElement> rightCountVal = driver.findElements(By.xpath(txt_val));
		int i = rightCountVal.size();
		for (int j = 0; j < rightCountVal.size(); j++) {

			String value = rightCountVal.get(j).getText();
			amt = value.substring(1, value.length());
			total += Integer.parseInt(amt);
		}

		testdataRead td = new testdataRead(); // total change
		String totalBalaence = td.totalBalance2; // camel
		int total1UIValue = Integer.parseInt(totalBalaence);
		if (total == total1UIValue) {
			assertTrue("calculate Sum Of All Values are equal to UI Result", true);
		} else {

			assertFalse("calculate Sum Of All Values are notequal to UI Result", false);
		}
	}

	@Then("^format as currencies$")
	public void need_to_verify_the_values_are_formatted_as_currencies() throws Throwable {

		String amt = null;
		ObjectRepo or = new ObjectRepo();
		;
		String txt_val = or.xpathtxt_val;
		List<WebElement> rightCountVal = driver.findElements(By.xpath(txt_val));
		int i = rightCountVal.size();
		for (int j = 0; j < rightCountVal.size(); j++) {
			String value = rightCountVal.get(j).getText();
			if (value.contains("$")) {
				assertTrue("values_are_formatted_as_currencies", true);
			} else {
				assertFalse("values_are_notformatted_as_currencies", false);
			}
			BigDecimalValidator validator = CurrencyValidator.getInstance();

			BigDecimal amount = validator.validate("value", Locale.US);
			if (amount != null) {
				assertTrue("it is not a nullvalue", true);
			} else {
				assertFalse("it is  a nullvalu", false);
			}

			String in = "value".replaceAll("\\(", "").replace(')', ' ').trim();
			
			amount = validator.validate(in, Locale.US);
			assertTrue("values_are_formatted_as_currencies", true);
			amount = validator.validate("invalid", Locale.US);
			assertFalse("values_are_notformatted_as_currencies", false);
		}
	}

}
