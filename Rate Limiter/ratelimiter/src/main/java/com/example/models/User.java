package com.example.models;

import com.example.enums.UserTier;

public class User {
    private static int initialID = 1;

    private int user_id;
    private String userName;
    private UserTier userTier;

    public User(String userName,UserTier userTier){
        user_id = initialID++;
        this.userName = userName;
        this.userTier = userTier;
    }

    public int getUserId(){
        return user_id;
    }
    public String getUserName(){
        return userName;
    }
    public UserTier getUserTier(){
        return userTier;
    }
    
    public void setUserName(String newName){
        userName = newName;
    }
    public void setUserTier(UserTier newTier)
    {
        userTier = newTier;
    }
}
