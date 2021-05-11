package stepdefinition;

import java.io.File;
import java.sql.Array;
import java.util.ArrayList;

import gherkin.JSONParser;
import gherkin.deps.com.google.gson.JsonObject;

public class testdataRead {
	JsonObject ExpectedValue =null;
	
	
	 File file = new File("C:\\Users\\vadap\\git\\repository\\Cucumber_Selenium\\src\\test\\java\\testData\\testData.json");
	
	 JsonObject obj=new JsonObject();
   
	 JsonObject values1=ExpectedValue.getAsJsonObject("Value 1");
	 public  String values_1=values1.toString();
	 
	 JsonObject values2=ExpectedValue.getAsJsonObject("Value 2");
	 public  String values_2=values2.toString();
	 
	 JsonObject values3=ExpectedValue.getAsJsonObject("Value 3");
	 public  String values_3=values3.toString();
	 
	 JsonObject values4=ExpectedValue.getAsJsonObject("Value 4");
	 public  String values_4=values4.toString();
	 
	 JsonObject values5=ExpectedValue.getAsJsonObject("Value 5");
	 public  String values_5=values5.toString();
	 
	 JsonObject count=ExpectedValue.getAsJsonObject("TotalCount");
	 public  String totalValueCount=count.toString();
	 
	 JsonObject RightCountNotEqualsToZero=ExpectedValue.getAsJsonObject("RightCountNotEqualsToZero");
	 public  String RightCountNotEqualsTo_Zero=RightCountNotEqualsToZero.toString();
	 
	 JsonObject totalBalance1=ExpectedValue.getAsJsonObject("TotalBalance");
	 public  String totalBalance2=values5.toString();
		 
	 }
	 
	 
	 
	
	 
	

