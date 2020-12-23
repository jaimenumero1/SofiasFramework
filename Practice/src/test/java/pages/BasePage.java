package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BasePage {
    //here we store all the elements that are common to all/most of the pages of our app
    WebDriver driver;

    public BasePage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="MP_link")
    public WebElement marketplaceButton;

    @FindBy(id="welcome")
    public WebElement welcomeText;
}


