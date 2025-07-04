package com.Railway.dataObject.Enum;

public enum AccountEnum {

    VALID_ACCOUNT("nhatanhkof@gmail.com", "Password "),
    INVALID_ACCOUNT("nhatanhkofs@gmail.com", "Password"),
    NULL_USERNAME_ACCOUNT("","hanhsss");

    private final String username;
    private final String password;

    AccountEnum(String username, String password){
        this.username = username;
        this.password = password;
    }

    /**
     * Returns the username of this account.
     * @return the username
     */
    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }
}
