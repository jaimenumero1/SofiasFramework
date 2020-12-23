package advancedLocators;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdvancedLocators {

    //driver.findElements(locator) --> returns all the elements that match this locator--> this method returns a List of Webelements
    //if no elemets are found that match the locator --> Empty List of Webelements will be returned

    // driver.findElement() will return one single element matching the provided locator. If there is more than one webelement that matches
    //the locator - it will return the first one it finds (selenium looks into HTML doc from top to buttom)
    //if no element is found or if locator is wrong -> NoSuchElementException

    @Test
    public void Test1() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        driver.navigate().to("https://www.google.com/");
        WebElement searchInputField = driver.findElement(By.name("q"));
        searchInputField.sendKeys("devxschool");
        driver.findElement(By.name("btnK")).click();
        Thread.sleep(4000);

        WebElement firstLink = driver.findElement(By.tagName("a"));
//element.gettext() - returns a String -> the text of the webelement
        System.out.println(firstLink.getText());
        System.out.println("______________________________");
        //find all the links on a page

        List<WebElement> allLinksOnThePage = driver.findElements(By.tagName("a"));
        for (WebElement link:allLinksOnThePage) {
            System.out.println(link.getText());
          if(link.getText().contains("DevX School")){
                link.click();
                break;
            }
        }
        driver.close();
    }
    //StaleElementException- > the element is old, not fresh and you cannot access it anymore.
    // It may happen as a result of new page opening or the part of HTML document has been refreshed


    @Test
    public void test2() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        driver.navigate().to("https://www.amazon.com/");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone" + Keys.ENTER);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[text()=‘See more’][1]")).click();

        Thread.sleep(3000);

        List<WebElement> brands = driver.findElements(By.cssSelector("li[id^='p_89']"));

        for (WebElement brand:brands) {
            System.out.println(brand.getText());
        }

        Assert.assertTrue("The brands displayed must be 10", brands.size() == 10);
        driver.close();

    }

    @Test
    public void test3() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        driver.get("https://demoqa.com/checkbox");
        driver.findElement(By.xpath("//button[@title='Toggle']")).click();
        Thread.sleep(2000);

        List<WebElement> subfolders = driver.findElements(By.xpath("//*[@class='rct-icon rct-icon-expand-close']/.."));

        for (WebElement subfolder:subfolders) {
            System.out.println(subfolder.getText());
        }

        subfolders.get(1).click();

        Assert.assertTrue(subfolders.size() == 3 && subfolders.get(1).isSelected());

    }


    @Test
    public void test4() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);


        driver.get("https://opensource-demo.orangehrmlive.com/");

        String username = "Admin";
        String password = "admin123";

        WebElement usernameInputField = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        WebElement passwordInputFiled = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button']"));

        usernameInputField.sendKeys(username);
        passwordInputFiled.sendKeys(password);
        loginButton.click();
        Thread.sleep(3000);

        WebElement welcomeText = driver.findElement(By.xpath("//a[contains(text(),'Welcome')]"));

        Assert.assertTrue(welcomeText.getText().contains(username));

    }

    @Test
    public void test5(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);


        driver.findElement(By.className(""));// or I don't know
        //check that xpath again might not work


        driver.get("https://demoqa.com/radio-button");
        driver.findElement(By.xpath("//label[@for='yesRadio']")).click();

        List<WebElement> radioButtonLabels = driver.findElements(By.xpath("//input[contains(@id,'Radio')]/following-sibling::label"));
        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[contains(@id,'Radio')]"));

        for (WebElement radio:radioButtons) {
            if(radio.isSelected()){
                System.out.println("This button is selected: ");
            }
            System.out.println(radio.getText());
        }



    }








}
