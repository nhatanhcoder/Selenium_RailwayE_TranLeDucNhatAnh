package com.Railway.utilities;

import com.Railway.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Helpers {

    public static void scrollToElement(WebElement element){
        new Actions(DriverManager.getDriver())
                .scrollByAmount(0, element.getRect().y)
                .perform();
    }

    /**
     * Waits until the number of elements matching the xpath changes from the old list's size.
     * Useful for waiting until dynamic content loads or changes.
     *
     * @param duration      Timeout in seconds.
     * @param elementXpath  Xpath of the element(s) to watch for change.
     * @param oldList       The previous list of elements (can be empty but not null).
     */
    public static void waitForDynamicElement(int duration, String elementXpath, List<WebElement> oldList) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(duration));
        wait.ignoring(Exception.class).until(driver -> {
            try {
                List<WebElement> newList = DriverManager.getDriver().findElements(By.xpath(elementXpath));
                return !newList.equals(oldList);
            } catch (Exception ex) {
                return false;
            }
        });
    }
}