package steps;

import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import utilities.Driver;

public class GoogleSteps {


    @Given("^the user is on google page$")
    public void the_user_is_on_google_page() throws Throwable {
        Driver.getDriver().navigate().to("https://www.google.com/");
    }

    @When("^the user types \"([^\"]*)\" in a search field$")
    public void the_user_types_in_a_search_field(String searchCriteria) throws Throwable {
        Driver.getDriver().findElement(By.name("q")).sendKeys(searchCriteria);
    }

    @When("^the user clicks search$")
    public void the_user_clicks_search() throws Throwable {
        Driver.getDriver().findElement(By.name("btnK")).click();
    }

    @Then("^verify the search results contain \"([^\"]*)\"$")
    public void verify_the_search_results_contain(String searchCriteria) throws Throwable {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(searchCriteria));
    }

}
