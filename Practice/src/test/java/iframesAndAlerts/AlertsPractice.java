package iframesAndAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AlertsPractice {

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
    public void test1() throws InterruptedException{
        driver.navigate().to("https://demoqa.com/alerts");

        driver.findElement(By.id("alertButton")).click(); //alert should appear on the page

        Alert alert = driver.switchTo().alert();
        //simple alert gives only 1 option- to accept it

        alert.accept(); // to hit "OK" on the alert

        driver.findElement(By.id("timerAlertButton")).click();//alert should appear on the page after 5 seconds

        new WebDriverWait(driver, 7).until(ExpectedConditions.alertIsPresent());

        //alert = driver.switchTo().alert();

        alert.accept();

        driver.findElement(By.id("confirmButton")).click();//alert should appear on the page

        alert.dismiss(); // to hit "CANCEL" on the alert


        String resultText = driver.findElement(By.id("confirmResult")).getText();

        Assert.assertEquals("You selected Cancel", resultText);

        driver.findElement(By.id("promtButton")).click();

        System.out.println("The text of alert is: "+ alert.getText());

        alert.sendKeys("Sofia");
        alert.accept();

        String promptTextResult = driver.findElement(By.id("promptResult")).getText();

        Assert.assertTrue(promptTextResult.contains("Sofia"));

    }

    @Test
    public void test2(){

        driver.navigate().to("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");

        WebElement doubleClickButton = driver.findElement(By.id("double-click"));

        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform(); //alert is on the screen

        Alert alert = driver.switchTo().alert();

        Assert.assertTrue(alert.getText().contains("You double clicked me!!!"));

        alert.accept();

        driver.findElement(By.name("prompt")).click();

        Assert.assertEquals("I am prompt", alert.getText());

        alert.sendKeys("DevX");
        alert.accept();

        driver.findElement(By.name("confirmation")).click();

        Assert.assertEquals("I am confirm", alert.getText());
        alert.dismiss();




    }





}




