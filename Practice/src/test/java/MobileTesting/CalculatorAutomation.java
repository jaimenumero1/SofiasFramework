package MobileTesting;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.text.DecimalFormat;


public class CalculatorAutomation {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        AndroidDriver<AndroidElement> driverAndroid = BaseMobileTesting.Capabilites();

        AndroidElement number9 = driverAndroid.findElementByAndroidUIAutomator("text(\"9\")");
        number9.click();
        AndroidElement number5 = driverAndroid.findElementByAndroidUIAutomator("text(\"5\")");
        number5.click();

        AndroidElement plusSign = driverAndroid.findElementByAndroidUIAutomator("text(\"+\")");
        plusSign.click();

        AndroidElement number2 = driverAndroid.findElementByAndroidUIAutomator("text(\"2\")");
        number2.click();

        AndroidElement number3 = driverAndroid.findElement(By.id("com.bng.calculator:id/btn_3"));
        number3.click();

        AndroidElement equalsSign = driverAndroid.findElement(By.xpath("//android.widget.Button[@text='=']"));
        equalsSign.click();

        AndroidElement clearButton = driverAndroid.findElement(By.id("com.bng.calculator:id/btn_clear"));
        clearButton.click();

        DeviceRotation deviceRotation = new DeviceRotation(90,90,90);
        driverAndroid.rotate(deviceRotation);
        Thread.sleep(1000);
        AndroidElement squareRootButton = driverAndroid.findElement(By.xpath("//android.widget.Button[@text='√']"));
        WebDriverWait wait = new WebDriverWait(driverAndroid,3);
        wait.until(ExpectedConditions.elementToBeClickable(squareRootButton)).click();

        AndroidElement history = driverAndroid.findElement(By.id("com.bng.calculator:id/historyImage"));
        history.click();
        AndroidElement sumHistoryOf118Button = driverAndroid.findElement(By.id("com.bng.calculator:id/resultV"));
        String sumOf118 = sumHistoryOf118Button.getText();
        System.out.println(sumOf118);
        sumHistoryOf118Button.click();

        AndroidElement equalsSign2 = driverAndroid.findElement(By.xpath("//android.widget.Button[@text='=']"));
        equalsSign2.click();
        driverAndroid.rotate(ScreenOrientation.PORTRAIT);
       AndroidElement multiplicationButton = driverAndroid.findElement(By.xpath("//android.widget.LinearLayout[2]/" +
               "android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[4]"));
        multiplicationButton.click();

        AndroidElement parenthesisButton = driverAndroid.findElement(By.xpath("//android.widget.LinearLayout[2]//" +
                "android.widget.LinearLayout[1]/android.widget.Button[2]"));
        parenthesisButton.click();

        AndroidElement minusButton = driverAndroid.findElement(By.xpath("//android.widget.LinearLayout[2]//" +
                "android.widget.LinearLayout[3]/android.widget.Button[4]"));
        minusButton.click();
        AndroidElement theNumberOne = driverAndroid.findElementByAndroidUIAutomator("text(\"1\")");
        theNumberOne.click();

        AndroidElement equalsSign3 = driverAndroid.findElement(By.xpath("//android.widget.Button[@text='=']"));
        equalsSign3.click();

        AndroidElement resultWindow = driverAndroid.findElement(By.id("com.bng.calculator:id/formula"));

        String  negativeResultOfCalculator = resultWindow.getText().trim();
        System.out.println(negativeResultOfCalculator + " This is negative result : " );


        MatcherAssert.assertThat(sumOf118, Matchers.is("=118"));
        String expectedResult = "−10.8627804912";

        MatcherAssert.assertThat("Failed Expected Result not there",expectedResult,Matchers.is(resultWindow.getText()));
        double requirementsExpectedResultRounded = -10.8628;

        for(int i = 0;i< negativeResultOfCalculator.length();i++){
            if(Character.isDigit(negativeResultOfCalculator.charAt(i)) || negativeResultOfCalculator.charAt(i)=='-'){
                System.out.println(i);
            }
            else {
                System.out.println(negativeResultOfCalculator.charAt(i));
            }
        }
        double newNumber = Double.parseDouble(negativeResultOfCalculator.substring(1,11));
        System.out.println(newNumber);

        DecimalFormat df = new DecimalFormat("##.####");
        df.setRoundingMode(RoundingMode.CEILING);
        newNumber = Double.parseDouble(df.format(newNumber));
       MatcherAssert.assertThat(newNumber*-1,Matchers.is(requirementsExpectedResultRounded));
       driverAndroid.pressKey(new KeyEvent(AndroidKey.HOME));


        driverAndroid.quit();

        double num = -10;
    }
}
