package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MeetupHomePage {

    WebDriver driver;

    public MeetupHomePage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Join Meetup']")
    public WebElement joinMeetupButton;

    @FindBy(xpath = "//a[text()='Log in'][1]")
    public WebElement logInLink;

    @FindBy(xpath = "//a[text()='Sign up'][1]")
    public WebElement signUpLink;


}
