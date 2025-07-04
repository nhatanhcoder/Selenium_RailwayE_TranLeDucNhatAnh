package com.tests.Login;

import com.Railway.constant.Constants;
import com.Railway.dataObject.Enum.AccountEnum;
import com.Railway.pages.ChangePasswordPage;
import com.Railway.pages.LoginPage;
import com.Railway.pages.MyTicketPage;
import com.tests.Common.TestBase;
import com.Railway.utilities.LogUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends TestBase {

    @Test
    public void testAdditionalPagesAfterLogin() {
        LoginPage loginPage = new LoginPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        MyTicketPage myTicketPage = new MyTicketPage();

        String validUsername = Constants.accountData.VALID_USERNAME;
        String validPassword = Constants.accountData.VALID_PASSWORD;

        LogUtils.info("Step 1: Go to login page");
        loginPage.clickOnTab();

        LogUtils.info("Step 2: Login with valid credentials");
        // Login with valid credentials
        loginPage.login(AccountEnum.VALID_ACCOUNT);

        LogUtils.info("Step 3: Check 'My ticket', 'Change password', 'Logout' tabs");
        // "My ticket", "Change password" and "Logout" tabs are displayed.
        Assert.assertEquals(myTicketPage.getPageNameText(), Constants.pageName.MY_TICKET_PAGE);
        System.out.println(Constants.pageName.MY_TICKET_PAGE);
        Assert.assertEquals(changePasswordPage.getPageNameText(), Constants.pageName.CHANGE_PASSWORD_PAGE);
        System.out.println(Constants.pageName.CHANGE_PASSWORD_PAGE);
        Assert.assertEquals(loginPage.getPageNameText(Constants.pageName.LOGOUT), Constants.pageName.LOGOUT);
        System.out.println(Constants.pageName.LOGOUT);

        LogUtils.info("Step 4: Go to My Ticket page and check heading");
        // Verify user is directed to My ticket page
        myTicketPage.clickOnTab();
        String myTicketTitle = Constants.pageHeading.MY_TICKET_PAGE;
        Assert.assertEquals(myTicketPage.getPageHeadingText(), myTicketTitle);

        // Verify user is directed to the Change password page
        changePasswordPage.clickOnTab();
        String changePasswordTitle = Constants.pageName.CHANGE_PASSWORD_PAGE;
        Assert.assertEquals(changePasswordPage.getPageHeadingText(), changePasswordTitle);
    }
}



