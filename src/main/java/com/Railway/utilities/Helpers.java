package com.Railway.utilities;

import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helpers {

    public static void scrollToElement(WebElement element){
        new Actions(DriverManager.getDriver())
                .scrollByAmount(0, element.getRect().y)
                .perform();
    }

    public static String extractLinkFromEmailBody(String emailBody) {
        String regex = "href\\s*=\\s*\"([^\"]+)\""; // Bắt nội dung trong dấu ngoặc kép
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(emailBody);

        if (matcher.find()) {
            return matcher.group(1); // Trả về link nằm trong href=""
        }
        return null; // Không tìm thấy
    }
    public static String EmailForRegister() {
        // Tạo chuỗi ngẫu nhiên 4 ký tự
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomStr = new StringBuilder();
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < 4; i++) {
            randomStr.append(chars.charAt(random.nextInt(chars.length())));
        }

        // Tạo email dạng: tên+random4kýtự@domain
        String subStringMail = "+" + randomStr;
        String Mail = Constants.accountData.MAIL_SERVICE_NAME + subStringMail + Constants.accountData.MAIL_SERVICE_DOMAIN;

        return Mail;
    }
}