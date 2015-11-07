package core_Assignment.web20calculatorTestNG;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Web20calculator_csv {
	public static void main(String[] args) {
 
 		String csvFile = "/Users/cydobolctbnem/Documents/Development/web20calculatorTestNG/src/main/resources/gridFormat.csv";

		
		
		BufferedReader br = null;
		String line = null;
		String SplitBy = ",";
		String text_case_id = null;
		String N1 = null;
		String N2 = null;
		String Operation = null;
		String Result_Expected = null;
		String url = "http://web2.0calc.com/";
		try {
			br = new BufferedReader(new FileReader(csvFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		
 
		try {
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
                 String Result_Actual = result.getAttribute("title");
                 String result_Actual = Result_Actual.toString();
                
				
				
				
			 
				System.out.println("");
				if (Result_Expected.contains(result_Actual)) {
					System.out.println("Test Case ID: \t\t" + text_case_id);
					System.out.println("N1:\t\t\t" + N1);
					System.out.println("N2:\t\t\t" + N2);
				  //System.out.println("Operation:\t\t" + Operation);
					System.out.println("Result Expected:\t" + Result_Expected);
					System.out.println("Result Actual: \t\t" + result_Actual);
					System.out.println("Test Case Result: \t" + "PASSED");
					
				} else {
					System.out.println("Test Case ID: \t\t" + text_case_id);
					System.out.println("N1:\t\t\t" + N1);
					System.out.println("N2:\t\t\t" + N2);
				  //System.out.println("Operation:\t\t" + Operation);
					System.out.println("Result Expected:\t" + Result_Expected);
					System.out.println("Result Actual: \t\t" + result_Actual);
					System.out.println("Test Case Result: \t" + "FAILED");
					 
				}
 
			}
			driver.findElement(By.xpath("//*[@id='hist']/button[2]")).click();
			driver.findElement(By.xpath("//*[@id='histframe']").xpath("//*[@id='clearhistory']")).click();
			Alert alert = driver.switchTo().alert();
			alert.accept();

			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}
 
