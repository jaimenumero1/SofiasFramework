package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DashboardPage extends BasePage{

    WebDriver driver;

    public DashboardPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='quickLaunge']//span[text()='Assign Leave']")
    public WebElement assignLeaveButton;

    //@FindBy --> used to find one ore more(List) that match that specific locator
    //@FindBys --> inside you provide multiple @FindBy with locators and it will try to find one or more elements that match ALL of the locators --
    //multiple @FindBy annotations inside of @FindBys annotation work as AND - MATCH ALL

    @FindBys ({
            @FindBy(id = "button"),
            @FindBy(name="q")
    })
    public WebElement button; //--> works for single WebElement and for List<WebElement>

    //@FindAll - inside you provide multiple @FindBy with locators and it will try to find one or more elements that match ANY of the provided
    // @FindBy annotation locator. All @FindBy annotations nested in @FindAll work as OR - MATCH ANY of the provided findby

    @FindAll({
            @FindBy(id = "button"),
            @FindBy(name="q")
    })
    public List<WebElement> button2; //--> works for single WebElement and for List<WebElement>

}



