package com.transtu.tn.Request;

import com.transtu.tn.Entity.UserCredentials;

public class UserRegistration {
    private UserSave userSave;
    private UserCredentials credentials;

    public UserSave getUserSave() {
        return userSave;
    }

    public void setUserSave(UserSave userSave) {
        this.userSave = userSave;
    }

    public UserCredentials getCredentials() {
        return credentials;
    }

    public void setCredentials(UserCredentials credentials) {
        this.credentials = credentials;
    }
}