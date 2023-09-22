package selenium_lab1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class lab1 {
	WebDriver driver= new ChromeDriver();
	SoftAssert myAssertionlang = new SoftAssert();
	
	SoftAssert myAssertionCurrency= new SoftAssert();
	
	SoftAssert myAssertionHotel= new SoftAssert();
	
	String ExLanguage="English";
	
	String ExCurrency="SAR";
	
	
	
	@BeforeTest
	public void myBeforeTest() {
		driver.get(" https://global.almosafer.com/ar ");
	
	}
	
	@Test
	public void myTest() {
		
	driver.findElement(By.className("cta__saudi")).click();
	
	String ActLanguage = driver.findElement(By.className("sc-gkFcWv")).getText();
	System.out.println(ActLanguage);
	System.out.println(ExLanguage);
	myAssertionlang.assertEquals(ActLanguage, ExLanguage);
	myAssertionlang.assertAll();

	
	
	String ActCurrency= driver.findElement(By.className("sc-dRFtgE")).getText();
	
	myAssertionCurrency.assertEquals(ActCurrency,ExCurrency);
	myAssertionCurrency.assertAll();
	
		
	WebElement hotelElement=driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
	hotelElement.click();

	
	 String result=hotelElement.getAttribute("aria-selected");
	
	myAssertionHotel.assertEquals(result,"true");
	myAssertionHotel.assertAll();
	 
		
	}
	
	@AfterTest
	public void myAfterTest() {
		
		driver.quit();
		
       

	}
	
	

}
