package com.local.project.data;

/**
 * Description:
 */
public class UserInfo {

    private String username;
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    private UserInfo() {

    }

    private static class UserInfoInstance {
        private static final UserInfo INSTANCE = new UserInfo();
    }

    public static UserInfo getInstance() {
        return UserInfoInstance.INSTANCE;
    }

}
