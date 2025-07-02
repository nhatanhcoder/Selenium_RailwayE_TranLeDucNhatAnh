package com.tests.Helper;

import com.Railway.constant.Constants;
import com.Railway.utilities.Helpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class MailHelper {

    private static final String BASE_URL = "https://api.mailslurp.com";
    private static final String API_KEY = "1471f84fd84afa435302cfbc49bd9a0484917ce1841218d6b26c59eb4bc9130d";
    private static RequestSpecification requestSpecification;

    private static RequestSpecification BaseApi() {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("x-api-key" , API_KEY)
                .header("accept", "*/*")
                .urlEncodingEnabled(true)
                .param("unReadOnly", false);
    }

    // ✅ 1. Lấy inboxId từ email address
    public static String getEmailID(String emaiTitle) {
        Response response ;
        do{
            requestSpecification = BaseApi().basePath("emails")
                    .param("page",0)
                    .param("size",20)
                    .param("sort","ASC")
                    .param("searchFilter",emaiTitle);
            response = requestSpecification.get();
        }while (response.jsonPath().getList("content.id").size()<=0);

        return response.jsonPath().getList("content.id").get(0).toString();
    }

    // ✅ 2. Lấy nội dung email mới nhất trong inbox
    public static String getEmailBodyByID(String emaiTitle) {
        String emailID = getEmailID(emaiTitle);
        requestSpecification = BaseApi().basePath("emails/" + emailID + "/body");
        Response response = requestSpecification.get();
        return response.getBody().print().toString();
    }

    public static void main(String[] args) {
        String emailBody = getEmailBodyByID("Please reset your password "+ "qzLUhcCXdDm5+13a@mailslurp.biz");
        System.out.println(Helpers.extractLinkFromEmailBody(emailBody));
    }

}
