package advancedMouseInteractions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigsReader;

import java.util.concurrent.TimeUnit;

public class AdvancedMouseInteractions {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    @Test
    public void test1(){
        driver.navigate().to("https://demoqa.com/buttons");
        //first find the elements you will be interacting with
        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
        //create an object of Actions class
        Actions actions = new Actions(driver);
        //action to happen on the element. We always finish with .perform() -->> makes the action happen
        actions.doubleClick(doubleClickButton).perform();
        //I want to verify that double message is displayed

        Assert.assertTrue("Double click message is not displayed",driver.findElement(By.id("doubleClickMessage")).isDisplayed());

        //now right click
        actions.contextClick(rightClickButton).perform();

        Assert.assertTrue("Right click message is not displayed", driver.findElement(By.id("rightClickMessage")).isDisplayed());

    }

    @Test
    public void test2() throws InterruptedException{
        driver.navigate().to("https://demoqa.com/tool-tips");
        WebElement hoverButton = driver.findElement(By.id("toolTipButton"));

        Actions actions = new Actions(driver);

        actions.moveToElement(hoverButton).perform();

        WebDriverWait wait = new WebDriverWait(driver, 3);
        boolean attributeAppeared = wait.until(ExpectedConditions.attributeToBe(hoverButton, "aria-describedby", "buttonToolTip" ));

        String attribute = hoverButton.getAttribute("aria-describedby"); //buttonToolTip

        Assert.assertEquals("buttonToolTip", attribute);

        actions.moveToElement(driver.findElement(By.xpath("//div[text()='Book Store Application']"))).perform();

        Thread.sleep(3000);



    }

    @Test
    public void test3() throws InterruptedException{
        driver.navigate().to("https://www.etsy.com/");

        //i need to scroll to subscribe input field, type my email and hit subscribe

        WebElement subscribeInput = driver.findElement(By.id("email-list-signup-email-input"));

        Actions actions = new Actions(driver);
//actions.keyDown(Keys.)
        actions.moveToElement(subscribeInput).click().sendKeys("devxschool@gmail.com" + Keys.ENTER).perform();

        Thread.sleep(3000);


    }

    @Test
    public void test4() throws InterruptedException{
        driver.navigate().to("https://demoqa.com/slider");
        System.out.println(ConfigsReader.getProperty("password"));
        //range-slider__tooltip__arrow
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', arguments[1])", slider, "border:2px solid yellow");
        Actions actions = new Actions(driver);

        actions.clickAndHold(slider).moveByOffset(20,0).release().perform();
        Thread.sleep(3000);
        WebElement sliderValue = driver.findElement(By.id("sliderValue"));
        Assert.assertTrue(Integer.parseInt(sliderValue.getAttribute("value")) > 25);

    }

    @Test
    public void test5(){
        driver.navigate().to("https://demoqa.com/droppable");
        //e need to find source and target
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(source, target).perform();

        Assert.assertTrue("this is a message",target.getText().contains("Dropped!"));
    }




}
