package pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
public WebDriver driver;
//element to click search
@FindBy(xpath="//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/input")
public WebElement Search;
//element to click on the product
@FindBy(xpath="//*[@id=\"desktopSearchResults\"]/div[2]/section/ul/li[2]/a")
public WebElement product;
//element to click on the add to bag icon
@FindBy(xpath="//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[2]/div/div[1]")
public WebElement bag;

public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void result() throws InterruptedException {
	//to perform action class
	Actions a=new Actions(driver);
	//to perform javascript executor
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//to click on searchbar
	a.moveToElement(Search).click().perform();
	//to type Titan and to click on enter
a.moveToElement(Search).sendKeys("Titan").perform();
Search.sendKeys(Keys.ENTER);
String title1=driver.getTitle();
//to validate the title of the page
Assert.assertEquals("Titan - Buy Titan Products Online in India | Myntra", title1);
	//to scroll down to the product
	  js.executeScript("window.scroll(0,100)");
	  //to click on the product
	a.moveToElement(product).click().perform();
	//to switch the tab
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window(tabs.get(1));

	Thread.sleep(5000);
	//to click on add to bag
	bag.click();
}
}

