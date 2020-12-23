package waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PracticeWaits {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    }

    @Test
    public void test1(){
        driver.get("https://www.etsy.com/");
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')][1]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 4);

        WebElement emailInputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='join_neu_email_field']")));

    }

    @Test
    public void fileUpload(){
        driver.get("https://demoqa.com/upload-download");
        driver.findElement(By.xpath("//input")).sendKeys("/Users/rudenka93/Desktop/DevX-School-Logo copy.png");
    }


    @Test
    public void fileUpload2(){

    }



    @After
    public void tearDown(){
        driver.close();
    }
}
