package utilities;

import org.openqa.selenium.WebDriver;


public class Driver {

    private Driver(){}

    private static WebDriver driver;



    public static WebDriver getDriver(){

        if(driver == null){


            String s = ConfigsReader.getProperty("browser").toLowerCase();
            if ("chrome".equals(s)) {
                driver = ChromeWebDriver.loadChromeDriver(Boolean.parseBoolean(ConfigsReader.getProperty("headless")));

            } else if ("firefox".equals(s)) {
                driver = FirefoxWebDriver.loadFirefoxDriver(Boolean.parseBoolean(ConfigsReader.getProperty("headless")));

            } else {
                driver = ChromeWebDriver.loadChromeDriver(Boolean.parseBoolean(ConfigsReader.getProperty("headless")));

            }
        }
        return driver;
    }


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
