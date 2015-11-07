package core_Assignment.web20calculatorTestNG;
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.runner.JUnitCore;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Web20calculator_main {
       
	
	
	
	 public static void main(String[] args) throws IOException {

		 core_Assignment.web20calculatorTestNG.Web20calculator_main web20calculator_m = new core_Assignment.web20calculatorTestNG.Web20calculator_main();
		 web20calculator_m.a2d();

 	 
		 //JUnitCore.main("core_Assignment.web20calculator.TestSuitAllTests()");
	 }
 
	public String[][] a2d() throws IOException {

 		String csvFile = "/Users/cydobolctbnem/Documents/Development/web20calculatorTestNG/src/main/resources/gridFormat.csv";
             
             BufferedReader br = null;
             String line = null;
             String[] column = null;
             int lines = 0;
             int columns = 0;
             String SplitBy = ",";
     		 String text_case_id = null;
     		 String N1 = null;
     		 String N2 = null;
     		 String Operation = null;
     		 String Result_Expected = null;
     		 String url = "http://web2.0calc.com/";
             
             // COUNTING LINES AND COLUMNS

             br = new BufferedReader(new FileReader(csvFile));
             
             while ((line = br.readLine()) != null) {

                    lines++;

                    column = line.split(SplitBy);

                    columns = column.length;

             }

             br.close();

 

             String s2d[][] = new String[lines][columns];

             br = new BufferedReader(new FileReader(csvFile));

           
             
             
    // WebDriver driver = new FirefoxDriver();
             
             System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
     		
     		WebDriver driver = new ChromeDriver();

             int i = 0;

             while ((line = br.readLine()) != null) {

 

                    String[] csv = line.split(SplitBy);

 

                    text_case_id = csv[0];

                    N1 = csv[1].toString();
    				
                    N2 = csv[2].toString();

                    Operation = csv[3];
    				
                    Result_Expected = csv[4].toString();

                    
                    driver.get(url);
   				    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   				    driver.findElement(By.xpath("//*[@id='hist']/button[2]")).click();
   				    driver.findElement(By.xpath("//*[@id='histframe']").xpath("//*[@id='clearhistory']")).click();
   					Alert alert = driver.switchTo().alert();
   					alert.accept();
   				    driver.findElement(By.xpath("//*[@id='input']")).sendKeys(N1);  
   				    driver.findElement(By.xpath(Operation)).click();  
                    driver.findElement(By.xpath("//*[@id='input']")).sendKeys(N2);   
                    driver.findElement(By.xpath("//*[@id='BtnCalc']")).click();
                    driver.findElement(By.xpath("//*[@id='hist']/button[2]")).click();
                    WebElement result =  driver.findElement(By.xpath("//*[@id='histframe']").xpath("//*[@id='histframe']/ul/li[1]/p[1]"));
                    String  result_Actual = result.getAttribute("title");
                    String  Result_Actual= result_Actual.toString();
                   
   				
 

                    s2d[i][0] = text_case_id;
                    
                    s2d[i][1] = Result_Expected;

                    s2d[i][2] = Result_Actual;
                    
                    
       
                   i++;

             }

           

             driver.quit();

             br.close();

             return s2d;

 

       }
 
}
