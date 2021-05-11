package testrunner;

import cucumber.api.CucumberOptions;
import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/java/features"
        ,glue= "seleniumgluecode",
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
        monochrome = true
                )


public class testRunner {
	 @AfterClass
	    public static void writeExtentReport() {
	        Reporter.loadXMLConfig(new File("config/report.xml"));
	    
	    }

	}

