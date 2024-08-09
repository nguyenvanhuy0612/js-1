package org.huy.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.function.Supplier;

public interface RemoteDriver2 extends WebDriver, JavascriptExecutor {
    default RemoteWebDriver internalDriver() {
        return null;
    }

    default boolean elementExists(By by) {
        return false;
    }

    boolean elementExists(By by, double timeoutInSec);
    boolean waitFor(double timeoutInSec, Supplier<Boolean> condition);
    void clickElement(By by);
    void clickElement(By by, double timeoutInSec);
    void clickXpath(String xpath);
    void setField(By by, CharSequence... value);
    void scrollToElement(By by);
}
