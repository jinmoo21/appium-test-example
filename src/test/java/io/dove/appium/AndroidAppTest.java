package io.dove.appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Slf4j
@ExtendWith(TestWatcherLogger.class)
public class AndroidAppTest extends TestLifeCycleLogger {
    AndroidDriver driver;

    @BeforeAll
    void setUp() throws MalformedURLException {
        DeviceInfo device = DeviceInfo.NOTE20_11;
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid(device.getUdid())
                .setDeviceName(device.getDeviceName())
                .setPlatformVersion(device.getPlatformVersion())
                .setAppPackage("com.nhn.android.search")
                .setAppActivity(".ui.pages.SearchHomePage");
        driver = new AndroidDriver(new URL(device.getUrl()), options);
    }

    @AfterAll
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeEach
    void init() {

    }

    @Test
    void test01() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.Toast[1]"));
        assertThat(element.getText(), equalTo("'뒤로'버튼 한번 더 누르시면 종료됩니다."));
    }
}
