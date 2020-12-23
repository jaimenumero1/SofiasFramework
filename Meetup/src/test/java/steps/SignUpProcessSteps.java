package steps;

import cucumber.api.java.en.*;
import org.junit.Assert;
import pages.MeetupHomePage;
import pages.SignUpPage;

public class SignUpProcessSteps {
    MeetupHomePage meetupHomePage = new MeetupHomePage();
    SignUpPage signUpPage = new SignUpPage();

    @When("^the user clicks Join Meetup button$")
    public void the_user_clicks_Join_Meetup_button() throws Throwable {
        meetupHomePage.joinMeetupButton.click();
    }

    @Then("^display all sign up options$")
    public void display_all_sign_up_options() throws Throwable {
        Assert.assertTrue(signUpPage.continueWithFacebookLink.isDisplayed() &&
                signUpPage.continueWithGoogleLink.isDisplayed() &&
                signUpPage.continueWithAppleLink.isDisplayed() &&
                signUpPage.signUpWithEmailLink.isDisplayed());
    }
}
