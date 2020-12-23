package javascriptPractice;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JavascriptPractice {

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

        JavascriptExecutor js = (JavascriptExecutor)driver;
        //this one opens a page
        js.executeScript("window.location='https://www.etsy.com/'");

        WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));

        //we are adding red border to sign in button to bring tester's attention to the next element we will interact with
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", signInButton, "border: 2px solid red");

        Thread.sleep(2000);

        js.executeScript("arguments[0].click();", signInButton);

        WebElement emailInput = driver.findElement(By.id("join_neu_email_field"));

        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", emailInput, "border: 2px solid red");


        Faker faker = new Faker();
        String fakeEmail = faker.bothify("????##@gmail.com");

        js.executeScript("arguments[0].setAttribute('value', arguments[1]);", emailInput, fakeEmail);
        //--> //<input value="agfhwga@gmail">
        Thread.sleep(2000);

        WebElement passwordInput = driver.findElement(By.id("join_neu_password_field"));

        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", passwordInput, "border: 2px solid red");
        Thread.sleep(2000);

        js.executeScript("arguments[0].setAttribute('value', arguments[1]);", passwordInput, "abc123");

        WebElement signInButton2 = driver.findElement(By.xpath("//button[@value='sign-in']"));
        Thread.sleep(2000);
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", signInButton2, "border: 2px solid red");
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", signInButton2);

    }

    @Test
    public void test2(){
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebDriverWait wait = new WebDriverWait(driver,3);
        WebElement usenameInput = driver.findElement(By.id("txtUsername"));
        WebElement passwordInput = driver.findElement(By.id("txtPassword"));
        WebElement logInButton = driver.findElement(By.id("btnLogin"));

        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", usenameInput, "border: 2px solid red");
        usenameInput.sendKeys("Admin");
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", passwordInput, "border: 2px solid red");
        passwordInput.sendKeys("admin123");
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", logInButton, "border: 2px solid red");
        logInButton.click();


        WebElement assignLeave = driver.findElement(By.linkText("Assign Leave"));
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", assignLeave, "border: 2px solid red");
        assignLeave.click();

        WebElement employeeName = driver.findElement(By.id("assignleave_txtEmployee_empName"));
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", employeeName, "border: 2px solid red");
        employeeName.sendKeys("Fiona Grace");

        //WebElement employeeNameFromList = driver.findElement(By.xpath("//strong[text()='Fiona Grac']"));
        //js.executeScript("arguments[0].setAttribute('style', arguments[1]);", employeeNameFromList, "border: 2px solid red");
        //employeeNameFromList.click();

        WebElement leaveType = driver.findElement(By.id("assignleave_txtLeaveType"));
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", leaveType, "border: 2px solid red");
        Select dropdown = new Select(leaveType);

        dropdown.selectByValue("1");

        WebElement fromDate = driver.findElement(By.id("assignleave_txtFromDate"));
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", fromDate, "border: 2px solid red");
        fromDate.click();
        //
        List<WebElement> allDates = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
        //create local date time
        int date = LocalDateTime.now().getDayOfMonth();
        for ( WebElement day:allDates) {
            if(Integer.parseInt(day.getText() ) == date)
                driver.findElement(By.xpath("//a[text()="+date+"]"));
        }


        //
        // driver.findElement(By.xpath("//a[text()=29]")).click();

        WebElement toDate = driver.findElement(By.id("assignleave_txtToDate"));
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", toDate, "border: 2px solid red");
        toDate.click();
        driver.findElement(By.xpath("//a[text()=29]")).click();

        WebElement assignButton = driver.findElement(By.id("assignBtn"));
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", assignButton, "border: 2px solid red");
        assignButton.click();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Employee does not have sufficient leave balance for leave request.']")));
        WebElement errorMessage =driver.findElement(By.xpath("//p[text()='Employee does not have sufficient leave balance for leave request.']"));

        Assert.assertTrue(errorMessage.isDisplayed());


    }

    //if .clear() doesn't work on the input field u can use:
    // element.sendKeys(Keys.CONTROL+"a"+Keys.DELETE);


}
