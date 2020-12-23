package navigationAndDropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dropdowns {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }


    @Test
    public void selectOneFromDevxSchoolTest1(){

        driver.navigate().to("https://www.devxschool.com/");

        WebElement enrollNowButton = driver.findElement(By.linkText("Enroll Now"));
        enrollNowButton.click();

        WebElement dropdown = driver.findElement(By.id("form-field-ads"));

        Select selectElement = new Select(dropdown);

        List<WebElement> selectedOptions = selectElement.getAllSelectedOptions();

        for (WebElement option: selectedOptions) {
            System.out.println(option.getText());
        }

        Assert.assertTrue(selectedOptions.size()==1 &&
                selectedOptions.get(0).getText().equals("From a friend"));

        //selectElement.selectByVisibleText("Instagram");
        //selectElement.selectByIndex(2);
        selectElement.selectByValue("Instagram");

        selectedOptions = selectElement.getAllSelectedOptions();

        Assert.assertTrue(selectedOptions.size()==1 &&
                selectedOptions.get(0).getText().equals("Instagram"));



    }



    @Test
    public void selectOneFromDropDowntest2(){

        driver.navigate().to("https://www.expedia.com/");
        //find cruises button
        WebElement cruisesButton = driver.findElement(By.id("tab-cruise-tab-hp"));
        //click on it
        cruisesButton.click();
        //find select element
        WebElement selectElement = driver.findElement(By.id("cruise-destination-hp-cruise"));
        //create object of Select class
        Select selectDestination = new Select(selectElement);
        //select Alaska by value   -->> value="alaska"
        selectDestination.selectByValue("alaska");
        //verify Alaska is selected
        Assert.assertTrue(selectDestination.getAllSelectedOptions().get(0).getText().equals("Alaska"));

        //select Africa by visible text -->> visible text is Africa
        selectDestination.selectByVisibleText("Africa");
        Assert.assertTrue(selectDestination.getAllSelectedOptions().get(0).getText().equals("Africa"));

        //select Mexico by index -->> index of Mexico is 3
        selectDestination.selectByIndex(3);
        Assert.assertTrue(selectDestination.getAllSelectedOptions().get(0).getText().equals("Mexico"));

        //print out all possible options
        for(WebElement option : selectDestination.getOptions())
        System.out.println(option.getText());

    }


    @Test
    public void test3(){
        driver.navigate().to("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        //find select element
        WebElement selectElement = driver.findElement(By.id("option-droup-demo"));
        //create an object of Select class
        Select dropdown = new Select(selectElement);
        //dropdown.deselectAll();

        //select Java
        dropdown.selectByVisibleText("Java");
        dropdown.selectByVisibleText("Oracle");

        //deselect default values
        dropdown.deselectByVisibleText("HTML");
        dropdown.deselectByVisibleText("CSS");

        List<WebElement> mySelectedOptions = dropdown.getAllSelectedOptions();

        for(WebElement selectedOption: mySelectedOptions){
            Assert.assertTrue(selectedOption.getText().equals("Java") ||
                    selectedOption.getText().equals("Oracle"));
        }



    }

}