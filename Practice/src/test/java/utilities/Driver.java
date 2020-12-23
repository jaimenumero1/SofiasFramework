package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    //controller class for our driver
    //the goal is to make sure that there is a SINGLE driver instance running
    //SINGLETON pattern - this means creating a class that ensures that ONLY ONE instance of
    // the object can exist at a time

    private Driver(){} //--> will not allow anyone to create a driver object directly

    private static WebDriver driver;

    //1st method - creating a driver depending on the browser specified in config.properties

    public static WebDriver getDriver(){

        if(driver == null){
            //we will create a new driver instance here and assing it to our driver variable

            switch(ConfigsReader.getProperty("browser").toLowerCase()){
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver(Boolean.parseBoolean(ConfigsReader.getProperty("headless")));
                    break;
                case "firefox":
                    driver = FirefoxWebDriver.loadFirefoxDriver(Boolean.parseBoolean(ConfigsReader.getProperty("headless")));
                    break;
                case "safari":
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
                    break;
                    default:
                        driver = ChromeWebDriver.loadChromeDriver(Boolean.parseBoolean(ConfigsReader.getProperty("headless")));
                        break;
            }
        }
        return driver;
    }

    //2nd method - will close the driver if it is running

    public static void closeDriver(){
        if(driver == null) return;
        try{
            driver.close();
            driver.quit();
            driver = null;
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
