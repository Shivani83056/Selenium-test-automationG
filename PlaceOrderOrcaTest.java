package PlaceOrder;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PlaceOrderOrcaTest {
	
WebDriver driver;
	
	@BeforeTest
	public void Setup() {
		driver = new ChromeDriver();
		driver.get("https://uat.orca.garaaz.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test
	public void Place_Order() throws InterruptedException {
		//Entering the mobile number
		Thread.sleep(1000);
		driver.navigate().refresh();
		driver.findElement(By.xpath("//input[@class='chakra-input css-1vf745h']")).sendKeys("7030067700"); 
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		//Entering the otp
		driver.findElement(By.cssSelector("[class='chakra-input css-n7s663']")).sendKeys("8888");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[class='chakra-button css-18442ta']")).click();
		
		//Entering on place order
		driver.findElement(By.xpath("(//p[@class='chakra-text css-15yg8y3'])[1]")).click();
		
		Thread.sleep(3000);
		//Entering the customer name and selecting by the suggestion.
		driver.findElement(By.xpath("//input[@placeholder='Enter name or mobile number']")).sendKeys("C S Motor");
		driver.findElement(By.xpath("(//li[@class='css-16haf7t'])[1]")).click();
		
		//Entering the part required
		driver.findElement(By.cssSelector("[class='chakra-input css-mq47y9']")).sendKeys("123");
		driver.findElement(By.xpath("(//p[@class='chakra-text css-64qu75'])[2]")).click();
		
		//Entering the quantity
		driver.findElement(By.cssSelector("[class='chakra-input css-p3uh7a']")).clear();
		driver.findElement(By.cssSelector("[class='chakra-input css-p3uh7a']")).sendKeys("4");
		
		//Adding Media
		//Thread.sleep(4000);
		//driver.findElement(By.xpath("(//button[@class='chakra-button css-s83ccp'])[2]")).sendKeys("/C:/Users/pjha0/OneDrive/Desktop/Dzire-Pics-front.jpg/");
		
		//Adding Remarks
		WebElement remarks = driver.findElement(By.cssSelector("[id='field-:rd:']"));
		remarks.click();
		remarks.sendKeys("I want to purchase Dzire parts");
		driver.findElement(By.xpath("(//button[@class='chakra-button css-1jhnog7'])[1]")).click();
		Thread.sleep(3000);
		
		//Asserting the successful message
		Thread.sleep(2000);
		WebElement successmessage = driver.findElement(By.id("toast-2-description"));
		Assert.assertTrue(successmessage.isDisplayed());
		
		//Opening the OrCA application to accept the order - 387394148429904
		driver.navigate().to("https://uat.orca.garaaz.com/");
		driver.findElement(By.cssSelector("[class='chakra-button css-15n6r7j']")).click();
		Thread.sleep(2000);
		
		//clicking on option 
		driver.findElement(By.xpath("(//span[@class='chakra-checkbox__control css-1dnp747'])[1]")).click();
		
		//Entering the order id
		driver.findElement(By.cssSelector("[class='chakra-input css-orck8z']")).sendKeys("8331284534173582");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("[class='chakra-button css-1aiyg8x']")).click();
		
		//Assigning the order handler.
		driver.findElement(By.xpath("(//button[@class='chakra-button chakra-menu__menu-button css-yynmlr'])[1]")).click();
		
		//Assigning to Vikram Singh
		driver.findElement(By.xpath("(//p[@class='chakra-text css-3wvuua'])[4]")).click();
		
		//Transaction type
		driver.findElement(By.xpath("(//button[@class='chakra-button chakra-menu__menu-button css-yynmlr'])[2]")).click();
		driver.findElement(By.xpath("(//p[@class='chakra-text css-3wvuua'])[1]")).click();
		
		//Assigning dealer
		driver.findElement(By.xpath("(//button[@class='chakra-button css-1amwerg'])[2]")).click();
		driver.findElement(By.cssSelector("[placeholder='Search Supplier By Name']")).sendKeys("Gar");
		driver.findElement(By.cssSelector("[class='css-whp3e2']")).click();
		
		
		//ETA
		driver.findElement(By.xpath("(//button[@class='chakra-button css-1amwerg'])[3]")).click();
		driver.findElement(By.xpath("(//span[@class='css-1f4g2w1'])[2]")).click();
		driver.findElement(By.cssSelector("[placeholder='Enter reason']")).sendKeys("Just testing");
		driver.findElement(By.cssSelector("[class='chakra-button css-jut409']")).click();
		
		driver.findElement(By.xpath("(//button[@class='chakra-button css-1amwerg'])[6]")).click();
		driver.findElement(By.xpath("(//button[@class='chakra-button css-1amwerg'])[7]")).click();
		
		//Clicking on confirm
		driver.findElement(By.xpath("(//button[@class='chakra-button css-1g383u9'])")).click();
		driver.findElement(By.cssSelector("[class='chakra-icon css-onkibi']")).click();
		Thread.sleep(3000);
		
		
		
		//Entering Dashboard
		driver.navigate().to("https://uat.dashboard.garaaz.com/orders");
		driver.findElement(By.cssSelector("[class='chakra-button css-43r96b']")).click(); //Proxy Login
		driver.findElement(By.cssSelector("[placeholder='9876543210']")).sendKeys("7030067700");
		driver.findElement(By.cssSelector("[type='submit']")).click();
		driver.findElement(By.cssSelector("[type='text']")).sendKeys("1234");
		driver.findElement(By.cssSelector("[type='submit']")).click();
		
		//Acknowledge the order.
		driver.findElement(By.xpath("(//button[@class='chakra-button css-8wmm78'])[1]")).click();
		//driver.findElement(By.xpath("(//button[@class='chakra-button css-8wmm78'])[1]")).click();
		
		
		// Adding Invoice
		driver.findElement(By.xpath("(//button[@class='chakra-button css-qt70nk'])[1]")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the file input element to be present in the DOM
		WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));

		// Make the file input interactable using JavaScript if necessary
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", fileInput);

		// Upload the file
		fileInput.sendKeys("C:\\Users\\pjha0\\Downloads\\invoice2.jpg"); 
		Thread.sleep(3000);
		
		//Filling out the details
		driver.findElement(By.name("invoiceNo")).sendKeys("0101/SS/5353");
		driver.findElement(By.name("invoiceAmount")).sendKeys("690");
		driver.findElement(By.name("invoiceDate")).sendKeys("03012024");
		driver.findElement(By.name("noOfItems")).sendKeys("4");
		driver.findElement(By.name("totalQtyOfItems")).sendKeys("4");
		
		//click the submit button
		driver.findElement(By.cssSelector("[class='chakra-button css-fvo008']")).click();
		
		//Action Quantity
		driver.findElement(By.xpath("(//button[@class='chakra-button css-1oz65qa'])[1]")).click();
		
		//Ready Order
		driver.findElement(By.cssSelector("[class='chakra-button css-depm6w']")).click();
		
		//Proceed
		driver.findElement(By.cssSelector("[class='chakra-button css-1ycquqd']")).click();
		
		
		//Switching back to OrCA
		driver.navigate().to("https://uat.orca.garaaz.com/");
		
		//Enter amout
		driver.findElement(By.cssSelector("[class='chakra-text css-fsk9y9']")).sendKeys("1");
		driver.findElement(By.cssSelector("[class='chakra-button css-1eu8csq']")).click(); //confirm
		driver.findElement(By.xpath("(//button[@class='chakra-button css-1amwerg'])[6]")).click();
		driver.findElement(By.xpath("(//button[@class='chakra-button css-1amwerg'])[7]")).click();
		driver.findElement(By.cssSelector("[class='chakra-button css-1g383u9']")).click();

		

		

	}
	
	@AfterTest
	public void teardown() {
		//driver.close();
	}
}