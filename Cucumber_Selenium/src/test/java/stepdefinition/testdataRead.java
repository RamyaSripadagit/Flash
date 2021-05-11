package stepdefinition;

import java.io.File;
import java.sql.Array;
import java.util.ArrayList;

import gherkin.JSONParser;
import gherkin.deps.com.google.gson.JsonObject;

public class testdataRead {
	JsonObject ExpectedValue =null;
	//please note this is dummy path i have kept testdata.json file in testdata package
	
	 File file = new File("C:\\Users\\sri\\Desktop\\test.txt");
	
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
	 
	 public int total;
	 public int totalamt;
	 public void  total(int total, String  totalamt) {
		 
	 totalamt= values_1 + values_2 + values_3 + values_4 + values_5;
	 total += Integer.parseInt(totalamt);
	 this.total=total;
		 
	 }
	 
	 
	 
	
	 
	
}
