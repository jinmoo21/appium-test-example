package io.dove.appium;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
@ExtendWith(TestWatcherLogger.class)
public class IOSAppTest extends TestLifeCycleLogger {
    IOSDriver driver;

    @BeforeAll
    void setUp() throws MalformedURLException {
        DeviceInfo device = DeviceInfo.IPHONE8_14;
        XCUITestOptions options = new XCUITestOptions()
                .setUdid(device.getUdid())
                .setDeviceName(device.getDeviceName())
                .setPlatformVersion(device.getPlatformVersion())
                .setBundleId("com.nhncorp.NaverSearch");
        driver = new IOSDriver(new URL(device.getUrl()), options);
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

    }
}
