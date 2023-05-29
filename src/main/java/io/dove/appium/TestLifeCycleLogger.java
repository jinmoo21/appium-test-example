package io.dove.appium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestLifeCycleLogger {
    @BeforeAll
    public void beforeAllTests() {
        log.info("Before all tests");
    }

    @AfterAll
    public void afterAllTests() {
        log.info("After all tests");
    }

    @BeforeEach
    public void beforeEachTest(TestInfo testInfo) {
        log.info("About to execute [{}]", testInfo.getDisplayName());
    }

    @AfterEach
    public void afterEachTest(TestInfo testInfo) {
        log.info("Finished executing [{}]", testInfo.getDisplayName());
    }
}