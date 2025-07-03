    package com.Railway.WrapElement;

    import com.Railway.driver.DriverManager;
    import org.openqa.selenium.*;
    import org.openqa.selenium.remote.RemoteWebElement;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.FluentWait;
    import org.openqa.selenium.support.ui.Select;
    import org.openqa.selenium.support.ui.Wait;

    import javax.lang.model.element.Element;
    import java.sql.SQLOutput;
    import java.time.Duration;
    import java.util.function.Function;

    public class ElementWrapper {
        private static final int DEFAULT_TIMEOUT = 10;
        private static final int DEFAULT_POLLING = 300;

        // ===== Fluent wait cho element hiển thị =====
        public static WebElement fluentWaitForElement(By locator) {
            FluentWait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver())
                    .withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .pollingEvery(Duration.ofMillis(DEFAULT_POLLING))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(ElementNotInteractableException.class);

            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            } catch (TimeoutException e) {
                System.err.println("❌ Timed out waiting for element: " + locator);
                throw e;
            }
        }

        // ===== Scroll element vào giữa màn hình =====
        public static void scrollToElement(WebElement element) {
            ((JavascriptExecutor) DriverManager.getDriver())
                    .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        }

        // ===== Send keys vào input =====
        public static void sendKeyElement(By locator, CharSequence... keys) {
            WebElement element = fluentWaitForElement(locator);
            scrollToElement(element);
            element.clear();
            element.sendKeys(keys);
        }

        // ===== Click vào element =====
        public static void clickElement(By locator) {
            WebElement element = fluentWaitForElement(locator);
            scrollToElement(element);
            element.click();
        }

        // ===== Chọn dropdown theo visible text =====
        public static void selectDropdownByText(By locator, String text) {
            WebElement dropdown = fluentWaitForElement(locator);
            scrollToElement(dropdown);
            new Select(dropdown).selectByVisibleText(text);
        }

        // ===== Chọn dropdown theo value =====
        public static void selectDropdownByValue(By locator, String value) {
            WebElement dropdown = fluentWaitForElement(locator);
            scrollToElement(dropdown);
            new Select(dropdown).selectByValue(value);
        }

        // ===== Lấy text từ element =====
        public static String getElementText(By locator) {
            WebElement element = fluentWaitForElement(locator);
            scrollToElement(element);
            return element.getText().trim();
        }

        // ===== Kiểm tra element có hiển thị không =====
        public static boolean isElementDisplayed(By locator) {
            try {
                return fluentWaitForElement(locator).isDisplayed();
            } catch (Exception e) {
                return false;
            }
        }

        // ===== Trả về WebElement nếu cần thao tác thêm =====
        public static WebElement getElement(By locator) {
            return fluentWaitForElement(locator);
        }
        // ===== Wait for dynamic dropdown to contain expected option =====
        public static void fluentWaitForDynamicElement(By elementBy , String oldID) {
            Wait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver())
                    .withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .pollingEvery(Duration.ofMillis(DEFAULT_POLLING))
                    .ignoring(TimeoutException.class)
                    .ignoring(NoSuchElementException.class)
                    .ignoring(ElementNotInteractableException.class);

            try {
                wait.until(d->{
                    RemoteWebElement element = (RemoteWebElement) d.findElement(elementBy);
                    String newElementID = element.getId();
                    System.out.println("old element id: " + oldID + "\n"+ " new element id: " + newElementID);
                    return !newElementID.equals(oldID);
                });
            }catch (TimeoutException e){
                System.out.println("Time out");
            }
        }

    }
