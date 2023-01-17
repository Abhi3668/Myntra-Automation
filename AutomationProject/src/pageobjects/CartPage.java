package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	//element to click on bag
@FindBy(xpath="//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/a[2]/span[1]")
public WebElement clickonbag;
    //element to click on the screen
@FindBy(xpath="//*[@id=\"appContent\"]/div/div/div/div/div[1]")
public WebElement clickon;
      //element to click on add another item
@FindBy(xpath="//*[@id=\"appContent\"]/div/div/div/div/div[3]/div/div[3]/div[2]/div[4]")

public WebElement addanotheritem;
public CartPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void bagpage() {
	//to click on bag
	clickonbag.click();
	//to click on the screen
	clickon.click();
	//to click on add another item
	addanotheritem.click();
}
}
