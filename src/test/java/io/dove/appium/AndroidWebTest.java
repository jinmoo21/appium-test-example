package io.dove.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

@Slf4j
@ExtendWith(TestWatcherLogger.class)
public class AndroidWebTest extends TestLifeCycleLogger {
    WebDriver driver;

    @BeforeAll
    void setUp() throws MalformedURLException {
        DeviceInfo device = DeviceInfo.NOTE20_11;
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid(device.getUdid())
                .setDeviceName(device.getDeviceName())
                .setPlatformVersion(device.getPlatformVersion())
                .withBrowserName("chrome");
        driver = new EventFiringDecorator<AndroidDriver>(new WebDriverListenerLogger())
                .decorate(new AndroidDriver(new URL(device.getUrl()), options));
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
        driver.get("https://google.com");
        assertThat(driver.getCurrentUrl(), startsWith("https://www.google.com"));
    }

    @Test
    void test02() {
        driver.get("https://naver.com");
        assertThat(driver.getCurrentUrl(), startsWith("https://m.naver.com"));
    }
}
