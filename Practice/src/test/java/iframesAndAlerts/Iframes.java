package iframesAndAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Iframes {

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

        driver.navigate().to("https://demoqa.com/frames");
        //I need to switch to the iframe before I can interact with the element in it
        driver.switchTo().frame("frame1");
        WebElement textOfFrame1 = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(textOfFrame1.isDisplayed());
        //I need to switch back to my main html page so I can find the second iframe

        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);

        WebElement textOfFrame2 = driver.findElement(By.id("sampleHeading"));

        Assert.assertEquals("This is a sample page", textOfFrame2.getText());

    }

    @Test
    public void test2(){
        driver.navigate().to("https://allwebco-templates.com/support/S_script_IFrame.htm");

        WebElement iframe = driver.findElement(By.xpath("//iframe[@name='Framename'][1]"));

        driver.switchTo().frame(iframe);

        System.out.println(driver.findElement(By.tagName("div")).getText());

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//a[text()='Free website scripts']")).click();

        String newPageTitle = "Free Website Scripts, Plugins and Addons | Allwebco Design Corporation";

        Assert.assertEquals(newPageTitle, driver.getTitle());

    }

    @Test
    public void test3(){

        driver.navigate().to("https://demoqa.com/nestedframes");
        //first go to parent frame
        driver.switchTo().frame("frame1"); //--> I am currently inside prent frame
        //then go to child frame
        driver.switchTo().frame(0);
        Assert.assertEquals("Child Iframe",driver.findElement(By.tagName("p")).getText()); //must be child
        //go back to parent and print its text
        driver.switchTo().parentFrame();
        Assert.assertEquals("Parent frame", driver.findElement(By.tagName("body")).getText()); //must be child
        //go to the main html doc
        driver.switchTo().defaultContent();
    }







}
