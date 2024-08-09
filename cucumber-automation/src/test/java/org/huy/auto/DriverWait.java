package org.huy.auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Clock;
import java.time.Duration;
import java.util.function.Function;

public class DriverWait extends WebDriverWait {
    public DriverWait(WebDriver driver, Duration timeout) {
        super(driver, timeout);
    }

    public DriverWait(WebDriver driver, Duration timeout, Duration sleep) {
        super(driver, timeout, sleep);
    }

    public DriverWait(WebDriver driver, Duration timeout, Duration sleep, Clock clock, Sleeper sleeper) {
        super(driver, timeout, sleep, clock, sleeper);
    }

    @Override
    public <V> V until(Function<? super WebDriver, V> isTrue) {
        try {
            return super.until(isTrue);
        } catch (Throwable e) {
            return null;
        }
    }
}
