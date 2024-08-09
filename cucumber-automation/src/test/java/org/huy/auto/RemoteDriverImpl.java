package org.huy.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import static org.huy.auto.Config.explicit;

public class RemoteDriverImpl implements RemoteDriver {
    private RemoteWebDriver driver;

    public RemoteDriverImpl(RemoteWebDriver driver) {
        this.driver = driver;
    }

    private String jsNodeXpath(String xpath) {
        return "document.evaluate(\"" + xpath.replace("\"", "'")
                + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue";
    }

    @Override
    public RemoteWebDriver internalDriver() {
        return driver;
    }

    @Override
    public boolean elementExists(By by) {
        return !by.findElements(driver).isEmpty();
    }

    @Override
    public boolean elementExists(By by, double timeoutInSec) {
        return false;
    }

    @Override
    public boolean waitFor(double timeoutInSec, Supplier<Boolean> condition) {
        return true;
    }

    @Override
    public void clickElement(By by) {
        String js = jsNodeXpath("");
        new WebDriverWait(driver, explicit)
                .ignoring(WebDriverException.class)
                .until(d -> {
                    ((JavascriptExecutor) d).executeScript("");
                    return true;
                });
    }

    @Override
    public void clickElement(By by, double timeoutInSec) {

    }

    @Override
    public void clickXpath(String xpath) {
        String js = jsNodeXpath(xpath);
        new WebDriverWait(driver, explicit)
                .ignoring(WebDriverException.class)
                .until(d -> {
                    driver.executeScript("%s.click()".formatted(js));
                    return true;
                });
    }

    @Override
    public void setField(By by, CharSequence... value) {
        new WebDriverWait(driver, explicit)
                .ignoring(WebDriverException.class)
                .until(d -> {
                    driver.findElement(by).sendKeys(value);
                    return true;
                });
    }

    @Override
    public void scrollToElement(By by) {

    }

    @Override
    public Object executeScript(String script, Object... args) {
        return driver.executeScript(script, args);
    }

    @Override
    public Object executeAsyncScript(String script, Object... args) {
        return null;
    }

    @Override
    public void get(String url) {
        driver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }
}
