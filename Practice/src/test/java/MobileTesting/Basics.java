package MobileTesting;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Visibility;
import java.net.MalformedURLException;

public class Basics extends BaseMobileTesting{

        public static void main(String[] args) throws MalformedURLException, InterruptedException {

       AndroidDriver<AndroidElement> driverAndroid = BaseMobileTesting.Capabilites();

      AndroidElement preferenceButton = driverAndroid.findElement(By.xpath("//android.widget.TextView[@text='Preference']"));
        preferenceButton.click();
       //xpath, id, class name, androidUIautomator
        // tagName[@id='hello']

        AndroidElement preference = driverAndroid.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']"));
        WebDriverWait wait = new WebDriverWait(driverAndroid, 5);
        wait.until(ExpectedConditions.visibilityOf(preference));
        preference.click();
        AndroidElement wifiCheckBox = driverAndroid.findElement(By.id("android:id/checkbox"));
        wifiCheckBox.click();
           // driverAndroid.rotate(ScreenOrientation.LANDSCAPE);
            DeviceRotation deviceRotation = new DeviceRotation(90,90,90);
            driverAndroid.rotate(deviceRotation);

        AndroidElement wifiSettings = driverAndroid.findElement(By.xpath("(//android.widget.RelativeLayout)[2]"));
        wifiSettings.click();
        Thread.sleep(1000);
        AndroidElement wifiSettingsInputBox = driverAndroid.findElement(By.id("android:id/edit"));
        wifiSettingsInputBox.sendKeys("Hello World");

        AndroidElement okButton = driverAndroid.findElement(By.id("android:id/button1"));
        okButton.click();

        driverAndroid.pressKey(new KeyEvent(AndroidKey.HOME));

            Thread.sleep(4000);



    }
}
