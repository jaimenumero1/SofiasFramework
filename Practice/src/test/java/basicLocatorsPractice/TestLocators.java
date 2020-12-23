package basicLocatorsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestLocators {

    @Test
    public void test1() throws InterruptedException{
        //to setup the driver instead of system.setProperty() we do this:
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.com/");
        // q, btnK

        WebElement searchInputField = driver.findElement(By.name("q"));
        //to type a text in an input field we use .sendKeys("string"):void
        String searchCriteria = "apple";
        searchInputField.sendKeys("flower");
        driver.findElement(By.name("btnK")).click();
        Thread.sleep(5000);

        Assert.assertTrue("The title doesn't contain the search criteria. Expected:"+searchCriteria+". Actual: "+driver.getTitle(),driver.getTitle().contains(searchCriteria));
        driver.close();
    }

    @Test
    public void test2() throws InterruptedException{
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);

        driver.get("https://www.google.com/");
        //linkText - locator to find any link on the webpage by its text
        driver.findElement(By.linkText("Gmail")).click();
        Thread.sleep(3000);
        //partialLinkText - locator that allows driver to find a link by the partial text
        WebElement createAnAcountButton = driver.findElement(By.partialLinkText("Create an"));

        Assert.assertTrue(createAnAcountButton.isDisplayed());
        driver.close();
    }

    @Test
    public void test3() throws InterruptedException{
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);

        driver.get("https://demostore.x-cart.com/");
        driver.findElement(By.linkText("Contact us")).click();
        Thread.sleep(3000);
        //tagName - locator that can find an element with specific tag
        WebElement heading = driver.findElement(By.tagName("h1"));

        Assert.assertTrue(heading.isDisplayed());
        driver.close();

    }

    @Test
    public void test4() throws InterruptedException{
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
        driver.get("http://www.practiceselenium.com/");
        driver.findElement(By.linkText("Let's Talk Tea")).click();
        Thread.sleep(3000);
        WebElement nameInput = driver.findElement(By.name("name"));

        Assert.assertTrue(nameInput.isDisplayed());
        driver.close();
    }

    @Test
    public void test5(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
        driver.get("http://www.practiceselenium.com/");

        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());
        driver.close();

    }

    @Test
    public void test6() throws InterruptedException{
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
        driver.get("http://www.practiceselenium.com/");
        driver.findElement(By.linkText("Check Out")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Cancel")).click();
        driver.close();

    }

    @Test
    public void test7() throws InterruptedException{
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
        
        driver.get("https://www.amazon.com/");

        driver.findElement(By.linkText("Sell")).click();
        Thread.sleep(4000);
        WebElement title = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(title.isDisplayed());

        driver.findElement(By.linkText("Sign up")).click();

        Thread.sleep(4000);

        WebElement emailInputField = driver.findElement(By.id("ap_email"));
        WebElement passwordInputField = driver.findElement(By.id("ap_password"));
        WebElement nextButton = driver.findElement(By.id("signInSubmit"));

        emailInputField.sendKeys("invalidemail");
        passwordInputField.sendKeys("invalid password");
        nextButton.click();
        Thread.sleep(2000);

        WebElement errorMessage = driver.findElement(By.tagName("h4"));

        Assert.assertTrue(errorMessage.isDisplayed());
        driver.close();

    }




}
