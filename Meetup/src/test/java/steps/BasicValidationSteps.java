package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MeetupHomePage;
import utilities.Driver;

import java.util.List;

public class BasicValidationSteps {

    MeetupHomePage meetupHomePage = new MeetupHomePage();

    @Given("^the user is on the MeetUp homepage$")
    public void the_user_is_on_the_MeetUp_homepage() throws Throwable {
        Driver.getDriver().get("https://www.meetup.com/");
        System.out.println("\"he\nllo\"");
    }

    @Then("^the title should be \"([^\"]*)\"$")
    public void the_title_should_be(String expectedTitle) throws Throwable {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("^verify Join Meetup button is displayed$")
    public void verify_Join_Meetup_button_is_displayed() throws Throwable {
        Assert.assertTrue(meetupHomePage.joinMeetupButton.isDisplayed());

    }
}
