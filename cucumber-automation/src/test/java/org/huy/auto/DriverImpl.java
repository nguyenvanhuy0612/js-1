package org.huy.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

public class DriverImpl implements RemoteDriver {
    private Duration timeout = Duration.ofMillis(1500L);
    private Duration waitTime = Duration.ofSeconds(30L);
    private RemoteWebDriver driver;
    private DriverWait wait;

    public DriverImpl(RemoteWebDriver driver) {
        this.driver = Objects.requireNonNull(driver);
        this.driver.manage().timeouts().implicitlyWait(this.timeout);
        this.wait = new DriverWait(this.driver, this.timeout);
        this.wait.ignoring(WebDriverException.class);
    }

    @Override
    public RemoteWebDriver internalDriver() {
        return this.driver;
    }

    @Override
    public boolean elementExists(By by) {
        return this.wait.until(d -> by.findElements(d).size() != 0 ? "true" : "false").equals("true");
    }

    @Override
    public boolean elementExists(By by, double timeoutInSec) {
        return new DriverWait(this.driver, Duration.ofMillis((long) (timeoutInSec * 1000)))
                .ignoring(WebDriverException.class)
                .until(d -> by.findElements(d).size() != 0 ? "true" : "false").equals("true");
    }

    @Override
    public boolean waitFor(double timeoutInSec, Supplier<Boolean> condition) {
        return new DriverWait(this.driver, Duration.ofMillis((long) (timeoutInSec * 1000)))
                .ignoring(WebDriverException.class)
                .until(d -> condition.get() ? "true" : "false").equals("true");
    }

    @Override
    public void clickElement(By by) {
        this.wait.until(d -> {
            by.findElement(d).click();
            return "true";
        });
    }

    @Override
    public void clickElement(By by, double timeoutInSec) {
        new DriverWait(this.driver, Duration.ofMillis((long) (timeoutInSec * 1000)))
                .ignoring(WebDriverException.class)
                .until(d -> {
                    by.findElement(d).click();
                    return "true";
                });
    }

    @Override
    public void clickXpath(String xpath) {

    }

    @Override
    public void setField(By by, CharSequence... value) {
        this.wait.until(d -> {
            by.findElement(d).sendKeys(value);
            return "true";
        });
    }

    @Override
    public void scrollToElement(By by) {

    }

    @Override
    public Object executeScript(String script, Object... args) {
        return this.driver.executeScript(script, args);
    }

    @Override
    public Object executeAsyncScript(String script, Object... args) {
        return this.driver.executeAsyncScript(script, args);
    }

    @Override
    public void get(String url) {
        this.driver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return this.driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return this.driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return this.driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return this.driver.getPageSource();
    }

    @Override
    public void close() {
        this.driver.close();
    }

    @Override
    public void quit() {
        this.driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return this.driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return this.driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return this.driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return this.driver.navigate();
    }

    @Override
    public Options manage() {
        return this.driver.manage();
    }
}
