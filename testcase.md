TC ID: TC01
TC Description: User can log into Railway with valid username and password
Steps:
1. Navigate to QA Railway Website
2. Click on "Login" tab
3. Enter valid Email and Password
4. Click on "Login" button
Expected Behavior: User is logged into Railway. Welcome user message is displayed.

TC ID: TC02
TC Description: User can't login with blank "Username" textbox
Steps:
1. Navigate to QA Railway Website
2. Click on "Login" tab
3. User doesn't type any words into "Username" textbox but enter valid information into "Password" textbox
4. Click on "Login" button
Expected Behavior: User can't login and message "There was a problem with your login and/or errors exist in your form." appears.

TC ID: TC03
TC Description: User cannot log into Railway with invalid password
Steps:
1. Navigate to QA Railway Website
2. Click on "Login" tab
3. Enter valid Email and invalid Password
4. Click on "Login" button
Expected Behavior: Error message "There was a problem with your login and/or errors exist in your form." is displayed.

TC ID: TC04
TC Description: Login page displays when un-logged User clicks on "Book ticket" tab
Steps:
1. Navigate to QA Railway Website
2. Click on "Book ticket" tab
Expected Behavior: Login page displays instead of Book ticket page.

TC ID: TC05
TC Description: System shows message when user enters wrong password several times
Steps:
1. Navigate to QA Railway Website
2. Click on "Login" tab
3. Enter valid information into "Username" textbox except "Password" textbox
4. Click on "Login" button
5. Repeat step 3 three more times
Expected Behavior: User can't login and message "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes." appears.

TC ID: TC06
TC Description: Additional pages display once user logged in
Steps:
1. Navigate to QA Railway Website
2. Click on "Login" tab
3. Login with valid account
Expected Behavior: "My ticket", "Change password" and "Logout" tabs are displayed.
Click "My ticket" tab, user will be directed to My ticket page.
Click "Change password" tab, user will be directed to Change password page.

TC ID: TC07
TC Description: User can create new account
Steps:
1. Navigate to QA Railway Website
2. Click on "Register" tab
3. Enter valid information into all fields
4. Click on "Register" button
Expected Behavior: New account is created and message "Thank you for registering your account" appears.

TC ID: TC08
TC Description: User can't login with an account hasn't been activated
Pre-condition: Create a new account but do not activate it
Steps:
1. Navigate to QA Railway Website
2. Click on "Login" tab
3. Enter username and password of account hasn't been activated
4. Click on "Login" button
Expected Behavior: User can't login and message "Invalid username or password. Please try again." appears.

TC ID: TC09
TC Description: User can change password
Pre-condition: Create and activate a new account
Steps:
1. Navigate to QA Railway Website
2. Login with valid account
3. Click on "Change Password" tab
4. Enter valid value into all fields
5. Click on "Change Password" button
Expected Behavior: Message "Your password has been updated!" appears.

TC ID: TC10
TC Description: User can't create account with "Confirm password" is not the same with "Password"
Steps:
1. Navigate to QA Railway Website
2. Click on "Register" tab
3. Enter valid information into all fields except "Confirm password" is not the same with "Password"
4. Click on "Register" button
Expected Behavior: Message "There're errors in the form. Please correct the errors and try again." appears.

TC ID: TC11
TC Description: User can't create account while password and PID fields are empty
Steps:
1. Navigate to QA Railway Website
2. Click on "Register" tab
3. Enter valid email address and leave other fields empty
4. Click on "Register" button
Expected Behavior: Message "There're errors in the form. Please correct the errors and try again." appears above the form.
Next to password fields, error message "Invalid password length." displays.
Next to PID field, error message "Invalid ID length." displays.

TC ID: TC12
TC Description: Errors display when password reset token is blank
Pre-condition: Create and activate a new account
Steps:
1. Navigate to QA Railway Login page
2. Click on "Forgot Password page" link
3. Enter the email address of the created account in Pre-condition
4. Click on "Send Instructions" button
5. Open mailbox and click on reset password link
6. Enter new passwords and remove the Password Reset Token
7. Click "Reset Password" button
Expected Behavior: Error message "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one." displays above the form.
Error message "The password reset token is invalid." displays next to the "Password Reset Token" field.

TC ID: TC13
TC Description: Errors display if password and confirm password don't match when resetting password
Pre-condition: Create and activate a new account
Steps:
1. Navigate to QA Railway Login page
2. Click on "Forgot Password page" link
3. Enter the email address of the created account in Pre-condition
4. Click on "Send Instructions" button
5. Open mailbox and click on reset password link
6. Enter different values for password fields
7. Click "Reset Password" button
Expected Behavior: Error message "Could not reset password. Please correct the errors and try again." displays above the form.
Error message "The password confirmation did not match the new password." displays next to the confirm password field.

TC ID: TC14
TC Description: User can book 1 ticket at a time
Pre-condition: Create and activate a new account
Steps:
1. Navigate to QA Railway Website
2. Login with a valid account
3. Click on "Book ticket" tab
4. Select a "Depart date" from the list
5. Select "Sài Gòn" for "Depart from" and "Nha Trang" for "Arrive at"
6. Select "Soft bed with air conditioner" for "Seat type"
7. Select "1" for "Ticket amount"
8. Click on "Book ticket" button
Expected Behavior: Message "Ticket booked successfully!" displays. Ticket information display correctly (Depart Date, Depart Station, Arrive Station, Seat Type, Amount).

TC ID: TC15
TC Description: User can open "Book ticket" page by clicking on "Book ticket" link in "Train timetable" page
Pre-condition: Create and activate a new account
Steps:
1. Navigate to QA Railway Website
2. Login with a valid account
3. Click on "Timetable" tab
4. Click on "book ticket" link of the route from "Huế" to "Sài Gòn"
Expected Behavior: "Book ticket" page is loaded with correct "Depart from" and "Arrive at" values.

TC ID: TC16
TC Description: User can cancel a ticket
Pre-condition: Create and activate a new account
Steps:
1. Navigate to QA Railway Website
2. Login with a valid account
3. Book a ticket
4. Click on "My ticket" tab
5. Click on "Cancel" button of ticket which user want to cancel
6. Click on "OK" button on Confirmation message "Are you sure?"
Expected Behavior: The canceled ticket is disappeared.