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
    public static void waitForDynamicElement(int duration, String elementXpath, List<WebElement> oldList) {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(duration)).ignoring(Exception.class);

        wait.until(d -> {
            List<WebElement> newList = DriverManager.getDriver().findElements(By.xpath(elementXpath));
            return !newList.equals(oldList);
        });
    }
}
