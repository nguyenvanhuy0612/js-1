package org.huy.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test {
    public static void main(String[] args) {
        RemoteDriver driver = new DriverImpl(new ChromeDriver());

        driver.get("https://the-internet.herokuapp.com/");
        driver.get("https://the-internet.herokuapp.com/context_menu");

        driver.executeScript("return document.getElementById('hot-spot')");

        WebElement element = (WebElement) driver.executeScript("return document.querySelector('.example')");

        System.out.println("element = " + element.getText());

        driver.findElements(By.xpath("//html"));

        driver.findElements(By.xpath("//html"));


        driver.quit();
    }
}
