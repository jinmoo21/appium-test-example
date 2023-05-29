package io.dove.appium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

@Slf4j
public class TestWatcherLogger implements TestWatcher {
    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        log.warn("Test aborted [{}]", context.getDisplayName());
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        log.warn("Test disabled [{}]", context.getDisplayName());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        log.error("Test failed [{}]", context.getDisplayName());
/*
        File scrFile = ((TakesScreenshot) DriverFactory.get()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("screenshot/" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ").format(new Date()) + context.getDisplayName() + ".png"));
        } catch (IOException e) {
            log.error("Failed test screen capture failed");
        }
*/
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        log.info("Test successful [{}]", context.getDisplayName());
    }
}