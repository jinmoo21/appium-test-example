package io.dove.appium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

public abstract class BasePage<T> extends LoadableComponent<BasePage<T>> {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract String getUrl();

    @Override
    protected void load() {
        driver.get(getUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        assertThat(driver.getCurrentUrl(), startsWith(getUrl()));
    }
}