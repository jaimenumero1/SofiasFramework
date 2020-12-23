package testUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import utilities.ConfigsReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class HRsoftware {

    WebDriver driver;

    @Before
    public void setUp(){
         driver = Driver.getDriver();
    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }


    @Test
    public void test1(){
        driver.navigate().to(ConfigsReader.getProperty("baseUrl"));

        WebElement usenameInput = driver.findElement(By.id("txtUsername"));
        WebElement passwordInput = driver.findElement(By.id("txtPassword"));
        WebElement logInButton = driver.findElement(By.id("btnLogin"));

        usenameInput.sendKeys(ConfigsReader.getProperty("username"));
        passwordInput.sendKeys(ConfigsReader.getProperty("password") + Keys.ENTER);



    }



}
