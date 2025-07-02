package com.Railway.constant;

public class Constants {
    public static final String BASE_URL = "http://saferailway.somee.com/";
    public static final String DATA_FILE_PATH = "src/main/java/com/Railway/dataObject/data.json";

    // Test Data Constants
    public static class accountData{
        //Login page
        public static final String VALID_USERNAME = "nhatanhkof@gmail.com";
        public static final String VALID_PASSWORD = "Password ";
        public static final String VALID_PID = "123324234";
        //Register page
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

        public static  String MAIL_SERVICE_NAME = "bachanngulam";
        public static  String MAIL_SERVICE_DOMAIN = "grr.la";
        public static  String NEW_PASSWORD = "bachanngulam";

    }

    public static class dateTimeFormat{
        public static final String HH_MM_SS = "HH:mm:ss";
        public static final String DD_MM_YYYY = "dd/MM/yyyy";
        public static final String YYYY_MM_DD_HH_MM_SS = "yyyy/MM/dd HH:mm:ss";
        //bookticket page
        public static final String M_DD_YYYY = "M/dd/yyyy";


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

        public static final String RESET_PASSWORD_SUCCESSFULLY = "Your password has been reset successfully. Please check your email for the new password.";
        //Book ticket
        public static final String BOOK_SUCCESSFULLY_MESSAGE = "Ticket booked successfully!";
    }


    public static class validationMessage{
        public static final String  INVALID_EMAIL_FORMAT= "Invalid email address";
        public static final String  INVALID_PASSWORD_FORMAT= "Invalid password length";
        public static final String  INVALID_PID_FORMAT= "Invalid PID";
        public static final String  PASSWORD_NOT_MATCH= "The two passwords do not match";

        public static final String  RESET_NEW_PASS_BLANK= "Please enter a new password.";
        public static final String  RESET_CONFIRM_NOTMATCH= "The password confirmation did not match the new password.";
        public static final String  RESET_TOKEN_INVALID= "The password reset token is invalid.";

    }

    public static class errorMessage{
        public static final String LOGIN_INVALID_ACCOUNT_MESSAGE = "Invalid username or password. Please try again.";
        public static final String LOGIN_ERROR_MESSAGE = "There was a problem with your login and/or errors exist in your form.";
        public static final String LOGIN_FAIL_MULTIPLE_MESSAGE =  "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        public static final String CHANGE_PASSWORD_ERROR_MESSAGE = "There was a problem with your password change and/or errors exist in your form.";

        public static final String REGISTER_ERROR_MESSAGE = "There're errors in the form. Please correct the errors and try again.";

        public static final String RESET_PASS_ERROR_MESSAGE= "Could not reset password. Please correct the errors and try again.";
        public static final String RESET_PASS_ERROR_TOKEN_MESSAGE= "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new";
    }

    public static class pageUrr{

    }

    public static class Button{

    }

    public static class TextBox{
        public static final String USERNAME_TEXTBOX = "Username";
        public static final String PASSWORD_TEXTBOX = "Password";

        public static final String REGISTERING_EMAIL_TEXTBOX = "Email";
        public static final String REGISTERING_PASSWORD_TEXTBOX = "Password";
        public static final String REGISTERING_CONFIRM_PASSWORD_TEXTBOX = "<PASSWORD>";
        public static final String REGISTERING_PID_TEXTBOX = "PID";

        public static final String FORGOT_PASSWORD = "<PASSWORD>";
    }

    public static class selectBoxName{
        //Book ticket page
        public static final String DEPART_DATE="Date";
        public static final String DEPART_STATION = "DepartStation";
        public static final String ARRIVE_STATION = "ArriveStation";
        public static final String SEAT_TYPE = "SeatType";
        public static final String TICKET_AMOUNT = "TicketAmount";
    }

    public static class ticketTableHeading{
        public static final String DEPART_STATION = "Depart Station";
        public static final String ARRIVE_STATION = "Arrive Station";
        public static final String SEAT_TYPE = "Seat Type";
        public static final String DEPART_DATE = "Depart Date";
        public static final String BOOK_DATE = "Book Date	";
        public static final String EXPIRED_DATE = "Expired Date";
        public static final String AMOUNT = "Amount";
        public static final String TOTAL = "Total";
    }
    public static class ticketData{
        public static class ticketDataTC14{
            public static final String DEPART_STATION = "Nha Trang";
            public static final String ARRIVE_STATION = "Đà Nẵng";
            public static final String DEPART_DATE = "7/16/2025";
            public static final String SEAT_TYPE = "Soft seat with air conditioner";
            public static final String TICKET_AMOUNT = "1";
        }
        public static class ticketData16{
            public static final String DEPART_STATION = "Đà Nẵng";
            public static final String ARRIVE_STATION = "Sài Gòn";
            public static final String DEPART_DATE = "7/2/2025";
            public static final String SEAT_TYPE = "Soft bed";
            public static final String TICKET_AMOUNT = "1";
        }
        public static class ticketDataTC15{
            public static final String DEPART_STATION = "Huế";
            public static final String ARRIVE_STATION = "Sài Gòn";
            public static final String DEPART_DATE = "7/19/2025";
            public static final String SEAT_TYPE = "Soft seat with air conditioner";
            public static final String TICKET_AMOUNT = "1";
        }
    }

    public static class screenshot{
        public static final String SCREENSHOT_PATH = "Result/screenshots";
        public static final String LOG_PATH = "Result/logs";
        public static final String REPORT_PATH = "Result/reports";
    }
    public static class EmailSlurp{
        public static final String MAIL_NAME ="qzLUhcCXdDm5";
        public static final String SLURP_DOMAIN ="@mailslurp.biz";
    }

}
