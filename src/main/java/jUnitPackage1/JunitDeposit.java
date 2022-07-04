package jUnitPackage1;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class JunitDeposit {
	/* Test case: As an user, I want to be able to add deposit
	 * Test Cases:
	 * 1: Open Browser and go to site http://www.techfios.com/billing/?ng=admin/ 
2. Enter username: demo@techfios.com 
3. Enter password: abc123
4. Click login button
5. Click on Transactions button
6. Click on New Deposit button 
7. Click on Open An Account drop down to expand it
8. Click on any account name
9. Type any description
10. Type any amount			
11. Click on submit button */
	// declaration of the webDriver
	WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("before class");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("after class");
	}
	@Before
	public void launchBrowser() {
		System.out.println("before method");
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe")
		//System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver(); // object variable
		// delete cookies
		driver.manage().deleteAllCookies();
		// go to the site
		driver.get("https://techfios.com/billing/?ng=admin/");
		// maximize window
		driver.manage().window().maximize();
		//controlling wait time to minimize execution failure, Implicit wait method
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	   @Test 
	    public void loginTest() {
	   	System.out.println("test method");
		// identify user name element & data insertion
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		// identify password element & data insertion
		driver.findElement(By.id("password")).sendKeys("abc123");
		// identify sign in element & click
		driver.findElement(By.name("login")).click();
		//assertion
		//Assert.;
		//another way to do assert
		//Assert.assert
		System.out.println("This is the account opening part");
		// clicking on Bank & Cash
		driver.findElement(By.partialLinkText("Bank & Cash")).click();
		driver.findElement(By.partialLinkText("New Account")).click();
		//Thread.sleep(5000);
		//file upload
		//identify the elemnt, use sendkeys as long as it is tag input
		//driver.findElement("")).sendkeys;
		//any other ytage you will have to use robot class
		
		// filing out the new account information
		System.out.println("This is ti fill out the account information");
		driver.findElement(By.id("account")).sendKeys("Saving Account");
		driver.findElement(By.id("description")).sendKeys("I am keeeping my saving here");
		driver.findElement(By.id("balance")).sendKeys("$129,000");
		driver.findElement(By.id("account_number")).sendKeys("214723387300");
		driver.findElement(By.id("contact_person")).sendKeys("Bintu C");
		driver.findElement(By.id("ib_url")).sendKeys("www.techfios.com/billing/?ng=admin/");
		//Thread.sleep(3200);
		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
	    //driver.findElement(By.partialLinkText("alert alert-success fade in"));
		//WebElement expected= driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]"));
		//String actualUrl="";
        
		
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/ul/li[1]/a")).click();
		driver.findElement(By.partialLinkText("Dashboard")).click();
	    //driver.findElement(By.xpath("//div[@id='page-wrapper']//input[@id='account']")).sendKeys("Sidy");	
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2")).click();
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]")).click();
		driver.findElement(By.linkText("Add Customer")).click();
		driver.findElement(By.xpath("//input[@id='account']")).sendKeys("Sidi");
		//driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button")).click();
		
		//driver.finElement(By.name());
				
		
		By DASHBOARD_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
	
		
		Assert.assertTrue("Wrong Page!!!", driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
		
//		Assert.assertEquals("Dashboard page not found!!", "Dashboard", driver.findElement(DASHBOARD_HEADER_FIELD).getText());
//		System.out.println(driver.findElement(DASHBOARD_HEADER_FIELD).getText());
		
		//Assert.assertEquals("Dashboard page not found!!", "Dashboard- iBilling", driver.getTitle());
//		System.out.println(driver.getTitle());
		
		//driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]")).click();
		//driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")).click();
		
		By COUNTRY_DROPDOWN_FIELD = By.xpath("//*[@id=\"cid\"]");
		
		Select sel = new Select(driver.findElement(COUNTRY_DROPDOWN_FIELD));
		sel.selectByVisibleText("Amazon");
		
		//homework
		sel.getOptions();
		
		driver.findElement(By.name("email")).sendKeys("sc22222@techfios.com");
		driver.findElement(By.id("phone")).sendKeys("214022222002010");
		driver.findElement(By.name("address")).sendKeys(" 6451 public rd ");
		driver.findElement(By.name("city")).sendKeys("Dallas");
		driver.findElement(By.name("state")).sendKeys("Texas");
		driver.findElement(By.id("zip")).sendKeys("75253");
		      //Drop Down to handle list of countries
		
    By ALLCOUNTRY_DROPDOWN_FIELD = By.xpath("//select[@id='country']");
		
		Select sel2 = new Select(driver.findElement(ALLCOUNTRY_DROPDOWN_FIELD));
		sel2.selectByVisibleText("United States");
		//driver.findElement(By.xpath("//ul[@class='select2-selection__rendered']")).sendKeys("QA training");
		driver.findElement(By.id("submit")).click();
		
		//Drop Down to handle list of currencies
		
        By CURRENCYY_DROPDOWN_FIELD = By.xpath("//SELECT[@ID='currency']");
			
			Select sel3 = new Select(driver.findElement(CURRENCYY_DROPDOWN_FIELD));
			sel3.selectByVisibleText("USD");
			//Drop Down to handle list of countries
			
	        By GROUP_DROPDOWN_FIELD = By.xpath("//*[@id=\'group\']");
				
				Select sel4 = new Select(driver.findElement(GROUP_DROPDOWN_FIELD));
			
				sel4.selectByVisibleText("SQL");
				//*[@id="submit"]
		//driver.findElement(By.xpath("//*[@id='submit']")).click();
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a"));
		
		
		
		
		
		
		
		
		
	  
	}
}
