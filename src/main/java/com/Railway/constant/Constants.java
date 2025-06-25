package com.Railway.constant;

public class Constants {
    public static final String BASE_URL = "http://saferailway.somee.com/";
    // Test Data Constants
    public static class accountData{
        public static final String VALID_USERNAME = "nhatanhkof@gmail.com";
        public static final String VALID_PASSWORD = "123456789";
        public static final String VALID_PID = "123324234";

        public static final String NULL_USERNAME = "";
        public static final String NULL_PASSWORD = "";
        public static final String NULL_CONFIRM_PASSWORD = "";
        public static final String NULL_PID = "";

        public static final String INVALID_USERNAME = "nhatanhka@gmail.com";
        public static final String INVALID_PASSWORD = "12345ss6789";
        public static final String INVALID_CONFIRM_PASSWORD = "123324234";

        public static final String UNACTIVE_EMAIL = "nhatanh221@gmail.com";

        public static  String VALID_REGISTERING_EMAIL = "testuser_" + System.currentTimeMillis() + "@example.com";
        public static  String VALID_REGISTERING_PASSWORD = "Pass_" + System.nanoTime();
        public static  String VALID_REGISTERING_PID = "123456789";

    }

    public static class dateTimeFormat{
        public static final String HH_MM_SS = "HH:mm:ss";
        public static final String DD_MM_YYYY = "dd/MM/yyyy";
    }


    public static class pageName{
        public static final String HOME_PAGE = "Home";
        public static final String LOGIN_PAGE = "Login";
        public static final String REGISTER_PAGE = "Register";
        public static final String BOOK_TICKET_PAGE = "Book ticket";
        public static final String MY_TICKET_PAGE = "My ticket";
        public static final String CHANGE_PASSWORD_PAGE = "Change password";
        public static final String FAQ_PAGE = "FAQ";
        public static final String CONTACT_PAGE = "Contact";
        public static final String TIMETABLE_PAGE = "Timetable";
        public static final String TICKET_PRICE_PAGE= "Ticket price";
        public static final String LOGOUT = "Log out";
    }


    public static class pageHeading{
        public static final String HOME_PAGE = "Welcome to Safe Railway";
        public static final String LOGIN_PAGE = "Login page";
        public static final String REGISTER_PAGE = "Create account";
        public static final String BOOK_TICKET_PAGE = "Book ticket";
        public static final String MY_TICKET_PAGE = "Manage ticket";
        public static final String CHANGE_PASSWORD_PAGE = "Change password";
        public static final String FAQ_PAGE = "Frequently Asked Questions";
        public static final String CONTACT_PAGE = "Contact Information";
        public static final String TIMETABLE_PAGE = "Train Timetable";
        public static final String TICKET_PRICE_PAGE= "Train ticket price list";
    }


    public static class message{
        public static final String WELCOME_MESSAGE = "Welcome to Safe Railway";
        public static final String LOGIN_SUCCESS_MESSAGE = "Login Successfully";
        public static final String REGISTER_SUCCESS_MESSAGE = "Thank you for registering your account";
        public static final String CHANGE_PASSWORD_SUCCESS_MESSAGE = "Your password has been updated!";
    }


    public static class validationMessage{
        public static final String  INVALID_EMAIL_FORMAT= "Invalid email address";
        public static final String  INVALID_PASSWORD_FORMAT= "Invalid password length";
        public static final String  INVALID_PID_FORMAT= "Invalid PID";
        public static final String  PASSWORD_NOT_MATCH= "The two passwords do not match";

    }

    public static class errorMessage{
        public static final String LOGIN_INVALID_ACCOUNT_MESSAGE = "Invalid username or password. Please try again.";
        public static final String LOGIN_ERROR_MESSAGE = "There was a problem with your login and/or errors exist in your form.";
        public static final String LOGIN_FAIL_MULTIPLE_MESSAGE =  "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        public static final String CHANGE_PASSWORD_ERROR_MESSAGE = "There was a problem with your password change and/or errors exist in your form.";

        public static final String REGISTER_ERROR_MESSAGE = "There're errors in the form. Please correct the errors and try again.";

    }


}
