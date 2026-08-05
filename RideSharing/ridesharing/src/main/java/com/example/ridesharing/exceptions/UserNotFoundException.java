package com.example.ridesharing.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String userId)
    {
        super("No Such User Found with Id: " + userId);
    }
}
