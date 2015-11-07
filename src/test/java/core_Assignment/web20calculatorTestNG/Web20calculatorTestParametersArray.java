package core_Assignment.web20calculatorTestNG;


import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Web20calculatorTestParametersArray {
 
    @DataProvider (name = "data")
	public static String[][]  data() throws IOException 
   {
	   core_Assignment.web20calculatorTestNG.Web20calculator_main web20calculator_main = new core_Assignment.web20calculatorTestNG.Web20calculator_main();
    
	   return web20calculator_main.a2d();
 	
    }

 

 @Test  (dataProvider = "data")
 public void test_Operation_Validation_web20calculator (String test_id,String result_Expected, String result_Actual, String N1,String N2) // throws ComparisonFailure 
 {
       System.out.println("Test Case: " + test_id + " Expected Result: " + result_Expected + " Actual Result: " + result_Actual );
  
        Assert.assertEquals(result_Expected, result_Actual); 
 
 }

}