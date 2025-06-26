package com.Railway.thirdPartyPage;

import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Set;

public class guerrillamailPage {

    private final By setMailBox = By.xpath("//span[@title='Click to Edit']");
    private final By setMailName = By.xpath("//div[@class='col2']//input[@type='text']");
    private final By setMailBoxButton = By.xpath("//button[@class='save button small']");
    private final By setMailDomain = By.id("gm-host-select");
    private final By mailLink = By.xpath("//div[@class='email_body']//a");
    private final By emailBodyLoaded = By.xpath("//div[@class='email_body']");

    private final String mailName = Constants.accountData.MAIL_SERVICE_NAME;
    private final String mailDomain = Constants.accountData.MAIL_SERVICE_DOMAIN;
    private final String email = "thanhletraining03@gmail.com";

    private By newestMailLocator() {
        return By.xpath(String.format(
                "//tr[contains(@class, 'mail_row') and contains(., '%s') and contains(., 'Please reset your password')]",
                email
        ));
    }

    public static void openMailBox() {
        DriverManager.getDriver().get("https://www.guerrillamail.com/");
    }

    public static void closeMailBox() {
        DriverManager.quitDriver();
    }

    public void clickSetMailBox() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(setMailBox)).click();
    }

    public void inputMailName() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(setMailName));
        nameField.clear();
        nameField.sendKeys(mailName);
    }

    public void submitSetMailButton() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(setMailBoxButton)).click();
    }

    public void selectMailDomain() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        WebElement domain = wait.until(ExpectedConditions.presenceOfElementLocated(setMailDomain));
        new Select(domain).selectByValue(mailDomain);
    }

    public WebElement findNewestMailFromSender() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.presenceOfElementLocated(newestMailLocator()));
    }

    public void clickNewestMail() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));

        // Đợi 11 giây để email mới load vào danh sách
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Tìm và click email
        WebElement emailRow = wait.until(ExpectedConditions.elementToBeClickable(newestMailLocator()));
        emailRow.click();

        // Đợi nội dung email hiển thị đầy đủ
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailBodyLoaded));
    }


    public void clickMailLinkAndWaitForNavigation() {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        String originalWindow = driver.getWindowHandle();
        Set<String> existingWindows = driver.getWindowHandles();

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(mailLink));
        link.click();

        wait.until(driver1 -> driver1.getWindowHandles().size() > existingWindows.size());

        Set<String> allWindows = driver.getWindowHandles();
        allWindows.removeAll(existingWindows);
        String newWindow = allWindows.iterator().next();

        driver.switchTo().window(newWindow);

        wait.until(ExpectedConditions.urlContains("reset"));
    }

    public void setupMailAndSelectEmailAndClickLink() {
        clickSetMailBox();
        inputMailName();
        submitSetMailButton();
        selectMailDomain();
        clickNewestMail();
        clickMailLinkAndWaitForNavigation();
    }
}