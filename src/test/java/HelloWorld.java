
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import com.epam.healenium.SelfHealingDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;

public class HelloWorld {

	//Reference: https://github.com/healenium/healenium-web
	
	//create selenium driver
	private WebDriver delegate;
	//create Self-healing driver
	private SelfHealingDriver driver;
	//Create web element
	private WebElement element;
	 
	//Values
	String name = "ABCD";
	String country = "Mangalore";
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		delegate = new ChromeDriver();	
		delegate.manage().window().maximize();
		delegate.get("http://localhost:3000/customerlist");
		//Create Healenium Instance
		driver = SelfHealingDriver.create(delegate);
	}
	
	@Test(priority = 0)
	public void normal() throws InterruptedException, MalformedURLException {
		/*
		 * Test Case: Validate is displayed the country
		 * 
		 * Step 1. Click on button 'ABCD'
		 * Step 2. Validate the country 'India' is displayed 
		 * 
		 * */
		
		element= driver.findElement(By.id(name));
		System.out.println("Attribute by ID: ----------------> "+element.getAttribute("id")+ " <-----------------------");
		element.click();
		//Is Displayed the content
		Boolean isDisplayed = driver.findElement(By.xpath("//*[@class='panel-body']/*[contains(., '"+country+"')]")).isDisplayed();
		System.out.println("IsDisplayed: ----------------> "+isDisplayed+ " <-----------------------");
		Thread.sleep(5000);
	}

	
	@Test(priority = 1)
	public void selfHealing() throws InterruptedException, MalformedURLException {
		/*
		 * Test Case: Validate is displayed the country
		 * 
		 * Step 1. Click on button 'ABCD'
		 * Step 2. Validate the country 'India' is displayed 
		 *
		 * */
		
		Thread.sleep(35000);
		element= driver.findElement(By.id(name));
		System.out.println("Attribute by ID: ----------------> "+element.getAttribute("id")+ " <-----------------------");
		element.click();
		//Is Displayed the content
		Boolean isDisplayed = driver.findElement(By.xpath("//*[@class='panel-body']/*[contains(., '"+country+"')]")).isDisplayed();
		System.out.println("IsDisplayed: ----------------> "+isDisplayed+ " <-----------------------");
	}
	
	@AfterMethod
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}
}
