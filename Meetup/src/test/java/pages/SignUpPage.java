package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "facebookAuthButton")
    public WebElement continueWithFacebookLink;

    @FindBy(id = "googleAuthButton")
    public WebElement continueWithGoogleLink;

    @FindBy(id = "appleAuthButton")
    public WebElement continueWithAppleLink;

    @FindBy(id = "register-trigger--withEmail")
    public WebElement signUpWithEmailLink;

    @FindBy(xpath = "//a[text()='Log in'][1]")
    public WebElement logInLink;

}
