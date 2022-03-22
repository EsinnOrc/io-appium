import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class test {
    public static AppiumDriver<MobileElement>driver;
    public static DesiredCapabilities cap;


    @BeforeMethod
    public void before()  throws  MalformedURLException, InterruptedException{
        cap = new DesiredCapabilities();


        cap.setCapability( "platformName", "Android");
        cap.setCapability( "deviceName", "emulator-5554");
        cap.setCapability( "appPackage", "com.android.dialer");
        cap.setCapability( "appActivity","com.android.dialer.main.impl.MainActivity");

//        cap.setCapability( "platformName", "Android");
//        cap.setCapability( "deviceName", "emulator-5554");
//        cap.setCapability( "appPackage", "com.google.android.calendar");
//        cap.setCapability( "appActivity","com.android.calendar.AllInOneActivity");

        driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),cap);
        Thread.sleep(2000);



    }


    @Test
    public void test()throws InterruptedException{
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]")).click();
        List<MobileElement> contacts = driver.findElements(By.id("com.android.dialer:id/contact_name"));
        contacts.get(0).click();
        Thread.sleep(200);

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[1]")).sendKeys("bbahar");
        Thread.sleep(500);

        driver.findElement(By.id("com.android.contacts:id/editor_menu_save_button")).click();
        Thread.sleep(500);

        System.out.println("Basarili");
    }


    @Test
    public void test2() throws InterruptedException{
        driver.findElement(By.id("com.google.android.calendar:id/right_arrow")).click();

        Thread.sleep(500);

        driver.findElement(By.id("com.google.android.calendar:id/right_arrow")).click();

        Thread.sleep(500);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(550, 1576)).perform();

        Thread.sleep(500);
        touchAction.tap(new PointOption().withCoordinates(960, 1676)).perform();
        Thread.sleep(500);

        touchAction.tap(new PointOption().withCoordinates(939, 1692)).perform();
        Thread.sleep(500);
        driver.findElement(By.id("com.google.android.calendar:id/title_edit_text")).sendKeys("Sunum Günü");
        Thread.sleep(500);

        touchAction.tap(new PointOption().withCoordinates(975, 141)).perform();

        System.out.println("Takvime eklendi");

    }



    @AfterMethod
    public void afteer(){



    }
}
