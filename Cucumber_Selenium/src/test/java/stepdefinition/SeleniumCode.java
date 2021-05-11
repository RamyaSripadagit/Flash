package stepdefinition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;

import ObjectRepo.objectRepo;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/javaFeatures"
,glue= {"seleniumgluecode"}
)

public class SeleniumCode {
	WebDriver driver = null;
	
	@Given("^User Navigate to values Page$")
	public void userNavigateValuesPage() throws Throwable {
		
      //please note dummy chrome driver path
     
 	  System.setProperty("webdriver.chrome.driver", "/lib/chromeDriver/chromedriver.exe");
 		
       //Instantiating driver object
       driver = new ChromeDriver();
       
      //Using get() method to open a webpage
      driver.get("https://www.exercise1.com/values ");
      assertTrue("Browser launched with values page", true);
	}

	@Then("^User verify the right count values appear on the screen$")
	public void need_to_verify_the_right_count_of_values_appear_on_the_screen() throws Throwable { //metho dname
		
			
			 objectRepo or=new objectRepo();
			 String txt_val=or.xpathtxt_val;
			 List<WebElement> rightCountVal=driver.findElements(By.xpath(txt_val));
			 int i=rightCountVal.size();
			 
			 testdataRead td=new testdataRead();
			 String totalValueCount=td.totalValueCount;
			 if(totalValueCount.equals("i"))
			 {
				
				 assertTrue("right count of value on the screen is as expected", true);
			 }
			 else
			 {
			    assertFalse("value count not matches with actual and expected", false);
			 }
			 for(int j=0;j<rightCountVal.size();j++) {
				 String ValueRightside=rightCountVal.get(j).getText();
				 String Value1= td.values_1;
				 String Value2= td.values_2;
				 String Value3= td.values_3;
				 String Value4= td.values_4;   //camel case
				 String Value5= td.values_5;
				 
				 if(ValueRightside.equalsIgnoreCase(Value1) || ValueRightside.equalsIgnoreCase(Value2) || ValueRightside.equalsIgnoreCase(Value3) || ValueRightside.equalsIgnoreCase(Value4) || ValueRightside.equalsIgnoreCase(Value5))
				 {
					 assertTrue("right count values appear on the screen are as per expected testdata", true);
				 }
				 else {
					 assertFalse("right count values appear on the screen are not as per expected testdata", false);
				 }
				 }
			 }


	

	@And("^values on the screen are greater than 0$")
	public void need_to_verify_the_values_on_the_screen_are_greater_than(int arg1) throws Throwable { //valid name
		
		     objectRepo or=new objectRepo(); //class nmae
			 String txt_val=or.xpathtxt_val;
			 List<WebElement> rightCountVal=driver.findElements(By.xpath(txt_val));
			 int i=rightCountVal.size();
			 for(int j=0;j<rightCountVal.size();j++) {
				 String ValueRightside=rightCountVal.get(j).getText();
				 
				 testdataRead td=new testdataRead();
				 String RightCountNotEqualsToZero=td.RightCountNotEqualsTo_Zero;
				 
				 if(ValueRightside.equalsIgnoreCase(RightCountNotEqualsToZero))
				 {
					  assertFalse(" values on the screen are not greater than zero", false);
				 }
				 else {
					 assertTrue("values on the screen are  greater than zero", true);
				 }
				 }
			 }
	   
	

	@Then("^Need to verify the total balance is correct based on the values listed on the screen and Need to verify the total balance matches the sum of the values$")
	public void need_to_verify_the_total_balance_is_correct_based_on_the_values_listed_on_the_screen_and_Need_to_verify_the_total_balance_matches_the_sum_of_the_values() throws Throwable {
		
			 
			 int num1 = 0;
			 int total=0;
			 String amt = null;
			 objectRepo or=new objectRepo();
			 String txt_val=or.xpathtxt_val;
			 List<WebElement> rightCountVal=driver.findElements(By.xpath(txt_val));
			 int i=rightCountVal.size();
			 for(int j=0;j<rightCountVal.size();j++) {
				
				 String Value=rightCountVal.get(j).getText();
				  amt=Value.substring(1, Value.length());
				  total += Integer.parseInt(amt);
			 }
				
				 testdataRead td=new testdataRead();   //total change
				 int TotalBalaence=td.total; //camel
				 if(total == TotalBalaence)
				 {
					 assertTrue("Need_to_verify_the_total_balance_matches_the_sum_of_the_values", true);
				 }
				 else {
					
			     assertFalse("_total_balance_notmatches_the_sum_of_the_values", false);  
			}
			
		  int total1 = 0;
		  objectRepo or1=new objectRepo();
		  String total_Val=or1.xpathlbl_ttl_val;
		  WebElement ele= driver.findElement(By.xpath(total_Val));
		  String count= ele.getAttribute(total_Val);
		  total1 += Integer.parseInt(count);
		  testdataRead td1=new testdataRead();
			 int TotalBalaence1=td1.total;
		  if(total1 == TotalBalaence1)
			 {
				 assertTrue("total_balance_is_correct_based_on_the_values_listed_on_the_screen", true);
			 }
			 else {
				 assertFalse("total_balance_is_notcorrect_based_on_the_values_listed_on_the_screen", false);
			 }
			 
			 
		
	}

	@Then("^format as currencies$")
	public void need_to_verify_the_values_are_formatted_as_currencies() throws Throwable {
		
		 String amt = null;
		 objectRepo or=new objectRepo();
		 String txt_val=or.xpathtxt_val;
		 List<WebElement> rightCountVal=driver.findElements(By.xpath(txt_val));
		 int i=rightCountVal.size();
		 for(int j=0;j<rightCountVal.size();j++) {
			String Value=rightCountVal.get(j).getText();
		    if(Value.contains("$"))
		    {
				 assertTrue("values_are_formatted_as_currencies", true);
			 }
			 else {
				 assertFalse("values_are_notformatted_as_currencies", false);
			 }
	   
	}

	}
}
