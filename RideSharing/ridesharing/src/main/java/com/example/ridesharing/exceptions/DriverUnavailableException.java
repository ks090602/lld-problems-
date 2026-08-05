package com.example.ridesharing.exceptions;

public class DriverUnavailableException extends RuntimeException{
    public DriverUnavailableException()
    {
        super("No Driver Available at your pickup location, Sorry Please try agaian after some time");
    }
}
