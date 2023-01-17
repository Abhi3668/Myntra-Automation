package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.CartPage;
import pageobjects.HomePage;

public class Testcase1 {
	public static Properties prop;
	WebDriver driver;
	public Properties loadPropertyFile() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\kondeti.sankar\\eclipse-workspace\\AutomationProject\\src\\testcases\\config.properties");
		System.out.println(fileInputStream);
		 prop = new Properties();
		prop.load(fileInputStream);
		// PropertyFile load . return
		return prop;
	}

	
	  @BeforeSuite public void SetUp() throws IOException { 
		   //Myntra Test Begins
		  //Loading the property file
		  loadPropertyFile();
		  String browser = prop.getProperty("browser");
			String url = prop.getProperty("url");
			if(browser.equalsIgnoreCase("chrome")) {
				// Launching Chrome
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if(browser.equalsIgnoreCase("edge")) {
				// Launching Edge
				WebDriverManager.edgedriver().setup();
				driver =new EdgeDriver();
					}
			//navigating to application
  driver.get(url);
  //to maximize the screen
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  //storing the title of the page into title
	  String title=driver.getTitle();
	  //validating the title
	  Assert.assertEquals("Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra", title);
	  }
	 

@Test
public void a() throws InterruptedException {
	//creating HomePage object
	HomePage home=new HomePage(driver);
	//creating CartPage object
	CartPage cart=new CartPage(driver);
	//calling method from HomePage
	home.result();
	//calling method from CartPage
	cart.bagpage();}

@AfterSuite
public void tearDown() throws Exception {
// Execution done closing the browser
driver.quit();
}
}
